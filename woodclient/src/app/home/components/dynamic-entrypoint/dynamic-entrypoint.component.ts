import { Component, OnInit } from '@angular/core';

import { FirstDumbComponent } from '../first-dumb/first-dumb.component';
import { SecondDumbComponent } from '../second-dumb/second-dumb.component';

@Component({
  selector: 'app-dynamic-entrypoint',
  templateUrl: './dynamic-entrypoint.component.html',
  styleUrls: ['./dynamic-entrypoint.component.css']
})
export class DynamicEntrypointComponent implements OnInit {

  componentData;

  constructor() { }

  ngOnInit() {
  }

  createFirstDumbComponent() {
    this.componentData = {
      component: FirstDumbComponent,
      inputs: {
        showNum: 9
      }
    };
  }

  createSecondDumbComponent() {
    this.componentData = {
      component: SecondDumbComponent,
      inputs: {
        showNum: 2
      }
    };
  }
}
