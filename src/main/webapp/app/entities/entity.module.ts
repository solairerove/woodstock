import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { WoodstockUnitMySuffixModule } from './unit/unit-my-suffix.module';
import { WoodstockReferenceMySuffixModule } from './reference/reference-my-suffix.module';
import { WoodstockChapterMySuffixModule } from './chapter/chapter-my-suffix.module';
import { WoodstockModuleMySuffixModule } from './module/module-my-suffix.module';
import { WoodstockQuestionMySuffixModule } from './question/question-my-suffix.module';
import { WoodstockAnswerMySuffixModule } from './answer/answer-my-suffix.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        WoodstockUnitMySuffixModule,
        WoodstockReferenceMySuffixModule,
        WoodstockChapterMySuffixModule,
        WoodstockModuleMySuffixModule,
        WoodstockQuestionMySuffixModule,
        WoodstockAnswerMySuffixModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class WoodstockEntityModule {}
