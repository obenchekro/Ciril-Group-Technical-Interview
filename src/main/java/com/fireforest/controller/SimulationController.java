package com.fireforest.controller;

import com.fireforest.dto.SimulationConfig;
import com.fireforest.entity.Forest;
import com.fireforest.service.ConfigService;
import com.fireforest.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
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
    public Forest initialize() {
        SimulationConfig config = configService.loadConfig();
        return simulationService.initializeForest(config.getHeight(), config.getWidth(), config.getInitialFire());
    }

    @GetMapping(value = "raw-representation", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> getRawRepresentation() {
        Forest forest = initialize();
        Map<String, Object> response = new HashMap<>();
        response.put("height", forest.getHeight());
        response.put("width", forest.getWidth());
        response.put("grid", forest.toSymbolGrid());
        return response;
    }

    @PostMapping(value = "/step", produces = MediaType.APPLICATION_JSON_VALUE)
    public Forest step() {
        return simulationService.simulateStep();
    }
}
