package com.app.Android_App;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.BaseTestAgarwal;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class view_Profile extends BaseTest {
	private String reportDirectory = "reports";
	private String reportFormat = "xml";
	private String testName = "Untitled";
	protected AndroidDriver<AndroidElement> driver = null;
	Dimension size;
	int starty;
	int endy;
	int startx;

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
		Edit_Profile_Pom p1 = new Edit_Profile_Pom(driver);
		Thread.sleep(5000);
		// b.click(p.getMain_Login());

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

		Thread.sleep(5000);
		try {
			AndroidElement photo_skip = driver.findElement(By.xpath("//*[@id='doitlater']"));
			if (photo_skip.isDisplayed()) {
				photo_skip.click();
			}
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(5000);
		b.click(p.getMatches());
		Thread.sleep(5000);
		String View_profile_1 = driver.findElement(By.xpath("//*[@id='profileMatriId']")).getText();

		System.out.println(View_profile_1);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='profileUsername']")).click();
		Thread.sleep(5000);
		String Id = driver.findElement(By.xpath("//*[@text and @width>0 and @height>0 and ./parent::*[@id='toolbar']]")).getText();
		System.out.println(Id);
		Thread.sleep(5000);
		if (View_profile_1.equals(Id)) {
			System.out.println("view Profile verified");

		} else {
			System.out.println("no profile verified");
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@class='android.widget.ImageButton'])[1]")).click();
		Thread.sleep(5000);
		Dimension size = driver.manage().window().getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		System.out.println(width);
		int y = (int) (height * 0.15);
		int startx = (int) (width * 0.75);
		int endx = (int) (width * 0.35);
		driver.swipe(startx, y, endx, y, 4000);
		Thread.sleep(5000);
		b.click(p.getShortlisted_btn());
		Thread.sleep(5000);
		List<AndroidElement> shorlisted_ids = driver.findElements(By.xpath("//*[@id='profileMatriId']"));
		int s = shorlisted_ids.size();

		for (int i = 0; i < s; i++) {
			Thread.sleep(5000);
			shorlisted_ids.get(s).getText();

			System.out.println(shorlisted_ids.get(s).getText());

		}

	}

	/*
	 * @AfterTest public void tearDown() { driver.resetApp(); driver.quit();
	 * test.log(LogStatus.PASS, "Application Closed Succesfull"); //
	 * reports.endTest(test); reports.flush(); reports.close();
	 * 
	 * }
	 */
}
