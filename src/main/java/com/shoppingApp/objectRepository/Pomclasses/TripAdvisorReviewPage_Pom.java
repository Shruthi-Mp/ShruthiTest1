package com.shoppingApp.objectRepository.Pomclasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TripAdvisorReviewPage_Pom {
	@FindBy(xpath="//span[contains(@class,'ui_bubble_rating fl bubble')][@id='bubble_rating']")
	private WebElement rating;
	public WebElement getrating()
	{
		return rating;
	}
	public void Clickonrating()
	{
		rating.click();
	}
	
	/*@FindBy(xpath="//span[@class='ui_bubble_rating fl bubble_00'][@id='bubble_rating']")
	private WebElement zerothbb;
	public WebElement getzerothbb()
	{
		return zerothbb;
	}*/
	@FindBy(xpath="//span[@class='ui_bubble_rating fl bubble_01']") //[@id='bubble_rating']
	private WebElement firstbb;
	public WebElement getfirstbb()
	{
		return firstbb;
	}
	@FindBy(xpath="//span[@class='ui_bubble_rating fl bubble_02']")//[@id='bubble_rating']
	private WebElement secbb;
	public WebElement getsecbb()
	{
		return secbb;
	}
	@FindBy(xpath="//span[@class='ui_bubble_rating fl bubble_03']")//[@id='bubble_rating']
	private WebElement thirdbb;
	public WebElement getthirdbb()
	{
		return thirdbb;
	}
	@FindBy(xpath="//span[@class='ui_bubble_rating fl bubble_04']")//[@id='bubble_rating']
	private WebElement fourthbb;
	public WebElement getfourthbb()
	{
		return fourthbb;
	}
	@FindBy(xpath="//span[@class='ui_bubble_rating fl bubble_05']")//[@id='bubble_rating']
	private WebElement fifthbb;
	public WebElement getfifthbb()
	{
		return fifthbb;
	}
	public void Clickonfifthbb()
	{
		fifthbb.click();
	}
	public List<WebElement> bubbleslist()
	{
		List<WebElement> lisbubbles= new ArrayList<WebElement>();
		lisbubbles.add(firstbb);
		lisbubbles.add(secbb);
		lisbubbles.add(thirdbb);
		lisbubbles.add(fourthbb);
		lisbubbles.add(fifthbb);
		return lisbubbles;
	}
	@FindBy(xpath="//em[text()='Excellent']")
	private WebElement excellent;
	public WebElement getexcellent()
	{
		return excellent;
	}
	public void Clickonexcellent()
	{
		excellent.click();
	}
	@FindBy(id="ReviewTitle")
	private WebElement rvwtitle;
	public WebElement getReviewTitle()
	{
		return rvwtitle;
	}
	public void ClickonReviewTitle(String review)
	{
		rvwtitle.sendKeys(review);
	}
	@FindBy(id="ReviewText")
	private WebElement ReviewText;
	public WebElement getReviewText()
	{
		return rvwtitle;
	}
	public void ClickonReviewText(String reviewtxt)
	{
		ReviewText.sendKeys(reviewtxt);
	}
	@FindBy(xpath="//div[text()='Hotel Ratings']")
	private WebElement hotelrating;
	public WebElement gethotelrating()
	{
		return hotelrating;
	}
	@FindBy(css="span[data-name='Service']")
	private WebElement Service;
	public WebElement getService()
	{
		return Service;
	}
	public void selectservice()
	{
		Service.click();
	}
	
	@FindBy(xpath="span[data-name='Location']")
	private WebElement Location;
	public WebElement getLocation()
	{
		return Location;
	}
	public void selectlocation()
	{
		Location.click();
	}
	@FindBy(xpath="span[data-name='Cleanliness']")
	private WebElement Cleanliness;
	public WebElement getCleanliness()
	{
		return Cleanliness;
	}
	public void selectCleanliness()
	{
		Cleanliness.click();
	}
	@FindBy(id="noFraud")
	private WebElement checkbox;
	public WebElement getcheckbox()
	{
		return checkbox;
	}
	public void selectcheckbox()
	{
		checkbox.click();
	}
}
