package com.google.AppiumActivities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Activity_1_GoogleTasksandKeep {
	 AppiumDriver<MobileElement> driver = null;
	    WebDriverWait wait;
  @BeforeTest
  public void beforeTest() throws MalformedURLException {
	  //Step-1 Open the Google Tasks app
	// Set the Desired Capabilities
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
      caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.google.android.apps.tasks");
      caps.setCapability("appActivity", "com.google.android.apps.tasks.ui.TaskListsActivity");
      caps.setCapability("noReset", true);

      // Instantiate Appium Driver
      URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
      wait = new WebDriverWait(driver, 10);

      
  }

  @Test
  public void addTasks() throws InterruptedException {
	  //Step 2 Click the button to add a new task.
	  MobileElement addTaskBtn = (MobileElement) driver.findElementByAccessibilityId("Create new task");
	  addTaskBtn.click();	   
	   Thread.sleep(15000);

	   //Complete Activity with Google Tasks
	   // 1st task
	   MobileElement taskName = (MobileElement) driver.findElementById("add_task_title");	   
	   taskName.sendKeys("Complete Activity with Google Tasks");
	   
	   MobileElement btnSave = (MobileElement) driver.findElementById("add_task_done");	   
	   btnSave.click();
	   
	   List<MobileElement> taskList = (List<MobileElement>) driver.findElementsByClassName("android.widget.TextView");	   
	  for (int i=0;i< taskList.size();i++) {
		if(taskList.get(i).getText().contains("Complete Activity with Google Tasks")){
			System.out.print("Task added");
		}
	  }

	   // 2nd task
	   addTaskBtn.click();	   
	   Thread.sleep(15000);
	   taskName.sendKeys("Complete Activity with Google Keep");
	   btnSave.click();
	   for (int i=0;i< taskList.size();i++) {
			if(taskList.get(i).getText().contains("Complete Activity with Google Keep")){
				System.out.print("Task added");
			}
		  }
// 3rd task
	   addTaskBtn.click();	   
	   Thread.sleep(15000);
	   taskName.sendKeys("Complete the second Activity Google Keep");
	   btnSave.click();
	   for (int i=0;i< taskList.size();i++) {
			if(taskList.get(i).getText().contains("Complete the second Activity Google Keep")){
				System.out.print("Task added");
			}
		  }
	   
	   
	   
	  
       
       
  }
  
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
