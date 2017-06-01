import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { EventManager  } from 'ng-jhipster';

import { ModuleMySuffix } from './module-my-suffix.model';
import { ModuleMySuffixService } from './module-my-suffix.service';

@Component({
    selector: 'jhi-module-my-suffix-detail',
    templateUrl: './module-my-suffix-detail.component.html'
})
export class ModuleMySuffixDetailComponent implements OnInit, OnDestroy {

    module: ModuleMySuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: EventManager,
        private moduleService: ModuleMySuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInModules();
    }

    load(id) {
        this.moduleService.find(id).subscribe((module) => {
            this.module = module;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInModules() {
        this.eventSubscriber = this.eventManager.subscribe(
            'moduleListModification',
            (response) => this.load(this.module.id)
        );
    }
}
