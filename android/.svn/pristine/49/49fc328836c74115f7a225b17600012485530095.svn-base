package com.app.Android_App;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class MatchesTest {
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
		Matches_Pom p = new Matches_Pom(driver);
		BaseTest b = new BaseTest();
		Thread.sleep(5000);
		/*b.click(p.getMain_Login());

		Thread.sleep(5000);
		b.click(p.getEnter_matri_Id());
		b.typeData(p.getEnter_matri_Id(), "EZH710533");
		Thread.sleep(5000);
		b.typeData(p.getEnter_password(), "cbstest");
		Thread.sleep(5000);
		b.click(p.getEnter_Login());
		Thread.sleep(10000);*/
		try {
			WebElement allow = driver.findElement(By.xpath("//*[@text='ALLOW']"));
			if (allow.isDisplayed()) {
				allow.click();
			}
		} catch (Exception e) {
			System.out.println("unable to find");

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
		Thread.sleep(3000);

		Thread.sleep(5000);
		b.click(p.getMatches());
		//System.out.println(p.getPrint_matri_id().getText());

		Thread.sleep(5000);

		if (driver.findElements(By.xpath("//*[@id='send_interestLayout']")).size()!= 0) {
			p.getSend_Intrest().click();
			//p.getBack_btn().click();
			Thread.sleep(5000);
			//p.getNot_now_btn().click();

		} else {
			System.out.println("There is no  matches to send Interest");
		}

		/*
		 * Thread.sleep(5000); if (p.getSend_mail().isDisplayed()) { //
		 * b.click(p.getSend_mail()); p.getSend_mail().click(); Thread.sleep(5000);
		 * p.getBack_btn().click(); Thread.sleep(5000); p.getNot_now_btn().click();
		 * 
		 * } else { System.out.println("There is no  matches to send Mail"); }
		 */

		Thread.sleep(5000);
		if (p.getV_shape_btn().isDisplayed()) {
			b.click(p.getV_shape_btn());
			Thread.sleep(5000);
			b.click(p.getMark_as_viewed());

		} else {
			System.out.println("There is no  matches to view");
		}
		Thread.sleep(5000);
		if (p.getV_shape_btn().isDisplayed()) {
			b.click(p.getV_shape_btn());
			Thread.sleep(5000);
			b.click(p.getIgnore());
			Thread.sleep(5000);
			b.click(p.getIgnore_block_yes());

		} else {
			System.out.println("There is no  matches to Ignore");
		}
		Thread.sleep(5000);
		if (p.getV_shape_btn().isDisplayed()) {
			b.click(p.getV_shape_btn());
			Thread.sleep(5000);
			b.click(p.getBlock());
			Thread.sleep(5000);
			b.click(p.getIgnore_block_yes());

		} else {
			System.out.println("There is no  matches to Block");
		}

	}

	@AfterTest
	public void tearDown() {
		// driver.quit();
	}
}