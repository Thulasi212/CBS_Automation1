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
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

import Base.BaseTestAgarwal;

import java.net.URL;
import java.sql.Driver;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

public class Search_by_Keyword extends BaseTest {
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
	public void testUntitled() throws InterruptedException, AWTException {
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
		driver.findElement(By.xpath("(//*[@id='icon'])[4]")).click();
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("//*[@id='edtGo']")).click();
		Thread.sleep(5000);
		String sear = "Tamil";
		AndroidElement tongue=driver.findElement(By.xpath("//*[@id='edtGo']"));tongue.sendKeys(sear);
		String s =tongue.getText();
		System.out.println("value entered is "+s);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='GO']")).click();
		Thread.sleep(5000);
		List<AndroidElement> ID=driver.findElements(By.xpath("//*[@id='profileMatriId']"));
		for (int i = 0; i < ID.size(); i++) {
			//driver.scrollTo("RDY");
			String ids = ID.get(i).getText();
			System.out.println("Thr ID are " + ids);
			
			
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='profileUsername']")).click();
		Thread.sleep(5000);
		driver.scrollToExact("Mother Tongue");
		String matri = driver.findElement(By.xpath("//*[@text='Tamil']")).getText();
		System.out.println("Mothertongue is" +matri);
		//assertEquals(sear, matri);
		if (s.equals(matri)) {
			System.out.println("verification pass");
			
		}
		else {
			System.out.println("verification fail");
		}
		
		
		/*driver.findElement(By.xpath("//*[@text='RDY']")).sendKeys("RDY510901");
		AndroidElement text = driver.findElement(By.xpath("//*[@text='RDY']"));
		text.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='editSearchById' and @top='true']")).click();*/
		/*Robot r = new Robot();
		r.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		r.keyRelease
		(java.awt.event.KeyEvent.VK_ENTER);
		*/
		//510905driver.findElement(By.xpath("//*[@id='editSearchById']")).sendKeys("510901");
	//	Thread.sleep(5000);
	//	driver.findElement(By.xpath("//*[@id='editSearchById']")).click();

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
