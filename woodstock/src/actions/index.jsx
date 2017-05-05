import * as types from '../constants/ActionTypes';
import axios from 'axios';

const API_URL = 'http://localhost:9090/api';

export const addTodo = (text) => ({type: types.ADD_TODO, text});
export const deleteTodo = (id) => ({type: types.DELETE_TODO, id});
export const editTodo = (id, text) => ({type: types.EDIT_TODO, id, text});
export const completeTodo = (id) => ({type: types.COMPLETE_TODO, id});
export const completeAll = () => ({type: types.COMPLETE_ALL});
export const clearCompleted = () => ({type: types.CLEAR_COMPLETED});

export function fetchUnits() {
    return function (dispatch) {
        axios.get(`${API_URL}/units`)
            .then(response => {
                console.log(response);
                dispatch({
                    type: types.FETCH_UNITS,
                    payload: response.data
                });
            })
            .catch((error) => console.log(error));
    }
}
