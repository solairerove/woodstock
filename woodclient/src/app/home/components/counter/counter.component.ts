import {Component, OnInit} from '@angular/core';
import {NgRedux} from 'ng2-redux';
import {Observable} from 'rxjs/Observable';

import {CounterActions} from './counter.actions';

@Component({
  selector: 'app-counter',
  templateUrl: './counter.component.html'
})
export class CounterComponent implements OnInit {

  counter$: Observable<number>;

  constructor(public actions: CounterActions,
              private ngRedux: NgRedux<any>) {
  }

  ngOnInit() {
    this.counter$ = this.ngRedux.select('counter');
  }
}
