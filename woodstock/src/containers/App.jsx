import React from 'react';
import PropTypes from 'prop-types';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import Header from '../components/Header';
import MainSection from '../components/MainSection';
import AppBarHeader from '../components/AppBarHeader';
import UnitList from '../components/UnitList';
import * as TodoActions from '../actions';

const App = ({todos, actions, units}) => (
    <div>
        <AppBarHeader/>
        {/*<Header addTodo={actions.addTodo}/>*/}
        {/*<MainSection todos={todos} actions={actions}/>*/}
        <UnitList units={units}/>
    </div>
);

App.propTypes = {
    todos: PropTypes.array.isRequired,
    actions: PropTypes.object.isRequired,
    units: PropTypes.array.isRequired
};

const mapStateToProps = state => ({
    todos: state.todos,
    units: state.units
});

const mapDispatchToProps = dispatch => ({
    actions: bindActionCreators(TodoActions, dispatch)
});

export default connect(mapStateToProps, mapDispatchToProps)(App)
