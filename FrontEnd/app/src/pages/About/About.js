import React from 'react'
import {Typography} from "@mui/material";
import "../About/About.css"
import '@fontsource/roboto/700.css';

const About = () => {
  return (
    <div className="About-container">
        <div className={'About-Description-container'}>
            <div className={'About-title'}>
                <h1>
                    Lots of Options For Low Price
                </h1>
            </div>
            <div className={'About-Description-Description'}>
                <h5>
                    Get register today and exclusive offer that cancel ride without getting charged any fees.
                </h5>
            </div>
        </div>
        <div className={'About-image-container'}>
            <div className={'About-image'}>

            </div>
        </div>
    </div>
  )
}
export default About;