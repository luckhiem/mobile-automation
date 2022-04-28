package core.actions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.cucumber.core.exception.ExceptionUtils.printStackTrace;

public class MobileActions extends AbstractActions {
    WebDriver driver;

    public MobileActions(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void wait(int timeout) throws InterruptedException {
        Thread.sleep(timeout);
    }

    @Override
    public void clickOn(WebElement el) {
        try {
            el.click();
        } catch (ElementClickInterceptedException e) {
            clickByJSExecute(el);
        }
    }

    @Override
    public void clickOnWithWait(WebElement el) {
        try {
            waitUntilLocatorIsClickable(el, 10);
            el.click();
        } catch (ElementClickInterceptedException e) {
            clickByJSExecute(el);
        }
    }

    @Override
    public void clickByJSExecute(WebElement el) {
        waitUntilLocatorIsClickable(el, 10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", el);
    }

    @Override
    public void inputTextBox(WebElement el, String value) {
        waitForElementActionable(el, 10);
        try {
            el.clear();
        } catch (ElementNotInteractableException e) {
            printStackTrace(e);
        }
        el.sendKeys(value);
    }

    @Override
    public void waitUntilElementIsNotStale(WebElement el, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(el)));
    }

    @Override
    public void waitUntilElementVisible(WebElement el, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(el));
    }

    @Override
    public void waitForElementActionable(WebElement el, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(el),
                ExpectedConditions.elementToBeClickable(el),
                ExpectedConditions.elementToBeSelected(el)));
    }

    @Override
    public void waitUntilLocatorIsClickable(WebElement el, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }
}
