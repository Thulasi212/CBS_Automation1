package com.app.Android_App;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import java.net.URL;
import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class matches extends BaseTest {
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
		dc.setCapability(MobileCapabilityType.UDID, "ZY223XV9ZS");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.community.matrimony");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.domaininstance.ui.activities.Splash");
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
		driver.setLogLevel(Level.INFO);
	}

	@Test
	public void loginTest() throws InterruptedException, AWTException, IOException {
		test = reports.startTest("Android Login Test");

		test.log(LogStatus.PASS, "Login Test Case Started");
		Thread.sleep(4000);
		// try {
		WebElement login = driver.findElement(By.xpath("//*[@text='LOGIN']"));
		// if (login.isDisplayed()) {
		login.click();

//			}
//		} catch (Exception e) {
//			e.getMessage();
//		}
		// driver.findElement(By.xpath("//*[@id='reg_login_button']")).click();
		test.log(LogStatus.PASS, "Entering Matri-ID & Password");
		driver.findElement(By.xpath("//*[@id='matriid_from_login_layout']")).sendKeys("EZH710533");
		driver.findElement(By.xpath("//*[@id='pass__from_login_layout']")).sendKeys("cbstest");
		driver.findElement(By.xpath("//*[@id='login_btn_from_login_layout']")).click();

		test.log(LogStatus.PASS, "Login Button Clicked");

		Thread.sleep(10000);
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

		driver.findElement(By.xpath("//*[@text='MATCHES']")).click();
		Thread.sleep(3000);
		AndroidElement send_Intrest = driver.findElement(By.xpath("//*[@id='send_interestLayout']"));
		if (send_Intrest.isDisplayed()) {
			send_Intrest.click();
			System.out.println("send intrest button clicked");
			Thread.sleep(3000);
			
		} else {
			// driver.findElement(By.xpath("//*[@id='send_interestLayout']")).click();
			System.out.println("no send intrest button clicked");

		}
		try {
			driver.findElement(By.xpath("//*[@id='popup_close_btn']")).click();
			System.out.println("profile is  ignored/Blocked");
		} catch (Exception e) {
			System.out.println(" no profile is  ignored/Blocked");
		}
		Thread.sleep(3000);
		AndroidElement Send_Mail = driver.findElement(By.xpath("//*[@text='Send Mail']"));
		if (Send_Mail.isDisplayed()) {
			Send_Mail.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@text='NOT NOW']")).click();
			Thread.sleep(3000);
		} else {
			System.out.println("send mail not clicked");
		}
		try {
			driver.findElement(By.xpath("//*[@id='popupdown']")).click();
		} catch (Exception e) {
			System.out.println("no chat displayed");
		}
		/*Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text='NOT NOW']")).click();
		Thread.sleep(3000);*/
		driver.findElement(By.xpath("(//*[@id='ivContentPopup'])[1]")).click();
		Thread.sleep(3000);
		//AndroidElement mark_as_viewed = driver.findElement(By.xpath("//*[@text='Mark As Viewed']"));
		/*if (driver.findElement(By.xpath("//*[@text='Mark As Viewed']")).isDisplayed()) {
			Thread.sleep(3000);
			driver.findElement(By.xpath(" ")).click();
		} else {
			System.out.println("profile is already viewed");

		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@id='ivContentPopup'])[1]")).click();
		Thread.sleep(5000);
		*/
		//AndroidElement Ignore = driver.findElement(By.xpath("//*[@text='Ignore']"));
		if (driver.findElement(By.xpath("//*[@text='Ignore']")).isDisplayed()) {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@text='Ignore']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@text='YES']")).click();

		} else {
			System.out.println("no profile to ignore");
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@id='ivContentPopup'])[1]")).click();
		Thread.sleep(5000);
		//AndroidElement Block = driver.findElement(By.xpath("//*[@text='Block']"));
		if (driver.findElement(By.xpath("//*[@text='Block']")).isDisplayed()) {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@text='Block']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@text='YES']")).click();

		} else {
			System.out.println("no profile to Block");
		}

	}
}