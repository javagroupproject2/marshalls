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

public class AddItemToFavoritesTest {

    private WebDriver driver;

    public AddItemToFavoritesTest() {
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
    public void testAddItemToFavorites() throws Exception {
        driver.manage().window().maximize();
        driver.get("https://www.marshalls.com/us/store/index.jsp");
        driver.findElement(By.xpath("//div[@id='Hero_Jul_NAImagery_Fall_D']/div[2]/a[3]")).click();
        driver.get("https://www.marshalls.com/us/store/shop/new-arrivals/shoes/_/N-842114098+696105375?icid=8.2.24:Marshalls:Homepage_Desktop::Fall_NAImage_Hero_Shoes");
        driver.findElement(By.id("product-brand-4000313928")).click();
        driver.get("https://www.marshalls.com/us/store/jump/product/shoes/new-arrivals/Justin-Over-The-Knee-Heeled-Boots/4000313928?colorId=NS4154993&pos=1:4&N=842114098+696105375");
        driver.findElement(By.linkText("9.5")).click();
        driver.findElement(By.linkText("9.5")).click();
        driver.findElement(By.linkText("Add this product to your favorites")).click();
        driver.findElement(By.linkText("Favorites")).click();
        driver.get("https://www.marshalls.com/us/store/browse/favorites.jsp");
    }
}
