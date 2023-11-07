package PracticeTests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JavaScriptsBasedPopups {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		//JS Alert, JS Confirm, JS Prompt
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page= browserContext.newPage();
		//Listners for handling the dialogs
		page.onDialog(dialog->	{
			String text= dialog.message();
			System.out.println(text);
			dialog.accept("Test comment");
		});
		
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		page.locator("button[onclick='jsAlert()']").click();
		String result1 = page.locator("p#result").textContent();
		System.out.println("Result text is: "+ result1);
		Thread.sleep(3000);
		page.locator("button[onclick='jsConfirm()']").click();
		String result2 = page.locator("p#result").textContent();
		System.out.println("Result text is: "+ result2);
		Thread.sleep(3000);
		
		page.locator("button[onclick='jsPrompt()']").click();
		String result3 = page.locator("p#result").textContent();
		System.out.println("Result text is: "+ result3);
		Thread.sleep(3000);
		
		
		
		
	}

}
