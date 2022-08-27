import React, {Component} from "react";
import {Button, Grid, MenuItem, Select, Typography} from "@mui/material";
import {FormControl, InputLabel, TextField} from "@material-ui/core";
import {DataGrid} from "@mui/x-data-grid";
import MySnackbar from "../../../Components/Snackbar/MySnackbar";
import Sidebar from "../../../Components/Sidebar/Sidebar";
import {ValidatorForm, TextValidator} from 'react-material-ui-form-validator';

class Car extends Component {
    constructor(props, context) {
        super(props, context);
        this.state = {
            formData: {
                type: "",
                color: "",
                extraMileagePrice: '',
                passengersCount: '',
                registrationNumber: "",
                transmissionType: "",
                fuelType: "",
                monthlyRate: '',
                freeMileage: '',
                brand: "",
                dailyRate: ''
            },
            open: false,
            message: '',
            severity: ''
        }
    }

    columns = [
        {field: 'id', headerName: 'RegistrationNumber', width: 200},
        {field: 'brand', headerName: 'Brand', width: 100},
        {field: 'type', headerName: 'Type', width: 100},
        {field: 'color', headerName: 'Color', width: 100,},
        {field: 'extraMileagePrice', headerName: 'ExtraMileagePrice', width: 150,},
        {field: 'passengersCount', headerName: 'PassengersCount', width: 150,},
        {field: 'transmissionType', headerName: 'TransmissionType', width: 150,},
        {field: 'fuelType', headerName: 'FuelType', width: 100,},
        {field: 'freeMileage', headerName: 'FreeMileage', width: 100,},
        {field: 'monthlyRate', headerName: 'Monthly Rate', width: 100,},
        {field: 'dailyRate', headerName: 'Daily Rate', width: 100,},
    ]

    rows = [
        {
            type: "Luxury",
            color: "Silver",
            extraMileagePrice: 120.0,
            passengersCount: 4,
            id: "CBZ-1775",
            transmissionType: "Auto",
            fuelType: "Petrol",
            monthlyRate: 150000.0,
            freeMileage: 15.0,
            brand: "Nisan",
            dailyRate: 17000.0
        }
    ]


    open = () => {
        this.setState({
            open: true,
            message: 'Test',
            severity: 'success'
        })
    }

    handleClose = (event, reason) => {
        if (reason === 'clickaway') {
            this.setState({
                open: false,
            })
        }
    }


    render() {
        return (
            <>
                <Sidebar/>
                <ValidatorForm
                    ref="form"
                    onSubmit={this.handleSubmit}
                    onError={errors => console.log(errors)}
                >
                    <Grid
                        container
                        direction="row"
                        justifyContent="space-evenly"
                        alignItems="center"
                        spacing={5}
                        paddingLeft={40}
                        paddingRight={10}
                        marginTop={-20}
                    >
                        <Grid item xs={12} sm={12} md={12} lg={12}>
                            <Typography variant="h3" gutterBottom>
                                Manage Car
                            </Typography>
                        </Grid>

                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <TextField id="outlined-basic" label="Registration Number" variant="outlined" fullWidth={true}/>
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <TextField id="outlined-basic" label="Brand" variant="outlined" fullWidth={true}/>
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <FormControl fullWidth>
                                <InputLabel id="demo-simple-select-label"></InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    value={this.state.type}
                                    label="Type"
                                    onChange={null}
                                >
                                    <MenuItem value={10}>Ten</MenuItem>
                                    <MenuItem value={20}>Twenty</MenuItem>
                                    <MenuItem value={30}>Thirty</MenuItem>
                                </Select>
                            </FormControl>
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <TextField id="outlined-basic" label="Color" variant="outlined" fullWidth={true}/>
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <TextField type='number' min='2' value={this.state.passengersCount} step='1' label={'Passengers Count'} onChange={null} variant={"outlined"} fullWidth={true}/>
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <FormControl fullWidth>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    value={this.state.transmissionType}
                                    label="Transmission Type"
                                    onChange={null}
                                >
                                    <MenuItem value={10}>Auto</MenuItem>
                                    <MenuItem value={20}>Manual</MenuItem>
                                </Select>
                            </FormControl>
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <FormControl fullWidth>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    value={this.state.fuelType}
                                    label={'Fuel Type'}
                                    onChange={null}
                                >
                                    <MenuItem value={10}>Petrol</MenuItem>
                                    <MenuItem value={20}>Diesel</MenuItem>
                                </Select>
                            </FormControl>
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <TextField id="outlined-basic" label="DailyRate" variant="outlined" fullWidth={true}/>
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <TextField id="outlined-basic" label="MonthlyRate" variant="outlined" fullWidth={true}/>
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <TextField id="outlined-basic" label="FreeMileage" variant="outlined" fullWidth={true}/>
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <TextField id="outlined-basic" label="ExtraMileagePrice" variant="outlined" fullWidth={true}/>
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <TextField id="outlined-basic" label="Outlined" variant="outlined" fullWidth={true}/>
                        </Grid>
                        <Grid item xs={12} sm={12} md={12} lg={12} display={"flex"} justifyContent={"flex-end"}>
                            <Button variant="contained"
                                    onClick={this.open}
                            >Save</Button>
                        </Grid>

                        <Grid item xs={12} sm={12} md={12} lg={12}>
                            <div style={{height: 400, width: '100%'}}>
                                <DataGrid
                                    rows={this.rows}
                                    columns={this.columns}
                                    pageSize={5}
                                    rowsPerPageOptions={[5]}
                                    checkboxSelection
                                />
                            </div>
                        </Grid>
                    </Grid>
                    <MySnackbar open={this.state.open} severity={this.state.severity} message={this.state.message}
                                handleClose={this.handleClose}/>
                </ValidatorForm>
            </>
        )
    }
}

export default Car