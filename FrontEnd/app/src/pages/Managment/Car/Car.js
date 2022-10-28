import React, {Component} from "react";
import {Button, Grid, MenuItem, Select, Typography} from "@mui/material";
import {FormControl, InputLabel, TextField} from "@material-ui/core";
import {DataGrid} from "@mui/x-data-grid";
import MySnackbar from "../../../Components/Snackbar/MySnackbar";
import Sidebar from "../../../Components/Sidebar/Sidebar";
import {ValidatorForm, TextValidator} from 'react-material-ui-form-validator';
import CarServices from "../../../Services/CarServices";
import './Car.css'

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
            severity: '',

            data:[]
        }
    }

    columns = [
        {field: 'registrationNumber', headerName: 'RegistrationNumber', width: 200},
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


    open = () => {
        console.log(this.state.formData)
        this.setState({
            open: true,
            message: 'Test',
            severity: 'success'
        })
    }


    handleSubmit = async () => {
        let formData = this.state.formData
        let response  = await CarServices.saveCar(formData);
        if (response.status == 201){
            this.setState({
                open:true,
                message:response.data.message,
                severity:"success"
            })
            this.loadData();
        }else {
            console.log(response)
            this.setState({
                open:true,
                message:response.response.data.message,
                severity:"error"
            })
        }
    }

    loadData = async () => {
        let response = await CarServices.getAllCar();
        if (response.status == 201) {
            this.setState({
                open: true,
                message: response.data.message,
                severity:"success",
                data:response.data.data
            })
            console.log(this.state.data)
        } else {
            this.setState({
                open: true,
                message: 'data load fail',
                severity:"error"
            })
        }
    }

    componentDidMount() {
        this.loadData();
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
                    style={styles.form}
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
                        <Grid item xs={12} sm={12} md={12} lg={12} >
                            <div className='car-titel'>
                              <h1>
                                Manage Car
                            </h1>  
                            </div>
                        </Grid>

                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <TextField id="outlined-basic" label="Registration Number" variant="outlined" fullWidth={true}
                                       onChange={(e) => {
                                           let formData = this.state.formData
                                           formData.registrationNumber = e.target.value
                                           this.setState({formData})
                                       }}
                            />
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <TextField id="outlined-basic" label="Brand" variant="outlined" fullWidth={true}
                                       onChange={(e) => {
                                           let formData = this.state.formData
                                           formData.brand = e.target.value
                                           this.setState({formData})
                                       }}
                            />
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <FormControl fullWidth>
                                <InputLabel id="demo-simple-select-label"></InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    value={this.state.type}
                                    label="Type"
                                    onChange={(e) => {
                                        let formData = this.state.formData
                                        formData.type = e.target.value
                                        this.setState({formData})
                                    }}
                                >
                                    <MenuItem value={'Luxury'}>Luxury</MenuItem>
                                    <MenuItem value={'Normal'}>Normal</MenuItem>

                                </Select>
                            </FormControl>
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <TextField id="outlined-basic" label="Color" variant="outlined" fullWidth={true}
                                       onChange={(e) => {
                                           let formData = this.state.formData
                                           formData.color = e.target.value
                                           this.setState({formData})
                                       }}
                            />
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <TextField type='number' min='2' value={this.state.passengersCount} step='1' label={'Passengers Count'}  variant={"outlined"} fullWidth={true}
                                       onChange={(e) => {
                                           let formData = this.state.formData
                                           formData.passengersCount = e.target.value
                                           this.setState({formData})
                                       }}
                            />
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <FormControl fullWidth>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    value={this.state.transmissionType}
                                    label="Transmission Type"
                                    onChange={(e) => {
                                        let formData = this.state.formData
                                        formData.transmissionType = e.target.value
                                        this.setState({formData})
                                    }}
                                >
                                    <MenuItem value={'Auto'}>Auto</MenuItem>
                                    <MenuItem value={'Manual'}>Manual</MenuItem>
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
                                    onChange={(e) => {
                                        let formData = this.state.formData
                                        formData.fuelType = e.target.value
                                        this.setState({formData})
                                    }}
                                >
                                    <MenuItem value={'Petrol'}>Petrol</MenuItem>
                                    <MenuItem value={'Diesel'}>Diesel</MenuItem>
                                </Select>
                            </FormControl>
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <TextField id="outlined-basic" label="DailyRate" variant="outlined" fullWidth={true}
                                       onChange={(e) => {
                                           let formData = this.state.formData
                                           formData.dailyRate = e.target.value
                                           this.setState({formData})
                                       }}
                            />
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <TextField id="outlined-basic" label="MonthlyRate" variant="outlined" fullWidth={true}
                                       onChange={(e) => {
                                           let formData = this.state.formData
                                           formData.monthlyRate = e.target.value
                                           this.setState({formData})
                                       }}
                            />
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <TextField id="outlined-basic" label="FreeMileage" variant="outlined" fullWidth={true}
                                       onChange={(e) => {
                                           let formData = this.state.formData
                                           formData.freeMileage = e.target.value
                                           this.setState({formData})
                                       }}
                            />
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            <TextField id="outlined-basic" label="ExtraMileagePrice" variant="outlined" fullWidth={true}
                                       onChange={(e) => {
                                           let formData = this.state.formData
                                           formData.extraMileagePrice = e.target.value
                                           this.setState({formData})
                                       }}
                            />
                        </Grid>
                        <Grid item xs={12} sm={12} md={6} lg={2}>
                            {/* <TextField id="outlined-basic" label="Outlined" variant="outlined" fullWidth={true}/> */}
                        </Grid>
                        <Grid item xs={12} sm={12} md={12} lg={12} display={"flex"} justifyContent={"flex-end"}>
                            <Button variant="contained"
                                    type={"submit"}
                            >Save</Button>
                        </Grid>

                        <Grid item xs={12} sm={12} md={12} lg={12}>
                            <div style={{height: 400, width: '100%'}}>
                                <DataGrid
                                    getRowId={(data) => data.registrationNumber }
                                    rows={this.state.data}
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


const styles = {
    form:{
        marginTop:'10rem'
    }
}