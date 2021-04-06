import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Registration extends TestBase{
    //@Test
    public void RegistrationTest(){

        int index = (int)((System.currentTimeMillis()/1000)%3600);
        String email = "Tom" + index + "@gmail.com";
        String password = "Tom-" +index;
        wd.findElement(By.linkText("LOGIN")).click();
        List<WebElement> inputs = wd.findElements(By.tagName("input"));
        fillByElement(inputs.get(0), email);
        fillByElement(inputs.get(1), password);
        List<WebElement> buttons = wd.findElements(By.tagName("button"));
        buttons.get(1).click();
        pause(5000);
        String text = wd.findElement(By.tagName("button")).getText();
        Assert.assertEquals(text,"Sign Out");
    }
    @Test
    public void RegistrationTest2(){

        int index = (int)((System.currentTimeMillis()/1000)%3600);
        String email = "Tomik" + index + "@gmail.com";
        String password = "Tomik-" +index;
        wd.findElement(By.linkText("LOGIN")).click();
        fillByLocator(By.cssSelector("[placeholder='Email']"),email);
        fillByLocator(By.cssSelector("[placeholder='Password']"),password);
        wd.findElement(By.cssSelector(".login_login__3EHKB button:nth-child(5)")).click();
        pause(5000);
        String text = wd.findElement(By.cssSelector("button")).getText();
        Assert.assertEquals(text,"Sign Out");
    }
}
