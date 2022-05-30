package core.actions;

import io.appium.java_client.*;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class MobileActions extends AbstractActions {
    WebDriver driver;
    public final static Logger LOGGER = LogManager.getLogger("Mobile Automation");

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
            waitUntilLocatorIsClickable(el, 30);
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
            System.out.println(e);
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

    public void mobileScrollScreenIOS(String dir) {
        final int ANIMATION_TIME = 200; // ms
        final HashMap<String, String> scrollObject = new HashMap<String, String>();

        switch (dir.toUpperCase()) {
            case "DOWN": // from down to up (! differs from mobile:swipe)
                scrollObject.put("direction", "down");
                break;
            case "UP": // from up to down (! differs from mobile:swipe)
                scrollObject.put("direction", "up");
                break;
            case "LEFT": // from left to right (! differs from mobile:swipe)
                scrollObject.put("direction", "left");
                break;
            case "RIGHT": // from right to left (! differs from mobile:swipe)
                scrollObject.put("direction", "right");
                break;
            default:
                throw new IllegalArgumentException("mobileScrollIOS(): dir: '" + dir + "' NOT supported");
        }
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("mobile:scroll", scrollObject); // swipe faster then scroll
            Thread.sleep(ANIMATION_TIME); // always allow swipe action to complete
        } catch (Exception e) {
            System.err.println("mobileScrollIOS(): FAILED\n" + e.getMessage());
            return;
        }
    }

    public void swipeScreen(Direction dir) {
        final int ANIMATION_TIME = 200;
        final int PRESS_TIME = 200;
        int edgeBorder = 10;
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = driver.manage().window().getSize();
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        switch (dir) {
            case DOWN:
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP:
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT:
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT:
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }
        try {
            new TouchAction((PerformsTouchActions) driver)
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
        }
    }

    public void hideKeyboard() {
        driver.navigate().back();
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
}
