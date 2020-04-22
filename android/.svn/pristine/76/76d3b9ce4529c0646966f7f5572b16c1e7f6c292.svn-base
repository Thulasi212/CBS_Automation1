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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.Delete_POM;
import POM.Login_Pom;
import POM.Register_Pom;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class MotherTongue_Star_REgis extends BaseTest {
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
	BaseTest.typeData(r.getSearch_btn(), BaseTest.getExcelData("Sheet3", 0, 0));
	Thread.sleep(3000);
	BaseTest.click(r.getValue_select_btn());
	String profile_self = BaseTest.getExcelData("Sheet3", 0, 1);
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
	String gender = BaseTest.getExcelData("Sheet3", 0, 2);

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
	String Name = BaseTest.getExcelData("Sheet3", 0, 3);
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

	String password = BaseTest.getExcelData("Sheet3", 0, 4);
	BaseTest.typeData(r.getPassword_btn(), Name);
	Thread.sleep(3000);
	String countrycode = BaseTest.getExcelData("Sheet3", 0, 5);
	BaseTest.typeData(r.getCountry_code_btn(), countrycode);
	Thread.sleep(3000);
	String mobile_num = BaseTest.getExcelData("Sheet3", 0, 6);
	BaseTest.typeData(r.getMobile_num_btn(), mobile_num);
	Thread.sleep(3000);
	
	
	for (int i = 0; i <= 15; i++) {
		
	
	
	String mothertongue = BaseTest.getExcelData("Sheet4", 0, i);
	BaseTest.click(r.getMothertongue_btn());
	Thread.sleep(3000);
	BaseTest.typeData(r.getSearch_btn(), mothertongue);
	Thread.sleep(3000);
	BaseTest.click(r.getValue_select_btn());
	Thread.sleep(3000);
	String caste = BaseTest.getExcelData("Sheet3", 0, 8);
       
	Thread.sleep(3000); 
	BaseTest.typeData(r.getSearch_btn(), caste);
	Thread.sleep(3000);
	BaseTest.click(r.getValue_select_btn());
	Thread.sleep(3000);
    /*String MotherTongue = driver.findElement(By.xpath("//*[@id='reg_mothertongue_editText']")).getText();
    System.out.println(MotherTongue);
    */
	try {
		driver.findElement(By.xpath("//*[@id='reg_subcaste_editText']")).click();
	} catch (Exception e) {
		System.out.println("subcaste not avaialble");
	}
	Thread.sleep(3000);
	String subcaste = BaseTest.getExcelData("Sheet3", 0, 9);

	Thread.sleep(3000);
	BaseTest.typeData(r.getSearch_btn(), subcaste);
	Thread.sleep(3000);
	BaseTest.click(r.getValue_select_btn());
	Thread.sleep(3000);
	
    String MotherTongue = driver.findElement(By.xpath("//*[@id='reg_mothertongue_editText']")).getText();
    System.out.println(MotherTongue);
	
	
    Thread.sleep(10000);
	BaseTest.click(r.getContinue_btn());

	////////////////// 2nd PAge//////////////////////////
	Thread.sleep(10000);
	String marital_status = BaseTest.getExcelData("Sheet3", 0, 10);
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

			String chidren = BaseTest.getExcelData("Sheet3", 0, 11);

			Thread.sleep(3000);
			BaseTest.typeData(r.getSearch_btn(), chidren);
			Thread.sleep(3000);
			BaseTest.click(r.getValue_select_btn());
			Thread.sleep(3000);
			String chidren_status = BaseTest.getExcelData("Sheet3", 0, 12);

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
	String country = BaseTest.getExcelData("Sheet3", 0, 13);

	Thread.sleep(3000);
	BaseTest.typeData(r.getSearch_btn(), country);
	Thread.sleep(3000);
	BaseTest.click(r.getValue_select_btn());
	Thread.sleep(3000);

	Thread.sleep(3000);
	String state = BaseTest.getExcelData("Sheet3", 0, 14);

	Thread.sleep(3000);
	BaseTest.typeData(r.getSearch_btn(), state);
	Thread.sleep(3000);
	BaseTest.click(r.getValue_select_btn());
	Thread.sleep(3000);

	Thread.sleep(3000);
	String city = BaseTest.getExcelData("Sheet3", 0, 15);

	Thread.sleep(3000);
	BaseTest.typeData(r.getSearch_btn(), city);
	Thread.sleep(3000);
	BaseTest.click(r.getValue_select_btn());
	Thread.sleep(3000);
	try {
		//if (!country.equals("India")) {
			Thread.sleep(3000);
			String citizenship = BaseTest.getExcelData("Sheet3", 0, 16);

			Thread.sleep(3000);
			BaseTest.typeData(r.getSearch_btn(), citizenship);
			Thread.sleep(3000);
			BaseTest.click(r.getValue_select_btn());
			Thread.sleep(3000);
		//}
	} catch (Exception e) {
		System.out.println("By default citizenship is selected as India..........");
	}

	Thread.sleep(3000);
	String height = BaseTest.getExcelData("Sheet3", 0, 17);

	Thread.sleep(3000);
	BaseTest.typeData(r.getSearch_btn(), height);
	Thread.sleep(3000);
	BaseTest.click(r.getValue_select_btn());
	Thread.sleep(3000);

	Thread.sleep(3000);
	String education = BaseTest.getExcelData("Sheet3", 0, 18);

	Thread.sleep(3000);
	BaseTest.typeData(r.getSearch_btn(), education);
	Thread.sleep(3000);
	BaseTest.click(r.getValue_select_btn());
	Thread.sleep(3000);

	Thread.sleep(3000);
	String Employed = BaseTest.getExcelData("Sheet3", 0, 19);

	Thread.sleep(3000);
	BaseTest.typeData(r.getSearch_btn(), Employed);
	Thread.sleep(3000);
	BaseTest.click(r.getValue_select_btn());
	Thread.sleep(3000);

	Thread.sleep(3000);
	String occupation = BaseTest.getExcelData("Sheet3", 0, 20);

	Thread.sleep(3000);
	BaseTest.typeData(r.getSearch_btn(), occupation);
	Thread.sleep(3000);
	BaseTest.click(r.getValue_select_btn());
	Thread.sleep(3000);

	try {
		BaseTest.click(r.getCurrency_btn());

	} catch (Exception e) {
		// TODO: handle exception
	}
	
	  try {
	  
	  Thread.sleep(3000); String currency = BaseTest.getExcelData("Sheet3", 0, 21);
	  
	  Thread.sleep(3000); BaseTest.typeData(r.getSearch_btn(), currency);
	  Thread.sleep(3000); BaseTest.click(r.getValue_select_btn());
	  Thread.sleep(3000); } catch (Exception e) {
		  
		   }
	  
	/* 
	try {
		BaseTest.click(r.getSalary_btn());
	} catch (Exception e) {
		// TODO: handle exception
	}
*/
	Thread.sleep(3000);
	String annual_income = BaseTest.getExcelData("Sheet3", 0, 22);
	Thread.sleep(3000);
	//BaseTest.click(r.getSearch_btn());
	Thread.sleep(3000);
	BaseTest.typeData(r.getSearch_btn(), annual_income);
	// Thread.sleep(3000);
	BaseTest.click(r.getValue_select_btn());
	// Thread.sleep(3000);
	Thread.sleep(3000);
	driver.swipe(0, 800, 0, 0, 1000);
	Thread.sleep(3000);

	String physical_status = BaseTest.getExcelData("Sheet3", 0, 24);
	Thread.sleep(3000);
	if (physical_status.equalsIgnoreCase("Normal")) {
		Thread.sleep(3000);
		BaseTest.click(r.getNormal_btn());
		Thread.sleep(3000);
	} else if (physical_status.equalsIgnoreCase("physically Challenged")) {
		Thread.sleep(3000);
		BaseTest.click(r.getPhys_btn());
		Thread.sleep(3000);
	}
	//driver.swipe(0, 800, 0, 0, 1000);
	Thread.sleep(3000);
	String Family_staus = BaseTest.getExcelData("Sheet3", 0, 25);
	Thread.sleep(3000);
	if (Family_staus.equalsIgnoreCase("Middle Class")) {
		Thread.sleep(3000);
		BaseTest.click(r.getMiddleclass_btn());
		Thread.sleep(3000);

	} else if (Family_staus.equalsIgnoreCase("Upper Middle Class")) {
		Thread.sleep(3000);
		BaseTest.click(r.getUppermiddle_btn());
		Thread.sleep(3000);
	}

	else if (Family_staus.equalsIgnoreCase("Rich / Affluent")) {
		Thread.sleep(3000);
		BaseTest.click(r.getRich_btn());
		Thread.sleep(3000);
	}

	String Family_type = BaseTest.getExcelData("Sheet3", 0, 26);
	Thread.sleep(3000);
	if (Family_type.equalsIgnoreCase("Joint family")) {
		Thread.sleep(3000);
		BaseTest.click(r.getJoint_btn());
		Thread.sleep(3000);

	} else if (Family_type.equalsIgnoreCase("Nuclear family")) {
		Thread.sleep(3000);
		BaseTest.click(r.getNuclear_btn());
		Thread.sleep(3000);
	}
	driver.swipe(0, 800, 0, 0, 1000);
	Thread.sleep(3000);
	String family_value = BaseTest.getExcelData("Sheet3", 0, 27);
	Thread.sleep(3000);
	if (family_value.equalsIgnoreCase("Orthodox")) {
		Thread.sleep(3000);
		BaseTest.click(r.getOrthodox_btn());
		Thread.sleep(3000);

	} else if (family_value.equalsIgnoreCase("Traditional")) {
		Thread.sleep(3000);
		BaseTest.click(r.getTraditional_btn());
		Thread.sleep(3000);
	} else if (family_value.equalsIgnoreCase("Moderate")) {
		Thread.sleep(3000);
		BaseTest.click(r.getModerate_bnt());
		Thread.sleep(3000);
	} else if (family_value.equalsIgnoreCase("Liberal")) {
		Thread.sleep(3000);
		BaseTest.click(r.getLiberal_btn());
		Thread.sleep(3000);
	}

	Thread.sleep(3000);
	String gothram = BaseTest.getExcelData("Sheet3", 0, 23);

	Thread.sleep(3000);
	BaseTest.typeData(r.getSearch_btn(), gothram);
	Thread.sleep(3000);
	BaseTest.click(r.getValue_select_btn());
	Thread.sleep(3000);

	driver.swipe(0, 800, 0, 0, 1000);

	Thread.sleep(3000);
	BaseTest.click(r.getThirdrdpage_continue_btn());
	///////////////////// 4th page registration///////////////////

	String dosham = BaseTest.getExcelData("Sheet3", 0, 28);
	Thread.sleep(3000);
	if (dosham.equalsIgnoreCase("Yes")) {
		Thread.sleep(3000);
		BaseTest.click(r.getDosham_yes_btn());
		Thread.sleep(3000);
	} else if (dosham.equalsIgnoreCase("No")) {
		Thread.sleep(3000);
		BaseTest.click(r.getDosham_no_btn());
		Thread.sleep(3000);
	} else if (dosham.equalsIgnoreCase("Don't know")) {
		Thread.sleep(3000);
		BaseTest.click(r.getDosham_dontknow_btn());
		Thread.sleep(3000);
	}
	if (dosham.equals("Yes")) {
		List<AndroidElement> dosham1 = driver.findElements(By.xpath("//*[@id='refine_adapter_checkBox']"));
		int iSize1 = dosham1.size();
		System.out.println(iSize1);
		dosham1.get(new Random().nextInt(dosham1.size())).click();
		System.out.println("Selected the dosham");
		// driver.findElement(By.xpath("//*[@id='refine_adapter_checkBox']")).click();
		driver.findElement(By.xpath("//*[@id='search_ok_imageView']")).click();

	}

	try {
		if (driver.findElement(By.xpath("//*[@id='reg_star_textView']")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id='reg_star_textView']")).click();
		}
		
	} catch (Exception e) {
		System.out.println("star section not givenn seperately.........");
	}
	
	Thread.sleep(3000);
	//String star = BaseTest.getExcelData("Sheet3", 0, 29);
	Thread.sleep(3000);

		for (int j = 1; j <= 27; j++) {
			String star = BaseTest.getExcelData("Sheet4", j, i);
			System.out.println(star);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(star);
			Thread.sleep(5000);
			String star1 = driver.findElement(By.xpath("//*[@id='value_textView']")).getText();
			System.out.println(star1);
			if (star.equalsIgnoreCase(star1)) {
				System.out.println("star verified......");
				
			}
			else {
				System.out.println("Not verified.....");
			}
			}
		
	}}}
	/*String star = BaseTest.getExcelData("Sheet3", 0, 29);

	Thread.sleep(3000);
	BaseTest.typeData(r.getSearch_btn(), star);
	Thread.sleep(3000);
	BaseTest.click(r.getValue_select_btn());
	Thread.sleep(3000);
*/
	
	

//}
