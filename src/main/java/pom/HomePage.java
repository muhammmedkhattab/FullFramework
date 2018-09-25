package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {

		super(driver);
		// scroll down
		jse = (JavascriptExecutor) driver;

	}

	// Search Method
	public void openSearch(WebDriver driver, String searchLocator) {
		WebElement searchtxt = driver.findElement(By.cssSelector((searchLocator)));
		clickButton(searchtxt);

	}

	// Click Method
	public void clickOnContactLink(WebDriver driver, String contactLinkLocator) {

		WebElement contactBtn = driver.findElement(By.linkText((contactLinkLocator)));
		scrollToBottom();
		clickButton(contactBtn);

	}

	//// Subscribe Method
	public void Subscribe(WebDriver driver, String confirmbtnLocator, String emailLocator, String submitBtnLocator,
			String email) throws InterruptedException {

		scrollToBottom();
		Thread.sleep(1000);

		WebElement confirmbtn = driver.findElement(By.id((confirmbtnLocator)));
		clickButton(confirmbtn);

		WebElement emailTXT = driver.findElement(By.name((emailLocator)));
		clickButton(emailTXT);
		setText(emailTXT, email);

		WebElement submitBtn = driver.findElement(By.cssSelector((submitBtnLocator)));
		clickButton(submitBtn);

	}

	public void navigateSideMenu(WebDriver driver, String sideMenuBtnLocator, String menuItemLocator) {

		// side menu
		WebElement sideMenuBtn = driver.findElement(By.cssSelector((sideMenuBtnLocator)));
		clickButton(sideMenuBtn);

		// item in side menu
		WebElement menuItem = driver.findElement(By.linkText(menuItemLocator));
		clickButton(menuItem);

	}

	// done
	public void selectLanguage(WebDriver driver, String searchlocator, String Language) {

		scrollToBottom();

		WebElement languageDropdownList = driver.findElement(By.cssSelector((searchlocator)));
		select = new Select(languageDropdownList);
		select.selectByVisibleText(Language);
	}

}
