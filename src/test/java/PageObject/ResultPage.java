package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by hp on 07.11.2015.
 */
public class ResultPage {
    private WebDriver driver;

    public ResultPage(WebDriver driver) {
        System.out.println("ResultPage.Constructor");
        this.driver = driver;
    }

    public String getFirstLink(){
        return driver.findElement(By.xpath("(//*[@id='search']//a)[1]")).getText();
    }
}
