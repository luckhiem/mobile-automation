package core.page;

import core.actions.MobileActions;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class AbstractPage {
    WebDriver driver;
    MobileActions actions;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
        actions = new MobileActions(driver);
    }
}
