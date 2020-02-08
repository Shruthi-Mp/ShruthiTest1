package com.shoppingApp.objectRepository.Pomclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipkartHomePage_Pom 
{
	@FindBy(css="input[name='q']")
	private WebElement fksearchbox;
	public WebElement getfksearchbox()
	{
		return fksearchbox;
	}
	public void sendkeystoFksearchbox(String name)
	{
		fksearchbox.sendKeys(name);
	}
	@FindBy(css="button[type='submit']")
	private WebElement fksearch;
	public WebElement getfksearch()
	{
		return fksearch;
	}
	public void Clickonfksearch()
	{
		fksearch.click();
	}
	
	@FindBy(xpath="//div[text()='Apple iPhone XR (Yellow, 64 GB)']")
	private WebElement fkselectiphone;
	public WebElement getfkselectiphone()
	{
		return fkselectiphone;
	}
	public void Clickonfkselectiphone()
	{
		fkselectiphone.click();
	}
}
