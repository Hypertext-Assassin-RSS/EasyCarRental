import React, {Component} from 'react'
import {Alert, Checkbox, Divider, Grid, MenuItem, Select, Snackbar, Typography} from "@mui/material";
import Button from "../../Components/controls/Button";
import {FormControlLabel} from "@material-ui/core";
import '@fontsource/roboto/700.css';
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import "../../img/Register.jpg"
import MyButton from "../../Components/Button/MyButton";
import {NavLink} from "react-router-dom";
import {ValidatorForm, TextValidator} from 'react-material-ui-form-validator';
import AccountServices from "../../Services/AccountServices";
import UserServices from "../../Services/UserServices";

class UserData extends Component {
    constructor(props, context) {
        super(props, context);
        this.state = {
            formData: {
                name: '',
                contact: '',
                address: '',
                id: '',
                licenseNo: '',
                registerDate: new Date().toISOString().slice(0, 10)
            },
            open:false,
            message:'',
            severity:''
        }
    }


    componentDidMount() {
        //this.getDate()
        console.log(this.state.formData.registerDate)

    }

    /*getDate = () => {
        let todayDate =
        let formData = this.state.formData
        formData.registerDate = todayDate
        this.setState({formData})
        console.log(this.state.formData.registerDate)
    }*/


    subscribe = () => {

    }
    handleSubmit = async () => {
        let formData = this.state.formData
        let response  = await UserServices.saveUserData(formData);
        if (response.status == 201){
            this.setState({
                open:true,
                message:'saved',
                severity:"success"
            })
        }else {
            this.setState({
                open:true,
                message:'error',
                severity:"error"
            })
        }
    }
    genders = [
        {label: 'Male'},
        {label: 'Female'}
    ]

    handleClose = (event, reason) => {
        if (reason === 'clickaway') {
            this.setState({
                open:false,
            })
        }
    }

    setGender = (event) => {
        this.setState({
            gender:event.target.value
        })
    }

