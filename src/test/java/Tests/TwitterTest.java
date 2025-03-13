package Tests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageUtilities.TestUtilities;

public class TwitterTest {
	private WebDriver driver = null;

	@BeforeTest
	public void initialiseDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");

		// Prevent detection
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);

		driver = new ChromeDriver(options);
	

	}
	
	@Test
	public void verifyTwitterTest() {
		TestUtilities testUtil=new TestUtilities();
		testUtil.createTweets(driver);
	}
	
	@AfterTest
	public void tearDown() {
		this.driver.quit();
	}

}
