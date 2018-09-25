package testcases;

import org.testng.annotations.Test;
import pom.PageBase;

public class ValidateLinksTest extends TestBase {

	PageBase pageObject;

	@Test(priority = 6)
	public void validateAllLink() throws InterruptedException {
		// This TC validates all link in the home page are running successfully
		Thread.sleep(500);
		pageObject = new PageBase(driver);
		pageObject.testBrokenLinks(driver);
		
	}
}
