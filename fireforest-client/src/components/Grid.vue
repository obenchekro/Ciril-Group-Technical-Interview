<template>
  <div class="grid">
    <div v-for="(row, rowIndex) in grid" :key="rowIndex" class="row">
      <Cell v-for="cell in row" :key="`${cell.x}-${cell.y}`" :state="cell.currentState" />
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, PropType } from "vue";
import { Cell } from "@/types/CellState";
import CellComponent from "@/components/Cell.vue";

export default defineComponent({
  name: "Grid",
  components: { Cell: CellComponent },
  props: {
    grid: {
      type: Array as PropType<Cell[][]>,
      required: true,
    },
  },
});
</script>

<style scoped>
.grid {
  display: flex;
  flex-direction: column;
}

.row {
  display: flex;
}
</style>
