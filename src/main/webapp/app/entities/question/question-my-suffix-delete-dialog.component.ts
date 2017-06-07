import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { AlertService, EventManager } from 'ng-jhipster';

import { QuestionMySuffix } from './question-my-suffix.model';
import { QuestionMySuffixPopupService } from './question-my-suffix-popup.service';
import { QuestionMySuffixService } from './question-my-suffix.service';

@Component({
    selector: 'jhi-question-my-suffix-delete-dialog',
    templateUrl: './question-my-suffix-delete-dialog.component.html'
})
export class QuestionMySuffixDeleteDialogComponent {

    question: QuestionMySuffix;

    constructor(
        private questionService: QuestionMySuffixService,
        public activeModal: NgbActiveModal,
        private alertService: AlertService,
        private eventManager: EventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.questionService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'questionListModification',
                content: 'Deleted an question'
            });
            this.activeModal.dismiss(true);
        });
        this.alertService.success('woodstockApp.question.deleted', { param : id }, null);
    }
}

@Component({
    selector: 'jhi-question-my-suffix-delete-popup',
    template: ''
})
export class QuestionMySuffixDeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private questionPopupService: QuestionMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.questionPopupService
                .open(QuestionMySuffixDeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
