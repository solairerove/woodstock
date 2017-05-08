import React, {Component} from 'react';
import {Card, CardActions, CardHeader, CardMedia, CardTitle, CardText} from 'material-ui/Card';
import FlatButton from 'material-ui/FlatButton';
import PropTypes from 'prop-types';

export default class UnitItem extends Component {
    static propTypes = {
        unit: PropTypes.object.isRequired
    };

    render() {
        const {unit} = this.props;

        return (
            <Card>
                <CardHeader
                    title={unit.label}
                    subtitle="Some subtitle"
                    avatar={unit.avatar}/>
                <CardMedia overlay={
                    <CardTitle title="title" subtitle="overlay subtitle"/>
                }>
                    <img src={unit.avatar} width="240" height="320"/>
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
}
