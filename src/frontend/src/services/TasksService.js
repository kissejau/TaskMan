import axios from "axios";

const TASKS_API_URL = "http://localhost:8080/";

class TasksService {
  getTasks() {
    return axios.get(TASKS_API_URL);
  }
}

export default new TasksService();