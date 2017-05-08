import React from 'react';
import {render} from 'react-dom';
import {applyMiddleware, createStore} from 'redux';
import thunk from 'redux-thunk';
import {Provider} from 'react-redux';
import logger from 'redux-logger';
import injectTapEventPlugin from 'react-tap-event-plugin'
import App from './containers/App';
import rootReducer from './reducers';
import 'todomvc-app-css/index.css'
import * as UnitActions from './actions/UnitActions';

import './index.css';

injectTapEventPlugin();

const store = createStore(
    rootReducer,
    applyMiddleware(thunk, logger)
);

store.dispatch(UnitActions.fetchUnits());

console.log(store.getState());

render(
    <Provider store={store}>
        <App/>
    </Provider>,
    document.getElementById('root')
);
