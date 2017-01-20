import { Component, OnInit } from '@angular/core';

import {NgRedux} from 'ng2-redux';
import {IAppState, rootReducer} from './store/index';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app works!';

    constructor(private ngRedux: NgRedux<IAppState>) {
        this.ngRedux.configureStore(rootReducer, {}, []);
    }

    ngOnInit() {
    }
}
