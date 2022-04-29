package core.actions;

import io.appium.java_client.AppiumBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.cucumber.core.exception.ExceptionUtils.printStackTrace;

public class MobileActions extends AbstractActions {
    WebDriver driver;
    public final static Logger LOGGER = LogManager.getLogger("Cucumber");

    public MobileActions(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void wait(int timeout) throws InterruptedException {
        Thread.sleep(timeout);
        LOGGER.info("User wait with : " + timeout + " milisecond");
    }

    @Override
    public WebElement findElement(By element) {
        waitUntilElementVisible(element, 30);
        WebElement el = driver.findElement(element);
        return el;
    }

    @Override
    public void clickOn(WebElement el) {
        try {
            el.click();
            LOGGER.info("User clicks On Element: " + el);
        } catch (ElementClickInterceptedException e) {
            clickByJSExecute(el);
        }
    }

    @Override
    public void clickOnWithWait(WebElement el) {
        try {
            waitUntilLocatorIsClickable(el, 10);
            el.click();
            LOGGER.info("User clicks On Element with wait: " + el);
        } catch (ElementClickInterceptedException e) {
            clickByJSExecute(el);
        }
    }

    @Override
    public void clickByJSExecute(WebElement el) {
        waitUntilLocatorIsClickable(el, 10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", el);
        LOGGER.info("User clicks js execute: " + el);
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
        LOGGER.info("User inputs field with element: " + el + " and value " + value);
    }

    @Override
    public void waitUntilElementIsNotStale(WebElement el, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(el)));
        LOGGER.info("wait until element: " + el + "is not stale");
    }

    @Override
    public void waitUntilElementVisible(WebElement el, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(el));
        LOGGER.info("wait until element: " + el + "is visible");
    }

    @Override
    public void waitUntilElementVisible(By element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        LOGGER.info("wait until element: " + element + " is visible");
    }

    @Override
    public void waitForElementActionable(WebElement el, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(el),
                ExpectedConditions.elementToBeClickable(el),
                ExpectedConditions.elementToBeSelected(el)));
        LOGGER.info("wait until element: " + el + "is actionable");
    }

    @Override
    public void waitUntilLocatorIsClickable(WebElement el, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        LOGGER.info("wait until element: " + el + "is clickable");
    }

    @Override
    public String getTextFromElement(WebElement element) {
        waitUntilElementVisible(element, 10);
        String text = element.getText();
        LOGGER.info("Get Text with value: " + text);
        return text;

    }
}
