import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class Util {
    public static String generateString(int targetStringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    public static void login(WebDriver driver, String userName){
        driver.get("https://www.tumblr.com/");
        driver.findElement(By.xpath("//a[contains(text(),\'Log in\')]")).click();
        driver.findElement(By.xpath("//section[@id=\'Get started\']/div/div/div[2]/div/section/div/form/input")).sendKeys(userName + "@gmail.com");
        driver.findElement(By.xpath("//section[@id=\'Get started\']/div/div/div[2]/div/section/div/form/button/span")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name=\'password\']")));
        }
        driver.findElement(By.xpath("//input[@name=\'password\']")).sendKeys("HelloFella420!");
        driver.findElement(By.xpath("//section[@id=\'Get started\']/div/div/div[2]/div/section/div/form/button/span")).click();
    }
}
