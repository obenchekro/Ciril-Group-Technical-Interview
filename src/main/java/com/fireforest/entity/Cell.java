package com.fireforest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fireforest.state.CellState;
import com.fireforest.state.TreeState;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

public class Cell {
    @Getter
    private final int x;
    @Getter
    private final int y;
    @Getter
    @Setter
    private CellState currentState;
    @JsonIgnore
    @Setter
    private CellState nextState;
    private static final Random random = new Random();

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.currentState = new TreeState();
        this.nextState = null;
    }

    public void transitionToNextState() {
        if (nextState != null) {
            currentState = nextState;
            nextState = null;
        }
    }

    public void handle(Cell[][] forest, double probability) {
        currentState.handle(this, forest, probability);
    }

    public boolean shouldIgnite(double probability) {
        return random.nextDouble() < probability;
    }
}
