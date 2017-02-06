import { Action } from '@ngrx/store';
import { ModelListActions } from './../action/model-list.cation';

export const modelListReducer = (state: any = {}, action: Action) => {
    switch (action.type) {

        case ModelListActions.LOAD_MODEL_SUCCESS:
            return action.payload;

        default:
            return state;
    }
};
