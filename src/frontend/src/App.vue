<template>
  <div id="app">
    <Tasks/>
  </div>
</template>

<script>
import Tasks from "@/components/Tasks";

export default {
  name: 'App',
  components: {
    Tasks
  }
}
</script>

<style>
#app {
  font-family: Hack, monospace;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: left;
  color: darkred;
  margin-top: 60px;
}
</style>