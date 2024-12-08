package com.fireforest.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class SimulationConfig {
    private final int height;
    private final int width;
    private final int[][] initialFire;
    private final double probability;
}
