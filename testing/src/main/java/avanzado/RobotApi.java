package avanzado;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotApi {
    WebDriver driver;

    @Test
    public void robotAPITest() throws AWTException, InterruptedException {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/downloads/");

        //click en el link
        driver.findElement(By.xpath("/html/body/div[3]/table/tbody/tr[2]/td[6]/a[1]")).click();

        Robot robot = new Robot();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_DOWN);

        Thread.sleep(2000);
        for (int i = 0 ; i <= 2 ; i++){
            robot.keyPress(KeyEvent.VK_TAB);
        }

        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);

        Thread.sleep(1000);
        driver.quit();
    }
}
