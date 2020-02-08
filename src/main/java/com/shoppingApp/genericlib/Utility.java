package com.shoppingApp.genericlib;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;

import com.shoppingApp.genericlib.BaseClass;

public class Utility {
	public static String screenshot(WebDriver driver)
	{
		Date d=new Date();
		String curdate=d.toString();
		String reqdate=curdate.replaceAll(" ","").replaceAll(":","");
		//String tcname= result.getName();
		//EventFiringWebDriver web=new EventFiringWebDriver(BaseClass.driver);
		TakesScreenshot shot = (TakesScreenshot) driver;
		File src=shot.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/"+reqdate+".png");
		String address = dest.getAbsolutePath();
		try 
		{
			FileUtils.copyFile(src, dest);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return address;
}
}
