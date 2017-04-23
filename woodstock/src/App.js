import React from 'react';
import {createStore} from 'redux';
import TodoApp from './TodoApp';
import Counter from './components/Counter';
import counter from './reducers';
import logo from './logo.svg';
import './App.css';

const store = createStore(counter);

class App extends React.Component {
    render() {
        return (
            <div className="App">
                <div className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h2>Welcome to React!</h2>
                </div>
                <TodoApp/>
                <Counter value={store.getState()}
                         onIncrement={() => store.dispatch({type: 'INCREMENT'})}
                         onDecrement={() => store.dispatch({type: 'DECREMENT'})}/>
            </div>
        );
    }
}

export default App;
