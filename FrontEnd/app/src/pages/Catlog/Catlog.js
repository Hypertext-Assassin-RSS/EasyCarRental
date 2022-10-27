import React, { Component } from 'react';
import '../Catlog/Catlog.css';
import Car from '../../Components/Catlog/Car'
import { initialCars } from '../../resource/carsData';
import { additionalCars } from '../../resource/carsData';



class Catlog extends Component {
  constructor() {
    super();
    this.state = {
      cars: initialCars
    };
    this.loadAdditionalCars = this.loadAdditionalCars.bind(this);
    this.addCarToGallery = this.addCarToGallery.bind(this);
  }

  loadAdditionalCars() {
    var currentCars = { ...this.state.cars };
    var newCars = Object.assign(currentCars, additionalCars);
    this.setState({ cars: newCars });
  }

  addCarToGallery(car) {
    var ts = Date.now();
    var newCar = {};
    newCar['car' + ts] = car;
    var currentCars = { ...this.state.cars };
    var newCars = Object.assign(currentCars, newCar);
    this.setState({ cars: newCars });
  }

  render() {
    return (
      <div className="App">
        <div className="cars">
          {
            Object
              .keys(this.state.cars)
              .map(key => <Car key={key} meta={this.state.cars[key]} />)
          }
        </div>
        <div className="add-cars"><button onClick={this.loadAdditionalCars}>Load more...</button></div>
      </div>
    );
  }
}

export default Catlog;
