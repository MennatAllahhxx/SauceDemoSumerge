package library;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtilityClass extends BaseClass {
    public static String readPFData(String key) throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+
                "\\TestData\\config.properties");
        Properties properties = new Properties();
        properties.load(file);
        return properties.getProperty(key);
    }

    public static void captureSS(int TCID) throws IOException {
        File dest = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File src = new File(System.getProperty("user.dir")+
                "\\FailedTestcaseScreenshot\\FailedTestCase_"+TCID+".jpg");
        FileHandler.copy(dest, src);
    }
}