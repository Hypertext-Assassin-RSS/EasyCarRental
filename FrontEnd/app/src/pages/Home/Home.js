import React from 'react'
import AnimationButton from "../../Components/Button/AnimationButton";
import MyButton from "../../Components/Button/MyButton";
import '@fontsource/roboto/700.css';
import {Typography} from "@mui/material";
import "../Home/Home.css"
import { BsArrowRightCircle } from "react-icons/bs";
import QuickBook from "../../Components/QuikeBook/QuickBook";
import { MdSearch } from "react-icons/md";
import { Button } from '@material-ui/core';


const Home = () => {
  return (
    <div className="home-container">
        <div>
            <QuickBook/>
        </div>
      <div className={'home-background'}>
          <div className={'home-tittle-container'}>
              <div className='home-title'>
                  <h3>
                      Easy Car Rent
                  </h3>
              </div>
              <div className={'home-subtitle'}>
                  <h5>
                      Rent a Car Made Easy
                  </h5>
              </div>
          </div>
          <div className={'home-button-container'}>
          <Button variant="contained" startIcon={<BsArrowRightCircle/> } 
          style={{
            backgroundColor: "#4C22FF",
            color:'white'
        }}
          >Book Now</Button>
          </div>
      </div>
  </div>
  )
}
export default Home;