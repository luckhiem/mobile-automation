package core.driver.manager;

import core.driver.IDriver;
import core.server.ServerManager;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSDriverManager implements IDriver {
    @Override
    public WebDriver createDriver(String deviceName, String wda) throws MalformedURLException {
        return new IOSDriver(new URL(ServerManager.getAppiumServerAddress()), createCapabilities(deviceName, wda));
    }

    @Override
    public DesiredCapabilities createCapabilities(String deviceName, String wda) {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.0");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        cap.setCapability(MobileCapabilityType.APP, "com.apple.MobileAddressBook");
        cap.setCapability(MobileCapabilityType.FULL_RESET, true);
        cap.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, wda);
        cap.setCapability(IOSMobileCapabilityType.SIMPLE_ISVISIBLE_CHECK, true);
        return cap;
    }
}
