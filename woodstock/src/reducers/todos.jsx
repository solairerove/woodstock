import {
    ADD_TODO,
    DELETE_TODO,
    EDIT_TODO,
    COMPLETE_TODO,
    COMPLETE_ALL,
    CLEAR_COMPLETED
} from '../constants/ActionTypes';

const initialState = [
    {
        id: 0,
        text: 'Use something else',
        completed: false
    }
];

const todos = (state = initialState, action) => {
    switch (action.type) {
        case ADD_TODO:
            return [
                {
                    id: state.reduce((maxId, todo) => Math.max(todo.id, maxId), -1) + 1,
                    text: action.text,
                    completed: false
                },
                ...state
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
                    completed: !action.completed
                }
                : todo);

        case COMPLETE_ALL:
            const areAllMarked = state.every(todo => todo.completed);
            return state.map(todo => ({
                ...todo,
                completed: !areAllMarked
            }));

        case CLEAR_COMPLETED:
            return state.filter(todo => todo.completed === false)

        default:
            return state
    }
};

export default todos;
