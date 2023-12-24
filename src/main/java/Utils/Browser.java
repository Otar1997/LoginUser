package Utils;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Browser {
    public static WebDriver driver = new ChromeDriver();

@BeforeMethod
    public void openBrowser() {
    driver.manage().window().maximize();
    driver.get("https://www.saucedemo.com/");
}
@AfterAll
public void closeBrowser(){
      // driver.close();
    }
}

