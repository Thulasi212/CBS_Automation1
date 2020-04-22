package com.app.Android_App;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTestAgarwal;

import java.net.URL;
import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

public class Daily_matches extends BaseTest {
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

	@BeforeMethod
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
			b.typeData(p1.getEnter_matri_Id1(), "EZH710533");
			Thread.sleep(5000);
			b.typeData(p1.getEnter_password1(), BaseTestAgarwal.readValueFromExcelSheet().get(1).get("Password"));
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

	}

	@Test
	public void testUntitled1() throws InterruptedException {
		Matches_Pom p = new Matches_Pom(driver);
		BaseTest b = new BaseTest();

		Thread.sleep(5000);

		b.click(driver.findElement(By.xpath("(//*[@id='icon'])[5]")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@id='ln_daily7']")));
		Thread.sleep(5000);
		try {
			b.click(driver.findElement(By.xpath("//*[@id='ivFilter']")));
		} catch (Exception e) {
			System.out.println("no filter is present");
		}
		try {
			driver.findElement(By.xpath("//*[@text='Matching Profiles']"));
			String time_left = driver.findElement(By.xpath("//*[@id='progress']")).getText();
			System.out.println(time_left);
		} catch (Exception e) {
			System.out.println("no profile");
		}
		Thread.sleep(5000);
		Dimension size = driver.manage().window().getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		System.out.println(width);
		int y = (int) (height * 0.15);
		int startx = (int) (width * 0.75);
		int endx = (int) (width * 0.35);
		Thread.sleep(5000);

		// b.click(driver.findElement(By.xpath("//*[@id='btnYes']")));

		driver.swipe(startx, y, endx, y, 4000);
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")));
		Thread.sleep(5000); //
		// b.click(driver.findElement(By.xpath("(//*[@id='icon'])[5]")));
		System.out.println("dailymatches swipe right success ");

		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 1000);
		Thread.sleep(5000);
		b.click(p.getAccount_settings());
		Thread.sleep(2000);
		b.click(p.getLogout_btn());

	}

	@Test
	public void testUntitled2() throws InterruptedException {

		Matches_Pom p = new Matches_Pom(driver);
		BaseTest b = new BaseTest();

		Thread.sleep(5000);

		b.click(driver.findElement(By.xpath("(//*[@id='icon'])[5]")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@id='ln_daily7']")));
		Thread.sleep(5000);
		try {
			b.click(driver.findElement(By.xpath("//*[@id='ivFilter']")));
		} catch (Exception e) {
			System.out.println("no filter is present");
		}
		try {
			driver.findElement(By.xpath("//*[@text='Matching Profiles']"));
			String time_left = driver.findElement(By.xpath("//*[@id='progress']")).getText();
			System.out.println(time_left);
		} catch (Exception e) {

			System.out.println("no profile");
		}
		Thread.sleep(5000);
		Dimension size = driver.manage().window().getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		System.out.println(width);
		int y = (int) (height * 0.15);
		int startx = (int) (width * 0.75);
		int endx = (int) (width * 0.35);
		Thread.sleep(5000);
		//driver.swipe(startx, y, endx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")));
		Thread.sleep(5000); //
		// b.click(driver.findElement(By.xpath("(//*[@id='icon'])[5]")));
		System.out.println("dailymatches swipe left success ");

		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 1000);
		Thread.sleep(5000);
		b.click(p.getAccount_settings());
		Thread.sleep(2000);
		b.click(p.getLogout_btn());

	}

	@Test
	public void testUntitled3() throws InterruptedException {

		Matches_Pom p = new Matches_Pom(driver);
		BaseTest b = new BaseTest();

		Thread.sleep(5000);

		b.click(driver.findElement(By.xpath("(//*[@id='icon'])[5]")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@id='ln_daily7']")));
		Thread.sleep(5000);
		try {
			b.click(driver.findElement(By.xpath("//*[@id='ivFilter']")));
		} catch (Exception e) {
			System.out.println("no filter is present");
		}
		Thread.sleep(5000);
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@text='Matching Profiles']"));
			String time_left = driver.findElement(By.xpath("//*[@id='progress']")).getText();
			System.out.println(time_left);
		} catch (Exception e) {
			System.out.println("no match");
		}

		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@id='btnYes']")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")));
		Thread.sleep(5000); //
		// b.click(driver.findElement(By.xpath("(//*[@id='icon'])[5]")));
		System.out.println("dailymatches send yes btn success ");

		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 1000);
		Thread.sleep(5000);
		Thread.sleep(5000);
		b.click(p.getAccount_settings());
		Thread.sleep(2000);
		b.click(p.getLogout_btn());

	}

	@Test
	public void testUntitled4() throws InterruptedException {

		Matches_Pom p = new Matches_Pom(driver);
		BaseTest b = new BaseTest();
		Thread.sleep(5000);

		// b.click(driver.findElement(By.xpath("(//*[@id='icon'])[5]")));
		b.click(p.getMenu_btn());
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@id='ln_daily7']")));
		Thread.sleep(5000);
		try {
			b.click(driver.findElement(By.xpath("//*[@id='ivFilter']")));
		} catch (Exception e) {		System.out.println("no filter is present");
		}
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//*[@text='Matching Profiles']"));
			String time_left = driver.findElement(By.xpath("//*[@id='progress']")).getText();
			System.out.println(time_left);
		} catch (Exception e) {
			System.out.println("no match");
		}
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@id='btnSkip']")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")));
		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 1000);
		Thread.sleep(5000);
		b.click(p.getAccount_settings());
		Thread.sleep(2000);
		b.click(p.getLogout_btn());

		System.out.println("dailymatches send skip  success ");

	}

	@Test
	public void testUntitled5() throws InterruptedException {

		Matches_Pom p = new Matches_Pom(driver);
		BaseTest b = new BaseTest();

		Thread.sleep(5000);

		// b.click(driver.findElement(By.xpath("(//*[@id='icon'])[5]")));
		b.click(p.getMenu_btn());
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@id='ln_daily7']")));
		Thread.sleep(5000);
		try {
			b.click(driver.findElement(By.xpath("//*[@id='ivFilter']")));
		} catch (Exception e) {
			System.out.println("no filter is present");
		}
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//*[@text='Matching Profiles']"));
			String time_left = driver.findElement(By.xpath("//*[@id='progress']")).getText();
			System.out.println(time_left);
		} catch (Exception e) {
			System.out.println("no match");
		}
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id='ivDailyImg']")).click();
		// driver.findElement(By.xpath("//*[@text='SHORTLIST']")).click();

		Thread.sleep(5000);
		try {
			AndroidElement do_u_like_popup = driver.findElement(By.xpath("//*[@id='send_yes_interest_btn']"));
			Thread.sleep(5000);
			if (do_u_like_popup.isDisplayed()) {
				do_u_like_popup.click();
				String text1 = driver.findElement(By.xpath("//*[@text='You have sent interest to her.']")).getText();
				System.out.println(text1);
			}
		} catch (Exception e) {
			System.out.println("There is no  matches to send Interest");
		}
		Thread.sleep(5000);
		try {
			AndroidElement daily_matches_shortlist = driver.findElement(By.xpath("//*[@text='SHORTLIST']"));
			if (daily_matches_shortlist.isDisplayed()) {
				daily_matches_shortlist.click();
				driver.findElement(By.xpath("//*[@text='SEND INTEREST']")).click();
				b.click(p.getBack_btn());
				b.click(p.getNot_now_btn());
			}
		} catch (Exception e) {

		}

		Thread.sleep(5000);
		try {
			if (p.getSend_mail().isDisplayed()) { // b.click(p.getSend_mail());
				Thread.sleep(5000);
				p.getSend_mail().click();
				Thread.sleep(5000);
				// System.out.println(p.getPrint_matri_id().getText());
				Thread.sleep(5000);
				p.getBack_btn().click();
				Thread.sleep(5000);
				p.getNot_now_btn().click();

			}
		} catch (Exception e) {
			System.out.println("There is no  matches to send Mail");
		}
		Thread.sleep(5000);
		try {
			AndroidElement right_corner_button = driver.findElement(By.xpath("//*[@id='ivContentPopup']"));
			Thread.sleep(5000);
			if (right_corner_button.isDisplayed()) {
				Thread.sleep(5000);
				right_corner_button.click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@text='Send SMS']")).click();
				Thread.sleep(5000);
				p.getBack_btn().click();
				Thread.sleep(5000);
				// p.getNot_now_btn().click();

			}

		} catch (Exception e) {
			System.out.println("no button clicked");
		}

		Thread.sleep(5000);
		List<AndroidElement> req1 = driver.findElements(By.xpath("//*[@text='Request']"));

		System.out.println(req1.size());

		int req2 = (req1.size() / 2) - 1;

		System.out.println(req2);

		for (int i = 0; i < req2; i++) {

			Thread.sleep(5000);

			// Thread.sleep(5000);

			driver.scrollToExact("Request").click();

			// Thread.sleep(5000);

		}

		try {
			Thread.sleep(5000);
			driver.scrollToExact("RELIGIOUS INFORMATION");
			Thread.sleep(5000);
			if (driver.findElement(By.xpath("//*[@text='REQUEST HOROSCOPE']")).isDisplayed()) {
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@text='REQUEST HOROSCOPE']")).click();
			} else {
				System.out.println("Request Was Already Sent");

			}
		} catch (Exception e) {
			System.out.println("Religious Information Was not Displayed");
		}

		Thread.sleep(5000);
		b.click(p.getBack_btn());
		Thread.sleep(5000);
		b.click(p.getBack_btn());
		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
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

		System.out.println("dailymatches daily matches viewprofile send request success ");
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

	/*
	 * @Test(priority=-1) public void testUntitled5() throws InterruptedException {
	 * 
	 * Matches_Pom p = new Matches_Pom(driver); BaseTest b = new BaseTest();
	 * 
	 * Thread.sleep(5000);
	 * 
	 * b.click(driver.findElement(By.xpath("(//*[@id='icon'])[5]")));
	 * Thread.sleep(5000);
	 * b.click(driver.findElement(By.xpath("//*[@id='ln_daily7']")));
	 * Thread.sleep(5000); if
	 * (driver.findElement(By.xpath("//*[@text='Matching Profiles']")).isDisplayed()
	 * ) { String time_left =
	 * driver.findElement(By.xpath("//*[@id='progress']")).getText();
	 * System.out.println(time_left); } else {
	 * 
	 * System.out.println("no matching btn found");
	 * 
	 * 
	 * 
	 * }
	 */

}
