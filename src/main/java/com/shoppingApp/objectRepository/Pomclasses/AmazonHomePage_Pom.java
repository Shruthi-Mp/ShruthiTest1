package com.shoppingApp.objectRepository.Pomclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage_Pom 
{
	@FindBy(id="twotabsearchtextbox")
	private WebElement amazonsearchbox;
	
	public WebElement getamazonsearchbox()
	{
		return amazonsearchbox;
	}
	public void sendKeystoAmazonsearchbox(String name)
	{
		amazonsearchbox.sendKeys(name);
	}
	@FindBy(css="input[value='Go']")
	private WebElement amaznsearch;
	public WebElement getamaznsearch()
	{
		return amaznsearch;
	}
	public void Clickonamaznsearch()
	{
		amaznsearch.click();
	}
	@FindBy(xpath="//span[text()='Apple iPhone XR (64GB) - Yellow']/..")
	private WebElement amaznselectiphone;
	public WebElement getamaznselectiphone()
	{
		return amaznselectiphone;
	}
	public void Clickonamaznselectiphone()
	{
		amaznselectiphone.click();
	}
	
}
