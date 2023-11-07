package PracticeTests;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class UploadFileTest {
	
	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page= browserContext.newPage();
		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		page.setInputFiles("input#filesToUpload", Paths.get("appLogin.json"));
		page.setInputFiles("input#filesToUpload", new Path[0]);
		Thread.sleep(4000);
		
		page.setInputFiles("input#filesToUpload", new Path[]
				{
					Paths.get("appLogin.json"),
					Paths.get("appLogin2.json"),
					Paths.get("TestData.txt")
				
				});
		
		Thread.sleep(3000);
		
	}

}
