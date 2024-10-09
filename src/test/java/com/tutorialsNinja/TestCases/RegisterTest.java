package com.tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNinja.Pages.AccountSuccessPage;
import com.tutorialsNinja.Pages.LandingPage;
import com.tutorialsNinja.Pages.RegisterPage;
import com.tutorialsNinja.TestBase.TestBase;
import com.tutorialsNinja.TestData.DataProvider_Data;
import com.tutorialsNinja.TestData.Topic1_ExcelCode;
import com.tutorialsNinja.Utilities.Utils;

public class RegisterTest extends TestBase{
	
	public RegisterTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public LandingPage landingpage;
	public RegisterPage registerpage;
	public AccountSuccessPage accountsuccesspage;

	@BeforeMethod
	public void loginSetup() {
		driver = initializeBrowserOpenApplication(prop.getProperty("browser"));
		landingpage = new LandingPage(driver);
		landingpage.clickOnMyAccountDropdown();
		landingpage.clickOnRegisterOption(); //System navigates to RegisterPage
	}
	
	
	@Test(priority=1, dataProvider = "TNRegister", dataProviderClass = Topic1_ExcelCode.class, enabled = false)
	public void verifyRegisterWithMandatoryDetails(String firstname, String lastname, String telephone, String password, String confirmPassword) {
		registerpage = new RegisterPage(driver);
		accountsuccesspage	= registerpage.combineMandatoryDetailsToNavigateToAccountSuccessPage(firstname, lastname, Utils.emailWithDateTimeStamp(), telephone, password, confirmPassword);
        System.out.println("Thread number - : > " + Thread.currentThread().getId());
        Assert.assertTrue(accountsuccesspage.displayStatusOfAccountSuccess());	
	}
	
	@Test(priority=2, dataProvider = "TNRegister", dataProviderClass = DataProvider_Data.class, enabled = false)
	public void verifyRegisterWithAllDetails(String firstname, String lastname, String telephone, String password, String confirmPassword) {
		registerpage = new RegisterPage(driver);
		accountsuccesspage = registerpage.combineAllDetailsToNavigateToAccountSuccessPage(firstname, lastname, Utils.emailWithDateTimeStamp(), telephone, password, confirmPassword);
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
		Assert.assertTrue(accountsuccesspage.displayStatusOfAccountSuccess());	
	}
	
	@Test(priority=3)
	public void verifyRegisterWithExistingEmail() {
		registerpage = new RegisterPage(driver);
		registerpage.combineAllDetailsToNavigateToAccountSuccessPage(dataprop.getProperty("firstname"), dataprop.getProperty("lastname"), 
				prop.getProperty("validEmail"), dataprop.getProperty("telephone"), dataprop.getProperty("password"), dataprop.getProperty("confirmPassword"));
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
		Assert.assertTrue(registerpage.retrieveExistingEmailWarningText().contains(dataprop.getProperty("existingEmailWarning")));
	}
	
	@Test(priority=4)
	public void verifyRegisterWithIncorrectConfirmPassword() {
		registerpage = new RegisterPage(driver);
		registerpage.combineAllDetailsToNavigateToAccountSuccessPage(dataprop.getProperty("firstname"), dataprop.getProperty("lastname"), 
				Utils.emailWithDateTimeStamp(), dataprop.getProperty("telephone"), dataprop.getProperty("password"), dataprop.getProperty("incorrectConfirmPassword"));
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
		Assert.assertTrue(registerpage.displayStatusOfIncorrectConfirmPassword());
	}
	
	@Test(priority=5)
	public void verifyRegisterWithNoDetails() {
		registerpage = new RegisterPage(driver);
		registerpage.clickOnContinueButton(); 
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
		Assert.assertTrue(registerpage.retrievePrivacyPolicyWarningText().contains(dataprop.getProperty("privacyPolicyWarning")));
		Assert.assertTrue(registerpage.displayStatusOfFirstname());
		Assert.assertTrue(registerpage.displayStatusOfLastname());
		Assert.assertTrue(registerpage.displayStatusOfEmail());
		Assert.assertTrue(registerpage.displayStatusOfTelephone());
		Assert.assertTrue(registerpage.displayStatusOfPassword());
			
	}
	
	
	@AfterMethod
	public void tearDown() {
       driver.quit();
	}

}
