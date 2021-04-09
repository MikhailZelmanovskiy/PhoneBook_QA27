import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase{
    @BeforeMethod
    public void preconditions(){
        if(isElement(By.cssSelector("[href='/login']"))) {
            wd.findElement(By.linkText("LOGIN")).click();
            fillByLocator(By.cssSelector("[placeholder='Email']"),"strayn.mike@gmail.com");
            fillByLocator(By.cssSelector("[placeholder='Password']"),"Mikhail-1988");
            wd.findElement(By.cssSelector(".login_login__3EHKB button:nth-child(4)")).click();
        }
    }
    @Test(invocationCount = 3)
    public void addContact(){
        int index = (int)((System.currentTimeMillis()/1000)%3600);
        wd.findElement(By.cssSelector("[href='/add']")).click();
        fillByLocator(By.cssSelector("[placeholder='Name']"),"Lola"+index);
        fillByLocator(By.cssSelector("[placeholder='Last Name']"),"LNow"+index);
        fillByLocator(By.cssSelector("[placeholder='Phone']"),"9876"+index);
        fillByLocator(By.cssSelector("[placeholder='email']"),"Lola"+index+"@gmail.com");
        fillByLocator(By.cssSelector("[placeholder='Address']"),"Tel-Aviv"+index);
        fillByLocator(By.cssSelector("[placeholder='description']"),"Friend"+index);

        wd.findElement(By.cssSelector(".add_form__2rsm2 button")).click();
        pause(500);

    }
    @AfterMethod
    public void postconditions(){
        wd.findElement(By.cssSelector("button")).click();
    }
}
