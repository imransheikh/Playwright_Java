package PracticeTests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorsTest {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page= browserContext.newPage();
		page.navigate("https://demoqa.com/login");
		String title1= page.title();
		System.out.println("Title is: " + title1);
		String appUrl= page.url();
		System.out.println("App URL is : " + appUrl);
		
		Locator welcomeLocator= page.locator("text=Welcome,");
		String welcomeText= welcomeLocator.innerText();
		System.out.println("Welcome Text is: " + welcomeText);
		
		//Single element
		Locator login= page.locator("text=Login");
		int totalLogin = login.count();
		System.out.println("Total Login Text is: " + totalLogin);
		login.first().click();
		//id userName
		// id password
		
		//Login
		
		// Multiple elements
		page.locator("//div[@class='header-text' and contains(text(),'Elements')]").click();
		page.locator("//span[contains(text(),'Web Tables')]").click();
		
		
		Locator tableData= page.locator("div.ReactTable>div.rt-table>div.rt-tbody>div");
		System.out.println("Total Table rows: " + tableData.count());
		
		for(int i=0; i<tableData.count(); i++)
		{
			Locator tableContect= tableData.nth(i).locator("//div[@class='rt-tr -odd']/div");
			for(int j=0; j<tableContect.count(); j++) {
				
				String tableValue= tableContect.nth(j).textContent();
				System.out.println("Table Content Value: " + tableValue);
			}

		}
		
		
		
		Thread.sleep(5000);
		
		
		
		
		
		
		
		
		page.close();
		browserContext.close();
		
		
		
	}

}
