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
		options.addArguments("--headless=new");  // Use the new headless mode
		options.addArguments("--disable-gpu");
		options.addArguments("--window-size=1920,1080"); // Ensure UI elements are visible
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-extensions");
		options.addArguments("--remote-allow-origins=*");
		this.driver = new ChromeDriver(options);
	}
	
	@Test
	public void verifyTwitterTest() {
		TestUtilities testUtil=new TestUtilities();
		testUtil.searchForVegetables(driver);
	}
	
	@AfterTest
	public void tearDown() {
		this.driver.quit();
	}

}
