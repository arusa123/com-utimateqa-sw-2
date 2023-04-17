package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @Before
    public void setUp() {
        openBrowser("Chrome");
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //implicitly wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //finding xpath for sign in element
        driver.findElement(By.linkText("Sign In")).click();
        //expected TEXT ELEMENT
        String expectedTextElement = "Welcome Back!";
        //actual element text
        String actualTextElement = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        //message
        Assert.assertEquals("Welcome Back!", expectedTextElement, actualTextElement);
    }

    @Test
    public void verifyTheErrorMessage() {
        //implicitly wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //finding xpath for sign in element
        driver.findElement(By.linkText("Sign In")).click();
        //send username
        driver.findElement(By.id("user[email]")).sendKeys("prime@gmail.co");
        //sending password
        driver.findElement(By.id("user[password]")).sendKeys("prime123");
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();
        //expected result
        String expectedText = "Invalid email or password.";
        //actualtext element
        String actualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("Invalid email or password.", expectedText, actualText);
    }

    @After
    public void close() {
        closeBrowser();
    }


}
