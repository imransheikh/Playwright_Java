package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	private Page page;

	// Object Repository
	private String search = "input[name='search']";
	private String searchIcon = "i.fa-search";
	private String searchPageHeader = "div#content h1";
	private String loginLink = "ul.dropdown-menu a:text('Login')";
	private String myAccountLink = "span:text('My Account')";

	// Constrcutor
	public HomePage(Page page) {
		this.page = page;
	}

	// Page action and method
	public String getHomePageTitle() {
		return page.title();
	}

	public String getHomePageURL() {
		return page.url();
	}
	
	public void doSearch(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
		//page.locator(searchPageHeader).waitFor(options);
	}
	
	public String getSearchHeader() {
		return page.locator(searchPageHeader).textContent();
	}

	public void clickOnMyAccount() {
		page.locator(myAccountLink).click();
	}
	
	public LoginPage clickOnLoginLink(){
		page.locator(loginLink).click();
		return new LoginPage(page);
	}
	
	
	

}
