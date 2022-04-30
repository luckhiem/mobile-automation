package core.page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingPage extends AbstractPage {
    WebDriver driver;

    @AndroidFindBy(id = "android:id/checkbox")
    protected WebElement nightModeCheckbox;

    @AndroidFindBy(id = "android:id/summary")
    protected WebElement nightModeSummary;

    public SettingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getNightModeStatus() {
        String status = getTextFromElement(nightModeSummary).replace("Night mode is ", "");
        return status;
    }

    public SettingPage enableNightMode() {
        String status = getNightModeStatus();
        if (status.equalsIgnoreCase("off")) {
            clickOnWithWait(nightModeCheckbox);
        }
        return this;
    }

    public SettingPage disableNightMode() {
        String status = getNightModeStatus();
        if (status.equalsIgnoreCase("on")) {
            clickOnWithWait(nightModeCheckbox);
        }
        return this;
    }
}