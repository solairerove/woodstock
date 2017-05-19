import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { WoodstockSharedModule } from '../../shared';
import {
    ReferenceMySuffixService,
    ReferenceMySuffixPopupService,
    ReferenceMySuffixComponent,
    ReferenceMySuffixDetailComponent,
    ReferenceMySuffixDialogComponent,
    ReferenceMySuffixPopupComponent,
    ReferenceMySuffixDeletePopupComponent,
    ReferenceMySuffixDeleteDialogComponent,
    referenceRoute,
    referencePopupRoute,
    ReferenceMySuffixResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...referenceRoute,
    ...referencePopupRoute,
];

@NgModule({
    imports: [
        WoodstockSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        ReferenceMySuffixComponent,
        ReferenceMySuffixDetailComponent,
        ReferenceMySuffixDialogComponent,
        ReferenceMySuffixDeleteDialogComponent,
        ReferenceMySuffixPopupComponent,
        ReferenceMySuffixDeletePopupComponent,
    ],
    entryComponents: [
        ReferenceMySuffixComponent,
        ReferenceMySuffixDialogComponent,
        ReferenceMySuffixPopupComponent,
        ReferenceMySuffixDeleteDialogComponent,
        ReferenceMySuffixDeletePopupComponent,
    ],
    providers: [
        ReferenceMySuffixService,
        ReferenceMySuffixPopupService,
        ReferenceMySuffixResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class WoodstockReferenceMySuffixModule {}
