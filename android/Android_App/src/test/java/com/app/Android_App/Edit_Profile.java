package com.app.Android_App;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTestAgarwal;

import java.net.URL;
import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

public class Edit_Profile extends BaseTest {
	public String reportDirectory = "reports";
	public String reportFormat = "xml";
	public String testName = "Untitled";
	public AndroidDriver<AndroidElement> driver = null;

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
		Edit_Profile_Pom p = new Edit_Profile_Pom(driver);
		Matches_Pom p1 = new Matches_Pom(driver);
		BaseTest b = new BaseTest();
		Thread.sleep(5000);
		// b.click(p.getMain_Login());

		try {
			driver.findElement(By.xpath("//*[@text='LOGIN']")).click();
		} catch (Exception e) {
			System.out.println("no login button");
		}
		try {
			b.click(p.getEnter_matri_Id1());
			b.typeData(p.getEnter_matri_Id1(), BaseTest.readValueFromExcelSheet().get(1).get("Username"));
			Thread.sleep(5000);
			b.typeData(p.getEnter_password1(), BaseTest.readValueFromExcelSheet().get(1).get("Password"));
			Thread.sleep(5000);
			b.click(p.getEnter_Login1());
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

		b.click(p.getMain_menu());
		Thread.sleep(5000);
		b.click(p.getEdit_Profile_btn());
		Thread.sleep(5000);
		b.click(p.getEdit_Number_btn());
		Thread.sleep(5000);
		b.clear(p.getEdit_Number_txt());
		Thread.sleep(5000);
		b.typeData(p.getEdit_Number_txt(), "8098882244");
		Thread.sleep(5000);
		// b.click(p.getEdit_Number_txt_submit());
		b.click(p1.getBack_btn());

		/*
		 * Thread.sleep(5000); b.click(p.getPersonal_lines_edit_btn());
		 * Thread.sleep(5000); b.click(p.getDescription_edit()); Thread.sleep(5000);
		 * b.clear(p.getDescription_edit()); Thread.sleep(5000); //
		 * b.typeData(p.getDescription_edit(), //
		 * BaseTest.readValueFromExcelSheet().get(1).get("ProfileDescription")); //
		 * b.typeData(p.getDescription_edit(), //
		 * BaseTest.readValueFromExcelSheet().get(1).get("ProfileDescription"));
		 * Thread.sleep(5000); driver.findElement(By.xpath("//*[@id='save']")).click();
		 * System.out.println("1"); Thread.sleep(5000); //
		 * driver.findElement(By.xpath("//*[@text='Cancel']")).click();
		 * System.out.println("2"); // b.click(p.getSave_btn());
		 */ /*
			 * if (driver.findElement(By.xpath("//*[@id='save']")).isDisplayed()) {
			 * b.click(p.getSave_btn()); } else {
			 * System.out.println("no save button clicked"); }
			 */

		// basic details Edit//

		Thread.sleep(5000);
		b.click(p.getBasic_details_edit_btn());
		Thread.sleep(5000);
		// edit profile//
		b.click(p.getEdit_Profile_btn());
		Thread.sleep(5000);
		b.click(p.getProfile_created());
		Thread.sleep(5000);
		// name//
		b.click(p.getName_field());
		Thread.sleep(5000);
		b.typeData(p.getName_field(), "sairani");
		Thread.sleep(5000);
		// height//
		b.click(p.getHeight_btn());
		Thread.sleep(5000);
		b.click(p.getHeight_Value());
		Thread.sleep(5000);
		// weight//
		b.click(p.getWeight_btn());
		Thread.sleep(5000);
		b.click(p.getWeight_value());
		Thread.sleep(5000);
		// Bodytype//

		b.click(p.getBody_type_btn());
		Thread.sleep(5000);
		b.click(p.getBody_type_Value());
		Thread.sleep(5000);
		// complexion//
		b.click(p.getComplexion_type_btn());
		Thread.sleep(5000);
		b.click(p.getComplexion_type_value());
		Thread.sleep(5000);
		// physical type//
		b.click(p.getPhysical_type_btn());
		Thread.sleep(5000);
		b.click(p.getPhysical_type_value());
		Thread.sleep(5000);
		// languages//
		b.click(p.getLanguages_known_btn());
		Thread.sleep(5000);
		b.click(p.getLanguages_known_Value());
		Thread.sleep(5000);
		b.click(p.getSelect_ok_btn());
		// save button//
		Thread.sleep(5000);
		b.click(p.getSave_btn());
		System.out.println("Basic details edited");
		Thread.sleep(10000);
		// Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 1000);

		// **********Religious**********/
		Thread.sleep(5000);
		b.click(p.getReligious_detilas_btn());
		Thread.sleep(5000);
		b.click(p.getStar_btn());
		// Thread.sleep(5000);
		// b.typeData(p.getStar_value_btn(),
		// BaseTest.readValueFromExcelSheet().get(1).get("star"));
		Thread.sleep(5000);
		b.click(p.getStar_select_value_btn());
		Thread.sleep(5000);
		b.click(p.getRasi_btn());
		Thread.sleep(5000);
		b.click(p.getRasi_value_btn());
		Thread.sleep(5000);
		b.click(p.getGothram_btn());
		Thread.sleep(5000);
		b.typeData(p.getGothram_btn(), "baby");
		Thread.sleep(5000);
		if (p.getDosham_btn().isDisplayed()) {
			Thread.sleep(5000);
			b.click(p.getDosham_btn());
		} else {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='edit_txt_dhosam_value']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@text='Yes']")).click();
		}
		b.click(p.getDosham_btn());
		Thread.sleep(5000);
		b.click(p.getDosham_value_btn());
		Thread.sleep(5000);
		b.click(p.getSave_btn());
		System.out.println("Religious information edited ");
		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		// ****************professional**************///
		Thread.sleep(5000);
		b.click(p.getProfessional_info_btn());
		Thread.sleep(5000);
		b.click(p.getEducation_btn());
		Thread.sleep(5000);
		b.click(p.getEducation_value_btn());
		Thread.sleep(5000);
		b.click(p.getEducation_Detail_btn());
		Thread.sleep(5000);
		b.typeData(p.getEducation_Detail_btn(), "Information Technology");
		Thread.sleep(5000);
		b.click(p.getCollege_Detail_btn());
		Thread.sleep(5000);
		b.typeData(p.getCollege_Detail_btn(), "engineering college");
		Thread.sleep(5000);
		b.click(p.getEmployed_btn());
		Thread.sleep(5000);
		b.click(p.getEmployed_Value_btn());
		Thread.sleep(5000);
		b.click(p.getOccupation_btn());
		Thread.sleep(5000);
		b.click(p.getOccupation_Value_btn());
		Thread.sleep(5000);
		b.click(p.getOccupation_detail_btn());
		Thread.sleep(5000);
		b.typeData(p.getOccupation_detail_btn(), "Devops");
		Thread.sleep(5000);
		// driver.findElement(By.xpath("//*[@id='back']")).click();
		driver.hideKeyboard();
		Thread.sleep(5000);
		b.click(p.getCurrency_btn());
		Thread.sleep(5000);
		b.click(p.getReg_search_btn());
		Thread.sleep(5000);
		b.typeData(p.getReg_search_btn(), "india");
		Thread.sleep(5000);
		b.click(p.getIndia_Value_btn());
		Thread.sleep(5000);
		b.click(p.getAnnual_income());
		Thread.sleep(5000);
		b.click(p.getAnnual_Income_Value_btn());
		Thread.sleep(5000);
		b.click(p.getSave_btn());
		System.out.println("Professional information edited");
		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		// **********location************/
		Thread.sleep(5000);
		b.click(p.getLocation_edit_btn());
		Thread.sleep(5000);
		b.click(p.getCountry_living_btn());
		Thread.sleep(5000);
		b.click(p.getCountry_living_Value_btn());
		Thread.sleep(5000);
		b.click(p.getResiding_state_btn());
		Thread.sleep(5000);
		b.click(p.getResiding_sate_Value_btn());
		Thread.sleep(5000);
		b.click(p.getResiding_city_btn());
		Thread.sleep(5000);
		b.click(p.getResiding_city_Value_btn());
		Thread.sleep(5000);
		b.click(p.getCitizen_btn());
		Thread.sleep(5000);
		b.click(p.getCitizen_Value_btn());

		Thread.sleep(5000);
		b.click(p.getSave_btn());
		System.out.println("Location edited ");
		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		// ***********Faamily**************//

		driver.swipe(0, 800, 0, 0, 1000);
		Thread.sleep(5000);
		b.click(p.getFamily_info_btn());
		Thread.sleep(5000);
		b.click(p.getFamily_btn());
		Thread.sleep(5000);
		b.click(p.getFamily_Value_btn());
		Thread.sleep(5000);
		b.click(p.getFamily_type_btn());
		Thread.sleep(5000);
		b.click(p.getFamily_type_Value_btn());
		Thread.sleep(5000);
		b.click(p.getFamily_status_btn());
		Thread.sleep(5000);
		b.click(p.getFamily_staus_Value_btn());
		// b.click(p.getFamily_Value_btn());
		Thread.sleep(5000);
		b.click(p.getFather_occupation_Value_btn());
		Thread.sleep(5000);
		b.typeData(p.getFather_occupation_Value_btn(), "real Estate");
		Thread.sleep(5000);
		b.click(p.getMother_occupation_Value_btn());
		Thread.sleep(5000);
		b.typeData(p.getMother_occupation_Value_btn(), "housewife");
		Thread.sleep(5000);
		driver.hideKeyboard();
		// b.click(p.getAncstor_btn());
		// Thread.sleep(5000);
		// b.typeData(p.getAncstor_btn(), "happy");
		// Thread.sleep(5000);
		// driver.findElement(By.id("back")).click();
		Thread.sleep(5000);
		b.click(p.getBrother_btn());
		Thread.sleep(5000);
		b.click(p.getBrother_Value_btn());
		Thread.sleep(10000);
		b.click(p.getBrother_married_btn());
		Thread.sleep(10000);
		b.click(p.getBrother_married_value_btn());
		Thread.sleep(10000);
		b.click(p.getSister_btn());
		Thread.sleep(10000);
		b.click(p.getSister_value_btn());
		Thread.sleep(5000);
		b.click(p.getSister_married_btn());
		Thread.sleep(5000);
		b.click(p.getSister_married_value_btn());
		Thread.sleep(5000);
		b.click(p.getSave_btn());
		System.out.println("family details edited");
		Thread.sleep(10000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		// driver.swipe(0, 800, 0, 0, 1000);
		// **************habits*************//
		driver.swipe(0, 800, 0, 0, 1000);
		Thread.sleep(5000);
		b.click(p.getHabits_edit_btn());
		Thread.sleep(5000);
		b.click(p.getEating_habits_btn());
		Thread.sleep(5000);
		b.click(p.getEating_habits_value_btn());
		Thread.sleep(5000);
		b.click(p.getDrinking_habits_btn());
		Thread.sleep(5000);
		b.click(p.getDrinking_habits_value_btn());
		Thread.sleep(5000);
		b.click(p.getSmoking_habits_btn());
		Thread.sleep(5000);
		b.click(p.getSmoking_habits_value_btn());
		Thread.sleep(5000);
		b.click(p.getSave_btn());
		System.out.println("habits details edited");
		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		// ************lifeStyle*************//
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		Thread.sleep(5000);
		b.click(p.getLifestyle_edit_btn());
		Thread.sleep(5000);
		b.click(p.getHobbies_btn());
		Thread.sleep(5000);
		b.click(p.getHobbies_value_btn());
		Thread.sleep(5000);
		b.click(p.getSelect_ok_btn());
		Thread.sleep(5000);
		b.click(p.getSave_btn());
		System.out.println("lifestyle details edited");
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")));
		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 1000);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='accountsLayout']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='logoutLayout']")).click();

	}

	@AfterTest
	public void tearDown() {
		// driver.resetApp();
		// driver.quit();
		reports.endTest(test);
		reports.flush();
		// driver.resetApp();
		// driver.quit();

	}

}
//rdy507761