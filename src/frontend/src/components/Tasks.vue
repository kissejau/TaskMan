<template>

  <div class="container-tasks">
    <table>
      <caption>ALL TASKS</caption>
      <thead>
        <th>task name</th>
        <th>task context</th>
        <th>task date</th>
        <th>delete</th>
      </thead>
      <tbody>
        <tr :class="task.id" v-for="task in tasks" v-bind:key="task.id">
          <td>{{ task.name }}</td>
          <td>{{ task.context }}</td>
          <td>{{ task.date }}</td>
          <td><button v-on:click="deleteTask(task.id)" :class="'btn-delete-' + task.id">Delete</button></td>
        </tr>
      </tbody>
    </table>
  </div>

</template>

<script>

import TasksService from "@/services/TasksService";
export default {
  name: "TasksList",
  data() {
    return {
      tasks: []
    }
  },
  methods: {
    getTasks() {
      TasksService.getTasks().then((response) => {
        this.tasks = response.data;
      })
    },
    deleteTask(id) {
      var elements = document.getElementsByClassName(id)
      while (elements.length > 0)
        elements[0].parentNode.removeChild(elements[0]);
      TasksService.deleteTask(id);
    }
  },
  created() {
    this.getTasks();
  }
}

</script>

<style>
.btn-delete {
  background: #DD2750;
  border: 1px solid #C43352;
}

table,
tr {
  border: 1px solid #F00;
  border-top: 1px solid #0F0;
}

table {
  text-align: left;
  position: relative;
  border-collapse: collapse;
  border: 1px, solid, black;
}

caption {
  color: rebeccapurple;
}

th {
  background: brown;
  color: white;
}

th,
tr {
  border-radius: 0;
  position: sticky;
  top: 0;
  padding: 10px;
}

td {
  padding: 20px;
}

.primary {
  background-color: #000000
}
</style>
