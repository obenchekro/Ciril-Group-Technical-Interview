package com.fireforest.controller;

import com.fireforest.dto.SimulationConfig;
import com.fireforest.entity.Forest;
import com.fireforest.service.ConfigService;
import com.fireforest.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {})
@RequestMapping("/api/v1/simulation")
public class SimulationController {

    @Autowired
    private SimulationService simulationService;

    @Autowired
    private ConfigService configService;

    @GetMapping(value = "/config", produces = MediaType.APPLICATION_JSON_VALUE)
    public SimulationConfig getConfig() {
        return configService.loadConfig();
    }

    @DeleteMapping("/config/clear-cache")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clearConfigCache() {
        configService.clearConfigCache();
    }

    @GetMapping(value = "/initialize", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> initialize() {
        try {
            SimulationConfig config = configService.loadConfig();
            return ResponseEntity.ok(
                    simulationService.initializeForest(config.getHeight(), config.getWidth(), config.getInitialFire())
            );
        } catch (Exception e) {;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("message", e.getMessage()));
        }
    }

    @GetMapping(value = "raw-representation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getRawRepresentation(@RequestBody Forest forest) {
        try {
            if (forest == null) throw new IllegalStateException("Forest not initialized");

            Map<String, Object> response = new HashMap<>();
            response.put("height", forest.getHeight());
            response.put("width", forest.getWidth());
            response.put("grid", forest.toSymbolGrid());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("message", e.getMessage()));
        }
    }

    @PostMapping(value = "/step", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> step() {
        try {
            SimulationConfig config = configService.loadConfig();
            double probability = config.getProbability();
            return ResponseEntity.ok(simulationService.simulateStep(probability));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("message", e.getMessage()));
        }
    }
}
