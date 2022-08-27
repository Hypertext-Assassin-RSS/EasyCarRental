import axios from "../axios";

class CarServices {
    saveCar = async (data) => {
        const promise = new Promise((resolve, reject) => {
            axios.post('Car',data)
                .then((res) => {
                    return resolve(res)
                })
                .catch((err) => {
                    return resolve(err)
                })
        })
        return await promise
    }

    getAllCar = async (data) => {
        const promise = new Promise((resolve, reject) => {
            axios.get('Car')
                .then((res) => {
                    return resolve(res)
                })
                .catch((err) => {
                    return resolve(err)
                })
        })
        return await promise
    }
}

export default new CarServices();