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
                .inputCompany("Creditor Watch")
                .clickInsertPhone()
                .inputPhones("123456789")
                .clickInsertEmail()
                .inputEmail("khiem.luc@gmail.com")
                .inputNotes("This is test")
                .clickOnDoneButton();
    }

    @Test
    public void searchAndEditContact() throws InterruptedException {
        ListingContactPage listingContactPage = new ListingContactPage(DriverManager.getDriver());
        NewContactPage newContactPage = new NewContactPage(DriverManager.getDriver());
        listingContactPage
                .inputSearchKeyword("John")
                .clickOnSearchResult("John Appleseed, John-Appleseed@mac.com")
                .clickOnEditButton();
        newContactPage
                .inputFirstName("Kevin Updated")
                .inputLastName("Luc")
                .inputCompany("Creditor Watch")
                .inputPhones("123456789")
                .inputNotes("This is test")
                .clickOnDoneButton();
    }
}
