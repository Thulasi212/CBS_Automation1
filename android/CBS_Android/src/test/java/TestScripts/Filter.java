package TestScripts;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

import org.apache.bcel.generic.BASTORE;
import org.apache.tools.ant.types.Assertions.BaseAssertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.RefineFilter;
import POM.Strictpp;

public class Filter extends BaseTest {
	private String reportDirectory = "reports";
	private String reportFormat = "xml";
	private String testName = "Untitled";
	protected AndroidDriver<AndroidElement> driver = null;
	String Country_profile;
	String State_profile;
	String City_profile;
	String Country;
	String Residing_State;
	String residing_city;
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

	@BeforeMethod
	public void login() throws Throwable {

		Strictpp s = new Strictpp(driver);

		Thread.sleep(10000);
		try {

			BaseTest.click(s.getChooseLogin());
		} catch (Exception e) {
			System.out.println("No Login Button Displayed");
		}

		Thread.sleep(10000);
		try {
			Thread.sleep(10000);
			BaseTest.click(s.getMatriId());
			BaseTest.typeData(s.getMatriId(), BaseTest.readValueFromExcelSheet().get(1).get("UserName"));
			Thread.sleep(10000);
			BaseTest.click(s.getPassword());
			BaseTest.typeData(s.getPassword(), BaseTest.readValueFromExcelSheet().get(1).get("PassWord"));
			Thread.sleep(10000);
			BaseTest.click(s.getIdLogin());
		} catch (Exception e) {
			System.out.println("Already Logged in");
		}

		Thread.sleep(10000);
		try {
			BaseTest.click(s.getQuick_Tour_Skip());
		} catch (Exception e) {
			System.out.println("The Tour Page Handled Successfully");
		}

		try {
			driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		} catch (Exception e) {
			System.out.println("No Tour page ");
		}

		Thread.sleep(10000);
		try {
			AndroidElement photo_skip = driver.findElement(By.xpath("//*[@id='doitlater']"));
			if (photo_skip.isDisplayed()) {
				photo_skip.click();
			}
		} catch (Exception e) {
			System.out.println("There is no photo page to handle");
		}

		Thread.sleep(10000);
		try {
			BaseTest.click(s.getQuick_response_popup());
		} catch (Exception e) {
			System.out.println("There is no Qucik Response Button");
		}

		Thread.sleep(10000);
		try {
			BaseTest.click(s.getNotification_access_later());
		} catch (Exception e) {
			System.out.println("There is no notification ");
		}

	}

