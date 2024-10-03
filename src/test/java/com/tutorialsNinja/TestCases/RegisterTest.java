package com.tutorialsNinja.TestCases;

import org.openqa.selenium.By;
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
	
	
	@Test(priority=1, dataProvider = "TNRegister", dataProviderClass = Topic1_ExcelCode.class)
	public void verifyRegisterWithMandatoryDetails(String firstname, String lastname, String telephone, String password, String confirmPassword) {
		registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(firstname);
		registerpage.enterLastName(lastname);
		registerpage.enterEmail(Utils.emailWithDateTimeStamp());
		registerpage.enterTelephone(telephone);
		registerpage.enterPassword(password);
		registerpage.enterConfirmPassword(confirmPassword);
		registerpage.clickOnPrivacyPolicyCheckBox();
		registerpage.clickOnContinueButton(); //System navigates to AccountSuccessPage
        System.out.println("Thread number - : > " + Thread.currentThread().getId());
        accountsuccesspage = new AccountSuccessPage(driver);
        Assert.assertTrue(accountsuccesspage.displayStatusOfAccountSuccess());	
	}
	
	@Test(priority=2, dataProvider = "TNRegister", dataProviderClass = DataProvider_Data.class)
	public void verifyRegisterWithAllDetails(String firstname, String lastname, String telephone, String password, String confirmPassword) {
		registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(firstname);
		registerpage.enterLastName(lastname);
		registerpage.enterEmail(Utils.emailWithDateTimeStamp());
		registerpage.enterTelephone(telephone);
		registerpage.enterPassword(password);
		registerpage.enterConfirmPassword(confirmPassword);
		registerpage.selectYesSubscribeRadioButton();
		registerpage.clickOnPrivacyPolicyCheckBox();
		registerpage.clickOnContinueButton(); 
	    Assert.assertTrue(accountsuccesspage.displayStatusOfAccountSuccess());	
	}
	
	@Test(priority=3)
	public void verifyRegisterWithExistingEmail() {
		registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataprop.getProperty("firstname"));
		registerpage.enterLastName(dataprop.getProperty("lastname"));
		registerpage.enterEmail(prop.getProperty("validEmail"));
		registerpage.enterTelephone(dataprop.getProperty("telephone"));
		registerpage.enterPassword(dataprop.getProperty("password"));
		registerpage.enterConfirmPassword(dataprop.getProperty("confirmPassword"));
		registerpage.selectYesSubscribeRadioButton();
		registerpage.clickOnPrivacyPolicyCheckBox();
		registerpage.clickOnContinueButton(); 
	
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
		String actualWarningMessage = registerpage.retrieveExistingEmailWarningText();
		String expectedWarningMessage = dataprop.getProperty("existingEmailWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	}
	
	@Test(priority=4)
	public void verifyRegisterWithIncorrectConfirmPassword() {
		registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataprop.getProperty("firstname"));
		registerpage.enterLastName(dataprop.getProperty("lastname"));
		registerpage.enterEmail(Utils.emailWithDateTimeStamp());
		registerpage.enterTelephone(dataprop.getProperty("telephone"));
		registerpage.enterPassword(dataprop.getProperty("password"));
		registerpage.enterConfirmPassword(dataprop.getProperty("incorrectConfirmPassword"));
		registerpage.selectYesSubscribeRadioButton();
		registerpage.clickOnPrivacyPolicyCheckBox();
		registerpage.clickOnContinueButton(); 
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
		Assert.assertTrue(registerpage.displayStatusOfIncorrectConfirmPassword());
	}
	
	@Test(priority=5)
	public void verifyRegisterWithNoDetails() {
		registerpage = new RegisterPage(driver);
		registerpage.clickOnContinueButton(); 
		System.out.println("Thread number - : > " + Thread.currentThread().getId());
			
		String actualWarningMessage = registerpage.retrievePrivacyPolicyWarningText();
		String expectedWarningMessage = dataprop.getProperty("privacyPolicyWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
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
