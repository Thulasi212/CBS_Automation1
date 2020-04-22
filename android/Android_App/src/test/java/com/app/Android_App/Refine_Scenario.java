package com.app.Android_App;

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

public class Refine_Scenario extends BaseTest {
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
		BaseTest b = new BaseTest();
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//*[@text='LOGIN']")).click();
		} catch (Exception e) {
			System.out.println("no login button");
		}
		try {
			b.click(p1.getEnter_matri_Id1());
			b.typeData(p1.getEnter_matri_Id1(), BaseTest.readValueFromExcelSheet().get(1).get("Username"));
			Thread.sleep(5000);
			b.typeData(p1.getEnter_password1(), BaseTest.readValueFromExcelSheet().get(1).get("Password"));
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
		b.click(p.getMatches());
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@id='tv_filter_refine']")));
		Thread.sleep(15000);
		// List<AndroidElement> employee_details =
		// driver.findElements(By.xpath("(//*[@id='refine_listView']/*/*[@id='refine_adapter_checkBox'])"));
		// Thread.sleep(5000);
		driver.swipe(0, 600, 0, 0, 2000);
		// ***************Employed in**************//
		b.click(driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*[@class='android.widget.RelativeLayout' and @height>0 and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]] and ./*[@id='txt_title']])[1]")));
		Thread.sleep(5000);
		List<AndroidElement> employee_details = driver.findElements(By.xpath("//*[@id='refine_adapter_checkBox']"));
		Thread.sleep(5000);

		// Thread.sleep(5000);
		employee_details.get(new Random().nextInt(employee_details.size() - 2)).click();
		Thread.sleep(5000);
		b.click(p1.getSelect_ok_btn());

		String r2 = driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*/*[@id='txt_title' and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]])[1]"))
				.getText();
		System.out.println(r2);
		Thread.sleep(15000);
		// *************citizenship*****************//
		b.click(driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*[@class='android.widget.RelativeLayout' and @height>0 and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]] and ./*[@id='txt_title']])[2]")));
		Thread.sleep(5000);
		employee_details.get(new Random().nextInt(employee_details.size())).click();
		Thread.sleep(5000);
		b.click(p1.getSelect_ok_btn());
		Thread.sleep(5000);
		String r3 = driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*/*[@id='txt_title' and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]])[2]"))
				.getText();
		Thread.sleep(5000);
		System.out.println(r3);

		Thread.sleep(15000);
		// ******** eating habits**********//
		b.click(driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*[@class='android.widget.RelativeLayout' and @height>0 and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]] and ./*[@id='txt_title']])[3]")));
		Thread.sleep(5000);
		employee_details.get(new Random().nextInt(employee_details.size() - 2)).click();
		Thread.sleep(5000);
		b.click(p1.getSelect_ok_btn());
		Thread.sleep(5000);
		String r4 = driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*/*[@id='txt_title' and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]])[3]"))
				.getText();
		Thread.sleep(5000);
		System.out.println(r4);
		Thread.sleep(15000);
		// driver.swipe(0, 800, 0, 0, 2000);
		// ***************drinking habits*************//
		Thread.sleep(15000);
		b.click(driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*[@class='android.widget.RelativeLayout' and @height>0 and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]] and ./*[@id='txt_title']])[4]")));
		Thread.sleep(5000);
		employee_details.get(new Random().nextInt(employee_details.size() - 2)).click();
		Thread.sleep(15000);
		b.click(p1.getSelect_ok_btn());
		Thread.sleep(5000);
		String r5 = driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*/*[@id='txt_title' and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]])[4]"))
				.getText();
		Thread.sleep(5000);
		System.out.println(r5);
		// *************smoking habits***************//
		Thread.sleep(15000);
		b.click(driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*[@class='android.widget.RelativeLayout' and @height>0 and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]] and ./*[@id='txt_title']])[5]")));
		Thread.sleep(15000);
		employee_details.get(new Random().nextInt(employee_details.size() - 2)).click();
		Thread.sleep(5000);
		b.click(p1.getSelect_ok_btn());
		Thread.sleep(5000);
		String r6 = driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*/*[@id='txt_title' and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]])[5]"))
				.getText();
		Thread.sleep(5000);
		System.out.println(r6);
		// ****************physical status**********//
		Thread.sleep(15000);
		b.click(driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*[@class='android.widget.RelativeLayout' and @height>0 and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]] and ./*[@id='txt_title']])[6]")));
		Thread.sleep(15000);
		employee_details.get(new Random().nextInt(employee_details.size() - 3)).click();
		Thread.sleep(5000);
		b.click(p1.getSelect_ok_btn());
		Thread.sleep(5000);
		String r7 = driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*/*[@id='txt_title' and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]])[6]"))
				.getText();
		Thread.sleep(5000);
		System.out.println(r7);
		// *****************complexion**************//
		Thread.sleep(15000);
		b.click(driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*[@class='android.widget.RelativeLayout' and @height>0 and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]] and ./*[@id='txt_title']])[7]")));
		Thread.sleep(15000);
		employee_details.get(new Random().nextInt(employee_details.size() - 4)).click();
		Thread.sleep(5000);
		b.click(p1.getSelect_ok_btn());
		Thread.sleep(5000);
		String r8 = driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*/*[@id='txt_title' and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]])[7]"))
				.getText();
		Thread.sleep(5000);
		System.out.println(r8);
		// Thread.sleep(5000);

		// *********************Body type****************//
		Thread.sleep(15000);
		b.click(driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*[@class='android.widget.RelativeLayout' and @height>0 and ./*[@id='txt_title']])[8]")));
		Thread.sleep(15000);
		employee_details.get(new Random().nextInt(employee_details.size() - 3)).click();
		Thread.sleep(5000);
		b.click(p1.getSelect_ok_btn());
		Thread.sleep(5000);
		String r9 = driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*[@class='android.widget.RelativeLayout' and @height>0 and ./*[@id='txt_title']])[8]"))
				.getText();
		Thread.sleep(5000);
		System.out.println(r9);
		// *********************family value******************//
		driver.swipe(0, 800, 0, 0, 2000);
		Thread.sleep(15000);
		b.click(driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*[@class='android.widget.RelativeLayout' and @height>0 and ./*[@id='txt_title']])[5]")));
		Thread.sleep(15000);
		employee_details.get(new Random().nextInt(employee_details.size() - 3)).click();
		Thread.sleep(5000);
		b.click(p1.getSelect_ok_btn());
		Thread.sleep(5000);
		String r10 = driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*[@class='android.widget.RelativeLayout' and @height>0 and ./*[@id='txt_title']])[5]"))
				.getText();
		Thread.sleep(5000);
		System.out.println(r10);
		// ******************family type*********************//
		Thread.sleep(15000);
		b.click(driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*[@class='android.widget.RelativeLayout' and @height>0 and ./*[@id='txt_title']])[6]")));
		Thread.sleep(15000);
		employee_details.get(new Random().nextInt(employee_details.size() - 4)).click();
		Thread.sleep(5000);
		b.click(p1.getSelect_ok_btn());
		Thread.sleep(5000);
		String r11 = driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*[@class='android.widget.RelativeLayout' and @height>0 and ./*[@id='txt_title']])[6]"))
				.getText();
		Thread.sleep(5000);
		System.out.println(r11);
		// ************************family status********************//
		Thread.sleep(15000);
		b.click(driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*[@class='android.widget.RelativeLayout' and @height>0 and ./*[@id='txt_title']])[7]]")));
		Thread.sleep(5000);
		employee_details.get(new Random().nextInt(employee_details.size() - 4)).click();
		Thread.sleep(5000);
		b.click(p1.getSelect_ok_btn());
		Thread.sleep(5000);
		String r12 = driver.findElement(By.xpath(
				"(//*[@id='recy_refine']/*/*/*[@class='android.widget.RelativeLayout' and @height>0 and ./*[@id='txt_title']])[7]"))
				.getText();
		Thread.sleep(5000);
		System.out.println(r12);

		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@id='btn_apply']")));

		// List<AndroidElement> employee_details1 =
		// driver.findElements(By.xpath("(//*[@id='refine_listView']/*/*[@id='refine_adapter_checkBox'])"));
		// Thread.sleep(5000);
		// for (int i = 1; i <employee_details1.size(); i++) {
		// employee_details.get(new Random(i).nextInt(employee_details.size())).click();
		// List<AndroidElement> values =
		// driver.findElements(By.xpath("(//*[@id='recy_refine']/*/*/*/*[@id='txt_title'
		// and @height>0 and ./parent::*[./parent::*[(./preceding-sibling::* |
		// ./following-sibling::*)[@height>0]]]])"));
		// for (int j = 1; j < values.size(); j++) {
		// String s1 = values.get(j).getText();
		// System.out.println("values" + s1);

		// }
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
