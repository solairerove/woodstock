import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { PaginationUtil } from 'ng-jhipster';

import { UnitMySuffixComponent } from './unit-my-suffix.component';
import { UnitMySuffixDetailComponent } from './unit-my-suffix-detail.component';
import { UnitMySuffixPopupComponent } from './unit-my-suffix-dialog.component';
import { UnitMySuffixDeletePopupComponent } from './unit-my-suffix-delete-dialog.component';

import { Principal } from '../../shared';

@Injectable()
export class UnitMySuffixResolvePagingParams implements Resolve<any> {

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

export const unitRoute: Routes = [
    {
        path: 'unit-my-suffix',
        component: UnitMySuffixComponent,
        resolve: {
            'pagingParams': UnitMySuffixResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.unit.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'unit-my-suffix/:id',
        component: UnitMySuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.unit.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const unitPopupRoute: Routes = [
    {
        path: 'unit-my-suffix-new',
        component: UnitMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.unit.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'unit-my-suffix/:id/edit',
        component: UnitMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.unit.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'unit-my-suffix/:id/delete',
        component: UnitMySuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.unit.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
