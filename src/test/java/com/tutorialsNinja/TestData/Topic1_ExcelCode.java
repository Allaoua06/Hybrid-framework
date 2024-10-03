package com.tutorialsNinja.TestData;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Topic1_ExcelCode {

	// STEPS

	// 1. Create your Excel Sheet[or whatever excel sheet which is available that
	// acts as the data source]
	// 2. Make sure the Excel sheet is not open in your OS
	// 3. in your pom.xml file you need to add some dependencies - POI Apache
	// dependencies
	// 4. Copy the Excel sheet into the package
	public static FileInputStream ip;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellType celltype;

	public static Object[][] readFromExcelSheetTNLogin(String sheetName) throws Exception {
		// Step 1 - Create the Object of FileInputStream and pass the path of the Excel
		// sheet in the Constructor
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\tutorialsNinja\\TestData\\ExcelData.xlsx");

		// Step 2- Create the Object of XSSFWorkbook and pass the FileInputStream
		// reference in it's constructor
		workbook = new XSSFWorkbook(ip);

		// Step 3- Use the workbook reference to address individual sheet
		sheet = workbook.getSheet(sheetName);

		// Step 4 - We need to identify rows and cols
		int rows = sheet.getLastRowNum(); // I do not know how many rows are there.
		int cols = sheet.getRow(0).getLastCellNum();

		// Step 5 - Create a 2-D Object array and return the Object Array
		Object[][] data = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {
			row = sheet.getRow(i + 1);

			for (int j = 0; j < cols; j++) {
				cell = row.getCell(j);

				celltype = cell.getCellType();

				switch (celltype) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;

				case NUMERIC:
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
					break;

				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}

			}
		}

		return data;
	}

	@DataProvider(name = "TNLogin")
	public Object[][] getTNLoginExcelData() throws Exception {
		Object[][] loginData = Topic1_ExcelCode.readFromExcelSheetTNLogin("LoginTN");
		return loginData;
	}
	
	
	public static Object[][] readFromExcelSheetTNRegister(String sheetName) throws Exception {
		// Step 1 - Create the Object of FileInputStream and pass the path of the Excel
		// sheet in the Constructor
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\tutorialsNinja\\TestData\\ExcelData.xlsx");

		// Step 2- Create the Object of XSSFWorkbook and pass the FileInputStream
		// reference in it's constructor
		workbook = new XSSFWorkbook(ip);

		// Step 3- Use the workbook reference to address individual sheet
		sheet = workbook.getSheet(sheetName);

		// Step 4 - We need to identify rows and cols
		int rows = sheet.getLastRowNum(); // I do not know how many rows are there.
		int cols = sheet.getRow(0).getLastCellNum();

		// Step 5 - Create a 2-D Object array and return the Object Array
		Object[][] data = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {
			row = sheet.getRow(i + 1);

			for (int j = 0; j < cols; j++) {
				cell = row.getCell(j);

				celltype = cell.getCellType();

				switch (celltype) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;

				case NUMERIC:
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
					break;

				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}

			}
		}

		return data;
	}
	
	@DataProvider(name = "TNRegister")
	public Object[][] getTNRegisterExcelData() throws Exception {
		Object[][] registerData = Topic1_ExcelCode.readFromExcelSheetTNRegister("RegisterTN");
		return registerData;
	}

}
