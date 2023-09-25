package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import objects.GlobalSQA;

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

    @Test(dataProvider = "customerlist")
    public void customer(String firstname, String lastname, String passcode)
    {
        System.out.println(firstname+" | "+lastname+" | "+passcode);
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstname);
        System.out.println("OK");
    }



    

   
    
   



}
