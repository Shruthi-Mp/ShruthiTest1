package com.shoppingApp.objectRepository.Pomclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonIphonePage_Pom {
	/*
	 * @FindBy(xpath="//span[text()='Apple iPhone XR (64GB) - Yellow']")
	 *  private WebElement amazoniphonename; 
	 *  public WebElement getamazoniphonename()
	 *   { 
	 *   		return amazoniphonename; 
	 *   } 
	 *   public void selectamazoniphonename()
	 *   {
	 * 			amazoniphonename.click(); 
	 * 	 }
	 */
	@FindBy(xpath="//span[@id='productTitle']/../../../following-sibling::div[10]//span[@id='priceblock_ourprice']")
	private WebElement amazoniphoneprice;
	public WebElement getamazoniphoneprice()
	{
		return amazoniphoneprice;
	}
	public String fetchamazoniphoneprice()
	{
		return amazoniphoneprice.getText();
	}
	
}
