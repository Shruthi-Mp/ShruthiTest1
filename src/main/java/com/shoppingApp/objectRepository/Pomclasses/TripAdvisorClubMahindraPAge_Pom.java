package com.shoppingApp.objectRepository.Pomclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TripAdvisorClubMahindraPAge_Pom {
	@FindBy(linkText="Write a review")
	private WebElement wreview;
	public WebElement getwreview()
	{
		return wreview;
	}
	public void ClickonwriteReview()
	{
		wreview.click();
	}
}
