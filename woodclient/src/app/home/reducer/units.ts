import {Action} from '@ngrx/store';
import {UnitActions} from '../action/unit.action';

export const units = (state: any = {}, action: Action) => {
  switch (action.type) {

    case UnitActions.LOAD_UNITS_SUCCESS:
      return action.payload;

    default:
      return state;
  }
};
