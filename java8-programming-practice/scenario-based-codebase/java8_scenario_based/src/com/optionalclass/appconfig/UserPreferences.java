package com.optionalclass.appconfig;

import java.util.Optional;
import java.util.Map;

public class UserPreferences {

    private Map<String, String> preferences;

    public UserPreferences(Map<String, String> preferences) {
        this.preferences = preferences;
    }

    public Optional<String> getPreference(String key) {
        return Optional.ofNullable(preferences.get(key));
    }
}

