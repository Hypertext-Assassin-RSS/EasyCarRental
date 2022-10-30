import React, { Component, useState } from "react";
import loginImg from "../../img/Login.jpg";
import "./Login.css";
import AnimationButton from "../../Components/Button/AnimationButton";
import { Alert, Button, Link, Snackbar, Typography } from "@mui/material";
import "@fontsource/roboto/700.css";
import MyButton from "../../Components/Button/MyButton";
import { MdLogin } from "react-icons/md";
import { NavLink } from "react-router-dom";
import LoginRegisterServices from "../../Services/LoginRegisterServices";
import { useHistory } from "react-router-dom";


export default function Login() {

  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')

  const [tempEmail, setTempEmail] = useState('')
  const [tempPassword, setTempPassword] = useState('')

  const [open, setOpen] = useState('')
  const [message, setMessage] = useState('')
  const [severity, setSeverity] = useState('')

  const history = useHistory();


  function handleClose(event,reason) {
    if (reason === "clickaway") {
      setOpen(false)
    }
  }

  async function login()  {
    let account = {email:email,password:password}

    console.log(account)

    let response = await LoginRegisterServices.login(account);
    console.log(response);
    if (response.status == 200) {
        setSeverity('success')
        setMessage(response.data.message)
        setOpen(true)

        history.push("/Request")
      
    } else {
      setSeverity('error')
      setMessage(response.response.data.message)
      setOpen(true)
    }
  }

  

    return (
      <div className="base-container">
        <div className="header">
          {/* <Typography variant="h4" style={{top: '7rem'}} gutterBottom component="div">
                        Login
                    </Typography> */}
        </div>
        <div className="content">
          <div className="image">
            <img src={loginImg} alt={"login.jpg"} />
          </div>
          <div className="form">
            <div className="form-group">
              <label htmlFor="username">Email</label>
              <input
                type="text"
                className={"input"}
                name="email"
                placeholder="Email"
                onChange={(e) => {
                  setEmail(e.target.value)
                }}
              />
            </div>
            <div className="form-group">
              <label htmlFor="password">Password</label>
              <input
                type="password"
                className={"input"}
                name="password"
                placeholder="password"
                onChange={(e) => {
                 setPassword(e.target.value)
                }}
              />
            </div>
          </div>
        </div>
        <div className="login-footer">
          <div className={"buttons"}>
            <Button
              style={{
                backgroundColor: "#4C22FF",
                color: "white",
              }}
              variant={"contained"}
              idleText={"Login"}
              onClick={login}
            >
              Login <MdLogin />
            </Button>
          </div>
          <div className={"buttons"}>
            <NavLink to="/Register" exact>
              <span></span>
            </NavLink>
          </div>
        </div>
        <Snackbar
          open={open}
          autoHideDuration={6000}
          onClose={handleClose}
        >
          <Alert
            onClose={handleClose}
            severity={severity}
            sx={{ width: "100%" }}
          >
            {message}
          </Alert>
        </Snackbar>
      </div>
    );
  
}



