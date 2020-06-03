package reports;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(JyperionListener.class)
public class PdfEmail extends BaseClass{
    WebDriver driver = getDriver();

    @Test
    public void testOne(){
        driver.get("https://www.google.com/");
        Assert.assertTrue(false);
    }

    @Test
    public void testTwo(){
        driver.get("https://www.facebook.com/");
        Assert.assertTrue(true);
    }

    @Test
    public void testThree(){
        driver.get("https://www.twitch.tv/");
        Assert.assertTrue(false);
    }

    @AfterTest
    public void closeBrowser (){
        driver.quit();
    }

    @AfterSuite
    public void sendEmail(){
        sendPdfReportByEmail("vporrasgpersonal@gmail.com", "Victoreto9", "vporrasgpersonal@gmail.com", "Prueba correo de selenium", "Reporte de errores");

    }



}
