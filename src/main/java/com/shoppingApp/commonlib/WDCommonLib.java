package com.shoppingApp.commonlib;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shoppingApp.genericlib.BaseClass;

public class WDCommonLib
{
	String mainId;
	String childId;
	public void mainWinodow()
	{
		String mainId= BaseClass.driver.getWindowHandle();
	}
	public void NavigatetoChildWindow()
	{
		Set<String> allId= BaseClass.driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		mainId=it.next();
		childId=it.next();
		BaseClass.driver.switchTo().window(childId);
	}
	public void NavigatetoParentWindow()
	{
		BaseClass.driver.switchTo().window(mainId);
	}
	public void mouseactions(WebElement ele)
	{
		Actions act = new Actions(BaseClass.driver);
		act.moveToElement(ele).perform();
	}
	public void explicitWait(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(BaseClass.driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public void mousedragdrop(WebElement src,WebElement dest)
	{
		Actions act = new Actions(BaseClass.driver);
		act.dragAndDrop(src, dest);
	}
	
}
