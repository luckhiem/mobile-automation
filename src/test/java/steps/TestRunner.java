package steps;

import core.server.ServerManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/jsonReports/cucumber.json"},
    features = {"target/test-classes/features/"},
    glue = {"steps"},
    tags = "@test",
    monochrome = true)
public class TestRunner {
    @BeforeClass
    public static void startServer(){
        ServerManager.startAppiumServer();
    }

    @AfterClass
    public static void stopServer(){
        ServerManager.stopAppiumServer();
    }
}
