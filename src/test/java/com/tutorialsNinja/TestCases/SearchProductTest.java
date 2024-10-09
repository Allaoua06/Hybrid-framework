package com.tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNinja.Pages.LandingPage;
import com.tutorialsNinja.Pages.ProductPage;
import com.tutorialsNinja.TestBase.TestBase;


public class SearchProductTest extends TestBase{
	
	public SearchProductTest() throws Exception {
		super();
	}


	public WebDriver driver;
	public LandingPage landingpage;
	public ProductPage productpage;

	@BeforeMethod
	public void loginSetup() {
		driver = initializeBrowserOpenApplication(prop.getProperty("browser"));
	}
	
	@Test(priority=1)
	public void searchWithValidProduct() {
		landingpage = new LandingPage(driver);
		productpage = landingpage.navigateToProductPage(dataprop.getProperty("validProduct"));
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
		Assert.assertTrue(productpage.displayStatusOfHPLaptop());
	}
	
	@Test(priority=2)
	public void searchWithInvalidProduct() {
		landingpage = new LandingPage(driver);
		productpage = landingpage.navigateToProductPage(dataprop.getProperty("invalidProduct"));
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
		Assert.assertFalse(productpage.displayStatusOfWarningMessage());
	}
	
	@Test(priority=3, dependsOnMethods = "searchWithInvalidProduct")
	public void searchWithNoProduct() {
		landingpage = new LandingPage(driver);
		productpage = landingpage.clickOnSearchButton();
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
		Assert.assertTrue(productpage.displayStatusOfWarningMessage());
	}
	
	
	@AfterMethod
	public void tearDown() {
       driver.quit();
	}

}
