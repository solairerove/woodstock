import { Action, ActionReducer } from '@ngrx/store';

export const INCREMENT = 'INCREMENT';
export const DECREMENT = 'DECREMENT';
export const RANDOMIZE = 'RANDOMIZE';
export const RESET = 'RESET';

const INITIAL_STATE = 0;

export function counterReducer(state = INITIAL_STATE, action: Action) {
    switch (action.type) {
        case INCREMENT:
            return state + 1;

        case DECREMENT:
            return state - 1;

        case RANDOMIZE:
            return action.payload;

        case RESET:
            return INITIAL_STATE;

        default:
            return INITIAL_STATE;
    }
}
