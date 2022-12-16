package cookieclicker;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
*  CCAuto contains functions for performing a couple different tasks in cookie clicker.
*/

public class CCAuto
{
    static WebDriver driver;
    static WebElement cookie;
    static WebElement language;
    static int cookieQuantity;

    public CCAuto(WebDriver driver)
    {
        this.driver = driver;
    }

    public static void pickLanguage()
    {
        language = driver.findElement(By.id("langSelect-EN"));
        language.click();
    }

    public static void clickCookie()
    {
        cookie = driver.findElement(By.id("bigCookie"));
        JavascriptExecutor j = (JavascriptExecutor) driver;

        while (cookieQuantity < 1000000)
        {
            cookie.click();
            Long cookieQuantity = (Long)j.executeScript("return Game.cookies");
        }
    }
}
