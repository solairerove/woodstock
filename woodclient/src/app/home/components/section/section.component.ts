import {Component, OnInit} from '@angular/core';
import {Store} from '@ngrx/store';
import {UnitActions} from '../../action/unit.action';

@Component({
  selector: 'app-section',
  templateUrl: './section.component.html',
  styleUrls: ['./section.component.css']
})
export class SectionComponent implements OnInit {

  constructor(private store$: Store<any>) {
  }

  ngOnInit() {
    this.store$.dispatch(UnitActions.loadUnits());
  }
}
