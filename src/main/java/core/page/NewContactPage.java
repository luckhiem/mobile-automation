package core.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class NewContactPage extends AbstractPage {
    WebDriver driver;

    @iOSXCUITFindBy(accessibility = "Add")
    protected WebElement addButton;

    @iOSXCUITFindBy(accessibility = "First name")
    protected WebElement firstNameInput;

    @iOSXCUITFindBy(accessibility = "Company")
    protected WebElement companyInput;

    @iOSXCUITFindBy(accessibility = "Last name")
    protected WebElement lastNameInput;

    @iOSXCUITFindBy(accessibility = "Insert add phone")
    protected WebElement insertPhoneButton;

    @iOSXCUITFindBy(accessibility = "Insert add email")
    protected WebElement insertEmailButton;

    @iOSXCUITFindBy(accessibility = "Done")
    protected WebElement doneButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == \"mobile\"`]")
    protected WebElement phoneInput;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"home\" AND value == \"Email\"")
    protected WebElement emailInput;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextView[`label == \"Notes\"`]")
    protected WebElement notesInput;

    public NewContactPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public NewContactPage clickOnAddButton() {
        clickOnWithWait(addButton);
        return this;
    }

    public NewContactPage inputFirstName(String value) {
        inputTextBox(firstNameInput, value);
        return this;
    }

    public NewContactPage inputLastName(String value) {
        inputTextBox(lastNameInput, value);
        return this;
    }

    public NewContactPage inputCompany(String value) {
        inputTextBox(companyInput, value);
        return this;
    }

    public NewContactPage clickInsertPhone() {
        clickOnWithWait(insertPhoneButton);
        return this;
    }

    public NewContactPage clickInsertEmail() {
        clickOnWithWait(insertEmailButton);
        return this;
    }

    public NewContactPage inputPhones(String value) {
        inputTextBox(phoneInput, value);
        return this;
    }

    public NewContactPage inputEmail(String value) {
        swipeScreen(Direction.DOWN);
        inputTextBox(emailInput, value);
        return this;
    }

    public NewContactPage inputNotes(String value) {
        swipeScreen(Direction.UP);
        inputTextBox(notesInput, value);
        return this;
    }

    public NewContactPage clickOnDoneButton() throws InterruptedException {
        clickOnWithWait(doneButton);
        wait(10000);
        return this;
    }
}