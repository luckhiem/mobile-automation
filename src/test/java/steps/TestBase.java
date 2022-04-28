package steps;

import core.driver.DriverManager;
import core.driver.TargetFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import core.utilities.ScenarioContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public abstract class TestBase {

    private final static Logger LOGGER = LogManager.getLogger("Cucumber");
    SoftAssertions softly = null;

    @Before
    public void beforeEachScenario(Scenario scenario) {
        System.out.println();
        System.out.println("============================================================");
        LOGGER.warn(String.format("** AUTOMATION TEST ***"));
        System.out.println("============================================================");
        System.out.println();
        String scenarioName = scenario.getName();
        LOGGER.info(String.format("Starting test: %s", scenarioName));
        softly = new SoftAssertions();
        ScenarioContext.currentContext().set("Assertion").with(softly);
        WebDriver driver = new TargetFactory().createInstance("android");
        DriverManager.setDriver(driver);
    }

    @After()
    public void afterEachScenario(Scenario scenarioResult) {
        try {
            if (softly.errorsCollected().size() > 0 || scenarioResult.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                        .getScreenshotAs(OutputType.BYTES);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            DriverManager.quit();
            softly.assertAll();
            System.out.println();
            System.out.println("============================================================");
            LOGGER.warn(String.format("** DONE TEST ***"));
            System.out.println("============================================================");
            System.out.println();
        }
    }
}
