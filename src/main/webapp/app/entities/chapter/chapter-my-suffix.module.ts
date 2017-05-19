import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { WoodstockSharedModule } from '../../shared';
import {
    ChapterMySuffixService,
    ChapterMySuffixPopupService,
    ChapterMySuffixComponent,
    ChapterMySuffixDetailComponent,
    ChapterMySuffixDialogComponent,
    ChapterMySuffixPopupComponent,
    ChapterMySuffixDeletePopupComponent,
    ChapterMySuffixDeleteDialogComponent,
    chapterRoute,
    chapterPopupRoute,
    ChapterMySuffixResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...chapterRoute,
    ...chapterPopupRoute,
];

@NgModule({
    imports: [
        WoodstockSharedModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        ChapterMySuffixComponent,
        ChapterMySuffixDetailComponent,
        ChapterMySuffixDialogComponent,
        ChapterMySuffixDeleteDialogComponent,
        ChapterMySuffixPopupComponent,
        ChapterMySuffixDeletePopupComponent,
    ],
    entryComponents: [
        ChapterMySuffixComponent,
        ChapterMySuffixDialogComponent,
        ChapterMySuffixPopupComponent,
        ChapterMySuffixDeleteDialogComponent,
        ChapterMySuffixDeletePopupComponent,
    ],
    providers: [
        ChapterMySuffixService,
        ChapterMySuffixPopupService,
        ChapterMySuffixResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class WoodstockChapterMySuffixModule {}
