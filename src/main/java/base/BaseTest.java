package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Logger;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected  static WebDriver driver;

    @BeforeClass
    public static void setUp() throws IOException {

        driver = new FirefoxDriver(/*generateFirefoxProfile()*/);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        String linkUrl = "http://www.ex.ua/";
        Logger.debug("Open home page: " + linkUrl);
        driver.get(linkUrl);
    }

    @AfterClass
    public static void tearDown() throws IOException{
        //makeScreenshot();
        Logger.debug("Close webdriver");
        driver.quit();

    }

    /*protected FirefoxProfile generateFirefoxProfile() throws IOException {
        FirefoxProfile prf = new FirefoxProfile();
        File file = new File(".\\resources\\firebug-1.11.0.xpi");
        System.out.println(file.getAbsolutePath());
        prf.addExtension(file);
        prf.setPreference("extensions.firebug.currentVersion", "1.11.2");
        return (prf);
    }*/


}
