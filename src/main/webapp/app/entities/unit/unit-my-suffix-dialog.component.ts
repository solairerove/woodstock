import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { EventManager, AlertService } from 'ng-jhipster';

import { UnitMySuffix } from './unit-my-suffix.model';
import { UnitMySuffixPopupService } from './unit-my-suffix-popup.service';
import { UnitMySuffixService } from './unit-my-suffix.service';

@Component({
    selector: 'jhi-unit-my-suffix-dialog',
    templateUrl: './unit-my-suffix-dialog.component.html'
})
export class UnitMySuffixDialogComponent implements OnInit {

    unit: UnitMySuffix;
    authorities: any[];
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: AlertService,
        private unitService: UnitMySuffixService,
        private eventManager: EventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.authorities = ['ROLE_USER', 'ROLE_ADMIN'];
    }
    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.unit.id !== undefined) {
            this.subscribeToSaveResponse(
                this.unitService.update(this.unit));
        } else {
            this.subscribeToSaveResponse(
                this.unitService.create(this.unit));
        }
    }

    private subscribeToSaveResponse(result: Observable<UnitMySuffix>) {
        result.subscribe((res: UnitMySuffix) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: UnitMySuffix) {
        this.eventManager.broadcast({ name: 'unitListModification', content: 'OK'});
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
}

@Component({
    selector: 'jhi-unit-my-suffix-popup',
    template: ''
})
export class UnitMySuffixPopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private unitPopupService: UnitMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.unitPopupService
                    .open(UnitMySuffixDialogComponent, params['id']);
            } else {
                this.modalRef = this.unitPopupService
                    .open(UnitMySuffixDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
