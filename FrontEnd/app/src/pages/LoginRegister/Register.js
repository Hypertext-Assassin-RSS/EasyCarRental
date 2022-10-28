import React from "react";
import registerImg from "../../img/Register.jpg";
import AnimationButton from "../../Components/Button/AnimationButton";
import { Alert, Button, Snackbar, Typography } from "@mui/material";
import "@fontsource/roboto/700.css";
import { ValidatorForm, TextValidator } from "react-material-ui-form-validator";
import AccountServices from "../../Services/AccountServices";
import { ImUserPlus } from "react-icons/im";

export class Register extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      accountData: {
        id: "",
        email: "",
        password: "",
      },
    };
  }

  handleClose = (event, reason) => {
    if (reason === "clickaway") {
      this.setState({
        open: false,
      });
    }
  };

  handleSubmit = async () => {
    console.log(this.state.accountData);
    let accountData = this.state.accountData;
    let response = await AccountServices.createAccount(accountData);
    if (response.status == 201) {
      this.setState({
        open: true,
        message: response.data.message,
        severity: "success",
      });
    } else {
      this.setState({
        open: true,
        message: response.data.message,
        severity: "error",
      });
    }
  };

  render() {
    return (
      <div className="base-container" ref={this.props.containerRef}>
        <ValidatorForm
          ref="form"
          onSubmit={this.handleSubmit}
          onError={(errors) => console.log(errors)}
        >
          <div className="header">
            {/* <Typography variant="h5" gutterBottom component="div">
                            Register
                        </Typography> */}
          </div>
          <div className="content">
            <div className="image">
              <img
                src={registerImg}
                style={{ paddingBottom: "3rem" }}
                alt={"Register.jpg"}
              />
            </div>

            <div className="form">
              <div className="form-group">
                <label htmlFor="username">Nic Number</label>
                <TextValidator
                  type="text"
                  name="id"
                  placeholder=""
                  value={this.state.accountData.id}
                  errorMessages={["this field is required"]}
                  validators={["required"]}
                  onChange={(e) => {
                    let accountData = this.state.accountData;
                    accountData.id = e.target.value;
                    this.setState({ accountData });
                  }}
                  variant="standard"
                  size={"small"}
                />
              </div>
              <div className="form-group">
                <label htmlFor="email">Email</label>
                <TextValidator
                  type="text"
                  name="email"
                  placeholder=""
                  value={this.state.accountData.email}
                  errorMessages={["this field is required"]}
                  validators={["required"]}
                  onChange={(e) => {
                    let accountData = this.state.accountData;
                    accountData.email = e.target.value;
                    this.setState({ accountData });
                  }}
                  variant="standard"
                  size={"small"}
                />
              </div>
              <div className="form-group">
                <label htmlFor="password">Password</label>
                <TextValidator
                  type="password"
                  name="password"
                  placeholder=""
                  value={this.state.accountData.password}
                  errorMessages={["this field is required"]}
                  validators={["required"]}
                  onChange={(e) => {
                    let accountData = this.state.accountData;
                    accountData.password = e.target.value;
                    this.setState({ accountData });
                  }}
                  variant="standard"
                  size={"small"}
                />
              </div>
            </div>
          </div>
          <div className="login-footer">
            <Button
              variant={"contained"}
              type="submit"
              style={{
                backgroundColor: "#4C22FF",
                color: "white",
              }}
            >
              <span>
                Register    <ImUserPlus />
              </span>
            </Button>
          </div>
          <Snackbar
            open={this.state.open}
            autoHideDuration={6000}
            onClose={this.handleClose}
          >
            <Alert
              onClose={this.handleClose}
              severity={this.state.severity}
              sx={{ width: "100%" }}
            >
              {this.state.message}
            </Alert>
          </Snackbar>
        </ValidatorForm>
      </div>
    );
  }
}

export default Register;
