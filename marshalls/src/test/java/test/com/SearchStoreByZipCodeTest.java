
package test.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SearchStoreByZipCodeTest {

    private WebDriver driver;

    public SearchStoreByZipCodeTest() {
    }

   
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
    public void testSearchStoreByZipCode() throws Exception {
        driver.manage().window().maximize();
        driver.get("https://www.marshalls.com/us/store/index.jsp");
        driver.findElement(By.linkText("Stores")).click();
        driver.get("https://www.marshalls.com/us/store/stores/storeLocator.jsp");
        driver.findElement(By.id("store-location-zip")).click();
        driver.findElement(By.id("store-location-zip")).clear();
        driver.findElement(By.id("store-location-zip")).sendKeys("60061");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("Store Info and Directions")).click();
        driver.get("https://www.marshalls.com/us/store/stores/Buffalo+Grove-IL-60089/1303/aboutstore");
    }

}
