package com.shoppingApp.objectRepository.Pomclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipkartIphonePage_Pom {
	@FindBy(xpath="//span[text()='Apple iPhone XR (Yellow, 64 GB)']/../../following-sibling::div[2]")
	//span[text()='Apple iPhone XR (Yellow, 64 GB)']/../../following-sibling::div[2]/div/div/div
	private WebElement fpiphoneprice;
	public WebElement getfpiphoneprice()
	{
		return fpiphoneprice;
	}
	public String fetchfpiphoneprice()
	{
		return fpiphoneprice.getText();
	}
}
