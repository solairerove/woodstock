import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';
import { INCREMENT, DECREMENT, RANDOMIZE, RESET } from './../components/counter/counter.reducer';

@Injectable()
export class CounterActions {

    // static INCREMENT = 'INCREMENT';
    // static DECREMENT = 'DECREMENT';
    // static RANDOMIZE = 'RANDOMIZE';
    // static RESET = 'RESET';
    static LOAD = 'LOAD';
    static LOAD_SUCCESS = 'LOAD_SUCCESS';
    static LOAD_FAILED = 'LOAD_FAILED';
    // static FIRE = 'FIRE';
    // static FIRE_SUCCESS = 'FIRE_SUCCESS';

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

    // static incrementCounter(): Action {
    //     return {
    //         type: CounterActions.INCREMENT
    //     };
    // }

    // static randomizeCounter(): Action {
    //     return {
    //         type: CounterActions.RANDOMIZE
    //     };
    // }

    // static fireCounterAction(): Action {
    //     return {
    //         type: CounterActions.FIRE
    //     };
    // }

    // static fireCounterSuccess(counter): Action {
    //     return {
    //         type: CounterActions.FIRE_SUCCESS,
    //         payload: counter
    //     };
    // }
}
