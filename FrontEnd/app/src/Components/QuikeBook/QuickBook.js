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
    }


    render() {
        return(
            <div className='quickbook-container'>
                <div className='item-container'>
                    <Typography variant="subtitle2" gutterBottom >
                        Pickup Location
                    </Typography>
                    <TextField id="standard-basic" label="" variant="outlined"  fullWidth={false} size={""}/>
                </div>
                <div className='item-container'>
                    <Typography variant="subtitle2" gutterBottom >
                        Pickup Date
                    </Typography>
                    <div className='item'>
                        <LocalizationProvider dateAdapter={AdapterDayjs} >
                            <DatePicker
                                label="Pickup Date"
                                value={null}
                                onChange={(newValue) => {

                                }}
                                renderInput={(params) => <TextField  {...params} variant={"outlined"} fullWidth={false} size={""}/>}
                            />
                            <TimePicker
                                label="Pickup Time"
                                value={null}
                                onChange={(newValue) => {

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
                                value={null}
                                onChange={(newValue) => {

                                }}
                                renderInput={(params) => <TextField {...params} variant={"outlined"} fullWidth={false} size={""}/>}
                            />
                            <TimePicker
                                label="Return Time"
                                value={null}
                                onChange={(newValue) => {

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
                    padding: "1rem 2rem"
                }}
                >Search</Button>
                </div>
            </div>
        )
    }
}

export default QuickBook