package com.job.testcases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity_6 {
	public static WebDriver driver = null;
	 
	  @BeforeTest
	  public void beforeTest() {
		  String path = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
		  System.setProperty("webdriver.chrome.driver",path);  
		     
		   driver = new ChromeDriver() ;
		  driver.get("https://alchemy.hguy.co/jobs/");
	  }
	  
	  @Test
	  public void applyToJob() {
		  driver.findElement(By.xpath("//a[text()='Jobs']")).click();
		driver.findElement(By.id("search_keywords")).clear();
		driver.findElement(By.id("search_keywords")).sendKeys("Automation Tester");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.cssSelector(".job_listings>li>a")).click()	;
		driver.findElement(By.cssSelector(".application_button.button")).click();
		System.out.println("Email is ------>"+ driver.findElement(By.cssSelector(".job_application_email")).getText());
			
	  }

	  @AfterTest
	  public void afterTest() {
		 driver.close();
	  }
}
