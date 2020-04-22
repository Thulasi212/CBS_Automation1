package TestScriptsBrahmin;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;

import org.apache.tools.ant.filters.TokenFilter.Trim;
import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.Search;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class RegularSearch {

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
		dc.setCapability(MobileCapabilityType.UDID, "21d9e22c");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.community.matrimony");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.domaininstance.ui.activities.Splash");
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
		driver.setLogLevel(Level.INFO);
String replace="";
	}

	@Test
	public void regularSearchTest() throws InterruptedException, AWTException {

		Search s = new Search(driver);

		try {
		  Thread.sleep(5000); BaseTest.click(s.getChooseLogin());
		  
		  Thread.sleep(5000); BaseTest.click(s.getMatriId());
		  
		  Thread.sleep(5000); BaseTest.typeData(s.getMatriId(),
		  BaseTest.readValueFromExcelSheet().get(1).get("UserName"));
		 
		  Thread.sleep(5000); BaseTest.click(s.getPassword());
		  
		  Thread.sleep(5000); BaseTest.typeData(s.getPassword(),
		  BaseTest.readValueFromExcelSheet().get(1).get("PassWord"));
		  
		  Thread.sleep(5000); BaseTest.click(s.getIdLogin());
		} catch
		 (Exception e) { System.out.println("Already Logged In"); }	  
		  
		  Thread.sleep(10000); try { BaseTest.click(s.getQuick_Tour_Skip()); } catch
		 (Exception e) { System.out.println("The Tour Page Handled Successfully"); }
		  
		 
		  Thread.sleep(5000); try { AndroidElement photo_skip =
		  driver.findElement(By.xpath("//*[@id='doitlater']")); if
		  (photo_skip.isDisplayed()) { photo_skip.click(); } } catch (Exception e) {
		  System.out.println("There is no photo page to handle"); }
		 

		Thread.sleep(5000);
		try {
			BaseTest.click(s.getQuick_response_popup());
		} catch (Exception e) {
			System.out.println("The Quick Response page handled Successfully");
		}

		try {
			driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();;
		} catch (Exception e) {
			System.out.println("No Tour page ");
		}
    	
		
		Thread.sleep(5000);
		try {
			BaseTest.click(s.getNotification_access_later());
		} catch (Exception e) {
			System.out.println("Notification handled");
		}

		try {
			Alert a = driver.switchTo().alert();
			a.dismiss();

		} catch (Exception e) {
			System.out.println("No alert To Handle");
		}

		Thread.sleep(5000);
		BaseTest.click(s.getSearch_btn());

/*		Thread.sleep(5000);
		BaseTest.click(s.getSearch_age());
		Thread.sleep(5000);
		BaseTest.click(s.getSearch_age_Height_from());
		Thread.sleep(5000);
		BaseTest.click(driver.findElement(By.xpath("//*[@text='19']")));
		Thread.sleep(5000);
		BaseTest.click(s.getSearch_age_Height_to());
		Thread.sleep(5000);
		BaseTest.click(driver.findElement(By.xpath("//*[@text='26']")));
		Thread.sleep(5000);
		BaseTest.click(s.getSearch_confirm_btn());

		Thread.sleep(5000);
		BaseTest.click(s.getSearch_Height());
		Thread.sleep(5000);
		BaseTest.click(s.getSearch_age_Height_from());
		Thread.sleep(5000);
		BaseTest.click(driver.findElement(By.xpath("//*[@text='5ft 1in']")));
		Thread.sleep(5000);
		BaseTest.click(s.getSearch_age_Height_to());
		Thread.sleep(5000);
		BaseTest.click(driver.findElement(By.xpath("//*[@text='5ft 7in']")));
		Thread.sleep(5000);
		BaseTest.click(s.getSearch_confirm_btn());

		Thread.sleep(5000);
		BaseTest.click(s.getSearch_marital_status());

		Thread.sleep(5000);
		BaseTest.click(s.getMarital_status_Unmarried());

		Thread.sleep(5000);
		BaseTest.click(s.getSearch_confirm_btn());  */

		Thread.sleep(5000);
		BaseTest.click(s.getSearch_now_btn());
		
		
		Thread.sleep(5000);
		String Age = driver.findElement(By.xpath("(//*[@id='txt_title'])[1]")).getText();
		System.out.println(Age);
		
		Thread.sleep(5000);
		String Height = driver.findElement(By.xpath("(//*[@id='txt_title'])[2]")).getText();
		System.out.println(Height);
		
		Thread.sleep(5000);
		String Marital_status = driver.findElement(By.xpath("(//*[@id='txt_title'])[3]")).getText();
		System.out.println(Marital_status);
		
		
		///Split the reguar search #key VALUE Age, Height , Marital Status
		Thread.sleep(5000);
		String[] A = Age.split("to");
		String Ag = A[0].toString();
		String[] aG = Ag.split(":");
		String AgeFrom = aG[1].toString();	
		System.out.println("Age From = " + AgeFrom);
	//	float AgeFrom1 = Float.parseFloat(AgeFrom);
	//	int ageFrom = Integer.parseInt(AgeFrom);
		String AgeTo =A[1].toString();
		System.out.println("Age To = " + AgeTo);
 //       float AgeTo1 = Float.parseFloat(AgeTo);
  //      int ageTo = Integer.parseInt(AgeTo);
		//////
        Thread.sleep(5000);
		String[] H = Height.split("to");
		String He = H[0].toString();
		String[] Hei = He.split(":");
		String HeightFrom = Hei[1].toString();
		System.out.println("Height From = " + HeightFrom);
	//	float HeightFrom1 = Float.parseFloat(HeightFrom);
	//	int HeightFrom2 = Integer.parseInt(HeightFrom);
		String HeightTo = H[1].toString();
		System.out.println("Height To = " + HeightTo);
	//	float HeightTo1 = Float.parseFloat(HeightTo);
	//	int HeightTo2 = Integer.parseInt(HeightTo);
		
		Thread.sleep(5000);
		/// Checking ID's Match
		String matri_id = driver.findElement(By.xpath("//*[@id='profileMatriId']")).getText();
		System.out.println("Matri ID = " + matri_id);
		System.out.println(s.getMatri_Id().getText());
		
		Thread.sleep(5000);
		String Description = driver.findElement(By.xpath("(//*[@id='recyclerview']/*/*/*/*/*[@id='profileDesc' and @height>0 and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]])[1]")).getText(); 
		System.out.println("Description" + Description);
	/*	String[] a = Description.split(",");
		for (int i = 2; i < a.length; i++) {
			
			String Agg = a[i].toString();
			if(Agg.endsWith(",")) {
				String replace = Agg.replace(",", "");
				System.out.println(replace);
			}else {
			System.out.println(Agg);
		}*/
		Thread.sleep(5000);
		String[] a = Description.split(",");
		String Agg = a[0].toString();
		System.out.println(Agg);
	//	float agg1 = Float.parseFloat(Agg);
	//	int agg2 = Integer.parseInt(Agg);
		String[] hh = a[1].split("/");
		String height1 = hh[0].toString();
		String Height11=height1.trim();
		System.out.println(Height11);
	//	float height11 = Float.parseFloat(height1);
	//	int height22 = Integer.parseInt(height1);
	/*	String[] other = hh[1].split(",");
		String aa= other[0].toString();
		System.out.println(aa);
		String[] abc = a[1].split("Unmarried");
		String bbc = abc[0].toString();
		System.out.println(bbc);
		String bb = abc[1].toString();
		System.out.println(bb);
		String cc = abc[2].toString();
		System.out.println(cc);
		String dd =abc[3].toString();
		System.out.println(dd);
		////String ee = abc[4].toString();
		//System.out.println(ee);   */
		
		Thread.sleep(5000);
	/*	if (ageFrom==agg2 ||  ageTo>=agg2) {
			
			System.out.println("The Age " +agg2+" is between " +ageFrom+" and "+ ageTo);
			
		} else {
			System.out.println("The Age " +agg2+" is not between " +ageFrom+" and "+ ageTo);
		}
		
		Thread.sleep(5000);
		if (HeightFrom2==height22 || HeightTo2>=height22) {
			
			System.out.println("The Height " +height22+" is between " +HeightFrom2+" and "+ HeightTo2);
		} else {
			System.out.println("The Height " +height22+" is between " +HeightFrom2+" and "+ HeightTo2);
		}
	*/    if (Agg.matches("18 yrs|19 yrs|20 yrs|21 yrs|22 yrs|23 yrs|24 yrs|25 yrs|26 yrs|27 yrs|28 yrs|29 yrs|30yrs")) {
		System.out.println("True");
	} else {
       System.out.println("False");
	}

	 if (Height11.matches("4ft 11in|4ft 5in|4ft 6in|4ft 7in|4ft 8in|4ft 9in|4ft 10in|5ft|5ft 1in|5ft 2in|5ft 3in|5ft 4in|5ft 5in|5ft 6in|5ft 7in|5ft 8in|5ft 9in|5ft 10in|5ft 11in|4 ft 5 in|4 ft 6 in|4 ft 7 in|4 ft 8 in|4 ft 9 in|4 ft 10 in|4 ft 11 in|5 ft|5 ft 1 in|5 ft 2 in|5 ft 3 in|5 ft 4 in|5 ft 5 in|5 ft 6 in|5 ft 7 in|5 ft 8 in|5 ft 9 in|5 ft 10 in|5 ft 11 in")) {
			System.out.println("True");
		} else {
	       System.out.println("False");
		}

	
	
	}

	@AfterTest
	public void tearDown() {

		// driver.quit();
	}

}
