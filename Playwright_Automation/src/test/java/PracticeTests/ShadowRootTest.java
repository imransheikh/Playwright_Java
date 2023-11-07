package PracticeTests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowRootTest {
	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page= browserContext.newPage();
		page.navigate("https://books-pwakit.appspot.com/");
		page.locator("book-app[apptitle='BOOKS'] #input").fill("Imran Sheikh");
		String bookDesc = page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
		System.out.println("Book Description: " + bookDesc);
		
		
		
		//Page-> DOM-> Shadow DOM-> Element
		//Page-> DOM-> Shadow DOM-> Element
		

	}

}
