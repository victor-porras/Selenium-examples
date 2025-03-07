package avanzado;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogTest {
    WebDriver driver;
    String basUrl = "https://healthunify.com/bmicalculator/";
    Logger log = Logger.getLogger(LogTest.class);

    @BeforeClass
    public void initializeComponent(){
        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\resources\\log.properties");
    }


    @Test
    public void launchBrowser(){
        try{
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(basUrl);
            log.info("Opening website: " + basUrl);
        }catch (WebDriverException we){
            log.error("WebDriver failer: " + we.getMessage());
        }catch (Exception e){
            log.fatal(e.getMessage());
        }
    }

    @Test(dependsOnMethods = {"BMICalculator"})
    public void tearDown(){
        driver.quit();
        log.info("Browser closed");
    }

    @Test(dependsOnMethods = {"launchBrowser"})
    public void BMICalculator(){
        try{
            log.info("Escribiendo peso");
            driver.findElement(By.name("wg")).sendKeys("87");

            log.info("Seleccionando kilogramos");
            new Select(driver.findElement(By.name("opt1"))).selectByVisibleText("kilograms");

            log.info("Indicando altura en pies");
            driver.findElement(By.name("opt2")).sendKeys("5");

            log.info("Indicando altura en pulgadas");
            driver.findElement(By.name("opt3")).sendKeys("10");

            log.info("Clicking in calculate");
            driver.findElement(By.name("cc")).click();


            String SIUnit = driver.findElement(By.name("si")).getAttribute("value");
            String USUnit = driver.findElement(By.name("us")).getAttribute("value");
            String UKUnit = driver.findElement(By.name("uk")).getAttribute("value");
            String note = driver.findElement(By.name("desc")).getAttribute("value");

            log.info("SI unit = " + SIUnit);
            log.info("US unit = " + USUnit);
            log.info("UK unit = " + UKUnit);
            log.info("Description" + note);


        }catch (NoSuchElementException ne){
            log.error("webelement not found: " + ne.getMessage());
        }catch (WebDriverException we){
            log.error("webdriver failed: " + we.getAdditionalInformation());
        }catch (Exception ex){
            log.fatal(ex.getMessage());
        }
    }

}
