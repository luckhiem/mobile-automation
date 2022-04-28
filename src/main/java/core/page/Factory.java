package core.page;

import org.openqa.selenium.WebDriver;

public class Factory {
    WebDriver driver;

    public Factory(WebDriver driver){
        this.driver = driver;
    }

    public HomePage homePage(){
        return new HomePage(driver);
    }
}
