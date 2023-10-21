package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Logout {
    WebDriver driver;
    @Given("User Open url {string}")
    public void userOpenUrl(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(url);
    }

    @And("User Input username {string} and password {string}")
    public void userInputUsernameAndPassword(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @And("User Click login button")
    public void userClickLoginButton() {
        driver.findElement(By.name("login-button")).click();
    }

    @When("User should navigate to left sidebar")
    public void userShouldNavigateToLeftSidebar() {
        driver.findElement(By.id("menu_button_container")).isDisplayed();
    }

    @Then("User click the logout button")
    public void userClickTheLogoutButton() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }
}
