import React from 'react'
import Sidebar from "../../Components/Sidebar/Sidebar";
import BarChar from "./Dash/BarChar";
import LineChar from "./Dash/LinChar";
import PieChar from "./Dash/PieChar";
import "./Dash.css"

const Dash = () => {
    return (
        <div className="Dash-container">
            <Sidebar/>
            <div className={'chart-container'}>
                <div className={'row-one'}>
                    <div className={'booking-data'}>
                        <PieChar/>
                    </div>
                    <div className={'car-data'}>
                        <PieChar/>
                    </div>
                    <div className={'driver-data'}>
                        <PieChar/>
                    </div>
                    <div className={'car-maintain-data'}>
                        <PieChar/>
                    </div></div>
                <div className={'row-two'}>
                    <div className={'income-data'}>
                        <div><LineChar/></div>
                        <div><LineChar/></div>
                        <div><LineChar/></div>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default Dash;