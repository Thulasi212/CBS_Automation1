package TestScriptsBrahmin;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.DashBoardPom;
import POM.EdipPartnerPP;
import POM.Login;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class DashBoard_Proifle_Completness extends BaseTest {
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
	}

	@BeforeMethod
	public void login() throws InterruptedException {
		Login s = new Login(driver);

		try {
			Thread.sleep(5000);
			BaseTest.click(s.getChooseLogin());
			Thread.sleep(5000);
			BaseTest.click(s.getMatriId());
			BaseTest.typeData(s.getMatriId(), BaseTest.readValueFromExcelSheet().get(1).get("UserName"));
			Thread.sleep(5000);
			BaseTest.click(s.getPassword());
			BaseTest.typeData(s.getPassword(), BaseTest.readValueFromExcelSheet().get(1).get("PassWord"));

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

	@Test(enabled = false)
	public void Add_prefrences() throws Exception {

		EdipPartnerPP p = new EdipPartnerPP(driver);

		Thread.sleep(5000);
		BaseTest.click(driver.findElement(By.xpath("//*[@text='Add Preferences")));

		Thread.sleep(5000);
		BaseTest.click(p.getEdit_pp_basicdetails_btn());

		/*
		 * Thread.sleep(5000); BaseTest.click(p.getPartner_marital_status());
		 * 
		 * Thread.sleep(5000);
		 * BaseTest.click(p.getPartner_marital_status_doesnt_matter());
		 * 
		 * 
		 * Thread.sleep(5000); BaseTest.click(p.getPartner_marital_status_confirmbtn());
		 */

		// Age Details

		Thread.sleep(5000);
		BaseTest.click(p.getPartner_age_from_btn());

		Thread.sleep(5000);
		// BaseTest.click(driver.findElement(By.xpath("//*[@text='20']")));
		BaseTest.typeData(p.getPartner_search_btn(), BaseTest.readValueFromExcelSheet().get(1).get("AgeFrom"));
		BaseTest.click(p.getPartner_search_value_click());

		Thread.sleep(5000);
		BaseTest.click(p.getPartner_age_To_btn());

		Thread.sleep(5000);
		// BaseTest.click(driver.findElement(By.xpath("//*[@text='27']")));
		BaseTest.typeData(p.getPartner_search_btn(), BaseTest.readValueFromExcelSheet().get(1).get("AgeTo"));
		BaseTest.click(p.getPartner_search_value_click());

		//// Height

		Thread.sleep(5000);
		BaseTest.click(p.getPartner_Height_from_btn());

		Thread.sleep(5000);
		// BaseTest.click(driver.findElement(By.xpath("//*[@text='4ft 11in']")));
		// BaseTest.click1(BaseTest.readValueFromExcelSheet().get(1).get("AgeFrom"));
		BaseTest.typeData(p.getPartner_search_btn(), BaseTest.readValueFromExcelSheet().get(1).get("HeightFrom"));
		BaseTest.click(p.getPartner_search_value_click());

		Thread.sleep(5000);
		BaseTest.click(p.getPartner_Height_To_btn());
		BaseTest.typeData(p.getPartner_search_btn(), BaseTest.readValueFromExcelSheet().get(1).get("HeightTo"));
		BaseTest.click(p.getPartner_search_value_click());

		// Thread.sleep(5000);
		// driver.swipe(0, 800, 0, 0, 1000);
		// BaseTest.click(driver.findElement(By.xpath("//*[@text='5ft 6in']")));

		// Mother Tongue

		Thread.sleep(5000);
		BaseTest.click(p.getPartner_mother_tongue_btn());
		Thread.sleep(5000);
		BaseTest.typeData(p.getPartner_search2_btn(), BaseTest.readValueFromExcelSheet().get(1).get("MotherTongue"));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='refine_adapter_checkBox']")).click();
		// BaseTest.click(p.getPartner_search_value_click());
		BaseTest.click(p.getPartner_marital_status_confirmbtn());

		// Physical Status

		Thread.sleep(5000);
		BaseTest.click(p.getPartner_physical_status_btn());
		Thread.sleep(5000);
		BaseTest.click(driver.findElement(By.xpath("//*[@text='Normal' and @id='refine_adapter_checkBox']")));
		Thread.sleep(5000);
		BaseTest.click(p.getPartner_marital_status_confirmbtn());

		Thread.sleep(5000);
		BaseTest.click(p.getEditt_Pp_save_btn());

		try {

			Thread.sleep(20000);
			// driver.scrollToExact("PARTNER PREFERENCES");
			driver.swipe(0, 2000, 0, 0, 1000);
			driver.swipe(0, 2000, 0, 0, 1000);
			driver.swipe(0, 500, 0, 0, 1000);
			Thread.sleep(5000);
			BaseTest.click(p.getPartner_releigious_prefe_btn());
			// Releigious Preference
			Thread.sleep(5000);
			BaseTest.click(p.getPartner_subcaste_btn());

			Thread.sleep(5000);
			BaseTest.click(driver.findElement(By.xpath("//*[@text='Any' and @id='refine_adapter_checkBox']")));

			Thread.sleep(5000);
			BaseTest.click(p.getPartner_marital_status_confirmbtn());

			Thread.sleep(5000);
			BaseTest.click(p.getPartner_star_btn());

			Thread.sleep(5000);
			BaseTest.typeData(p.getPartner_search2_btn(), BaseTest.readValueFromExcelSheet().get(1).get("Star"));

			Thread.sleep(5000);
			BaseTest.click(driver.findElement(By.xpath("//*[@id='refine_adapter_checkBox']")));

			Thread.sleep(5000);
			BaseTest.click(p.getPartner_marital_status_confirmbtn());

			Thread.sleep(5000);
			BaseTest.click(p.getPartner_Dosham_btn());

			Thread.sleep(5000);
			BaseTest.click(driver.findElement(By.xpath("//*[@text=concat('Don', \"'\", 't Know')]")));

			Thread.sleep(5000);
			BaseTest.click(p.getEditt_Pp_save_btn());

			/////////////////////////////////////////////////////////////////////////

			Thread.sleep(20000);
			// save bttoun needs to be click
			driver.swipe(0, 2000, 0, 0, 1000);
			driver.swipe(0, 2000, 0, 0, 1000);
			driver.swipe(0, 800, 0, 0, 1000);

			Thread.sleep(5000);
			BaseTest.click(p.getPartner_professional_btn());

			Thread.sleep(5000);
			BaseTest.click(p.getPartner_education_btn());

			Thread.sleep(5000);
			BaseTest.typeData(p.getPartner_search2_btn(), BaseTest.readValueFromExcelSheet().get(1).get("Education"));

			Thread.sleep(5000);
			BaseTest.click(driver.findElement(By.xpath("//*[@id='refine_adapter_checkBox']")));

			Thread.sleep(5000);
			BaseTest.click(p.getPartner_marital_status_confirmbtn());

			Thread.sleep(5000);
			BaseTest.click(p.getPartner_occupation_btn());

			Thread.sleep(5000);
			BaseTest.typeData(p.getPartner_search2_btn(), BaseTest.readValueFromExcelSheet().get(1).get("Occupation"));

			Thread.sleep(5000);
			BaseTest.click(driver.findElement(By.xpath("//*[@id='refine_adapter_checkBox']")));

			Thread.sleep(5000);
			BaseTest.click(p.getPartner_marital_status_confirmbtn());

			Thread.sleep(5000);
			BaseTest.click(p.getPartner_annual_INcome_btn());

			Thread.sleep(5000);
			BaseTest.typeData(p.getPartner_search_btn(), BaseTest.readValueFromExcelSheet().get(1).get("AnnualIncome"));

			Thread.sleep(5000);
			BaseTest.click(p.getPartner_search_value_click());

			Thread.sleep(5000);
			BaseTest.click(p.getPartner_Annual_Income_Value_btn());

			Thread.sleep(5000);
			BaseTest.typeData(p.getPartner_search_btn(),
					BaseTest.readValueFromExcelSheet().get(1).get("AnnualIncome2"));

			Thread.sleep(5000);
			BaseTest.click(p.getPartner_search_value_click());

			// click save button
			Thread.sleep(5000);
			BaseTest.click(p.getEditt_Pp_save_btn());

			//////////////////////////////////////////////////////////////////////////////////////////
			
			Thread.sleep(20000);
	    	driver.swipe(0, 2000, 0, 0, 1000);
	    	driver.swipe(0, 2000, 0, 0, 1000);
	    	driver.swipe(0, 1200, 0, 0, 1000);
	    	
	    	//Locarion Preferences
	   Thread.sleep(5000);
	   BaseTest.click(p.getPartner_location_btn());
	   
	   Thread.sleep(5000);
	   BaseTest.click(p.getPartner_country_btn());
	   
	   Thread.sleep(5000);
	   BaseTest.typeData(p.getPartner_search2_btn(), BaseTest.readValueFromExcelSheet().get(1).get("Country"));
	    
	   Thread.sleep(5000);
	   BaseTest.click(driver.findElement(By.xpath("(//*[@id='refine_adapter_checkBox'])[2]")));
	   
	   
		Thread.sleep(5000);
		BaseTest.click(p.getPartner_marital_status_confirmbtn());
		
		Thread.sleep(5000);
		BaseTest.click(p.getPartner_citizenship_btn());
		
		Thread.sleep(5000);
		BaseTest.typeData(p.getPartner_search2_btn(), BaseTest.readValueFromExcelSheet().get(1).get("Citizen"));
		
		
	   Thread.sleep(5000);
	   BaseTest.click(driver.findElement(By.xpath("(//*[@id='refine_adapter_checkBox'])[2]")));
	  
		Thread.sleep(5000);
		BaseTest.click(p.getPartner_marital_status_confirmbtn());
		
		
		
		
		
		try {
			Thread.sleep(5000);
			BaseTest.click(p.getPartner_residing_state());
			
			Thread.sleep(5000);
			BaseTest.typeData(p.getPartner_search2_btn(), BaseTest.readValueFromExcelSheet().get(1).get("ResidingState"));
			
			Thread.sleep(5000);
			BaseTest.click(driver.findElement(By.xpath("//*[@id='refine_adapter_checkBox']")));
			

			Thread.sleep(5000);
			BaseTest.click(p.getPartner_marital_status_confirmbtn());
		} catch (Exception e) {
			System.out.println("Residing Not Belongs to India");
		}
		

		
		} catch (Exception e) {
                 System.out.println("The page was landed in Dashboard");
		}

	}
	
	

	@Test (enabled=false)
	public void profile_Awaiting_response() throws InterruptedException {

		DashBoardPom d = new DashBoardPom(driver);
		try {
			Thread.sleep(10000);
			if ((d.getProfile_awaiting()).isEnabled()) {

				String Matri_ID = d.getMatriID().getText();
				System.out.println("Matri ID - " + Matri_ID);

				Thread.sleep(10000);
				if (d.getAccept().isEnabled()) {

					BaseTest.click(d.getAccept());

					Thread.sleep(10000);

					BaseTest.click(d.getAccept_popup_close());

				} else {

					System.out.println("Accept Button is not Displayed");
				}

				Thread.sleep(10000);
				if (d.getShortlist().isEnabled()) {

					BaseTest.click(d.getShortlist());
				} else {

					System.out.println("There is no Profile To SHortlist");
				}

				Thread.sleep(10000);

				if (d.getShortlisted_profile().isEnabled()) {

					System.out.println("The Profile was Already Shortlisted");

				} else {

					System.out.println("There is no profile to shortlist");
				}

				Thread.sleep(10000);
				if (d.getDecline().isEnabled()) {
					BaseTest.click(d.getDecline());

					Thread.sleep(10000);
					BaseTest.click(d.getDecline_confirm_btn());

					Thread.sleep(10000);
					BaseTest.click(d.getAccept_popup_close());

				} else {
					System.out.println("There is no profile to decline");
				}

			} else {
				System.out.println("There is no Profile Awaiting Response");
			}

		} catch (Exception e) {
			System.out.println("There is no Profile Awaiting Response");
		}

	}

	@Test (enabled=false)
	public void photo_request() throws InterruptedException {

		DashBoardPom d = new DashBoardPom(driver);
		try {
			Thread.sleep(10000);
			if (d.getPhoto_request().isEnabled()) {

				if (d.getAdd_Photo().isEnabled()) {

					Thread.sleep(5000);
					BaseTest.click(d.getAdd_Photo());

					Thread.sleep(5000);
					BaseTest.click(d.getAdd_Photo_folder());

					Thread.sleep(5000);
					BaseTest.click(d.getTake_picture());

					Thread.sleep(10000);
					BaseTest.click(d.getCamera_click());

					Thread.sleep(10000);
					BaseTest.click(d.getPhoto_confirm());
					System.out.println("The photo Captured and Uploaded");

				} else {

					System.out.println("The Photo was Already added");

				}

			}

			Thread.sleep(10000);
			if (d.getPhoto_request().isEnabled()) {

				if (d.getAdd_Photo().isEnabled()) {

					Thread.sleep(5000);
					BaseTest.click(d.getAdd_Photo());

					Thread.sleep(5000);
					BaseTest.click(d.getAdd_Photo_folder());

					Thread.sleep(5000);
					BaseTest.click(d.getChoose_galeery());

					Thread.sleep(5000);
					BaseTest.click(d.getPhoto_());

					Thread.sleep(5000);
					BaseTest.click(d.getPhoto_from_gallery());
				} else {

					System.out.println("There is no Photo Request received");
				}
			}

		} catch (Exception e) {

			System.out.println("There is no Photo Request received");
		}

	}
	
	
	
	@Test
	public void accepted_Matches() {
	
		DashBoardPom d = new DashBoardPom(driver);
		
		try {
			if (driver.findElements(By.xpath("//*[@text='Accepted Matches']")).size()!=0) {
				
				Thread.sleep(5000);
				String Matri_IDs = d.getMatriID().getText();
				System.out.println("The Accepted Matches ID - " + Matri_IDs);
				
				if (d.getAccepted_matches_upgrade().isEnabled()) {
					
					Thread.sleep(5000);
					BaseTest.click(d.getAccepted_matches_upgrade());

					Thread.sleep(5000);
					if (driver.findElement(By.xpath("//*[@text='Upgrade Now' and @width>0]")).isEnabled()) {
						
						System.out.println("The Page Landed on Payment");
						
						Thread.sleep(5000);
						BaseTest.click(driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")));
					
						try {
						Thread.sleep(5000);
						BaseTest.click(driver.findElement(By.xpath("//*[@text='NOT NOW']")));
						} catch (Exception e) { e.getMessage();}
						
						
					} else {
						
						System.out.println("Already Upgraded");
					}
					
					
				} else {
					
					System.out.println("There is Now Upgrade Button to upgrade");

				}
				
				
			} else {
				
				System.out.println("There is no Accepted matches");

			}
		} catch (Exception e) {
			
			System.out.println("There is no Accepted matches");
		}

	}

	@AfterTest
	public void tearDown() {
		// driver.quit();
	}
}