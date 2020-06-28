import org.junit.Assert;
import org.openqa.selenium.*;

public class ChooseGift {

    protected  static void webPageChangeCheck (WebDriver driver){
         Assert.assertEquals("https://buyme.co.il/search?budget=2&category=5&region=13",driver.getCurrentUrl());
    }
// this function will pick a buisness
    protected  static void pickBuisness (WebDriver driver){
        driver.findElements(Constant.RESTRANT_ID).get(2).click();
        driver.findElement(Constant.PRICE_ID).sendKeys("500");
        driver.findElements(Constant.SUBMIT_PRICE_ID).get(1).click();


    }

}
