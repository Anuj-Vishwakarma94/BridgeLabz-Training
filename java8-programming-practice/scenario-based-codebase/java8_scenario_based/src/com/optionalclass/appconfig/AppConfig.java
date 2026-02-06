package com.optionalclass.appconfig;

import java.util.Optional;
import java.util.Map;

public class AppConfig {

    private Map<String, String> configs;

    public AppConfig(Map<String, String> configs) {
        this.configs = configs;
    }

    public Optional<String> get(String key) {
        return Optional.ofNullable(configs.get(key));
    }
}

