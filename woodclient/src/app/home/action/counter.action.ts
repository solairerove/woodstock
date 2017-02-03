import { Action } from '@ngrx/store';
import { INCREMENT, DECREMENT, RANDOMIZE, RESET } from './../components/counter/counter.reducer';
import { Injectable } from '@angular/core';

@Injectable()
export class CounterActions {

    static INCREMENT = 'INCREMENT';
    static DECREMENT = 'DECREMENT';
    static RANDOMIZE = 'RANDOMIZE';
    static RESET = 'RESET';
    static LOAD = 'LOAD';
    static FIRE = 'FIRE';
    static FIRE_SUCCESS = 'FIRE_SUCCESS';

    static incrementCounter(): Action {
        return {
            type: CounterActions.INCREMENT
        };
    }

    static randomizeCounter(): Action {
        return {
            type: CounterActions.RANDOMIZE
        };
    }

    static fireCounterSuccess(counter): Action {
        return {
            type: CounterActions.FIRE_SUCCESS,
            payload: counter
        };
    }
}
