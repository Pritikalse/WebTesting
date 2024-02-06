package com.aut.qa.testcases;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aut.qa.base.testBase;
import com.aut.qa.pages.Home_Page;
import com.aut.qa.pages.loginPage;

public class loginPageTest extends testBase {
	
	loginPage LoginPage;
	Home_Page homePage;

	
	public loginPageTest (){
		super();
	}

	@BeforeMethod
	public void setup() {
		initilization();
		LoginPage = new loginPage();
	}
	
	
	
    @Test(priority = 1)
	public void ValidateLogibPageTitile() {
		 String ActualTitle = LoginPage.getLoginPageTitle();
		 assertEquals(ActualTitle, "Swag Labs","the page titile is wrong");
	}

    @Test(priority = 2 , dependsOnMethods =  "ValidateLogibPageTitile" )
    public void validatelogin() {
    	LoginPage.ClickonLoginBTN(prop.getProperty("username"), prop.getProperty("Password"));
    	
    	String ActualTitleOfHomePage = LoginPage.getLoginPageTitle();
    	assertEquals(ActualTitleOfHomePage, "Swag Labs","the page titile is wrong");
    	
    }
    
    @AfterMethod
	public void tearDown() {
		driver.quit();
	}
  
    
}
