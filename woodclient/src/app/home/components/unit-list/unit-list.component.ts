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
    this.initState();
  }

  private initState() {
    this.store$
      .select(state => state.units)
      .subscribe(s => this.units = s);
  }
}
