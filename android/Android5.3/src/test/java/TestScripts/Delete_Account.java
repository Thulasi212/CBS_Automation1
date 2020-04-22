package TestScripts;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindAll;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.Delete_POM;
import POM.Login_Pom;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.logging.Level;

public class Delete_Account extends BaseTest {
	Integer parseInt;
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

		Login_Pom l = new Login_Pom(driver);
		Delete_POM d = new Delete_POM(driver);
		try {
			Thread.sleep(2000);
			BaseTest.click(l.getHome_Login_btn());
			Thread.sleep(2000);
			BaseTest.click(l.getEnter_Matrid());
			Thread.sleep(2000);
			BaseTest.typeData(l.getEnter_Matrid(), "RDY485145");
			Thread.sleep(2000);
			BaseTest.typeData(l.getEnter_passwrd(), "cbstest5");
			Thread.sleep(2000);
			BaseTest.click(l.getEnter_Login());

		} catch (Exception e) {
			System.out.println("Already Login.................");
		}

		try {

			Thread.sleep(4000);
			BaseTest.click(l.getInter_close());
			System.out.println("intermediate page Handled......");

		} catch (Exception e) {
			System.out.println("no intermediate page displayed.....");
		}

		try {

			Thread.sleep(4000);
			BaseTest.click(l.getQuickrespnse_clse_btn());
			System.out.println("quick Response page Handled......");

		} catch (Exception e) {
			System.out.println("no quick response page displayed.....");
		}

		Thread.sleep(2000);
		BaseTest.click(d.getProfile_btn_click());
		Thread.sleep(2000);

		driver.swipe(0, 800, 0, 0, 1000);
		BaseTest.click(d.getAccounts_settings());
		Thread.sleep(2000);
		BaseTest.click(d.getDelete_profile_btn());
		Thread.sleep(2000);
		try {
			BaseTest.click(d.getMarried_btn());
			Thread.sleep(2000);
			BaseTest.click(d.getOur_site());
			Thread.sleep(2000);
			BaseTest.click(d.getMarriage_date_btn());
			Thread.sleep(2000);
			BaseTest.click(driver.findElement(By.xpath("//*[@id='button1']")));
			Thread.sleep(2000);
			BaseTest.typeData(d.getExperience_edittext_btn(), "testing profile.....");
			Thread.sleep(2000);
			BaseTest.click(d.getCancel_btn());
			System.out.println("MArried button verified.......");

		} catch (Exception e) {

			System.out.println("MArried button not verified.......");

		}

		Thread.sleep(2000);
		BaseTest.click(d.getDelete_profile_btn());
		Thread.sleep(2000);

		try {
			Thread.sleep(2000);
			BaseTest.click(d.getMarried_fixed_btn());
			Thread.sleep(2000);
			BaseTest.click(d.getOther_site_btn());
			Thread.sleep(2000);
			BaseTest.typeData(d.getSite_name(), "testing site");
			Thread.sleep(2000);
			BaseTest.typeData(d.getExperience_edittext_btn(), "testing profile.....");
			Thread.sleep(2000);
			BaseTest.click(d.getCancel_btn());
			System.out.println("MArriage fixed button verified.......");

		} catch (Exception e) {
			System.out.println("MArriage fixed  button not verified.......");
		}

		Thread.sleep(2000);
		BaseTest.click(d.getDelete_profile_btn());
		Thread.sleep(2000);
		try {
			Thread.sleep(2000);
			BaseTest.click(d.getOther_reasons_btn());
			Thread.sleep(2000);
			BaseTest.click(d.getOther_reasons_tick_btn());
			Thread.sleep(2000);
			//BaseTest.typeData(d.getExperience_edittext_btn(), "testing profile.....");
			Thread.sleep(2000);
			BaseTest.click(d.getCancel_btn());

			System.out.println("other reasons  button verified.......");

			
		} catch (Exception e) {
			System.out.println("other reasons  button not verified.......");

		}
		
		
		
		
		
		
		
		
	}
}
