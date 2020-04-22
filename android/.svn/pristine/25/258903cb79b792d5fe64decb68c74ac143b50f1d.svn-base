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

import com.relevantcodes.extentreports.LogStatus;

import java.net.URL;
import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class Inbox extends BaseTest {
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
		driver.findElement(By.xpath("//*[@id='matriid_from_login_layout']")).sendKeys("rdy507744");
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
		driver.findElement(By.xpath("//*[@id='icon' and ./parent::*[@id='tab_mailbox']]")).click();
		try {
			driver.findElement(By.xpath("//*[@text='Click here to filter interests,\\nmessages or requests']")).click();
		} catch (Exception e) {
			System.out.println("Handled");
		}

		Thread.sleep(5000);

		WebElement pending_mail = driver.findElement(By.xpath("//*[@id='tv_view_replyLayout']"));
		Thread.sleep(3000);
		WebElement mat_ID = driver.findElement(By.xpath("//*[@id='profileMatriId']"));
				

		if (pending_mail.isDisplayed()) {
			pending_mail.click();
			Thread.sleep(3000);
			WebElement mail_content = driver.findElement(By.xpath("//*[@id='mailcontent']"));
			mail_content.sendKeys("Testing");
			Thread.sleep(3000);

			// String mat_id=mat_ID.getText();
			Thread.sleep(3000);
			System.out.println("replied_ID" + ":" + mat_ID.getText());
			driver.findElement(By.xpath("//*[@text='Send']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='popup_close_btn']")).click();
			System.out.println("999999999999999");
			// driver.findElement(By.xpath("//*[@text='YES']")).click();
			// WebElement yes = driver.findElement(By.xpath("//*[@text='YES']"));
		} else {

			System.out.println("No Message to view and Reply");
		}
		if (!pending_mail.isDisplayed()) {
			driver.findElement(By.xpath("//*[@text='YES']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='popup_close_btn']")).click();

		} else {

			System.out.println("No Interest to Accept");
		}
		Thread.sleep(3000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.findElement(By.xpath("//*[@text='Replied (17)']")).click();
		Thread.sleep(3000);
		AndroidElement Check_Id = driver.findElement(By.xpath("//*[@id='profileMatriId']"));
		Thread.sleep(3000);
		System.out.println("replied ID Checking" + ":" + Check_Id.getText());
		if (mat_ID.equals(Check_Id)) {
			System.out.println("mail replied Scenario passed");

		} else {
			System.out.println("failed");

		}

//    Thread.sleep(2000);
//	driver.findElement(By.xpath("//*[@id='icon' and ./parent::*[@id='tab_menu']]")).click();

		driver.swipe(0, 800, 0, 0, 1000);

		driver.findElement(By.xpath("//*[@id='accountsLayout']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='logoutLayout']")).click();

		test.log(LogStatus.PASS, "Logged out Succesfully");

		test.log(LogStatus.PASS, "Login Test Case PASSED");

	}

	@AfterTest
	public void tearDown() {
		driver.resetApp();
		driver.quit();
		reports.endTest(test);
		reports.flush();
		// driver.resetApp();
		// driver.quit();

	}
}
