package org.cenfotec.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo1 {
    public static void main (String[] args){
        //Instanciar un objeto webdriver
        WebDriver driver;

        //Declarar variables
        String baseURL = "http://newtours.demoaut.com";
        String actualResult = "";
        String expectedResult = "Welcome: Mercury Tours";

        //Indicar la localizacion del archivo chromedriver.exe en la propiedad webdriver
        //System.getProperty("user.dir") = C:\..\..\..\SeleniniumBasico
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        //Abrir el navegador Chrome
        driver = new ChromeDriver();

        //Navegar a la pagina
        driver.get(baseURL);

        //Obtener el titulo de la pagina
        actualResult = driver.getTitle();

        //Imprimir el resultado usando el operador ternario
        System.out.println(actualResult.contentEquals(expectedResult)?"Prueba pasada!" + actualResult : "Prueba fallada");

        driver.close();

    }
}
