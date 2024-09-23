
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


public class SearchItemUpToCheckOutTest {

    private WebDriver driver;

    public SearchItemUpToCheckOutTest() {
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
    public void testSearchItemUpToCheckOut() throws Exception {
        driver.manage().window().maximize();
        driver.get("https://www.marshalls.com/us/store/index.jsp");
        driver.findElement(By.id("search-text-input")).click();
        driver.findElement(By.id("search-text-input")).clear();
        driver.findElement(By.id("search-text-input")).sendKeys("jacket");
        driver.findElement(By.id("site-search-form")).submit();
        driver.get("https://www.marshalls.com/us/store/shop/?_dyncharset=utf-8&initSubmit=true&Ntt=jacket&qfh_sch=Search");
        driver.findElement(By.xpath("//span[@id='product-brand-4000285635']/span")).click();
        driver.findElement(By.xpath("//img[@alt=' ']")).click();
        driver.get("https://www.marshalls.com/us/store/jump/product/Lambskin-Leather-Jacket-With-Woven-Details/4000285635?colorId=NS4154762&pos=1:1&Ntt=jacket");
        driver.findElement(By.xpath("//div[@id='product-4000285635']/section/div[2]/form/div[3]/div/div[2]/ul/li[3]/a/span")).click();
        driver.findElement(By.id("quantity-4000285635")).click();
        new Select(driver.findElement(By.id("quantity-4000285635"))).selectByVisibleText("3");
        driver.findElement(By.id("addItemToOrder")).click();
        driver.findElement(By.linkText("View Bag")).click();
        driver.get("https://www.marshalls.com/us/store/checkout/cart.jsp");
        driver.findElement(By.name("moveToPurchaseInfoAsGuest")).click();
        driver.get("https://www.marshalls.com/us/store/checkout/checkout.jsp?_requestid=534637");
    }
}
