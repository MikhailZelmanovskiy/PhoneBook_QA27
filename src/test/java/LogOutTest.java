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
            List<WebElement> inputs = wd.findElements(By.tagName("input"));
            fillByElement(inputs.get(0), "strayn.mike@gmail.com");
            fillByElement(inputs.get(1), "Mikhail-1988");
            List<WebElement> buttons = wd.findElements(By.tagName("button"));
            buttons.get(0).click();
        }
    }
    @Test
    public void logOutTest(){
        wd.findElement(By.tagName("button")).click();
        List<WebElement> tagA = wd.findElements(By.tagName("a"));
        String text = tagA.get(2).getText();
        Assert.assertEquals(text, "LOGIN");

    }
}
