package com.aut.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aut.qa.base.testBase;
import com.aut.qa.pages.Cart_Page;
import com.aut.qa.pages.Checkout_Page;
import com.aut.qa.pages.Home_Page;
import com.aut.qa.pages.loginPage;
import com.aut.qa.utils.TestUtils;

public class CheckOut_Test extends testBase{
	
	Home_Page HomePage ;
	loginPage LoginPage;
	Cart_Page CartPage;
	Checkout_Page CheckoutPage;
	
	
	
	public CheckOut_Test() {
		super();
		}
	
	@BeforeMethod
	public void Setup() {
		initilization();
		LoginPage = new loginPage(); 
		HomePage = LoginPage.ClickonLoginBTN(prop.getProperty("username"), prop.getProperty("Password"));
		HomePage.ClickonAddToCartBTN();
		CartPage =HomePage.ClickOnCartIcon();
		CheckoutPage =CartPage.ClickOnCheckoutBtn();
		
		
	}
	
	@DataProvider
	public Object[][] GetData() throws Exception {
		Object[] [] data  = TestUtils.GetTestData(TestUtils.Sheet_name);
		return data;
	}
	
	@Test (priority = 1 , dataProvider = "GetData")
	
	public void VerifyEnterDatails(String FName, String LName , String ZipCode) throws InterruptedException {
		if(CheckoutPage.isFNameDisplyed() && CheckoutPage.isLNameDisplyed() &&CheckoutPage.isZIPDisplyed()) {
			CheckoutPage.enterDetails(FName, LName, ZipCode);
			Thread.sleep(5000);
		}
		
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	

}
