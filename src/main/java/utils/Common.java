package utils;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.sql.Driver;

public class Common extends BaseTest{

    public static void makeScreenshot(){

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFileToDirectory(srcFile, new File(".//screenshots/"));
            Logger.htmlOutput("Taken screenshot:" + srcFile.getName());
        }
        catch (Exception e) {
            Logger.error(e.getMessage());
        }
    }

    public static void highlightElement(WebElement element)
    {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = 'red'", element);
        makeScreenshot();
        js.executeScript("arguments[0].style.backgroundColor = '"+bg+"'", element);

    }
}
