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

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    StoreModule.provideStore({ counter: counterReducer }),
    HomeRoutingModule
  ],
  declarations: [
    HomeComponent,
    ReactiveFormComponent,
    CounterComponent
  ],
  providers: [
    RandomNumberService
  ],
})
export class HomeModule { }
