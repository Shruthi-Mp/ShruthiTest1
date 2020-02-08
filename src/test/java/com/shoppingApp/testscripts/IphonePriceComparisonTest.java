package com.shoppingApp.testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.shoppingApp.commonlib.WDCommonLib;
import com.shoppingApp.genericlib.BaseClass;
import com.shoppingApp.genericlib.FileLib;
import com.shoppingApp.genericlib.Utility;
import com.shoppingApp.objectRepository.Pomclasses.AmazonHomePage_Pom;
import com.shoppingApp.objectRepository.Pomclasses.AmazonIphonePage_Pom;
import com.shoppingApp.objectRepository.Pomclasses.FlipkartHomePage_Pom;
import com.shoppingApp.objectRepository.Pomclasses.FlipkartIphonePage_Pom;

public class IphonePriceComparisonTest extends BaseClass
{
	FileLib f=new FileLib();
	WDCommonLib wlib= new WDCommonLib();
	@Test
	public void iphonepricecomparision() throws IOException, InterruptedException
	{
		AmazonHomePage_Pom ahp = PageFactory.initElements(BaseClass.driver, AmazonHomePage_Pom.class);
		AmazonIphonePage_Pom aip = PageFactory.initElements(BaseClass.driver, AmazonIphonePage_Pom.class);
		FlipkartHomePage_Pom fhp = PageFactory.initElements(BaseClass.driver, FlipkartHomePage_Pom.class);
		FlipkartIphonePage_Pom fip = PageFactory.initElements(BaseClass.driver, FlipkartIphonePage_Pom.class);
		
		BaseClass.driver.get(f.fetchDataFromProperty("amazon_url"));
		String name= f.fetchDatafromExcel("shoppingapp", 0, 0);
		ahp.sendKeystoAmazonsearchbox(name);
		ahp.Clickonamaznsearch();
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("window.scrollBy(0,1000)");
		System.out.println("navigating to iphone page");
		Thread.sleep(2000);
		ahp.Clickonamaznselectiphone();
		wlib.NavigatetoChildWindow();
		String amazonprice=aip.fetchamazoniphoneprice().replace("₹","").replaceAll(",", "");
		int aprice=Integer.parseInt(amazonprice);
		BaseClass.driver.get(f.fetchDataFromProperty("flipkart_url"));
		try
		{
			BaseClass.driver.findElement(By.xpath("//button[text()='✕']")).click();
		}
		catch(Throwable e)
		{
			
		}
		//String name= f.fetchDatafromExcel("shoppingapp", 0, 0);
		fhp.sendkeystoFksearchbox(name);
		fhp.Clickonfksearch();
		fhp.Clickonfkselectiphone();
		wlib.NavigatetoChildWindow();
		String fkprice=fip.fetchfpiphoneprice().replace("₹","").replaceAll(",", "");
		int fprice=Integer.parseInt(fkprice); //number format exception if u don't replace spl chars
		System.out.println(fkprice);
	    Utility.screenshot(BaseClass.driver);
		if(aprice<fprice)
		{
			System.out.println("amzon price is less and price is:"+aprice);
			 Utility.screenshot(BaseClass.driver);

		}
		else
		{
			System.out.println("flipkart price is less and price is:"+fprice);
			 Utility.screenshot(BaseClass.driver);

		}
		
	}
}
