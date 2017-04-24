import React from 'react';
import logo from './logo.svg';
import './App.css';

import AddTodo from './containers/AddTodo';
import VisibleTodoList from './containers/VisibleTodoList';

const App = () => {
    return (
        <div className="App">
            <div className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <h2>Welcome to React!</h2>
            </div>
            <AddTodo/>
            <VisibleTodoList/>
        </div>
    )
};

export default App;
