package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.Register_Pom;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class City_Registration extends BaseTest {

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

		Register_Pom r = new Register_Pom(driver);
		Thread.sleep(3000);
		BaseTest.click(r.getSkip_btn());
		Thread.sleep(3000);
		Thread.sleep(3000);
		BaseTest.click(r.getSignup_btn());
		Thread.sleep(3000);
		BaseTest.click(r.getCommunity_select_btn());
		Thread.sleep(5000);
		BaseTest.typeData(r.getSearch_btn(), BaseTest.getExcelData("Sheet2", 0, 0));
		Thread.sleep(3000);
		BaseTest.click(r.getValue_select_btn());
		String profile_self = BaseTest.getExcelData("Sheet2", 0, 1);
		Thread.sleep(3000);
		if (profile_self.equalsIgnoreCase("Parents")) {
			Thread.sleep(3000);
			BaseTest.click(r.getProfile_parents_btn());
			Thread.sleep(3000);
		} else if (profile_self.equalsIgnoreCase("Self")) {
			Thread.sleep(3000);
			BaseTest.click(r.getProfile_self_btn());
			Thread.sleep(3000);
		} else if (profile_self.equalsIgnoreCase("Sibling")) {
			Thread.sleep(3000);
			BaseTest.click(r.getProfile_sibling_btn());
			Thread.sleep(3000);
		}

		else if (profile_self.equalsIgnoreCase("Relative")) {
			Thread.sleep(3000);
			BaseTest.click(r.getProfile_Relative_btn());
			Thread.sleep(3000);
		}

		else if (profile_self.equalsIgnoreCase("Friend")) {
			Thread.sleep(3000);
			BaseTest.click(r.getProfile_friend_btn());

		}
		Thread.sleep(3000);
		BaseTest.click(r.getCancel_btn());
		Thread.sleep(3000);
		String gender = BaseTest.getExcelData("Sheet2", 0, 2);

		try {
			Thread.sleep(3000);
			if (gender.equalsIgnoreCase("Male")) {
				Thread.sleep(3000);
				BaseTest.click(r.getGender_male_btn());

			}
			else if (gender.equalsIgnoreCase("Female")) {
				Thread.sleep(3000);
				BaseTest.click(r.getGender_female_btn());
			}
		} catch (Exception e) {
			Thread.sleep(3000);
			
		}
		Thread.sleep(3000);
		String Name = BaseTest.getExcelData("Sheet2", 0, 3);
		BaseTest.typeData(r.getEnter_name_btn(), Name);
		Thread.sleep(3000);
		driver.hideKeyboard();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='reg_dob_editText']")).click();
		Thread.sleep(3000);
		/*
		 * List<AndroidElement> datePickerBox =
		 * driver.findElements(By.xpath("//*[@class='android.view.View']"));
		 * Thread.sleep(3000);
		 * 
		 * AndroidElement month = datePickerBox.get(10); AndroidElement day =
		 * datePickerBox.get(9); AndroidElement year = datePickerBox.get(11);
		 * Thread.sleep(3000);
		 * 
		 * day.click(); day.sendKeys("22"); Thread.sleep(3000); month.click();
		 * month.sendKeys("Feb"); Thread.sleep(3000); year.click();
		 * year.sendKeys("2018"); Thread.sleep(3000);
		 */
		BaseTest.click(r.getDate_set_btn());
		String mail = "supertestregmail" + Math.floor(Math.random() * 867590) + "@gmail.com";
		Thread.sleep(3000);

		BaseTest.typeData(r.getEmail_btn(), mail);
		driver.hideKeyboard();
		Thread.sleep(3000);

		String password = BaseTest.getExcelData("Sheet2", 0, 4);System.out.println(password);
		BaseTest.typeData(r.getPassword_btn(), Name);
		Thread.sleep(3000);
		String countrycode = BaseTest.getExcelData("Sheet2", 0, 5);
		BaseTest.typeData(r.getCountry_code_btn(), countrycode);
		Thread.sleep(3000);
		String mobile_num = BaseTest.getExcelData("Sheet2", 0, 6);
		BaseTest.typeData(r.getMobile_num_btn(), mobile_num);
		Thread.sleep(3000);
		String mothertongue = BaseTest.getExcelData("Sheet2", 0, 7);
		BaseTest.click(r.getMothertongue_btn());
		Thread.sleep(3000);
		BaseTest.typeData(r.getSearch_btn(), mothertongue);
		Thread.sleep(3000);
		BaseTest.click(r.getValue_select_btn());
		Thread.sleep(3000);
		String caste = BaseTest.getExcelData("Sheet2", 0, 8);

		Thread.sleep(3000);
		BaseTest.typeData(r.getSearch_btn(), caste);
		Thread.sleep(3000);
		BaseTest.click(r.getValue_select_btn());
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//*[@id='reg_subcaste_editText']")).click();
		} catch (Exception e) {
			System.out.println("subcaste not avaialble");
		}
		Thread.sleep(3000);
		String subcaste = BaseTest.getExcelData("Sheet2", 0, 9);

		Thread.sleep(3000);
		BaseTest.typeData(r.getSearch_btn(), subcaste);
		Thread.sleep(3000);
		BaseTest.click(r.getValue_select_btn());
		Thread.sleep(3000);
		BaseTest.click(r.getContinue_btn());

		////////////////// 2nd PAge//////////////////////////
		Thread.sleep(10000);
		String marital_status = BaseTest.getExcelData("Sheet2", 0, 10);
		Thread.sleep(3000);
		if (marital_status.equalsIgnoreCase("Unmarried")) {
			Thread.sleep(3000);
			BaseTest.click(r.getUnmarried_btn());
			Thread.sleep(3000);
		} else if (marital_status.equalsIgnoreCase("Divorced")) {
			Thread.sleep(3000);
			BaseTest.click(r.getDivorced_btn());
			Thread.sleep(3000);
		} else if (marital_status.equalsIgnoreCase("Widow/Widower")) {
			Thread.sleep(3000);
			BaseTest.click(r.getWidower_btn());
			Thread.sleep(3000);
		}

		else if (marital_status.equalsIgnoreCase("Separated")) {
			Thread.sleep(3000);
			BaseTest.click(r.getSeparated_btn());
			Thread.sleep(3000);
		}

		Thread.sleep(3000);
		try {
			if (!marital_status.equals("Unmarried")) {

				String chidren = BaseTest.getExcelData("Sheet2", 0, 11);

				Thread.sleep(3000);
				BaseTest.typeData(r.getSearch_btn(), chidren);
				Thread.sleep(3000);
				BaseTest.click(r.getValue_select_btn());
				Thread.sleep(3000);
				String chidren_status = BaseTest.getExcelData("Sheet2", 0, 12);

				Thread.sleep(3000);
				BaseTest.typeData(r.getSearch_btn(), chidren_status);
				Thread.sleep(3000);
				BaseTest.click(r.getValue_select_btn());
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			System.out.println("no children button present");
		}
		Thread.sleep(3000);

		try {
			driver.findElement(By.xpath("//*[@id='reg_country_textView']")).click();
		} catch (Exception e) {
			System.out.println("no country btn selected");
		}

		Thread.sleep(3000);
		String country = BaseTest.getExcelData("Sheet2", 0, 13);

		Thread.sleep(3000);
		BaseTest.typeData(r.getSearch_btn(), country);
		Thread.sleep(3000);
		BaseTest.click(r.getValue_select_btn());
		Thread.sleep(3000);
		for (int k = 21; k <= 24; k++) {
		Thread.sleep(3000);
		String state = getExcelData("Sheet1", 0, k);
		System.out.println(state);
		Thread.sleep(2000);

		//driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(state);
		Thread.sleep(2000);
		
		BaseTest.typeData(r.getSearch_btn(), state);
		Thread.sleep(3000);
		BaseTest.click(r.getValue_select_btn());
		

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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Thread.sleep(3000);
}}}