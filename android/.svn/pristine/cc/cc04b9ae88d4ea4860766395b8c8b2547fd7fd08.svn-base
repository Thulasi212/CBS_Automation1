package testscripts;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTestAgarwal;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

public class Dashboard extends BaseTestAgarwal {
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
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.agarwalmatrimony");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.domaininstance.ui.activities.Splash");
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
		driver.setLogLevel(Level.INFO);

	}

	@BeforeMethod
	public void testUntitled() throws InterruptedException {
		Dashboard_Pom db = new Dashboard_Pom(driver);
		Edit_Profile_Pom pp = new Edit_Profile_Pom(driver);
		Matches_Pom p = new Matches_Pom(driver);
		BaseTestAgarwal b = new BaseTestAgarwal();
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//*[@text='LOGIN']")).click();
		} catch (Exception e) {
			System.out.println("no login button");
		}
		try {
			b.click(pp.getEnter_matri_Id1());
			b.typeData(pp.getEnter_matri_Id1(), BaseTestAgarwal.readValueFromExcelSheet().get(1).get("Username"));
			Thread.sleep(5000);
			b.typeData(pp.getEnter_password1(), BaseTestAgarwal.readValueFromExcelSheet().get(1).get("Password"));
			Thread.sleep(5000);
			b.click(pp.getEnter_Login1());
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
		Matches_Pom p = new Matches_Pom(driver);
		BaseTestAgarwal b = new BaseTestAgarwal();
		Dashboard_Pom db = new Dashboard_Pom(driver);
		Edit_Profile_Pom pp = new Edit_Profile_Pom(driver);
		Inbox_pom ip = new Inbox_pom(driver);
		Thread.sleep(5000);

		Dimension size = driver.manage().window().getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		System.out.println(width);
		int y = (int) (height * 0.25);
		int startx = (int) (width * 0.75);
		int endx = (int) (width * 0.15);
		Thread.sleep(5000);

		// b.click(driver.findElement(By.xpath("//*[@id='btnYes']")));

		// driver.swipe(startx, y, endx, y, 4000);
		// driver.swipe(startx, y, endx, y, 4000);
		Thread.sleep(5000);

		try {

			if (driver.findElement(By.xpath("//*[@text='ADD PHOTO']")).isDisplayed()) {
				b.click(db.getAdd_photo_btn());

				Thread.sleep(5000);
				b.click(db.getAdd_photo_btn());

				Thread.sleep(5000);
			}
			b.click(db.getChoose_gallery_option());

			Thread.sleep(5000);
			b.click(db.getGallery_btn());

			Thread.sleep(5000);
			b.click(db.getPhotos_btn());

			/*
			 * List<AndroidElement> photos =
			 * driver.findElements(By.xpath("// *[@id='micro_thumb']"));
			 * Thread.sleep(15000); for (int i = 0; i <= photos.size(); i++) {
			 * Thread.sleep(5000); int ps = photos.size(); System.out.println("photos size:"
			 * + ps);
			 */
			Thread.sleep(15000);

			List<AndroidElement> links = driver.findElements(By.xpath("// *[@id='micro_thumb']"));
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
		} catch (Exception e) {
			System.out.println("no photo scenario dispalyed");
		}

		try {
			Thread.sleep(5000);
			if (driver.findElement(By.xpath("//*[@text='ADD HOROSCOPE']")).isDisplayed()) {
				Thread.sleep(5000);

				b.click(db.getAdd_Horoscope_btn());
				Thread.sleep(5000);
				try {
					b.click(driver.findElement(By.xpath("//*[@id='spinMonth']")));
					Thread.sleep(5000);
					b.click(driver.findElement(By.xpath("(//*[@class='android.widget.ListView']/*[@id='text1'])[5]")));
					Thread.sleep(5000);
					b.click(driver.findElement(By.xpath("//*[@id='spinDate']")));
					Thread.sleep(5000);
					b.click(driver.findElement(By.xpath("(//*[@class='android.widget.ListView']/*[@id='text1'])[6]")));
					Thread.sleep(5000);
					b.click(driver.findElement(By.xpath("//*[@id='spinYear']")));
					Thread.sleep(5000);
					b.click(driver.findElement(By.xpath("(//*[@class='android.widget.ListView']/*[@id='text1'])[11]")));

				} catch (Exception e) {
					System.out.println("no date of birth field displayed");
				}
				b.click(db.getEdit_hour_txt());
				Thread.sleep(5000);
				b.click(driver.findElement(By.xpath("//*[@text='04']")));
				Thread.sleep(5000);

				b.click(db.getEdit_min_txt());
				Thread.sleep(5000);
				b.click(driver.findElement(By.xpath("//*[@text='08']")));
				Thread.sleep(5000);

				b.click(db.getEdit_Am_pm_txt());
				Thread.sleep(5000);
				b.click(driver.findElement(By.xpath("//*[@text='AM']")));

				/// ******horoscope country*********//

				Thread.sleep(5000);
				b.click(db.getEdit_country_txt());
				// b.click(driver.findElement(By.xpath("//*[@id='tvCountry']")));
				Thread.sleep(5000);
				b.typeData(pp.getSearch_edit_btn(),
						BaseTestAgarwal.readValueFromExcelSheet().get(1).get("country"));
				Thread.sleep(5000);
				b.click(pp.getValue_select());
				Thread.sleep(5000);
				//b.click(pp.getSelect_ok_btn());

				// ****horoscope state****//

				Thread.sleep(5000);
				b.click(db.getEdit_state_txt());

				Thread.sleep(5000);
				b.typeData(pp.getSearch_edit_btn(), BaseTestAgarwal.readValueFromExcelSheet().get(1).get("state"));
				Thread.sleep(5000);
				b.click(pp.getValue_select());
				Thread.sleep(5000);
				//b.click(pp.getSelect_ok_btn());

				// *********horoscope city************//

				Thread.sleep(5000);
				b.click(db.getEdit_city_txtt());

				Thread.sleep(5000);
				b.typeData(pp.getSearch_edit_btn(), BaseTestAgarwal.readValueFromExcelSheet().get(1).get("city"));
				Thread.sleep(5000);
				b.click(pp.getValue_select());
				Thread.sleep(5000);
				//b.click(pp.getSelect_ok_btn());

				// ****horoscope chart style*******//

				Thread.sleep(5000);
				b.click(db.getEdit_chart_txt());

				Thread.sleep(5000);
				b.typeData(pp.getSearch_edit_btn(),
						BaseTestAgarwal.readValueFromExcelSheet().get(1).get("horoscope"));
				Thread.sleep(5000);
				b.click(pp.getValue_select());
				//b.click(pp.getSelect_ok_btn());

				Thread.sleep(5000);
				b.click(db.getGenerate_horoscope());
				Thread.sleep(5000);
				b.click(pp.getValue_select());
				Thread.sleep(5000);
				b.click(p.getPopup_close());
			}

		} catch (Exception e) {
			System.out.println("no horoscope button dispalyed");
		}

		try {
			Thread.sleep(5000);
			if (driver.findElement(By.xpath("//*[@text='ADD DETAILS']")).isDisplayed()) {
				Thread.sleep(5000);
				b.click(db.getAdd_details_btn());
				Thread.sleep(5000);
				b.typeData(pp.getSearch_checkbox_btn(), BaseTestAgarwal.readValueFromExcelSheet().get(1).get("star"));
				Thread.sleep(5000);
				b.click(pp.getValue_select());
				Thread.sleep(5000);
				b.click(pp.getSelect_ok_btn());

			}
		} catch (Exception e) {
			System.out.println("no details handled");
		}
		try {Thread.sleep(5000);
			if (db.getDb_viewedur_profile_viewal_btn().isDisplayed()) {
				Thread.sleep(5000);
				b.click(db.getDb_viewedur_profile_viewal_btn());
				System.out.println("landed on viewed my profile section");
			} else {
				System.out.println("no view all btn present in dashboard");

			}
		} catch (Exception e) {
			System.out.println(" no view all btn present in dashboard .....");
		}
		Thread.sleep(5000);
		List<AndroidElement> ID = driver.findElements(By.xpath("//*[@id='profileMatriId']"));
		for (int i = 0; i < ID.size(); i++) {
			// driver.scrollTo("NIC");
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
				// String req_msg = driver.findElement(By.xpath("//*[@text]")).getText();
				// Thread.sleep(5000);
				// System.out.println(req_msg);
				// Thread.sleep(5000);
			}
		} catch (Exception e) {
			System.out.println("no request btn handled");
		}
		Thread.sleep(5000);

		b.click(p.getBack_btn());
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
			Thread.sleep(5000);
			b.click(p.getBack_btn());
		} catch (Exception e) {
			System.out.println("no option displayed");
		}
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
				Thread.sleep(5000);
				b.click(p.getNot_now_btn());
			}

		} catch (Exception e) {
			System.out.println("no intrest button displayed");
		}
		Thread.sleep(5000);
		try {
			if (driver
					.findElement(By.xpath(
							"(//*[@id='recyclerview']/*/*/*/*/*/*[@id='shorlist_or_deleteButton' and @height>0])[1]"))
					.isDisplayed()) {

				driver.findElement(By.xpath(
						"(//*[@id='recyclerview']/*/*/*/*/*/*[@id='shorlist_or_deleteButton' and @height>0])[1]"))
						.click();
				Thread.sleep(5000);
			}

		} catch (Exception e) {
			System.out.println("no upgrade page verified");
		}
		Thread.sleep(5000);
		try {
			Thread.sleep(5000);
			b.click(p.getBack_btn());
			System.out.println("landed and back to upgrade page");

		} catch (Exception e) {
			System.out.println("back btn not handled");
		}
		Thread.sleep(5000);
		String upgradetext = driver.findElement(By.xpath("//*[@text='Upgrade Now']")).getText();
		// System.out.println("*" + upgradetext);
		Thread.sleep(5000);
		String upgradetext1 = driver.findElement(By.xpath("(//*[@id='recyclerview']/*/*/*/*/*[@id='tvUpgradeTo'])[1]"))
				.getText();
		Thread.sleep(5000);
		System.out.println("* " + upgradetext + upgradetext1);
		Thread.sleep(5000);
		b.click(db.getUpgrade_now_btn());
		Thread.sleep(5000);
		b.click(p.getBack_btn());
		Thread.sleep(5000);
		try {
			b.click(p.getNot_now_btn());
		} catch (Exception e) {
			System.out.println("no not now btn dispalyed");

		}
		Thread.sleep(5000);
		driver.swipe(endx, y, startx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		// driver.swipe(startx, starty, startx, endy, 1000);
		// driver.swipe(startx, y, endx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		Thread.sleep(5000);
		try {
			Thread.sleep(5000);
			if (db.getRespond_nw_btn().isDisplayed()) {
				Thread.sleep(5000);
				b.click(db.getRespond_nw_btn());
				Thread.sleep(5000);
				b.click(p.getFilter());
			}

		} catch (Exception e) {
			System.out.println("no respond button present");
		}
		Thread.sleep(5000);
		try {
			if (ip.getView_Reply().isDisplayed()) {
				Thread.sleep(5000);
				b.click(ip.getView_Reply());
				// b.typeData(ip.getMail_content(),
				// BaseTestBrahmin.readValueFromExcelSheet().get(1).get("message"));
				Thread.sleep(5000);
				b.click(ip.getPopup_close());

			}
		} catch (Exception e) {
			System.out.println("no view & Reply btn displayed");
		}

		Thread.sleep(5000);
		try {
			if (ip.getAccept_intrest_yes().isDisplayed()) {
				Thread.sleep(5000);
				b.click(ip.getAccept_intrest_yes());
				// b.typeData(ip.getMail_content(),
				// BaseTestBrahmin.readValueFromExcelSheet().get(1).get("message"));
				Thread.sleep(5000);
				b.click(ip.getPopup_close());
				System.out.println("intrest accepted");

			}
		} catch (Exception e) {
			System.out.println("no aceept yes btn displayed");
		}

	}

	@AfterTest
	public void tearDown() {
		//driver.resetApp();
		driver.quit();
		reports.endTest(test);
		reports.flush();
		// driver.resetApp();
		// driver.quit();

		// test.log(LogStatus.PASS, "Application Closed Succesfull");
		// reports.endTest(test);

	}

}
