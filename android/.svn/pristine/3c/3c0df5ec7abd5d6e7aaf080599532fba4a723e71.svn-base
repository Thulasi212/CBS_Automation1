package com.app.Android_App;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTestAgarwal;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;

public class Notification_settings {
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
	        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.community.matrimony");
	        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.domaininstance.ui.activities.Splash");
	        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
	        driver.setLogLevel(Level.INFO);

	}

	@Test
	public void testUntitled() throws InterruptedException {

		 Edit_Profile_Pom p1 = new Edit_Profile_Pom(driver);
		Matches_Pom p = new Matches_Pom(driver);
		BaseTest b = new BaseTest();
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//*[@text='LOGIN']")).click();
		} catch (Exception e) {
			System.out.println("no login button");
		}
		try {
			b.click(p1.getEnter_matri_Id1());
			b.typeData(p1.getEnter_matri_Id1(), BaseTest.readValueFromExcelSheet().get(1).get("Username"));
			Thread.sleep(5000);
			b.typeData(p1.getEnter_password1(), BaseTest.readValueFromExcelSheet().get(1).get("Password"));
			Thread.sleep(5000);
			b.click(p1.getEnter_Login1());
		} catch (Exception e) {
			System.out.println("Already login");
		}
		Thread.sleep(10000);

		try {
			WebElement allow = driver.findElement(By.xpath("//*[@text='ALLOW']"));
			if (allow.isDisplayed()) {
				allow.click();
			}
		} catch (Exception e) {
			System.out.println("No photo page");

		}
		try {
			WebElement skip = driver.findElement(By.xpath("//*[@id='skip']"));
			if (skip.isDisplayed()) {
				skip.click();

			}
		} catch (Exception e) {
			e.getMessage();
		}
		try {
			WebElement popup = driver.findElement(By.xpath("//*[@id='popup_close_btn']"));
			if (popup.isDisplayed()) {
				popup.click();
			}
		} catch (Exception e) {
			e.getMessage();
		}

		// driver.findElement(By.xpath("//*[@id='skip']")).click();
		Thread.sleep(5000);
		try {
			AndroidElement photo_skip = driver.findElement(By.xpath("//*[@id='doitlater']"));
			if (photo_skip.isDisplayed()) {
				photo_skip.click();
			}
		} catch (Exception e) {
			e.getMessage();
		}

		System.out.println("login and landed in dashboard");
		Thread.sleep(5000);
		b.click(p.getMenu_btn());
		driver.swipe(0, 800, 0, 0, 2000);
		driver.swipe(0, 800, 0, 0, 2000);
		b.click(driver.findElement(By.xpath("//*[@text='Notification Settings']")));
		Thread.sleep(5000);
		try {
			List<AndroidElement> notification = driver.findElements(By.xpath("//*[@class='android.widget.Switch']"));
			Thread.sleep(5000);
			// for (int i = 1; i <= 5; i++) {
			// if (notification.contains("ON")) {
			driver.findElement(By.xpath("//*[@text='ON']")).click();
			// }
			// driver.findElement(By.xpath("//*[@text='ON']")).click();
			System.out.println("notification OFF");
			// }
		} catch (Exception e) {
			List<AndroidElement> notification1 = driver.findElements(By.xpath("//*[@class='android.widget.Switch']"));
			Thread.sleep(5000);
			// for (int i = 1; i <= 5; i++) {
			// if (notification1.contains("OFF")) {
			// driver.findElement(By.xpath("//*[@text='ON']")).click();
			driver.findElement(By.xpath("//*[@text='OFF']")).click();
			System.out.println("notification ON");
			// }
		}
		Thread.sleep(5000);
		b.click(p.getBack_btn());
		Thread.sleep(5000);
		b.click(p.getApp_version());
		// driver.findElement(By.xpath("//*[@id='appversion']")).click();
		Thread.sleep(5000);
		String appversion = driver.findElement(By.xpath("//*[@id='appversion']")).getText();
		System.out.println("The tested " + appversion);
		Thread.sleep(5000);
		b.click(p.getAccount_settings());
		Thread.sleep(2000);
		b.click(p.getLogout_btn());

	}

}
//}
