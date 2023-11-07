package PracticeTests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserContext;

public class BrowserContextTest {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext bc1 = browser.newContext();
		Page p1= bc1.newPage();
		p1.navigate("https://www.google.com/");
		String title1= p1.title();
		System.out.println("Title is: " + title1);
		
		
		
		BrowserContext bc2 = browser.newContext();
		Page p2= bc2.newPage();
		p2.navigate("https://demoqa.com/login");
		String title= p2.title();
		System.out.println("Title is: " + title);
		String appUrl= p2.url();
		System.out.println("App URL is : " + appUrl);
		
		p1.close();
		bc1.close();
		
		p2.close();
		bc2.close();
		
		
	}
}
