import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs/Observable';

import { INCREMENT, DECREMENT, RANDOMIZE, RESET } from './counter.reducer';
import { RandomNumberService } from '../../service/random-number.service';

@Component({
  selector: 'app-counter',
  templateUrl: './counter.component.html',
  styleUrls: ['./counter.component.css']
})
export class CounterComponent implements OnInit {

  counter: Observable<any>;

  constructor(private store: Store<any>, private randomNumberService: RandomNumberService) {
    this.counter = store.select('counterReducer');
  }

  ngOnInit() {
  }

  increment() {
    this.store.dispatch({ type: INCREMENT });
  }

  decrement() {
    this.store.dispatch({ type: DECREMENT });
  }

  randomize() {
    this.store.dispatch({
      type: RANDOMIZE,
      payload: this.randomNumberService.pick()
    });
  }

  reset() {
    this.store.dispatch({ type: RESET });
  }
}
