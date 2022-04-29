package core.actions;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractActions {

    public void wait(int timeout) throws InterruptedException {};

    public abstract WebElement findElement(By by);

    public abstract void clickOn(WebElement el);

    public abstract void clickOnWithWait(WebElement el);

    public abstract void clickByJSExecute(WebElement el);

    public abstract void inputTextBox(WebElement el, String value);

    public abstract void waitUntilElementIsNotStale(WebElement el, int timeout);

    public abstract void waitUntilElementVisible(WebElement el, int timeout);

    public abstract void waitUntilElementVisible(By by, int timeout);

    public abstract void waitForElementActionable(WebElement el, int timeout);

    public abstract void waitUntilLocatorIsClickable(WebElement el, int timeout);

    public abstract String getTextFromElement(WebElement element);
}
