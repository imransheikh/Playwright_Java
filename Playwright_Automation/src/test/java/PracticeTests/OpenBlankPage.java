package PracticeTests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class OpenBlankPage {
	
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page= browserContext.newPage();
		page.navigate("https://demoqa.com/login");
		
		Page popup= page.waitForPopup(()->{
			page.click("a[target='_blank']");
			
		});
		
		popup.waitForLoadState();
		popup.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
	}

}
