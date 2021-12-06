package com.job.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Activity_1 {
	public static WebDriver driver = null;
	
  @BeforeTest
  public void beforeTest() {
	  String path = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
	  System.setProperty("webdriver.chrome.driver",path);  
	     
	   driver = new ChromeDriver() ;
	  driver.get("https://alchemy.hguy.co/jobs/");
	  
	  
  }

  @Test
  public void getTitle() {	 
	  
	  assertEquals(driver.getTitle(), "Alchemy Jobs – Job Board Application");
  }
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
