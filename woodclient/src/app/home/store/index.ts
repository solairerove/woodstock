import { combineReducers, Reducer } from 'redux';
import { counterReducer } from './counter.reducer';

export class IAppState {
    counter?: number;
}

export const rootReducer: Reducer<IAppState> = combineReducers<IAppState>({
    counter: counterReducer
});
