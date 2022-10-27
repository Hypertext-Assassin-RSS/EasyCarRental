import {Component} from "react";


import  './QuickBook.css'
import {TextField} from "@material-ui/core";
import {Button, Typography} from "@mui/material";
import {AdapterDayjs} from "@mui/x-date-pickers/AdapterDayjs";
import {DatePicker, LocalizationProvider, TimePicker} from "@mui/x-date-pickers";
import MyButton from "../Button/MyButton";
import { MdSearch } from "react-icons/md";

class QuickBook extends Component{

    constructor(props, context) {
        super(props, context);
        this.state = {
            
                location:'',
                pickupData:{
                    date:'',
                    time:''
                },
                returnData:{
                    date:'',
                    time:''
                },
            
        }
    }


    render() {
        return(
            <div className='quickbook-container'>
                <div className='item-container'>
                    <Typography variant="subtitle2" gutterBottom >
                        Pickup Location
                    </Typography>
                    <TextField id="standard-basic" label="" variant="outlined"  fullWidth={false} size={""} onChange={(e)=> {this.setState({location:e.target.value})}}/>
                </div>
                <div className='item-container'>
                    <Typography variant="subtitle2" gutterBottom >
                        Pickup Date
                    </Typography>
                    <div className='item'>
                        <LocalizationProvider dateAdapter={AdapterDayjs} >
                            <DatePicker
                                label="Pickup Date"
                                value={this.state.pickupData.date}
                                onChange={(newValue) => {
                                    let pickupData = this.state.pickupData
                                    pickupData.date = newValue.$d
                                    this.setState({pickupData})
                                }}
                                renderInput={(params) => <TextField  {...params} variant={"outlined"} fullWidth={false} size={""}/>}
                            />
                            <TimePicker
                                label="Pickup Time"
                                value={this.state.pickupData.time}
                                onChange={(newValue) => {
                                    let pickupData = this.state.pickupData
                                    pickupData.time = newValue
                                    this.setState({pickupData})
                                }}
                                renderInput={(params) => <TextField {...params} variant={"outlined"} fullWidth={false} size={""}/>}
                            />
                        </LocalizationProvider>
                    </div>

                </div>
                <div className='item-container'>
                    <Typography variant="subtitle2" gutterBottom>
                        Return Date
                    </Typography>
                    <div className='item'>
                        <LocalizationProvider dateAdapter={AdapterDayjs}>
                            <DatePicker
                                label="Return Date"
                                value={this.state.returnData.date}
                                onChange={(newValue) => {
                                    let returnData = this.state.returnData
                                    returnData.date = newValue.$d
                                    this.setState({returnData})
                                }}
                                renderInput={(params) => <TextField {...params} variant={"outlined"} fullWidth={false} size={""}/>}
                            />
                            <TimePicker
                                label="Return Time"
                                value={this.state.returnData.time}
                                onChange={(newValue) => {
                                    let returnData = this.state.returnData
                                    returnData.time = newValue
                                    this.setState({returnData})
                                }}
                                renderInput={(params) => <TextField {...params} variant={"outlined"} fullWidth={false} size={""}/>}
                            />
                        </LocalizationProvider>
                    </div>
                </div>
                <div className='button-container'>
                <Button variant="contained" startIcon={<MdSearch />} className='button'
                style={{
                    borderRadius: 35,
                    backgroundColor: "#4C22FF",
                    padding: ".5rem 2rem"
                }}
                onClick={() => {console.log(this.state)}}
                >Search</Button>
                </div>
            </div>
        )
    }
}

export default QuickBook