package core.driver;

import core.driver.manager.AndroidDriverManager;
import core.driver.manager.IOSDriverManager;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class TargetFactory {
    public WebDriver createInstance(String platform) throws MalformedURLException {
        WebDriver webdriver = null;
        Platform platformType = Platform.valueOf(platform.toUpperCase());

        switch (platformType) {
            case ANDROID:
                webdriver = new AndroidDriverManager().createDriver();
                break;
            case IOS:
                webdriver = new IOSDriverManager().createDriver();
                break;
            default:
                break;
        }
        return webdriver;
    }

    public enum Platform {
        ANDROID, IOS,
    }
}
