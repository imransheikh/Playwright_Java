package PracticeTests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextLocator {

	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page= browserContext.newPage();
		page.navigate("https://demoqa.com/login");
		
		String text1= page.locator("text= Welcome,").textContent();
		String text2= page.locator("h2:has-text('Welcome,')").textContent();
		String text3= page.locator("div h2:has-text('Welcome,')").textContent();
		String text4= page.locator("'Welcome,'").textContent();
		
		
		System.out.println("Welcome text is=> "+ text1 + " " + text2  + "  " + text3 + " " + text4);
		
		page.close();
		browserContext.close();
		
		
		
		
		
		
	}
}
