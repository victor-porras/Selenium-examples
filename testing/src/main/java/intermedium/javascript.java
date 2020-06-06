
package intermedium;

        import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.Select;
        import org.testng.Assert;
        import org.testng.annotations.*;

public class javascript {

    private WebDriver driver;
    String expectedResult = null;
    String actualResult = null;
    String baseUrL = "http://newtours.demoaut.com";
    private JavascriptExecutor js;
    String pageLoadStatus = "";

    private boolean highlight(WebElement element){
        js = (JavascriptExecutor)driver;
        for (int i = 0 ; i < 3 ; i++){
            try {
                    js.executeScript("arguments[0].setAttribute('style', 'background:red')", element);
                    Thread.sleep(1000);
                    js.executeScript("arguments[0].setAttribute('style', 'background:')", element);

            }catch (Exception e){
                System.err.println("JavaScript | Method: highlight | Exception desc: " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    private boolean scrollWindow(){
        try{
                js = (JavascriptExecutor)driver;
                //Scroll up(0,-250)/down(0,250)
                js.executeScript("window.scrollBy(0,250)");

        }catch (Exception e){
            System.err.println("JavaScript | Method: highlight | Exception desc: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean waitForPageToLoad(){
        try{
            do {
                js = (JavascriptExecutor)driver;
                pageLoadStatus = (String)js.executeScript("return document.readyState");
            }while (!pageLoadStatus.equals("complete"));

        }catch (Exception e){
            System.err.println("JavaScript | Method: highlight | Exception desc: " + e.getMessage());
            return false;
        }
        return true;
    }


    @BeforeTest
    public void launchbrowser(){
        System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrL);
        waitForPageToLoad();
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 0)
    public void goToRegisterPage(){
            WebElement linkRegister = driver.findElement(By.linkText("REGISTER"));
            Assert.assertTrue(highlight(linkRegister));
            js.executeScript("arguments[0].click();", linkRegister);
            expectedResult = "Register: Mercury Tours";
            actualResult = driver.getTitle();
            Assert.assertEquals(actualResult,expectedResult);
            Assert.assertTrue(scrollWindow());
    }

    @Test(priority = 1)
    public void registerAnUser(){
        try{
            WebElement txtFirstName = driver.findElement(By.name("firstName"));
            highlight(txtFirstName);
            txtFirstName.sendKeys("Victor P");

            WebElement ddlCountry = driver.findElement(By.name("country"));
            highlight(ddlCountry);
            new Select(ddlCountry).selectByVisibleText("AUSTRIA");

            highlight(driver.findElement(By.id("email")));
            driver.findElement(By.id("email")).sendKeys("Vporras@gmail.com");

            highlight(driver.findElement(By.name("password")));
            driver.findElement(By.name("password")).sendKeys("12345");

            WebElement txtConfirmPass = driver.findElement(By.name("confirmPassword"));
            highlight(txtConfirmPass);
            txtConfirmPass.sendKeys("12345");
            txtConfirmPass.submit();

            Assert.assertTrue(waitForPageToLoad());

            highlight(driver.findElement(By.xpath("//*[contains(text(),'Note:')]")));


        }catch (NoSuchElementException ne){
            Assert.fail("Test failed: element was not found");
        }catch (Exception e){
            Assert.fail("Test failed" + e.getMessage());
        }

    }


}
