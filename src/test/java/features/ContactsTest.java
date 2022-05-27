package features;

import core.driver.DriverManager;
import core.page.WelcomePage;
import org.testng.annotations.Test;

public class ContactsTest extends BaseTest {

    @Test
    public void addNewContact() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(DriverManager.getDriver());
        welcomePage
                .clickOnAddButton()
                .inputFirstName();
    }

    @Test
    public void addNewContact1() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(DriverManager.getDriver());
        welcomePage
                .clickOnAddButton()
                .inputFirstName();
    }
}
