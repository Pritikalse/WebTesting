package com.aut.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aut.qa.base.testBase;
import com.aut.qa.pages.Cart_Page;
import com.aut.qa.pages.Home_Page;
import com.aut.qa.pages.loginPage;

public class YourCartPage extends testBase {

	Home_Page HomePage ;
	loginPage LoginPage;
	Cart_Page cartPage;
	
	public YourCartPage() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		initilization();
		LoginPage = new loginPage(); 
		HomePage = LoginPage.ClickonLoginBTN(prop.getProperty("username"), prop.getProperty("Password"));
		HomePage.ClickonAddToCartBTN();
		cartPage =HomePage.ClickOnCartIcon();
	}
	
	@Test(priority = 1)
	public void verifyHeading() {
		String Actualheading = cartPage.cartPageHeading();
		assertEquals(Actualheading, "Your Cart", "heading is wrong");
	}
	
	@Test(priority = 2)
	public void verifycheckoutBTNisdisplayed() {
		boolean flag = cartPage.isCheckOutBTNDisplayed();
		assertTrue(flag , "btn is not displyed");
	}
	
	/*
	 * @Test (priority = 3) public void VerifyContinueShoppingBTNisWorking() {
	 * WebElement ContinueShppoing = cartPage.ClickOnContinueShopping(); //String
	 * HomepageHeadingDisplyed=; assertEquals(ContinueShppoing, ValidateHeading()
	 * ,"ContineuShppoingBTN is not working" ); }
	 */
	
	
	
	@AfterMethod
	
	public void tearDwon() {
		driver.quit();
	}
	
	
}
