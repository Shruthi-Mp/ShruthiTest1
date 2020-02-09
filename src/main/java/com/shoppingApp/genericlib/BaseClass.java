package com.shoppingApp.genericlib;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass
{
	public static FileLib f=new FileLib();
	public static WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	
	Connection connect;
	Statement stat;
	ResultSet results;
	@BeforeSuite 
	public void connectDB() throws ClassNotFoundException, SQLException
	{
		/*System.out.println("connecting to DB");
		
		//create driver class object
		Class.forName("com.mysql.jdbc.Driver");
		
		//create connection object
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306","rootsh","root");
		
		//create statement object
		stat = connect.createStatement();
		
		//execute query
		results = stat.executeQuery("Select * from Customers");
		
		//get values from database
		while(results.next())
		{
			String res=results.getNString(1);
			Reporter.log(res, true);
		} */
	}
	@BeforeClass
	public void launchBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Utility.screenshot(driver);
		//driver.get(f.fetchDataFromProperty("amazon_url"));
		//driver.get(f.fetchDataFromProperty("flipkart_url"));
		System.out.println("launching browser");
	} 
	/*
	 * @BeforeMethod 
	 * public void Login() 
	 * { 
	 * 		System.out.println(""); 
	 * }
	 */
	@AfterMethod
	public void logout(ITestResult status) 
	{
		System.out.println("logout done");
		reports= new ExtentReports("./reports/testy.html",false);
		test=reports.startTest("generating reports..");
		//int num= status.getStatus();
		String store= Utility.screenshot(driver);
		
		if(status.getStatus()==ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, test.addScreenCapture(store));
			//test.log(LogStatus.PASS, test.addScreenCaptureFromPath(store));
		}
		else
		{
			test.log(LogStatus.FAIL, test.addScreenCapture(store));
		}
		reports.flush();
		reports.endTest(test); 
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		Utility.screenshot(driver);
		System.out.println("browser is closed");
	}
	@AfterSuite
	public void closeDB() throws SQLException
	{
		System.out.println("closing DB");
		//connect.close();
	} 
	
}
