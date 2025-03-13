package Tests;

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
		options.addArguments("--disable-gpu");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-extensions");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-background-networking");
		options.addArguments("--disable-infobars");
		options.addArguments("--user-data-dir=/tmp/chrome-user-data-" + System.currentTimeMillis());
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		options.setExperimentalOption("useAutomationExtension", false);

		this.driver = new ChromeDriver(options);

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
