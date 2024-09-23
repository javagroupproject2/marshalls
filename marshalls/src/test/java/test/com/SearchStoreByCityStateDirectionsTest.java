package test.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchStoreByCityStateDirectionsTest {

    private WebDriver driver;

    public SearchStoreByCityStateDirectionsTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {

        //System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.close();
    }

   

    @Test
    public void testSearchStoreByCityStateDirections() throws Exception {
        driver.manage().window().maximize();
        driver.get("https://www.marshalls.com/us/store/index.jsp");
        driver.findElement(By.linkText("Stores")).click();
        driver.get("https://www.marshalls.com/us/store/stores/storeLocator.jsp");
        driver.findElement(By.id("store-location-city")).click();
        driver.findElement(By.id("store-location-city")).clear();
        driver.findElement(By.id("store-location-city")).sendKeys("Schaumburg");
        driver.findElement(By.id("store-location-state")).click();
        new Select(driver.findElement(By.id("store-location-state"))).selectByVisibleText("Illinois");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.xpath("//div[@id='main']/div[3]/section/div[2]/section/section/ul/li[2]/a")).click();
        driver.get("https://www.marshalls.com/us/store/stores/Schaumburg-IL-60173/544/aboutstore");
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys("233");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys("233 Coventry");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys("Vernon Hills");
        driver.findElement(By.id("zip")).click();
        driver.findElement(By.id("zip")).clear();
        driver.findElement(By.id("zip")).sendKeys("60061");
        driver.findElement(By.id("state")).click();
        new Select(driver.findElement(By.id("state"))).selectByVisibleText("Illinois");
        driver.findElement(By.id("directions-submit")).click();
    }
}
