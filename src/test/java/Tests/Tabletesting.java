package Tests;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tabletesting {
    private WebDriver driver = null;

    @BeforeMethod
    public void initialiseDriver() {
        ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
        options.addArguments(
                "user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");

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
        driver.navigate().to("https://the-internet.herokuapp.com/tables");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement table1=driver.findElement(By.id("table1"));
        WebElement tbody=table1.findElement(By.tagName("tbody"));

        List<WebElement>rowElements=tbody.findElements(By.tagName("tr"));
        System.out.println("ROWS COUNT ::"+rowElements.size());
        System.out.println("Column Size ::"+rowElements.get(0).findElements(By.tagName("td")).size());

        for (WebElement rowElement : rowElements) {
            List<WebElement> cloumnEle = rowElement.findElements(By.tagName("td"));
            System.out.println("Last Name :" + cloumnEle.get(0).getText());
            System.out.println("First Name :" + cloumnEle.get(1).getText());
            System.out.println("Email :" + cloumnEle.get(2).getText());
            System.out.println("Due :" + cloumnEle.get(3).getText());
            System.out.println("Web Site :" + cloumnEle.get(4).getText());
            if (cloumnEle.get(2).getText().equals("fbach@yahoo.com")) {
                cloumnEle.get(5).findElements(By.tagName("a")).get(0).click();
            }
            System.out.println("*********************************************");
        }
    }

    @Test
    public void verifyTwitterTest2() {
        String searchText="Bajaj Corp Ltd.";
        driver.navigate().to("https://demo.guru99.com/test/web-table-element.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement table1=driver.findElement(By.xpath("//table[@class='dataTable']"));
        WebElement tbody=table1.findElement(By.tagName("tbody"));
        String ele="//a[normalize-space(text())='runtime']/parent::td/parent::tr";
        WebElement row=tbody.findElement(By.xpath(ele.replace("runtime", searchText)));
        List<WebElement>rowElements=row.findElements(By.tagName("td"));
        System.out.println("Prev Close (Rs) ::"+rowElements.get(2).getText());
    }

}