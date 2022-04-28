package core.page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage {
    WebDriver driver;

    @AndroidFindBy(id="com.avjindersinghsekhon.minimaltodo:id/addToDoItemFAB")
    protected WebElement plusBtn;

    @AndroidFindBy(accessibility="More options")
    protected WebElement threeDotBtn;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public HomePage clickOnAddButton(){
        clickOnWithWait(plusBtn);
        return this;
    }

    public HomePage clickIconThreeDot(){
        clickOnWithWait(threeDotBtn);
        return this;
    }
}