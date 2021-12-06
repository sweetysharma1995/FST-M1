package com.job.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity_9 {
	public static WebDriver driver = null;
	 
	  @BeforeTest
	  public void beforeTest() {
		  String path = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
		  System.setProperty("webdriver.chrome.driver",path);  
		     
		   driver = new ChromeDriver() ;
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	  }
	  
	  @Test
	  public void loginIntoWebsiteBackend() {
		 driver.findElement(By.id("user_login")).sendKeys("root");
		 driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		 driver.findElement(By.id("wp-submit")).click();
		 assertEquals(driver.getTitle(),"Dashboard ‹ Alchemy Jobs — WordPress");
			driver.findElement(By.id("menu-posts-job_listing")).click();
			driver.findElement(By.className("page-title-action")).click();
			driver.findElement(By.cssSelector("button[aria-label='Close dialog']")).click();
	//fill necessary details
			driver.findElement(By.id("post-title-0")).sendKeys("Test Analyst");
			driver.findElement(By.id("_job_location")).sendKeys("USA");
			driver.findElement(By.id("_company_name")).sendKeys("IBM USA");
			driver.findElement(By.xpath("//button[contains(text(),'Publish…')]")).click();
			driver.findElement(By.cssSelector(".components-button.editor-post-publish-button")).click();
			
			assertTrue(driver.findElement(By.cssSelector(".post-publish-panel__postpublish-header.is-opened")).getText().contains("is now live."));
				
	  
	  }

	  @AfterTest
	  public void afterTest() {
		  driver.close();
	  }
	  
}