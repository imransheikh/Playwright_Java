package PracticeTests;

import java.nio.file.Paths;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadFiles {

	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page= browserContext.newPage();
		page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=2.0/");
		
		Download downlaod = page.waitForDownload(()->{
			page.locator("//a[contains(text(),'chromedriver_win32.zip')]").click();
		});
		
		System.out.println("Download URL=> " + downlaod.url());
		System.out.println(downlaod.page().url());
		System.out.println(downlaod.path().toString());
	
		downlaod.saveAs(Paths.get("C:\\Users\\Imran\\Downloads\\imrandownload.zip"));
		
	}
}
