package com.shoppingApp.testscripts;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shoppingApp.commonlib.WDCommonLib;
import com.shoppingApp.genericlib.BaseClass;
import com.shoppingApp.genericlib.FileLib;
import com.shoppingApp.objectRepository.Pomclasses.TripAdvisorClubMahindraPAge_Pom;
import com.shoppingApp.objectRepository.Pomclasses.TripAdvisorHomePage_Pom;
import com.shoppingApp.objectRepository.Pomclasses.TripAdvisorReviewPage_Pom;

public class TripAdvisorRatingTest extends BaseClass {
	FileLib f=new FileLib();
	WDCommonLib lib=new WDCommonLib();
	@Test
 	public void TripAdvisorRating() throws EncryptedDocumentException, IOException, InterruptedException
 	{
 		TripAdvisorHomePage_Pom thp = PageFactory.initElements(BaseClass.driver, TripAdvisorHomePage_Pom.class);
 		TripAdvisorClubMahindraPAge_Pom tcmp = PageFactory.initElements(BaseClass.driver, TripAdvisorClubMahindraPAge_Pom.class);
 		TripAdvisorReviewPage_Pom trp = PageFactory.initElements(BaseClass.driver, TripAdvisorReviewPage_Pom.class);
 		BaseClass.driver.get(f.fetchDataFromProperty("trip_url"));
		try { thp.Clickonclosepopup(); } catch(Throwable e) { }
		thp.clickontripsearchbox();
 		String name=f.fetchDatafromExcel("tripadvisor", 0, 0);
 		thp.sendkeystotripactualsearchbox(name);
 		List<WebElement> plist = thp.getplacelist();
		plist.get(0).click();
		Thread.sleep(3000);
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(2000);
		tcmp.ClickonwriteReview();
		Thread.sleep(2000);
		lib.NavigatetoChildWindow();
		//WebElement ele=trp.getrating();
		//lib.explicitWait(ele);
		//WebElement[] listofbubbles=trp.bubbleslist();
		Actions act=new Actions(BaseClass.driver);
		for( int i=0;i<trp.bubbleslist().size();i++)
		{
			act.moveToElement(trp.bubbleslist().get(i)).perform();
			Thread.sleep(3000);
		}
		trp.getfifthbb().click();
		System.out.println("rating is given");
		/*for(int i=1;i<=listofbubbles.length;i++)
		{
			WebElement src= listofbubbles[i];
			WebElement dest=listofbubbles[i+1];
			lib.mousedragdrop(src, dest);
		}*/
		
		//String attvalue=trp.getratingbubble().getAttribute("class");
		 /* String[] str=attvalue.split("_"); System.out.println(str[3]); int numvalue=
		 * Integer.parseInt(str[3]); */
		/*int numvalue=1;
		while(numvalue<=5)
		{
			//lib.mouseactions(ele);
			Thread.sleep(3000);
			ele.sendKeys(Keys.ARROW_RIGHT);
		}
		numvalue++; */
		/*while(attvalue.contains("05"))
		{
			trp.getratingbubble().sendKeys(Keys.ARROW_RIGHT);
		}
		System.out.println("rating done");
		Thread.sleep(5000);*/
		
		String review=f.fetchDatafromExcel("tripadvisor", 0, 1);
		trp.ClickonReviewTitle(review);
		String reviewtxt=f.fetchDatafromExcel("tripadvisor", 0, 2);
		trp.ClickonReviewText(reviewtxt);
		trp.selectcheckbox();
		System.out.println("checkbox selected");
 	}
}
