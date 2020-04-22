package testscripts;

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

public class Inbox_received_scenario_1 extends BaseTestAgarwal {
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
		Matches_Pom p1 = new Matches_Pom(driver);
		Edit_Profile_Pom p = new Edit_Profile_Pom(driver);
		BaseTestAgarwal b = new BaseTestAgarwal();
		Inbox_pom p2 = new Inbox_pom(driver);
		Thread.sleep(5000);
		// b.click(p.getMain_Login());
		try {
			driver.findElement(By.xpath("//*[@text='LOGIN']")).click();
		} catch (Exception e) {
			System.out.println("no login button");
		}
		try {
			b.click(p.getEnter_matri_Id1());
			b.typeData(p.getEnter_matri_Id1(), BaseTestAgarwal.readValueFromExcelSheet().get(1).get("Username"));
			Thread.sleep(5000);
			b.typeData(p.getEnter_password1(), BaseTestAgarwal.readValueFromExcelSheet().get(1).get("Password"));
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
		Thread.sleep(5000);
		b.click(p1.getMail_box());
		Thread.sleep(5000);
		// b.click(p1.getMail_box());
		// Thread.sleep(5000);
		b.click(p1.getFilter());
		Thread.sleep(5000);
		// Thread.sleep(5000);
		String send_interest_id = p1.getPrint_matri_id().getText();
		System.out.println(p1.getPrint_matri_id().getText());
		Thread.sleep(5000);
		try {
			Thread.sleep(5000);
			if (p2.getAccept_intrest_yes().isDisplayed())
				Thread.sleep(5000);
			b.click(p2.getAccept_intrest_yes());
			Thread.sleep(5000);
			b.click(p1.getPopup_close());
			Thread.sleep(5000);
			b.click(driver.findElement(By.xpath(
					"(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='mTabLayout']]/*[@class='android.support.v7.app.a$b'])[2]")));
			Thread.sleep(5000);
			String send_interest_id3 = p1.getPrint_matri_id().getText();
			Thread.sleep(5000);
			System.out.println(p1.getPrint_matri_id().getText());
			Thread.sleep(5000);
			if (send_interest_id.equals(send_interest_id3)) {
				System.out.println("Intrest accept scenario success");

			} else {
				System.out.println("Intrest accept scenario  failed");

			}
		} catch (Exception e) {
			System.out.println("no yes btn present");
		}

		// b.click(p2.getAccept_intrest_yes());
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='mTabLayout']]/*/*[@text and @class='android.widget.TextView' and @height>0])[1]"));
		} catch (Exception e) {
			System.out.println("already in pending section");
		}
		Thread.sleep(5000);
		try {
			Thread.sleep(5000);
			if (p2.getView_Reply().isDisplayed())
				Thread.sleep(5000);
			b.click(p2.getView_Reply());
			Thread.sleep(5000);
			b.typeData(p2.getMail_content(), "hi");
			Thread.sleep(5000);
			b.click(p2.getMessage_send());
			Thread.sleep(5000);
			b.click(p1.getPopup_close());
			Thread.sleep(5000);
			b.click(driver.findElement(By.xpath(
					"(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='mTabLayout']]/*[@class='android.support.v7.app.a$b'])[4]")));

		} catch (Exception e) {
			System.out.println("no view_reply btn present");
		}
		String send_interest_id1 = p1.getPrint_matri_id().getText();
		System.out.println(p1.getPrint_matri_id().getText());
		Thread.sleep(5000);
		if (send_interest_id.equals(send_interest_id1)) {
			System.out.println("message replied scenario verified");

		} else {
			System.out.println("replied scenario failed");
			Thread.sleep(5000);
			b.click(driver.findElement(By.xpath(
					"(//*[@class='android.widget.LinearLayout' and ./parent::*[@id='mTabLayout']]/*[@class='android.support.v7.app.a$b'])[1]")));
			Thread.sleep(5000);

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
