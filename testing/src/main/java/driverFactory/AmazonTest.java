package driverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTest {
    WebDriver driver;
    WebDriverWait waitElement;

    @BeforeTest
    public void setUpTest(){
        DriverFactory.getInstance().setDriver(BrowserType.CHROME);
        driver = DriverFactory.getInstance().getDriver();
        driver.get("https://www.amazon.com");
        waitElement = new WebDriverWait(driver, 15);
    }

    @AfterTest
    public void tearDown(){
        DriverFactory.getInstance().removeDriver();
    }

    @Test(priority = 0)
    public void searchPlasticCaseIpad(){
        WebElement txtSearch = driver.findElement(By.id("twotabsearchtextbox"));
        waitElement.until(ExpectedConditions.visibilityOf(txtSearch));
        txtSearch.sendKeys("ipad air 2 case");

        driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();

        WebElement chkPlastic = driver.findElement(By.xpath("//*[@id=\"p_n_feature_keywords_four_browse-bin/8080061011\"]/span/a/div/label/i"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", chkPlastic);
        chkPlastic.click();
    }

    @Test(priority = 1)
    public void searchThreeFiveItems(){
        for (int i = 4; i < 7; i++){
            String name = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[2]/div[" + i + "]/div/span/div/div/div[2]/h2")).getText();


            String score = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[2]/div[" + i + "]/div/span/div/div/div[3]/div/span[1]/span/a/i[1]/span")).getAttribute("innerText");

            System.out.println("Name: " + name + ", Score: " + score);
        }
    }



}
