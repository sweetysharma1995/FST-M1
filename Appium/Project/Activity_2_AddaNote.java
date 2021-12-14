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

public class Activity_2_AddaNote {
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
      caps.setCapability("appPackage", "com.google.android.keep");
      caps.setCapability("appActivity", "com.google.android.keep.activities.BrowseActivity");
      caps.setCapability("noReset", true);

      // Instantiate Appium Driver
      URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
      wait = new WebDriverWait(driver, 10);

      
  }

  @Test
  public void addNote() throws InterruptedException {
	  //Step 2 Click the button to add a new task.
	  MobileElement addNewNoteBtn = (MobileElement) driver.findElementByAccessibilityId("New text note");
	  addNewNoteBtn.click();	   
	   Thread.sleep(15000);

	   //Click the Create New Note button to add a new Note
	   
	   
	   MobileElement title = (MobileElement) driver.findElementById("editable_title");
	   title.sendKeys("Title1");	
	   
	   MobileElement noteDesc = (MobileElement) driver.findElementById("edit_note_text");
	   noteDesc.sendKeys("This is Note Desc");	
	   
	   
	   MobileElement backBtn = (MobileElement) driver.findElementByAccessibilityId("Open navigation drawer");
	   backBtn.click();	   
		   Thread.sleep(10000);
	   
		   List<MobileElement> notList = (List<MobileElement>) driver.findElementsByClassName("androidx.cardview.widget.CardView");	   
			  for (int i=0;i< notList.size();i++) {
				if(notList.get(i).getAttribute("content-desc").contains("Title1. This is Note Desc")){
					System.out.print("Note added");
				}
			  }
	  
       
       
  }
  
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
