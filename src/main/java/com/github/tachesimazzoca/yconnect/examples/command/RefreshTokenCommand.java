package com.github.tachesimazzoca.yconnect.examples.command;

import com.github.tachesimazzoca.yconnect.examples.Config;
import jp.co.yahoo.yconnect.YConnectExplicit;
import jp.co.yahoo.yconnect.core.util.YConnectLogger;

public class RefreshTokenCommand {
    public static void main(String[] args) throws Exception {
        YConnectLogger.setFilePath(Config.get("YConnectLogger.filePath"));

        YConnectExplicit yconnect = new YConnectExplicit();

        String clientId = Config.get("YConnectExplicit.clientId");
        String clientSecret = Config.get("YConnectExplicit.clientSecret");

        if (args.length != 1) {
            throw new IllegalArgumentException(
                    "Wrong number of arguments: <refreshToken>");
        }
        String refreshToken = args[0];

        yconnect.refreshToken(refreshToken, clientId, clientSecret);
        long expire = yconnect.getAccessTokenExpiration();
        String accessToken = yconnect.getAccessToken();

        System.out.println("AccessTokenExpiration: " + expire);
        System.out.println("AccessToken: " + accessToken);
        System.out.println("RefreshToken: " + refreshToken);
    }
}
