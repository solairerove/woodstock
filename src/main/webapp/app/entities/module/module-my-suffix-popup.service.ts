import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { ModuleMySuffix } from './module-my-suffix.model';
import { ModuleMySuffixService } from './module-my-suffix.service';
@Injectable()
export class ModuleMySuffixPopupService {
    private isOpen = false;
    constructor(
        private modalService: NgbModal,
        private router: Router,
        private moduleService: ModuleMySuffixService

    ) {}

    open(component: Component, id?: number | any): NgbModalRef {
        if (this.isOpen) {
            return;
        }
        this.isOpen = true;

        if (id) {
            this.moduleService.find(id).subscribe((module) => {
                this.moduleModalRef(component, module);
            });
        } else {
            return this.moduleModalRef(component, new ModuleMySuffix());
        }
    }

    moduleModalRef(component: Component, module: ModuleMySuffix): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.module = module;
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
