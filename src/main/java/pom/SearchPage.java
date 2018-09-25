package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);

	}

	public void searchForValue(WebDriver driver,String searchValueLocator,String searchTXT) {
		
		WebElement searchInputTXT = driver.findElement(By.cssSelector((searchValueLocator)));
		 
		searchInputTXT.clear();
		setText(searchInputTXT, searchTXT);
		KeyPressEnter(searchInputTXT);

	}
}
