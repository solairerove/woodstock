import 'rxjs';
import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { Effect, Actions } from '@ngrx/effects';

import { ModelListActions } from './../action/model-list.cation';
import { HttpService } from './../service/http.service';

@Injectable()
export class ModelListEffects {

    @Effect() loadModels$: Observable<any> = this.actions$
        .ofType(ModelListActions.LOAD_MODEL)
        .do(() => console.log('effects -> loadModels$'))
        .switchMap(() => this.httpService$.fetchResponse())
        .map(res => ModelListActions.loadModelActionSuccess(res));

    constructor(private actions$: Actions,
        private httpService$: HttpService) { }
}
