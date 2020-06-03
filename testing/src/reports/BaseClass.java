package reports;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir" + "\\drivers\\chromedriver.exe");

    public static WebDriver getDriver(){
        if (driver == null){
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void takeScreenShot (WebDriver, String fileWitchPath){
        TakesScreenshot scrShot

    }

}
