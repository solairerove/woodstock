import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { EventManager  } from 'ng-jhipster';

import { UnitMySuffix } from './unit-my-suffix.model';
import { UnitMySuffixService } from './unit-my-suffix.service';

@Component({
    selector: 'jhi-unit-my-suffix-detail',
    templateUrl: './unit-my-suffix-detail.component.html'
})
export class UnitMySuffixDetailComponent implements OnInit, OnDestroy {

    unit: UnitMySuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: EventManager,
        private unitService: UnitMySuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInUnits();
    }

    load(id) {
        this.unitService.find(id).subscribe((unit) => {
            this.unit = unit;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInUnits() {
        this.eventSubscriber = this.eventManager.subscribe(
            'unitListModification',
            (response) => this.load(this.unit.id)
        );
    }
}
