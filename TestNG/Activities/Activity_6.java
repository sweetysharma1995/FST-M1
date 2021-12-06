package com.testng.activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Activity_6 {
	WebDriver driver;
    WebDriverWait wait;
 
    @BeforeClass
    public void beforeClass() {
    	String path = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
	   	  System.setProperty("webdriver.chrome.driver",path);  
	   	     
	   	   driver = new ChromeDriver() ;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        //Open browser
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    
    @Test
    @Parameters({"username", "password"})
    public void loginTestCase(String username, String password) {
        //Find username and pasword fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        
        //Enter values
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        
        //Click Log in
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        //Assert Message
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(loginMessage, "Welcome Back, admin");
    }
 
    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
}
