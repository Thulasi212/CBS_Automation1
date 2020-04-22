package testscripts;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTestAgarwal;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;

public class teST1 {
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

		//Edit_Profile_Pom p1 = new Edit_Profile_Pom(driver);
		Matches_Pom p = new Matches_Pom(driver);
		BaseTestAgarwal b = new BaseTestAgarwal();
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//*[@text='LOGIN']")).click();
		} catch (Exception e) {
			System.out.println("no login button");
		}

		Thread.sleep(5000);
		b.click(p.getEnter_matri_Id());
		b.typeData(p.getEnter_matri_Id(), "EZh710533");
		Thread.sleep(5000);
		b.typeData(p.getEnter_password(), "cbstest");
		Thread.sleep(5000);
		b.click(p.getEnter_Login());
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
		b.click(p.getMenu_btn());
		driver.swipe(0, 800, 0, 0, 2000);
		driver.swipe(0, 800, 0, 0, 2000);
		b.click(driver.findElement(By.xpath("//*[@text='Notification Settings']")));
		Thread.sleep(5000);
		//Get status of switch using it's text.
		  String switchStatus1 = driver.findElement(By.xpath(("//*[@text='ON']"))).getText();
		  System.out.println(switchStatus1);
		  //If switchStatus1 = Monitored switch OFF, Execute inner code.
		  if((switchStatus1.trim()).equals("ON")){
		   System.out.println("Doing Monitored switch OFF");
		   //Locate switch button element by name = Monitored switch OFF.
		   AndroidElement swt = (AndroidElement) driver.findElement(By.xpath(("//*[@text='ON']")));
		   //Tap on switch button "Monitored switch OFF" to make it ON.
		   swt.tap(1, 1);
		   System.out.println("Monitored switch is ON now.");
		  }
		  //Pause test for 5 seconds to put switch ON for 5 seconds.
		  Thread.sleep(5000);
		  
		  //Get status of switch using it's text.
		  String switchStatus2 = driver.findElement(By.xpath("//*[@text='OFF']")).getText();
		  System.out.println(switchStatus2);
		  //If switchStatus1 = Monitored switch ON, Execute inner code.
		  if((switchStatus2.trim()).equals("OFF")){
		   System.out.println("Doing Monitored switch OFF");
		   //Locate switch button element by name = Monitored switch ON.
		   AndroidElement swt = (AndroidElement) driver.findElement(By.xpath("//*[@text='OFF']"));
		   //Tap on switch button "Monitored switch OFF" to make it OFF.
		   swt.tap(1, 1);
		   System.out.println("Monitored switch is OFF now.");
		  }
		 }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}