import axios from "axios"

const User_API_BASE_URL = "http://localhost:8887/api/v1/user"


class UserService {

    getUser() {
        return axios.get(User_API_BASE_URL)
    }

}