package testscripts;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTestAgarwal;


import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class Payment_package extends BaseTestAgarwal {
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
Edit_Profile_Pom p1 =new Edit_Profile_Pom(driver);
		Payment_POM pm = new Payment_POM(driver);
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
			System.out.println("no skip button displayed");
		}

		try {
			WebElement popup = driver.findElement(By.xpath("//*[@id='popup_close_btn']"));
			if (popup.isDisplayed()) {
				popup.click();
			}
		} catch (Exception e) {
			System.out.println("no popup button displayed");
		}

		Thread.sleep(5000);
		try {
			AndroidElement photo_skip = driver.findElement(By.xpath("//*[@id='doitlater']"));
			if (photo_skip.isDisplayed()) {
				photo_skip.click();
			}

		} catch (Exception e) {
			System.out.println("no do it later button dispalyed");
		}
		System.out.println("login and landed in dashboard");

	}

	@Test

	public void testUntitled1() throws InterruptedException {

		Payment_POM pm = new Payment_POM(driver);
		Matches_Pom p = new Matches_Pom(driver);
		BaseTestAgarwal b = new BaseTestAgarwal();
		Thread.sleep(5000); //
		Thread.sleep(2000);
		b.click(pm.getMenu_btn());

		Thread.sleep(3000);
		driver.swipe(0, 800, 0, 0, 2000);
		Thread.sleep(3000);
		String offer = pm.getSpl_offer().getText();
		Thread.sleep(3000);
		System.out.println("payment offer" + ":" + offer);
		Thread.sleep(3000);
		b.click(pm.getSpl_offer());
		Thread.sleep(3000);
		System.out.println("landed on upgrade page");
		Thread.sleep(3000);
		String offer1 = pm.getAvailable_offer_upgrade_page().getText();
		Thread.sleep(3000);
		System.out.println("payment offer" + ":" + offer1);
		Thread.sleep(3000);
		// Assert.assertEquals(offer, offer1);

		// System.out.println("offers are validated");

		Thread.sleep(3000);

		b.click(pm.getGold_3mnth());
		Thread.sleep(3000);
		b.click(pm.getPayment_creditcard());
		Thread.sleep(3000);
		b.typeData(pm.getCard_number(), BaseTestAgarwal.readValueFromExcelSheet().get(1).get("cardnumber"));
		Thread.sleep(3000);
		System.out.println("enter card details");
		Thread.sleep(3000);
		b.click(pm.getExpiry_month());
		Thread.sleep(3000);
		b.click(pm.getMonth_value());
		Thread.sleep(3000);
		b.click(pm.getEnter_expiry_month_year());
		// Thread.sleep(3000);
		// b.typeData(pm.getEnter_expiry_month_year(),
		// BaseTestBrahmin.readValueFromExcelSheet().get(1).get("expiryyear"));
		// Thread.sleep(3000);
		// b.click(pm.getEnter_expiry_month_year());

		try {
			Thread.sleep(3000);
			b.click(pm.getPop_up_close());
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(3000);

		b.typeData(pm.getEnter_cvv(), "123");
		Thread.sleep(3000);
		try {
			// b.click(pm.getPop_up_close());
			driver.findElement(By.xpath("//*[@id='popclose']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(3000);
		b.click(pm.getPay_btn());
		Thread.sleep(3000);

		try {
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
			b.click(pm.getPop_up_close());
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(10000);
		System.out.println("payment in progress");
		Thread.sleep(10000);
		b.click(pm.getNavigate_back_btn());
		Thread.sleep(3000);
		b.click(pm.getCancel_yes_btn());
		Thread.sleep(3000);
		b.click(pm.getNavigate_back_btn());
		Thread.sleep(3000);
		b.click(pm.getNavigate_back_btn());
		Thread.sleep(3000);
		try {

			b.click(pm.getNOt_now_btn());
		} catch (Exception e) {
			System.out.println("not now btn not present");
		}
		System.out.println("negative payment success for gold 3 month pack");
		Thread.sleep(3000);
		b.click(pm.getAccount_settings());
		Thread.sleep(3000);
		b.click(pm.getLogout_btn());

	}

	@Test
	public void testUntitled2() throws InterruptedException {

		Payment_POM pm = new Payment_POM(driver);
		Matches_Pom p = new Matches_Pom(driver);
		BaseTestAgarwal b = new BaseTestAgarwal();
		Thread.sleep(5000);
		b.click(pm.getMenu_btn());
		Thread.sleep(3000);
		b.click(pm.getProfile_upgrade());
		String offer1 = pm.getAvailable_offer_upgrade_page().getText();
		Thread.sleep(3000);
		System.out.println("payment offer" + ":" + offer1);
		Thread.sleep(3000);

		b.click(pm.getGold_3mnth());
		Thread.sleep(3000);
		b.click(pm.getPayment_creditcard());
		Thread.sleep(3000);
		b.typeData(pm.getCard_number(), BaseTestAgarwal.readValueFromExcelSheet().get(1).get("cardnumber"));
		Thread.sleep(3000);
		System.out.println("enter card details");
		Thread.sleep(3000);
		b.click(pm.getExpiry_month());
		Thread.sleep(3000);
		b.click(pm.getMonth_value());
		Thread.sleep(3000);
		// b.click(pm.getEnter_expiry_month_year());
		Thread.sleep(3000);
		// b.typeData(pm.getEnter_expiry_month_year(),
		// BaseTestBrahmin.readValueFromExcelSheet().get(1).get("expiryyear"));
		// Thread.sleep(3000);
		b.click(pm.getEnter_expiry_month_year());
		Thread.sleep(3000);
		try {
			b.click(pm.getPop_up_close());

			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(3000);

		b.typeData(pm.getEnter_cvv(), "123");
		Thread.sleep(3000);

		Thread.sleep(2000);
		try {
			b.click(pm.getPop_up_close());
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(3000);
		b.click(pm.getPay_btn());
		Thread.sleep(3000);

		try {
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
			b.click(pm.getPop_up_close());

		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(10000);
		System.out.println("payment in progress");
		Thread.sleep(10000);
		b.click(pm.getNavigate_back_btn());
		Thread.sleep(3000);
		b.click(pm.getCancel_yes_btn());
		Thread.sleep(3000);
		b.click(pm.getNavigate_back_btn());
		Thread.sleep(3000);
		System.out.println("negative payment success for Gold 3 month pack");
//************diamond 3 month pack********************//
		b.click(pm.getDiamond_3_mnth_pack());
		Thread.sleep(3000);

		b.click(pm.getGold_3mnth());
		Thread.sleep(3000);
		b.click(pm.getPayment_creditcard());
		Thread.sleep(3000);
		b.typeData(pm.getCard_number(), BaseTestAgarwal.readValueFromExcelSheet().get(1).get("cardnumber"));
		Thread.sleep(3000);
		System.out.println("enter card details");
		Thread.sleep(3000);
		b.click(pm.getExpiry_month());
		Thread.sleep(3000);
		b.click(pm.getMonth_value());
		Thread.sleep(3000);
		// b.click(pm.getEnter_expiry_month_year());
		Thread.sleep(3000);
		// b.typeData(pm.getEnter_expiry_month_year(),
		// BaseTestBrahmin.readValueFromExcelSheet().get(1).get("expiryyear"));
		// Thread.sleep(3000);
		b.click(pm.getEnter_expiry_month_year());
		Thread.sleep(3000);
		try {
			// b.click(pm.getPop_up_close());

			driver.findElement(By.xpath("//*[@id='popclose']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(3000);

		b.typeData(pm.getEnter_cvv(), "123");
		Thread.sleep(3000);

		Thread.sleep(2000);
		try {
			b.click(pm.getPop_up_close());
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(3000);
		b.click(pm.getPay_btn());
		Thread.sleep(3000);

		try {
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
			b.click(pm.getPop_up_close());

		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(10000);
		System.out.println("payment in progress");
		Thread.sleep(10000);
		b.click(pm.getNavigate_back_btn());
		Thread.sleep(3000);
		b.click(pm.getCancel_yes_btn());
		Thread.sleep(3000);
		b.click(pm.getNavigate_back_btn());
		Thread.sleep(3000);

		/*
		 * b.click(pm.getNavigate_back_btn()); Thread.sleep(3000);
		 */

		try {

			b.click(pm.getNOt_now_btn());
		} catch (Exception e) {
			System.out.println("not now btn not present");
		}
		System.out.println("negative payment success for diamond 3 month pack");
		try {
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
			b.click(pm.getPop_up_close());

		} catch (Exception e) {
			e.getMessage();
		}
//*******************platinum 3 month pack********************************//
		b.click(pm.getPlatinum_3_month_pack());

		b.click(pm.getGold_3mnth());
		Thread.sleep(3000);
		b.click(pm.getPayment_creditcard());
		Thread.sleep(3000);
		b.typeData(pm.getCard_number(), BaseTestAgarwal.readValueFromExcelSheet().get(1).get("cardnumber"));
		Thread.sleep(3000);
		System.out.println("enter card details");
		Thread.sleep(3000);
		b.click(pm.getExpiry_month());
		Thread.sleep(3000);
		b.click(pm.getMonth_value());
		Thread.sleep(3000);
		// b.click(pm.getEnter_expiry_month_year());
		Thread.sleep(3000);
		// b.typeData(pm.getEnter_expiry_month_year(),
		// BaseTestBrahmin.readValueFromExcelSheet().get(1).get("expiryyear"));
		// Thread.sleep(3000);
		b.click(pm.getEnter_expiry_month_year());
		Thread.sleep(3000);
		try {
			b.click(pm.getPop_up_close());

			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(3000);

		b.typeData(pm.getEnter_cvv(), "123");
		Thread.sleep(3000);

		Thread.sleep(2000);
		try {
			b.click(pm.getPop_up_close());
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(3000);
		b.click(pm.getPay_btn());
		Thread.sleep(3000);

		try {
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
			b.click(pm.getPop_up_close());

		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(10000);
		System.out.println("payment in progress");
		Thread.sleep(10000);
		b.click(pm.getNavigate_back_btn());
		Thread.sleep(3000);
		b.click(pm.getCancel_yes_btn());
		Thread.sleep(3000);
		b.click(pm.getNavigate_back_btn());
		Thread.sleep(3000);

		/*
		 * b.click(pm.getNavigate_back_btn()); Thread.sleep(3000);
		 */

		try {

			b.click(pm.getNOt_now_btn());
		} catch (Exception e) {
			System.out.println("not now btn not present");
		}
		System.out.println("negative payment success for platinum 3 month pack");
		try {
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
			b.click(pm.getPop_up_close());

		} catch (Exception e) {
			e.getMessage();
		}

		Thread.sleep(3000);
		b.click(pm.getAccount_settings());
		Thread.sleep(3000);
		b.click(pm.getLogout_btn());

	}

	@Test
	public void testUntitled3() throws InterruptedException {

		Payment_POM pm = new Payment_POM(driver);
		Matches_Pom p = new Matches_Pom(driver);
		BaseTestAgarwal b = new BaseTestAgarwal();
		Thread.sleep(5000);
		b.click(pm.getMenu_btn());
		Thread.sleep(3000);
		b.click(pm.getProfile_upgrade());
		Thread.sleep(3000);
		String offer1 = pm.getAvailable_offer_upgrade_page().getText();
		Thread.sleep(3000);
		System.out.println("payment offer" + ":" + offer1);
		Thread.sleep(3000);

		b.click(pm.getSix_month_pack());
		Thread.sleep(3000);
		b.click(pm.getGold_3mnth());
		Thread.sleep(3000);
		b.click(pm.getPayment_creditcard());
		Thread.sleep(3000);
		b.typeData(pm.getCard_number(), BaseTestAgarwal.readValueFromExcelSheet().get(1).get("cardnumber"));
		Thread.sleep(3000);
		System.out.println("enter card details");
		Thread.sleep(3000);
		b.click(pm.getExpiry_month());
		Thread.sleep(3000);
		b.click(pm.getMonth_value());
		Thread.sleep(3000);
// b.click(pm.getEnter_expiry_month_year());
		Thread.sleep(3000);
// b.typeData(pm.getEnter_expiry_month_year(),
// BaseTestBrahmin.readValueFromExcelSheet().get(1).get("expiryyear"));
// Thread.sleep(3000);
		b.click(pm.getEnter_expiry_month_year());
		Thread.sleep(3000);
		try {
			b.click(pm.getPop_up_close());

			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(3000);

		b.typeData(pm.getEnter_cvv(), "123");
		Thread.sleep(3000);

		Thread.sleep(2000);
		try {
			b.click(pm.getPop_up_close());
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(3000);
		b.click(pm.getPay_btn());
		Thread.sleep(3000);

		try {
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
			b.click(pm.getPop_up_close());

		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(10000);
		System.out.println("payment in progress");
		Thread.sleep(10000);
		b.click(pm.getNavigate_back_btn());
		Thread.sleep(3000);
		b.click(pm.getCancel_yes_btn());
		Thread.sleep(3000);
		b.click(pm.getNavigate_back_btn());
		Thread.sleep(3000);

		/*
		 * b.click(pm.getNavigate_back_btn()); Thread.sleep(3000);
		 */

		try {

			b.click(pm.getNOt_now_btn());
		} catch (Exception e) {
			System.out.println("not now btn not present");
		}
		System.out.println("negative payment for  Gold 6 month pack is success");
		try {
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
			b.click(pm.getPop_up_close());

		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(3000);

		b.click(pm.getSix_month_pack());
		Thread.sleep(3000);

		b.click(pm.getSix_month_pack());
		b.click(pm.getDiamond_3_mnth_pack());
		Thread.sleep(3000);

		b.click(pm.getGold_3mnth());
		Thread.sleep(3000);
		b.click(pm.getPayment_creditcard());
		Thread.sleep(3000);
		b.typeData(pm.getCard_number(), BaseTestAgarwal.readValueFromExcelSheet().get(1).get("cardnumber"));
		Thread.sleep(3000);
		System.out.println("enter card details");
		Thread.sleep(3000);
		b.click(pm.getExpiry_month());
		Thread.sleep(3000);
		b.click(pm.getMonth_value());
		Thread.sleep(3000);
		// b.click(pm.getEnter_expiry_month_year());
		Thread.sleep(3000);
		// b.typeData(pm.getEnter_expiry_month_year(),
		// BaseTestBrahmin.readValueFromExcelSheet().get(1).get("expiryyear"));
		// Thread.sleep(3000);
		b.click(pm.getEnter_expiry_month_year());
		Thread.sleep(3000);
		try {
			b.click(pm.getPop_up_close());

			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(3000);

		b.typeData(pm.getEnter_cvv(), "123");
		Thread.sleep(3000);

		Thread.sleep(2000);
		try {
			b.click(pm.getPop_up_close());
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(3000);
		b.click(pm.getPay_btn());
		Thread.sleep(3000);

		try {
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
			b.click(pm.getPop_up_close());

		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(10000);
		System.out.println("payment in progress");
		Thread.sleep(10000);
		b.click(pm.getNavigate_back_btn());
		Thread.sleep(3000);
		b.click(pm.getCancel_yes_btn());
		Thread.sleep(3000);
		b.click(pm.getNavigate_back_btn());
		Thread.sleep(3000);

		/*
		 * b.click(pm.getNavigate_back_btn()); Thread.sleep(3000);
		 */

		try {

			b.click(pm.getNOt_now_btn());
		} catch (Exception e) {
			System.out.println("not now btn not present");
		}
		System.out.println("negative payment success for diamond 6 month pack");
		try {
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
			b.click(pm.getPop_up_close());

		} catch (Exception e) {
			e.getMessage();
		}

//*******************platinum 3 month pack********************************//

		Thread.sleep(3000);

		b.click(pm.getSix_month_pack());
		Thread.sleep(3000);

		b.click(pm.getPlatinum_3_month_pack());

		b.click(pm.getGold_3mnth());
		Thread.sleep(3000);
		b.click(pm.getPayment_creditcard());
		Thread.sleep(3000);
		b.typeData(pm.getCard_number(), BaseTestAgarwal.readValueFromExcelSheet().get(1).get("cardnumber"));
		Thread.sleep(3000);
		System.out.println("enter card details");
		b.click(pm.getExpiry_month());
		Thread.sleep(3000);
		b.click(pm.getMonth_value());
		Thread.sleep(3000);
		// b.click(pm.getEnter_expiry_month_year());
		Thread.sleep(3000);
		// b.typeData(pm.getEnter_expiry_month_year(),
		// BaseTestBrahmin.readValueFromExcelSheet().get(1).get("expiryyear"));
		// Thread.sleep(3000);
		b.click(pm.getEnter_expiry_month_year());
		Thread.sleep(3000);
		try {
			b.click(pm.getPop_up_close());

			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(3000);

		b.typeData(pm.getEnter_cvv(), "123");
		Thread.sleep(3000);

		Thread.sleep(2000);
		try {
			b.click(pm.getPop_up_close());
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(3000);
		b.click(pm.getPay_btn());
		Thread.sleep(3000);

		try {
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
			b.click(pm.getPop_up_close());

		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(10000);
		System.out.println("payment in progress");
		Thread.sleep(10000);
		b.click(pm.getNavigate_back_btn());
		Thread.sleep(3000);
		b.click(pm.getCancel_yes_btn());
		Thread.sleep(3000);
		b.click(pm.getNavigate_back_btn());
		Thread.sleep(3000);

		/*
		 * b.click(pm.getNavigate_back_btn()); Thread.sleep(3000);
		 */

		try {

			b.click(pm.getNOt_now_btn());
		} catch (Exception e) {
			System.out.println("not now btn not present");
		}
		System.out.println("negative payment success for platinum 6 month pack");
		try {
			// driver.findElement(By.xpath("//*[@id='popclose']")).click();
			b.click(pm.getPop_up_close());

		} catch (Exception e) {
			e.getMessage();
		}

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
