import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { PaginationUtil } from 'ng-jhipster';

import { AnswerMySuffixComponent } from './answer-my-suffix.component';
import { AnswerMySuffixDetailComponent } from './answer-my-suffix-detail.component';
import { AnswerMySuffixPopupComponent } from './answer-my-suffix-dialog.component';
import { AnswerMySuffixDeletePopupComponent } from './answer-my-suffix-delete-dialog.component';

import { Principal } from '../../shared';

@Injectable()
export class AnswerMySuffixResolvePagingParams implements Resolve<any> {

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

export const answerRoute: Routes = [
    {
        path: 'answer-my-suffix',
        component: AnswerMySuffixComponent,
        resolve: {
            'pagingParams': AnswerMySuffixResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.answer.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'answer-my-suffix/:id',
        component: AnswerMySuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.answer.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const answerPopupRoute: Routes = [
    {
        path: 'answer-my-suffix-new',
        component: AnswerMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.answer.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'answer-my-suffix/:id/edit',
        component: AnswerMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.answer.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'answer-my-suffix/:id/delete',
        component: AnswerMySuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.answer.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
