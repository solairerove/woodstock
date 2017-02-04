import { Action } from '@ngrx/store';
import { Injectable } from '@angular/core';

@Injectable()
export class ModelListActions {

    static LOAD_MODEL = 'LOAD_MODEL';
    static LOAD_MODEL_SUCCESS = 'LOAD_MODEL_SUCCESS';
    static LOAD_MODEL_FAILED = 'LOAD_MODEL_FAILED';

    static loadModelAction(): Action {
        return {
            type: ModelListActions.LOAD_MODEL
        };
    }

    static loadModelActionSuccess(data: any): Action {
        return {
            type: ModelListActions.LOAD_MODEL_SUCCESS,
            payload: data
        };
    }

    static loadModelActionFailed(data: any): Action {
        return {
            type: ModelListActions.LOAD_MODEL_FAILED,
            payload: data
        };
    }
}
