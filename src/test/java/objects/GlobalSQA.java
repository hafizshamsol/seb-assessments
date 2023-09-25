package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import data.ExcelDataProvider;

public class GlobalSQA extends ExcelDataProvider{

    WebDriver driver;

    public GlobalSQA(WebDriver driver){
        this.driver = driver;
    }

    By customerloginbutton = By.xpath("//button[normalize-space()='Customer Login']");
    By bankmanagerloginbutton = By.cssSelector("button[ng-click='manager()']");
    By addcustomerbutton = By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass1']");
    By login = By.xpath("//button[normalize-space()='Login']");
    By firstnamefield = By.xpath("//input[@placeholder='First Name']");
    By lastname = By.xpath("//input[@placeholder='Last Name']");
    By postcode = By.xpath("//input[@placeholder='Post Code']");
    By deposit = By.xpath("(//button[normalize-space()='Deposit'])[1]");
    By withdraw = By.xpath("//button[normalize-space()='Withdrawl']");
    By depositfield = By.xpath("//input[@placeholder='amount']");
    By withdrawfield = By.xpath("//input[@placeholder='amount']");
    By withdrawsubmit = By.xpath("//button[@type='submit']");
    By depositsubmit = By.xpath("//button[@type='submit']");
   // WebElement balance = driver.findElement(By.xpath("(//strong[normalize-space()='0'])[1]"));


    public void customerLogin(){
        driver.findElement(customerloginbutton).click();
    }

    public void bankmanagerLogin(){
        driver.findElement(bankmanagerloginbutton).click();
    }

    public void addCustomer(){
        driver.findElement(addcustomerbutton).click();
    }

    public void selectName(){
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='userSelect']"));
        Select selectObject = new Select(dropdown);
        selectObject.selectByIndex(1);
    }

    public void Login(){
        driver.findElement(login).click();
    }

     public void selectAccountNum(){
        WebElement dropdown = driver.findElement(By.xpath("(//select[@id='accountSelect'])[1]"));
        Select selectObject = new Select(dropdown);
        selectObject.selectByIndex(2);
    }

    public void Deposit(){
        driver.findElement(deposit).click();
    }

    public void insertDepositNo1(){
        driver.findElement(depositfield).sendKeys("50000");
    }

    public void insertDepositNo2(){
        driver.findElement(depositfield).sendKeys("5000");
    }

    public void insertDepositNo3(){
        driver.findElement(depositfield).sendKeys("1500");
    }

    public void submitDeposit(){
        driver.findElement(depositsubmit).click();
    }

    public void Withdraw(){
        driver.findElement(withdraw).click();
    }

    public void insertWithdrwalNo1(){
        driver.findElement(withdrawfield).sendKeys("3000");
    }

    public void insertWithdrwalNo2(){
        driver.findElement(withdrawfield).sendKeys("2000");
    }

    public void insertWithdrwalNo3(){
        driver.findElement(withdrawfield).sendKeys("10000");
    }

    public void insertWithdrwalNo4(){
        driver.findElement(withdrawfield).sendKeys("15000");
    }

    public void submitWithdrwal(){
        driver.findElement(withdrawsubmit).click();
    }

}
