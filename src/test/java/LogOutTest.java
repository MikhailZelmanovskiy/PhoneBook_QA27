import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LogOutTest extends TestBase{
    @BeforeMethod
    public void preconditions(){
        if(isElement(By.cssSelector("[href='/login']"))) {
            wd.findElement(By.linkText("LOGIN")).click();
            fillByLocator(By.cssSelector("[placeholder='Email']"),"strayn.mike@gmail.com");
            fillByLocator(By.cssSelector("[placeholder='Password']"),"Mikhail-1988");
            wd.findElement(By.cssSelector(".login_login__3EHKB button:nth-child(4)")).click();
        }
    }
    @Test
    public void logOutTest(){
        wd.findElement(By.tagName("button")).click();
        List<WebElement> tagA = wd.findElements(By.tagName("a"));
        String text = tagA.get(2).getText();
        Assert.assertEquals(text, "LOGIN");

    }
    @Test
    public void logOutTest2(){
        wd.findElement(By.cssSelector("button")).click();
        String text = wd.findElement(By.cssSelector("#root div a:nth-child(4)")).getText();
        Assert.assertEquals(text, "LOGIN");

    }
}
