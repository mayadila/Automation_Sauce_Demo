package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class AddCart {
    WebDriver driver;
    @Given("I open url {string}")
    public void iOpenUrl(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(url);
    }

    @And("I input username {string} and password {string}")
    public void iInputUsernameAndPassword(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @And("I click login button")
    public void iClickLoginButton() {
        driver.findElement(By.name("login-button")).click();
    }

    @When("user click button Add to Cart in first list product")
    public void userClickButtonAddToCartInFirstListProduct() throws Exception{
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(500);
    }

    @And("user click icon cart")
    public void userClickIconCart() throws Exception{
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(500);
    }

    @Then("in cart page, will show product user which choose")
    public void inCartPageWillShowProductUserWhichChoose() { Assert.assertEquals("Sauce Labs Backpack",driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText());
        System.out.println("Scenario : Adding product to cart");
        System.out.println("If Success Add Product to Cart " + driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText() + " , You Can See Title Product Name " + driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText() + "  in Cart Page");
        driver.quit();
    }
}
