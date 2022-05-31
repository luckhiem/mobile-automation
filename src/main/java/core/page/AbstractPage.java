package core.page;

import core.actions.MobileActions;
import core.driver.DriverManager;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class AbstractPage {
    WebDriver driver;
    MobileActions actions;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
        actions = new MobileActions(driver);
    }

    public <T> T redirect(Class<T> pageClass) throws NoSuchMethodException {
        try {
            Class[] parameterType = new Class[1];
            parameterType[0] = WebDriver.class;
            return pageClass.getDeclaredConstructor(parameterType).newInstance(DriverManager.getDriver());
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
