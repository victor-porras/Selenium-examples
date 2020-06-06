package org.cenfotec.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class closequit {
    static WebDriver driver;
    static  String baseUrl = "http://www.popuptest.com/popuptest12.html";
    static  String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    public static void close() {
        driver = new ChromeDriver();
        driver.navigate().to(baseUrl);
        driver.close();

    }
    public static void quit() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        Thread.sleep(2000);
        driver.quit();

    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath);
        quit();
    }

}
