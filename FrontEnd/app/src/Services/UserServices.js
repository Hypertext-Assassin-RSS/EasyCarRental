import axios from "../axios";

class UserServices{
    saveUserData = async (data) => {
        const promise = new Promise((resolve, reject)=>{
            axios.post('User',data)
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

export default new UserServices();