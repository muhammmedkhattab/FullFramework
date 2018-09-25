package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	// Method to take screenshot
	public static void captureScreenShot(WebDriver driver, String screenshotname) {
		Path dest = Paths.get("./screenshots",
				screenshotname + new SimpleDateFormat(" yyyy-MM-dd-HH-mm").format(new Date()) + ".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {

			System.out.println("Excpetion while taking screenshot" + e.getMessage());

		}
	}

}
