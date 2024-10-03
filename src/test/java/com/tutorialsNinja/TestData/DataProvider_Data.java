package com.tutorialsNinja.TestData;

import org.testng.annotations.DataProvider;

public class DataProvider_Data {

	@DataProvider(name = "TNLogin")
	public Object[][] getLoginData(){
		
		Object[][] getData = { {"seleniumpanda@gmail.com", "Selenium@123"},
				               {"seleniumpanda1@gmail.com", "Selenium@123"},
				               {"seleniumpanda2@gmail.com", "Selenium@123"},
				               {"seleniumpanda3@gmail.com", "Selenium@123"},
				               {"seleniumpanda4@gmail.com", "Selenium@123"},
				               {"seleniumpanda5@gmail.com", "Selenium@123"},
				               {"seleniumpanda6@gmail.com", "Selenium@123"},
				               {"seleniumpanda7@gmail.com", "Selenium@123"},
				               {"seleniumpanda8@gmail.com", "Selenium@123"}};
		return getData;
				
		}
		
		
	@DataProvider(name = "TNRegister")
	public Object[][] getRegisterData(){
		
		Object[][] getData = { {"Selenium", "Panda", "9876543210", "Selenium@123", "Selenium@123"},
				               {"Selenium", "Panda", "9876543210", "Selenium@123", "Selenium@123"},
				               {"Selenium", "Panda", "9876543210", "Selenium@123", "Selenium@123"},
				               {"Selenium", "Panda", "9876543210", "Selenium@123", "Selenium@123"},
				               {"Selenium", "Panda", "9876543210", "Selenium@123", "Selenium@123"},
				               {"Selenium", "Panda", "9876543210", "Selenium@123", "Selenium@123"},
				               {"Selenium", "Panda", "9876543210", "Selenium@123", "Selenium@123"},
				               {"Selenium", "Panda", "9876543210", "Selenium@123", "Selenium@123"},
				               {"Selenium", "Panda", "9876543210", "Selenium@123", "Selenium@123"}};
		return getData;
				
		}
		
		
	}

