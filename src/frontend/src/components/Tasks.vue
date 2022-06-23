<template>
  <div class="container">
    <h1 class="text-container">ALL TASKS:</h1>
    <table>
      <thead>
      <th>task name</th>
      <th>task context</th>
      <th>task date</th>
      </thead>
      <tbody>
      <tr v-for="task in tasks" v-bind:key="task.id">
        <td>{{ task.name }}</td>
        <td>{{ task.context }}</td>
        <td>{{ task.date }}</td>
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
    }
  },
  created() {
    this.getTasks();
  }
}
</script>

<style>
</style>
