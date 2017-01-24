import {INCREMENT, DECREMENT, RANDOMIZE, RESET} from '../components/counter/counter.actions';

const INITIAL_STATE = 0;

export const counterReducer = (state: number = INITIAL_STATE, action: any) => {
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
      return state;
  }
};
