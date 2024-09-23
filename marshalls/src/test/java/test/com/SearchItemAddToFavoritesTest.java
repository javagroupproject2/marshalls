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

public class SearchItemAddToFavoritesTest {

    private WebDriver driver;

    public SearchItemAddToFavoritesTest() {
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
    public void testSearchItemAddToFavorites() throws Exception {
        driver.manage().window().maximize();
        driver.get("https://www.marshalls.com/us/store/index.jsp");
        driver.findElement(By.id("search-text-input")).click();
        driver.findElement(By.id("search-text-input")).clear();
        driver.findElement(By.id("search-text-input")).sendKeys("perfume");
        driver.findElement(By.id("site-search-form")).submit();
        driver.get("https://www.marshalls.com/us/store/shop/?_dyncharset=utf-8&initSubmit=true&Ntt=perfume&qfh_sch=Search");
        driver.findElement(By.xpath("//img[@alt='Made In France 1oz Legacy Flanker Eau De Parfum']")).click();
        driver.get("https://www.marshalls.com/us/store/jump/product/Made-In-France-1oz-Legacy-Flanker-Eau-De-Parfum/4000285214?colorId=NS4155481&pos=1:3&Ntt=perfume");
        driver.findElement(By.linkText("Add this product to your favorites")).click();
    }
}
