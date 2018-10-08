package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import data.DataDriven;
import pom.HomePage;

public class UserNavigateToMenuTest extends GridBase {
	HomePage homeObject;

	String WestPageURL = DataDriven.getCellData("Prod_TD", "WestPageURL", 1);
	String sideMenuBtnLocator = DataDriven.getCellData("HomePageLocators", "HomeSideMenu", 1);
	String menuItemLocator = DataDriven.getCellData("HomePageLocators", "HomeMenuItem", 1);
	@Test(priority = 3)
	public void UserNavigateSuccessfully() throws InterruptedException {

		homeObject = new HomePage(driverGrid);
		homeObject.navigateSideMenu(driverGrid, sideMenuBtnLocator, menuItemLocator);
		Thread.sleep(5000);
		String url = driverGrid.getCurrentUrl();
		Assert.assertTrue(url.equalsIgnoreCase(WestPageURL));

	}
}
