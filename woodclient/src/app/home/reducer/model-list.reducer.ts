import { ModelListActions } from './../action/model-list.cation';
import { Action } from '@ngrx/store';

const INITIAL_STATE = {};

export const modelListReducer = (state = INITIAL_STATE, action: Action) => {
    switch (action.type) {
        case ModelListActions.LOAD_MODEL: {
            return Object.assign({}, state);
        }

        case ModelListActions.LOAD_MODEL_SUCCESS: {
            return action.payload;
        }

        default:
            return INITIAL_STATE;
    }
};
