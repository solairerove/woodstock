import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';

@Injectable()
export class CounterActions {

    static LOAD = 'LOAD';
    static LOAD_SUCCESS = 'LOAD_SUCCESS';
    static LOAD_FAILED = 'LOAD_FAILED';

    static loadAction(): Action {
        return {
            type: CounterActions.LOAD
        };
    }

    static loadActionSuccess(data: any): Action {
        return {
            type: CounterActions.LOAD_SUCCESS,
            payload: data
        };
    }

    static loadActionFailed(data: any): Action {
        return {
            type: CounterActions.LOAD_FAILED,
            payload: data
        };
    }
}
