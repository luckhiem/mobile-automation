package steps;

import core.driver.DriverManager;
import core.driver.TargetFactory;
import core.page.Factory;
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

import java.net.MalformedURLException;

import static core.constants.Platform.OS;

public class Hook {

    public final static Logger LOGGER = LogManager.getLogger("Cucumber");
    SoftAssertions softly = null;
    ScenarioContext context = ScenarioContext.currentContext();

    @Before
    public void beforeEachScenario(Scenario scenario) throws MalformedURLException {
        System.out.println();
        System.out.println("============================================================");
        LOGGER.warn("** AUTOMATION TEST ***");
        System.out.println("============================================================");
        System.out.println();
        String scenarioName = scenario.getName();
        LOGGER.info(String.format("Starting test: %s", scenarioName));
        softly = new SoftAssertions();
        context.set("Assertion").with(softly);
        WebDriver driver = new TargetFactory().createInstance(OS);
        DriverManager.setDriver(driver);
        Factory factoryInstance = new Factory(DriverManager.getDriver());
        context.set("factory").with(factoryInstance);
    }

    @After()
    public void afterEachScenario(Scenario scenarioResult) {
        try {
            if (softly.errorsCollected().size() > 0 || scenarioResult.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenarioResult.attach(screenshot, "image/png", "image");
            }
        } finally {
            DriverManager.quit();
            softly.assertAll();
            System.out.println();
            System.out.println("============================================================");
            LOGGER.warn("** DONE TEST ***");
            System.out.println("============================================================");
            System.out.println();
        }
    }
}
