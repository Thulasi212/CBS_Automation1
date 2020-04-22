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

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class Matches_Send_Intrest {
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
		Thread.sleep(15000);
		// b.click(p.getMain_Login());
		driver.findElement(By.xpath("//*[@text='LOGIN']")).click();
		Thread.sleep(15000);
		b.click(p.getEnter_matri_Id());
		b.typeData(p.getEnter_matri_Id(), "EZH710533");
		Thread.sleep(15000);
		b.typeData(p.getEnter_password(), "cbstest");
		Thread.sleep(15000);
		b.click(p.getEnter_Login());
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
		Thread.sleep(15000);
		try {
			AndroidElement photo_skip = driver.findElement(By.xpath("//*[@id='doitlater']"));
			if (photo_skip.isDisplayed()) {
				photo_skip.click();
			}
		} catch (Exception e) {
			e.getMessage();
		}

		Thread.sleep(115000);
		b.click(p.getMatches());
		Thread.sleep(15000);
		String send_interest_id = p.getPrint_matri_id().getText();
		System.out.println(p.getPrint_matri_id().getText());

		Thread.sleep(15000);
		try {
			if (p.getSend_Intrest().isDisplayed()) {
				p.getSend_Intrest().click();
				String text1 = driver.findElement(By.xpath("//*[@text='You have sent interest to her.']")).getText();
				System.out.println(text1);
			}
		} catch (Exception e) {
			System.out.println("There is no  matches to send Interest");
		}

		Thread.sleep(15000);
		try {
			if (p.getSend_mail().isDisplayed()) { // b.click(p.getSend_mail());
				p.getSend_mail().click();
				System.out.println(p.getPrint_matri_id().getText());
				Thread.sleep(15000);
				p.getBack_btn().click();
				Thread.sleep(15000);
				p.getNot_now_btn().click();

			}
		} catch (Exception e) {
			System.out.println("There is no  matches to send Mail");
		}

		Thread.sleep(15000);
		try {
			if (p.getBack_btn().isDisplayed()) {
				p.getBack_btn().click();
				Thread.sleep(15000);
				p.getNot_now_btn().click();
			}
		} catch (Exception e) {
			System.out.println("already upgraded");
		}

		try {
			driver.findElement(By.xpath("//*[@id='layUpgradeOption']")).getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(15000);
		String upgradetext = driver.findElement(By.xpath("//*[@text='Upgrade Now']")).getText();
		// System.out.println("*" + upgradetext);
		Thread.sleep(15000);
		String upgradetext1 = driver.findElement(By.xpath("//*[@text='to send her mail directly']")).getText();
		Thread.sleep(15000);
		System.out.println("*" + upgradetext + upgradetext1);
		Thread.sleep(15000);
		b.click(driver.findElement(By.xpath("//*[@text='Upgrade Now']")));
		Thread.sleep(15000);
		b.click(p.getBack_btn());
		Thread.sleep(15000);
		try {
			b.click(p.getNot_now_btn());
		} catch (Exception e) {
			System.out.println("no not now btn dispalyed");
		}
		// b.click(p.getNot_now_btn());

		Thread.sleep(15000);
		b.click(p.getMail_box());
		Thread.sleep(15000);
		b.click(p.getFilter());
		Thread.sleep(15000);
		b.click(p.getMail_box_sent());
		Thread.sleep(15000);
		String send_interest_id1 = p.getPrint_matri_id().getText();
		System.out.println(p.getPrint_matri_id().getText());

		if (send_interest_id.equals(send_interest_id1)) {

			System.out.println(" sent intrest Test Passed");

		} else {
			System.out.println("Check on Accepted Link");

		}
		Thread.sleep(15000);
		b.click(p.getBack_btn());
		Thread.sleep(15000);
		b.click(p.getMenu_btn());
		// To Scroll
		driver.swipe(0, 1000, 0, 0, 1000);
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@id='appversion']")).click();
		Thread.sleep(15000);
		String appversion = driver.findElement(By.xpath("//*[@id='appversion']")).getText();
		System.out.println("The tested " + appversion);

		/*
		 * b.click(p.getMail_box_sent_accepted()); String send_interest_acceptId =
		 * p.getPrint_matri_id().getText();
		 * 
		 * if (send_interest_id.equals(send_interest_acceptId)) {
		 * System.out.println("Test Passed");
		 * 
		 * } else { System.out.println("Check on Declined link Link"); }
		 * 
		 */

	}
}