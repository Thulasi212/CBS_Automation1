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

public class Safe_matri extends BaseTest {

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
		Safe_female_photo s = new Safe_female_photo(driver);

		try {
			Thread.sleep(2000);
			BaseTest.click(l.getHome_Login_btn());
			Thread.sleep(2000);
			BaseTest.click(l.getEnter_Matrid());
			Thread.sleep(2000);
			BaseTest.typeData(l.getEnter_Matrid(), "kmc333738");
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
			BaseTest.click(l.getQuickrespnse_clse_btn());
			System.out.println("quick Response page Handled......");

		} catch (Exception e) {
			System.out.println("no quick response page displayed.....");
		}

		Thread.sleep(2000);
		BaseTest.click(d.getProfile_btn_click());
		Thread.sleep(2000);

		driver.scrollToExact("Safe Matrimony").click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//*[@id='topnav-login-bg']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@text='HOW TO IDENTIFY FRAUDSTERS']")).click();
		Thread.sleep(2000);
		driver.scrollToExact("Report a Fraud");
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@id='name']]"))
				.sendKeys("jyothi......adougoiwuyeiuiikbnkdh");
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@id='email']]"))
				.sendKeys("faurei@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='mobile-no']")).sendKeys("faurei@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@id='details']]"))
				.sendKeys("faurei@gmail.com");
		Thread.sleep(2000);

		String captcha = driver.findElement(By.xpath("//*[@id='captchaimg']")).getText();
		System.out.println(captcha);
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@id='details']]"))
				.sendKeys(captcha);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='reg-submit']")).click();

		try {
			driver.findElement(By.xpath("//*[@id='topnav-login-bg']")).click();

			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@text='REPORT ABUSE']")).click();
			Thread.sleep(2000);
			driver.scrollToExact("Report a Fraud");
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@id='name']]"))
					.sendKeys("jyothi......adougoiwuyeiuiikbnkdh");
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@id='email']]"))
					.sendKeys("faurei@gmail.com");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='mobile-no']")).sendKeys("faurei@gmail.com");
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@id='details']]"))
					.sendKeys("faurei@gmail.com");
			Thread.sleep(2000);

			String captcha1 = driver.findElement(By.xpath("//*[@id='captchaimg']")).getText();
			System.out.println(captcha);
			Thread.sleep(2000);

			driver.findElement(By.xpath(
					"//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@id='details']]"))
					.sendKeys(captcha);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id='reg-submit']")).click();

		} catch (Exception e) {
			System.out.println("Report Abuse not loaded completely");
		}

		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='topnav-login-bg']")).click();

			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@text='CONTACT POLICE']")).click();
			Thread.sleep(2000);
			driver.scrollToExact("Report a Fraud");
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@id='name']]"))
					.sendKeys("jyothi......adougoiwuyeiuiikbnkdh");
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@id='email']]"))
					.sendKeys("faurei@gmail.com");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='mobile-no']")).sendKeys("faurei@gmail.com");
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@id='details']]"))
					.sendKeys("faurei@gmail.com");
			Thread.sleep(2000);

			String captcha1 = driver.findElement(By.xpath("//*[@id='captchaimg']")).getText();
			System.out.println(captcha);
			Thread.sleep(2000);

			driver.findElement(By.xpath(
					"//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@id='details']]"))
					.sendKeys(captcha);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id='reg-submit']")).click();
		} catch (Exception e) {
			System.out.println("contact police not loaded completely ");
		}

		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='topnav-login-bg']")).click();

			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@text='GRIEVANCE']")).click();
			Thread.sleep(2000);
			driver.scrollToExact("Report a Fraud");
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@id='name']]"))
					.sendKeys("jyothi......adougoiwuyeiuiikbnkdh");
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@id='email']]"))
					.sendKeys("faurei@gmail.com");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='mobile-no']")).sendKeys("faurei@gmail.com");
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@id='details']]"))
					.sendKeys("faurei@gmail.com");
			Thread.sleep(2000);

			String captcha1 = driver.findElement(By.xpath("//*[@id='captchaimg']")).getText();
			System.out.println(captcha);
			Thread.sleep(2000);

			driver.findElement(By.xpath(
					"//*[@class='android.widget.EditText' and (./preceding-sibling::* | ./following-sibling::*)[@id='details']]"))
					.sendKeys(captcha);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id='reg-submit']")).click();
		} catch (Exception e) {
			System.out.println("Grievience  not loaded completely ");
		}
	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//*[@id='appversion']")).getText());

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='accountsLayout']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='logoutLayout']")).click();

		
		
		
		
		
		
		
		
		
		
		
	}

}
