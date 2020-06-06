package org.cenfotec.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main (String[] args){
        WebDriver driver;
        String baseUrl = "http://live.demoguru99.com/index.php/checkout/cart";
        String actualResult = "";
        String expectedResult = "$615.00";
        String chromePath = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();

        //click en link TV
        driver.findElement(By.linkText("TV")).click();

        //click en boton ADD TO CART

        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span")).click();




        actualResult = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[5]/span/span")).getText();


        //Imprimir el resultado usando el operador ternario
        if (actualResult.contentEquals(expectedResult)){
            System.out.println("Prueba pasada");
        }else{
            System.out.println("Prueba fallida");
        };

        driver.close();



    }
}
