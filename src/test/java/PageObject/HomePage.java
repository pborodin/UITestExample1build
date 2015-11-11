package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hp on 07.11.2015.
 */
public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        System.out.println("HomePage.Constructor");
        this.driver = driver;
    }

    public ResultPage search(String text){
        System.out.println("HomePage.search");
        //driver.findElement(By.id("lst-ib")).sendKeys(text);
        WebElement e = driver.findElement(By.name("q"));
        e.sendKeys(text);
        e.sendKeys(Keys.RETURN);
        System.out.println(driver);
        return new ResultPage(driver);
    }

}
