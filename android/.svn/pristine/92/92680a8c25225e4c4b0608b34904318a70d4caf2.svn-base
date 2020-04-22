package testscripts;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTestAgarwal;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class Who_VIewed_my_Profile {
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
		dc.setCapability(MobileCapabilityType.UDID, "16e455170205");
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
		Dimension size = driver.manage().window().getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		System.out.println(width);
		int y = (int) (height * 0.15);
		int startx = (int) (width * 0.75);
		int endx = (int) (width * 0.35);

		driver.swipe(startx, y, endx, y, 4000);
		driver.swipe(startx, y, endx, y, 4000);
		driver.swipe(startx, y, endx, y, 4000);
		driver.swipe(startx, y, endx, y, 4000);
		// ScrollTabs();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='VIEWED MY PROFILE']")).click();
		Thread.sleep(5000);

		// Thread.sleep(5000);
		List<AndroidElement> ID = driver.findElements(By.xpath("//*[@id='profileMatriId']"));
		for (int i = 0; i < ID.size(); i++) {
			driver.scrollTo("NIC");
			String ids = ID.get(i).getText();
			System.out.println("viewed my profile Id's are " + ids);
		}
		Thread.sleep(5000);
		String View_profile_1 = driver.findElement(By.xpath("//*[@id='profileMatriId']")).getText();

		System.out.println(View_profile_1);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='profileUsername']")).click();
		Thread.sleep(5000);
		String Id = driver.findElement(By.xpath("(//*[@class='android.widget.TextView'])[5]")).getText();
		System.out.println(Id);
		Thread.sleep(5000);
		if (View_profile_1.equals(Id)) {
			System.out.println("view Profile verified");

		} else {
			System.out.println("no profile verified");
		}

		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 2000);
		Thread.sleep(5000);
		try {
			List<AndroidElement> req1 = driver.findElements(By.xpath("//*[@text='Request']"));

			System.out.println(req1.size());

			int req2 = (req1.size() / 2) - 1;

			System.out.println(req2);

			for (int i = 0; i < req2; i++) {

				Thread.sleep(5000);

				driver.scrollToExact("Request").click();
				// Thread.sleep(5000);
				String req_msg = driver.findElement(By.xpath("//*[@text]")).getText();
				// Thread.sleep(5000);
				System.out.println(req_msg);
				// Thread.sleep(5000);
			}
		} catch (Exception e) {
			System.out.println("no request btn handled");
		}

		Thread.sleep(5000);
		try {
			AndroidElement do_u_like_popup = driver.findElement(By.xpath("//*[@id='send_yes_interest_btn']"));
			Thread.sleep(5000);
			if (do_u_like_popup.isDisplayed()) {
				do_u_like_popup.click();
				String text1 = driver.findElement(By.xpath("//*[@id='ei_message']")).getText();
				System.out.println(text1);
			}
		} catch (Exception e) {
			System.out.println("There is no  matches to send Interest");
		}
		Thread.sleep(5000);

		try {
			AndroidElement daily_matches_shortlist = driver.findElement(By.xpath("//*[@text='SHORTLIST']"));
			Thread.sleep(5000);
			if (daily_matches_shortlist.isDisplayed()) {
				daily_matches_shortlist.click();
				driver.findElement(By.xpath("//*[@text='SEND INTEREST']")).click();

				Thread.sleep(5000);
				b.click(p.getBack_btn());
				Thread.sleep(5000);
				b.click(p.getNot_now_btn());
			}
		} catch (Exception e) {

		}

		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//*[@id='layUpgradeOption']")).getText();
		} catch (Exception e) {
			System.out.println("no option displayed");
		}
		Thread.sleep(5000);
		b.click(p.getBack_btn());
		Thread.sleep(5000);
		try {
			Thread.sleep(5000);

			if (driver.findElement(By.xpath("(//*[@id='recyclerview']/*/*/*/*/*/*[@id='send_interestButton'])[1]"))
					.isDisplayed()) {

				Thread.sleep(5000);
				driver.findElement(By.xpath("(//*[@id='recyclerview']/*/*/*/*/*/*[@id='send_interestButton'])[1]"))
						.click();
				Thread.sleep(5000);
				b.click(p.getBack_btn());
			}

		} catch (Exception e) {
			System.out.println("no intrest button displayed");
		}
		try {
			if (driver.findElement(By.xpath("//*[@id='shorlist_or_deleteButton']")).isDisplayed()) {

				driver.findElement(By.xpath("//*[@id='shorlist_or_deleteButton']")).click();
				Thread.sleep(5000);
			}

		} catch (Exception e) {
			System.out.println("no upgrade page verified");
		}
		try {
			Thread.sleep(5000);
			b.click(p.getBack_btn());
			System.out.println("landed and back to upgrade page");

		} catch (Exception e) {
			System.out.println("back btn not handled");
		}

		String upgradetext = driver.findElement(By.xpath("//*[@text='Upgrade Now']")).getText();
		// System.out.println("*" + upgradetext);
		Thread.sleep(5000);
		String upgradetext1 = driver.findElement(By.xpath("(//*[@id='recyclerview']/*/*/*/*/*[@id='tvUpgradeTo'])[1]"))
				.getText();
		Thread.sleep(5000);
		System.out.println("* " + upgradetext + upgradetext1);
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

	}
}