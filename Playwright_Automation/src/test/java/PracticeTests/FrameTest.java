package PracticeTests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameTest {
	
	
	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page= browserContext.newPage();
		page.navigate("https://demoqa.com/login");
		page.locator("//div[@class='header-text' and contains(text(),'Alerts, Frame & Windows')]").click();
		page.locator("//span[text()='Frames']").click();
		
		
		String heading = page.frameLocator("iframe[id='frame1']").locator("//h1[@id='sampleHeading']").first().textContent();
		System.out.println("Heading is=> " + heading);
		
		Thread.sleep(5000);
		
	}

}
