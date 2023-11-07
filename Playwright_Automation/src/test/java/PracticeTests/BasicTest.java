package PracticeTests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BasicTest {
	
	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		//Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		//Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page= browser.newPage();
		page.navigate("https://demoqa.com/login");
		String title= page.title();
		System.out.println("Title is: " + title);
		
		String appUrl= page.url();
		System.out.println("App URL is : " + appUrl);
		browser.close();
		playwright.close();
		//imran   id = login
		//Qwerty@123
	}

}
