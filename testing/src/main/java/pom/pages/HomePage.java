package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By linkRegister = By.linkText("REGISTER");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickRegisterLink(){
         driver.findElement(linkRegister).click();
    }

    public String getHomePageTitle(){
        return driver.getTitle();
    }

}
