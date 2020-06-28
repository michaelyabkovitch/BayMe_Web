import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SenderReceiverInfo {
//this function will fill the sender receiver form
    protected  static void senderReceiverForm (WebDriver driver){
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[1]/label[1]")).click();
        driver.findElements(Constant.RECEIVER_NAME_ID).get(2).sendKeys("bbbbb");
        driver.findElements(Constant.SENDER_NAME_ID).get(3).sendKeys("aaaa");
        driver.findElement(Constant.EVENT_DROP_MENU_ID).click();
        WebDriverWait wait = new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/form/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div[3]/label[1]/div/div/ul/li[3]"))).click();
        driver.findElement(Constant.BLESSING_ID).sendKeys("Congratulations on the  recovering COVID-19 , now after isolation you will indulge yourself in delicious food");
        driver.findElement(By.className("send-now")).click();
    }
    // this function will upload the picture
    protected  static void pictureUpload(WebDriver driver){
        driver.findElement(Constant.FILE_UPLOAD_ID).sendKeys("C:\\Users\\micha\\IdeaProjects\\pic.jpg");

    }
    //this function will choose email option and fill it
    protected  static void emailSelection(WebDriver driver){
        driver.findElements(Constant.EMAIL_RECEIVES_ID).get(2).click();
        driver.findElement(Constant.EMAIL_RECEIVES_FILL_ID).sendKeys("dfdsfd@grgrg.com");
        driver.findElement(Constant.SAVE_ID).click();



    }


}
