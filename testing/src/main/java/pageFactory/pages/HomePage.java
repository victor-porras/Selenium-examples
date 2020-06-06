package pageFactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    //By linkRegister = By.linkText("REGISTER");
    @FindBy(linkText = "REGISTER")
    WebElement linkRegister;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRegisterLink(){
         linkRegister.click();
    }

    public String getHomePageTitle(){
        return driver.getTitle();
    }

}
