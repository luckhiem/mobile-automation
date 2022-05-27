package core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public interface IDriver {
    WebDriver createDriver(String deviceName, String wda) throws MalformedURLException;
    DesiredCapabilities createCapabilities(String deviceName, String wda);
}
