package com.tutorialsNinja.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	//Step 1 - Add extentreports dependency in pom.xml file
	
	//Step 2 - Create a method known as generateExtentReport()
	
	public static ExtentReports generateExtentReport() throws Exception {
		
	//Step 3 - Create the Object of ExtentReports class
		ExtentReports extentReport = new ExtentReports();
		
    //Step 4 - in your project under test-output folder just create a folder within the code.
		
	//Step 5 - Create the Object of File class and pass the path of the .html file in the constructor
		File extentReportFile = new File(System.getProperty("user.dir")+ "\\test-output\\ExtentReports\\extentreporter.html");
		
   //Step 6 - Create the object of ExtentSparkReporter class and pass the path of the file in it's constructor
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
	//Step 7 - Using the sparkReporter we can configure a lot of things in our .html file
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TN Automation Hybrid Results");
		sparkReporter.config().setDocumentTitle("TNReportTitle | PnTJuly24_Oct_24_Weekday_Batch");
		sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
		
	//Step 8 - We need to attach the ExtentReport with the SparkReporter
		extentReport.attachReporter(sparkReporter);
		
		Properties prop = new Properties();	
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\tutorialsNinja\\Config\\config.properties");
		prop.load(ip);
	
    //Step 9 - You can pass on additional information about your project or your computer or others in your Extent Reports
		extentReport.setSystemInfo("application url", prop.getProperty("url"));
		extentReport.setSystemInfo("email", prop.getProperty("validEmail"));
		extentReport.setSystemInfo("password", prop.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating System", prop.getProperty("os.name"));
		extentReport.setSystemInfo("Operating System version detail", prop.getProperty("os.version"));
		extentReport.setSystemInfo("Tester Responsible", prop.getProperty("user.name"));
		extentReport.setSystemInfo("java version", prop.getProperty("java.version"));
		extentReport.setSystemInfo("java vendor", prop.getProperty("java.vendor"));
		
		//Step 10 - return the extentReport
		return extentReport;
		
	}

}
