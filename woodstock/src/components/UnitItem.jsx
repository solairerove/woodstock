import React, {Component} from 'react';
import PropTypes from 'prop-types';

export default class UnitItem extends Component {
    static propTypes = {
        unit: PropTypes.object.isRequired
    };

    render() {
        const {unit} = this.props;

        return (
            <li>
                <label>
                    {unit.label}
                </label>
            </li>
        )
    }
}
