import * as types from '../constants/ActionTypes';
import axios from 'axios';

const API_URL = 'http://localhost:9090/api';

export const addTodo = (text) => ({type: types.ADD_TODO, text});
export const deleteTodo = (id) => ({type: types.DELETE_TODO, id});
export const editTodo = (id, text) => ({type: types.EDIT_TODO, id, text});
export const completeTodo = (id) => ({type: types.COMPLETE_TODO, id});
export const completeAll = () => ({type: types.COMPLETE_ALL});
export const clearCompleted = () => ({type: types.CLEAR_COMPLETED});

export const fetchUnitsSuccess = (units) => {
    return {
        type: types.FETCH_UNITS_SUCCESS,
        units
    }
};

export const fetchUnits = () => {
    return (dispatch) => {
        return axios
            .get(`${API_URL}/units`)
            .then(res => {
                console.log(res);
                dispatch(fetchUnitsSuccess(res.data));
            })
            .catch(error => console.log(error));
    }
};
