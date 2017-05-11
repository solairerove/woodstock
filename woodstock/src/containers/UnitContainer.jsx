import React from 'react';
import PropTypes from 'prop-types';
import {connect} from 'react-redux';
import AppBarHeader from '../components/AppBarHeader';
import UnitDetails from '../components/UnitDetails';

const UnitContainer = ({unit}) => (
    <div>
        <AppBarHeader/>
        <UnitDetails unit={unit}/>
    </div>
);

UnitContainer.propTypes = {
    unit: PropTypes.object.isRequired
};

const mapStateToProps = (state, props) => {
    const id = '591055117ed4cb05c4e0a40f';
    console.log(state);
    const unit = Object.assign({}, state.rootReducer.units.find(unit => unit.id === id));
    return {unit: unit}
};

export default connect(mapStateToProps)(UnitContainer)
