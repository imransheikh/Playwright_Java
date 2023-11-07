package com.qa.opencart.base;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest{

	PlaywrightFactory playwrightFactory;
	Page page;
	protected Properties prop;
	protected HomePage homePage;
	protected LoginPage loginPage;

	@BeforeTest
	public void setUp() {
		System.out.println("Executing before test...");
		playwrightFactory = new PlaywrightFactory();
		prop = playwrightFactory.init_prop();
		page = playwrightFactory.iniBrowser(prop);
		homePage = new HomePage(page);
		loginPage= new LoginPage(page);

	}

	@AfterTest
	public void tearDown() {
		System.out.println("Executing after test...");
		page.context().browser().close();
	}

}
