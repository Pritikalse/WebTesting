package com.aut.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aut.qa.base.testBase;

public class loginPage extends testBase {
	
	// page Factory - object repository
	
	@FindBy(name = "user-name")
	WebElement usernameBox;
	
	@FindBy(name = "password")
	WebElement PasswordBox;
	
	@FindBy(id = "login-button")
	WebElement loginBTN;
	
	//initialization object
	
	public loginPage() {
		PageFactory.initElements(driver, this);
		
		
	}
	
	// define the actions on the page 
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public Home_Page ClickonLoginBTN(String UN,String PW) {
		usernameBox.sendKeys(UN);
		PasswordBox.sendKeys(PW);
		loginBTN.click();
		
		return new Home_Page();
		
		
	}
	


}
