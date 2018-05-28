package demoqastore.testproject.test.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import demoqastore.testproject.util.DataHandlers;

public class TestConfiguration {
	public static WebDriver createDriverInstance() {
		String browser = DataHandlers.getDataFromProperty("configuration", "browser");
		String url = DataHandlers.getDataFromProperty("configuration", "url");

		String app_url = null;
		WebDriver driver = null;

		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.marionette",
					"./browser-servers/" + "geckodriver-v0.16.0-win64/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (url.equals("release")) {
			app_url = DataHandlers.getDataFromProperty("configuration", "release");
		} else if (url.equals("develop")) {
			app_url = DataHandlers.getDataFromProperty("configuration", "develop");
		}
		driver.get(app_url);
		return driver;
	}
}
