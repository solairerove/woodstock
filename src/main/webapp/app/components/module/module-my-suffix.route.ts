import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes, CanActivate } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { PaginationUtil } from 'ng-jhipster';

import { ModuleMySuffixComponent } from './module-my-suffix.component';
import { ModuleMySuffixDetailComponent } from './module-my-suffix-detail.component';
import { ModuleMySuffixPopupComponent } from './module-my-suffix-dialog.component';
import { ModuleMySuffixDeletePopupComponent } from './module-my-suffix-delete-dialog.component';

import { Principal } from '../../shared';

@Injectable()
export class ModuleMySuffixResolvePagingParams implements Resolve<any> {

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

export const moduleRoute: Routes = [
    {
        path: 'module-my-suffix',
        component: ModuleMySuffixComponent,
        resolve: {
            'pagingParams': ModuleMySuffixResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.module.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'module-my-suffix/:id',
        component: ModuleMySuffixDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.module.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const modulePopupRoute: Routes = [
    {
        path: 'module-my-suffix-new',
        component: ModuleMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.module.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'module-my-suffix/:id/edit',
        component: ModuleMySuffixPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.module.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'module-my-suffix/:id/delete',
        component: ModuleMySuffixDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'woodstockApp.module.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
