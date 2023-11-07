package PracticeTests;

import java.nio.file.Paths;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AutomaticLoginTest {
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://demoqa.com/login");
		
		Locator userName= page.locator("input#userName");
		userName.fill("imran");
		
		Locator password= page.locator("input#password");
		password.fill("Qwerty@123");
		
		Locator loginButton= page.locator("button#login");
		loginButton.click();
		
		browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("appLogin.json")));
		
		
		
	}

}
