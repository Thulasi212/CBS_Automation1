package com.app.Android_App;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;

public class Contact_Viewed extends BaseTest {
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

	@BeforeMethod
	public void testUntitled() throws InterruptedException {
		 Edit_Profile_Pom p = new Edit_Profile_Pom(driver);
		
		BaseTest b = new BaseTest();
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//*[@text='LOGIN']")).click();
		} catch (Exception e) {
			System.out.println("no login button");
		}
		try {
			b.click(p.getEnter_matri_Id1());
			b.typeData(p.getEnter_matri_Id1(), BaseTest.readValueFromExcelSheet().get(1).get("Username"));
			Thread.sleep(5000);
			b.typeData(p.getEnter_password1(), BaseTest.readValueFromExcelSheet().get(1).get("Password"));
			Thread.sleep(5000);
			b.click(p.getEnter_Login1());
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

	}

	@Test
	public void testUntitled1() throws InterruptedException {
		Matches_Pom p = new Matches_Pom(driver);
		BaseTest b = new BaseTest();

		Thread.sleep(5000);
		b.click(p.getMenu_btn());
		// b.click(driver.findElement(By.xpath("(//*[@id='icon'])[5]")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@text='Contact Viewed']")));
		Thread.sleep(5000);
		try {
			List<AndroidElement> ID = driver.findElements(By.xpath("//*[@id='profileMatriId']"));
			Thread.sleep(5000);
			for (int i = 0; i < ID.size(); i++) {
				// driver.scrollTo("RDY");
				Thread.sleep(5000);
				String ids = ID.get(i).getText();
				Thread.sleep(5000);
				System.out.println("Thr ID are " + ids);

			}
		} catch (Exception e) {
			System.out.println("no persons viewed ur contact");
		}

		Thread.sleep(5000);
		// driver.findElement(By.xpath("//*[@contentDescription='Navigate
		// up']")).click();
		b.click(p.getBack_btn());
		Thread.sleep(5000);
		try {
			WebElement skip = driver.findElement(By.xpath("//*[@id='skip']"));
			if (skip.isDisplayed()) {
				skip.click();

			}
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(5000);
		b.click(p.getMenu_btn());
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='appversion']")).click();
		Thread.sleep(5000);
		String appversion = driver.findElement(By.xpath("//*[@id='appversion']")).getText();
		System.out.println("The tested " + appversion);
		Thread.sleep(5000);
		b.click(p.getAccount_settings());
		Thread.sleep(2000);
		b.click(p.getLogout_btn());

	}

	@AfterTest
	public void tearDown() {
		// driver.resetApp();
		driver.quit();
		reports.endTest(test);
		reports.flush();
		// driver.resetApp();
		// driver.quit();

		// test.log(LogStatus.PASS, "Application Closed Succesfull");
		// reports.endTest(test);

	}
}
