import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { ChapterMySuffix } from './chapter-my-suffix.model';
import { ChapterMySuffixService } from './chapter-my-suffix.service';
@Injectable()
export class ChapterMySuffixPopupService {
    private isOpen = false;
    constructor(
        private modalService: NgbModal,
        private router: Router,
        private chapterService: ChapterMySuffixService

    ) {}

    open(component: Component, id?: number | any): NgbModalRef {
        if (this.isOpen) {
            return;
        }
        this.isOpen = true;

        if (id) {
            this.chapterService.find(id).subscribe((chapter) => {
                this.chapterModalRef(component, chapter);
            });
        } else {
            return this.chapterModalRef(component, new ChapterMySuffix());
        }
    }

    chapterModalRef(component: Component, chapter: ChapterMySuffix): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.chapter = chapter;
        modalRef.result.then((result) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true });
            this.isOpen = false;
        }, (reason) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true });
            this.isOpen = false;
        });
        return modalRef;
    }
}
