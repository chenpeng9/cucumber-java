package com.peng.functions;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * Created by PeChen on 30/06/2018.
 */
public final class EnvironmentContext {
    public static final Map<String, String> SETTINGS_DEFAULTS =
            ImmutableMap.of("browser", "chrome",
                    "environment", "dev");

    public static final String SETTINGS_LOCATION = "environment.properties";

    public final Map<String, String> settings;

    public EnvironmentContext() {
        settings = loadSettings();
    }

    public String getProperty(String Key) {
        String envrionmentName = settings.get("environment");
        if (StringUtils.isNotEmpty(envrionmentName)) {
            String value  = settings.get(Key + "." + envrionmentName);
            if (StringUtils.isNotEmpty(value)) {
                return value;
            }
        }

        String value = settings.get(Key);
        if (StringUtils.isNotEmpty(value)){
            return value;
        }
        throw new IllegalStateException("could not find a value for the key: " + Key);
    }

    public Boolean hasProperty(String Key) {
        return Objects.nonNull(this.getProperty(Key));
    }

    private static Map<String, String> loadSettings() {
        Map<String, String> settings = new HashMap<>(SETTINGS_DEFAULTS);

        InputStream source = EnvironmentContext.class.getClassLoader().getResourceAsStream(SETTINGS_LOCATION);
        if (source != null) {
            try (Reader reader = new InputStreamReader(source, "UTF-8")) {
                Properties overrides = new Properties();
                overrides.load(reader);
                settings.putAll((Map) overrides);
            } catch (IOException e) {
                throw new IllegalStateException("could not load configuration for the test framework", e);
            }
        }
        return Collections.unmodifiableMap(settings);
    }


    @Test
    public void getEnvrionmentContex() throws Exception {
        EnvironmentContext environmentContext = new EnvironmentContext();
        Assert.assertEquals(environmentContext.getProperty("browser"),"chrome");
    }
}