    render() {
        return (
            <div className="container">
                <div style={{marginBottom: "1rem"}}>
                    <div>
                        <Typography variant="h5" gutterBottom component="div">
                            Customer Register
                        </Typography>
                    </div>
                    <Divider light/>
                </div>
                <ValidatorForm
                    ref="form"
                    onSubmit={this.handleSubmit}
                    onError={errors => console.log(errors)}
                >
                    <div className={'background'}></div>
                    <Grid container spacing={{xs: 2, md: 3}} columns={{xs: 4, sm: 8, md: 12}}>
                        <Grid item xs={2} sm={4} md={4}>
                            <TextValidator type="text" id="outlined-basic" name="name" variant="outlined"
                                           value={this.state.formData.name}
                                           errorMessages={['this field is required']}
                                           validators={['required']}
                                           label="Full Name"
                                           fullWidth={true}
                                           onChange={(e) => {
                                               let formData = this.state.formData
                                               formData.name = e.target.value
                                               this.setState({formData})
                                           }}
                            />
                        </Grid>
                        <Grid item xs={2} sm={4} md={4}>
                            <TextValidator type="text" id="outlined-basic" variant="outlined" fullWidth={true}
                                           value={this.state.formData.contact}
                                           errorMessages={['this field is required']}
                                           validators={['required', 'isNumber']}
                                           label="Mobile"
                                           name="mobile"
                                           onChange={(e) => {
                                               let formData = this.state.formData
                                               formData.contact = e.target.value
                                               this.setState({formData})
                                           }}
                            />

                        </Grid>
                        <Grid item xs={2} sm={4} md={4}>
                            <TextValidator type="text" id="outlined-basic" variant="outlined" fullWidth={true}
                                           value={this.state.formData.address}
                                           errorMessages={['this field is required']}
                                           validators={['required']}
                                           label="Address"
                                           name="address"
                                           onChange={(e) => {
                                               let formData = this.state.formData
                                               formData.address = e.target.value
                                               this.setState({formData})
                                           }}
                            />
                        </Grid>
                        <Grid item xs={2} sm={4} md={4}>
                            <TextValidator type="text" id="outlined-basic" variant="outlined" fullWidth={true}
                                           value={this.state.formData.id}
                                           errorMessages={['this field is required']}
                                           validators={['required']}
                                           label="Nic Number"
                                           name="id"
                                           onChange={(e) => {
                                               let formData = this.state.formData
                                               formData.id = e.target.value
                                               this.setState({formData})
                                           }}
                            />

                        </Grid>
                        <Grid item xs={2} sm={4} md={4}>
                            <TextValidator type="text" id="outlined-basic" variant="outlined" fullWidth={true}
                                           value={this.state.formData.licenseNo}
                                           errorMessages={['this field is required']}
                                           validators={['required']}
                                           label="Lic Number"
                                           name="lic"
                                           onChange={(e) => {
                                               let formData = this.state.formData
                                               formData.licenseNo = e.target.value
                                               this.setState({formData})
                                           }}
                            />

                        </Grid>
                       {/* <Grid item xs={2} sm={4} md={4}>
                            <Select
                                labelId="demo-simple-select-label"
                                id="demo-simple-select"
                                value={this.state.formData.gender}
                                label="Gender"
                                fullWidth={true}
                                onChange={(e) => {
                                    let formData = this.state.formData
                                    formData.gender = e.target.value
                                    this.setState({formData})
                                }}
                            >
                                <MenuItem value={'male'}>Male</MenuItem>
                                <MenuItem value={'female'}>Female</MenuItem>
                            </Select>
                        </Grid>*/}
                        <Grid item xs={2} sm={4} md={4} style={{zIndex: "1"}}>
                            <FormControlLabel control={<Checkbox defaultChecked/>} label="Subscribe for Special Deals"
                                              defaultChecked={true}/>
                        </Grid>
                        <Grid item xs={2} sm={4} md={4}>
                            <div className={'buttons-container'}>
                                <Button
                                    type="submit"
                                    text="Submit"/>
                                <Button
                                    text="Reset"
                                    color="default"
                                />
                            </div>
                        </Grid>
                    </Grid>
                    <Grid container spacing={{xs: 2, md: 3}} columns={{xs: 1, sm: 1, md: 1}}>
                        <Grid item xs={2} sm={4} md={4}>
                            <div style={{display: "flex", flexDirection: "row"}}>
                                <div className={'file'}>
                                    <TextField type="text" id="outlined-basic" variant="outlined" label="Nic No"/>
                                </div>
                                <div className={'file'}>
                                    <TextField type="file" id="outlined-basic" variant="outlined"/>
                                </div>

                            </div>
                        </Grid>
                        <Grid item xs={2} sm={4} md={4}>
                            <div style={{display: "flex", flexDirection: "row"}}>
                                <div className={'file'}>
                                    <TextField type="text" id="outlined-basic" variant="outlined"
                                               label="Driving License number"/>
                                </div>
                                <div className={'file'}>
                                    <TextField type="file" id="outlined-basic" variant="outlined"/>
                                </div>

                            </div>
                        </Grid>
                        <Grid item xs={2} sm={4} md={4}>
                            <div>
                                <Button
                                    type="submit"
                                    text="Submit"/>
                                <Button
                                    text="Reset"
                                    color="default"/>
                            </div>
                        </Grid>
                        <Grid item xs={2} sm={4} md={4}>
                            <div className={'loginModel'}>
                                <div className={'loginItem'}>
                                    <Typography variant="h7" gutterBottom component="div">
                                        Already have account</Typography>
                                </div>
                                <div>
                                    <NavLink to="/Login" exact>
                            <span>
                                <MyButton
                                    idleText={
                                        "Login"
                                    }
                                />
                            </span>
                                    </NavLink>
                                </div>
                            </div>
                        </Grid>
                    </Grid>
                    <Snackbar open={this.state.open} autoHideDuration={6000} onClose={this.handleClose}>
                        <Alert onClose={this.handleClose} severity={this.state.severity} sx={{ width: '100%' }}>
                            {this.state.message}
                        </Alert>
                    </Snackbar>
                </ValidatorForm>
            </div>
        )
    }

}

export default UserData;