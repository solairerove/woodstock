import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { EventManager, AlertService } from 'ng-jhipster';

import { ModuleMySuffix } from './module-my-suffix.model';
import { ModuleMySuffixPopupService } from './module-my-suffix-popup.service';
import { ModuleMySuffixService } from './module-my-suffix.service';
import { UnitMySuffix, UnitMySuffixService } from '../unit';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-module-my-suffix-dialog',
    templateUrl: './module-my-suffix-dialog.component.html'
})
export class ModuleMySuffixDialogComponent implements OnInit {

    module: ModuleMySuffix;
    authorities: any[];
    isSaving: boolean;

    units: UnitMySuffix[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: AlertService,
        private moduleService: ModuleMySuffixService,
        private unitService: UnitMySuffixService,
        private eventManager: EventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.authorities = ['ROLE_USER', 'ROLE_ADMIN'];
        this.unitService.query()
            .subscribe((res: ResponseWrapper) => { this.units = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }
    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.module.id !== undefined) {
            this.subscribeToSaveResponse(
                this.moduleService.update(this.module), false);
        } else {
            this.subscribeToSaveResponse(
                this.moduleService.create(this.module), true);
        }
    }

    private subscribeToSaveResponse(result: Observable<ModuleMySuffix>, isCreated: boolean) {
        result.subscribe((res: ModuleMySuffix) =>
            this.onSaveSuccess(res, isCreated), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: ModuleMySuffix, isCreated: boolean) {
        this.alertService.success(
            isCreated ? 'woodstockApp.module.created'
            : 'woodstockApp.module.updated',
            { param : result.id }, null);

        this.eventManager.broadcast({ name: 'moduleListModification', content: 'OK'});
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

    trackUnitById(index: number, item: UnitMySuffix) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-module-my-suffix-popup',
    template: ''
})
export class ModuleMySuffixPopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private modulePopupService: ModuleMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.modulePopupService
                    .open(ModuleMySuffixDialogComponent, params['id']);
            } else {
                this.modalRef = this.modulePopupService
                    .open(ModuleMySuffixDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
