import React from 'react';
import {render} from 'react-dom';
import {applyMiddleware, createStore} from 'redux';
import {Provider} from 'react-redux';
import logger from 'redux-logger';
import App from './containers/App';
import rootReducer from './reducers';
import 'todomvc-app-css/index.css'

import './index.css';

const store = createStore(
    rootReducer,
    applyMiddleware(logger)
);

console.log(store.getState());

render(
    <Provider store={store}>
        <App/>
    </Provider>,
    document.getElementById('root')
);
