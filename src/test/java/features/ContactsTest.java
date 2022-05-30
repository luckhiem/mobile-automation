package features;

import core.driver.DriverManager;
import core.page.ListingContactPage;
import core.page.NewContactPage;
import org.testng.annotations.Test;

public class ContactsTest extends BaseTest {

    @Test
    public void addNewContact() throws InterruptedException {
        NewContactPage newContactPage = new NewContactPage(DriverManager.getDriver());
        newContactPage
                .clickOnAddButton()
                .inputFirstName("Kevin")
                .inputLastName("Luc")
                .inputCompany("ShopBack")
                .addPhones("123456789")
                .inputNotes("This is test")
                .clickOnDoneButton();
    }

    @Test
    public void searchAndEditContact() throws InterruptedException {
        ListingContactPage listingContactPage = new ListingContactPage(DriverManager.getDriver());
        listingContactPage
                .inputSearchKeyword("John")
                .clickOnSearchResult("John Appleseed, John-Appleseed@mac.com");
    }
}
