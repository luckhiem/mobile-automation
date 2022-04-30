package core.page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutPage extends AbstractPage {
    WebDriver driver;

    @AndroidFindBy(id = "com.avjindersinghsekhon.minimaltodo:id/aboutContactMe")
    protected WebElement aboutContactMe;

    public AboutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public AboutPage waitUntilAboutPageDisplayed() {
        waitUntilElementVisible(aboutContactMe, 10);
        return this;
    }
}