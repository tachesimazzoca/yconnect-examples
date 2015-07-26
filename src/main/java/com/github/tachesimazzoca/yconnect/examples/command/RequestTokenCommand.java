package com.github.tachesimazzoca.yconnect.examples.command;

import com.github.tachesimazzoca.yconnect.examples.Config;
import jp.co.yahoo.yconnect.YConnectExplicit;
import jp.co.yahoo.yconnect.core.util.YConnectLogger;

import java.net.URI;

public class RequestTokenCommand {
    public static void main(String[] args) throws Exception {
        YConnectLogger.setFilePath(Config.get("YConnectLogger.filePath"));

        YConnectExplicit yconnect = new YConnectExplicit();

        String clientId = Config.get("YConnectExplicit.clientId");
        String clientSecret = Config.get("YConnectExplicit.clientSecret");
        String redirectURI = Config.get("YConnectExplicit.redirectURI");

        if (args.length != 3) {
            throw new IllegalArgumentException(
                    "Wrong number of arguments: <redirectURI> <state> <nonce>");
        }

        URI uri = new URI(args[0]);
        String state = args[1];
        String nonce = args[2];

        // By calling the method "hasAuthorizationCode, the YConnectExplicit
        // object holds the response parameters parsed from the redirect URI.
        // For the weird side effect, you must call this method before calling
        // the method "getAuthorizationCode". TOO BAD DESIGN :-(
        if (!yconnect.hasAuthorizationCode(uri)) {
            throw new IllegalArgumentException("Invalid authorization code");
        }
        String code = yconnect.getAuthorizationCode(state);
        yconnect.requestToken(code, clientId, clientSecret, redirectURI);
        long expire = yconnect.getAccessTokenExpiration();
        String accessToken = yconnect.getAccessToken();
        String refreshToken = yconnect.getRefreshToken();
        String idToken = yconnect.getIdToken();

        if (!yconnect.verifyIdToken(nonce, clientId, clientSecret, idToken)) {
            throw new IllegalArgumentException("Invalid idToken");
        }

        System.out.println("AccessTokenExpiration: " + expire);
        System.out.println("AccessToken: " + accessToken);
        System.out.println("RefreshToken: " + refreshToken);
    }
}
