export type CellType = "fire" | "tree" | "ash";

export interface CellState {
  type: CellType;
  symbol: string;
}

export interface Cell {
  x: number;
  y: number;
  currentState: CellState;
}

export interface Grid {
  height: number;
  width: number;
  grid: Cell[][];
}
