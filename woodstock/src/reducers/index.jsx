import {combineReducers} from 'redux';
import todoReducer from './todos';
import unitReducer from './units';

const rootReducer = combineReducers({
    todos: todoReducer,
    units: unitReducer
});

export default rootReducer;
