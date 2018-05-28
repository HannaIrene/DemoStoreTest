package demoqastore.testproject.repo.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQaStoreTransactionResultsPage {
	WebDriver driver;

	public DemoQaStoreTransactionResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForTransactionsResultsPageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article[@id='post-30']")));
	}

	public WebElement getPurchasedProductName() {
		return driver.findElement(By.xpath("//table[thead[tr[th[text()='Name']]]]/tbody/tr/td[text()='Magic Mouse']"));
	}

	public WebElement getPurchasedProductQuantity() {
		return driver.findElement(By.xpath("//table[thead[tr[th[text()='Quantity']]]]/tbody/tr/td[text()='1']"));
	}
}
