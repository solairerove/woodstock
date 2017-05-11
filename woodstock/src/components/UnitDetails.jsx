import React from 'react';
import {
    Card,
    CardActions,
    CardHeader,
    CardMedia,
    CardTitle,
    CardText
} from 'material-ui/Card';
import FlatButton from 'material-ui/FlatButton';
import PropTypes from 'prop-types';

const UnitDetails = ({unit}) => {
    return (
        <Card>
            <CardHeader title={unit.label} subtitle="Some subtitle"/>
            
            <CardMedia
                overlay={<CardTitle title="title" subtitle="overlay subtitle"/>}>
                <img src={unit.avatar} width="240" height="320" alt=""/>
            </CardMedia>

            <CardText>
                {unit.description}
            </CardText>

            <CardActions>
                <FlatButton label="Action"/>
            </CardActions>
        </Card>
    );
}

UnitDetails.propTypes = {
    unit: PropTypes.object.isRequired
};

export default UnitDetails;
