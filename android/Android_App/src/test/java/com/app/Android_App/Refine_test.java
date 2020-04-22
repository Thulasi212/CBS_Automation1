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

import Base.BaseTestAgarwal;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

public class Refine_test extends BaseTest {
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
			Thread.sleep(10000);
		}
		Thread.sleep(5000);
		try {
			if (p.getBack_btn().isDisplayed()) {
				b.click(p.getBack_btn());

			}

		} catch (Exception e) {
			System.out.println("no daily matches page displayed");
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
		Thread.sleep(5000);
		b.click(p.getMatches());
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@id='tv_filter_refine']")));
		Thread.sleep(15000);
		List<AndroidElement> employee_details12 = driver.findElements(By.xpath(
				"(//*[@id='recy_refine']/*/*/*/*[@id='txt_title' and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]])"));
		for (int i = 1; i < employee_details12.size(); i++) {
			Thread.sleep(5000);
			employee_details12.get(i).click();

			Thread.sleep(15000);
			List<AndroidElement> employee_details1 = driver
					.findElements(By.xpath("(//*[@id='refine_listView']/*/*[@id='refine_adapter_checkBox'])"));
			Thread.sleep(5000);
			for (int j = 1;j < employee_details1.size();i++) {
				Thread.sleep(10000);
				employee_details1.get(new Random(j).nextInt(employee_details1.size())).click();
				Thread.sleep(1000);
				b.click(p1.getSelect_ok_btn());
				Thread.sleep(10000);
				//List<AndroidElement> values = driver.findElements(By.xpath(
					//	"(//*[@id='recy_refine']/*/*/*/*[@id='txt_title' and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]])"));
				//Thread.sleep(5000);
				//for (int k = 1; k < values.size(); j++) {
					//Thread.sleep(5000);
					//String s1 = values.get(k).getText();
					//System.out.println("values" + s1);
					i++;
				}

			}
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
