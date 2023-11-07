package PracticeTests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserWindows {
	
	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		//BrowserContext bx1 = browser.newContext();
		BrowserContext bx2 = browser.newContext();
		
		//Page page1= bx1.newPage();
		Page page2= bx2.newPage();
		
		
		//page1.navigate("https://demoqa.com/browser-windows");
		page2.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Page popup= page2.waitForPopup(()->{
			page2.locator("//a[contains(@href,'linkedin')]").click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		System.out.println("Child window title " + popup.title());
		
		String buttonText= popup.locator("button#join-form-submit").textContent();
		System.out.println("Button text is: " + buttonText);
		Thread.sleep(5000);
		popup.close();
		
		System.out.println("Parent window title => " + page2.title());
		
		
		//page2.locator("//a[contains(@href,'facebook')]").click();
		
	}

}
