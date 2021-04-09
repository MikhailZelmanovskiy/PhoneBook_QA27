import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContacts extends TestBase{
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
    public void removeOneContact(){
        wd.findElement(By.cssSelector("[href='/contacts']")).click();

        WebElement contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
        contact.click();

        WebElement removeBth = wd.findElement(By.cssSelector(".contact-item-detailed_card__50dTS button:last-of-type"));
        removeBth.click();

    }
    @AfterMethod
    public void postConditions(){
        wd.findElement(By.cssSelector("button")).click();
    }
}
