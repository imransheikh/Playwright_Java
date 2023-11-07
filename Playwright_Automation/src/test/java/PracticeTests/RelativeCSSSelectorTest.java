package PracticeTests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RelativeCSSSelectorTest {

	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page= browserContext.newPage();
		page.navigate("https://demoqa.com/login");
		page.locator("//div[@class='header-text' and contains(text(),'Elements')]").click();
		page.locator("//span[text()='Web Tables']").click();
		
		
		page.locator("span[title='Edit']:right-of(:text('Insurance'))").first().click();
		
		
	}
}
