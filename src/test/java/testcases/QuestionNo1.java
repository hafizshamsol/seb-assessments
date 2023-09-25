package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import objects.GlobalSQA;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data.ExcelDataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;

public class QuestionNo1 extends ExcelDataProvider
{

    public static WebDriver driver;

    @BeforeTest
    public void openChrome()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().setSize(new Dimension(1024, 768));
    }

    @Test(testName = "Bank Manager Login", priority = 1)
    public void login()
    {
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        GlobalSQA page = new GlobalSQA(driver);
        page.bankmanagerLogin();
    }

    @Test(testName = "Bank Manager Adds Customers", priority = 2)
    public void addCustomer()
    {
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
        GlobalSQA page = new GlobalSQA(driver);
        page.addCustomer();
    }

    @Test(dataProvider = "customerlist", priority = 3)
    public void customer(String firstname, String lastname, String passcode)
    {
        System.out.println(firstname+" | "+lastname+" | "+passcode);
        driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys(firstname);
        driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys(lastname);
        driver.findElement(By.cssSelector("input[placeholder='Post Code']")).sendKeys(passcode);
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
    }

    @Test(testName = "Delete Customers", priority = 4)
    public void checkCustomers() throws InterruptedException
    {
        driver.findElement(By.xpath("//button[normalize-space()='Customers']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Jackson");
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[5]/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Open Account']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Customers']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Christopher");
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/button[1]")).click();
    }

    @AfterTest
    public void BrowserClose()
    {
        driver.close();;
    }



    

   
    
   



}
