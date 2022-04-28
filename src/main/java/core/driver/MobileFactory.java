package core.driver;

import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public enum MobileFactory {
    ANDROID {
        @Override
        public AndroidDriver createDriver() {
            return new AndroidDriver(getCapabilities());
        }

        public DesiredCapabilities getCapabilities() {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("platformName", "Android");
            cap.setCapability("platformVersion", "12");
            cap.setCapability("deviceName", "Emulator");
            cap.setCapability("automationName", "uiautomator2");
            cap.setCapability("app", "src/main/resources/app-release.apk");
            return cap;
        }
    },
    IOS {
        @Override
        public AndroidDriver createDriver() {
            return new AndroidDriver(getCapabilities());
        }

        public DesiredCapabilities getCapabilities() {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("platformName", "Android");
            cap.setCapability("platformVersion", "12");
            cap.setCapability("deviceName", "Emulator");
            cap.setCapability("automationName", "uiautomator2");
            cap.setCapability("app", "src/main/resources/app-release.apk");
            return cap;
        }
    };

    public abstract WebDriver createDriver();
}
