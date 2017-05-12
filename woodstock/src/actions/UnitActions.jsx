import * as types from '../constants/ActionTypes';
import FetchUnits from '../http/FetchUnits';

export const fetchUnitsSuccess = (units) => {
    return {type: types.FETCH_UNITS_SUCCESS, units}
};

export const fetchUnits = () => {
    return (dispatch) => {
        return FetchUnits
            .fetchUnits()
            .then(units => dispatch(fetchUnitsSuccess(units)))
            .catch(error => console.log(error));
    }
};

export const fetchUnitSuccess = (unit) => {
    return {type: types.FETCH_UNIT_SUCCESS, unit}
};

export const fetchUnit = (id) => {
    return (dispatch) => {
        return FetchUnits
            .fetchUnit(id)
            .then(unit => dispatch(fetchUnitSuccess(unit)))
            .catch(error => console.log(error));
    }
}
