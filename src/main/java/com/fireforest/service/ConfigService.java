
package com.fireforest.service;

import com.fireforest.config.ConfigLoader;
import com.fireforest.dto.SimulationConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

    @Cacheable("config")
    public SimulationConfig loadConfig() {
        return ConfigLoader.loadConfig();
    }

    @CacheEvict(value = "config", allEntries = true)
    public void clearConfigCache() {}
}
