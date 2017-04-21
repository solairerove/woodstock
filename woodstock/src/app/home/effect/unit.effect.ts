import 'rxjs';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {Actions, Effect} from '@ngrx/effects';

import {HttpService} from '../service/http.service';
import {UnitActions} from '../action/unit.action';

@Injectable()
export class UnitEffect {

  @Effect() loadUnits$: Observable<any> = this.actions$
    .ofType(UnitActions.LOAD_UNITS)
    .switchMap(() => this.httpService$.fetchUnits()
      .map(res => UnitActions.loadUnitsSuccess(res)));

  @Effect() loadUnit$: Observable<any> = this.actions$
    .ofType(UnitActions.LOAD_UNITS)
    .switchMap(() => this.httpService$.fetchUnit('f')
      .map(res => UnitActions.loadUnitSucess(res)));

  constructor(private actions$: Actions,
              private httpService$: HttpService) {
  }
}
