import React from 'react';
import PropTypes from 'prop-types';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import AppBarHeader from '../components/AppBarHeader';
import UnitList from '../components/UnitList';
import * as UnitActions from '../actions/UnitActions';

const App = ({actions, units}) => (
    <div>
        <AppBarHeader/>
        <UnitList units={units}/>
    </div>
);

App.propTypes = {
    actions: PropTypes.object.isRequired,
    units: PropTypes.array.isRequired
};

const mapStateToProps = state => ({
    units: state.units
});

const mapDispatchToProps = dispatch => ({
    actions: bindActionCreators(UnitActions, dispatch)
});

export default connect(mapStateToProps, mapDispatchToProps())(App)
