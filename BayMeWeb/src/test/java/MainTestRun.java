import org.apache.commons.io.FileUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.xml.sax.SAXException;

import org.openqa.selenium.TakesScreenshot;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class MainTestRun {
    private static WebDriver driver;
    private static ExtentReports extent = new ExtentReports();
    private static ExtentTest test;



    @BeforeClass
    public static void runOnceBeforeClass() throws IOException, SAXException, ParserConfigurationException {
        String Browser = ReadFromXML.getData("BROWSER");
        if( Browser.equals("Firefox")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\micha\\IdeaProjects\\geckodriver-v0.26.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } else if (Browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\micha\\IdeaProjects\\chromedriver_win32_v\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\micha\\IdeaProjects\\extend.html");
            extent.attachReporter(htmlReporter);
            test=extent.createTest("Buyme","ff");


            extent.setSystemInfo("Envirmant","production");
            test.log(Status.INFO,"connecting driver");


        driver.get(ReadFromXML.getData("URL"));

    }
    @AfterClass
    public static void AfterClass (){
        driver.quit();
        extent.flush();

    }

    @Test
    public void Test01_OpenRegistration() throws IOException {
        RegistrationScreen.Open_Registration(driver);
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\micha\\IdeaProjects\\Second_Project\\ScreenShot" )).build());



    }

    @Test
    public void Test02_FillRegistrationForm () throws IOException {
        RegistrationScreen.Fill_Registration_form(driver);
       // test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\micha\\IdeaProjects\\Second_Project\\ScreenShot" )).build());

    }

    @Test
    public void Test03_DropMenuChoosing() throws IOException {
        HomeScreen.Drop_Menu_Choosing(driver);
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\micha\\IdeaProjects\\Second_Project\\ScreenShot" )).build());


    }


    @Test
    public void Test04_ChooseGift () throws IOException {
        ChooseGift.webPageChangeCheck(driver);
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\micha\\IdeaProjects\\Second_Project\\ScreenShot\\" )).build());
        ChooseGift.pickBuisness(driver);
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\micha\\IdeaProjects\\Second_Project\\ScreenShot\\" )).build());

    }
    @Test
    public void Test05_SenderReceiverInfo () throws IOException {
        SenderReceiverInfo.senderReceiverForm(driver);
        SenderReceiverInfo.pictureUpload(driver);
        SenderReceiverInfo.emailSelection(driver);
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\micha\\IdeaProjects\\Second_Project\\ScreenShot\\" )).build());

    }

    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }
}






