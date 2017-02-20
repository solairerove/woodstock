import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class UnitActions {

  static LOAD_UNITS = 'LOAD_UNITS';
  static LOAD_UNITS_SUCCESS = 'LOAD_UNITS_SUCCESS';

  static loadUnits(): Action {
    return {
      type: UnitActions.LOAD_UNITS
    };
  }

  static loadUnitsSuccess(data): Action {
    return {
      type: UnitActions.LOAD_UNITS_SUCCESS,
      payload: data
    };
  }
}
