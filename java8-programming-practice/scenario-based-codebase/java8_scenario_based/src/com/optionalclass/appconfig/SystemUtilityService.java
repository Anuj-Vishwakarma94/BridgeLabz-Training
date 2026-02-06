package com.optionalclass.appconfig;

import java.util.*;

public class SystemUtilityService {

    public static void main(String[] args) {

        Map<String, String> configMap = new HashMap<>();
        configMap.put("timeout", "30");

        AppConfig config = new AppConfig(configMap);

        String timeout = config.get("timeout")
                .orElse("60");

        String filePath = config.get("file.path")
                .orElse("/default/path/app.log");

        String env = Optional.ofNullable(System.getenv("JAVA_HOME"))
                .orElse("Not Set");

        ApiResponse response = new ApiResponse(null);

        String apiValue = response.getValue()
                .orElse("Empty Response");

        Map<String, String> prefsMap = new HashMap<>();
        prefsMap.put("theme", "dark");

        UserPreferences preferences = new UserPreferences(prefsMap);

        String theme = preferences.getPreference("theme")
                .orElse("light");

        System.out.println(timeout);
        System.out.println(filePath);
        System.out.println(env);
        System.out.println(apiValue);
        System.out.println(theme);
    }
}

