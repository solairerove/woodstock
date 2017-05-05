import {
    ADD_TODO,
    DELETE_TODO,
    EDIT_TODO,
    COMPLETE_TODO,
    COMPLETE_ALL,
    CLEAR_COMPLETED,
    FETCH_UNITS_SUCCESS
} from '../constants/ActionTypes';

const initialState = [
    {
        id: 0,
        text: 'Use something else',
        completed: false
    }
];

const todoReducer = (state = initialState, action) => {
    switch (action.type) {
        case ADD_TODO:
            return [
                ...state, {
                    id: state.reduce((maxId, todo) => Math.max(todo.id, maxId), -1) + 1,
                    text: action.text,
                    completed: false
                }
            ];

        case DELETE_TODO:
            return state.filter(todo => todo.id !== action.id);

        case EDIT_TODO:
            return state.map(todo => todo.id === action.id
                ? {
                    ...todo,
                    text: action.text
                }
                : todo);

        case COMPLETE_TODO:
            return state.map(todo => todo.id === action.id
                ? {
                    ...todo,
                    completed: !todo.completed
                }
                : todo);

        case COMPLETE_ALL:
            const areAllMarked = state.every(todo => todo.completed);

            return state.map(todo => ({
                ...todo,
                completed: !areAllMarked
            }));

        case CLEAR_COMPLETED:
            return state.filter(todo => todo.completed === false);
        
        case FETCH_UNITS_SUCCESS:
            return action.units;

        default:
            return state
    }
};

export default todoReducer;
