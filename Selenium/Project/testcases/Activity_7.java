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

public class Activity_7 {
	public static WebDriver driver = null;
	 
	  @BeforeTest
	  public void beforeTest() {
		  String path = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
		  System.setProperty("webdriver.chrome.driver",path);  
		     
		   driver = new ChromeDriver() ;
		  driver.get("https://alchemy.hguy.co/jobs/");
	  }
	  
	  @Test
	  public void ceateJob() {
		  Random random = new Random();   
		  driver.findElement(By.xpath("//a[text()='Post a Job']")).click();
		  driver.findElement(By.id("create_account_email")).sendKeys("sweety@gmail.com"+random.nextInt(1000));
		driver.findElement(By.id("job_title")).clear();
		driver.findElement(By.id("job_title")).sendKeys("Automation Tester");
		driver.switchTo().frame("job_description_ifr");
		driver.findElement(By.id("tinymce")).sendKeys("Testing jobs");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("application")).sendKeys("jobs@ibm.com");
		driver.findElement(By.id("company_name")).sendKeys("IBM Pvt Ltd");
		driver.findElement(By.name("submit_job")).click();
		driver.findElement(By.id("job_preview_submit_button")).click();
		
		
		assertTrue( driver.findElement(By.cssSelector(".entry-content.clear")).getText().contains("Job listed successfully."));
			
	  }

	  @AfterTest
	  public void afterTest() {
		  //driver.close();
	  }
}
