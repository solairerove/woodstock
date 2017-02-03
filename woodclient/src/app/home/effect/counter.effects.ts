import 'rxjs';
import { Injectable } from '@angular/core';
import { Effect, Actions } from '@ngrx/effects';

import { CounterActions } from './../action/counter.action';
import { RandomNumberService } from './../service/random-number.service';

@Injectable()
export class CounterEffects {

    @Effect() randomize$ = this.actions$
        .ofType(CounterActions.RANDOMIZE)
        .switchMap(() => this.randomNumberService.pick())
        .map(res => CounterActions.fireCounterSuccess(res));

    constructor(private actions$: Actions,
        private randomNumberService: RandomNumberService) { }
}
