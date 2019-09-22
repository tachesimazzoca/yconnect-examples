package com.github.tachesimazzoca.yconnect.examples;

import jp.co.yahoo.yconnect.core.util.YConnectLogger;
import org.junit.Test;

public class YConnectLoggerTest {
    private String getResourcePath(String name) {
        return getClass().getResource(name).getPath();
    }

    @Test
    public void testSetFilePath() {
        // We must set the path to log4j.xml via the method
        // YConnectLogger.setFilePath.
        // If the process is skipped, YConnectLogger will set
        // "./yconnect_log_conf.xml" as default.
        YConnectLogger.setFilePath(getResourcePath("/log4j.xml"));
        YConnectLogger.debug("Some Object",
                "should put a message with the class name.");
    }
}
