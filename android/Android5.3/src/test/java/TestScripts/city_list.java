package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.Delete_POM;
import POM.Login_Pom;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class city_list extends BaseTest {

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
	public void testUntitled() throws Throwable {

		Login_Pom l = new Login_Pom(driver);
		Delete_POM d = new Delete_POM(driver);
		// for (int i = 0; i <= 3; i++) {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@text='Skip']")).click();
			Thread.sleep(2000);
			// driver.findElement(By.xpath("//*[@text='Skip']")).click();
			Thread.sleep(2000);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@text='Login']")).click();
			Thread.sleep(2000);

			Thread.sleep(2000);
			// String username = BaseTest.readValueFromExcelSheet().get(i).get("KMC333738");
			// String password = BaseTest.readValueFromExcelSheet().get(i).get("cbstest");
			// BaseTest.click(l.getEnter_Matrid());
			Thread.sleep(2000);

			BaseTest.typeData(l.getEnter_Matrid(), "AGR159159");

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
			BaseTest.click(driver.findElement(By.xpath("//*[@id='skip']")));
			System.out.println("PAyment intermediate page HAndled");

		} catch (Exception e) {
			System.out.println("no PAyment intermediate page HAndled.....");
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

		driver.findElement(By.xpath("//*[@id='ln_editProfile']")).click();
		Thread.sleep(5000);

		driver.swipe(0, 1200, 0, 0, 1000);
		driver.swipe(0, 400, 0, 0, 1000);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='location_edit']")).click();
		Thread.sleep(2000);
		for (int k = 21; k <= 24; k++) {
			driver.findElement(By.xpath("//*[@id='edit_txt_residing_state_value']")).click();
			Thread.sleep(2000);

			String state = getExcelData("Sheet1", 0, k);
			System.out.println(state);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(state);
			Thread.sleep(2000);

			// System.out.println(driver.findElement(By.xpath("//*[@id='value_textView']")).getText());
			// Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='value_textView']")).click();
			Thread.sleep(2000);
			// if
			// (state.equalsIgnoreCase(driver.findElement(By.xpath("//*[@id='value_textView']")).getText()))
			// {
			// System.out.println("same state is selected.....");
			// }
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@id='edit_txt_residing_city_value']")).click();
			Thread.sleep(2000);

			String aa = getExcelData("Sheet1", 1, k);

			Integer A = Integer.parseInt(aa);
			Thread.sleep(2000);
			for (int j = 2; j <= A + 1; j++) {
				String city = getExcelData("Sheet1", j, k);
				System.out.println(city);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(city);
				Thread.sleep(2000);
				System.out.println(driver.findElement(By.xpath("//*[@id='value_textView']")).getText());
				Thread.sleep(1000);
				if (city.equals(driver.findElement(By.xpath("//*[@id='value_textView']")).getText())) {
					System.out.println("city verified ");
				} else {
					System.out.println("city not verified ");
				}

			}
			driver.findElement(By.xpath("//*[@id='value_textView']")).click();
			/*
			 * List<AndroidElement> list =
			 * driver.findElements(By.xpath("//*[@id='reg_listView']")); Thread.sleep(2000);
			 * 
			 * 
			 * 
			 * for (int m = 0; m < list.size(); m++) {
			 * System.out.println(list.get(m).getText()); }
			 */

			// driver.findElement(By.xpath("//*[@id='drawer_close']")).click();
			// System.out.println(driver.findElement(By.xpath("//*[@id='value_textView']")).getText());
			// Thread.sleep(2000);

		}

	}
}// }