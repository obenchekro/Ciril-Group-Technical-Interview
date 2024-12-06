package com.fireforest.entity;

import com.fireforest.state.FireState;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.Data;

@Data
public class Forest {
    private final int height;
    private final int width;
    private final Cell[][] grid;

    public Forest(int height, int width) {
        this.height = height;
        this.width = width;
        this.grid = IntStream.range(0, height)
                .mapToObj(i -> IntStream.range(0, width)
                        .mapToObj(j -> new Cell(i, j))
                        .toArray(Cell[]::new))
                .toArray(Cell[][]::new);
    }

    public String[][] toSymbolGrid() {
        return Stream.of(grid)
                .map(row -> Stream.of(row)
                        .map(cell -> cell.getCurrentState().getSymbol())
                        .toArray(String[]::new))
                .toArray(String[][]::new);
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

    public void setInitialFire(int[][] firePositions) {
        for (int[] pos : firePositions) {
            grid[pos[0]][pos[1]].setCurrentState(new FireState());
        }
    }

    public void simulateStep() {
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                cell.handle(grid);
            }
        }

        for (Cell[] row : grid) {
            for (Cell cell : row) {
                cell.transitionToNextState();
            }
        }
    }

    public boolean hasFire() {
        return Arrays.stream(grid)
                .flatMap(Arrays::stream)
                .anyMatch(cell -> cell.getCurrentState() instanceof FireState);
    }
}
