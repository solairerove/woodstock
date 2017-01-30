import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { StoreModule } from '@ngrx/store';

import { HomeComponent } from './home.component';
import { HomeRoutingModule } from './home.routes';

import { RandomNumberService } from './service/random-number.service';
import { ReactiveFormComponent } from './components/reactive-form/reactive-form.component';
import { counterReducer } from './components/counter/counter.reducer';
import { CounterComponent } from './components/counter/counter.component';
import { DynamicComponent } from './components/dynamic/dynamic.component';
import { FirstDumbComponent } from './components/first-dumb/first-dumb.component';
import { SecondDumbComponent } from './components/second-dumb/second-dumb.component';
import { DynamicEntrypointComponent } from './components/dynamic-entrypoint/dynamic-entrypoint.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    StoreModule.provideStore({ counterReducer }),
    HomeRoutingModule
  ],
  declarations: [
    HomeComponent,
    ReactiveFormComponent,
    CounterComponent,
    DynamicComponent,
    FirstDumbComponent,
    SecondDumbComponent,
    DynamicEntrypointComponent
  ],
  providers: [
    RandomNumberService
  ],
})
export class HomeModule { }
