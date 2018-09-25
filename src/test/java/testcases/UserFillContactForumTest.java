package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import data.DataDriven;
import pom.ContactPage;
import pom.HomePage;
import pom.PageBase;

public class UserFillContactForumTest extends TestBase {
	
	Faker fakeData = new Faker();
	String email = fakeData.internet().emailAddress();
	String Name = fakeData.name().fullName();
	String Message = fakeData.gameOfThrones().character();
	String urlContactPage = DataDriven.getCellData("Prod_TD", "ContactPageURL", 1);
	String messageRegex = DataDriven.getCellData("Prod_TD", "MessageRegex", 1);
	String contactLinkLocator = DataDriven.getCellData("HomePageLocators", "HomeContactLink", 1);
	String messageLocator = DataDriven.getCellData("ContactPageLocators", "ContactMessage", 1);
	String fullNameLocator = DataDriven.getCellData("ContactPageLocators", "ContactFullName", 1);
	String emailLocator = DataDriven.getCellData("ContactPageLocators", "ContactEmail", 1);
	String confirmCheckBoxLocator = DataDriven.getCellData("ContactPageLocators", "ContactConfirmCheckBox", 1);
	String submitBtnLocator = DataDriven.getCellData("ContactPageLocators", "ContactSubmitBtn", 1);
	String successMessageLocator = DataDriven.getCellData("ContactPageLocators", "ContactSuccessMessage", 1);
	
	HomePage homeObject;
	ContactPage contactObject;
	PageBase PageObject;

	@Test(priority = 5)
	public void UserFillForumSuccessfully() throws InterruptedException {
		Thread.sleep(500);
		homeObject = new HomePage(driver);
		contactObject = new ContactPage(driver);
		PageObject = new PageBase(driver);

		homeObject.clickOnContactLink(driver, contactLinkLocator);

		PageObject.WindowHandling(driver, urlContactPage);

		contactObject.fillContactForum(driver, messageLocator, fullNameLocator, emailLocator, confirmCheckBoxLocator,
				submitBtnLocator, Message, Name, email);

		contactObject.ValidateMessage(driver, successMessageLocator);
		String regex = messageRegex;
		Assert.assertTrue(ContactPage.message.matches(regex));
		PageObject.redirectToDriver(driver);

	}
}
