package AddProductsInCart;

import StepObject.LogInSteps;
import StepObject.ProductAdd;
import Utils.Browser;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartTest extends Browser {
    private LogInSteps logInSteps = new LogInSteps(driver);
    private ProductAdd productAdd=new ProductAdd(driver);

    @Test
        public void AddProductsInCart(){

        logInSteps.usernameFieldAction("standard_user");
        logInSteps.passwordFieldAction("secret_sauce");
        logInSteps.logInButtonAction();

        String[] productIds ={"item_4_title_link","item_0_title_link","item_1_title_link","item_5_title_link","item_2_title_link","item_3_title_link"};
        String [] buttonIds={"add-to-cart-sauce-labs-backpack","add-to-cart-sauce-labs-bike-light","add-to-cart-sauce-labs-bolt-t-shirt","add-to-cart-sauce-labs-fleece-jacket","add-to-cart-sauce-labs-onesie","add-to-cart-test.allthethings()-t-shirt-(red)"};
        String [] addedProductNames = new String[6];
        for (int i = 0; i < productIds.length; i++){
             addedProductNames[i] = productAdd.addToCart(productIds[i],buttonIds[i]);
         }



        WebElement shoppingCart = driver.findElement(By.id("shopping_cart_container"));
        shoppingCart.click();
        for (int i = 0; i < addedProductNames.length; i++) {
            Assert.assertEquals(addedProductNames[i],driver.findElement(By.id(productIds[i])).getText());
        }

        }

}
