package core.server;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class ServerManager {
    private ServerManager() {
    }

    private static AppiumDriverLocalService appiumDriverLocalService;

    public static void startAppiumServer(String port) {
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/")
                .withArgument(GeneralServerFlag.LOG_LEVEL, "debug")
                .withLogFile(new File("./log/log_" + System.currentTimeMillis()));
        appiumDriverLocalService = appiumServiceBuilder.build();
        appiumDriverLocalService.start();
    }

    public static String getAppiumServerAddress() {
        return appiumDriverLocalService.getUrl().toString();
    }

    public static void stopAppiumServer() {
        appiumDriverLocalService.stop();
    }
}
