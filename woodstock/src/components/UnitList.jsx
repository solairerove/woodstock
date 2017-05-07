import React, {Component} from 'react';
import PropTypes from 'prop-types';
import UnitItem from './UnitItem';

export default class UnitList extends Component {
    static propTypes = {
        units: PropTypes.array.isRequired
    };

    render() {
        const {units} = this.props;

        return (
            <section>
                <ul className="unit-list">
                    {
                        units.map(unit =>
                            <UnitItem unit={unit}/>
                        )
                    }
                </ul>
            </section>
        )
    }
}
