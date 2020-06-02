package reports;

import org.openqa.selenium.WebDriver;

public class BaseClass {
    static WebDriver driver;
    static String chromePath = System.getProperty("user.dir" + "\\drivers\\chromedriver.exe");

    public static WebDriver getDriver(){

    }
}
