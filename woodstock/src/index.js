import React from 'react';
import {render} from 'react-dom';
import {createStore} from 'redux';
import {Provider} from 'react-redux';
import App from './containers/App';
import rootReducer from './reducers';
import 'todomvc-app-css/index.css'

import './index.css';

const store = createStore(
    rootReducer,
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
);

console.log(store.getState());

render(
    <Provider store={store}>
        <App/>
    </Provider>,
    document.getElementById('root')
);
