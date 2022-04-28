package core.driver.manager;

import core.driver.IDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSDriverManager implements IDriver {
    @Override
    public WebDriver createDriver() throws MalformedURLException {
        return new IOSDriver(new URL("http://localhost:4723/wd/hub"), createCapabilities());
    }

    @Override
    public DesiredCapabilities createCapabilities() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "12");
        cap.setCapability("deviceName", "Emulator");
        cap.setCapability("automationName", "uiautomator2");
        cap.setCapability("app", "/Users/khiemluc/Documents/mobile-automation/src/main/resources/app-release.apk");
        return cap;
    }
}
