package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/jsonReports/cucumber.json"},
    features = {"target/test-classes/features/"},
    glue = {"steps"},
    tags = "@test",
    monochrome = true)
public class TestRunner {}
