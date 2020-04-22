package TestScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.Search;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class SearchByID extends BaseTest {

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
		dc.setCapability(MobileCapabilityType.UDID, "21d9e22c");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.community.matrimony");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.domaininstance.ui.activities.Splash");
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
		driver.setLogLevel(Level.INFO);

	}

	@Test
	public void searchByIDTest() throws InterruptedException, AWTException {

		Search s = new Search(driver);

		Thread.sleep(5000);
		BaseTest.click(s.getChooseLogin());

		Thread.sleep(5000);
		BaseTest.click(s.getMatriId());

		Thread.sleep(5000);
		BaseTest.typeData(s.getMatriId(), BaseTest.readValueFromExcelSheet().get(1).get("UserName"));

		Thread.sleep(5000);
		BaseTest.click(s.getPassword());

		Thread.sleep(5000);
		BaseTest.typeData(s.getPassword(), BaseTest.readValueFromExcelSheet().get(1).get("PassWord"));

		Thread.sleep(5000);
		BaseTest.click(s.getIdLogin());

		Thread.sleep(10000);
		try {
			BaseTest.click(s.getQuick_Tour_Skip());
		} catch (Exception e) {
			System.out.println("The Tour Page Handled Successfully");
		}

		
		Thread.sleep(5000);
		try {
			AndroidElement photo_skip = driver.findElement(By.xpath("//*[@id='doitlater']"));
			if (photo_skip.isDisplayed()) {
				photo_skip.click();
			}
		} catch (Exception e) {
			System.out.println("There is no photo page to handle");
		}
		
		
		Thread.sleep(5000);
		try {
			BaseTest.click(s.getQuick_response_popup());
		} catch (Exception e) {
			System.out.println("The Quick Response page handled Successfully");
		}
		
		
		Thread.sleep(5000);
		try {
			BaseTest.click(s.getNotification_access_later());
		} catch (Exception e) {
			System.out.println("Notification handled");
		}

		try {
			Alert a = driver.switchTo().alert();
			a.dismiss();

		} catch (Exception e) {
			System.out.println("No alert To Handle");
		}

		Thread.sleep(5000);
		BaseTest.click(s.getSearch_btn());

		Thread.sleep(5000);
		List<AndroidElement> regular_search = driver.findElements(By.xpath("//*[@id='inc_filter']"));
		// (//*[@class='android.widget.RelativeLayout' and @height>0])[8]
		int size = regular_search.size();
		System.out.println("Regulare Search Size = " + size);

		for (int i = 0; i < regular_search.size(); i++) {
			Thread.sleep(5000);
			String ss = regular_search.get(i).getText();
			System.out.println("***" + ss);

		}

		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='editSearchById']")).sendKeys(String.valueOf("EZH714139"));
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='editSearchById']")).click();

		Robot r = new Robot();
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(5000);
		try {
			if (s.getShortlist_btn().isDisplayed()) {
				Thread.sleep(5000);
				BaseTest.click(s.getShortlist_btn());
				Thread.sleep(5000);
				if (s.getShortlist_sendinterest_btn().isDisplayed()) {
					Thread.sleep(5000);
					BaseTest.click(s.getShortlist_sendinterest_btn());
				}
			}
		} catch (Exception e) {
			System.out.println("The ID Was Already Shortlisted ");
		}

		
		Thread.sleep(5000);
		if (driver.findElement(By.xpath("//*[@text='UPGRADE NOW' and @width>0]")).isDisplayed()) {
			Thread.sleep(5000);
			BaseTest.click(driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")));
			Thread.sleep(5000);
			BaseTest.click(driver.findElement(By.xpath("//*[@text='NOT NOW']")));

		}

		else {
			System.out.println("The Package Was Upgraded");

		}
		

		Thread.sleep(5000);
		List<AndroidElement> searchby_ID = driver.findElements(By.xpath("//*[@text='Request']"));
		int sss = searchby_ID.size();
		System.out.println(sss);
		int searchid = (sss / 2) - 1;
		System.out.println(searchid);
		for (int i = 0; i < searchid; i++) {

			Thread.sleep(5000);
			driver.scrollToExact("Request").click();
			
			// BaseTest.click(driver.findElement(By.xpath("//*[@text='Request']")));

		}
		
		Thread.sleep(5000);
		try {
			Thread.sleep(5000);
			driver.scrollToExact("RELIGIOUS INFORMATION");
			Thread.sleep(5000);
			if (driver.findElement(By.xpath("//*[@text='REQUEST HOROSCOPE']")).isDisplayed()) {
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@text='REQUEST HOROSCOPE']")).click();
			} else {
				System.out.println("Request Was Already Sent");

			}
		} catch (Exception e) {
			System.out.println("Religious Information Was not Displayed");
		}

		
		Thread.sleep(5000);
		try {
			driver.scrollToExact("+ More Conversations");
		} catch (Exception e) {
			System.out.println("There is no Conversations");
		}
		Thread.sleep(5000);
		if (driver.findElement(By.xpath("//*[@text='+ More Conversations']")).isDisplayed()) {

			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@text='+ More Conversations']")).click();
		}
		
		
		Thread.sleep(5000);
		List<AndroidElement> conversation = driver.findElements(By.xpath("//*[@id='txt_req_comm_title']"));
		System.out.println(conversation.size());
		Thread.sleep(5000);
		for (AndroidElement conversation_details : conversation) {
			Thread.sleep(5000);
			System.out.println(conversation_details);

		}
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();

		Thread.sleep(5000);
		BaseTest.click(s.getMenu_btn());

		Thread.sleep(5000);
		driver.swipe(0, 1000, 0, 0, 1000);

		Thread.sleep(5000);
		BaseTest.click(s.getMenu_Account_settings());

		Thread.sleep(5000);
		BaseTest.click(s.getLogout());
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
