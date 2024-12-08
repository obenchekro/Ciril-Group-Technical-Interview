package com.fireforest.state;

import com.fireforest.entity.Cell;

public class AshState implements CellState {

    @Override
    public void handle(Cell cell, Cell[][] forest, double probability) {}

    @Override
    public void tryIgnite(Cell cell, double probability) {}

    @Override
    public String getSymbol() {
        return "⬛";
    }
}
