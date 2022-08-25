import React from 'react';
import {
    BrowserRouter as Router,
    Route,
    Redirect,
    Switch
} from 'react-router-dom';

import About from './pages/About/About';
import Contact from './pages/Contact/Contact';
import Home from './pages/Home/Home';
import Services from './pages/Service/Services';
import Testimonial from './pages/Testimonial/Testimonial';
import Navbar from './Components/Navbar/Navbar';
import Login from "./pages/LoginRegister/Login";
import Register from "./pages/LoginRegister/Register";
import DenseTable from "./pages/Managment/Rent/RentRequests";
import Dash from "./pages/Managment/Dash";


const App = () => {
    return (
        <Router>

            <Navbar/>
            <main>
                <Switch>
                    <Route path="/" exact>
                        <Home/>
                    </Route>
                    <Route path="/about" exact>
                        <About/>
                    </Route>
                    <Route path="/service" exact>
                        <Services/>
                    </Route>
                    <Route path="/testimonial" exact>
                        <Testimonial/>
                    </Route>
                    <Route path="/contact" exact>
                        <Contact/>
                    </Route>
                    <Route path="/Login" exact>
                        <Login/>
                    </Route>
                    <Route path="/Register" exact>
                        <Register/>
                    </Route>
                    <Route path="/RentRequests" exact>
                        <DenseTable/>
                    </Route>
                    <Route path="/Dash" exact>
                        <Dash/>
                    </Route>
                    <Redirect to="/"/>
                </Switch>
            </main>
        </Router>
    );
}

export default App;
