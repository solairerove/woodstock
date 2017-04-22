import React from 'react';
import TodoApp from './TodoApp';
import logo from './logo.svg';
import './App.css';

class App extends React.Component {
    render() {
        return (
            <div className="App">
                <div className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h2>Welcome to React!</h2>
                </div>
                <TodoApp/>
            </div>
        );
    }
}

export default App;
