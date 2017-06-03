import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { EventManager  } from 'ng-jhipster';

import { QuestionMySuffix } from './question-my-suffix.model';
import { QuestionMySuffixService } from './question-my-suffix.service';

@Component({
    selector: 'jhi-question-my-suffix-detail',
    templateUrl: './question-my-suffix-detail.component.html'
})
export class QuestionMySuffixDetailComponent implements OnInit, OnDestroy {

    question: QuestionMySuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: EventManager,
        private questionService: QuestionMySuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInQuestions();
    }

    load(id) {
        this.questionService.find(id).subscribe((question) => {
            this.question = question;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInQuestions() {
        this.eventSubscriber = this.eventManager.subscribe(
            'questionListModification',
            (response) => this.load(this.question.id)
        );
    }
}
