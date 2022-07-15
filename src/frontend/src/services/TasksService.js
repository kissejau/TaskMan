import axios from "axios";

const TASKS_API_URL = "http://localhost:8080/";

class TasksService {
  getTasks() {
    return axios.get(TASKS_API_URL);
  }
  deleteTask(id) {
    const body = { data: { 'id': id } }
    axios.delete(TASKS_API_URL + "delete", body);
  }
}

export default new TasksService();