package LoginData;

import StepObject.LogInSteps;
import Utils.Browser;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;



public class LoginUser extends Browser {
   private LogInSteps logInSteps = new LogInSteps(driver);
    @Test()
    public void loginTest() {

        logInSteps.usernameFieldAction("standard_user");
        logInSteps.passwordFieldAction("secret_sauce");
        logInSteps.logInButtonAction();

        //checking if we logged in website successfully
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedUrl, actualUrl);
    }
    @Test()
    public void  invalidUserTest() {

        //getting random username and password
        Faker faker =new Faker();
        String username =faker.name().username();
        String password = faker.internet().password();
        String expectedResult ="Epic sadface: Username and password do not match any user in this service";
        //getting web elements from website and fill with username and password
        logInSteps.usernameFieldAction(username);
        logInSteps.passwordFieldAction(password);
        logInSteps.logInButtonAction();
        //we wait to the error container by web driver wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("error-button")));
        // after we get error message, save to resulttext
        String resultText = driver.findElement(By.cssSelector("[class='error-message-container error']")).getText();
        // we are checking if result is correct
        Assert.assertEquals(resultText, expectedResult);


    }
}
