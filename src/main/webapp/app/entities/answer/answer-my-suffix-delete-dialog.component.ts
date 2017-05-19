import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { EventManager } from 'ng-jhipster';

import { AnswerMySuffix } from './answer-my-suffix.model';
import { AnswerMySuffixPopupService } from './answer-my-suffix-popup.service';
import { AnswerMySuffixService } from './answer-my-suffix.service';

@Component({
    selector: 'jhi-answer-my-suffix-delete-dialog',
    templateUrl: './answer-my-suffix-delete-dialog.component.html'
})
export class AnswerMySuffixDeleteDialogComponent {

    answer: AnswerMySuffix;

    constructor(
        private answerService: AnswerMySuffixService,
        public activeModal: NgbActiveModal,
        private eventManager: EventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.answerService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'answerListModification',
                content: 'Deleted an answer'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-answer-my-suffix-delete-popup',
    template: ''
})
export class AnswerMySuffixDeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private answerPopupService: AnswerMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.answerPopupService
                .open(AnswerMySuffixDeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
