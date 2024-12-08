package com.fireforest.state;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fireforest.entity.Cell;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FireState.class, name = "fire"),
        @JsonSubTypes.Type(value = TreeState.class, name = "tree"),
        @JsonSubTypes.Type(value = AshState.class, name = "ash")
})
public interface CellState {
    void handle(Cell cell, Cell[][] forest, double probability);
    String getSymbol();
    void tryIgnite(Cell cell, double probability);
}
