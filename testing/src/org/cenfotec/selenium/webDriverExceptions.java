package org.cenfotec.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class webDriverExceptions {
    static WebDriver driver;

    public static void main (String[] args){

        try{
            String baseUrl = "http://live.demoguru99.com/index.php/checkout/cart";
            String actualResult = "";
            String expectedResult = "$615.00";
            String chromePath = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";

            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
            driver.get(baseUrl);
            driver.manage().window().maximize();

            //click en link TV

            WebElement LinkTV = driver.findElement(By.linkText("TV"));
            LinkTV.click();

            //click en boton ADD TO CART

            WebElement btnaddtocart =  driver.findElement(By.xpath("//*[@id=\"to\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span"));
            btnaddtocart.click();


            //obtener el precio

            WebElement subtotal = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[5]/span/span"));
            actualResult = subtotal.getText();


            //Imprimir el resultado usando el operador ternario
            if (actualResult.contentEquals(expectedResult)){
                System.out.println("Prueba pasada");
            }else{
                System.out.println("Prueba fallida");
            };

        }catch (NoSuchElementException ne) {
            System.err.println("No se encontro el WebElement" + ne.getMessage());
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
