<template>
  <div class="simulation">
    <button @click="initialize">Initialize</button>
    <button @click="nextStep">Next Step</button>
    <Grid v-if="grid" :grid="grid.grid" />
  </div>
</template>

<script lang="ts">
import { defineComponent, ref } from "vue";
import { fireForestApi } from "@/api/fireForestApi";
import { Grid } from "@/types/CellState";
import GridComponent from "@/components/Grid.vue";

export default defineComponent({
  name: "SimulationView",
  components: { Grid: GridComponent },
  setup() {
    const grid = ref<Grid | null>(null);

    const initialize = async () => {
      grid.value = await fireForestApi.initializeForest();
    };

    const nextStep = async () => {
      if (grid.value) {
        grid.value = await fireForestApi.simulateStep();
      }
    };

    return { grid, initialize, nextStep };
  },
});
</script>

<style scoped>
.simulation {
  padding: 20px;
}

button {
  margin: 5px;
  padding: 10px;
}
</style>
