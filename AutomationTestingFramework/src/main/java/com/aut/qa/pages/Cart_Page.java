package com.aut.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aut.qa.base.testBase;

public class Cart_Page  extends testBase {

	
	@FindBy(className = "title")
	WebElement headingOfPage;
	
	@FindBy(id = "checkout")
	WebElement checkoutBTN;
	
	@FindBy(id = "continue-shopping")
	WebElement continueShoppingBTN;
	
	
	public Cart_Page() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String cartPageHeading() {
		 return headingOfPage.getText();
	}
	
	public boolean isCheckOutBTNDisplayed() {
		return checkoutBTN.isDisplayed();
	}
	
	
	 
	public WebElement ClickOnContinueShopping() {
		 continueShoppingBTN.click();
		return continueShoppingBTN;
	}
	
	public Checkout_Page ClickOnCheckoutBtn() {
		checkoutBTN.click();
		 return new Checkout_Page();
	}
	
	
	
}
