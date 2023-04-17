package utilities;

import java.time.Duration;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {

    public static WebDriver driver;
    public static WebDriver getDriver() {

        if (driver == null) {
            switch (BaseClass.getProperty("browser")) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.get(BaseClass.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.explicit_wait_time));
            PageInitializer.initialize();
        }
        return driver;
    }

    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
    public static Properties configfile;
    static {
        try {
            String path = Constants.filePath;
            FileInputStream input = new FileInputStream(path);
            configfile = new Properties();
            configfile.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyName) {
        return configfile.getProperty(keyName);
    }

}
