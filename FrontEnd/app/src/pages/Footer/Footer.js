import React from 'react'
import './Footer.css'
import { Typography }  from '@material-ui/core'
import '@fontsource/roboto/700.css';
import { MdFacebook } from "react-icons/md";
import { SiTwitter , SiGmail} from "react-icons/si";

const Footer = () => {
  return (
  <div className="footer">
    <div className='footer-container'>
      <div className='title-container'>
      <Typography variant="h4" gutterBottom>
        Easy Car Rental
      </Typography>
      <span>Car Rental System</span>
      </div>
      <div className='footer-link-container'>
        <div className='footer-link'>
          <a  href='#'>Services</a>
        </div>
        <div className='footer-link'>
          <a  href='#'>Contact</a>
        </div>
        <div className='social-icon-container'>
          <div className='social-icon'> <a  href='#'><MdFacebook /></a> </div>
          <div className='social-icon'> <a  href='#'><SiTwitter /></a></div>
          <div className='social-icon'> <a  href='#'><SiGmail /></a></div>
        </div>
      </div>
    </div>
    <div className='copy-right'>
      <span>Developed and maintained by © Rajith Sanjaya All right reserved</span>
    </div>
  </div>
  )
}
export default Footer;