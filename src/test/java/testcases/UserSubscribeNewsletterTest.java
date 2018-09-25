package testcases;

import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import data.DataDriven;
import pom.HomePage;

public class UserSubscribeNewsletterTest extends TestBase {
	
	String homePageURL = DataDriven.getCellData("Prod_TD", "HomePageProdURL", 1);
	String confirmbtnLocator = DataDriven.getCellData("HomePageLocators", "HomeConfirmBtn", 1);
	String emailLocator = DataDriven.getCellData("HomePageLocators", "HomeEmailField", 1);
	String submitBtnLocator = DataDriven.getCellData("HomePageLocators", "HomeSubmitBtn", 1);
	
	HomePage homeObject;
	Faker fakeData = new Faker();
	String email = fakeData.internet().emailAddress();

	@Test(priority = 4)
	public void UserSearchSuccessfully() throws InterruptedException {

		homeObject = new HomePage(driver);
		homeObject.Subscribe(driver, confirmbtnLocator, emailLocator, submitBtnLocator, email);

	}
}
