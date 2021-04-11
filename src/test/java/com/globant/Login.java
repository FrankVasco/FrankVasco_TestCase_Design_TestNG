package com.globant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.reporters.jq.TimesPanel;

public class Login {

    public WebDriver driver;


    @BeforeTest
    public void openBrowser(){
        System.setProperty ("webdriver.chrome.driver","C:\\driver\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get("https://www.espn.com/?src=com&adblock=true");
        System.out.println("...Open browser....");
        driver.manage().window().maximize();

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
        System.out.println("...Close browser...");
    }



    @Test
    public void login(){
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("global-user-trigger"))).click();
        System.out.println("Click in user icon");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-affiliatename='espn'])[1]"))).click();
        System.out.println("Click on login");
        driver.switchTo().frame("disneyid-iframe");
        System.out.println("Switch to iframe");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']"))).click();
        System.out.println("Click on e-mail textbox");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']"))).sendKeys("askim8610@gmail.com");
        System.out.println("Type the e-mail address");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']"))).click();
        System.out.println("Click on password textbox");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']"))).sendKeys("Frank861028");
        System.out.println("Type the password");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn btn-primary btn-submit ng-isolate-scope']"))).click();
        System.out.println("Click on login button");
    }

    @Test
    public void logout(){
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("global-user-trigger"))).click();
        System.out.println("Click on user icon");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"global-header\"]/div[2]/ul/li[2]/div/div/ul[1]/li[9]/a"))).click();
        System.out.println("Click on logout");
    }

    @Test
    public void disableAccount(){
        System.out.println("Click on user icon");
        System.out.println("Click on ESPN Profile");
        System.out.println("Switch to iframe");
        System.out.println("Click on Delete Account");
    }





}
