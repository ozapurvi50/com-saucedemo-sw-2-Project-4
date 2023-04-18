package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";     //Defining variable to store Url

    @Before
    public void setUp() {                             //Method to open browser
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //Adding implicit time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Finding element and storing to variable for username
        WebElement emailField = driver.findElement(By.id("user-name"));

        //Sending text to username field
        emailField.sendKeys("standard_user");

        //Finding element for password and storing it to variable
        WebElement password = driver.findElement(By.id("password"));

        //Sending text to password field
        password.sendKeys("secret_sauce");

        //Find element using xpath and click on login button
        WebElement loginLink1 = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginLink1.click();

        //Expected text on webpage
        String expectedMessage = "PRODUCTS";

        //Finding the text and storing to variable
        WebElement actualTextElement = driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));

        //Storing value for text to variable from webpage
        String actualMessage = actualTextElement.getText();

        //Comparing both the text and printing result in console
        Assert.assertEquals("Invalid name", expectedMessage, actualMessage);

        driver.close();              //Close driver
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        //Find elements and store in variable and send text through sendkeys
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("standard_user");

        //Find elements and store in variable and send text through sendkeys
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        //Find Element from login button through xpath and click
        WebElement loginLink1 = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginLink1.click();

        //List of images to check on webpage
        List<WebElement> sliderElementList = driver.findElements(By.xpath("//div[@class='inventory_item_img']"));
        System.out.println("Total images are : " + sliderElementList.size());

       driver.close();
    }

}