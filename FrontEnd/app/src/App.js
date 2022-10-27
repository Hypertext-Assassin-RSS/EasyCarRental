import React from "react";
import {
  BrowserRouter as Router,
  Route,
  Redirect,
  Switch,
} from "react-router-dom";
import "./App.css";

import About from "./pages/About/About";
import Contact from "./pages/Contact/Contact";
import Home from "./pages/Home/Home";
import Services from "./pages/Service/Services";
import Catlog from "./pages/Catlog/Catlog";
import Navbar from "./Components/Navbar/Navbar";
import Login from "./pages/LoginRegister/Login";
import Register from "./pages/LoginRegister/Register";
import DenseTable from "./pages/Managment/Rent/RentRequests";
import Dash from "./pages/Managment/Dash";
import LoginRegister from "./pages/LoginRegister/LoginRegister";
import UserData from "./pages/UserData/UserData";
import Car from "./pages/Managment/Car/Car";
import Footer from "./pages/Footer/Footer";

const App = () => {
  return (
    <Router>
      <Navbar />
      <main>
        <Switch>
          <Route path="/" exact>
            <div className="App">
              <Home />
              <About />
              <Services />
              <Contact />
              <Footer />
            </div>
          </Route>
          <Route path="/about" exact>
            <About />
          </Route>
          <Route path="/service" exact>
            <Services />
          </Route>
          <Route path="/catlog" exact>
            <Catlog />
          </Route>
          <Route path="/contact" exact>
            <Contact />
          </Route>
          <Route path="/Login" exact>
            <LoginRegister />
          </Route>
          <Route path="/Register" exact>
            <Register />
          </Route>
          <Route path="/RentRequests" exact>
            <DenseTable />
          </Route>
          <Route path="/Dash" exact>
            <Dash />
          </Route>
          <Route path="/UserData" exact>
            <UserData />
          </Route>
          <Route path="/Car" exact>
            <Car />
          </Route>
          <Redirect to="/" />
        </Switch>
      </main>
    </Router>
  );
};

export default App;
