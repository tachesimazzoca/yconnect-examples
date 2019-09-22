package com.github.tachesimazzoca.yconnect.examples.command;

import com.github.tachesimazzoca.yconnect.examples.Config;
import jp.co.yahoo.yconnect.core.util.YConnectLogger;

import java.io.IOException;

public class GetAuthorizationURLCommand {
    public static void main(String[] args) throws IOException {
        YConnectLogger.setFilePath(Config.get("YConnectLogger.filePath"));
        YConnectLogger.debug("", "debugging");
    }
}
