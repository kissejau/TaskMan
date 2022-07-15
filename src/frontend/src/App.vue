<template>
  <div id="app">
    <Tasks />
    <TaskConstructor />
  </div>
</template>

<script>
import Tasks from "@/components/Tasks";
import TaskConstructor from "@/components/TaskConstructor.vue";

export default {
  name: 'App',
  components: {
    Tasks,
    TaskConstructor
  }
}
</script>

<style>
#app {
  font-family: Hack, monospace;
  color: black;
}
</style>