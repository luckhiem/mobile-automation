package steps;

import core.page.Factory;
import core.utilities.ScenarioContext;
import io.cucumber.java.en.Then;

public class AboutScreen {
    Factory factory = ScenarioContext.currentContext().get("factory", Factory.class);

    @Then("I should see about page is displayed")
    public void iShouldSeeAboutPageIsDisplayed() {
        factory.aboutPage().waitUntilAboutPageDisplayed();
    }
}
