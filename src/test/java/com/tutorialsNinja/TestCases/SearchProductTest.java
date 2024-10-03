package com.tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tutorialsNinja.Listeners.MyListeners;
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
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
	}
	
	@Test(priority=1)
	public void searchWithValidProduct() {
		landingpage = new LandingPage(driver);
		landingpage.enterProduct(dataprop.getProperty("validProduct"));
		landingpage.clickOnSearchButton(); //System navigates to ProductPage
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
		productpage = new ProductPage(driver);
		Assert.assertTrue(productpage.displayStatusOfHPLaptop());
	}
	
	@Test(priority=2)
	public void searchWithInvalidProduct() {
		landingpage = new LandingPage(driver);
		landingpage.enterProduct(dataprop.getProperty("invalidProduct"));
		//driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("invalidProduct"));
		landingpage.clickOnSearchButton();
		//driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
		productpage = new ProductPage(driver);
		Assert.assertTrue(productpage.displayStatusOfWarningMessage());
	}
	
	@Test(priority=3)
	public void searchWithNoProduct() {
		landingpage = new LandingPage(driver);
		landingpage.clickOnSearchButton();
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
		productpage = new ProductPage(driver);
		Assert.assertTrue(productpage.displayStatusOfWarningMessage());
	}
	
	
	@AfterMethod
	public void tearDown() {
       driver.quit();
	}

}
