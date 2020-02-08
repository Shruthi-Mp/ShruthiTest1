package com.shoppingApp.objectRepository.Pomclasses;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TripAdvisorHomePage_Pom {
	/*
	 * @FindBy(xpath="//span[text()='Search']") private WebElement tripsearchbox;
	 * public WebElement gettripsearchbox() { return tripsearchbox; } public void
	 * sendkeystoFksearchbox(String name) { tripsearchbox.sendKeys(name); }
	 */
	@FindBy(id="close")
	private WebElement closepopup;
	public WebElement getclosepopup()
	{
		return closepopup;
	}
	public void Clickonclosepopup()
	{
		closepopup.click();
	}
	
	@FindBy(css="div[title='Search']")
	private WebElement tripsearchbox;
	public WebElement gettripsearchbox()
	{
		return tripsearchbox;
	}
	public void clickontripsearchbox()
	{
		tripsearchbox.click();
	}
	@FindBy(id="mainSearch")
	private WebElement tripactualsearchbox;
	public WebElement gettripactualsearchbox()
	{
		return tripactualsearchbox;
	}
	public void sendkeystotripactualsearchbox(String name)
	{
		tripactualsearchbox.sendKeys(name);
	}
	
	@FindBy(xpath="//ul[@class='resultContainer local']/li")
	private List<WebElement> placelist;
	public List<WebElement> getplacelist()
	{
		return placelist;
	}
	/*
	 * public List<WebElement> selectinplacelist() { placelist.click(); }
	 */
	
}
