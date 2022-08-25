import React from 'react'
import AnimationButton from "../../Components/Button/AnimationButton";
import MyButton from "../../Components/Button/MyButton";
import '@fontsource/roboto/700.css';
import {Typography} from "@mui/material";
import "../Home/Home.css"
import { BsArrowRightCircle } from "react-icons/bs";

const Home = () => {
  return (
    <div className="home-container">
      <div className={'home-background'}></div>
        <div className={'home-tittle-container'}>
          <div className={'home-title'}>
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
        <MyButton
            rounded={true}
            size="large"
            idleText={
          <span>
            Book Now <BsArrowRightCircle/>
          </span>
          }
        />
      </div>

  </div>
  )
}
export default Home;