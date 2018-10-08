package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

	public static Properties suceLabData = loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\sauceLab.properties");

	private static Properties loadProperties(String path) {
     System.out.println(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\sauceLab.properties");
		Properties pro = new Properties();
		// stream to read file
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (IOException e) {
			System.out.println("File not found" + e.getMessage());

		}
		return pro;

	}
}
