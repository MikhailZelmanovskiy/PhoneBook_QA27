import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeSuite
    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
    }

    @AfterSuite
    public void rearDown() {
        wd.quit();
    }

    public void fillByElement(WebElement el, String text) {
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    public void fillByLocator(By locator, String text) {
        WebElement el = wd.findElement(locator);
        el.clear();
        el.click();
        el.sendKeys(text);
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isElement(By locator){
        return wd.findElements(locator).size()>0;
    }
    public void login(String email, String password){
        wd.findElement(By.cssSelector("[href='/login']")).click();
        fillByLocator(By.cssSelector("[placeholder='Email']"), email);
        fillByLocator(By.cssSelector("input[placeholder='Password']"), password);
        wd.findElement(By.cssSelector("button:first-of-type")).click();
    }
}