package core.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage extends AbstractPage {
    WebDriver driver;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Continue' AND name == 'Continue' AND type == 'XCUIElementTypeButton'")
    protected WebElement continueButton;

    @iOSXCUITFindBy(accessibility = "Add")
    protected WebElement addButton;

    @iOSXCUITFindBy(accessibility = "First name")
    protected WebElement firstNameInput;

    public WelcomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WelcomePage clickOnContinueButton() throws InterruptedException {
        clickOnWithWait(continueButton);
        wait(20000);
        return this;
    }

    public WelcomePage clickOnAddButton() throws InterruptedException {
        clickOnWithWait(addButton);
        return this;
    }

    public WelcomePage inputFirstName() throws InterruptedException {
        inputTextBox(firstNameInput, "Kevin");
        return this;
    }
}