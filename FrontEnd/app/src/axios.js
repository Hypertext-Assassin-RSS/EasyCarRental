import axios from "axios";

const instance = axios.create({

    baseURL:'http://localhost:8080/BackEnd_war/api/v1/'

})

export default instance;