package com.app.Android_App;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class PWA_community {
	private String reportDirectory = "reports";
	private String reportFormat = "xml";
	private String testName = "Untitled";
	protected AndroidDriver<AndroidElement> driver = null;

	DesiredCapabilities dc = new DesiredCapabilities();

	@BeforeTest
	public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "32002b32ee5b451f");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }



	@Test
	public void testUntitled() throws Exception {
		Thread.sleep(3000);
		driver.get("https://m.communitymatrimony.com/login");
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("#login-btn > a")).click();
		Thread.sleep(3000);
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", login);
		Thread.sleep(3000);*/
		Thread.sleep(3000);
		driver.findElement(By.id("idEmail")).sendKeys("EZH710533");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("body > ion-app > ng-component > page-login > ion-content > div.scroll-content > div.loginType > form > ion-list.posrelative.list.list-md > ion-item > div.item-inner > div > ion-input > div")).sendKeys("cbstest");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("body > ion-app > ng-component > page-login > ion-content > div.scroll-content > div.loginType > form > ion-grid > ion-row:nth-child(2) > ion-col > button > span")).click();
	}

	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
}