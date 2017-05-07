import * as types from '../constants/ActionTypes';
import axios from 'axios';

const API_URL = 'http://localhost:9090/api';

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
                dispatch(fetchUnitsSuccess(res.data));
            })
            .catch(error => console.log(error));
    }
};
