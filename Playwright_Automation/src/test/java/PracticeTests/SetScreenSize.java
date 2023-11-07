package PracticeTests;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SetScreenSize {
	
	public static void main(String[] args) {
		
		Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
		int width= (int) screenSize.getWidth();
		int height= (int) screenSize.getHeight();
		System.out.println("Width " + width + " And Heigth " + height);
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		//BrowserContext browserContext = browser.newContext();
		//BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1536,864));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
		Page page= browserContext.newPage();
		page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=2.0/");
		
	}

}
