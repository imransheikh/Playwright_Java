package PracticeTests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CommaSeparatedCSSXpath {

	
public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page= browserContext.newPage();
		page.navigate("https://demoqa.com/login");
		
		//It will check for both Login and signIn, if anyone is present then it will perform click operation
		Locator login = page.locator("button:has-text('Login'), button:has-text('signIn')");
		login.click();
		
		Locator loginWithXpath= page.locator("//button[text()='Login'] | //button[text()='signIn']");
		System.out.println("Login Text: "+ loginWithXpath.textContent());
		
		//It will check for both Login and New User is present or not
		
		Locator login_NewUser_Button= page.locator("button:has-text('Login'), button:has-text('New User')");
		if (login_NewUser_Button.count()==2)
		{
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		
		
				
	}


}
