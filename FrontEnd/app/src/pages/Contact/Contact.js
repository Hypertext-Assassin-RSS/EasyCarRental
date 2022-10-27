import React from "react";
import { Typography } from "@mui/material";
import { MdAddCall, MdEmail, MdLocationPin } from "react-icons/md";

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
      <div className="contact-conatainer">
        <div className="connection-conatiner">
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
              {<span>0795901293</span>}
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
              {<span>easycarrent.con.lk</span>}
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
              {<span>No 69 Broad Road,Negambo</span>}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
export default Contact;
