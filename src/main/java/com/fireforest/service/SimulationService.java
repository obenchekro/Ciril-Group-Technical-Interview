
package com.fireforest.service;

import com.fireforest.entity.Forest;
import com.fireforest.repository.ForestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimulationService {
    private Forest forest;
    @Autowired
    private ForestRepository forestRepository;

    public Forest initializeForest(int height, int width, int[][] initialFire) {
        Forest forest = new Forest(height, width);
        forest.setInitialFire(initialFire);
        forestRepository.saveForest(forest);
        return forest;
    }

    public Forest simulateStep(double probability) {
        Forest forest = forestRepository.getForest();
        if (forest == null) {
            throw new IllegalStateException("Forest has not been initialized.");
        }
        forest.simulateStep(probability);
        return forest;
    }
}
