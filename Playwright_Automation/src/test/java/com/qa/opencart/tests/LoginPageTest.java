package com.qa.opencart.tests;

import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {
	
	
	@Test()
	public void loginTest() throws InterruptedException {
		homePage.clickOnMyAccount();
		homePage.clickOnLoginLink();
		
		String emailAddress = prop.getProperty("emailAddress");
		String password = prop.getProperty("password");
		loginPage.doLogin(emailAddress, password);
	}
	
	@Test()
	public void forgotPasswordLinkDisplayedTest() throws InterruptedException {
		homePage.clickOnMyAccount();
		homePage.clickOnLoginLink();
        loginPage.isForgotPasswordLinkDisplayed();	
	}

}
