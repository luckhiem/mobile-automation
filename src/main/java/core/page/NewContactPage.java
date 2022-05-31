package core.page;

import core.actions.MobileActions;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        actions.clickOnWithWait(addButton);
        return this;
    }

    public NewContactPage inputFirstName(String value) {
        actions.inputTextBox(firstNameInput, value);
        return this;
    }

    public NewContactPage inputLastName(String value) {
        actions.inputTextBox(lastNameInput, value);
        return this;
    }

    public NewContactPage inputCompany(String value) {
        actions.inputTextBox(companyInput, value);
        return this;
    }

    public NewContactPage clickInsertPhone() {
        actions.clickOnWithWait(insertPhoneButton);
        return this;
    }

    public NewContactPage clickInsertEmail() {
        actions.swipeScreen(MobileActions.Direction.DOWN);
        actions.clickOnWithWait(insertEmailButton);
        return this;
    }

    public NewContactPage inputPhones(String value) {
        actions.inputTextBox(phoneInput, value);
        return this;
    }

    public NewContactPage inputEmail(String value) {
        actions.inputTextBox(emailInput, value);
        return this;
    }

    public NewContactPage inputNotes(String value) {
        actions.swipeScreen(MobileActions.Direction.UP);
        actions.inputTextBox(notesInput, value);
        return this;
    }

    public NewContactPage clickOnDoneButton() throws InterruptedException {
        actions.clickOnWithWait(doneButton);
        actions.wait(10000);
        return this;
    }
}