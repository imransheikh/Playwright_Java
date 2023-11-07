package PracticeTests;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ReactLocators {

	
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page= browserContext.newPage();
		page.navigate("https://www.netflix.com/nl-en/");
		page.locator("_react=Anonymous[name='email'] >> input").first().fill("imrantest.pbh@gmail.com");
		//page.locator("_react=UIMarkup[className='cta-btn-txt']").first().click();
		Locator links = page.locator("_react=UIMarkup[data-uia='data-uia-footer-label']");
		System.out.println("Link count are: " + links.count());
		List<String> strLinks = page.locator("_react=UIMarkup[data-uia='data-uia-footer-label']").allInnerTexts();
		
		for(String str: strLinks)
		{
			System.out.println("Link names are:" + str);
		}
		
	}
}
