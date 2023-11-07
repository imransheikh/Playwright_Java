package com.qa.opencart.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.data.AppConstants;

public class HomePageTest extends BaseTest {

	@Test(priority = 1)
	public void homePageTitleTest() {
		System.out.println("Home Page Title: " + homePage.getHomePageTitle());
		assertEquals(homePage.getHomePageTitle(), AppConstants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void homePageURLTest() {
		System.out.println("Home Page URL: " + homePage.getHomePageURL());
		assertEquals(homePage.getHomePageURL(), prop.getProperty("url"));
	}


	@Test(priority = 3, dataProvider = "getProductData")
	public void searchProductTest(String productName) {
		homePage.doSearch(productName);
		assertEquals(homePage.getSearchHeader(), "Search - " + productName);
	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] { { "Macbook" }, { "iPhone" }, { "iMac" } };
	}

}
