package pom;

import java.util.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	protected WebDriver driver;
	public static JavascriptExecutor jse;
	public Select select;
	public Actions action;
	public static String currentWindowID = null;

	// create constructor
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// Method to Click Buttons
	protected static void clickButton(WebElement button) {

		button.click();
	}

	// Method to send Keys
	protected static void setText(WebElement textElement, String value) {

		textElement.sendKeys(value);
	}

	public void scrollToBottom() {

		jse.executeScript("scrollBy(0,4500)");
	}

	public void KeyPressEnter(WebElement webElement) {

		webElement.sendKeys(Keys.RETURN);
	}

	public void WindowHandling(WebDriver driver, String NewPageURL) {
		currentWindowID = driver.getWindowHandle();

		for (String windowID : driver.getWindowHandles()) {

			driver.switchTo().window(windowID);
			String URL = driver.getCurrentUrl();

			if (URL.contains(URL))

			{
			}

		}

	}

	public void redirectToDriver(WebDriver driver) {

		driver.switchTo().window(currentWindowID);
		System.out.println("URL:  " + driver.getCurrentUrl());

	}

	public void testBrokenLinks(WebDriver driver) {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links :" + links.size());

		for (int i = 0; i < links.size(); i++) {

			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			verifyLink(url);
		}

	}

	public void verifyLink(String urlLink) {
		try {
			URL link = new URL(urlLink);
			// connection using URL
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			httpConn.setConnectTimeout(2000);
			httpConn.connect();
			if (httpConn.getResponseCode() == 200) {
				System.out.println(urlLink + "  -  " + httpConn.getResponseMessage());
			}
			if (httpConn.getResponseCode() == 404) {
				System.out.println(urlLink + "  -  " + httpConn.getResponseMessage());
			}
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
