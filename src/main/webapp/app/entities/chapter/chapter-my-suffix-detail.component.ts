import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Rx';
import { EventManager  } from 'ng-jhipster';

import { ChapterMySuffix } from './chapter-my-suffix.model';
import { ChapterMySuffixService } from './chapter-my-suffix.service';

@Component({
    selector: 'jhi-chapter-my-suffix-detail',
    templateUrl: './chapter-my-suffix-detail.component.html'
})
export class ChapterMySuffixDetailComponent implements OnInit, OnDestroy {

    chapter: ChapterMySuffix;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: EventManager,
        private chapterService: ChapterMySuffixService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInChapters();
    }

    load(id) {
        this.chapterService.find(id).subscribe((chapter) => {
            this.chapter = chapter;
        });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInChapters() {
        this.eventSubscriber = this.eventManager.subscribe(
            'chapterListModification',
            (response) => this.load(this.chapter.id)
        );
    }
}
