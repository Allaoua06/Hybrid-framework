package com.tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNinja.Pages.AccountPage;
import com.tutorialsNinja.Pages.LandingPage;
import com.tutorialsNinja.Pages.LoginPage;
import com.tutorialsNinja.TestBase.TestBase;
import com.tutorialsNinja.TestData.Topic1_ExcelCode;


public class LoginTest extends TestBase{

	public LoginTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public LandingPage landingpage;
	public LoginPage loginpage;
	public AccountPage accountpage;

	@BeforeMethod
	public void loginSetup() {
		driver = initializeBrowserOpenApplication(prop.getProperty("browser"));
		landingpage = new LandingPage(driver);
	    loginpage = landingpage.clickOnMyAccountAndClickOnLogin(); //system will navigate to LoginPage
		
	    
	  //landingpage.clickOnMyAccountDropdown();
	  		//driver.findElement(By.linkText("My Account")).click();
	    //driver.findElement(By.linkText("Login")).click();
	}

	@Test(priority = 1, dataProvider = "TNLogin", dataProviderClass = Topic1_ExcelCode.class)
	public void verifyLoginWithValidCredentials(String email, String password) {
		loginpage = new LoginPage(driver);	
		accountpage = loginpage.directlyGoToAccountPage(email, password);
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
		Assert.assertTrue(accountpage.validateDisplayStatusOfLogoutLink());
	}
	
	@Test(priority = 2)
	public void verifyLoginWithValidEmailInvalidPassword() {
		loginpage = new LoginPage(driver);
		loginpage.directlyGoToAccountPage(prop.getProperty("validEmail"), dataprop.getProperty("invalidPassword"));
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
		Assert.assertTrue(loginpage.retrieveLoginMessageWarningText().contains(loginpage.retrieveLoginMessageWarningText()));
	}
	
	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailValidPassword() {
		loginpage = new LoginPage(driver);
		loginpage.directlyGoToAccountPage(dataprop.getProperty("invalidEmail"), prop.getProperty("validPassword"));
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
		Assert.assertTrue(loginpage.retrieveLoginMessageWarningText().contains(dataprop.getProperty("invalidLoginWarning")));
	}
	
	@Test(priority = 4)
	public void verifyLoginWithInvalidCredentials() {
		loginpage = new LoginPage(driver);
		loginpage.directlyGoToAccountPage(dataprop.getProperty("invalidEmail"), dataprop.getProperty("invalidPassword"));
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
		Assert.assertTrue(loginpage.retrieveLoginMessageWarningText().contains(dataprop.getProperty("invalidLoginWarning")));
	}
	
	@Test(priority = 5)
	public void verifyLoginWithNoCredentials() {
		loginpage.clickOnLoginButton();	
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
		Assert.assertTrue(loginpage.retrieveLoginMessageWarningText().contains(dataprop.getProperty("invalidLoginWarning")));
	}

	@AfterMethod
	public void tearDown() {
       driver.quit();
	}

}
