package TestScriptsBrahmin;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;

import org.jsoup.Connection.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.QuickRes;
import POM.Strictpp;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class StrictFilter extends BaseTest {

	private String reportDirectory = "reports";
	private String reportFormat = "xml";
	private String testName = "Untitled";
	protected AndroidDriver<AndroidElement> driver = null;
	Dimension size;
	int starty;
	int endy;
	int startx;
	String description;

	DesiredCapabilities dc = new DesiredCapabilities();

	@BeforeTest
	public void setUp() throws MalformedURLException {
		   dc.setCapability("reportDirectory", reportDirectory);
	        dc.setCapability("reportFormat", reportFormat);
	        dc.setCapability("testName", testName);
	        dc.setCapability(MobileCapabilityType.UDID, "21d9e22c");
	        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.community.matrimony");
	        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.domaininstance.ui.activities.Splash");
	        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
	        driver.setLogLevel(Level.INFO);




	}

	@BeforeMethod
	public void loginTest() throws Exception {
		Strictpp s = new Strictpp(driver);

		try {
		  Thread.sleep(5000); 
		  BaseTest.click(s.getChooseLogin()); 
		  Thread.sleep(5000);
		  BaseTest.click(s.getMatriId());
		  BaseTest.typeData(s.getMatriId(),
		  BaseTest.readValueFromExcelSheet().get(1).get("UserName"));
		  Thread.sleep(5000); 
		  BaseTest.click(s.getPassword());
		  BaseTest.typeData(s.getPassword(),
		  BaseTest.readValueFromExcelSheet().get(1).get("PassWord"));
		  
		  Thread.sleep(5000); 
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

		Thread.sleep(5000);
		try {
			AndroidElement photo_skip = driver.findElement(By.xpath("//*[@id='doitlater']"));
			if (photo_skip.isDisplayed()) {
				photo_skip.click();
			}
		} catch (Exception e) {
			System.out.println("There is no photo page to handle");
		}

		Thread.sleep(5000);
		try {
			BaseTest.click(s.getQuick_response_popup());
		} catch (Exception e) {
			System.out.println("There is no Qucik Response Button");
		}

		Thread.sleep(5000);
		try {
			BaseTest.click(s.getNotification_access_later());
		} catch (Exception e) {
			System.out.println("There is no notification ");
		}

	}

	@Test(priority=1)
	public void strictPP() throws Exception {

		Strictpp s = new Strictpp(driver);
//	
//
//		Thread.sleep(5000);
//		BaseTest.click(s.getChooseLogin());
//		Thread.sleep(5000);
//		BaseTest.click(s.getMatriId());
//		BaseTest.typeData(s.getMatriId(), BaseTest.readValueFromExcelSheet().get(1).get("UserName"));
//		Thread.sleep(5000);
//		BaseTest.click(s.getPassword());
//		BaseTest.typeData(s.getPassword(), BaseTest.readValueFromExcelSheet().get(1).get("PassWord"));
//
//		Thread.sleep(5000);
//		BaseTest.click(s.getIdLogin());  
//		Thread.sleep(10000);
//		try {
//			BaseTest.click(s.getQuick_Tour_Skip());
//		} catch (Exception e) {
//			System.out.println("The Tour Page Handled Successfully");
//		}
//		
//		 try {
//				driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
//			} catch (Exception e) {
//				System.out.println("No Tour page ");
//			}
//		 
//
//		Thread.sleep(5000);
//		try {
//			AndroidElement photo_skip = driver.findElement(By.xpath("//*[@id='doitlater']"));
//			if (photo_skip.isDisplayed()) {
//				photo_skip.click();
//			}
//		} catch (Exception e) {
//			System.out.println("There is no photo page to handle");
//		}
//		
//		 Thread.sleep(5000);
//			try {
//				BaseTest.click(s.getQuick_response_popup());
//			} catch (Exception e) {
//				System.out.println("There is no Qucik Response Button");
//			}
//			
//
//			 Thread.sleep(5000);
//				try {
//					BaseTest.click(s.getNotification_access_later());
//				} catch (Exception e) {
//					System.out.println("There is no notification ");
//				}  

		Thread.sleep(5000);
		BaseTest.click(s.getMenu_button());

		Thread.sleep(5000);
		BaseTest.click(s.getEdit_partner_preference());

		Thread.sleep(5000);
		BaseTest.click(s.getStrict_filter());

		Thread.sleep(5000);
		WebElement Age = driver.findElement(By.xpath("//*[@id='llStrictItem' and @height>0 and ./*[@text='Age']]"));
		String a = Age.getText();
		System.out.println(a);

		// List<AndroidElement> basic = driver.findElements(By.xpath("//*[@text='Basic
		// Preference']"));
		// for (int i = 0; i < basic.size(); i++) {
		WebElement age = driver.findElement(By.xpath("(//*[@id='switchOnOFF'])"));
		if (driver.findElement(By.xpath("//*[@text='OFF']")).isEnabled()) {

			BaseTest.click(s.getStrict_filter_OFF());

		} else {

			System.out.println("Filter was Already Applied");

		}

		Thread.sleep(5000);
		WebElement height = driver.findElement(By.xpath("(//*[@id='switchOnOFF'])"));

		if (driver.findElement(By.xpath("//*[@text='OFF']")).isEnabled()) {

			BaseTest.click(s.getStrict_filter_OFF());

		} else {

			System.out.println("Filter was Already Applied");

		}

		Thread.sleep(5000);
		WebElement marital_status = driver.findElement(By.xpath("(//*[@id='switchOnOFF'])"));

		if (driver.findElement(By.xpath("//*[@text='OFF']")).isEnabled()) {

			BaseTest.click(s.getStrict_filter_OFF());

		} else {

			System.out.println("Filter was Already Applied");

		}

		Thread.sleep(5000);
		WebElement Mothertongue = driver.findElement(By.xpath("(//*[@id='switchOnOFF'])"));

		if (driver.findElement(By.xpath("//*[@text='OFF']")).isEnabled()) {

			BaseTest.click(s.getStrict_filter_OFF());

		} else {

			System.out.println("Filter was Already Applied");

		}

		Thread.sleep(5000);
		WebElement physical_status = driver.findElement(By.xpath("(//*[@id='switchOnOFF'])"));

		if (driver.findElement(By.xpath("//*[@text='OFF']")).isEnabled()) {

			BaseTest.click(s.getStrict_filter_OFF());

		} else {

			System.out.println("Filter was Already Applied");

		}

		Thread.sleep(5000);
		String Age_details = driver
				.findElement(By.xpath("(//*[@id='recyclerStrictFilter']/*/*/*/*[@id='txtValue' and @height>0])[1]"))
				.getText();
		System.out.println("Age - " + Age_details);
		String[] Age_split = Age_details.split("-");
		String Age_From = Age_split[0].toString().trim();
		int Age_from = Integer.parseInt(Age_From);
		System.out.println(Age_from);
		float Agefrom1 = Float.parseFloat(Age_From);

		String[] Age_split2 = Age_split[1].split("Yrs");
		String Age_To = Age_split2[0].toString().trim();
		int Age_to = Integer.parseInt(Age_To);
		System.out.println(Age_to);

		Thread.sleep(5000);
		String height_details = driver
				.findElement(By.xpath("(//*[@id='recyclerStrictFilter']/*/*/*/*[@id='txtValue' and @height>0])[2]"))
				.getText();
		System.out.println("Height - " + height_details);

		String[] Height_split = height_details.split("-");
		String Height_From = Height_split[0].toString().trim();
		System.out.println(Height_From);
		String Height_To = Height_split[1].toString().trim();
		System.out.println(Height_To);
		String Height_f = Height_From.replaceAll("[ftin]", "");
		System.out.println(Height_f.trim());
		String[] Heightfrr = Height_f.split("  ");
		String Height_frr = Heightfrr[0] + "." + Heightfrr[1];
		// String Height_fr = Height_f.replaceAll("[ ]", ".");
		float height_from = Float.parseFloat(Height_frr);
		System.out.println("Height From - " + height_from);

		String Height_t = Height_To.replaceAll("[ftin]", "");
		String[] Height_tr = Height_t.split("  ");
		String Height_trr = Height_tr[0] + "." + Height_tr[1];
		float height_to = Float.parseFloat(Height_trr);
		System.out.println("Height To - " + height_to);

		Thread.sleep(5000);
		String marital_status_details = driver
				.findElement(By.xpath("(//*[@id='recyclerStrictFilter']/*/*/*/*[@id='txtValue' and @height>0])[3]"))
				.getText();
		System.out.println("Marital Status - " + marital_status_details);

		Thread.sleep(5000);
		BaseTest.click(s.getStrict_filter_submit());

		Thread.sleep(5000);
		BaseTest.click(s.getStrict_back_btn());

		// Thread.sleep(5000);
		// BaseTest.click(s.getStrict_back_btn());

		Thread.sleep(5000);
		BaseTest.click(s.getMatches());

		Thread.sleep(5000);
		if (s.getProfile_matri_id().isDisplayed()) {

			description = s.getProfile_description().getText();
			System.out.println(description);
			// driver.findElement(By.xpath("//*[@id='profileDesc']"))
		} else {

			System.out.println("No Profile to Check the Applied Strict Filter");
		}

		Thread.sleep(5000);
		String[] A = description.split(",");
		String Ag = A[0].toString();
		String[] aage = Ag.split(" ");
		String agee = aage[0].toString().trim();
		int AGE = Integer.parseInt(agee);
		System.out.println("Age - " + AGE);

		Thread.sleep(5000);
		String[] H = A[1].split("/");
		String He = H[0].toString().trim();
		System.out.println("Height -" + He);

		String Hei = He.replaceAll("[ftin]", "");
		System.out.println(Hei);

		String[] Heig = Hei.split("  ");
		String heighT = Heig[0] + "." + Heig[1];
		float HEIGHT = Float.parseFloat(heighT);
		System.out.println("Height - " + HEIGHT);

		Thread.sleep(5000);
		String[] marital = H[1].split(marital_status_details); // need to check // Condition to split with "," or with #space
		System.out.println(marital);
		String marita_status = marital[0].toString().trim();
		System.out.println("Marital Status - " + marita_status);

		Thread.sleep(5000);
		if (AGE == Age_from || AGE <= Age_to) {
			System.out.println("Age" + AGE + " is Between" + Age_from + "and" + Age_to);
		} else {
			System.out.println("Age" + AGE + " is not Between" + Age_from + "and" + Age_to);
		}

		Thread.sleep(5000);
		if (HEIGHT == height_from || HEIGHT <= height_to) {
			System.out.println("Height" + HEIGHT + " is Between" + height_from + "and" + height_to);
		} else {
			System.out.println("Height" + HEIGHT + " is not Between" + height_from + "and" + height_to);
		}

		if (marital_status_details.equalsIgnoreCase(marita_status)) {

			System.out.println("The Marital Status Matched");

		} else {

			System.out.println("The Marital Status not  Matched");

		}

		if (Age_from == AGE || Age_to <= AGE) {

		} else {

		}

	}

	@Test(priority=2)
	public void strictPP2() throws InterruptedException {

		Strictpp s = new Strictpp(driver);

		Thread.sleep(5000);
		BaseTest.click(s.getMenu_button());

		Thread.sleep(5000);
		BaseTest.click(s.getEdit_partner_preference());

		Thread.sleep(5000);
		BaseTest.click(s.getStrict_filter());

		Thread.sleep(5000);
		driver.scrollToExact("Religious Preference");

		// Thread.sleep(5000);
		// BaseTest.click(s.getStrict_filter_OFF());

		if (driver.findElement(By.xpath("//*[@text='OFF']")).isEnabled()) {

			BaseTest.click(s.getStrict_filter_OFF());

		} else {

			System.out.println("Filter was Already Applied");

		}

		if (driver.findElement(By.xpath("//*[@text='OFF']")).isEnabled()) {

			BaseTest.click(s.getStrict_filter_OFF());

		} else {

			System.out.println("Filter was Already Applied");

		}

		if (driver.findElement(By.xpath("//*[@text='OFF']")).isEnabled()) {

			BaseTest.click(s.getStrict_filter_OFF());

		} else {

			System.out.println("Filter was Already Applied");

		}
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////
		Thread.sleep(5000);
		String Age_details = driver
				.findElement(By.xpath("(//*[@id='recyclerStrictFilter']/*/*/*/*[@id='txtValue' and @height>0])[1]"))
				.getText();
		System.out.println("Age - " + Age_details);
		String[] Age_split = Age_details.split("-");
		String Age_From = Age_split[0].toString().trim();
		int Age_from = Integer.parseInt(Age_From);
		System.out.println(Age_from);
		float Agefrom1 = Float.parseFloat(Age_From);

		String[] Age_split2 = Age_split[1].split("Yrs");
		String Age_To = Age_split2[0].toString().trim();
		int Age_to = Integer.parseInt(Age_To);
		System.out.println(Age_to);

		Thread.sleep(5000);
		String height_details = driver
				.findElement(By.xpath("(//*[@id='recyclerStrictFilter']/*/*/*/*[@id='txtValue' and @height>0])[2]"))
				.getText();
		System.out.println("Height - " + height_details);

		String[] Height_split = height_details.split("-");
		String Height_From = Height_split[0].toString().trim();
		System.out.println(Height_From);
		String Height_To = Height_split[1].toString().trim();
		System.out.println(Height_To);
		String Height_f = Height_From.replaceAll("[ftin]", "");
		System.out.println(Height_f.trim());
		String[] Heightfrr = Height_f.split("  ");
		String Height_frr = Heightfrr[0] + "." + Heightfrr[1];
		// String Height_fr = Height_f.replaceAll("[ ]", ".");
		float height_from = Float.parseFloat(Height_frr);
		System.out.println("Height From - " + height_from);

		String Height_t = Height_To.replaceAll("[ftin]", "");
		String[] Height_tr = Height_t.split("  ");
		String Height_trr = Height_tr[0] + "." + Height_tr[1];
		float height_to = Float.parseFloat(Height_trr);
		System.out.println("Height To - " + height_to);

		Thread.sleep(5000);
		String marital_status_details = driver
				.findElement(By.xpath("(//*[@id='recyclerStrictFilter']/*/*/*/*[@id='txtValue' and @height>0])[3]"))
				.getText();
		System.out.println("Marital Status - " + marital_status_details);
		
		Thread.sleep(5000);
		String Mother_Tongue = driver.findElement(By.xpath("(//*[@id='recyclerStrictFilter']/*/*/*[@id='rlValue' and @height>0])[4]")).getText();
		System.out.println("Mother Tongue - "+Mother_Tongue);
		
		Thread.sleep(5000);
		String Physical_Status1 = driver.findElement(By.xpath("(//*[@id='recyclerStrictFilter']/*/*/*[@id='rlValue' and @height>0])[5]")).getText();
		
		System.out.println("Physical Status _ "+Physical_Status1);
		////////////////////////////////////////////////////////////////////////////////////////////////

		Thread.sleep(5000);
		BaseTest.click(s.getStrict_filter_submit());

		Thread.sleep(5000);
		BaseTest.click(s.getStrict_back_btn());

		Thread.sleep(5000);
		BaseTest.click(driver.findElement(By.xpath("//*[@id='icon' and ./parent::*[@id='tab_home']]")));
		
		Thread.sleep(5000);
		BaseTest.click(s.getLatest_matches());

		Thread.sleep(5000);
		if (s.getProfile_matri_id().isDisplayed()) {

			description = s.getProfile_description().getText();
			System.out.println(description);
//	 driver.findElement(By.xpath("//*[@id='profileDesc']"))
		} else {

			System.out.println("No Profile to Check the Applied Strict Filter");
		}
    
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@id='recyclerview']/*/*/*/*[@class='android.widget.RelativeLayout' and @height>0 and (./preceding-sibling::* | ./following-sibling::*)[@height>0] and ./*[@id='lldateSupport']])[1]")).click();
		
		Thread.sleep(5000);
		driver.scrollToExact("Basic Details");
		
		Thread.sleep(5000);
		driver.swipe(0, 300, 0, 0, 1000);
		
		Thread.sleep(5000);
		WebElement Profile_Age = driver.findElement(By.xpath("((//*[@id='basicdetail_dynamicinfo']/*[@class='android.widget.LinearLayout'])[1]/*[@text and @class='android.widget.TextView' and @width>0 and @height>0])[3]"));
		String A = Profile_Age.getText();
		System.out.println(A);
	//	String[] Age_pro = A.split(":");
	//	String Age_Prof = Age_pro[1].toString().trim();
		String[] Age_profie = A.split(" ");
		String Age_pr = Age_profie[0].toString().trim();
		int Age_Profile = Integer.parseInt(Age_pr);
		System.out.println(Age_Profile);
		
		Thread.sleep(5000);
		WebElement Profile_Height = driver.findElement(By.xpath("((//*[@id='basicdetail_dynamicinfo']/*[@class='android.widget.LinearLayout'])[5]/*[@text and @class='android.widget.TextView' and @width>0 and @height>0])[3]"));
		String B = Profile_Height.getText();
		System.out.println(B);
	//	String[] Hei_Profile = B.split(":");
	//	String Heigh_Profile = Hei_Profile[1].toString().trim();
	//	System.out.println(Heigh_Profile);
		String Height_Prof = B.replaceAll("[ftin]", "");
		System.out.println(Height_Prof);
		String[] Height_Profi = Height_Prof.split("  ");
		String Height_Profil = Height_Profi[0]+"."+Height_Profi[1];
		System.out.println(Height_Profil);
		
		float Height_Profile = Float.parseFloat(Height_Profil);
		System.out.println(Height_Profile);
		
		Thread.sleep(5000);
		WebElement Profile_marital_status = driver.findElement(By.xpath("((//*[@id='basicdetail_dynamicinfo']/*[@class='android.widget.LinearLayout'])[7]/*[@text and @class='android.widget.TextView' and @width>0 and @height>0])[3]"));
		String Marital_status_Profile = Profile_marital_status.getText();
//		System.out.println(C);
		//String[] profile_marital = C.split(":");
	//	String Marital_status_Profile = profile_marital[1].toString().trim();
		System.out.println(Marital_status_Profile);
		
		Thread.sleep(5000);
		WebElement Profile_Physical_status = driver.findElement(By.xpath("((//*[@id='basicdetail_dynamicinfo']/*[@class='android.widget.LinearLayout'])[10]/*[@text and @class='android.widget.TextView' and @width>0 and @height>0])[3]"));
		String Physical_status_Profile= Profile_Physical_status.getText();
	//	System.out.println(D);
	//	String[] Physical_Status = D.split(":");
	//	String Physical_status_Profile = Physical_Status[1].toString().trim();
		System.out.println(Physical_status_Profile);
		
		Thread.sleep(5000);
		WebElement Profile_Mother_tongue = driver.findElement(By.xpath("((//*[@id='basicdetail_dynamicinfo']/*[@class='android.widget.LinearLayout'])[8]/*[@text and @class='android.widget.TextView' and @width>0 and @height>0])[3]"));
		String Mother_Tongue_Profile= Profile_Mother_tongue.getText();
	//	System.out.println(E);
	//	String[] Mother_tongue_pro = E.split(":");
	//	String Mother_Tongue_Profile = Mother_tongue_pro[1].toString().trim();
		System.out.println(Mother_Tongue_Profile);
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	Thread.sleep(5000);
	if (Age_Profile == Age_from || Age_Profile <= Age_to) {
		System.out.println("Age" + Age_Profile + " is Between" + Age_from + "and" + Age_to);
	} else {
		System.out.println("Age" + Age_Profile + " is not Between" + Age_from + "and" + Age_to);
	}

	Thread.sleep(5000);
	if (Height_Profile == height_from || Height_Profile <= height_to) {
		System.out.println("Height" + Height_Profile + " is Between" + height_from + "and" + height_to);
	} else {
		System.out.println("Height" + Height_Profile + " is not Between" + height_from + "and" + height_to);
	}

	if (Marital_status_Profile.equalsIgnoreCase(marital_status_details)) {

		System.out.println("The Marital Status Matched");

	} else {

		System.out.println("The Marital Status not  Matched");

	}
	
	if (Physical_status_Profile.equalsIgnoreCase(marital_status_details)) {

		System.out.println("The Physical_status Matched");

	} else {

		System.out.println("ThePhysical_status not  Matched");

	}
	
	if (Mother_Tongue_Profile.contains(Mother_Tongue)) {

		System.out.println("The Mother_Tongue  Matched");

	} else {

		System.out.println("The Mother_Tongue  not  Matched");

	}
	
	
	Thread.sleep(5000);
	BaseTest.click(s.getStrict_back_btn());
	
	
	Thread.sleep(5000);
	BaseTest.click(s.getMenu_button());
	
	Thread.sleep(5000);
	driver.swipe(0, 1000, 0, 0, 1000);
	Thread.sleep(5000);
	BaseTest.click(s.getAccount_settings());
	
	Thread.sleep(5000);
	BaseTest.click(s.getLogout());
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	@AfterTest
	public void endTest() {
		//driver.quit();

	}

}
