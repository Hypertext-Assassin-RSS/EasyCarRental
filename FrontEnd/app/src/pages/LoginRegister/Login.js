import React from "react";
import loginImg from "../../img/Login.jpg";
import "./Login.css"
import AnimationButton from "../../Components/Button/AnimationButton";
import {Link, Typography} from "@mui/material";
import '@fontsource/roboto/700.css';
import MyButton from "../../Components/Button/MyButton";
import {MdLogin} from "react-icons/md";
import {NavLink} from "react-router-dom";

export class Login extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="base-container" ref={this.props.containerRef}>
                <div className="header">
                    <Typography variant="h4" style={{top:'7rem'}} gutterBottom component="div">
                        Login
                    </Typography>
                </div>
                <div className="content">
                    <div className="image">
                        <img src={loginImg}  alt={'login.jpg'}/>
                    </div>
                    <div className="form">
                        <div className="form-group">
                            <label htmlFor="username">Username</label>
                            <input type="text" className={"input"} name="username" placeholder="username" />
                        </div>
                        <div className="form-group">
                            <label htmlFor="password">Password</label>
                            <input type="password" className={"input"} name="password" placeholder="password" />
                        </div>
                    </div>
                </div>
                <div className="footer">
                    <div className={'buttons'}>
                        <NavLink  to="/RentRequests" exact>
                            <AnimationButton
                                idleText={"Login"}
                            />
                        </NavLink>

                    </div>
                    <div className={'buttons'}>
                        <NavLink  to="/Register" exact>
                            <span>
                                <MyButton
                                    idleText={
                                        "Register"
                                    }
                                />
                            </span>
                        </NavLink>
                    </div>
                </div>
            </div>
        );
    }
}

export default Login
