import axios from "axios"

const QUESTION_API_BASE_URL = "http://localhost:8887/api/v1/questions"

class QuestionsService {

    getAllQuestions() {
        return axios.get(QUESTION_API_BASE_URL)
    }
}

export default new QuestionsService()