import axios from "../axios";

class AccountServices {
    createAccount = async (data) => {
        const promise = new Promise((resolve, reject) =>{
            axios.post('Account',data)
                .then((res) =>{
                    return resolve(res)
                })
                .catch((err)=>{
                    return resolve("Error :"+err)
                })
        })
        return await promise;
    }
}

export default new AccountServices();