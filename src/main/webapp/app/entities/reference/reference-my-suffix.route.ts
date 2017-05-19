import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { PaginationUtil } from 'ng-jhipster';

import { ReferenceMySuffixComponent } from './reference-my-suffix.component';
import { ReferenceMySuffixDetailComponent } from './reference-my-suffix-detail.component';
import { ReferenceMySuffixPopupComponent } from './reference-my-suffix-dialog.component';
import { ReferenceMySuffixDeletePopupComponent } from './reference-my-suffix-delete-dialog.component';

import { Principal } from '../../shared';

@Injectable()
export class ReferenceMySuffixResolvePagingParams implements Resolve<any> {

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

export const referenceRoute: Routes = [
    {
        path: 'reference-my-suffix',
        component: ReferenceMySuffixComponent,
        resolve: {
            'pagingParams': ReferenceMySuffixResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.reference.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'reference-my-suffix/:id',
        component: ReferenceMySuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.reference.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const referencePopupRoute: Routes = [
    {
        path: 'reference-my-suffix-new',
        component: ReferenceMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.reference.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'reference-my-suffix/:id/edit',
        component: ReferenceMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.reference.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'reference-my-suffix/:id/delete',
        component: ReferenceMySuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.reference.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
