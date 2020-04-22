package com.app.Android_App;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import java.net.URL;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class CommunityAppLive extends BaseTest {
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
		driver.findElement(By.xpath("//*[@id='matriid_from_login_layout']")).sendKeys("AGR754665");
		driver.findElement(By.xpath("//*[@id='pass__from_login_layout']")).sendKeys("cbstest");
		driver.findElement(By.xpath("//*[@id='login_btn_from_login_layout']")).click();

		test.log(LogStatus.PASS, "Login Button Clicked");

		Thread.sleep(10000);
		try {
			WebElement skip = driver.findElement(By.xpath("//*[@id='skip']"));
			if (skip.isDisplayed()) {
				skip.click();

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

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@id='icon'])[5]")).click();

		Thread.sleep(2000);

		String path = "D:\\Android HTML Report\\Android ScreenShot\\" + Math.floor(Math.random() * 14) + "Login.png";
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File destini = new File(path);
		FileUtils.copyFile(source, destini);
		Thread.sleep(2000);

		// To Scroll
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);

		// Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='appversion']")).click();
		Thread.sleep(5000);
		String appversion = driver.findElement(By.xpath("//*[@id='appversion']")).getText();
		System.out.println("++" + appversion);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='accountsLayout']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='logoutLayout']")).click();

		test.log(LogStatus.PASS, "Logged out Succesfully");

		test.log(LogStatus.PASS, "Login Test Case PASSED");

		// reports.endTest(test);

	}

	@AfterTest
	public void tearDown() {
		driver.resetApp();
		driver.quit();
		reports.endTest(test);
		reports.flush();
		// driver.resetApp();
		// driver.quit();

		// test.log(LogStatus.PASS, "Application Closed Succesfull");
		// reports.endTest(test);

	}
}
