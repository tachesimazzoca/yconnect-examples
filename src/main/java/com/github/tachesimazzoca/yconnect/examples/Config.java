package com.github.tachesimazzoca.yconnect.examples;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static Properties prop;

    synchronized private static void init() throws IOException {
        if (null == prop) {
            InputStream in = Thread.currentThread().getClass()
                    .getResourceAsStream("/app.properties");
            prop = new Properties();
            prop.load(in);
        }
    }

    public static String get(String key) throws IOException {
        if (null == prop)
            init();
        return prop.getProperty(key);
    }
}