	@Test(enabled = false)
	public void filterTest() throws Exception {
		RefineFilter f = new RefineFilter(driver);
		Thread.sleep(10000);
		BaseTest.click(f.getLatest_matches());

		Thread.sleep(10000);
		BaseTest.click(f.getRefine_filter());

		Thread.sleep(10000);
		BaseTest.click(f.getReset());

		Thread.sleep(10000);
		BaseTest.click(f.getMore());

		// **************************************** //Age - Edit the
		// Value*****************************************************
		Thread.sleep(10000);
		BaseTest.click(f.getAge());

		Thread.sleep(10000);
		BaseTest.click(f.getAge_Height_From_btn());

		Thread.sleep(10000);
		BaseTest.click(driver.findElement(By.xpath("//*[@text='24']")));

		Thread.sleep(10000);
		BaseTest.click(f.getAge_Height_to_btn());

		Thread.sleep(10000);
		BaseTest.click(driver.findElement(By.xpath("//*[@text='28']")));

		Thread.sleep(10000);
		BaseTest.click(f.getAge_Height_confirm_btn());

		String Age_details = f.getAge().getText();
		System.out.println(Age_details);

		String[] A = Age_details.split(":");
		String AA = A[1].toString().trim();

		String[] AAA = AA.split("to");
		String AB = AAA[0].toString().trim();
		String[] ABC = AB.split(" ");
		String Age_Fr = ABC[0].toString().trim();

		int Age_From = Integer.parseInt(Age_Fr);

		System.out.println("Age From - " + Age_From);

		String AABC = AAA[1].toString().trim();
		String[] ABAC = AABC.split(" ");
		String Age_t = ABAC[0].toString().trim();

		int Age_to = Integer.parseInt(Age_t);
		System.out.println("Age To" + Age_to);

		//////////////////////////////////////// *******Height - Edit
		//////////////////////////////////////// Value*******************//////////////////////////////

		Thread.sleep(10000);
		BaseTest.click(f.getHeight());

		Thread.sleep(10000);
		BaseTest.click(f.getAge_Height_From_btn());

		Thread.sleep(10000);
		BaseTest.click(driver.findElement(By.xpath("//*[@text='5ft 2in']")));

		Thread.sleep(10000);
		BaseTest.click(f.getAge_Height_to_btn());

		Thread.sleep(10000);
		BaseTest.click(driver.findElement(By.xpath("//*[@text='5ft 8in']")));

		Thread.sleep(10000);
		BaseTest.click(f.getAge_Height_confirm_btn());

		String Height_details = f.getHeight().getText();
		System.out.println(Height_details);

		String[] B = Height_details.split(":");
		String BA = B[1].toString().trim();

		String[] BAB = BA.split("to");
		String BABA = BAB[0].toString().trim();
		String BABB = BABA.replaceAll("[ftin]", "");
		String[] BAC = BABB.split(" ");
		String Height_fr = BAC[0] + "." + BAC[1];

		float Height_From = Float.parseFloat(Height_fr);
		System.out.println("Height From - " + Height_From);

		String ABAB = BAB[1].toString().trim();
		String BB = ABAB.replaceAll("[ftin]", "");
		String[] BC = BB.split(" ");
		String Height_t = BC[0] + "." + BC[1];

		float Height_to = Float.parseFloat(Height_t);
		System.out.println("Height to - " + Height_to);

		/////////////////////////////// ***********Marial
		/////////////////////////////// Status************/////////////////

		Thread.sleep(10000);
		BaseTest.click(f.getMarital_status());

		Thread.sleep(10000);
		BaseTest.click(f.getMarital_status_Unmarried_btn());

		Thread.sleep(10000);
		BaseTest.click(f.getAge_Height_confirm_btn());

		String Marital_details = f.getMarital_status().getText();
		System.out.println(Marital_details);

		String[] C = Marital_details.split(":");
		String Marital_status = C[1].toString().trim();

		System.out.println("Marital Status - " + Marital_status);

		///////////////////// ********************Mother
		///////////////////// Tongue***************/////////////////

		Thread.sleep(10000);
		BaseTest.click(f.getMother_tongue());

		Thread.sleep(10000);
		BaseTest.typeData(f.getSearch_btn(), BaseTest.readValueFromExcelSheet().get(1).get("MotherTongue"));

		Thread.sleep(10000);
		BaseTest.click(f.getSearch_value_choose_btn());

		Thread.sleep(10000);
		BaseTest.click(f.getAge_Height_confirm_btn());

		String Mother_tongue_details = f.getMother_tongue().getText();
		System.out.println(Mother_tongue_details);

		String[] D = Mother_tongue_details.split(":");
		String Mother_Tongue = D[1].toString().trim();
		System.out.println(Mother_Tongue);
		if (Mother_Tongue.contains(",")) {
			String[] DA = Mother_Tongue.split(",");
			String DB = DA[0].toString().trim();
			System.out.println(DB);
			String DC = DA[1].toString().trim();
			System.out.println(DC);

		} else {
			System.out.println("Only Mother Tongue Present");
		}

		////////////////////////////////////////// ****************************//////////////////////////

		Thread.sleep(10000);
		BaseTest.click(f.getApply());

		Thread.sleep(10000);
		String profile_detail = driver.findElement(By.xpath("//*[@id='profileDesc']")).getText();

		System.out.println(profile_detail);

		Thread.sleep(10000);
		String[] AZ = profile_detail.split(",");
		String Ag = AZ[0].toString();
		String[] aage = Ag.split(" ");
		String agee = aage[0].toString().trim();
		int AGE = Integer.parseInt(agee);
		System.out.println("Age - " + AGE);

		Thread.sleep(10000);
		String[] H = AZ[1].split("/");
		String He = H[0].toString().trim();
		System.out.println("Height -" + He);

		String Hei = He.replaceAll("[ftin]", "");
		System.out.println(Hei);

		String[] Heig = Hei.split("  ");
		String heighT = Heig[0] + "." + Heig[1];
		float HEIGHT = Float.parseFloat(heighT);
		System.out.println("Height - " + HEIGHT);

		/*
		 * Thread.sleep(10000); String[] marital = H[1].split(","); // need to check //
		 * Condition to split with "," or with #space System.out.println(marital);
		 * String marita_status = marital[2].toString().trim();
		 * System.out.println("Marital Status - " + marita_status);
		 */

		//////////////// Verify /////////////////

		Thread.sleep(10000);
		if (AGE == Age_From || AGE <= Age_to) {
			System.out.println("Age" + AGE + " is Between" + Age_From + "and" + Age_to);
		} else {
			System.out.println("Age" + AGE + " is not Between" + Age_From + "and" + Age_to);
		}

		Thread.sleep(10000);
		if (HEIGHT == Height_From || HEIGHT <= Height_to) {
			System.out.println("Height" + HEIGHT + " is Between" + Height_From + "and" + Height_to);
		} else {
			System.out.println("Height" + HEIGHT + " is not Between" + Height_From + "and" + Height_to);
		}

		/*
		 * if (marita_status.equalsIgnoreCase(Marital_status)) {
		 * 
		 * System.out.println("The Marital Status Matched");
		 * 
		 * } else {
		 * 
		 * System.out.println("The Marital Status not  Matched");
		 * 
		 * }
		 */

	}

