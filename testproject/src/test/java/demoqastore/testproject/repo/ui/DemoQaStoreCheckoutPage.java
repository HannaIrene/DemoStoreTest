package demoqastore.testproject.repo.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQaStoreCheckoutPage {
	WebDriver driver;

	public DemoQaStoreCheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForCheckoutPageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slide1']")));
	}

	public WebElement getProductNameLabel() {
		return driver.findElement(By.xpath("//a[text()='Magic Mouse']"));
	}

	public String getProductQuantityTextBox() {
		return driver.findElement(By.name("quantity")).getAttribute("value");
	}

	/*
	 * public WebElement getPriceValue() { return driver.findElement(By.xpath(""));
	 * } public WebElement getTotalPriceValue() { return
	 * driver.findElement(By.xpath("")); }
	 */
	public WebElement getRemoveButton() {
		return driver.findElement(By.xpath("//input[@value='Remove']"));
	}

	public WebElement getContinueButton() {
		return driver.findElement(By.xpath("//span[text()='Continue']"));
	}
}
