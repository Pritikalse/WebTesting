package com.aut.qa.pages;

import com.aut.qa.base.testBase;


	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	
	public class Home_Page  extends testBase {
		
		@FindBy(className = "title")
		WebElement HomePageHeading;
		
		@FindBy(id = "add-to-cart-sauce-labs-backpack")
		WebElement backPageAddToCartBTN;
		
		@FindBy(name = "remove-sauce-labs-backpack")
		WebElement backPackremoveBTN;
		
		@FindBy(id = "shopping_cart_container")
		WebElement CartIcon;
		
		public Home_Page() {
		      PageFactory.initElements(driver, this);
		      
		      }
		public String HomePageHeading() {
			return HomePageHeading.getText();
		}
		
		public boolean isBackPaeAddToCartButtonDisplayed() {
			return backPageAddToCartBTN.isDisplayed();
		}

		public boolean isBackPremovefromCartButtonDisplayed() {
			return backPackremoveBTN.isDisplayed();
		}
		
		public void ClickonAddToCartBTN() {
			backPageAddToCartBTN.click();
		}
		
		//click on shopping cart icon
		public Cart_Page ClickOnCartIcon() {
			CartIcon.click();
			return new Cart_Page();
		}
		
		
	}



