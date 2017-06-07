import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { EventManager, AlertService } from 'ng-jhipster';

import { QuestionMySuffix } from './question-my-suffix.model';
import { QuestionMySuffixPopupService } from './question-my-suffix-popup.service';
import { QuestionMySuffixService } from './question-my-suffix.service';
import { ModuleMySuffix, ModuleMySuffixService } from '../module';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-question-my-suffix-dialog',
    templateUrl: './question-my-suffix-dialog.component.html'
})
export class QuestionMySuffixDialogComponent implements OnInit {

    question: QuestionMySuffix;
    authorities: any[];
    isSaving: boolean;

    modules: ModuleMySuffix[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: AlertService,
        private questionService: QuestionMySuffixService,
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
        if (this.question.id !== undefined) {
            this.subscribeToSaveResponse(
                this.questionService.update(this.question), false);
        } else {
            this.subscribeToSaveResponse(
                this.questionService.create(this.question), true);
        }
    }

    private subscribeToSaveResponse(result: Observable<QuestionMySuffix>, isCreated: boolean) {
        result.subscribe((res: QuestionMySuffix) =>
            this.onSaveSuccess(res, isCreated), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: QuestionMySuffix, isCreated: boolean) {
        this.alertService.success(
            isCreated ? 'woodstockApp.question.created'
            : 'woodstockApp.question.updated',
            { param : result.id }, null);

        this.eventManager.broadcast({ name: 'questionListModification', content: 'OK'});
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
    selector: 'jhi-question-my-suffix-popup',
    template: ''
})
export class QuestionMySuffixPopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private questionPopupService: QuestionMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.questionPopupService
                    .open(QuestionMySuffixDialogComponent, params['id']);
            } else {
                this.modalRef = this.questionPopupService
                    .open(QuestionMySuffixDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
