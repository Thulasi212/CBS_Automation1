package com.app.Android_App;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class MobileNumberCount extends BaseTest {
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
		dc.setCapability(MobileCapabilityType.UDID, "16e455170205");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.community.matrimony");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.domaininstance.ui.activities.Splash");
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
		driver.setLogLevel(Level.INFO);
	}

	@BeforeMethod
	public void login() throws InterruptedException {

		Matches_Pom p = new Matches_Pom(driver);
		BaseTest b = new BaseTest();
		Thread.sleep(15000);
		// b.click(p.getMain_Login());
		try {
			driver.findElement(By.xpath("//*[@text='LOGIN']")).click();
			Thread.sleep(15000);
			b.click(p.getEnter_matri_Id());
			b.typeData(p.getEnter_matri_Id(), "RDY485145");
			Thread.sleep(15000);
			b.typeData(p.getEnter_password(), "cbstest5");
			Thread.sleep(15000);
			b.click(p.getEnter_Login());
		} catch (Exception e) {
			System.out.println("Already Logged In");
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
		Thread.sleep(15000);
		try {
			AndroidElement photo_skip = driver.findElement(By.xpath("//*[@id='doitlater']"));
			if (photo_skip.isDisplayed()) {
				photo_skip.click();
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	public void mobileNumber() throws InterruptedException {
		String s = "";
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='LATEST MATCHES']")).click();

		Thread.sleep(5000);
		String Matri_Id = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[1]")).getText();
		System.out.println(Matri_Id);

		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@id='profileDesc'])[1]")).click();

		Thread.sleep(5000);

		if (driver.findElement(By.xpath("//*[@id='vp_phone' and @width>0]")).isDisplayed()) {

			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='vp_phone' and @width>0]")).click();

			Thread.sleep(5000);
			String Number_Viewed_count = driver.findElement(By.xpath("//*[@id='mobileviewed']")).getText();
			System.out.println(Number_Viewed_count);
			String A = Number_Viewed_count.substring(16, 18);
			Integer View = Integer.parseInt(A);
			System.out.println(View);

			String Count_left = driver.findElement(By.xpath("//*[@id='countleft']")).getText();
			System.out.println(Count_left);
			String B = Count_left.substring(13, 15);
			Integer left = Integer.parseInt(B);
			System.out.println(left);

			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='view_btn']")).click();
			System.out.println("View Mobile Number");
			try {
				if (driver.findElement(By.xpath("//*[@id='tvPrimaryMobNo']")).isDisplayed()) {
					String Mobile_number = driver.findElement(By.xpath("//*[@id='tvPrimaryMobNo']")).getText();
					System.out.println(Mobile_number);

				} else {
					driver.findElement(By.xpath("//*[@id='btnRequest']")).click();
				}
			} catch (Exception e) {
				System.out.println("Not able to view the Mobile Number");
			}
			/*
			 * Thread.sleep(5000); String Mobile_number =
			 * driver.findElement(By.xpath("//*[@id='tvPrimaryMobNo']")).getText();
			 * System.out.println(Mobile_number);
			 */

			Thread.sleep(5000);
			// driver.findElement(By.xpath("//*[@id='back']")).click();
			driver.navigate().back();

			//////////////////////////////

			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='vp_phone' and @width>0]")).click();

			Thread.sleep(5000);
			String Number_Viewed_count1 = driver.findElement(By.xpath("//*[@id='mobileviewed']")).getText();
			System.out.println(Number_Viewed_count1);
			String A1 = Number_Viewed_count1.substring(16, 18);
			Integer View1 = Integer.parseInt(A1);
			System.out.println(View);

			String Count_left1 = driver.findElement(By.xpath("//*[@id='countleft']")).getText();
			System.out.println(Count_left1);
			String B1 = Count_left1.substring(13, 15);
			Integer left1 = Integer.parseInt(B1);
			System.out.println(left1);

			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='view_btn']")).click();
			System.out.println("View Mobile Number");

			try {
				if (driver.findElement(By.xpath("//*[@id='tvPrimaryMobNo']")).isDisplayed()) {
					String Mobile_number1 = driver.findElement(By.xpath("//*[@id='tvPrimaryMobNo']")).getText();
					System.out.println(Mobile_number1);

				} else {
					driver.findElement(By.xpath("//*[@id='btnRequest']")).click();
				}
			} catch (Exception e) {
				System.out.println("Not able to view the Mobile Number");
			}
			/*
			 * Thread.sleep(5000); String Mobile_number1 =
			 * driver.findElement(By.xpath("//*[@id='tvPrimaryMobNo']")).getText();
			 * System.out.println(Mobile_number1);
			 */

			Thread.sleep(5000);
			driver.navigate().back();

			if (View + 1 == View1) {
				System.out.println("Verified");

			} else {
				System.out.println("No Matched");
			}

			if (left - 1 == left1) {
				System.out.println("Verified");

			} else {
				System.out.println("No Matched");
			}

		} else {
			System.out.println("Call Now button is not displayed");

		}

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}