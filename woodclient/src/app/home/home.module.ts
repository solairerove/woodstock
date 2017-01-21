import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgReduxModule } from 'ng2-redux';

import { HomeComponent } from './home.component';
import { HomeRoutingModule } from './home.routes';

import { CounterActions } from './components/counter/counter.actions';
import { CounterComponent } from './components/counter/counter.component';
import { RandomNumberService } from './service/random-number.service';

@NgModule({
  imports: [
    CommonModule,
    NgReduxModule,
    HomeRoutingModule
  ],
  declarations: [
    HomeComponent,
    CounterComponent
  ],
  providers: [
    CounterActions,
    RandomNumberService
  ],
})
export class HomeModule { }
