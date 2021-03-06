package core.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage {
    WebDriver driver;

    @AndroidFindBy(id = "com.avjindersinghsekhon.minimaltodo:id/addToDoItemFAB")
    protected WebElement plusBtn;

    @AndroidFindBy(accessibility = "More options")
    protected WebElement threeDotBtn;

    @AndroidFindBy(id = "com.avjindersinghsekhon.minimaltodo:id/toDoListItemTextview")
    protected WebElement itemInList;

    @AndroidFindBy(uiAutomator = "text(\"About\")")
    protected WebElement aboutBtn;

    @AndroidFindBy(uiAutomator = "text(\"Settings\")")
    protected WebElement settingBtn;

    protected String itemInListWithName = "text(\"%s\")";

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public HomePage clickOnAddButton() {
        clickOnWithWait(plusBtn);
        return this;
    }

    public HomePage clickIconThreeDot() {
        clickOnWithWait(threeDotBtn);
        return this;
    }

    public HomePage clickOnAboutBtn() {
        clickOnWithWait(aboutBtn);
        return this;
    }

    public HomePage clickOnSettingsBtn() {
        clickOnWithWait(settingBtn);
        return this;
    }

    public String getTodoTitle() {
        String value = getTextFromElement(itemInList);
        return value;
    }

    public HomePage waitForHomePageDisplayed() {
        waitUntilElementVisible(plusBtn, 10);
        return this;
    }

    public HomePage clickOnItemInList(String itemName) {
        WebElement el = findElement(AppiumBy.androidUIAutomator(String.format(itemInListWithName, itemName)));
        clickOnWithWait(el);
        return this;
    }
}