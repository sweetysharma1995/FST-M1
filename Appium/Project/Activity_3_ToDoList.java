package com.google.AppiumActivities;

import static org.testng.Assert.assertFalse;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class Activity_3_ToDoList {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "<device name>");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 15);

        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void addToDoList() throws Exception {
    	String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
    	wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.className("android.view.View")));
    	
    	driver.findElement(
                MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(7).scrollIntoView(new UiSelector().textContains(\"To-Do List\"))"))
                .click();
    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.className("android.widget.EditText")));	
   //Task 1
    driver.findElementByClassName("android.widget.EditText").sendKeys("Add tasks to list");
    driver.findElementByXPath("//*[contains(@text, 'Add Task')]").click();
    driver.findElementByXPath("//*[contains(@text, 'Add tasks to list')]").click();
    Thread.sleep(5000);
    //Task 2
    driver.findElementByClassName("android.widget.EditText").sendKeys("Clear the list");
    driver.findElementByXPath("//*[contains(@text, 'Add Task')]").click();
    driver.findElementByXPath("//*[contains(@text, 'Clear the list')]").click();
    Thread.sleep(5000);
    //Task 3
    driver.findElementByClassName("android.widget.EditText").sendKeys("Get number of tasks");
    driver.findElementByXPath("//*[contains(@text, 'Add Task')]").click();
    driver.findElementByXPath("//*[contains(@text, 'Get number of tasks')]").click();
    Thread.sleep(5000);
    //clear list
    
    driver.findElementByXPath("//*[contains(@text, 'Clear List')]").click();
    Thread.sleep(5000);
    //
    
    MobileElement message = driver.findElementByXPath("//*[contains(@text, 'Add more tasks to this list.')]");
    Assert.assertFalse(message.isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
