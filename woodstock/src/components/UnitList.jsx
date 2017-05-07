import React, {Component} from 'react';
import PropTypes from 'prop-types';
import UnitItem from './UnitItem';

export default class UnitList extends Component {
    static propTypes = {
        units: PropTypes.array.isRequired
    };

    render() {
        const {units} = this.props;

        const element = (
            units.map(unit =>
                <UnitItem key={unit.id}
                          unit={unit}/>
            )
        );

        return (
            <section>
                <ul className="unit-list">
                    {element}
                </ul>
            </section>
        )
    }
}
