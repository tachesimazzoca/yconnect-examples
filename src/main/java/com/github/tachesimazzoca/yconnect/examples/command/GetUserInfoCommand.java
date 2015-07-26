package com.github.tachesimazzoca.yconnect.examples.command;

import com.github.tachesimazzoca.yconnect.examples.Config;
import jp.co.yahoo.yconnect.YConnectExplicit;
import jp.co.yahoo.yconnect.core.oidc.UserInfoObject;
import jp.co.yahoo.yconnect.core.util.YConnectLogger;

public class GetUserInfoCommand {
    public static void main(String[] args) throws Exception {
        YConnectLogger.setFilePath(Config.get("YConnectLogger.filePath"));

        YConnectExplicit yconnect = new YConnectExplicit();

        if (args.length != 1) {
            throw new IllegalArgumentException(
                    "Wrong number of arguments: <accessToken>");
        }
        String accessToken = args[0];

        yconnect.requestUserInfo(accessToken);
        UserInfoObject userInfo = yconnect.getUserInfoObject();

        System.out.println(userInfo.toString());
    }
}
