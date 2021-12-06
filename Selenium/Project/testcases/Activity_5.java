package com.job.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity_5 {
	public static WebDriver driver = null;
	 
	  @BeforeTest
	  public void beforeTest() {
		  String path = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
		  System.setProperty("webdriver.chrome.driver",path);  
		     
		   driver = new ChromeDriver() ;
		  driver.get("https://alchemy.hguy.co/jobs/");
	  }
	  
	  @Test
	  public void navigateToJobsPage() {
		  driver.findElement(By.xpath("//a[text()='Jobs']")).click();
			
			 assertEquals( driver.getTitle() ,"Jobs – Alchemy Jobs");
			
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.close();
	  }
}
