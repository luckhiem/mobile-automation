package steps;

import core.page.Factory;
import core.utilities.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

public class HomeScreen {
    Factory factory = ScenarioContext.currentContext().get("factory", Factory.class);
    SoftAssertions soft = ScenarioContext.currentContext().get("Assertion", SoftAssertions.class);

    @Given("I place in the homepage")
    public void iPlaceInTheHomepage() {
        factory.homePage().waitForHomePageDisplayed();
    }

    @When("I click on the add button")
    public void iClickOnTheAddButton() {
        factory.homePage().clickOnAddButton();
    }

    @Then("I should see the todo {string} displayed in the list")
    public void iShouldSeeTheTodoDisplayedInTheList(String value) {
        String title = factory.homePage().getTodoTitle();
        soft.assertThat(title).containsIgnoringCase(value);
    }
}
