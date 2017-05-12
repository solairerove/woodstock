import React from 'react';
import {render} from 'react-dom';
import {Route, Switch} from 'react-router';

import {applyMiddleware, combineReducers, createStore} from 'redux';
import {Provider} from 'react-redux';
import thunk from 'redux-thunk';
import logger from 'redux-logger';

import createHistory from 'history/createBrowserHistory';
import {ConnectedRouter, routerMiddleware, routerReducer} from 'react-router-redux';

import injectTapEventPlugin from 'react-tap-event-plugin';
import ligthBaseTheme from 'material-ui/styles/baseThemes/lightBaseTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import getMuiTheme from 'material-ui/styles/getMuiTheme';

import Home from './components/Home';
import UnitsContainer from './containers/UnitsContainer';
import UnitContainer from './containers/UnitContainer';

import rootReducer from './reducers';

import * as UnitActions from './actions/UnitActions';

import './index.css';

// Material UI
injectTapEventPlugin();

// React Router
const history = createHistory();
const reduxRouteMiddleware = routerMiddleware(history);

// Redux
const store = createStore(combineReducers({rootReducer, router: routerReducer}), applyMiddleware(thunk, logger, reduxRouteMiddleware));

store.dispatch(UnitActions.fetchUnits());
console.log(store.getState());
render(
    <MuiThemeProvider muiTheme={getMuiTheme(ligthBaseTheme)}>
    <Provider store={store}>
        <ConnectedRouter history={history}>
            <Switch>
                <Route exact path='/' component={UnitsContainer}/>
                <Route path='/home' component={Home}/>
                <Route path='/units/:id' component={UnitContainer}/>
            </Switch>
        </ConnectedRouter>
    </Provider>
</MuiThemeProvider>, document.getElementById('root'));
