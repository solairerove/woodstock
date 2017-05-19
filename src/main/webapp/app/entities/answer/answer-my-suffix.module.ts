import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { WoodstockSharedModule } from '../../shared';
import {
    AnswerMySuffixService,
    AnswerMySuffixPopupService,
    AnswerMySuffixComponent,
    AnswerMySuffixDetailComponent,
    AnswerMySuffixDialogComponent,
    AnswerMySuffixPopupComponent,
    AnswerMySuffixDeletePopupComponent,
    AnswerMySuffixDeleteDialogComponent,
    answerRoute,
    answerPopupRoute,
    AnswerMySuffixResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...answerRoute,
    ...answerPopupRoute,
];

@NgModule({
    imports: [
        WoodstockSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        AnswerMySuffixComponent,
        AnswerMySuffixDetailComponent,
        AnswerMySuffixDialogComponent,
        AnswerMySuffixDeleteDialogComponent,
        AnswerMySuffixPopupComponent,
        AnswerMySuffixDeletePopupComponent,
    ],
    entryComponents: [
        AnswerMySuffixComponent,
        AnswerMySuffixDialogComponent,
        AnswerMySuffixPopupComponent,
        AnswerMySuffixDeleteDialogComponent,
        AnswerMySuffixDeletePopupComponent,
    ],
    providers: [
        AnswerMySuffixService,
        AnswerMySuffixPopupService,
        AnswerMySuffixResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class WoodstockAnswerMySuffixModule {}
