import {Component, OnInit} from '@angular/core';
import {NgRedux, select} from 'ng2-redux';
import {Observable} from 'rxjs/Observable';

import {CounterActions} from './counter.actions';
import {IAppState} from '../../store';

@Component({
  selector: 'app-counter',
  templateUrl: './counter.component.html'
})
export class CounterComponent implements OnInit {

  @select() counter$: Observable<number>;

    constructor(public actions: CounterActions,
                private ngRedux: NgRedux<IAppState>) {
    }

    ngOnInit() {
    }
}
