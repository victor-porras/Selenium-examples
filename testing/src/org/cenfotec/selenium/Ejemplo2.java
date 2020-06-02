package org.cenfotec.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Ejemplo2 {
    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";


    public static void main (String[] args){
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        String baseUrl = "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebDriverWait waitVar = new WebDriverWait(driver, 10);



        try{
            driver.switchTo().frame("iframeResult");

            WebElement btntry = driver.findElement(By.xpath("/html/body/button"));
            waitVar.until(ExpectedConditions.elementToBeClickable(btntry));
            btntry.click();
            Thread.sleep(4000);

            waitVar.until(ExpectedConditions.alertIsPresent());
            Alert alertWindow = driver.switchTo().alert();
            String alertText = alertWindow.getText();
            System.out.println(alertText);
            alertWindow.sendKeys("VictorPorras");
            alertWindow.accept();

            String finalText = driver.findElement(By.id("demo")).getText();
            System.out.println(finalText.contains("Victor")?finalText:"Prueba fallida");


        }catch (NoSuchElementException ne) {
            System.err.println("No se encontro el WebElement" + ne.getMessage());
        }catch (NoSuchFrameException nf){
            System.err.println("No se encontro el frame" + nf.getMessage());
        }catch (NoAlertPresentException na){
            System.err.println("No se encontro la alerta" + na.getMessage());
        }catch (TimeoutException te){
            System.err.println("Tiempo de espera excedido" + te.getMessage());
        }catch (WebDriverException we){
            System.err.println("Hubo un fallo:" + we.getMessage());
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
        finally {
            driver.close();
        }

    }
}
