package Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assertion1 {

    WebDriver driver;
    @Before
    public  void setting(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void lastDuties() {
        driver.quit();
    }
    @Test
    public void test1(){


        driver.get("https://automationexercise.com");

        WebElement logo=driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(logo.isDisplayed());

        WebElement signUp= driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        signUp.click();

        WebElement loginYazıElementi= driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));
        Assert.assertTrue(loginYazıElementi.isDisplayed());

        WebElement email= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("ahmet@nehaber.com");

        WebElement password= driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("12345");

        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        WebElement loggedInYazısı=driver.findElement(By.xpath("//li[10]//a[1]"));

         Assert.assertTrue(loggedInYazısı.isDisplayed());

         driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();

         String expectedUrl="https://automationexercise.com/login";
         String actualUrl=driver.getCurrentUrl();

         Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    public void test2(){

        driver.get("https://automationexercise.com");

        WebElement logo=driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(logo.isDisplayed());

        driver.findElement(By.xpath("//a[text()=' Products']")).click();

        String expectedUrl="https://automationexercise.com/products";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        WebElement searchBox= driver.findElement(By.xpath("//input[@id='search_product']"));
        searchBox.sendKeys("T-shirts");

        driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();

        WebElement veriying = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(veriying.isDisplayed());

    }
}
