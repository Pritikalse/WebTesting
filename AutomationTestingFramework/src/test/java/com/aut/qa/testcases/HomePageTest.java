package com.aut.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aut.qa.base.testBase;
import com.aut.qa.pages.Home_Page;
import com.aut.qa.pages.loginPage;

public class HomePageTest extends testBase{
	
	
	Home_Page HomePage ;
	loginPage LoginPage;
	
	
	
	public HomePageTest(){
		super();
		}
	@BeforeMethod
	public void setup() {
		initilization();
		LoginPage = new loginPage(); 
		HomePage = LoginPage.ClickonLoginBTN(prop.getProperty("username"), prop.getProperty("Password"));
		
	}
	
	@Test(priority = 1)
	public void ValidateHeading() {
		String ActualHeaidng = HomePage.HomePageHeading();
		assertEquals(ActualHeaidng, "Products", "heading is wrong");
	}
	
	@Test(priority = 2)
	public void verifyisBackPaeAddToCartButtonDisplayed() {
		  boolean flag = HomePage.isBackPaeAddToCartButtonDisplayed();
		  assertTrue(flag ,"add to acrd button is not displyed");
	}
	@Test(priority = 3)
	
	public void verifyItemAddedIntoCart() {
		HomePage.ClickonAddToCartBTN();
		boolean flag= HomePage.isBackPremovefromCartButtonDisplayed();
		assertTrue(flag,"Item is not succesfully added");
	}
	 
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}

