package com.fireforest.utils;

import java.util.ArrayList;
import java.util.List;

public class PropertyParser {

    public static int parsePositiveInt(String value, String key) {
        try {
            int intValue = Integer.parseInt(value);
            if (intValue <= 0) {
                throw new IllegalArgumentException(key + " must be a positive integer");
            }
            return intValue;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid integer for " + key + ": " + value, e);
        }
    }

    public static double parseProbability(String value) {
        try {
            double prob = Double.parseDouble(value);
            if (prob < 0 || prob > 1) {
                throw new IllegalArgumentException("Probability must be between 0 and 1: " + value);
            }
            return prob;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid probability value: " + value, e);
        }
    }

    public static List<int[]> parseFirePositions(String value, int height, int width, String key) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Missing fire positions in the initiation.");
        }
        String[] firePositions = value.split(";");
        List<int[]> initialFire = new ArrayList<>();
        for (String pos : firePositions) {
            String[] coords = pos.split(",");
            if (coords.length != 2) {
                throw new IllegalArgumentException("Invalid format for " + key + ": " + pos);
            }
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            if (x < 0 || x >= height || y < 0 || y >= width) {
                throw new IllegalArgumentException(key + " position out of bounds: " + pos);
            }
            initialFire.add(new int[]{x, y});
        }
        return initialFire;
    }
}
