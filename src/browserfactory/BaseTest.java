package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;              //Storing driver in variable

    public void openBrowser(String baseUrl){
        driver = new ChromeDriver();            //Storing Chrome driver in variable
        driver.get(baseUrl);                    //Getting Url
        driver.manage().window().fullscreen();  //Making screen fullscreen

        //implicit time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser(){                //Close browser
        driver.quit();
    }
}
