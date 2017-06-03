import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { WoodstockSharedModule } from '../../shared';
import {
    QuestionMySuffixService,
    QuestionMySuffixPopupService,
    QuestionMySuffixComponent,
    QuestionMySuffixDetailComponent,
    QuestionMySuffixDialogComponent,
    QuestionMySuffixPopupComponent,
    QuestionMySuffixDeletePopupComponent,
    QuestionMySuffixDeleteDialogComponent,
    questionRoute,
    questionPopupRoute,
    QuestionMySuffixResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...questionRoute,
    ...questionPopupRoute,
];

@NgModule({
    imports: [
        WoodstockSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        QuestionMySuffixComponent,
        QuestionMySuffixDetailComponent,
        QuestionMySuffixDialogComponent,
        QuestionMySuffixDeleteDialogComponent,
        QuestionMySuffixPopupComponent,
        QuestionMySuffixDeletePopupComponent,
    ],
    entryComponents: [
        QuestionMySuffixComponent,
        QuestionMySuffixDialogComponent,
        QuestionMySuffixPopupComponent,
        QuestionMySuffixDeleteDialogComponent,
        QuestionMySuffixDeletePopupComponent,
    ],
    providers: [
        QuestionMySuffixService,
        QuestionMySuffixPopupService,
        QuestionMySuffixResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class WoodstockQuestionMySuffixModule {}
