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

    @iOSXCUITFindBy(accessibility = "Edit")
    protected WebElement editButton;

    public ListingContactPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ListingContactPage inputSearchKeyword(String value) {
        actions.inputTextBox(searchInput, value);
        return this;
    }

    public ListingContactPage clickOnSearchResult(String value) throws InterruptedException {
        By element = AppiumBy.accessibilityId(value);
        actions.clickOnWithWait(driver.findElement(element));
        return this;
    }

    public ListingContactPage clickOnEditButton() {
        actions.clickOnWithWait(editButton);
        return this;
    }
}