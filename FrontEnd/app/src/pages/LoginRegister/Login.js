import React, {Component} from "react";
import loginImg from "../../img/Login.jpg";
import "./Login.css"
import AnimationButton from "../../Components/Button/AnimationButton";
import {Alert, Button, Link, Snackbar, Typography} from "@mui/material";
import '@fontsource/roboto/700.css';
import MyButton from "../../Components/Button/MyButton";
import {MdLogin} from "react-icons/md";
import {NavLink} from "react-router-dom";
import LoginRegisterServices from "../../Services/LoginRegisterServices";



export class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            account: {
                email: '',
                password: '',
            },
            email: '',
            password: '',

            open:false,
            message:'',
            severity:''
        }
    }


    handleClose = (event, reason) => {
        if (reason === 'clickaway') {
            this.setState({
                open:false
            })
        }
    }



    login =  async () => {
        let  account = this.state.account
        let response = await  LoginRegisterServices.login(account)
        console.log(response)
        if (response.status == 200){
            this.setState({
                open:true,
                message:response.data.message,
                severity:'success'
            })


        }else {
            this.setState({
                open:true,
                message:response.response.data.message,
                severity:'error'
            })
        }
    }




    render() {
        return (
            <div className="base-container">
                <div className="header">
                    <Typography variant="h4" style={{top: '7rem'}} gutterBottom component="div">
                        Login
                    </Typography>
                </div>
                <div className="content">
                    <div className="image">
                        <img src={loginImg} alt={'login.jpg'}/>
                    </div>
                    <div className="form">
                        <div className="form-group">
                            <label htmlFor="username">Email</label>
                            <input type="text" className={"input"} name="email" placeholder="Email"
                                   onChange={(e) => {
                                       let account = this.state.account
                                       account.email = e.target.value
                                       this.setState({account})
                                   }}
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="password">Password</label>
                            <input type="password" className={"input"} name="password" placeholder="password"
                                   onChange={(e) => {
                                       let account = this.state.account
                                       account.password = e.target.value
                                       this.setState({account})
                                   }}
                            />
                        </div>
                    </div>
                </div>
                <div className="footer">
                    <div className={'buttons'}>
                            <Button
                                variant={"contained"}
                                idleText={"Login"}
                                onClick={this.login}


                            >Login</Button>
                    </div>
                    <div className={'buttons'}>
                        <NavLink to="/Register" exact>
                            <span>

                            </span>
                        </NavLink>
                    </div>
                </div>
                <Snackbar open={this.state.open} autoHideDuration={6000} onClose={this.handleClose}>
                    <Alert onClose={this.handleClose} severity={this.state.severity} sx={{ width: '100%' }}>
                        {this.state.message}
                    </Alert>
                </Snackbar>
            </div>
        );
    }
}

export default Login
