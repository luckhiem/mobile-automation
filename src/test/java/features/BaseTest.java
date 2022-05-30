package features;

import core.driver.DriverManager;
import core.driver.TargetFactory;
import core.server.ServerManager;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;

import static core.constants.Platform.OS;

public abstract class BaseTest {
    public final static Logger LOGGER = LogManager.getLogger("Mobile Automation");

    @BeforeTest(alwaysRun = true)
    @Parameters({"deviceName", "port"})
    public void startServer(String deviceName, String port) {
        AppiumDriverLocalService service = ServerManager.buildAppiumLocalService(port);
        ServerManager.setAppiumDriverLocalService(service);
        service.start();
        LOGGER.info("Start the appium server");
    }

    @BeforeClass(alwaysRun = true)
    @Parameters({"wda", "deviceName"})
    public void setup(String wda, String deviceName) throws MalformedURLException {
        LOGGER.info("Address " + ServerManager.getAppiumServerAddress());
        WebDriver driver = new TargetFactory().createInstance(OS, deviceName, wda);
        DriverManager.setDriver(driver);
        LOGGER.info("Create new driver in platform " + driver);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        DriverManager.quit();
        LOGGER.info("Stop driver in platform " + OS);
    }

    @AfterTest(alwaysRun = true)
    public void stopServer() {
        ServerManager.stopAppiumServer();
        LOGGER.info("Stop the appium server");
    }
}