/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 22
 **/

import React, { useState } from "react";
import "react-modern-calendar-datepicker/lib/DatePicker.css";
import DatePicker from "react-modern-calendar-datepicker";

const Date = () => {
    const [selectedDay, setSelectedDay] = useState(null);

    const renderCustomInput = ({ ref }) => (
        <input
            readOnly
            ref={ref} // necessary
            placeholder=""
            value={selectedDay ? `${selectedDay.year} : ${selectedDay.month} : ${selectedDay.day}` : ''}
            style={{
                textAlign: 'center',
                padding: '0.5rem 1rem',
                fontSize: '1rem',
                border: '1px solid #9c88ff',
                borderRadius: '10px',
                boxShadow: '0 1rem 1.5rem rgba(156, 136, 255, 0.2)',
                color: '#9c88ff',
                outline: 'none',
                zIndex:'0'
            }}
            className="my-custom-input-class" // a styling class
        />
    )

    return (
        <DatePicker
            value={selectedDay}
            onChange={setSelectedDay}
            inputPlaceholder="Select a day"
            renderInput={renderCustomInput}
            shouldHighlightWeekends
        />
    );
};

export default Date;