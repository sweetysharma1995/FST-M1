package com.job.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity_8 {
	public static WebDriver driver = null;
	 
	  @BeforeTest
	  public void beforeTest() {
		  String path = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
		  System.setProperty("webdriver.chrome.driver",path);  
		     
		   driver = new ChromeDriver() ;
		  driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	  }
	  
	  @Test
	  public void loginIntoWebsiteBackend() {
		 driver.findElement(By.id("user_login")).sendKeys("root");
		 driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		 driver.findElement(By.id("wp-submit")).click();
		 assertEquals(driver.getTitle(),"Dashboard ‹ Alchemy Jobs — WordPress");
			
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.close();
	  }
}
