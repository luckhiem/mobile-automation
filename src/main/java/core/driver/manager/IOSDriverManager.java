package core.driver.manager;

import core.driver.IDriver;
import core.server.ServerManager;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSDriverManager implements IDriver {
    @Override
    public WebDriver createDriver() throws MalformedURLException {
        return new IOSDriver(new URL(ServerManager.getAppiumServerAddress()), createCapabilities());
    }

    @Override
    public DesiredCapabilities createCapabilities() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.APP, "/Users/khiemluc/Documents/mobile-automation/src/main/resources/app-release.apk");
        return cap;
    }
}
