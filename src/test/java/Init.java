import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Init {
    private final Properties property = new Properties();
    private FileInputStream fileInputStream;
    private WebDriver driver;

    public Init() {
        try {
            fileInputStream = new FileInputStream("./src/test/resources/config.properties");
            property.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebDriver initWebDriver() {
        if (property.getProperty("driverType").equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver", "./chromedriver");
            driver = new ChromeDriver();
        }
        return driver;
    }



    public String getProperty(String name) {
        return property.getProperty(name);
    }
}
