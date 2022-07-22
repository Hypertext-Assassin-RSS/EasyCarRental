import React from 'react';
import '../../App.css';
import './Home.css'
import {Button, Checkbox, FormControlLabel, TextField} from "@mui/material";
import Date from "../../components/Datepicker/Date";
import Typography from '@mui/material/Typography';
import {IoChatboxEllipses, IoSearchCircleSharp} from "react-icons/io5";
import {AiOutlineSafety} from "react-icons/ai";
import {MdOutlineMoneyOffCsred, MdPayment} from "react-icons/md";
import {pink} from "@mui/material/colors";



export default function Home() {
    return (
    <div className='home'>
        <div className='container'>
            <div className='book'>
                <div>
                    <Typography variant="button" display="block" gutterBottom>
                        Location
                    </Typography>
                    <div className='item'>
                        <TextField id="standard-basic"  variant="standard"/>
                    </div>
                </div>
                <div className='check_box'>
                    <FormControlLabel control={<Checkbox  />} label="Driver"  sx={{
                        color: "black",
                        '&.Mui-checked': {
                            color: "green",
                        },
                    }}    />
                </div>
                <div>
                    <Typography variant="button" display="block" gutterBottom>
                        Pick-up date
                    </Typography>
                    <Date/>
                </div>
                <div >
                    <Typography variant="button" display="block" gutterBottom>
                        Return date
                    </Typography>
                    <Date/>
                </div>
                <div>
                    <Button variant="contained" startIcon={<IoSearchCircleSharp/>}>Search</Button>
                </div>
            </div>
            <div className='description'>
                <div className='description_title'>
                    <Typography variant="h4" gutterBottom component="div">
                        Why book with us?
                    </Typography>
                </div>

                <div className='description_item_container'>
                    <div className='description_item'>
                        <div className='icon'>
                            <IoChatboxEllipses/>
                        </div>
                        <Typography variant="h6" gutterBottom component="div">
                            24/7 customer support
                        </Typography>
                    </div>
                    <div className='description_item'>
                        <div className='icon'>
                            <AiOutlineSafety/>
                        </div>
                        <Typography variant="h6" gutterBottom component="div">
                            Secure online payment
                        </Typography>
                    </div>
                    <div className='description_item'>
                        <div className='icon'>
                            <MdPayment/>
                        </div>
                        <Typography variant="h6" gutterBottom component="div">
                            Free cancellation
                        </Typography>
                    </div>
                    <div className='description_item'>
                        <div className='icon'>
                            <MdOutlineMoneyOffCsred/>
                        </div>
                        <Typography variant="h6" gutterBottom component="div">
                            No hidden charges
                        </Typography>
                    </div>
                </div>
            </div>
        </div>
    </div>
        /*<h1 className='home' style={{color:"gray"}}>Easy Car Rental</h1>*/
    );
}
