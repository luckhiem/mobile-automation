package core.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListingContactPage extends AbstractPage {
    WebDriver driver;

    @iOSXCUITFindBy(accessibility = "Search")
    protected WebElement searchInput;

    @iOSXCUITFindBy(accessibility = "John Appleseed, John-Appleseed@mac.com")
    protected WebElement searchResultItems;

    public ListingContactPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ListingContactPage inputSearchKeyword(String value) {
        inputTextBox(searchInput, value);
        return this;
    }

    public ListingContactPage clickOnSearchResult(String value) throws InterruptedException {
        By element = AppiumBy.accessibilityId(value);
        clickOnWithWait(driver.findElement(element));
        wait(10000);
        return this;
    }
}