import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { EventManager, AlertService } from 'ng-jhipster';

import { ReferenceMySuffix } from './reference-my-suffix.model';
import { ReferenceMySuffixPopupService } from './reference-my-suffix-popup.service';
import { ReferenceMySuffixService } from './reference-my-suffix.service';
import { ModuleMySuffix, ModuleMySuffixService } from '../module';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-reference-my-suffix-dialog',
    templateUrl: './reference-my-suffix-dialog.component.html'
})
export class ReferenceMySuffixDialogComponent implements OnInit {

    reference: ReferenceMySuffix;
    authorities: any[];
    isSaving: boolean;

    modules: ModuleMySuffix[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: AlertService,
        private referenceService: ReferenceMySuffixService,
        private moduleService: ModuleMySuffixService,
        private eventManager: EventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.authorities = ['ROLE_USER', 'ROLE_ADMIN'];
        this.moduleService.query()
            .subscribe((res: ResponseWrapper) => { this.modules = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }
    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.reference.id !== undefined) {
            this.subscribeToSaveResponse(
                this.referenceService.update(this.reference), false);
        } else {
            this.subscribeToSaveResponse(
                this.referenceService.create(this.reference), true);
        }
    }

    private subscribeToSaveResponse(result: Observable<ReferenceMySuffix>, isCreated: boolean) {
        result.subscribe((res: ReferenceMySuffix) =>
            this.onSaveSuccess(res, isCreated), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: ReferenceMySuffix, isCreated: boolean) {
        this.alertService.success(
            isCreated ? 'woodstockApp.reference.created'
            : 'woodstockApp.reference.updated',
            { param : result.id }, null);

        this.eventManager.broadcast({ name: 'referenceListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError(error) {
        try {
            error.json();
        } catch (exception) {
            error.message = error.text();
        }
        this.isSaving = false;
        this.onError(error);
    }

    private onError(error) {
        this.alertService.error(error.message, null, null);
    }

    trackModuleById(index: number, item: ModuleMySuffix) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-reference-my-suffix-popup',
    template: ''
})
export class ReferenceMySuffixPopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private referencePopupService: ReferenceMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.referencePopupService
                    .open(ReferenceMySuffixDialogComponent, params['id']);
            } else {
                this.modalRef = this.referencePopupService
                    .open(ReferenceMySuffixDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
