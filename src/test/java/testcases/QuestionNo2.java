package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.GlobalSQA;

public class QuestionNo2 {

    public static WebDriver driver;

    @BeforeTest (description = "Open Browser")
    public void openChrome()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().setSize(new Dimension(1024, 768));
    }

    @Test(testName = "Customer Login", priority = 1)
    public void Login()
    {
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        GlobalSQA page = new GlobalSQA(driver);
        page.customerLogin();
    }

    @Test(testName = "Select Name", priority = 2)
    public void SelectName() throws InterruptedException
    {
        GlobalSQA page = new GlobalSQA(driver);
        page.selectName();
        Thread.sleep(1000);
        page.Login();
    }

    @Test(testName = "Select Account Number", priority = 3)
    public void SelectAccountNumber() throws InterruptedException
    {
        Thread.sleep(1000);
        GlobalSQA page = new GlobalSQA(driver);
        page.selectAccountNum();
    }

    @Test(testName = "Deposit 50,000 Rupees", priority = 4)
    public void DepositNo1() throws InterruptedException
    {
        GlobalSQA page = new GlobalSQA(driver);
        page.Deposit();
        Thread.sleep(3000);
        page.insertDepositNo1();
        page.submitDeposit();
        Thread.sleep(3000);

        By balance = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > strong:nth-child(2)");
        String totalbalance = driver.findElement(balance).getText();
        System.out.println("Current Balance: " +totalbalance);
        Assert.assertEquals(totalbalance, "50000", "Current balance is correct");
    }

    @Test(testName = "Withdraw 3,000 Rupees", priority = 5)
    public void WithdrwalNo1() throws InterruptedException
    {
        GlobalSQA page = new GlobalSQA(driver);
        page.Withdraw();
        Thread.sleep(5000);
        page.insertWithdrwalNo1();
        page.submitWithdrwal();
        Thread.sleep(3000);

        By balance = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > strong:nth-child(2)");
        String totalbalance = driver.findElement(balance).getText();
        System.out.println("Current Balance: " +totalbalance);
        Assert.assertEquals(totalbalance, "47000", "Current balance is correct");
    }

    @Test(testName = "Withdraw 2,000 Rupees", priority = 6)
    public void WithdrwalNo2() throws InterruptedException
    {
        GlobalSQA page = new GlobalSQA(driver);
        page.Withdraw();
        Thread.sleep(5000);
        page.insertWithdrwalNo2();
        page.submitWithdrwal();
        Thread.sleep(3000);

        By balance = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > strong:nth-child(2)");
        String totalbalance = driver.findElement(balance).getText();
        System.out.println("Current Balance: " +totalbalance);
        Assert.assertEquals(totalbalance, "45000", "Current balance is correct");
    }

    @Test(testName = "Deposit 5,000 Rupees", priority = 7)
    public void DepositNo2() throws InterruptedException
    {
        GlobalSQA page = new GlobalSQA(driver);
        page.Deposit();
        Thread.sleep(3000);
        page.insertDepositNo2();
        page.submitDeposit();
        Thread.sleep(3000);

        By balance = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > strong:nth-child(2)");
        String totalbalance = driver.findElement(balance).getText();
        System.out.println("Current Balance: " +totalbalance);
        Assert.assertEquals(totalbalance, "50000", "Current balance is correct");
    }

    @Test(testName = "Withdraw 10,000 Rupees", priority = 8)
    public void WithdrwalNo3() throws InterruptedException
    {
        GlobalSQA page = new GlobalSQA(driver);
        page.Withdraw();
        Thread.sleep(5000);
        page.insertWithdrwalNo3();
        page.submitWithdrwal();
        Thread.sleep(3000);

        By balance = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > strong:nth-child(2)");
        String totalbalance = driver.findElement(balance).getText();
        System.out.println("Current Balance: " +totalbalance);
        Assert.assertEquals(totalbalance, "40000", "Current balance is correct");
    }

    @Test(testName = "Withdraw 15,000 Rupees", priority = 9)
    public void WithdrwalNo4() throws InterruptedException
    {
        GlobalSQA page = new GlobalSQA(driver);
        page.Withdraw();
        Thread.sleep(5000);
        page.insertWithdrwalNo4();
        page.submitWithdrwal();
        Thread.sleep(3000);

        By balance = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > strong:nth-child(2)");
        String totalbalance = driver.findElement(balance).getText();
        System.out.println("Current Balance: " +totalbalance);
        Assert.assertEquals(totalbalance, "25000", "Current balance is correct");
    }

    @Test(testName = "Deposit 1,500 Rupees", priority = 10)
    public void DepositNo3() throws InterruptedException
    {
        GlobalSQA page = new GlobalSQA(driver);
        page.Deposit();
        Thread.sleep(3000);
        page.insertDepositNo3();
        page.submitDeposit();
        Thread.sleep(3000);

        By balance = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > strong:nth-child(2)");
        String totalbalance = driver.findElement(balance).getText();
        System.out.println("Final Balance: " +totalbalance);
        Assert.assertEquals(totalbalance, "26500", "Final balance is correct");
    }

    @AfterTest(description = "Close Browser")
    public void closeChrome(){
        driver.close();
    }
    
}
