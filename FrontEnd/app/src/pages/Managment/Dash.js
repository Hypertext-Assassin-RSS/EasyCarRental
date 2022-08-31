import React, {Component} from 'react'
import Sidebar from "../../Components/Sidebar/Sidebar";
import BarChar from "./Dash/BarChar";
import LineChar from "./Dash/LinChar";
import PieChar from "./Dash/PieChar";
import "./Dash.css"
import { Chart as ChartJS, ArcElement, Tooltip, Legend } from 'chart.js';
import { Pie } from 'react-chartjs-2';

class Dash extends Component {
    constructor(props, context) {
        super(props, context);
    }

    data = {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [
            {
                label: '# of Votes',
                data: [12, 19, 3, 5, 2, 3],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)',
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)',
                ],
                borderWidth: 1,
            },
        ],
    };

    render() {
        return (
            <div className="Dash-container">
                <Sidebar/>
                <div className={'chart-container'}>
                    <div className={'row-one'}>
                        <div className={'booking-data'}>
                            <PieChar/>
                        </div>
                        <div className={'car-data'}>
                            <Pie data={this.data} />
                        </div>
                        <div className={'driver-data'}>
                            <PieChar/>
                        </div>
                        <div className={'car-maintain-data'}>
                            <PieChar/>
                        </div>
                    </div>
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

}
export default Dash;