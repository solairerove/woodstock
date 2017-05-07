import React, {Component} from 'react';
import PropTypes from 'prop-types';

export default class UnitItem extends Component {
    static propTypes = {
        todo: PropTypes.object.isRequired
    };

    render() {
        const {todo} = this.props;

        const element = (
            <label>
                {todo.text}
            </label>
        );

        return (
            <li>
                {element}
            </li>
        )
    }
}
