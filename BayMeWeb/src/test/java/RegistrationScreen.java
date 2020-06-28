
import org.openqa.selenium.*;


public class RegistrationScreen {
//this function will open registration form
    protected  static void Open_Registration( WebDriver driver){
        driver.findElement(Constant.SIGNUP_BUTTON_ID).click();
        driver.findElement(Constant.REGISTRATION_BUTTON_ID).click();

    }
    //this function will fill registration form
    protected  static  void Fill_Registration_form (WebDriver driver){

        fillRegistrationForm(driver);
        driver.findElement(Constant.SUBMIT_REGISTRATION_BUTTON_ID).click();
    }



// function that fill the registration form
    protected  static void fillRegistrationForm(WebDriver driver){

        driver.findElements(Constant.FIRST_NAME_REGISTRATION_ID).get(0).sendKeys("bla");
        driver.findElements(Constant.EMAIL_REGISTRATION_ID).get(1).sendKeys("g5h774ewd4fd@qwe.com");
        driver.findElements(Constant.PASS_REGISTRATION_ID).get(2).sendKeys("Ab123456");
        driver.findElements(Constant.PASS_CONFIRMATION_REGISTRATION_ID).get(3).sendKeys("Ab123456");


    }





}
