import React from "react";
import PropTypes from "prop-types";
import {} from 'react-router';
import {GridList, GridTile} from "material-ui/GridList";
import Paper from 'material-ui/Paper';
import IconButton from "material-ui/IconButton";
import BookAction from "material-ui/svg-icons/action/book";

const styles = {
    root: {
        padding_top: 20,
        display: 'flex',
        flexWrap: 'wrap',
        justifyContent: 'space-around'
    },
    gridList: {
        width: 640,
        overflowY: 'auto',
        overflowX: 'auto'
    }
};

const UnitList = ({units, actions}) => {
    return (
        <div style={styles.root}>
            <Paper zDepth={2}>
                <GridList
                    cols={2}
                    cellHeight={200}
                    style={styles.gridList}
                    padding={0}>
                    {units.map(unit => (
                            <GridTile key={unit.id}
                                      title={unit.label}
                                      actionIcon={
                                          <IconButton>
                                              <BookAction color="white"/>
                                          </IconButton>
                                      }
                                      cols={unit.featured ? 2 : 1}
                                      rows={unit.featured ? 2 : 1}>
                                <img src={unit.avatar} alt=""/>
                            </GridTile>
                        )
                    )}
                </GridList>
            </Paper>
        </div>
    );
};

UnitList.propTypes = {
    units: PropTypes.array.isRequired,
    actions: PropTypes.object.isRequired
};

const activePost = (id) => {
    this.actions.fetchUnit(id);
};

export default UnitList;
