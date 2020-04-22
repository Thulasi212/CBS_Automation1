package testscripts;

//package <set your test package>;
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
import java.util.logging.Level;

public class View_Not_contacted {
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
			b.typeData(p1.getEnter_matri_Id1(), BaseTestAgarwal.readValueFromExcelSheet().get(1).get("Username"));
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

		Thread.sleep(5000);
		// b.click(p.getMatches());
		b.click(p.getView_not_contact_btn());
		Thread.sleep(5000);
		String send_interest_id = p.getPrint_matri_id().getText();
		System.out.println(p.getPrint_matri_id().getText());

		Thread.sleep(5000);
		try {
			if (p.getSend_Intrest().isDisplayed()) {
				p.getSend_Intrest().click();
				String text1 = driver.findElement(By.xpath("//*[@text='You have sent interest to her.']")).getText();
				System.out.println(text1);
			}
		} catch (Exception e) {
			System.out.println("There is no  matches to send Interest");
		}

		Thread.sleep(5000);
		try {
			if (p.getSend_mail().isDisplayed()) { // b.click(p.getSend_mail());
				p.getSend_mail().click();
				System.out.println(p.getPrint_matri_id().getText());
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
			if (p.getBack_btn().isDisplayed()) {
				p.getBack_btn().click();
				Thread.sleep(5000);
				p.getNot_now_btn().click();
			}
		} catch (Exception e) {
			System.out.println("already upgraded");
		}

		try {
			driver.findElement(By.xpath("//*[@id='layUpgradeOption']")).getText();
		} catch (Exception e) {
			System.out.println("no upgrade btn clicked");
		}
		Thread.sleep(5000);
		String upgradetext = driver.findElement(By.xpath("//*[@text='Upgrade Now']")).getText();
		// System.out.println("*" + upgradetext);
		Thread.sleep(5000);
		String upgradetext1 = driver.findElement(By.xpath("//*[@text='to send her mail directly']")).getText();
		Thread.sleep(5000);
		System.out.println("*" + upgradetext + upgradetext1);
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@text='Upgrade Now']")));
		Thread.sleep(5000);
		b.click(p.getBack_btn());
		Thread.sleep(5000);
		try {
			b.click(p.getNot_now_btn());
		} catch (Exception e) {
			System.out.println("no not now btn dispalyed");
		}
		// b.click(p.getNot_now_btn());

		Thread.sleep(5000);
		b.click(p.getMail_box());
		Thread.sleep(5000);
		b.click(p.getFilter());
		Thread.sleep(5000);
		b.click(p.getMail_box_sent());
		Thread.sleep(5000);
		String send_interest_id1 = p.getPrint_matri_id().getText();
		System.out.println(p.getPrint_matri_id().getText());

		if (send_interest_id.equals(send_interest_id1)) {

			System.out.println(" sent intrest Test Passed");

		} else {
			System.out.println("Check on Accepted Link");

		}
		Thread.sleep(5000);
		b.click(p.getBack_btn());
		Thread.sleep(5000);
		b.click(p.getMenu_btn());
		// To Scroll
		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='appversion']")).click();
		Thread.sleep(5000);
		String appversion = driver.findElement(By.xpath("//*[@id='appversion']")).getText();
		System.out.println("The tested " + appversion);

		/*
		 * b.click(p.getMail_box_sent_accepted()); String send_interest_acceptId =
		 * p.getPrint_matri_id().getText();
		 * 
		 * if (send_interest_id.equals(send_interest_acceptId)) {
		 * System.out.println("Test Passed");
		 * 
		 * } else { System.out.println("Check on Declined link Link"); }
		 * 
		 */

	}
}