package com.fireforest.state;

import com.fireforest.entity.Cell;

public class TreeState implements CellState {

    @Override
    public void handle(Cell cell, Cell[][] forest, double probability) {}

    @Override
    public String getSymbol() {
        return "🌲";
    }

    @Override
    public void tryIgnite(Cell cell, double probability) {
        if (cell.shouldIgnite(probability)) {
            cell.setNextState(new FireState());
        }
    }
}
