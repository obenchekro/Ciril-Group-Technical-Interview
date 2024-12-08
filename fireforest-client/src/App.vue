<template>
  <SimulationView />
</template>

<script lang="ts">
import { defineComponent } from "vue";
import SimulationView from "@/views/SimulationView.vue";

export default defineComponent({
  name: "App",
  components: { SimulationView },
});
</script>

<style>
body {
  font-family: Arial, sans-serif;
}
</style>
