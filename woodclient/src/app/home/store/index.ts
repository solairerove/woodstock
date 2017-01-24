import {combineReducers, Reducer} from 'redux';
import {counterReducer} from './counter.reducer';

export const rootReducer: Reducer<any> = combineReducers({
  counter: counterReducer
});
