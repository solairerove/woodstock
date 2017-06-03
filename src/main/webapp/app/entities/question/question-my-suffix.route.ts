import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { PaginationUtil } from 'ng-jhipster';

import { QuestionMySuffixComponent } from './question-my-suffix.component';
import { QuestionMySuffixDetailComponent } from './question-my-suffix-detail.component';
import { QuestionMySuffixPopupComponent } from './question-my-suffix-dialog.component';
import { QuestionMySuffixDeletePopupComponent } from './question-my-suffix-delete-dialog.component';

import { Principal } from '../../shared';

@Injectable()
export class QuestionMySuffixResolvePagingParams implements Resolve<any> {

    constructor(private paginationUtil: PaginationUtil) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const page = route.queryParams['page'] ? route.queryParams['page'] : '1';
        const sort = route.queryParams['sort'] ? route.queryParams['sort'] : 'id,asc';
        return {
            page: this.paginationUtil.parsePage(page),
            predicate: this.paginationUtil.parsePredicate(sort),
            ascending: this.paginationUtil.parseAscending(sort)
      };
    }
}

export const questionRoute: Routes = [
    {
        path: 'question-my-suffix',
        component: QuestionMySuffixComponent,
        resolve: {
            'pagingParams': QuestionMySuffixResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.question.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'question-my-suffix/:id',
        component: QuestionMySuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.question.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const questionPopupRoute: Routes = [
    {
        path: 'question-my-suffix-new',
        component: QuestionMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.question.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'question-my-suffix/:id/edit',
        component: QuestionMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.question.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'question-my-suffix/:id/delete',
        component: QuestionMySuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.question.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
