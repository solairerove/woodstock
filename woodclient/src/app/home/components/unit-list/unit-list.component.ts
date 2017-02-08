import {Component, OnInit} from "@angular/core";
import {Store} from "@ngrx/store";
import {HttpService} from "../../service/http.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-unit-list',
  templateUrl: './unit-list.component.html',
  styleUrls: ['./unit-list.component.css']
})
export class UnitListComponent implements OnInit {

  public units: Observable<any>;

  constructor(private store$: Store<any>,
  private httpService$: HttpService) {
  }

  ngOnInit() {
    this.httpService$
      .fetchUnits()
      .subscribe(s => this.units = s);
    // this.store$
    //   .select(state => state.units)
    //   .subscribe(s => console.log(s));
  }
}
