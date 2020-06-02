
package intermedium;

        import org.openqa.selenium.By;
        import org.openqa.selenium.NoSuchElementException;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
        import org.testng.annotations.*;

public class javascript {

    private WebDriver driver;
    String expectedResult = null;
    String actualResult = null;
    String baseUrL = "http://newtours.demoaut.com";



    @BeforeTest
    public void launchbrowser(){
        System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrL);
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 0)
    public void goToRegisterPage(){

    }

    @Test(priority = 1)
    public void registerAnUser(){
        try{

        }catch (NoSuchElementException ne){
            Assert.fail("Test failed: element was not found");
        }catch (Exception e){
            Assert.fail("Test failed" + e.getMessage());
        }

    }


}
