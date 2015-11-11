package PageObject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by hp on 07.11.2015.
 */
public class GooglePageTest {
    public WebDriver driver, driver1;

    @Before
    public  void setUp(){

        //System.setProperty("webdriver.chrome.driver", "c:\\Users\\hp\\Programs\\chromedriver.exe");
        //System.setProperty("webdriver.phantomjs.driver", "c:\\Users\\hp\\Programs\\phantomjs.exe");
//        driver = new FirefoxDriver();
        driver = new PhantomJSDriver();
//        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 680));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.google.ru/?gws_rd=ssl");
//        driver.get("http://evo-land.ru/");

    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testSearch1(){
        HomePage home = new HomePage(driver);
        ResultPage result1 = home.search("auto");
        String s = result1.getFirstLink();
        System.out.println("auto" + s);
        Assert.assertTrue(s.contains("automated"));
    }

    @Test
    public void testSearch(){
        // String s;
        //s = driver.findElement(By.id("fsl")).getText();
//        s = driver.getPageSource();
//        driver.findElement(By.name("q"));
//        System.out.println(s);
        HomePage home = new HomePage(driver);
        ResultPage result = home.search("automated testing info");
        String s = result.getFirstLink();
        System.out.println("automated testing info   " + s);
        Assert.assertTrue(result.getFirstLink().contains("automated"));
    }
}
