package testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import data.DataDriven;
import utilities.Helper;

public class TestBase {

	public static WebDriver driver;

	@BeforeTest
	@Parameters({ "browser" })
	public void startDriver(@Optional("Chrome") String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		} else if (browserName.equalsIgnoreCase("chrome-headless")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		String homePageURL = DataDriven.getCellData("Prod_TD", "HomePageProdURL", 1);

		driver.navigate().to(homePageURL);
		//
	}

	@AfterTest
	public void exitDriver() throws InterruptedException {

		driver.quit();

	}

	@AfterMethod
	public void screenShotOnFailure(ITestResult result) throws InterruptedException {

		if (ITestResult.FAILURE == result.getStatus()) {
			// Take a screenshot when TC failed and add it in the the Screenshots Folder
			Thread.sleep(500);
			Helper.captureScreenShot(driver, result.getName().concat("TC Failed"));
			Thread.sleep(500);
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");

		}
		// Take a screenshot when TC Passed and add it in the the Screenshots Folder
		else if (ITestResult.SUCCESS == result.getStatus()) {
			Thread.sleep(500);
			Helper.captureScreenShot(driver, result.getName().concat("TC Passed"));
			Thread.sleep(500);
			System.out.println("Passed!");
			System.out.println("Taking Screenshot....");

		}
	}

}
