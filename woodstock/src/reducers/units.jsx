import {FETCH_UNITS, FETCH_UNITS_SUCCESS, FETCH_UNIT_SUCCESS} from '../constants/ActionTypes';

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

        case FETCH_UNITS:
            return [
                ...state, {
                    units: []
                }
            ]

        case FETCH_UNITS_SUCCESS:
            return action.units

        case FETCH_UNIT_SUCCESS:
            return action.unit;

        default:
            return state
    }
};

export default unitReducer;
