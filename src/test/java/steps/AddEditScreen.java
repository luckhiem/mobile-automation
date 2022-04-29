package steps;

import core.page.Factory;
import core.utilities.ScenarioContext;
import io.cucumber.java.en.When;

public class AddEditScreen {
    Factory factory = ScenarioContext.currentContext().get("factory", Factory.class);

    @When("I input todo with title {string}")
    public void iInputTodoWithTitle(String value) {
        factory.addEditPage().inputTitle(value);
    }

    @When("I submit add the todo")
    public void iAddTheTodo() {
        factory.addEditPage().submitForm();
    }

    @When("I switch on reminder")
    public void iSwitchOnReminder() {
        factory.addEditPage().switchRemindMe();
    }

    @When("I input datetime with {string} and {string} in reminder")
    public void iInputDatetimeWithAndInReminder(String date, String time) {
        if (date.equalsIgnoreCase("today")) {
            factory.addEditPage().inputTime(time);
        } else {
            factory.addEditPage()
                    .inputDate(date)
                    .inputTime(time);
        }
    }

    @When("I add a new todo {string}")
    public void iAddANewTodo(String value) {
        iInputTodoWithTitle(value);
        iAddTheTodo();
    }
}
