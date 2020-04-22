
package com.app.Android_App;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.awt.AWTException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Save_search_photo_horoscope {
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
	public void testUntitled() throws InterruptedException, AWTException {
		 Edit_Profile_Pom p1 = new Edit_Profile_Pom(driver);
		Matches_Pom p = new Matches_Pom(driver);
		BaseTest b = new BaseTest();
		Thread.sleep(5000);
		//for (int i = 0; i <=2; i++) {
		try {
			driver.findElement(By.xpath("//*[@text='LOGIN']")).click();
		} catch (Exception e) {
			System.out.println("no login button");
		}

	

		b.click(p1.getEnter_matri_Id1());
		b.typeData(p1.getEnter_matri_Id1(), BaseTest.readValueFromExcelSheet().get(1).get("Username"));
		Thread.sleep(5000);
		b.typeData(p1.getEnter_password1(), BaseTest.readValueFromExcelSheet().get(1).get("Password"));
		Thread.sleep(5000);
		b.click(p1.getEnter_Login1());
		Thread.sleep(30000);
		//Thread.sleep(10000);

		try {
			WebElement allow = driver.findElement(By.xpath("//*[@text='ALLOW']"));
			if (allow.isDisplayed()) {
				allow.click();
			}
		} catch (Exception e) {
			System.out.println("No photo page");

		}
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
	//}
	@Test
	public void testUntitled1() throws InterruptedException {
		Matches_Pom p = new Matches_Pom(driver);
		BaseTest b = new BaseTest();

		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@id='icon'])[4]")).click();
		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 2000);
		driver.swipe(0, 800, 0, 0, 2000);
		driver.swipe(0, 800, 0, 0, 2000);
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("(//*[@id='recy_filter']/*/*/*[@id='img_arrow' and @height>0])[7]")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@text='With Photo']")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@text='Search Now']")));
		Thread.sleep(10000);
		b.click(driver
				.findElement(By.xpath("(//*[@id='recyclerview']/*/*/*/*/*/*/*[@id='profileimg' and @height>0])[1]")));
		Thread.sleep(10000);
		String photo_count = driver.findElement(By.xpath("//*[@id='tvPhotoCount']")).getText();
		Thread.sleep(5000);
		System.out.println("photo count :" + photo_count);
		Thread.sleep(5000);
		int result = Integer.parseInt(photo_count);
		Thread.sleep(5000);
		for (int i = 1; i <= result - 1; i++) {

			Dimension size = driver.manage().window().getSize();
			int height = size.getHeight();
			int width = size.getWidth();
			System.out.println(width);
			int y = (int) (height * 0.15);
			int startx = (int) (width * 0.75);
			int endx = (int) (width * 0.45);
			Thread.sleep(5000);
			driver.swipe(startx, y, endx, y, 4000);
			driver.swipe(startx, y, endx, y, 4000);

			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='gallery_next']")).click();

		}
		Thread.sleep(5000);
		b.click(p.getBack_btn());
		Thread.sleep(5000);
		b.click(p.getBack_btn());
		Thread.sleep(5000);
		// b.click(p.getBack_btn());
		Thread.sleep(5000); //
		b.click(driver.findElement(By.xpath("(//*[@id='icon'])[5]")));
		System.out.println("photo profile test is success ");

		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 1000);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='accountsLayout']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='logoutLayout']")).click();

	}

	@Test
	public void testUntitled2() throws InterruptedException {

		Matches_Pom p = new Matches_Pom(driver);
		BaseTest b = new BaseTest();

		Thread.sleep(5000);

		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@id='icon'])[4]")).click();
		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 2000);
		driver.swipe(0, 800, 0, 0, 2000);
		driver.swipe(0, 800, 0, 0, 2000);
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("(//*[@id='recy_filter']/*/*/*[@id='img_arrow' and @height>0])[7]")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@text='With Horoscope']")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@text='Search Now']")));
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='profileMatriId']")).click();
		Thread.sleep(10000);
		try {
			b.click(driver.findElement(By.xpath("//*[@id='horoscope']")));

			Thread.sleep(10000);
			b.click(driver.findElement(By.xpath("//*[@id='text1']")));
			Thread.sleep(5000);
			b.click(driver.findElement(By.xpath("//*[@id='btnBuyAstromatch']")));
			Thread.sleep(5000);
			b.click(p.getBack_btn());
			Thread.sleep(5000);
			b.click(p.getBack_btn());
			Thread.sleep(5000);
			b.click(p.getBack_btn());
			Thread.sleep(5000);
			b.click(p.getBack_btn());
			Thread.sleep(5000);
			b.click(p.getBack_btn());
			Thread.sleep(5000); //
			b.click(driver.findElement(By.xpath("(//*[@id='icon'])[5]")));
			System.out.println("horoscope view test passed for paid id ");

			Thread.sleep(5000);
			driver.swipe(0, 800, 0, 0, 1000);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='accountsLayout']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='logoutLayout']")).click();

		} catch (Exception e) {
			System.out.println("no horoscope btn displayed");
		
		b.click(p.getBack_btn());
		b.click(p.getNot_now_btn());
		b.click(p.getBack_btn());
		b.click(p.getBack_btn());
		b.click(driver.findElement(By.xpath("(//*[@id='icon'])[5]")));
		System.out.println("horoscope view test passed for free id ");

		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 1000);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='accountsLayout']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='logoutLayout']")).click();
	}
	}

	@Test
	public void testUntitled3() throws InterruptedException {

		Matches_Pom p = new Matches_Pom(driver);
		BaseTest b = new BaseTest();

		Thread.sleep(5000);

		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@id='icon'])[4]")).click();
		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 2000);
		driver.swipe(0, 800, 0, 0, 2000);
		driver.swipe(0, 800, 0, 0, 2000);
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("(//*[@id='recy_filter']/*/*/*[@id='img_arrow' and @height>0])[7]")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@text='With Horoscope']")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@text='Search Now']")));
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='profileMatriId']")).click();
		Thread.sleep(10000);

		try {
			Thread.sleep(15000);
			if (driver.findElement(By.xpath("//*[@id='horoscope' and @width>0]")).isDisplayed()) {
				Thread.sleep(5000);
				b.click(driver.findElement(By.xpath("//*[@id='horoscope' and @width>0]")));
				Thread.sleep(5000);
				b.click(p.getBack_btn());
				Thread.sleep(5000);
				b.click(p.getNot_now_btn());
				Thread.sleep(5000);
				b.click(p.getBack_btn());
				Thread.sleep(5000);
				b.click(p.getBack_btn());
				Thread.sleep(5000);
				b.click(driver.findElement(By.xpath("(//*[@id='icon'])[5]")));
				//System.out.println("horoscope view test passed for paid id ");

				Thread.sleep(5000);
				driver.swipe(0, 800, 0, 0, 1000);
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='accountsLayout']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='logoutLayout']")).click();
				System.out.println("horoscope test handled for free id");
			}

		} catch (Exception e) {
			System.out.println(" horoscope test failed for free id");
		}
	
	}  
	 @AfterTest
	    public void tearDown() {
	    	driver.resetApp();
	    	driver.quit();
	    	//reports.endTest(test);
	    	//reports.flush();
	    	}
	}
