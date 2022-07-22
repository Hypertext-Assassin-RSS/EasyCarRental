import React from 'react';
import Navbar from './components/Navbar/Navbar';
import './App.css';
import Home from './pages/home/Home';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Services from './pages/services/Services';
import Products from './pages/product/Products';
import ContactUs from './pages/contact/ContactUs';
import SignUp from './pages/sign/SignUp';

function App() {
  return (
    <Router>
      <Navbar />
      <Switch>
        <Route path='/' exact component={Home} />
        <Route path='/services' component={Services} />
        <Route path='/products' component={Products} />
        <Route path='/contact-us' component={ContactUs} />
        <Route path='/sign-up' component={SignUp} />
      </Switch>
    </Router>
  );
}

export default App;
