import React from 'react';
import PropTypes from 'prop-types';
import {connect} from 'react-redux';
import AppBarHeader from '../components/AppBarHeader';
import UnitList from '../components/UnitList';
import * as UnitActions from '../actions/UnitActions';

const UnitsContainer = ({units, actions}) => (
    <div>
        <AppBarHeader/>
        <UnitList units={units}/>
    </div>
);

UnitsContainer.propTypes = {
    units: PropTypes.array.isRequired,
    actions: PropTypes.object.isRequired
};

const mapStateToProps = state => ({units: state.rootReducer.units});

const mapDispatchToProps = dispatch => ({
    actions: bindActionCreators(UnitActions, dispatch)
});

export default connect(mapStateToProps, mapDispatchToProps)(UnitsContainer)
