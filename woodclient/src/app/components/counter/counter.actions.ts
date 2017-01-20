import {Injectable} from '@angular/core';
import {NgRedux} from 'ng2-redux';
import {RandomNumberService} from '../../service/random-number.service';
import {IAppState} from '../../store';

export const INCREMENT = 'INCREMENT';
export const DECREMENT = 'DECREMENT';
export const RANDOMIZE = 'RANDOMIZE';
export const RESET = 'RESET';

@Injectable()
export class CounterActions {

    constructor(private ngRedux: NgRedux<IAppState>,
                private randomNumberService: RandomNumberService) {
    }

    increment(): void {
        this.ngRedux.dispatch({type: INCREMENT});
    }

    decrement(): void {
        this.ngRedux.dispatch({type: DECREMENT});
    }

    randomize(): void {
        this.ngRedux.dispatch({
            type: RANDOMIZE,
            payload: this.randomNumberService.pick()
        });
    }

    reset(): void {
        this.ngRedux.dispatch({type: RESET});
    }
}
