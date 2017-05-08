import React, {Component} from 'react';
import AppBar from 'material-ui/AppBar';
import Drawer from 'material-ui/Drawer';
import MenuItem from 'material-ui/MenuItem';
import IconButton from 'material-ui/IconButton';
import NavigationMenu from 'material-ui/svg-icons/navigation/menu';

export default class AppBarHeader extends Component {
    constructor(props) {
        super(props);
        this.state = {open: false};
    }

    handleToggle = () => this.setState({open: !this.state.open});

    handleClose = () => this.setState({open: false});

    render() {
        return (
            <div>
                <AppBar
                    style={{position: 'fixed'}}
                    title="Woodstock"
                    iconElementLeft={
                        <IconButton>
                            <NavigationMenu onTouchTap={this.handleToggle}/>
                        </IconButton>
                    }
                    zDepth={1}/>

                <Drawer
                    docked={false}
                    width={200}
                    open={this.state.open}
                    onRequestChange={open => this.setState({open})}>
                    <MenuItem onTouchTap={this.handleClose}>Close</MenuItem>
                </Drawer>
            </div>
        )
    }
};
