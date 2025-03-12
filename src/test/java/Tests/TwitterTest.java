package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageUtilities.TestUtilities;

public class TwitterTest {
	private WebDriver driver = null;

	@BeforeTest
	public void initialiseDriver() {
		this.driver = new ChromeDriver();
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
