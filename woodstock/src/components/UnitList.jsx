import React, {Component} from 'react';
import PropTypes from 'prop-types';
import {GridList, GridTile} from 'material-ui/GridList';
import IconButton from 'material-ui/IconButton';
import Subheader from 'material-ui/Subheader';
import BookAction from 'material-ui/svg-icons/action/book';
import Paper from 'material-ui/Paper';
import UnitItem from './UnitItem';

const styles = {
    root: {
        display: 'flex',
        flexWrap: 'wrap',
        justifyContent: 'space-around',
    },
    gridList: {
        width: 500,
        height: 450,
        overflowY: 'auto',
    },
};

export default class UnitList extends Component {
    static propTypes = {
        units: PropTypes.array.isRequired
    };

    render() {
        const {units} = this.props;

        // const element = (
        //     units.map(unit =>
        //         <UnitItem key={unit.id}
        //                   unit={unit}/>
        //     )
        // );

        // return (
        //     <section>
        //         <ul className="unit-list">
        //             {element}
        //         </ul>
        //     </section>
        // )

        return (

            <div style={styles.root}>
                <GridList
                    cellHeight={250}
                    style={styles.gridList}
                    padding={1}>
                    <Subheader>Units</Subheader>
                    {units.map(unit =>
                        <GridTile key={unit.id}
                                  title={unit.label}
                                  subtitle={
                                      <span>
                                          by <b>solairerove</b>
                                      </span>
                                  }
                                  actionIcon={
                                      <IconButton>
                                          <BookAction color="white"/>
                                      </IconButton>
                                  }>
                            <img src={unit.avatar}/>
                        </GridTile>
                    )}
                </GridList>
            </div>
        );
    }
}
