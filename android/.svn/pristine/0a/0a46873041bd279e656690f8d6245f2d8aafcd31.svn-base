package testscripts;

//package <set your test package>;
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
import java.util.logging.Level;

public class Matches_Ignore extends BaseTestAgarwal {
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
		Matches_Pom p = new Matches_Pom(driver);
		BaseTestAgarwal b = new BaseTestAgarwal();
		Thread.sleep(5000);
		// b.click(p.getMain_Login());
		/*driver.findElement(By.xpath("//*[@text='LOGIN']")).click();
		Thread.sleep(5000);
		b.click(p.getEnter_matri_Id());
		b.typeData(p.getEnter_matri_Id(), "EZH710533");
		Thread.sleep(5000);
		b.typeData(p.getEnter_password(), "cbstest");
		Thread.sleep(5000);
		b.click(p.getEnter_Login());*/
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

		Thread.sleep(5000);
		b.click(p.getMatches());
		Thread.sleep(5000);
		//String matches= driver.findElement(By.xpath("//*[@text='2292 All Matching Profile(s)']")).getText();

		//System.out.println("*" + matches);
		//b.click(p.getView_not_contact_btn());
		Thread.sleep(5000);
		String send_interest_id = p.getPrint_matri_id().getText();
		System.out.println(p.getPrint_matri_id().getText());

		Thread.sleep(5000);
		if (p.getV_shape_btn().isDisplayed()) {
			b.click(p.getV_shape_btn());
			Thread.sleep(5000);
			b.click(p.getIgnore());
			Thread.sleep(5000);
			b.click(p.getIgnore_block_yes());
			Thread.sleep(5000);
			//String ignore_toast_message = driver.findElement(By.xpath("//*[@id='message']")).getText();

			//System.out.println( "88 " + ignore_toast_message);
		} else {
			System.out.println("There is no  matches to Ignore");

		}
		b.click(p.getMenu_btn());
		// To Scroll
		driver.swipe(0, 800, 0, 0, 1000);

		b.click(p.getAccount_settings());
		Thread.sleep(5000);
		b.click(p.getIgnored_profiles());
		Thread.sleep(5000);
		String send_interest_id1 = p.getPrint_matri_id().getText();
		System.out.println(p.getPrint_matri_id().getText());
		if (send_interest_id.equals(send_interest_id1)) {
			System.out.println("ignored profiles verified");
		} else {
			System.out.println(" NO ignored profiles verified");
		}
		}
		@AfterTest
	    public void tearDown() {
	    	driver.resetApp();
	    	driver.quit();
	    	reports.endTest(test);
	    	reports.flush();
	    	//driver.resetApp();
	    	//driver.quit();
	    	
	}
}
