import models.Contact;
import models.User;
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
    public void tearDown() {

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

    public void openLogRegForm(){
        wd.findElement(By.xpath("//a[.='LOGIN']")).click();
    }

    public void clickLoginButton(){
        wd.findElement(By.xpath("//button[.=' Login']")).click();
    }

    public void fillLogRegForm(User user){
        fillByLocator(By.xpath("//input[@placeholder='Email']"), user.getEmail());
        fillByLocator(By.xpath("//input[@placeholder='Password']"), user.getPassword());
    }

    public String takeText(By locator){
        return wd.findElement(locator).getText();
    }
    public String takeText(WebElement element){
        return element.getText();
    }
    public boolean isLogin(){
        return isElement(By.xpath("//button[.='Sign Out']"));
    }

    public void openContactForm(){
        wd.findElement(By.xpath("//a[@href='/add']")).click();
    }

    public void fillContactForm(Contact contact){
        fillByLocator(By.xpath("//input[@placeholder='Name']"),contact.getName());
        fillByLocator(By.xpath("//input[@placeholder='Last Name']"),contact.getLastName());
        fillByLocator(By.xpath("//input[@placeholder='Phone']"),contact.getPhone());
        fillByLocator(By.xpath("//input[@placeholder='email']"),contact.getEmail());
        fillByLocator(By.xpath("//input[@placeholder='Address']"),contact.getAddress());
        fillByLocator(By.xpath("//input[@placeholder='description']"),contact.getDedscription());

    }

    public void saveNewContact(){
        wd.findElement(By.xpath("//button/b[text()='Save']")).click();
    }
    public boolean isContact(Contact contact){
        return wd.findElement(By.xpath("//h2")).getText().contains(contact.getName());
    }

}