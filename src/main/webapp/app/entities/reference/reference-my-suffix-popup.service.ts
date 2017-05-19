import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { ReferenceMySuffix } from './reference-my-suffix.model';
import { ReferenceMySuffixService } from './reference-my-suffix.service';
@Injectable()
export class ReferenceMySuffixPopupService {
    private isOpen = false;
    constructor(
        private modalService: NgbModal,
        private router: Router,
        private referenceService: ReferenceMySuffixService

    ) {}

    open(component: Component, id?: number | any): NgbModalRef {
        if (this.isOpen) {
            return;
        }
        this.isOpen = true;

        if (id) {
            this.referenceService.find(id).subscribe((reference) => {
                this.referenceModalRef(component, reference);
            });
        } else {
            return this.referenceModalRef(component, new ReferenceMySuffix());
        }
    }

    referenceModalRef(component: Component, reference: ReferenceMySuffix): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.reference = reference;
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
