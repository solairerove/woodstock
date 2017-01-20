import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {NgReduxModule} from 'ng2-redux';

import { AppComponent } from './app.component';
import { CounterActions } from './components/counter/counter.actions';
import { CounterComponent } from './components/counter/counter.component';
import { RandomNumberService } from './service/random-number.service';

@NgModule({
  declarations: [
    AppComponent,
    CounterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    NgReduxModule
  ],
  providers: [
    CounterActions,
    RandomNumberService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
