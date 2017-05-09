import React from 'react';
import PropTypes from 'prop-types';
import {connect} from 'react-redux';
import AppBarHeader from '../components/AppBarHeader';
import UnitList from '../components/UnitList';

const App = ({units}) => (
    <div>
        <AppBarHeader/>
        <UnitList units={units}/>
    </div>
);

App.propTypes = {
    units: PropTypes.array.isRequired
};

const mapStateToProps = state => ({
    units: state.rootReducer.units
});

export default connect(mapStateToProps)(App)
