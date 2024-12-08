<template>
  <div class="cell" :class="state.type">
    {{ state.symbol }}
  </div>
</template>

<script lang="ts">
import { defineComponent, PropType } from "vue";
import { CellState } from "@/types/CellState";

export default defineComponent({
  name: "Cell",
  props: {
    state: {
      type: Object as PropType<CellState>,
      required: true,
    },
  },
});
</script>

<style scoped>
.cell {
  display: inline-block;
  width: 30px;
  height: 30px;
  text-align: center;
  line-height: 30px;
  border: 1px solid #ccc;
}

.cell.fire {
  background-color: red;
}

.cell.tree {
  background-color: green;
}

.cell.ash {
  background-color: gray;
}
</style>
