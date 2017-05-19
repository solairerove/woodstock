import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { WoodstockSharedModule } from '../../shared';
import {
    ModuleMySuffixService,
    ModuleMySuffixPopupService,
    ModuleMySuffixComponent,
    ModuleMySuffixDetailComponent,
    ModuleMySuffixDialogComponent,
    ModuleMySuffixPopupComponent,
    ModuleMySuffixDeletePopupComponent,
    ModuleMySuffixDeleteDialogComponent,
    moduleRoute,
    modulePopupRoute,
    ModuleMySuffixResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...moduleRoute,
    ...modulePopupRoute,
];

@NgModule({
    imports: [
        WoodstockSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        ModuleMySuffixComponent,
        ModuleMySuffixDetailComponent,
        ModuleMySuffixDialogComponent,
        ModuleMySuffixDeleteDialogComponent,
        ModuleMySuffixPopupComponent,
        ModuleMySuffixDeletePopupComponent,
    ],
    entryComponents: [
        ModuleMySuffixComponent,
        ModuleMySuffixDialogComponent,
        ModuleMySuffixPopupComponent,
        ModuleMySuffixDeleteDialogComponent,
        ModuleMySuffixDeletePopupComponent,
    ],
    providers: [
        ModuleMySuffixService,
        ModuleMySuffixPopupService,
        ModuleMySuffixResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class WoodstockModuleMySuffixModule {}
