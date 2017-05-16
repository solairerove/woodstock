import React from 'react';
import PropTypes from 'prop-types';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import AppBarHeader from '../components/AppBarHeader';
import UnitList from '../components/UnitList';
import * as UnitActions from '../actions/UnitActions';

const UnitsContainer = ({units, actions}) => (
    <div>
        <AppBarHeader/>
        <UnitList units={units} actions={actions}/>
    </div>
);

UnitsContainer.propTypes = {
    units: PropTypes.array.isRequired,
    actions: PropTypes.object.isRequired
};

const mapStateToProps = (state, ownProps) => {
    return {units: state.rootReducer.units};
};

const mapDispatchToProps = dispatch => ({
    actions: bindActionCreators(UnitActions, dispatch)
});

export default connect(mapStateToProps, mapDispatchToProps)(UnitsContainer)
