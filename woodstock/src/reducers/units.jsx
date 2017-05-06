import {FETCH_UNITS_SUCCESS} from  '../constants/ActionTypes';

const initState = [
    {}
];

const unitReducer = (state = initState, action) => {
    switch (action.type) {
        case FETCH_UNITS_SUCCESS:
            return action.units;

        default:
            return state
    }
};

export default unitReducer;
