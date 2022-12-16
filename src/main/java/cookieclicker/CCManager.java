package cookieclicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;


/*
 * The manager initializes the driver and opens up Cookie Clicker before performing operations with CCAuto's methods.
*/
public class CCManager
{
    static WebDriver driver;

    public CCManager()
    {
        File chrome = new File("src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        driver = new ChromeDriver();
    }

    private void openCookieClicker()
    {
        driver.get("https://orteil.dashnet.org/cookieclicker/");
    }

    public void run()
    {
        CCAuto clicker = new CCAuto(driver);
        openCookieClicker();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("langSelect-EN")));
        CCAuto.pickLanguage();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("bigCookie")));
        CCAuto.clickCookie();

        System.exit(0);
    }
}
