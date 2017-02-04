import { ModelListActions } from './../action/model-list.cation';
import { HttpService } from './../service/http.service';
import 'rxjs';
import { Injectable } from '@angular/core';
import { Effect, Actions } from '@ngrx/effects';

@Injectable()
export class ModelListEffects {

    @Effect() load$ = this.actions$
        .ofType(ModelListActions.LOAD_MODEL)
        .switchMap(() => this.httpService$.fetchResponse())
        .map(res => ModelListActions.loadModelActionSuccess(res));

    constructor(private actions$: Actions,
        private httpService$: HttpService) { }
}
