import React from 'react'
import {Checkbox, Divider, Grid, Select, Typography} from "@mui/material";
import Button from "../../Components/controls/Button";
import {FormControlLabel} from "@material-ui/core";
import '@fontsource/roboto/700.css';
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import "./Register.css"
import "../../img/Register.jpg"
import MyButton from "../../Components/Button/MyButton";
import {NavLink} from "react-router-dom";

function Register(props) {
    const {fullName, email, mobile, address, nic, lic, gender, date, subscribe, handleSubmit} = props;

    const genders = [
        {label: 'Male'},
        {label: 'Female'}
    ]

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
            <form  onSubmit={handleSubmit}>
                <div className={'background'}></div>
                <Grid container spacing={{xs: 2, md: 3}} columns={{xs: 4, sm: 8, md: 12}}>
                    <Grid item xs={2} sm={4} md={4}>
                        <TextField type="text" id="outlined-basic" name="fullName" variant="outlined" label="Full Name"
                                   fullWidth={true}/>
                    </Grid>
                    <Grid item xs={2} sm={4} md={4}>
                        <TextField type="text" id="outlined-basic" variant="outlined" fullWidth={true} label="Email"
                                   name="email"/>

                    </Grid>
                    <Grid item xs={2} sm={4} md={4}>
                        <TextField type="text" id="outlined-basic" variant="outlined" fullWidth={true} label="Mobile"
                                   name="mobile"/>

                    </Grid>
                    <Grid item xs={2} sm={4} md={4}>
                        <TextField type="text" id="outlined-basic" variant="outlined" fullWidth={true} label="Address"
                                   name="Address"/>
                    </Grid>
                    <Grid item xs={2} sm={4} md={4}>
                        <Autocomplete
                            disablePortal
                            id="combo-box-demo"
                            options={genders}
                            renderInput={(params) => <TextField {...params} label="Gender"/>}
                        />
                    </Grid>
                    <Grid item xs={2} sm={4} md={4} style={{zIndex:"1"}}>
                        <FormControlLabel control={<Checkbox defaultChecked/>} label="Subscribe for Special Deals" defaultChecked={true}/>
                    </Grid>
                    <Grid item xs={2} sm={4} md={4}>
                        <div className={'buttons-container'}>
                            <Button
                                type="submit"
                                text="Submit"/>
                            <Button
                                text="Reset"
                                color="default"
                                /*onClick={resetForm}*/ />
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
                                <Typography variant="h7"  gutterBottom component="div">
                                    Already have account</Typography>
                            </div>
                            <div>
                                <NavLink  to="/Login" exact>
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
            </form>
        </div>
    )
}

export default Register;