package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.Delete_POM;
import POM.Login_Pom;
import POM.Safe_female_photo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Safe_matrimony extends BaseTest {

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
		String text = "You can protect your photo using privacy settings & share it only with the members you like";
		Login_Pom l = new Login_Pom(driver);
		Delete_POM d = new Delete_POM(driver);
		Safe_female_photo s = new Safe_female_photo(driver);

		try {
			Thread.sleep(2000);
			BaseTest.click(l.getHome_Login_btn());
			Thread.sleep(2000);
			BaseTest.click(l.getEnter_Matrid());
			Thread.sleep(2000);
			BaseTest.typeData(l.getEnter_Matrid(), "rdy485145");
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

		// driver.scrollToExact("Safe matrimony").click();
		// Thread.sleep(2000);

		BaseTest.click(s.getPhoto_img());

		Thread.sleep(2000);

		
		Thread.sleep(2000);

		String page = driver.findElement(By.xpath("//*[@id='female_secure']")).getText();
		System.out.println(page);

		Thread.sleep(2000);
		try {
			if (text.equals(page)) {
				System.out.println("both the text are equal...");

			} else {
				System.out.println("text is not equal........");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		//Assert.assertEquals(page, text, "two text doesnt match.....");

		try {
			driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		} catch (Exception e) {
			System.out.println("no back btn present");
		}

		try {
			Thread.sleep(2000);

			driver.scrollToExact("Edit Profile").click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id='ivNoPhoto']")).click();
			Thread.sleep(2000);

			String page1 = driver.findElement(By.xpath("//*[@id='female_secure']")).getText();
			System.out.println(page1);

			if (text.equals(page1)) {
				System.out.println("both the text are equal...");

			} else {
				System.out.println("text is not equal........");
			}

		} catch (Exception e) {
			System.out.println("no edit profile btn clicked");
		}

		try {
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		} catch (Exception e) {
			System.out.println("no back btn present");
		}
		try {
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		} catch (Exception e) {
			System.out.println("no back btn present");
		}
		Thread.sleep(2000);
		driver.swipe(0, 1000, 0, 0, 2000);
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//*[@id='appversion']")).getText());
		Thread.sleep(2000);
        driver.scrollToExact("Account Settings").click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id='accountsLayout']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='logoutLayout']")).click();

		
		
		
		
	}

}
