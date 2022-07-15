<template>

    <div class="container-taskConstructor">
        <input id="input-name" type="text" placeholder="task name">
        <br>
        <input id="input-context" type="text" placeholder="task context">
        <br>
        <button class="btn-add" v-on:click="addTask()">add</button>
    </div>

</template>

<script>
import TasksService from "@/services/TasksService"

export default {
    name: "TaskConstructor",
    methods: {
        addTask() {
            var name = document.getElementById('input-name').value;
            var context = document.getElementById('input-context').value;
            TasksService.createTask(name, context);
        }
    }
}
</script>

<style>
.container-taskConstructor {
    margin-top: 20px;
}

.btn-add {
    background: rgb(33, 189, 33);
    border: 1px solid #043102;
}
</style>
