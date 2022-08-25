import axios from "../axios";


class LoginRegisterServices {
    login = async (data) => {
        const promise = new Promise((resolve, reject) => {
            axios.get('Account',{params:{email:data.email, password:data.password}})
                .then((res) => {
                    return resolve(res)
                })
                .catch((err)=>{
                    return resolve(err)
                })

        })
        return await promise;
    }
}

export default  new LoginRegisterServices();