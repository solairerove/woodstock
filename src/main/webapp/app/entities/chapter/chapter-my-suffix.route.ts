import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { PaginationUtil } from 'ng-jhipster';

import { ChapterMySuffixComponent } from './chapter-my-suffix.component';
import { ChapterMySuffixDetailComponent } from './chapter-my-suffix-detail.component';
import { ChapterMySuffixPopupComponent } from './chapter-my-suffix-dialog.component';
import { ChapterMySuffixDeletePopupComponent } from './chapter-my-suffix-delete-dialog.component';

import { Principal } from '../../shared';

@Injectable()
export class ChapterMySuffixResolvePagingParams implements Resolve<any> {

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

export const chapterRoute: Routes = [
    {
        path: 'chapter-my-suffix',
        component: ChapterMySuffixComponent,
        resolve: {
            'pagingParams': ChapterMySuffixResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.chapter.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'chapter-my-suffix/:id',
        component: ChapterMySuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.chapter.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const chapterPopupRoute: Routes = [
    {
        path: 'chapter-my-suffix-new',
        component: ChapterMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.chapter.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'chapter-my-suffix/:id/edit',
        component: ChapterMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.chapter.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'chapter-my-suffix/:id/delete',
        component: ChapterMySuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.chapter.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
