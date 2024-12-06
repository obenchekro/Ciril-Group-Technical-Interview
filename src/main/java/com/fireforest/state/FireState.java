
package com.fireforest.state;

import com.fireforest.entity.Cell;

public class FireState implements CellState {

    @Override
    public void handle(Cell cell, Cell[][] forest) {
        cell.setNextState(new AshState());

        int x = cell.getX();
        int y = cell.getY();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < forest.length && ny >= 0 && ny < forest[0].length) {
                Cell neighbor = forest[nx][ny];
                neighbor.getCurrentState().tryIgnite(neighbor, 0.3);
            }
        }
    }

    @Override
    public String getSymbol() {
        return "🔥";
    }

    @Override
    public void tryIgnite(Cell cell, double probability) {
        if (cell.shouldIgnite(probability)) {
            cell.setNextState(new FireState());
        }
    }
}
