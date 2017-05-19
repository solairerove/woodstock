import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { WoodstockSharedModule } from '../../shared';
import {
    UnitMySuffixService,
    UnitMySuffixPopupService,
    UnitMySuffixComponent,
    UnitMySuffixDetailComponent,
    UnitMySuffixDialogComponent,
    UnitMySuffixPopupComponent,
    UnitMySuffixDeletePopupComponent,
    UnitMySuffixDeleteDialogComponent,
    unitRoute,
    unitPopupRoute,
    UnitMySuffixResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...unitRoute,
    ...unitPopupRoute,
];

@NgModule({
    imports: [
        WoodstockSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        UnitMySuffixComponent,
        UnitMySuffixDetailComponent,
        UnitMySuffixDialogComponent,
        UnitMySuffixDeleteDialogComponent,
        UnitMySuffixPopupComponent,
        UnitMySuffixDeletePopupComponent,
    ],
    entryComponents: [
        UnitMySuffixComponent,
        UnitMySuffixDialogComponent,
        UnitMySuffixPopupComponent,
        UnitMySuffixDeleteDialogComponent,
        UnitMySuffixDeletePopupComponent,
    ],
    providers: [
        UnitMySuffixService,
        UnitMySuffixPopupService,
        UnitMySuffixResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class WoodstockUnitMySuffixModule {}
