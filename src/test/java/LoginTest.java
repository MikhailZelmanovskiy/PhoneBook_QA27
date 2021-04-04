import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest extends TestBase{
    @Test
    public void loginTest(){
        wd.findElement(By.linkText("LOGIN")).click();
        List<WebElement> inputs = wd.findElements(By.tagName("input"));
        fillByElement(inputs.get(0), "strayn.mike@gmail.com");
        fillByElement(inputs.get(1), "Mikhail-1988");
        List<WebElement> buttons = wd.findElements(By.tagName("button"));
        buttons.get(0).click();
        pause(7000);
        String text = wd.findElement(By.tagName("button")).getText();
        Assert.assertEquals(text,"Sign Out");
    }
    @Test
    public void loginTest2(){
        wd.findElement(By.cssSelector("[href='/login']"));
        fillByLocator(By.cssSelector("[placeholder='Email']"), "Mona222@gmail.com");
        fillByLocator(By.cssSelector("input[placeholder='Password']"), "Mona222-11");
        wd.findElement(By.cssSelector("button:first-of-type")).click();
        pause(7000);
        String text = wd.findElement(By.cssSelector("button")).getText();
        Assert.assertEquals(text,"Sign Out");
    }
}
