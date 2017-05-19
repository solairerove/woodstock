import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { EventManager, AlertService } from 'ng-jhipster';

import { AnswerMySuffix } from './answer-my-suffix.model';
import { AnswerMySuffixPopupService } from './answer-my-suffix-popup.service';
import { AnswerMySuffixService } from './answer-my-suffix.service';
import { QuestionMySuffix, QuestionMySuffixService } from '../question';

@Component({
    selector: 'jhi-answer-my-suffix-dialog',
    templateUrl: './answer-my-suffix-dialog.component.html'
})
export class AnswerMySuffixDialogComponent implements OnInit {

    answer: AnswerMySuffix;
    authorities: any[];
    isSaving: boolean;

    questions: QuestionMySuffix[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: AlertService,
        private answerService: AnswerMySuffixService,
        private questionService: QuestionMySuffixService,
        private eventManager: EventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.authorities = ['ROLE_USER', 'ROLE_ADMIN'];
        this.questionService.query().subscribe(
            (res: Response) => { this.questions = res.json(); }, (res: Response) => this.onError(res.json()));
    }
    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.answer.id !== undefined) {
            this.subscribeToSaveResponse(
                this.answerService.update(this.answer));
        } else {
            this.subscribeToSaveResponse(
                this.answerService.create(this.answer));
        }
    }

    private subscribeToSaveResponse(result: Observable<AnswerMySuffix>) {
        result.subscribe((res: AnswerMySuffix) =>
            this.onSaveSuccess(res), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: AnswerMySuffix) {
        this.eventManager.broadcast({ name: 'answerListModification', content: 'OK'});
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

    trackQuestionById(index: number, item: QuestionMySuffix) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-answer-my-suffix-popup',
    template: ''
})
export class AnswerMySuffixPopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private answerPopupService: AnswerMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.answerPopupService
                    .open(AnswerMySuffixDialogComponent, params['id']);
            } else {
                this.modalRef = this.answerPopupService
                    .open(AnswerMySuffixDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
