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
import POM.Login_Pom;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.logging.Level;

public class swipe extends BaseTest {
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
		dc.setCapability(MobileCapabilityType.UDID, "42006893e04c1457");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.community.matrimony");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.domaininstance.ui.activities.Splash");
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
		driver.setLogLevel(Level.INFO);

	}

	@Test
	public void testUntitled() throws InterruptedException {

		Login_Pom l = new Login_Pom(driver);
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
			BaseTest.click(l.getQuickrespnse_clse_btn());
			System.out.println("quick Response page Handled......");

		} catch (Exception e) {
			System.out.println("no quick response page displayed.....");
		}

		Thread.sleep(2000);
		driver.swipe(0, 1200, 0, 0, 1000);
		Thread.sleep(2000);

		Dimension size = driver.manage().window().getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		System.out.println(width);
		int y = (int) (height * 0.35);
		int startx = (int) (width * 0.75);
		int endx = (int) (width * 0.25);
		Thread.sleep(5000); 

		try {
			if (driver.findElement(By.xpath(
					"//*[@id='dashTitle' and (./preceding-sibling::* | ./following-sibling::*)[@height>0 and ./*[@id='mCommunicationLay']]]"))
					.isDisplayed()) {
				System.out.println(driver.findElement(By.xpath(
						"//*[@id='dashTitle' and (./preceding-sibling::* | ./following-sibling::*)[@height>0 and ./*[@id='mCommunicationLay']]]"))
						.getText());

				for (int i = 1; i <= 8; i++) {
					driver.swipe(startx, y, endx, y, 4000);
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@text='VIEW ALL']")).click();

		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@text='GOT IT']")).click();
		} catch (Exception e) {
			System.out.println("help button disabled");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();

		System.out.println("landed in dashboard section..........");

		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);

		try {

			if (driver.findElement(By.xpath(
					"//*[@id='dashTitle' and @height>0 and (./preceding-sibling::* | ./following-sibling::*)[./*[./*[@id='card_view' and ./*[./*[./*[./*[@height>0]]]]]]]]"))
					.isDisplayed()) {
				System.out.println(driver.findElement(By.xpath(
						"//*[@id='dashTitle' and @height>0 and (./preceding-sibling::* | ./following-sibling::*)[./*[./*[@id='card_view' and ./*[./*[./*[./*[@height>0]]]]]]]]"))
						.getText());

				for (int i = 1; i <= 8; i++) {
					driver.swipe(startx, y, endx, y, 4000);
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@text='VIEW ALL']")).click();

		Thread.sleep(3000);
		Dimension size1 = driver.manage().window().getSize();
		int height1 = size.getHeight();
		int width1 = size.getWidth();
		System.out.println(width1);
		int y1 = (int) (height1 * 0.15);
		int startx1 = (int) (width1 * 0.75);
		int endx1 = (int) (width1 * 0.35);
		Thread.sleep(3000);
		for (int k = 0; k <= 6; k++) {
			driver.swipe(endx1, y1, startx1, y1, 4000);
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@text='DASHBOARD']")).click();
		Thread.sleep(3000);
		driver.swipe(0, 1200, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 600, 0, 0, 1000);
		// driver.swipe(0, 800, 0, 0, 1000);
		// driver.swipe(0, 800, 0, 0, 1000);
		Thread.sleep(2000);
		try {
			Thread.sleep(2000);
			if (driver.findElement(By.xpath("//*[contains(text(),'awaiting')]")).isDisplayed()) {
				System.out.println(driver.findElement(By.xpath("//*[contains(text(),'awaiting')]")).getText());

				for (int m = 1; m <= 8; m++) {
					driver.swipe(startx, y, endx, y, 4000);
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@text='VIEW ALL']")).click();

		Thread.sleep(3000);
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@text='GOT IT']")).click();
		} catch (Exception e) {
			System.out.println("help button disabled");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();

		System.out.println("landed in dashboard section..........");
		Thread.sleep(3000);
		driver.swipe(0, 1200, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);

		Thread.sleep(2000);
		try {
			Thread.sleep(2000);
			if (driver.findElement(By.xpath("//*[contains(text(),'respond')]")).isDisplayed()) {
				System.out.println(driver.findElement(By.xpath("//*[contains(text(),'respond')]")).getText());
				Thread.sleep(2000);
				Dimension size2 = driver.manage().window().getSize();
				int height2 = size.getHeight();
				int width2 = size.getWidth();
				System.out.println(width2);
				int y2 = (int) (height2 * 0.45);
				int startx2 = (int) (width2 * 0.75);
				int endx2 = (int) (width2 * 0.25);
				Thread.sleep(5000);
				for (int r = 1; r <= 8; r++) {
					driver.swipe(startx2, y2, endx2, y2, 4000);
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@text='VIEW ALL']")).click();

		Thread.sleep(3000);
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@text='GOT IT']")).click();
		} catch (Exception e) {
			System.out.println("help button disabled");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();

		System.out.println("landed in dashboard section..........");

	}
}
