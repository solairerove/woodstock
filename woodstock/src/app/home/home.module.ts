import {NgModule} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';
import {StoreDevtoolsModule} from '@ngrx/store-devtools';

import {HomeComponent} from './home.component';
import {HomeRoutingModule} from './home.routes';

import {HttpService} from './service/http.service';
import {UnitActions} from './action/unit.action';
import {UnitEffect} from './effect/unit.effect';
import {units} from './reducer/units';
import {SectionComponent} from './components/section/section.component';
import {UnitListComponent} from './components/unit-list/unit-list.component';
import { UnitDetailComponent } from './components/unit-detail/unit-detail.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    StoreModule.provideStore({units}),
    EffectsModule.run(UnitEffect),
    StoreDevtoolsModule.instrumentOnlyWithExtension({maxAge: 5}),

    HomeRoutingModule
  ],
  declarations: [
    HomeComponent,
    UnitListComponent,
    SectionComponent,
    UnitDetailComponent
  ],
  providers: [
    HttpService,
    UnitActions
  ],
})
export class HomeModule {
}
