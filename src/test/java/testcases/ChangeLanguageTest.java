package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import data.DataDriven;
import pom.HomePage;
import pom.PageBase;

public class ChangeLanguageTest extends TestBase {
	HomePage homeObject;
	String DeutschlandURL = DataDriven.getCellData("Prod_TD", "DeutschlandURL", 1);
	String CountriesLanguageDeutschland = DataDriven.getCellData("Prod_TD", "CountriesLanguage", 1);
	String searchlocator = DataDriven.getCellData("HomePageLocators", "HomeLanguageDropdown", 1);
	PageBase PageObject;
	
	
	@Test(priority = 1)
	public void ChangeLanguage() throws InterruptedException {

		homeObject = new HomePage(driver);
		homeObject.selectLanguage(driver,searchlocator,CountriesLanguageDeutschland);
		Thread.sleep(300);
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.equalsIgnoreCase(DeutschlandURL));
		


	}
}
