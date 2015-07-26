package com.github.tachesimazzoca.yconnect.examples.command;

import com.github.tachesimazzoca.yconnect.examples.Config;
import jp.co.yahoo.yconnect.YConnectExplicit;
import jp.co.yahoo.yconnect.core.oauth2.OAuth2ResponseType;
import jp.co.yahoo.yconnect.core.oidc.OIDCDisplay;
import jp.co.yahoo.yconnect.core.oidc.OIDCPrompt;
import jp.co.yahoo.yconnect.core.oidc.OIDCScope;
import jp.co.yahoo.yconnect.core.util.YConnectLogger;
import org.apache.commons.lang.RandomStringUtils;

import java.io.IOException;
import java.net.URI;

public class GetAuthorizationURLCommand {
    public static void main(String[] args) throws IOException {
        YConnectLogger.setFilePath(Config.get("YConnectLogger.filePath"));

        YConnectExplicit yconnect = new YConnectExplicit();

        String clientId = Config.get("YConnectExplicit.clientId");
        String redirectURI = Config.get("YConnectExplicit.redirectURI");

        String state = RandomStringUtils.randomAlphanumeric(32);
        String nonce = RandomStringUtils.randomAlphanumeric(32);

        String responseType = OAuth2ResponseType.CODE_IDTOKEN;
        String display = OIDCDisplay.DEFAULT;
        String prompt[] = {OIDCPrompt.DEFAULT};
        String scope[] = {OIDCScope.OPENID, OIDCScope.PROFILE,
                OIDCScope.EMAIL, OIDCScope.ADDRESS};

        yconnect.init(clientId, redirectURI, state, responseType, display, prompt, scope, nonce);
        URI uri = yconnect.generateAuthorizationUri();

        System.out.println("state: " + state);
        System.out.println("nonce: " + nonce);
        System.out.println("AuthorizationURI:" + uri);
    }
}
