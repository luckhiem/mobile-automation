package core.actions;

import core.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public abstract class AbstractActions {
    WebDriver driver;

    public AbstractActions() {
        this.driver = DriverManager.getDriver();
    }

    public abstract void clickOn(WebElement el);

    public abstract void clickOnWithWait(WebElement el);

    public abstract void clickByJSExecute(WebElement el);

    public abstract void inputTextBox(WebElement el, String value);

    public abstract void waitUntilElementIsNotStale(WebElement el, int timeout);

    public abstract void waitUntilElementVisible(WebElement el, int timeout);

    public abstract void waitForElementActionable(WebElement el, int timeout);

    public abstract void waitUntilLocatorIsClickable(WebElement el, int timeout);
}
