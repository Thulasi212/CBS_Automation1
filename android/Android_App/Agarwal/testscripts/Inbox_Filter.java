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
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

public class Inbox_Filter extends BaseTestAgarwal {
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

		Edit_Profile_Pom p1 = new Edit_Profile_Pom(driver);
		Matches_Pom p = new Matches_Pom(driver);
		BaseTestAgarwal b = new BaseTestAgarwal();
		Thread.sleep(5000);
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
			Thread.sleep(10000);
		}
		Thread.sleep(5000);
		try {
			if (p.getBack_btn().isDisplayed()) {
				b.click(p.getBack_btn());

			}

		} catch (Exception e) {
			System.out.println("no daily matches page displayed");
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

		b.click(p.getMail_box());
		Thread.sleep(5000);
		// b.click(p1.getMail_box());
		// Thread.sleep(5000);
		b.click(p.getFilter());
		Thread.sleep(5000);
		b.click(p.getMail_filter());
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='reset_filter']")).click();
		Thread.sleep(5000);
		List<AndroidElement> receieved_filter = driver
				.findElements(By.xpath("//*[@class='android.widget.CheckedTextView']"));
		for (int i = 0; i <= receieved_filter.size(); i++) {
			Thread.sleep(5000);
			receieved_filter.get(new Random().nextInt(receieved_filter.size())).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='btnApplyFilter']")).click();
			Thread.sleep(5000);
			try {
				List<AndroidElement> ID = driver.findElements(By.xpath("//*[@id='profileMatriId']"));

				for (int j = 0; j < ID.size(); j++) {
					Thread.sleep(5000);
					String ids = ID.get(j).getText();
					System.out.println("matri_Id's are " + ids);
				}
			} catch (Exception e) {
				System.out.println("no data is present");
			}

			Thread.sleep(5000);
			b.click(p.getMail_filter());
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='reset_filter']")).click();
			i++;
		}
		Thread.sleep(5000);
		b.click(p.getBack_btn());
		Thread.sleep(5000);
		b.click(p.getMail_box_sent());
		Thread.sleep(5000);
		b.click(p.getMail_filter());

		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='reset_filter']")).click();
		Thread.sleep(5000);
		List<AndroidElement> sent_filter = driver
				.findElements(By.xpath("//*[@class='android.widget.CheckedTextView']"));
		for (int k = 0; k <= sent_filter.size(); k++) {
			Thread.sleep(5000);
			receieved_filter.get(new Random().nextInt(sent_filter.size())).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='btnApplyFilter']")).click();
			Thread.sleep(5000);
			try {
				if (p.getMatriId_2().isDisplayed()) {
					List<AndroidElement> ID = driver.findElements(By.xpath("//*[@id='profileMatriId']"));

					for (int l = 0; l <= ID.size(); l++) {
						Thread.sleep(5000);
						String ids = ID.get(l).getText();
						System.out.println("matri_Id's are " + ids);
					}
				}
			} catch (Exception e) {
				System.out.println("no data is present");
			}
			Thread.sleep(5000);
			b.click(p.getMail_filter());
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='reset_filter']")).click();
			k++;

		}
		Thread.sleep(5000);
		System.out.println("Inbox filter for sent And received completed");
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
