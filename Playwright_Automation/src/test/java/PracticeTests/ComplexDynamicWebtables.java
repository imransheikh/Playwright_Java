package PracticeTests;

import java.util.List;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class ComplexDynamicWebtables {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");

		Locator rows = page.locator("table#example tr");
		System.out.println("Total row Count: " + rows.count());

		rows.locator(":scope", new Locator.LocatorOptions().setHasText("Bruno Nash")).locator("td.select-checkbox")
				.click();

		List<String> allTableContent = rows.locator(":scope").allInnerTexts();
		for (String str : allTableContent) {
			System.out.println(str);
		}
		System.out.println("====================================================");
		Locator getText= rows.locator(":scope", new Locator.LocatorOptions().setHasText("Bruno Nash")).locator("text= London");
		System.out.println("Offices:=> " + getText.textContent());

	}

}
