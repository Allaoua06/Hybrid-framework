package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	public WebDriver driver;

	@FindBy(id = "input-firstname")
	private WebElement firstNameTextBox;

	@FindBy(id = "input-lastname")
	private WebElement lastNameTextBox;

	@FindBy(id = "input-email")
	private WebElement emailTextBox;

	@FindBy(id = "input-telephone")
	private WebElement telephoneTextBox;

	@FindBy(id = "input-password")
	private WebElement passwordTextBox;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordTextBox;

	@FindBy(name = "agree")
	private WebElement privacyPolicyCheckbox;

	@FindBy(xpath = "//input[@name = 'newsletter' and @value = '1']")
	private WebElement YesSubscributeRadioButton;

	@FindBy(css = "input.btn.btn-primary")
	private WebElement continueButton;

	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement existingEmailWarning;

	@FindBy(xpath = "//div[text() = 'Password confirmation does not match password!']")
	private WebElement incorrectConfirmPasswordWarning;

	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement privacyPolicyWarning;

	@FindBy(xpath = "//div[text() = 'First Name must be between 1 and 32 characters!']")
	private WebElement firstnameWarning;

	@FindBy(xpath = "//div[text() = 'Last Name must be between 1 and 32 characters!']")
	private WebElement lastnameWarning;

	@FindBy(xpath = "//div[text() = 'E-Mail Address does not appear to be valid!']")
	private WebElement emailWarning;

	@FindBy(xpath = "//div[text() = 'Telephone must be between 3 and 32 characters!']")
	private WebElement telephoneWarning;

	@FindBy(xpath = "//div[text() = 'Password must be between 4 and 20 characters!']")
	private WebElement passwordWarning;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFirstName(String firstnameText) {
		firstNameTextBox.sendKeys(firstnameText);
	}

	public void enterLastName(String lastnameText) {
		lastNameTextBox.sendKeys(lastnameText);
	}

	public void enterEmail(String emailText) {
		emailTextBox.sendKeys(emailText);
	}

	public void enterTelephone(String telephoneText) {
		telephoneTextBox.sendKeys(telephoneText);
	}

	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}

	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPasswordTextBox.sendKeys(confirmPasswordText);
	}

	public void clickOnPrivacyPolicyCheckBox() {
		privacyPolicyCheckbox.click();
	}

	public void selectYesSubscribeRadioButton() {
		YesSubscributeRadioButton.click();
	}

	public void clickOnContinueButton() {
		continueButton.click();
	}

	public AccountSuccessPage combineMandatoryDetailsToNavigateToAccountSuccessPage(String firstnameText,
			String lastnameText, String emailText, String telephoneText, String passwordText,
			String confirmPasswordText) {
		firstNameTextBox.sendKeys(firstnameText);
		lastNameTextBox.sendKeys(lastnameText);
		emailTextBox.sendKeys(emailText);
		telephoneTextBox.sendKeys(telephoneText);
		passwordTextBox.sendKeys(passwordText);
		confirmPasswordTextBox.sendKeys(confirmPasswordText);
		privacyPolicyCheckbox.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}

	public AccountSuccessPage combineAllDetailsToNavigateToAccountSuccessPage(String firstnameText, String lastnameText,
			String emailText, String telephoneText, String passwordText, String confirmPasswordText) {
		firstNameTextBox.sendKeys(firstnameText);
		lastNameTextBox.sendKeys(lastnameText);
		emailTextBox.sendKeys(emailText);
		telephoneTextBox.sendKeys(telephoneText);
		passwordTextBox.sendKeys(passwordText);
		confirmPasswordTextBox.sendKeys(confirmPasswordText);
		YesSubscributeRadioButton.click();
		privacyPolicyCheckbox.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}

	public String retrieveExistingEmailWarningText() {
		String text = existingEmailWarning.getText();
		return text;
	}

	public boolean displayStatusOfIncorrectConfirmPassword() {
		boolean displayStatus = incorrectConfirmPasswordWarning.isDisplayed();
		return displayStatus;
	}

	public String retrievePrivacyPolicyWarningText() {
		String text = privacyPolicyWarning.getText();
		return text;
	}

	public boolean displayStatusOfFirstname() {
		boolean displayStatus = firstnameWarning.isDisplayed();
		return displayStatus;
	}

	public boolean displayStatusOfLastname() {
		boolean displayStatus = lastnameWarning.isDisplayed();
		return displayStatus;
	}

	public boolean displayStatusOfEmail() {
		boolean displayStatus = emailWarning.isDisplayed();
		return displayStatus;
	}

	public boolean displayStatusOfTelephone() {
		boolean displayStatus = telephoneWarning.isDisplayed();
		return displayStatus;
	}

	public boolean displayStatusOfPassword() {
		boolean displayStatus = passwordWarning.isDisplayed();
		return displayStatus;
	}
}
