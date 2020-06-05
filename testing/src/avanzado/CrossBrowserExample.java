package avanzado;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class CrossBrowserExample {
    WebDriver driver;
    String baseUrl = "http://newtours.demoaut.com/";
    String expected = null;
    String actual = null;
    WebDriverWait wait;

    private void setProperties(String prop, String driverName){
        System.setProperty("webdriver." + prop + ".driver", System.getProperty("user.dir")+"\\drivers\\"+ driverName + ".exe");
    }
    @BeforeTest
    @Parameters("browser")
    public void launchBrowser(String browser) throws Exception {
        switch (browser.toLowerCase()){
            case "chrome":
                setProperties("chrome" , "chromedriver");
                driver = new ChromeDriver();
            break;
            case "firefox":
                setProperties("firefox" , "geckodriver");
                driver = new FirefoxDriver();
             break;
            case "ie":
                setProperties("ie" , "IEDriverServer");
                driver = new InternetExplorerDriver();
             break;
            case "edge":
                setProperties("edge" , "MicrosoftWebDriver");
                driver = new EdgeDriver();
             break;
            default:
                throw new Exception("Incorrect Browser");


        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @BeforeMethod
    public void verifyHomePageTitle() throws InterruptedException {
        expected = "Welcome: Mercury Tours";
        Thread.sleep(2000);
        actual = driver.getTitle();
        Assert.assertEquals(actual,expected);
    }

    @AfterMethod
    public void  goBackToHomePage(){
        driver.findElement(By.linkText("Home")).click();
    }

    @Test(priority = 1, enabled = true)
    public void register(){
        driver.findElement(By.linkText("REGISTER")).click();
        expected = "Register: Mercury Tours";
        wait.until(ExpectedConditions.titleIs("Register: Mercury Tours"));
        actual = driver.getTitle();
        Assert.assertEquals(actual,expected);
    }





}
