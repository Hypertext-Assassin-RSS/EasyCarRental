import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import {DataGrid} from "@mui/x-data-grid";
import MyButton from "../../../Components/Button/MyButton";




const columns = [
    {field: 'id', headerName: 'RequestCode', width: 100},
    {field: 'cusId', headerName: 'Customer Nic No', width: 130},
    {field: 'RegNo', headerName: 'Vehicle Registration Number', width: 205},
    {field: 'pickup', headerName: 'Pickup Date', type: 'number', width: 100,},
    {field: 'return', headerName: 'ReturnDate', width: 100,},
    {field: 'driverReq', headerName: 'Driver Need', width: 100}
];


const rows = [
    {id: 'RQ001', cusId: '200027301776', RegNo: 'BCW8035', pickup: '2022/08/01', return: '2022/08/07', driverReq: 'Yes'}

];


function DataTable() {
    return (
        <div>
            <div style={{height: '70vh', width: '100%'}}>
                <DataGrid
                    rows={rows}
                    columns={columns}
                    pageSize={5}
                    rowsPerPageOptions={[5]}
                    checkboxSelection
                />
            </div>
            <div>
                <MyButton
                    idleText={'Delete'}
                    color={'red'}
                />
            </div>
        </div>

    );
}

export default DataTable
