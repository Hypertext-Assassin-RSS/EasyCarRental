import React from 'react'
import './AdminLogin.css'
import InputUnstyled from '@mui/base/InputUnstyled';
import ButtonUnstyled from '@mui/base/ButtonUnstyled';


export default function AdminLogin() {
  return (
    <div className='admin-coantainer'>
      <div className='input-container'>
        <div className='input'><InputUnstyled /></div>
        <div className='input'><InputUnstyled /></div>
      </div>
      <div className='button-container'> 
      <ButtonUnstyled className='customer-btn'>
        <a href='/Dash'>
          Login
        </a>
        </ButtonUnstyled>
      </div>
      
    </div>
  )
}
