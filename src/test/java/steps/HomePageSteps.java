package steps;

import core.page.Factory;
import core.utilities.ScenarioContext;
import io.cucumber.java.en.Given;

public class HomePageSteps {
    Factory factory = ScenarioContext.currentContext().get("factory", Factory.class);

    @Given("I open the app")
    public void iOpenTheApp() throws InterruptedException {
        factory.homePage()
                .clickOnAddButton()
                .wait(60000);
    }
}
