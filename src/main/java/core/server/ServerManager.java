package core.server;

import core.driver.DriverManager;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ServerManager {
    private static final ThreadLocal<AppiumDriverLocalService> appiumDriverLocalService = new ThreadLocal<>();

    private ServerManager() {
    }

    public static AppiumDriverLocalService getAppiumDriverLocalService() {
        return appiumDriverLocalService.get();
    }

    public static void setAppiumDriverLocalService(AppiumDriverLocalService service) {
        ServerManager.appiumDriverLocalService.set(service);
    }

    public static AppiumDriverLocalService buildAppiumLocalService(String port) {
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/")
                .withArgument(GeneralServerFlag.LOG_LEVEL, "debug")
                .withLogFile(new File("./log/log_" + System.currentTimeMillis()));
        return appiumServiceBuilder.build();
    }

    public static String getAppiumServerAddress() {
        return getAppiumDriverLocalService().getUrl().toString();
    }

    public static void stopAppiumServer() {
        getAppiumDriverLocalService().stop();
    }
}
