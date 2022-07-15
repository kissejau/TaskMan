<template>
  <div id="app">
    <Tasks />
  </div>
</template>

<script>
import Tasks from "@/components/Tasks";

export default {
  name: 'App',
  components: {
    Tasks,
  }
}
</script>

<style>
#app {
  font-family: Hack, monospace;
  color: black;
}
</style>