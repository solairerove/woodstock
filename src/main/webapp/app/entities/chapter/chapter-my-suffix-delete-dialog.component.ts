import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { AlertService, EventManager } from 'ng-jhipster';

import { ChapterMySuffix } from './chapter-my-suffix.model';
import { ChapterMySuffixPopupService } from './chapter-my-suffix-popup.service';
import { ChapterMySuffixService } from './chapter-my-suffix.service';

@Component({
    selector: 'jhi-chapter-my-suffix-delete-dialog',
    templateUrl: './chapter-my-suffix-delete-dialog.component.html'
})
export class ChapterMySuffixDeleteDialogComponent {

    chapter: ChapterMySuffix;

    constructor(
        private chapterService: ChapterMySuffixService,
        public activeModal: NgbActiveModal,
        private alertService: AlertService,
        private eventManager: EventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.chapterService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'chapterListModification',
                content: 'Deleted an chapter'
            });
            this.activeModal.dismiss(true);
        });
        this.alertService.success('woodstockApp.chapter.deleted', { param : id }, null);
    }
}

@Component({
    selector: 'jhi-chapter-my-suffix-delete-popup',
    template: ''
})
export class ChapterMySuffixDeletePopupComponent implements OnInit, OnDestroy {

    modalRef: NgbModalRef;
    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private chapterPopupService: ChapterMySuffixPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.modalRef = this.chapterPopupService
                .open(ChapterMySuffixDeleteDialogComponent, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
