package core.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEditPage extends AbstractPage {
    WebDriver driver;

    @AndroidFindBy(id = "com.avjindersinghsekhon.minimaltodo:id/userToDoEditText")
    protected WebElement titleInput;

    @AndroidFindBy(id = "com.avjindersinghsekhon.minimaltodo:id/toDoHasDateSwitchCompat")
    protected WebElement switchRemindMe;

    @AndroidFindBy(id = "com.avjindersinghsekhon.minimaltodo:id/makeToDoFloatingActionButton")
    protected WebElement addBtn;

    @AndroidFindBy(id = "com.avjindersinghsekhon.minimaltodo:id/newTodoDateEditText")
    protected WebElement dateInput;

    @AndroidFindBy(id = "com.avjindersinghsekhon.minimaltodo:id/newTodoTimeEditText")
    protected WebElement timeInput;

    @AndroidFindBy(id = "com.avjindersinghsekhon.minimaltodo:id/date_picker_year")
    protected WebElement dataPickerYear;

    public AddEditPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public AddEditPage inputTitle(String value) {
        inputTextBox(titleInput, value);
        return this;
    }

    public AddEditPage submitForm() {
        clickOnWithWait(addBtn);
        return this;
    }

    public AddEditPage switchRemindMe() {
        clickOnWithWait(switchRemindMe);
        return this;
    }

    public AddEditPage inputDate(String date) {
        inputTextBox(dateInput, date);
        return this;
    }

    public AddEditPage inputTime(String time) {
        inputTextBox(timeInput, time);
        return this;
    }
}