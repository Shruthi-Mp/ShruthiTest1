package com.shoppingApp.genericlib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass
{
	public static FileLib f=new FileLib();
	public static WebDriver driver;
	@BeforeSuite 
	public void connectDB()
	{
		System.out.println("connecting to DB");
	}
	@BeforeClass
	public void launchBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
	public void logout()
	{
		System.out.println("logout done");
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		System.out.println("browser is closed");
	}
	@AfterSuite
	public void closeDB()
	{
		System.out.println("closing DB");
	}
	
}
