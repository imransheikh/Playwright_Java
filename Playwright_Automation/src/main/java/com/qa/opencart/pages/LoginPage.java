package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;

	// Object Repository
	private String emailAddressField = "input#input-email";
	private String passwordTextField = "input#input-password";
	private String loginButton = "input[value='Login']";
	private String forgotPasswordLink = "div.form-group a:text('Forgotten Password')";
	private String logoutLink = "div.list-group a:text('Logout')";
	

	// Constrcutor
	public LoginPage(Page page) {
		this.page = page;
	}
	
	public String getLoginPageTitle() {
		return page.title();
	}
	
	public void enterEmailAddress(String emailAddress){
		page.fill(emailAddressField, emailAddress);
	}
	
	public void enterPassword(String password){
		page.fill(passwordTextField, password);
	}
	
	public void clickOnLoginButton(){
		page.click(loginButton);
	}
	
	public boolean isForgotPasswordLinkDisplayed(){
		return page.isVisible(forgotPasswordLink);
	}
	
	public boolean isLogoutDisplayed() {
		return page.isVisible(logoutLink);
	}
	
	public boolean doLogin(String emailAddress, String password) {
		enterEmailAddress(emailAddress);
		enterPassword(password);
		clickOnLoginButton();
		if(page.isVisible(logoutLink)) {
			System.out.println("User is logged in successfully...");
			return true;
		}
		else {
			return false;
		}
	}


}
