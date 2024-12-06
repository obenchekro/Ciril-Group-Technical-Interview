
package com.fireforest.state;

import com.fireforest.entity.Cell;

public interface CellState {
    void handle(Cell cell, Cell[][] forest);
    String getSymbol();
    void tryIgnite(Cell cell, double probability);
}
