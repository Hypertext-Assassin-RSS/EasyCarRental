import React, { useEffect, useState } from "react";
import "./Request.css";
import { Button, Checkbox, Grid, TextField } from "@material-ui/core";
import CarServices from "../../Services/CarServices";
import { Autocomplete } from "@mui/material";
import FormControlLabel from "@mui/material/FormControlLabel";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { DatePicker } from "@mui/x-date-pickers/DatePicker";

export default function Request() {
  const [data, setData] = useState([]);
  const [checked, setChecked] = useState(true);
  const [pickupDate, setPickupDate] = useState(null);
  const [returnDate, setReturnDate] = useState(null);
  const [vehicleNo, setVehicleNo] = useState(null)
  const [address, setAddress] = useState('')

  const defaultProps = {
    options: data,
    getOptionLabel: (option) => option.registrationNumber,
  };

  const flatProps = {
    options: data.map((option) => option.title),
  };

  const handleChange = (event) => {
    setChecked(event.target.checked);
  };

  const load = async () => {
    let response = await CarServices.getAllCar();
    if (response.status == 201) {
      setData(response.data.data);
    }
  };

  useEffect(() => {
    load();
  }, []);

  const sendReq = () =>{
    let sendData = {registrationNumber:vehicleNo,driverRequest:checked,pickupAddress:address,pickupDate:pickupDate,returnDate:returnDate}
    console.log("Data",sendData)
  }

  return (
    <div className="request-container">
      <Grid
        container
        direction="row"
        justifyContent="center"
        alignItems="center"
        spacing={2}
      >
        <Grid item>
          <Autocomplete
            {...defaultProps}
            id="disable-clearable"
            disableClearable
            sx={{ width: 200 }}
            inputValue={vehicleNo}
            onInputChange={(event, newInputValue) => {
              setVehicleNo(newInputValue);
            }}
            renderInput={(params) => (
              <TextField {...params} label="Vehicle No" variant="standard" />
            )}
          />
        </Grid>
        <Grid item>
          <TextField
            id="standard-basic"
            label="Pickup Address"
            variant="standard"
            onChange={(newValue) =>{
              setAddress(newValue)}}
          />
        </Grid>
        <Grid item>
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DatePicker
              label="Pikup Date"
              value={pickupDate}
              onChange={(newValue) => {
                setPickupDate(newValue);
              }}
              renderInput={(params) => <TextField {...params} />}
            />
          </LocalizationProvider>
        </Grid>
        <Grid item>
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DatePicker
              label="Return Date"
              value={returnDate}
              onChange={(newValue) => {
                setReturnDate(newValue);
              }}
              renderInput={(params) => <TextField {...params} />}
            />
          </LocalizationProvider>
        </Grid>
        <Grid item lg={2}>
          <FormControlLabel
            control={
              <Checkbox
                checked={checked}
                onChange={handleChange}
                inputProps={{ "aria-label": "controlled" }}
              />
            }
            label="Need Driver"
          />
        </Grid>
        <Grid item>
          <Button variant="outlined"
          onClick={() => {sendReq()}}
          >
            Send
          </Button>
        </Grid>
      </Grid>
    </div>
  );
}
