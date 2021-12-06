package com.job.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Activity_2 {
	
	public static WebDriver driver = null;
 
  @BeforeTest
  public void beforeTest() {
	  String path = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
	  System.setProperty("webdriver.chrome.driver",path);  
	     
	   driver = new ChromeDriver() ;
	  driver.get("https://alchemy.hguy.co/jobs/");
  }
  
  @Test
  public void verifyWebsiteHeading() {
	 assertEquals( driver.findElement(By.className("entry-title")).getText(),"Welcome to Alchemy Jobs");
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
