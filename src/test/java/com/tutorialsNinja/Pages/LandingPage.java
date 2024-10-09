package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public WebDriver driver;
	
	//identify the Objects
	//initialize the Objects
	//define the Objects
	
	@FindBy(linkText = "My Account")
	private WebElement MyAccountdropdown;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(name = "search")
	private WebElement searchTextBox;
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	//Actions to call these Objects
	public void clickOnMyAccountDropdown() {
		MyAccountdropdown.click();
	}
	
	public void clickOnLoginOption() {
		loginOption.click();
	}
	
	public LoginPage clickOnMyAccountAndClickOnLogin() {
		MyAccountdropdown.click();
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public void clickOnRegisterOption() {
		registerOption.click();
	}
	
	public void enterProduct(String ProductText) {
		searchTextBox.sendKeys(ProductText);
	}
	
	public ProductPage clickOnSearchButton() {
		searchButton.click();
		return new ProductPage(driver);
	}
	
	public ProductPage navigateToProductPage(String ProductText) {
		searchTextBox.sendKeys(ProductText);
		searchButton.click();
		return new ProductPage(driver);
	}

}
