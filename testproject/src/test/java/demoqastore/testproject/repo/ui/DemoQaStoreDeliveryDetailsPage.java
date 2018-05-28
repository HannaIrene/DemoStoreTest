package demoqastore.testproject.repo.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demoqastore.testproject.util.DropDownHandlers;

public class DemoQaStoreDeliveryDetailsPage {
	WebDriver driver;

	public DemoQaStoreDeliveryDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForDeliveryDetailsPageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Calculate Shipping Price']")));
	}

	public WebElement getShippingStateTextbox() {
		return driver.findElement(By.xpath("//input[@title='shippingstate']"));
	}

	public WebElement getEmailAddressTextbox() {
		return driver.findElement(By.id("wpsc_checkout_form_9"));
	}

	public WebElement getFirstNameBillingDetailsTextbox() {
		return driver.findElement(By.id("wpsc_checkout_form_2"));
	}

	public WebElement getLastNameBillingDetailsTextbox() {
		return driver.findElement(By.id("wpsc_checkout_form_3"));
	}

	public WebElement getAddressBillingDetailsTextarea() {
		return driver.findElement(By.id("wpsc_checkout_form_4"));
	}

	public WebElement getCityBillingDetailsTextbox() {
		return driver.findElement(By.id("wpsc_checkout_form_5"));
	}

	public WebElement getProvinceBillingDetailsTextbox() {
		return driver.findElement(By.id("wpsc_checkout_form_6"));
	}

	public void getCountryBillingDetailsDropdown(String text) {
		WebElement ddl = driver.findElement(By.id("wpsc_checkout_form_7"));
		DropDownHandlers.selectDDLByVisibleText(ddl, text);
	}

	public WebElement getPostalCodeBillingDetailsTextbox() {
		return driver.findElement(By.id("wpsc_checkout_form_8"));
	}

	public WebElement getPhoneNumberBillingDetailsTextbox() {
		return driver.findElement(By.id("wpsc_checkout_form_18"));
	}

	public WebElement getShippingAddressCheckbox() {
		return driver.findElement(By.id("shippingSameBilling"));
	}

	public WebElement getFirstNameShippingAddressTextbox() {
		return driver.findElement(By.id("wpsc_checkout_form_11"));
	}

	public WebElement getLastNameShippingAddressTextbox() {
		return driver.findElement(By.id("wpsc_checkout_form_12"));
	}

	public WebElement getAddressShippingAddressTextarea() {
		return driver.findElement(By.id("wpsc_checkout_form_13"));
	}

	public WebElement getCityShippingAddressTextbox() {
		return driver.findElement(By.id("wpsc_checkout_form_14"));
	}

	public WebElement getProvinceShippingAddressTextbox() {
		return driver.findElement(By.id("wpsc_checkout_form_15"));
	}

	public void getCountryShippingAddressDropdown(String text) {
		WebElement ddl = driver.findElement(By.id("wpsc_checkout_form_16"));
		DropDownHandlers.selectDDLByVisibleText(ddl, text);
	}

	public WebElement getPostalCodeShippingAddressTextbox() {
		return driver.findElement(By.id("wpsc_checkout_form_17"));
	}

	/*
	 * public WebElement getTotalShippingValue() { return
	 * driver.findElement(By.id("wpsc_checkout_form_17")); }
	 */
	// Write code (with independent and dependent xpath to TOTAL SHIPPING, ITEM
	// COST, TAX, TOTAL PRICE)
	public WebElement getPurchaseButton() {
		return driver.findElement(By.xpath("//input[@class='make_purchase wpsc_buy_button']"));
	}

	public WebElement getGoBackButton() {
		return driver.findElement(By.xpath("//span[text()='Go Back']"));
	}
}
