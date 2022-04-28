package core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public interface IDriver {
    WebDriver createDriver() throws MalformedURLException;
    DesiredCapabilities createCapabilities();
}
