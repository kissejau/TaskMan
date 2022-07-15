import axios from "axios";

const TASKS_API_URL = "http://localhost:8080/";
const REDIRECT_PAGE = "http://localhost:8081/"

class TasksService {
  getTasks() {
    return axios.get(TASKS_API_URL);
  }
  deleteTask(id) {
    var elements = document.getElementsByClassName(id)
    while (elements.length > 0)
      elements[0].parentNode.removeChild(elements[0]);
    const body = { data: { 'id': id } }
    axios.delete(TASKS_API_URL + "delete", body);
  }
  createTask(name, context) {
    const body = { 'name': name, 'context': context }
    axios.post(TASKS_API_URL + "add", body)
    window.location.href = REDIRECT_PAGE;
  }
  editTask(id) {
    const name = prompt("Enter new task name or skip:");
    const context = prompt("Enter new task context or skip:");
    const body = { 'id': id, 'name': name, 'context': context }
    axios.put(TASKS_API_URL + "update", body)
    this.getTasks();
    window.location.href = REDIRECT_PAGE;
  }
}

export default new TasksService();