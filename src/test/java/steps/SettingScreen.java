package steps;

import core.page.Factory;
import core.utilities.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

public class SettingScreen {
    Factory factory = ScenarioContext.currentContext().get("factory", Factory.class);
    SoftAssertions soft = ScenarioContext.currentContext().get("Assertion", SoftAssertions.class);

    @When("I check {string} night mode setting")
    public void iCheckNightModeSetting(String arg0) {
        switch (arg0.toLowerCase()) {
            case "on":
                factory.settingPage().enableNightMode();
                break;
            case "off":
                factory.settingPage().disableNightMode();
                break;
            default:
                break;
        }

    }

    @Then("I should see night mode {string}")
    public void iShouldSeeNightMode(String value) {
        String status = factory.settingPage().getNightModeStatus();
        soft.assertThat(status).containsIgnoringCase(value);
    }
}
