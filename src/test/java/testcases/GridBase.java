package testcases;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import data.DataDriven;
import data.LoadProperties;
import utilities.Helper;

public class GridBase {
	// sauce Lab conf

	public static final String USERNAME = LoadProperties.suceLabData.getProperty("username");
	public static final String Access_key = LoadProperties.suceLabData.getProperty("accesskey");
	public static final String sauceURL = "http://" + USERNAME + ":" + Access_key+ LoadProperties.suceLabData.getProperty("seleniumURL");
	public static final String localHost="http://localhost:4444/wd/hub";
	public static RemoteWebDriver driverGrid;
	public String homePageURL = DataDriven.getCellData("Prod_TD", "HomePageProdURL", 1);
	public DesiredCapabilities caps = null;

	@BeforeTest
	@Parameters(value = { "browserName" })
	public void startGrid(@Optional("chrome")String browserName) throws Exception {
		
		switch (browserName.toLowerCase()) {

		case "chrome":
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			caps = DesiredCapabilities.chrome();
			break;
			
		case "firefox":
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			caps = DesiredCapabilities.firefox();
			caps.setBrowserName("firefox");
			//caps.setCapability("platform", "Windows 10");
			//caps.setCapability("version", "62.0");
			break;

		default:
			System.out.println("passed Grid");
			break;
		}
		//sauceURL
		//localHost
		driverGrid = new RemoteWebDriver(new URL(sauceURL), caps);
		//driverGrid.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));

		driverGrid.navigate().to(homePageURL);

	}

	@AfterTest
	public void exitDriver() throws InterruptedException {

		driverGrid.quit();

	}

	
	@AfterMethod
	public void screenShotOnFailure(ITestResult result) throws InterruptedException {

		if (ITestResult.FAILURE == result.getStatus()) {
			// Take a screenshot when TC failed and add it in the the Screenshots Folder
			Thread.sleep(500);
			Helper.captureScreenShot(driverGrid, result.getName().concat("TC Failed"));
			Thread.sleep(500);
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");

		}
		// Take a screenshot when TC Passed and add it in the the Screenshots Folder
		else if (ITestResult.SUCCESS == result.getStatus()) {
			Thread.sleep(500);
			Helper.captureScreenShot(driverGrid, result.getName().concat("TC Passed"));
			Thread.sleep(500);
			System.out.println("Passed!");
			System.out.println("Taking Screenshot....");

		}
	}
}
