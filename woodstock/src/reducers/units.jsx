import {FETCH_UNITS_SUCCESS} from  '../constants/ActionTypes';

const initState = [
    {
        id: "0",
        label: "Unit label",
        avatar: "Unit avatar",
        description: "description",
        featured: false,
        modules: []
    }
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
