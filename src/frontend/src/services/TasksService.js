import axios from "axios";

const TASKS_API_URL = "http://localhost:8080/";
const REDIRECT_PAGE = "http://localhost:8081/"

class TasksService {
  getTasks() {
    return axios.get(TASKS_API_URL);
  }
  deleteTask(id) {
    const body = { data: { 'id': id } }
    axios.delete(TASKS_API_URL + "delete", body);
  }
  createTask(name, context) {
    const body = { 'name': name, 'context': context }
    axios.post(TASKS_API_URL + "add", body)
    window.location.href = REDIRECT_PAGE;
  }
}

export default new TasksService();