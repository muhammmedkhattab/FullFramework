package testcases;

import java.io.File;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import data.DataDriven;
import utilities.Helper;

public class GridBase {
	public String homePageURL = DataDriven.getCellData("Prod_TD", "HomePageProdURL", 1);
	////////////////////////////////////////////
	//public static WebDriver driver;
	////////////////////////////// @Optional("chrome") ////////////////
	protected ThreadLocal<RemoteWebDriver> driverGrid = null;

	@BeforeTest
	@Parameters(value = { "browserName" })
	public void startGrid(String browser) throws Exception {

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			// driver = new ChromeDriver();
			//driverGrid = new ThreadLocal<>();
			DesiredCapabilities caps = new DesiredCapabilities();

			System.out.println("Test::" + browser);
			caps.setCapability("browserName", browser);
			driverGrid.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		
			getDriver().navigate().to(homePageURL);

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			// driver = new FirefoxDriver();
			System.out.println("Test::" + browser);
			//driverGrid = new ThreadLocal<>();
			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability("browserName", browser);
			driverGrid.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
			getDriver().navigate().to(homePageURL);

		}

	}

	public WebDriver getDriver() {

		return driverGrid.get();
	}

	@AfterClass
	public void exitDriver() throws InterruptedException {

		getDriver().quit();
		driverGrid.remove();

	}

	@AfterMethod
	public void screenShotOnFailure(ITestResult result) throws InterruptedException {

		if (ITestResult.FAILURE == result.getStatus()) {
			// Take a screenshot when TC failed and add it in the the Screenshots Folder
			Thread.sleep(500);
			Helper.captureScreenShot(getDriver(), result.getName().concat("TC Failed"));
			Thread.sleep(500);
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");

		}
		// Take a screenshot when TC Passed and add it in the the Screenshots Folder
		else if (ITestResult.SUCCESS == result.getStatus()) {
			Thread.sleep(500);
			Helper.captureScreenShot(getDriver(), result.getName().concat("TC Passed"));
			Thread.sleep(500);
			System.out.println("Passed!");
			System.out.println("Taking Screenshot....");

		}
	}

}
