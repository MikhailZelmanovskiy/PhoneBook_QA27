import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditContactTest extends TestBase{
    @BeforeMethod
    public void precondition() {
        if (isElement(By.cssSelector("[href='/login']"))) {
            login("strayn.mike@gmail.com", "Mikhail-1988");
        }
    }

    @Test
    public void editContact(){
        wd.findElement(By.xpath("//a[.='CONTACTS']")).click();
        WebElement contact = wd.findElement(By.xpath("//div[@class='contact-item_card__2SOIM']"));
        contact.click();
        WebElement edit = wd.findElement(By.xpath("//button[.='Edit']"));
        edit.click();
        String text = wd.findElement(By.xpath("//input[@placeholder='Name']")).getAttribute("value");
        fillByLocator(By.xpath("//input[@placeholder='Name']"), text + "*");

        text = wd.findElement(By.xpath("//input[@placeholder='Last Name']")).getAttribute("value");
        fillByLocator(By.xpath("//input[@placeholder='Last Name']"), text + "*");

        text = wd.findElement(By.xpath("//input[@placeholder='Phone']")).getAttribute("value");
        fillByLocator(By.xpath("//input[@placeholder='Phone']"), text + "*");

        text = wd.findElement(By.xpath("//input[@placeholder='email']")).getAttribute("value");
        fillByLocator(By.xpath("//input[@placeholder='email']"), text + "*");

        text = wd.findElement(By.xpath("//input[@placeholder='Address']")).getAttribute("value");
        fillByLocator(By.xpath("//input[@placeholder='Address']"), text + "*");

        text = wd.findElement(By.xpath("//input[@placeholder='desc']")).getAttribute("value");
        fillByLocator(By.xpath("//input[@placeholder='desc']"), text + "*");

        WebElement save = wd.findElement(By.xpath("//button[.='Save']"));
        save.click();


    }

    @AfterMethod
    public void postConditions(){
        wd.findElement(By.cssSelector("button")).click();
    }
}
