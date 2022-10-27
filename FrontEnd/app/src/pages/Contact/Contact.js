import React from "react";
import { TextField, Typography } from "@mui/material";
import { MdAddCall, MdEmail, MdLocationPin } from "react-icons/md";
import InputUnstyled from '@mui/base/InputUnstyled';


import "./Contact.css";

const Contact = () => {
  return (
    <div className="container">
      <div className="title-container">
        <Typography
          variant="h3"
          fontWeight={"bolder"}
          gutterBottom
          component="div"
        >
          Contact
        </Typography>
      </div>
      <div className="conatct-message">
        <div className="contact-conatainer">
        
          <div className="connection">
            <div className="contact-icon-contaner">
              <MdAddCall className="contact-icon" />
            </div>
            <div className="contact-name-contaner">
              <Typography
                variant="h5"
                fontWeight={"bolder"}
                gutterBottom
                component="div"
                margin={0}
              >
                Call
              </Typography>
              {<span className="contact-details">0795901293</span>}
            </div>
          </div>
          <div className="connection">
            <div className="contact-icon-contaner">
              <MdEmail className="contact-icon" />
            </div>
            <div className="contact-name-contaner">
              <Typography
                variant="h5"
                fontWeight={"bolder"}
                gutterBottom
                component="div"
                margin={0}
              >
                Email
              </Typography>
              {<span className="contact-details">easycarrent.con.lk</span>}
            </div>
          </div>
          <div className="connection">
            <div className="contact-icon-contaner">
              <MdLocationPin className="contact-icon" />
            </div>
            <div className="contact-name-contaner">
              <Typography
                variant="h5"
                fontWeight={"bolder"}
                gutterBottom
                component="div"
                margin={0}
              >
                Address
              </Typography>
              {<span className="contact-details">No 69 Broad Road,Negambo</span>}
            </div>
          </div>
        
      </div>
      <div className="message-container">
        <div className="message-input-container">
          <div className="message-input-row">
          <div className="message-input">
            <span className="message-input-name">Name</span>
            <TextField id="standard-basic" label="" variant="standard" 
             InputProps={{
              disableUnderline: true,
            }}
            />
          </div>
          <div className="message-input">
            <span className="message-input-name">Contact</span>
            <TextField id="standard-basic" label="" variant="standard" 
             InputProps={{
              disableUnderline: true,
            }}
            />
          </div>
          </div>
          <div className="message-input">
          <span className="message-input-name">Project</span>
          <TextField id="standard-basic" label="" variant="standard" fullWidth='true'
           InputProps={{
            disableUnderline: true,
          }}
          />
          </div>
          <div className="message-input">
          <span className="message-input-name">Message</span>
          <TextField id="standard-basic" label="" multiline rows={5} variant="standard" fullWidth='true' 
           InputProps={{
            disableUnderline: true,
          }}
          />
          </div>
        </div>
      </div>
      </div>
      
    </div>
  );
};
export default Contact;
