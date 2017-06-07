import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { AlertService, EventManager } from 'ng-jhipster';

import { ReferenceMySuffix } from './reference-my-suffix.model';
import { ReferenceMySuffixPopupService } from './reference-my-suffix-popup.service';
import { ReferenceMySuffixService } from './reference-my-suffix.service';

@Component({
    selector: 'jhi-reference-my-suffix-delete-dialog',
    templateUrl: './reference-my-suffix-delete-dialog.component.html'
})
export class ReferenceMySuffixDeleteDialogComponent {

    reference: ReferenceMySuffix;

    constructor(
        private referenceService: ReferenceMySuffixService,
        public activeModal: NgbActiveModal,
        private alertService: AlertService,
        private eventManager: EventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.referenceService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'referenceListModification',
                content: 'Deleted an reference'
            });
            this.activeModal.dismiss(true);
        });
        this.alertService.success('woodstockApp.reference.deleted', { param : id }, null);
    }
}

@Component({
    selector: 'jhi-reference-my-suffix-delete-popup',
    template: ''
})
export class ReferenceMySuffixDeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private referencePopupService: ReferenceMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.referencePopupService
                .open(ReferenceMySuffixDeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
