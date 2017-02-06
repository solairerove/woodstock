import { ModelListActions } from './../../action/model-list.cation';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs/Observable';
import { Component, OnInit } from '@angular/core';
import { HttpService } from './../../service/http.service';

@Component({
  selector: 'app-model-list',
  templateUrl: './model-list.component.html',
  styleUrls: ['./model-list.component.css']
})
export class ModelListComponent implements OnInit {

  public models: Observable<any>;
  private errorMessage: any;

  constructor(private store$: Store<any>,
    private httpService$: HttpService) {
  }

  ngOnInit() {
    this.initState();
  }

  private initState() {
    this.store$
      .select(state => state.modelListReducer)
      .subscribe(data => {
        console.log(data);
      });
  }

  public load(): void {
    this.store$.dispatch(ModelListActions.loadModelAction());
  }
}
