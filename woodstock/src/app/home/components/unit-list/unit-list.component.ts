import {Observable} from 'rxjs';
import {Component, OnInit} from '@angular/core';
import {Store} from '@ngrx/store';

@Component({
  selector: 'app-unit-list',
  templateUrl: './unit-list.component.html',
  styleUrls: ['./unit-list.component.css']
})
export class UnitListComponent implements OnInit {

  public units: Observable<any>;

  constructor(private store$: Store<any>) {
  }

  ngOnInit() {
    this.store$
      .map(state => state.units)
      .subscribe(u => this.units = u);
  }
}
