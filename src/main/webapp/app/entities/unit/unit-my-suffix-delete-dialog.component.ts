import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { AlertService, EventManager } from 'ng-jhipster';

import { UnitMySuffix } from './unit-my-suffix.model';
import { UnitMySuffixPopupService } from './unit-my-suffix-popup.service';
import { UnitMySuffixService } from './unit-my-suffix.service';

@Component({
    selector: 'jhi-unit-my-suffix-delete-dialog',
    templateUrl: './unit-my-suffix-delete-dialog.component.html'
})
export class UnitMySuffixDeleteDialogComponent {

    unit: UnitMySuffix;

    constructor(
        private unitService: UnitMySuffixService,
        public activeModal: NgbActiveModal,
        private alertService: AlertService,
        private eventManager: EventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.unitService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'unitListModification',
                content: 'Deleted an unit'
            });
            this.activeModal.dismiss(true);
        });
        this.alertService.success('woodstockApp.unit.deleted', { param : id }, null);
    }
}

@Component({
    selector: 'jhi-unit-my-suffix-delete-popup',
    template: ''
})
export class UnitMySuffixDeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private unitPopupService: UnitMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.unitPopupService
                .open(UnitMySuffixDeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
