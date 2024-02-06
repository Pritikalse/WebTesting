package com.aut.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aut.qa.base.testBase;

public class Checkout_Page  extends testBase{
	
	@FindBy(xpath = "//span[@class= 'title']")
			WebElement CheckoutHeading;
	
	@FindBy(id="first-name")
	WebElement FristName;
	
	@FindBy(id="last-name")
	WebElement LastName;
	
	@FindBy(id="postal-code")
	WebElement zip;

	@FindBy(id = "continue")
	WebElement ContinueBTN;
	
	public Checkout_Page(){
		PageFactory.initElements(driver, this);
		
	}
	
	public void CheckoutPageHeading() {
		CheckoutHeading.getText();
	}
	
	public boolean isFNameDisplyed() {
		return FristName.isDisplayed();
	}
	
	public boolean isLNameDisplyed() {
		return LastName.isDisplayed();
	}
	
	public boolean isZIPDisplyed() {
		return zip.isDisplayed();
	}
	
	public checkout_overview ClickOnContinueBTN() {
		ContinueBTN.click();
		return new checkout_overview();
	}
	
	public void enterDetails(String FN, String LN , String ZP) {
		FristName.sendKeys(FN);
		LastName.sendKeys(LN);
		zip.sendKeys(ZP);
	}
	
	
}
