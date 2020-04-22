package TestScripts;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.Delete_POM;
import POM.Login_Pom;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class Branch_locator extends BaseTest {
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

	@BeforeMethod
	public void testUntitled() throws InterruptedException {

		Login_Pom l = new Login_Pom(driver);
		Delete_POM d = new Delete_POM(driver);
		try {
			Thread.sleep(2000);
			BaseTest.click(l.getHome_Login_btn());
			Thread.sleep(2000);
			BaseTest.click(l.getEnter_Matrid());
			Thread.sleep(2000);
			BaseTest.typeData(l.getEnter_Matrid(), "KMC333738");
			Thread.sleep(2000);
			BaseTest.typeData(l.getEnter_passwrd(), "cbstest");
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
			BaseTest.click(driver.findElement(By.xpath("//*[@id='skip']")));
			System.out.println("PAyment intermediate page HAndled");

		} catch (Exception e) {
			System.out.println("no PAyment intermediate page HAndled.....");
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

		// driver.swipe(0, 1200, 0, 0, 1000);
		driver.scrollToExact("24x7 Help Center").click();
		Thread.sleep(2000);

		BaseTest.click(d.getBranch_locator());
		Thread.sleep(2000);

	}

	@Test
	public void enable_Location() throws InterruptedException {
		Delete_POM d = new Delete_POM(driver);
		Thread.sleep(2000);

		try {
			BaseTest.click(d.getLocation_allow());
			System.out.println("location allow btn handled");
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			Thread.sleep(2000);
			BaseTest.click(d.getGoogle_location_service());
			System.out.println("location service  enabled");

		} catch (Exception e) {
			System.out.println("location service not enabled");
		}

		Thread.sleep(5000);
		driver.resetApp();
		/*
		 * Dimension dimensions = driver.manage().window().getSize(); Double
		 * screenHeightStart = dimensions.getHeight() * 0.10; int scrollStart =
		 * screenHeightStart.intValue(); System.out.println("s=" + scrollStart); Double
		 * screenHeightEnd = dimensions.getHeight() * 0.2; int scrollEnd =
		 * screenHeightEnd.intValue(); for (int i = 0; i < dimensions.getHeight(); i++)
		 * { driver.swipe(0, scrollStart, 0, scrollEnd, 2000); }
		 */
	}

	@Test
	public void disable_Location() throws InterruptedException {
		Delete_POM d = new Delete_POM(driver);
		Thread.sleep(2000);
		try {
			BaseTest.click(d.getLocation_allow());
			System.out.println("location allow btn handled");
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Thread.sleep(2000);
			BaseTest.click(d.getLocation_no_thanks_btn());
			System.out.println("location allow service not enabled");
		} catch (Exception e) {
			System.out.println("location allow service not enabled");
		}

		Thread.sleep(2000);

	}

	@AfterTest
	public void tearDown() {

		driver.quit();



	}
}