package core.driver;

import org.openqa.selenium.WebDriver;

public class TargetFactory {
    public WebDriver createInstance(String platform) {
        WebDriver webdriver = null;
        switch (platform.toLowerCase()) {
            case "android":
            case "ios":
                webdriver = MobileFactory.valueOf(platform.toUpperCase()).createDriver();
                break;
            default:
                break;
        }
        return webdriver;
    }
}
