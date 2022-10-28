import React, {Component} from 'react'
import {Grid, Paper} from "@mui/material";
import '@fontsource/roboto/700.css';
import "../Service/Services.css"
import { Typography }  from '@material-ui/core'

class Services extends Component{
  constructor(props, context, register) {
    super(props, context);
    }
  render() {
    return (
        <div className="services-container">
          <div className='services-title-container'>
          <h1>We Offer</h1>
          </div>
            <div className={'services-model-container'}>
                <Grid sx={{ flexGrow: 1 }} container spacing={2}>
                    <Grid item xs={12}>
                        <Grid container justifyContent="center" spacing={3}>
                            <Grid item display={"flex"} flexDirection={"row"}>
                                <Paper
                                    sx={{
                                        height: "max-content",
                                        width: "width: 30%;",
                                        backgroundColor: (theme) =>
                                            theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
                                    }}
                                >
                                    <div className={'services-model'}>
                                    <div className={'services-model-one'} >

                                    </div>
                                    <div className={'services-model-description'}>
                                        <div className={'services-model-title'}>
                                            <Typography variant="h6" fontWeight={"bolder"} gutterBottom component="div">
                                                Weddings
                                            </Typography>
                                        </div>
                                        <div className={'services-model-subtitle'}>
                                            <Typography variant="caption" display="block" gutterBottom>
                                                All the need of you dream vehicle in your wedding day
                                            </Typography>
                                        </div>
                                    </div>
                                </div>
                                </Paper>
                            </Grid>
                            <Grid item display={"flex"} flexDirection={"row"}>
                                <Paper
                                    sx={{
                                        height: "max-content",
                                        width: "width: 30%;",
                                        backgroundColor: (theme) =>
                                            theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
                                    }}
                                >
                                    <div className={'services-model'}>
                                        <div className={'services-model-two'} >

                                        </div>
                                        <div className={'services-model-description'}>
                                            <div className={'services-model-title'}>
                                                <Typography variant="h6" fontWeight={"bolder"} gutterBottom component="div">
                                                   Road Trip
                                                </Typography>
                                            </div>
                                            <div className={'services-model-subtitle'}>
                                                <Typography variant="caption" display="block" gutterBottom>
                                                    A holiday road trip for you and yor family
                                                </Typography>
                                            </div>
                                        </div>
                                    </div>
                                </Paper>
                            </Grid>
                            <Grid item display={"flex"} flexDirection={"row"}>
                                <Paper
                                    sx={{
                                        height: "max-content",
                                        width: "width: 30%;",
                                        backgroundColor: (theme) =>
                                            theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
                                    }}
                                >
                                    <div className={'services-model'}>
                                        <div className={'services-model-three'} >

                                        </div>
                                        <div className={'services-model-description'}>
                                            <div className={'services-model-title'}>
                                                <Typography variant="h6" fontWeight={"bolder"} gutterBottom component="div">
                                                    Tourism
                                                </Typography>
                                            </div>
                                            <div className={'services-model-subtitle'}>
                                                <Typography variant="caption" display="block" gutterBottom>
                                                    Welcome to see any location any time you desire
                                                </Typography>
                                            </div>
                                        </div>
                                    </div>
                                </Paper>
                            </Grid>
                        </Grid>
                    </Grid>
                </Grid>


            </div>
        </div>
    )
  }


}
export default Services;