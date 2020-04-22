package TestScripts;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.Delete_POM;
import POM.Login_Pom;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class quick_tour extends BaseTest {
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
		driver.scrollToExact("More").click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@text='Quick Tour']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@text='Skip']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@text='Quick Tour']")).click();
		Thread.sleep(2000);
		for (int i = 0; i <= 3; i++) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@text='Next']")).click();
		}
		Thread.sleep(2000);
		for (int i = 0; i <= 3; i++) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@text='Previous']")).click();
		}

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();

		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//*[@id='appversion']")).getText());

		Thread.sleep(2000);

		driver.scrollToExact("Account Settings").click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='logoutLayout']")).click();

	}
}
