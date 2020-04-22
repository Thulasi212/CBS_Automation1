package testscripts;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.opendaylight.yang.gen.v1.urn.opendaylight.intent.rev150122.intents.Intent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTestAgarwal;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

public class Photo_Upload extends BaseTestAgarwal {
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
		Thread.sleep(10000);
		try {
			if (p.getBack_btn().isDisplayed()) {
				b.click(p.getBack_btn());

			}

		} catch (Exception e) {
			System.out.println("no daily matches page displayed");
		}
		Thread.sleep(10000);
		try {
			if (p.getBack_btn().isDisplayed()) {
				b.click(p.getBack_btn());

			}

		} catch (Exception e) {
			System.out.println("no daily matches page displayed");
		}
		Thread.sleep(10000);
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

		Thread.sleep(5000);
		try {
			AndroidElement photo_skip = driver.findElement(By.xpath("//*[@id='doitlater']"));
			if (photo_skip.isDisplayed()) {
				photo_skip.click();
			}
		} catch (Exception e) {
			e.getMessage();
		}

		try {
			if (driver.findElement(By.xpath("//*[@text='ADD PHOTO']")).isDisplayed()) {

				b.click(driver.findElement(By.xpath("//*[@text='ADD PHOTO']")));
				Thread.sleep(5000);
				b.click(driver.findElement(By.xpath("//*[@text='ADD PHOTO']")));
				Thread.sleep(5000);
			}
			b.click(driver.findElement(By.xpath("//*[@text='Choose from Gallery']")));
			Thread.sleep(5000);
			b.click(driver.findElement(By.xpath(
					"//*[@id='icon' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='Gallery']]]")));
			Thread.sleep(5000);
			b.click(driver.findElement(By.xpath("(//*[@id='tabs']/*[./*[@id='indicator_text']])[1]")));
			Thread.sleep(5000);
			// b.click(driver.findElement(By.xpath("//*[@text='Recent']")));
			// Thread.sleep(5000);
			/*
			 * List<AndroidElement> photos =
			 * driver.findElements(By.xpath("// *[@id='micro_thumb']"));
			 * Thread.sleep(15000); for (int i = 0; i <= photos.size(); i++) {
			 * Thread.sleep(5000); int ps = photos.size(); System.out.println("photos size:"
			 * + ps);
			 */
			Thread.sleep(15000);
			// driver.findElement(By.xpath("// *[@id='micro_thumb']")).click();
			List<AndroidElement> links = driver
					.findElements(By.xpath("//*[@class='com.sec.samsung.gallery.glview.composeView.ThumbObject']"));

			// List<AndroidElement> links = driver.findElements(By.xpath("//
			// *[@id='micro_thumb']"));
			List<WebElement> visited = new ArrayList<WebElement>();
			WebElement random = links.get(new Random().nextInt(links.size()));
			String randomId = random.getText();
			System.out.println("No.of Photo's.. " + links.size());
			if (!visited.contains(random)) {
				random.click();
				// visited.add(random);
				// driver.navigate().back();
			}
			Thread.sleep(10000);
			b.click(p.getBack_btn());
			b.click(p.getMenu_btn());
			driver.swipe(0, 800, 0, 0, 1000);
			driver.swipe(0, 800, 0, 0, 1000);
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@id='appversion']")).click();
			Thread.sleep(5000);
			String appversion = driver.findElement(By.xpath("//*[@id='appversion']")).getText();
			System.out.println("The tested " + appversion);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='accountsLayout']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='logoutLayout']")).click();
			System.out.println("PHOTO UPLOAD SCENARIO PASSED FROM DASHBOARD");
		} catch (Exception e) {
			Thread.sleep(5000);
			b.click(p.getMenu_btn());
			Thread.sleep(5000);
			b.click(driver.findElement(By.xpath("//*[@id='selfImageView']")));
			Thread.sleep(15000);
			b.click(driver.findElement(By.xpath("//*[@text='ADD PHOTO']")));
			Thread.sleep(5000);
			b.click(driver.findElement(By.xpath("//*[@text='Choose from Gallery']")));
			Thread.sleep(5000);
			b.click(driver.findElement(By.xpath(
					"//*[@id='icon' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='Gallery']]]")));
			Thread.sleep(5000);
			b.click(driver.findElement(By.xpath("(//*[@id='tabs']/*[./*[@id='indicator_text']])[1]")));
			Thread.sleep(5000);
			// b.click(driver.findElement(By.xpath("//*[@text='Recent']")));
			// Thread.sleep(5000);
			/*
			 * List<AndroidElement> photos =
			 * driver.findElements(By.xpath("// *[@id='micro_thumb']"));
			 * Thread.sleep(15000); for (int i = 0; i <= photos.size(); i++) {
			 * Thread.sleep(5000); int ps = photos.size(); System.out.println("photos size:"
			 * + ps);
			 */
			Thread.sleep(15000);
			// driver.findElement(By.xpath("// *[@id='micro_thumb']")).click();
			List<AndroidElement> links = driver
					.findElements(By.xpath("//*[@class='com.sec.samsung.gallery.glview.composeView.ThumbObject']"));

			// sList<AndroidElement> links = driver.findElements(By.xpath("//
			// *[@id='micro_thumb']"));
			List<WebElement> visited = new ArrayList<WebElement>();
			WebElement random = links.get(new Random().nextInt(links.size()));
			String randomId = random.getText();
			System.out.println("No.of ID's.. " + links.size());
			if (!visited.contains(random)) {
				random.click();
				// visited.add(random);
				// driver.navigate().back();
			}
			Thread.sleep(10000);
			b.click(p.getBack_btn());
			Thread.sleep(5000);
			driver.swipe(0, 800, 0, 0, 1000);
			driver.swipe(0, 800, 0, 0, 1000);
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@id='appversion']")).click();
			Thread.sleep(5000);
			String appversion = driver.findElement(By.xpath("//*[@id='appversion']")).getText();
			System.out.println("The tested " + appversion);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='accountsLayout']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='logoutLayout']")).click();
			System.out.println("PHOTO UPLOAD SCENARIO PASSED FROM PROFILE MENU");
		}

		// b.click(driver.findElement(By.xpath(
		// "//*[@id='micro_thumb' and ./parent::*[@contentDescription='Photo taken on 9
		// January, 2019 18:49:34. Location: India, Tamil Nadu, Chennai, Adyar, LB
		// Road18115.']]")));

		// b.click(driver.findElement(By.xpath("//*[@text='ADD PHOTO']")));

		// *[@id='micro_thumb']

	}

	@AfterTest
	public void tearDown() {
		// driver.resetApp();
		driver.quit();
		reports.endTest(test);
		reports.flush();
		// driver.resetApp();
		// driver.quit();

		// test.log(LogStatus.PASS, "Application Closed Succesfull");
		// reports.endTest(test);

	}

}
