import React from 'react';
import {render} from 'react-dom';
import {applyMiddleware, createStore} from 'redux';
import thunk from 'redux-thunk';
import {Provider} from 'react-redux';
import logger from 'redux-logger';

import injectTapEventPlugin from 'react-tap-event-plugin'
import ligthBaseTheme from 'material-ui/styles/baseThemes/lightBaseTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import getMuiTheme from 'material-ui/styles/getMuiTheme';

import App from './containers/App';
import rootReducer from './reducers';

import * as UnitActions from './actions/UnitActions';

import './index.css';

injectTapEventPlugin();

const store = createStore(
    rootReducer,
    applyMiddleware(thunk, logger)
);

store.dispatch(UnitActions.fetchUnits());

render(
    <MuiThemeProvider muiTheme={getMuiTheme(ligthBaseTheme)}>
        <Provider store={store}>
            <App/>
        </Provider>
    </MuiThemeProvider>,
    document.getElementById('root')
);
