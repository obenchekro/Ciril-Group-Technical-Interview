package com.fireforest.config;

import com.fireforest.dto.SimulationConfig;
import com.fireforest.utils.PropertyParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class ConfigLoader {
    private static final String CONFIG_FILE = "app.config";

    public static SimulationConfig loadConfig() {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file", e);
        }

        int height = PropertyParser.parsePositiveInt(prop.getProperty("forest.height"), "forest.height");
        int width = PropertyParser.parsePositiveInt(prop.getProperty("forest.width"), "forest.width");

        String firePositions = prop.getProperty("forest.initialFire");
        List<int[]> initialFire = PropertyParser.parseFirePositions(firePositions, height, width, "forest.initialFire");
        double probability = PropertyParser.parseProbability(prop.getProperty("forest.probability"));

        return new SimulationConfig(height, width, initialFire.toArray(new int[0][]), probability);
    }
}
