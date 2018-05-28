package demoqastore.testproject.test.testsuite;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demoqastore.testproject.repo.ui.DemoQaStoreAccessoriesPage;
import demoqastore.testproject.repo.ui.DemoQaStoreCheckoutPage;
import demoqastore.testproject.repo.ui.DemoQaStoreDeliveryDetailsPage;
import demoqastore.testproject.repo.ui.DemoQaStoreHomePage;
import demoqastore.testproject.repo.ui.DemoQaStoreTransactionResultsPage;
import demoqastore.testproject.test.config.TestConfiguration;

public class TestOrderMagicMouse {
	WebDriver driver;
	DemoQaStoreHomePage homePage;
	DemoQaStoreAccessoriesPage accessoriesPage;
	DemoQaStoreCheckoutPage checkoutPage;
	DemoQaStoreDeliveryDetailsPage deliveryDetailsPage;
	DemoQaStoreTransactionResultsPage transactionsResultsPage;

	@BeforeMethod
	public void setUp() {
		driver = TestConfiguration.createDriverInstance();
		homePage = new DemoQaStoreHomePage(driver);
		accessoriesPage = new DemoQaStoreAccessoriesPage(driver);
		checkoutPage = new DemoQaStoreCheckoutPage(driver);
		deliveryDetailsPage = new DemoQaStoreDeliveryDetailsPage(driver);
		transactionsResultsPage = new DemoQaStoreTransactionResultsPage(driver);
	}

	@Test
	public void testBuyMagicMouse() throws InterruptedException {

		// Navigate to DemoQA Store - Landing Page
		homePage.waitForLandingPageToLoad();
		homePage.getAccessoriesLink().click();
		accessoriesPage.waitForAccessoriesPageToLoad();

		// Add Magic Mouse to Cart
		accessoriesPage.getMagicMouseAddToCartLink().click();
		Thread.sleep(10000);
		accessoriesPage.getcheckoutLink().click();

		// Verify Product details in Checkout Page
		checkoutPage.waitForCheckoutPageToLoad();
		String actual_productName = checkoutPage.getProductNameLabel().getText();
		String expected_productName = "Magic Mouse";
		Assert.assertEquals(actual_productName, expected_productName);
		String actual_productQuantity2 = checkoutPage.getProductQuantityTextBox();
		String expected_productQuantity2 = "1";
		Assert.assertEquals(actual_productQuantity2, expected_productQuantity2);
		checkoutPage.getContinueButton().click();

		// ENTER BILLING AND SHIPPING DETAILS
		deliveryDetailsPage.waitForDeliveryDetailsPageToLoad();
		deliveryDetailsPage.getShippingStateTextbox().sendKeys("Ontario");
		deliveryDetailsPage.getEmailAddressTextbox().sendKeys("abysmith@gmail.com");
		deliveryDetailsPage.getFirstNameBillingDetailsTextbox().sendKeys("Aby");
		deliveryDetailsPage.getLastNameBillingDetailsTextbox().sendKeys("Smith");
		deliveryDetailsPage.getAddressBillingDetailsTextarea().sendKeys("25 G Road, Scarborough ON");
		deliveryDetailsPage.getCityBillingDetailsTextbox().sendKeys("Toronto");
		deliveryDetailsPage.getProvinceBillingDetailsTextbox().sendKeys("Ontario");
		deliveryDetailsPage.getCountryBillingDetailsDropdown("Canada");
		deliveryDetailsPage.getPostalCodeBillingDetailsTextbox().sendKeys("M1B 0B4");
		deliveryDetailsPage.getPhoneNumberBillingDetailsTextbox().sendKeys("416-775-4800");
		deliveryDetailsPage.getFirstNameShippingAddressTextbox().sendKeys("Ann");
		deliveryDetailsPage.getLastNameShippingAddressTextbox().sendKeys("Smith");
		deliveryDetailsPage.getAddressShippingAddressTextarea().sendKeys("18 C Road Scarborough ON");
		deliveryDetailsPage.getCityShippingAddressTextbox().sendKeys("Toronto");
		deliveryDetailsPage.getCountryShippingAddressDropdown("Canada");
		deliveryDetailsPage.getPostalCodeShippingAddressTextbox().sendKeys("M1B 1C4");
		deliveryDetailsPage.getPurchaseButton().click();

		// Confirming order purchase in the Transactions Details Page
		transactionsResultsPage.waitForTransactionsResultsPageToLoad();
		String actualProductName = transactionsResultsPage.getPurchasedProductName().getText();
		String expectedProductName = "Magic Mouse";
		Assert.assertEquals(actualProductName, expectedProductName);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
