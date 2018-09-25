package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ContactPage extends PageBase {

	public ContactPage(WebDriver driver) {
		super(driver);

	}
public static String message;

	public void fillContactForum(WebDriver driver, String contactMessageLocator, String fullNameLocator,
			String emailTXTLocator, String confirmCheckBoxLocator, String clickButtonLocator, String Message,
			String FullName, String Email) throws InterruptedException {

		WebElement contactMessage = driver.findElement(By.cssSelector(contactMessageLocator));
		setText(contactMessage, Message);

		WebElement fullNameTxt = driver.findElement(By.cssSelector(fullNameLocator));
		setText(fullNameTxt, FullName);

		WebElement emailTXT = driver.findElement(By.id(emailTXTLocator));
		setText(emailTXT, Email);
		Thread.sleep(500);

		WebElement confirmCheckBox = driver.findElement(By.id(confirmCheckBoxLocator));
		clickButton(confirmCheckBox);

		jse.executeScript("scrollBy(0,1500)");
		Thread.sleep(500);

		WebElement contactBtn = driver.findElement(By.cssSelector(clickButtonLocator));
		clickButton(contactBtn);
	}

	public void ValidateMessage(WebDriver driver, String successMessageLocator) {

		WebElement successMessage = driver.findElement(By.cssSelector(successMessageLocator));
		 message = successMessage.getText();
		
	}

}
