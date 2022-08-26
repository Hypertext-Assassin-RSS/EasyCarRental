import React, {Component} from "react";
import {Button, Grid, Typography} from "@mui/material";
import {TextField} from "@material-ui/core";
import {DataGrid} from "@mui/x-data-grid";
import MySnackbar from "../../../Components/Snackbar/MySnackbar";
import Sidebar from "../../../Components/Sidebar/Sidebar";

class Car extends Component{
    constructor(props, context) {
        super(props, context);
        this.state = {
            formData:{
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
            open:false,
            message:'',
            severity:''
        }
    }

    columns = [
        { field: 'id', headerName: 'RegistrationNumber', width: 200 },
        { field: 'brand', headerName: 'Brand', width: 100 },
        { field: 'type', headerName: 'Type', width: 100 },
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
         {type: "Luxury", color: "Silver", extraMileagePrice: 120.0, passengersCount: 4, id: "CBZ-1775", transmissionType: "Auto", fuelType: "Petrol", monthlyRate: 150000.0, freeMileage: 15.0, brand: "Nisan", dailyRate: 17000.0}
        ]


    open = () => {
        this.setState({
            open:true,
            message:'Test',
            severity:'success'
        })
    }

    handleClose = (event, reason) => {
        if (reason === 'clickaway') {
            this.setState({
                open:false,
            })
        }
    }


    render() {
        return(
            <>
                <Sidebar/>
                <Grid
                    container
                    direction="row"
                    justifyContent="space-evenly"
                    alignItems="center"
                    spacing={5}
                    paddingLeft={35}
                    paddingRight={3}
                    marginTop={-15}
                >
                    <Grid item xs={12} sm={12} md={12} lg={12}>
                        <Typography variant="h3" gutterBottom>
                            Manage Car
                        </Typography>
                    </Grid>
                    <Grid item xs={12} sm={12} md={6} lg={2}>
                        <TextField id="outlined-basic" label="RegistrationNumber" variant="outlined" fullWidth={true}/>
                    </Grid>
                    <Grid item xs={12} sm={12} md={6} lg={2}>
                        <TextField id="outlined-basic" label="Brand" variant="outlined" fullWidth={true}/>
                    </Grid>
                    <Grid item xs={12} sm={12} md={6} lg={2}>
                        <TextField id="outlined-basic" label="Type" variant="outlined" fullWidth={true}/>
                    </Grid>
                    <Grid item xs={12} sm={12} md={6} lg={2}>
                        <TextField id="outlined-basic" label="Color" variant="outlined" fullWidth={true}/>
                    </Grid>
                    <Grid item xs={12} sm={12} md={6} lg={2}>
                        <TextField id="outlined-basic" label="PassengersCount" variant="outlined" fullWidth={true}/>
                    </Grid>
                    <Grid item xs={12} sm={12} md={6} lg={2}>
                        <TextField id="outlined-basic" label="TransmissionType" variant="outlined" fullWidth={true}/>
                    </Grid>
                    <Grid item xs={12} sm={12} md={6} lg={2}>
                        <TextField id="outlined-basic" label="FuelType" variant="outlined" fullWidth={true}/>
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
                        <div style={{ height: 400, width: '100%' }}>
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
                <MySnackbar open={this.state.open} severity={this.state.severity} message={this.state.message} handleClose={this.handleClose}/>
                </>
        )
    }
}

export default Car