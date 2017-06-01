import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { EventManager  } from 'ng-jhipster';

import { AnswerMySuffix } from './answer-my-suffix.model';
import { AnswerMySuffixService } from './answer-my-suffix.service';

@Component({
    selector: 'jhi-answer-my-suffix-detail',
    templateUrl: './answer-my-suffix-detail.component.html'
})
export class AnswerMySuffixDetailComponent implements OnInit, OnDestroy {

    answer: AnswerMySuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: EventManager,
        private answerService: AnswerMySuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInAnswers();
    }

    load(id) {
        this.answerService.find(id).subscribe((answer) => {
            this.answer = answer;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInAnswers() {
        this.eventSubscriber = this.eventManager.subscribe(
            'answerListModification',
            (response) => this.load(this.answer.id)
        );
    }
}
