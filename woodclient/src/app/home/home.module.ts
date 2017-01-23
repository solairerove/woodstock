import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NgReduxModule } from 'ng2-redux';

import { HomeComponent } from './home.component';
import { HomeRoutingModule } from './home.routes';

import { CounterActions } from './components/counter/counter.actions';
import { CounterComponent } from './components/counter/counter.component';
import { RandomNumberService } from './service/random-number.service';
import { ReactiveFormComponent } from './components/reactive-form/reactive-form.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    NgReduxModule,
    HomeRoutingModule
  ],
  declarations: [
    HomeComponent,
    CounterComponent,
    ReactiveFormComponent
  ],
  providers: [
    CounterActions,
    RandomNumberService
  ],
})
export class HomeModule { }
