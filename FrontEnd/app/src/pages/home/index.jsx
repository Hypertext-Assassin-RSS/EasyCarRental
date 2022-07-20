/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 20
 **/
import React from 'react';
import {Component} from "react";
import styleSheet from "./style";
import { withStyles } from "@mui/styles";
import {Button, Typography} from "@material-ui/core";


class Home extends Component{
    constructor(props, context) {
        super(props, context);
    }

    render() {
        const {classes} = this.props
        return(
            <div className={classes.container}>
                <Typography variant="h4" gutterBottom component="div">
                    Home
                </Typography>
            </div>

        )
    }
}

export default withStyles(styleSheet)(Home);