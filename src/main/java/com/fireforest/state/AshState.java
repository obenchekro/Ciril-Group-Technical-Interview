
package com.fireforest.state;

import com.fireforest.entity.Cell;

public class AshState implements CellState {

    @Override
    public void handle(Cell cell, Cell[][] forest) {
    }

    @Override
    public void tryIgnite(Cell cell, double probability) {
        if (cell.shouldIgnite(probability)) {
            cell.setNextState(new FireState());
        }
    }

    @Override
    public String getSymbol() {
        return "⬛";
    }
}
