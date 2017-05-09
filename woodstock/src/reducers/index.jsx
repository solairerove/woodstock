import {combineReducers} from 'redux';
import unitReducer from './units';

const rootReducer = combineReducers({
    units: unitReducer
});

export default rootReducer;
