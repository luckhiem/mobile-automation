package core.page;

import core.actions.MobileActions;
import core.driver.DriverManager;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class AbstractPage extends MobileActions {
    protected AbstractPage(WebDriver driver) {
        super(driver);
        initElements(new AppiumFieldDecorator(DriverManager.getDriver(), Duration.ofSeconds(30)), this);
    }
}
