package demoqastore.testproject.repo.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQaStoreAccessoriesPage {
	WebDriver driver;

	public DemoQaStoreAccessoriesPage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForAccessoriesPageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article[@id='post-105']")));
	}

	public WebElement getMagicMouseProductLink() {
		return driver.findElement(By.xpath("//a[text()='Magic Mouse']"));
	}

	public WebElement getMagicMouseAddToCartLink() {
		return driver.findElement(By.xpath("//div[h2[a[text()='Magic Mouse']]]/form/div/div/span/input[@name='Buy']"));
	}

	public WebElement getcheckoutLink() {
		return driver.findElement(By.xpath("//a[@title='Checkout']"));
	}
}
