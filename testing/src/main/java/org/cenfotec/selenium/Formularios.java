package org.cenfotec.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Formularios {
    static WebDriver  driver;
    static String baseUrl = "http://newtours.demoaut.com";
    static String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    public static void main(String[] args){
        try{
                System.setProperty("webdriver.chrome.driver", chromePath);
                driver = new ChromeDriver();
                driver.get(baseUrl);
                WebElement Register = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a"));
                Register.click();

                WebElement inputFirstName = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input"));
                inputFirstName.sendKeys("xdddddddddddddddddddddddddd");
                Thread.sleep(2000);
                inputFirstName.clear();
                Thread.sleep(2000);
                inputFirstName.sendKeys("Victor Victor Victor Victor");
                Thread.sleep(2000);


                Select pais = new Select(driver.findElement(By.name("country")));
                Thread.sleep(2000);
                pais.selectByVisibleText("COSTA RICA");


                WebElement username = driver.findElement(By.xpath("//*[@id=\"email\"]"));
                username.sendKeys("Vsniper");

                WebElement password = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input"));
                password.sendKeys("v99");

                WebElement confirmpass = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[16]/td[2]/input"));
                confirmpass.sendKeys("v99");
                confirmpass.submit();

                WebElement registermessage = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/a[2]"));

                System.out.println("Prueba pasada"+ " " + registermessage.getText());



        }catch (NoSuchElementException ne) {
                System.err.println("No se encontro el WebElement" + ne.getMessage());
        }catch (WebDriverException we){
                System.err.println("Hubo un fallo:" + we.getMessage());
        }catch (Exception ex){
                System.err.println(ex.getMessage());
        }finally {
               driver.close();
         }




    }
}