	@Test
	public void filterViewProfile() throws Exception {

		RefineFilter f = new RefineFilter(driver);
		Thread.sleep(10000);
		BaseTest.click(f.getLatest_matches());

		Thread.sleep(10000);
		BaseTest.click(f.getRefine_filter());

		Thread.sleep(10000);
		BaseTest.click(f.getReset());

		Thread.sleep(10000);
		BaseTest.click(f.getMore());

		// **************************************** //Age - Edit the
		// Value*****************************************************
		Thread.sleep(10000);
		BaseTest.click(f.getAge());

		Thread.sleep(10000);
		BaseTest.click(f.getAge_Height_From_btn());

		Thread.sleep(10000);
		BaseTest.click(driver.findElement(By.xpath("//*[@text='23']")));

		Thread.sleep(10000);
		BaseTest.click(f.getAge_Height_to_btn());

		Thread.sleep(10000);
		BaseTest.click(driver.findElement(By.xpath("//*[@text='28']")));

		Thread.sleep(10000);
		BaseTest.click(f.getAge_Height_confirm_btn());

		String Age_details = f.getAge().getText();
		System.out.println(Age_details);

		String[] A = Age_details.split(":");
		String AA = A[1].toString().trim();

		String[] AAA = AA.split("to");
		String AB = AAA[0].toString().trim();
		String[] ABC = AB.split(" ");
		String Age_Fr = ABC[0].toString().trim();

		int Age_From = Integer.parseInt(Age_Fr);

		System.out.println("Age From - " + Age_From);

		String AABC = AAA[1].toString().trim();
		String[] ABAC = AABC.split(" ");
		String Age_t = ABAC[0].toString().trim();

		int Age_to = Integer.parseInt(Age_t);
		System.out.println("Age To" + Age_to);

		//////////////////////////////////////// *******Height - Edit
		//////////////////////////////////////// Value*******************//////////////////////////////

		Thread.sleep(10000);
		BaseTest.click(f.getHeight());

		Thread.sleep(10000);
		BaseTest.click(f.getAge_Height_From_btn());

		Thread.sleep(10000);
		BaseTest.click(driver.findElement(By.xpath("//*[@text='5ft 2in']")));

		Thread.sleep(10000);
		BaseTest.click(f.getAge_Height_to_btn());

		Thread.sleep(10000);
		BaseTest.click(driver.findElement(By.xpath("//*[@text='5ft 8in']")));

		Thread.sleep(10000);
		BaseTest.click(f.getAge_Height_confirm_btn());

		String Height_details = f.getHeight().getText();
		System.out.println(Height_details);

		String[] B = Height_details.split(":");
		String BA = B[1].toString().trim();

		String[] BAB = BA.split("to");
		String BABA = BAB[0].toString().trim();
		String BABB = BABA.replaceAll("[ftin]", "");
		String[] BAC = BABB.split(" ");
		String Height_fr = BAC[0] + "." + BAC[1];

		float Height_From = Float.parseFloat(Height_fr);
		System.out.println("Height From - " + Height_From);

		String ABAB = BAB[1].toString().trim();
		String BB = ABAB.replaceAll("[ftin]", "");
		String[] BC = BB.split(" ");
		String Height_t = BC[0] + "." + BC[1];

		float Height_to = Float.parseFloat(Height_t);
		System.out.println("Height to - " + Height_to);

		/////////////////////////////// ***********Marial
		/////////////////////////////// Status************/////////////////

		Thread.sleep(10000);
		BaseTest.click(f.getMarital_status());

		Thread.sleep(10000);
		BaseTest.click(f.getMarital_status_Unmarried_btn());

		Thread.sleep(10000);
		BaseTest.click(f.getAge_Height_confirm_btn());

		String Marital_details = f.getMarital_status().getText();
		System.out.println(Marital_details);

		String[] C = Marital_details.split(":");
		String Marital_status = C[1].toString().trim();

		System.out.println("Marital Status - " + Marital_status);

		///////////////////// ********************Mother
		///////////////////// Tongue***************/////////////////

		Thread.sleep(10000);
		BaseTest.click(f.getMother_tongue());

		Thread.sleep(10000);
		BaseTest.typeData(f.getSearch_btn(), BaseTest.readValueFromExcelSheet().get(1).get("MotherTongue"));

		Thread.sleep(10000);
		BaseTest.click(f.getSearch_value_choose_btn());

		Thread.sleep(10000);
		BaseTest.click(f.getAge_Height_confirm_btn());

		String Mother_tongue_details = f.getMother_tongue().getText();
		System.out.println(Mother_tongue_details);

		String[] D = Mother_tongue_details.split(":");
		String Mother_Tongue = D[1].toString().trim();
		System.out.println(Mother_Tongue);
		if (Mother_Tongue.contains(",")) {
			String[] DA = Mother_Tongue.split(",");
			String DB = DA[0].toString().trim();
			System.out.println(DB);
			String DC = DA[1].toString().trim();
			System.out.println(DC);

		} else {
			System.out.println("Only Mother Tongue Present");
		}

		///////////////////////// *************Country*****************///////////////////////

		Thread.sleep(10000);
		BaseTest.click(f.getCountry());

		Thread.sleep(10000);
		BaseTest.typeData(f.getSearch_btn(), BaseTest.readValueFromExcelSheet().get(1).get("Country"));

		Thread.sleep(10000);
		BaseTest.click(f.getSearch_value_choose_btn());

		Thread.sleep(10000);
		BaseTest.click(f.getSearch_value_choose_btn());

		Thread.sleep(10000);
		BaseTest.click(f.getAge_Height_confirm_btn());

		Thread.sleep(10000);
		String Country_details = f.getCountry().getText();
		System.out.println("Country - " + Country_details);

		String[] E = Country_details.split(":");
		String Country = E[1].toString().trim();
		System.out.println(Country);

		if (Country.contains(",")) {
			String[] EB = Country.split(",");
			String EC = EB[0].toString().trim();
			System.out.println(EC);
			String ED = EB[1].toString().trim();
			System.out.println(ED);

		} else {
			System.out.println("Only One country Present");

		}

		//////////////////// ***********Residing State****************///////////////

		if (f.getStar().isDisplayed()) {

			Thread.sleep(10000);
			BaseTest.click(f.getState());

			Thread.sleep(10000);
			BaseTest.typeData(f.getSearch_btn(), BaseTest.readValueFromExcelSheet().get(1).get("ResidingState"));

			Thread.sleep(10000);
			BaseTest.click(f.getSearch_value_choose_btn());

			Thread.sleep(10000);
			BaseTest.click(f.getAge_Height_confirm_btn());

			Thread.sleep(10000);
			String State_details = f.getState().getText();
			System.out.println(State_details);

			String[] F = State_details.split(":");
			String Residing_State = F[1].toString().trim();
			System.out.println("Residing State - " + Residing_State);

			if (Residing_State.contains(",")) {
				String[] FA = Residing_State.split(",");
				String FB = FA[0].toString().trim();
				System.out.println(FB);

				String FC = FA[1].toString().trim();
				System.out.println(FC);

			} else {
				System.out.println("Only one state present");
			}

		} else {
			System.out.println("Residing States Not Present");
		}

		////////////////////////// ***********Residing City*************
		////////////////////////// ////////////////

		if (f.getCity().isDisplayed()) {

			Thread.sleep(10000);
			BaseTest.click(f.getCity());

			Thread.sleep(10000);
			BaseTest.typeData(f.getSearch_btn(), BaseTest.readValueFromExcelSheet().get(1).get("IndianCity"));

			Thread.sleep(10000);
			BaseTest.click(f.getSearch_value_choose_btn());

			Thread.sleep(10000);
			BaseTest.click(f.getAge_Height_confirm_btn());

			String G = f.getCity().getText();
			System.out.println(G);
			String[] GA = G.split(":");
			String residing_city = GA[1].toString().trim();
			System.out.println("Residing City - " + residing_city);

			if (residing_city.contains(",")) {
				String[] FA = residing_city.split(",");
				String FB = FA[0].toString().trim();
				System.out.println(FB);

				String FC = FA[1].toString().trim();
				System.out.println(FC);

			} else {

				System.out.println("Only one Residing City Present");
			}

		} else {

			System.out.println("Residing City Not Present");
		}

		///////////////////////////////////// ***** Education
		///////////////////////////////////// ***********///////////////////////

		//////////////////// View Profile Verification /////////////////////////

		Thread.sleep(10000);
		BaseTest.click(f.getApply());

		Thread.sleep(10000);
		String profile_detail = driver.findElement(By.xpath("//*[@id='profileDesc']")).getText();

		System.out.println(profile_detail);

		Thread.sleep(10000);
		try {
			BaseTest.click(driver.findElement(By.xpath(
					"(//*[@id='recyclerview']/*/*/*/*/*[@id='profileDesc' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]])[1]")));
		} catch (Exception e) {
			System.out.println("No matches found");
		}

		Thread.sleep(10000);
		driver.scrollToExact("Basic Details");

		Thread.sleep(10000);
		driver.swipe(0, 300, 0, 0, 1000);

		Thread.sleep(10000);
		WebElement Profile_Age = driver.findElement(By.xpath(
				"((//*[@id='basicdetail_dynamicinfo']/*[@class='android.widget.LinearLayout'])[1]/*[@text and @class='android.widget.TextView' and @width>0 and @height>0])[3]"));
		String AZ = Profile_Age.getText();
		System.out.println(A);
		// String[] Age_pro = A.split(":");
		// String Age_Prof = Age_pro[1].toString().trim();
		String[] Age_profie = AZ.split(" ");
		String Age_pr = Age_profie[0].toString().trim();
		int Age_Profile = Integer.parseInt(Age_pr);
		System.out.println(Age_Profile);

		Thread.sleep(10000);
		WebElement Profile_Height = driver.findElement(By.xpath(
				"((//*[@id='basicdetail_dynamicinfo']/*[@class='android.widget.LinearLayout'])[5]/*[@text and @class='android.widget.TextView' and @width>0 and @height>0])[3]"));
		String BZ = Profile_Height.getText();
		System.out.println(B);
		// String[] Hei_Profile = B.split(":");
		// String Heigh_Profile = Hei_Profile[1].toString().trim();
		// System.out.println(Heigh_Profile);
		String Height_Prof = BZ.replaceAll("[ftin]", "");
		System.out.println(Height_Prof);
		String[] Height_Profi = Height_Prof.split("  ");
		String Height_Profil = Height_Profi[0] + "." + Height_Profi[1];
		System.out.println(Height_Profil);

		float Height_Profile = Float.parseFloat(Height_Profil);
		System.out.println(Height_Profile);

		Thread.sleep(10000);
		WebElement Profile_marital_status = driver.findElement(By.xpath(
				"((//*[@id='basicdetail_dynamicinfo']/*[@class='android.widget.LinearLayout'])[7]/*[@text and @class='android.widget.TextView' and @width>0 and @height>0])[3]"));
		String Marital_status_Profile = Profile_marital_status.getText();
//   		System.out.println(C);
		// String[] profile_marital = C.split(":");
		// String Marital_status_Profile = profile_marital[1].toString().trim();
		System.out.println(Marital_status_Profile);

		Thread.sleep(10000);
		WebElement Profile_Physical_status = driver.findElement(By.xpath(
				"((//*[@id='basicdetail_dynamicinfo']/*[@class='android.widget.LinearLayout'])[10]/*[@text and @class='android.widget.TextView' and @width>0 and @height>0])[3]"));
		String Physical_status_Profile = Profile_Physical_status.getText();
		// System.out.println(D);
		// String[] Physical_Status = D.split(":");
		// String Physical_status_Profile = Physical_Status[1].toString().trim();
		System.out.println(Physical_status_Profile);

		Thread.sleep(10000);
		WebElement Profile_Mother_tongue = driver.findElement(By.xpath(
				"((//*[@id='basicdetail_dynamicinfo']/*[@class='android.widget.LinearLayout'])[8]/*[@text and @class='android.widget.TextView' and @width>0 and @height>0])[3]"));
		String Mother_Tongue_Profile = Profile_Mother_tongue.getText();
		// System.out.println(E);
		// String[] Mother_tongue_pro = E.split(":");
		// String Mother_Tongue_Profile = Mother_tongue_pro[1].toString().trim();
		System.out.println(Mother_Tongue_Profile);

		/////////////////////////////////////

		Thread.sleep(10000);
		driver.scrollToExact("LOCATION");
		Thread.sleep(10000);
		if (driver.findElement(By.xpath(
				"((//*[@id='location_dynamicinfo']/*[@class='android.widget.LinearLayout'])[2]/*[@text and @width>0 and @height>0])[3]"))
				.isDisplayed()) {

			String Country_profile = driver.findElement(By.xpath(
					"((//*[@id='location_dynamicinfo']/*[@class='android.widget.LinearLayout'])[2]/*[@text and @width>0 and @height>0])[3]"))
					.getText();
			System.out.println(Country_profile);

		} else {
			System.out.println("No Country Displayed");

		}
		Thread.sleep(10000);
		if (driver.findElement(By.xpath(
				"((//*[@id='location_dynamicinfo']/*[@class='android.widget.LinearLayout'])[4]/*[@text and @width>0 and @height>0])[3]"))
				.isDisplayed()) {

			String State_profile = driver.findElement(By.xpath(
					"((//*[@id='location_dynamicinfo']/*[@class='android.widget.LinearLayout'])[2]/*[@text and @width>0 and @height>0])[3]"))
					.getText();
			System.out.println(State_profile);

		} else {
			System.out.println("No Country Displayed");

		}

		Thread.sleep(10000);
		if (driver.findElement(By.xpath(
				"((//*[@id='location_dynamicinfo']/*[@class='android.widget.LinearLayout'])[3]/*[@text and @width>0 and @height>0])[3]"))
				.isDisplayed()) {

			String City_profile = driver.findElement(By.xpath(
					"((//*[@id='location_dynamicinfo']/*[@class='android.widget.LinearLayout'])[2]/*[@text and @width>0 and @height>0])[3]"))
					.getText();
			System.out.println(City_profile);

		} else {
			System.out.println("No Country Displayed");

		}

/////////////////////////////////// ******Verification Process*********  /////////////////
		Thread.sleep(10000);
		if (Age_Profile == Age_From || Age_Profile <= Age_to) {
			System.out.println("Age" + Age_Profile + " is Between" + Age_From + "and" + Age_to);
		} else {
			System.out.println("Age" + Age_Profile + " is not Between" + Age_From + "and" + Age_to);
		}

		Thread.sleep(10000);
		if (Height_Profile == Height_From || Height_Profile <= Height_to) {
			System.out.println("Height" + Height_Profile + " is Between" + Height_From + "and" + Height_to);
		} else {
			System.out.println("Height" + Height_Profile + " is not Between" + Height_From + "and" + Height_to);
		}

		if (Mother_Tongue.contains(Mother_Tongue_Profile)) {

			System.out.println("Mother Tongue Matched");

		} else {

			System.out.println("Mother Tongue note Matched");

		}

		if (Country_profile.contains(Mother_Tongue_Profile)) {

			System.out.println("Mother Tongue Matched");

		} else {

			System.out.println("Mother Tongue not Matched");

		}

		if (State_profile.contains(Residing_State)) {

			System.out.println("State Matched");

		} else {

			System.out.println("State not Matched");

		}

		if (City_profile.contains(residing_city)) {

			System.out.println("City Matched");

		} else {

			System.out.println("City not Matched");

		}

	}

	@AfterTest
	public void tearDown() {
		// driver.quit();
	}
}