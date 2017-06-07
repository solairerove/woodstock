import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Response } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { EventManager, AlertService } from 'ng-jhipster';

import { ChapterMySuffix } from './chapter-my-suffix.model';
import { ChapterMySuffixPopupService } from './chapter-my-suffix-popup.service';
import { ChapterMySuffixService } from './chapter-my-suffix.service';
import { ReferenceMySuffix, ReferenceMySuffixService } from '../reference';
import { ResponseWrapper } from '../../shared';

@Component({
    selector: 'jhi-chapter-my-suffix-dialog',
    templateUrl: './chapter-my-suffix-dialog.component.html'
})
export class ChapterMySuffixDialogComponent implements OnInit {

    chapter: ChapterMySuffix;
    authorities: any[];
    isSaving: boolean;

    references: ReferenceMySuffix[];

    constructor(
        public activeModal: NgbActiveModal,
        private alertService: AlertService,
        private chapterService: ChapterMySuffixService,
        private referenceService: ReferenceMySuffixService,
        private eventManager: EventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.authorities = ['ROLE_USER', 'ROLE_ADMIN'];
        this.referenceService.query()
            .subscribe((res: ResponseWrapper) => { this.references = res.json; }, (res: ResponseWrapper) => this.onError(res.json));
    }
    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.chapter.id !== undefined) {
            this.subscribeToSaveResponse(
                this.chapterService.update(this.chapter), false);
        } else {
            this.subscribeToSaveResponse(
                this.chapterService.create(this.chapter), true);
        }
    }

    private subscribeToSaveResponse(result: Observable<ChapterMySuffix>, isCreated: boolean) {
        result.subscribe((res: ChapterMySuffix) =>
            this.onSaveSuccess(res, isCreated), (res: Response) => this.onSaveError(res));
    }

    private onSaveSuccess(result: ChapterMySuffix, isCreated: boolean) {
        this.alertService.success(
            isCreated ? 'woodstockApp.chapter.created'
            : 'woodstockApp.chapter.updated',
            { param : result.id }, null);

        this.eventManager.broadcast({ name: 'chapterListModification', content: 'OK'});
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

    trackReferenceById(index: number, item: ReferenceMySuffix) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-chapter-my-suffix-popup',
    template: ''
})
export class ChapterMySuffixPopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private chapterPopupService: ChapterMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.modalRef = this.chapterPopupService
                    .open(ChapterMySuffixDialogComponent, params['id']);
            } else {
                this.modalRef = this.chapterPopupService
                    .open(ChapterMySuffixDialogComponent);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
