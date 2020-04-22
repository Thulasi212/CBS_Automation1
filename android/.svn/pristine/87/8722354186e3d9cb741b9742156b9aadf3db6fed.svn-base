package TestScriptsBrahmin;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.jsoup.Connection.Base;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.EdipPartnerPP;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class EditPP extends BaseTest{
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

    @Test
    public void editPartner() throws InterruptedException {
    	
    	EdipPartnerPP p = new EdipPartnerPP(driver);
    	try {
    	Thread.sleep(5000);
    	BaseTest.click(p.getChoose_login());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getMatriId());
    	
    	Thread.sleep(5000);
    	BaseTest.typeData(p.getMatriId(), BaseTest.readValueFromExcelSheet().get(1).get("UserName"));
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getPasword());
    	
    	Thread.sleep(5000);
    	BaseTest.typeData(p.getPasword(), BaseTest.readValueFromExcelSheet().get(1).get("PassWord"));
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getEnter_login());
    	} catch (Exception e) {
			System.out.println("Already Logged In");
		}
    	Thread.sleep(10000);
    	try {
			BaseTest.click(p.getSkip_tour());
		} catch (Exception e) {
			System.out.println("The Tour Page Handled Successfully");
		}
    	
    	 try {
 			driver.findElement(By.xpath("//*[@contentDescription='Navigate up']"));
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
			BaseTest.click(p.getQuick_reponse());
		} catch (Exception e) {
			System.out.println("The Quick Response page handled Successfully");
		}
    	Thread.sleep(5000);
    	try {
			BaseTest.click(p.getNotification_access());
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
    	BaseTest.click(p.getMenu_btn());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getEdit_pp_button());  
    	
    	
    	/*Thread.sleep(5000);
    	BaseTest.click(p.getAbout_my_partner_btn());
    	
     	Thread.sleep(5000);
       BaseTest.typeData(p.getAbout_my_partner_description(), BaseTest.readValueFromExcelSheet().get(1).get("AboutPartner"));
      	
    Thread.sleep(5000);
    BaseTest.click(p.getEditt_Pp_save_btn());*/
    	
    	//Thread.sleep(9000);
    	//BaseTest.click(p.getPartner_prefer_tab());
    	
     	Thread.sleep(5000);
    	BaseTest.click(p.getEdit_pp_basicdetails_btn());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getPartner_marital_status());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getPartner_marital_status_doesnt_matter());
    	
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getPartner_marital_status_confirmbtn());
    	
    	//Age Details
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getPartner_age_from_btn());
    	
    	Thread.sleep(5000);
    	//BaseTest.click(driver.findElement(By.xpath("//*[@text='20']")));
    	BaseTest.typeData(p.getPartner_search_btn(), BaseTest.readValueFromExcelSheet().get(1).get("AgeFrom"));
    	BaseTest.click(p.getPartner_search_value_click());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getPartner_age_To_btn());
    	
    	Thread.sleep(5000);
    	//BaseTest.click(driver.findElement(By.xpath("//*[@text='27']")));
    	BaseTest.typeData(p.getPartner_search_btn(), BaseTest.readValueFromExcelSheet().get(1).get("AgeTo"));
    	BaseTest.click(p.getPartner_search_value_click());  
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getPartner_Height_from_btn());
    	
    	Thread.sleep(5000);
    	//BaseTest.click(driver.findElement(By.xpath("//*[@text='4ft 11in']")));
    	//BaseTest.click1(BaseTest.readValueFromExcelSheet().get(1).get("AgeFrom"));
    	BaseTest.typeData(p.getPartner_search_btn(), BaseTest.readValueFromExcelSheet().get(1).get("HeightFrom"));
    	BaseTest.click(p.getPartner_search_value_click());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getPartner_Height_To_btn());
    	BaseTest.typeData(p.getPartner_search_btn(), BaseTest.readValueFromExcelSheet().get(1).get("HeightTo"));
    	BaseTest.click(p.getPartner_search_value_click());
    	
    	Thread.sleep(5000);
    	//driver.swipe(0, 800, 0, 0, 1000);
    //	BaseTest.click(driver.findElement(By.xpath("//*[@text='5ft 6in']")));
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getPartner_mother_tongue_btn());
    	Thread.sleep(5000);
    	BaseTest.typeData(p.getPartner_search2_btn(), BaseTest.readValueFromExcelSheet().get(1).get("MotherTongue"));
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("//*[@id='refine_adapter_checkBox']")).click();
    	//BaseTest.click(p.getPartner_search_value_click());
    	BaseTest.click(p.getPartner_marital_status_confirmbtn());
    	Thread.sleep(5000);
    	BaseTest.click(p.getPartner_physical_status_btn());
    	Thread.sleep(5000);
    	BaseTest.click(driver.findElement(By.xpath("//*[@text='Normal' and @id='refine_adapter_checkBox']")));
    	Thread.sleep(5000);
    	BaseTest.click(p.getPartner_marital_status_confirmbtn());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getEditt_Pp_save_btn());  
    	//save button needs to be clicked
    	
     	Thread.sleep(20000);
    	//driver.scrollToExact("PARTNER PREFERENCES");
    	driver.swipe(0, 2000, 0, 0, 1000);
    	driver.swipe(0, 2000, 0, 0, 1000);
    	driver.swipe(0, 500, 0, 0, 1000);
    	Thread.sleep(5000);
    	BaseTest.click(p.getPartner_releigious_prefe_btn());
    	//Releigious Preference
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
    	
    	Thread.sleep(20000);
    	//save bttoun needs to be click
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
    	BaseTest.typeData(p.getPartner_search_btn(), BaseTest.readValueFromExcelSheet().get(1).get("AnnualIncome2"));
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getPartner_search_value_click());
    	
    	
    	//click save button
    	Thread.sleep(5000);
    	BaseTest.click(p.getEditt_Pp_save_btn());  
    	
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
	
	
	//Thread.sleep(5000);
//	BaseTest.typeData(p.getPartner_search2_btn(), BaseTest.readValueFromExcelSheet().get(1).get("ResidingState"));
	
	//Thread.sleep(5000);
	//BaseTest.click(driver.findElement(By.xpath("//*[@id='refine_adapter_checkBox']")));
	

	//Thread.sleep(5000);
	//BaseTest.click(p.getPartner_marital_status_confirmbtn());
	
	
	Thread.sleep(5000);
	try {
		BaseTest.click(driver.findElement(By.xpath("//*[@id='edit_txt_partner_resident_usa_state_value']")));
		Thread.sleep(5000);
		BaseTest.typeData(p.getPartner_search2_btn(), BaseTest.readValueFromExcelSheet().get(1).get("USAState"));
		Thread.sleep(5000);
		BaseTest.click(driver.findElement(By.xpath("//*[@id='refine_adapter_checkBox']")));
		Thread.sleep(5000);
		BaseTest.click(p.getPartner_marital_status_confirmbtn());
	} catch (Exception e) {
		System.out.println("Residing Not Belongs to USA");
	}
	
	try {
		BaseTest.click(driver.findElement(By.xpath("//*[@id='edit_txt_partner_resident_indian_city_value']")));
		Thread.sleep(5000);
		BaseTest.typeData(p.getPartner_search2_btn(), BaseTest.readValueFromExcelSheet().get(1).get("IndianCity"));
		Thread.sleep(5000);
		BaseTest.click(driver.findElement(By.xpath("//*[@id='refine_adapter_checkBox']")));
		Thread.sleep(5000);
		BaseTest.click(p.getPartner_marital_status_confirmbtn());
	} catch (Exception e) {
		System.out.println("Residing Not Belongs to India");
	}
	
	
	Thread.sleep(5000);
	BaseTest.click(p.getEditt_Pp_save_btn());
	
	
	Thread.sleep(20000);
	driver.swipe(0, 2000, 0, 0, 1000);
	driver.swipe(0, 2000, 0, 0, 1000);
	driver.swipe(0, 2000, 0, 0, 1000);
	
	Thread.sleep(5000);
	BaseTest.click(p.getPartner_habits_btn());
	
	Thread.sleep(5000);
	BaseTest.click(p.getPartner_Eating_habits_btn());
	
	Thread.sleep(5000);
	BaseTest.click(driver.findElement(By.xpath("//*[@text=concat('Doesn', \"'\", 't matter') and @id='refine_adapter_checkBox']")));
	
	Thread.sleep(5000);
	BaseTest.click(p.getPartner_marital_status_confirmbtn());
	
	Thread.sleep(5000);
	BaseTest.click(p.getPartner_drinking_habits_btn());
	
	Thread.sleep(5000);
	BaseTest.click(driver.findElement(By.xpath("//*[@text=concat('Doesn', \"'\", 't matter') and @id='refine_adapter_checkBox']")));
	
	Thread.sleep(5000);
	BaseTest.click(p.getPartner_marital_status_confirmbtn());
	
	Thread.sleep(5000);
	BaseTest.click(p.getPartner_smoking_habits_btn());
	
	Thread.sleep(5000);
	BaseTest.click(driver.findElement(By.xpath("//*[@text=concat('Doesn', \"'\", 't matter') and @id='refine_adapter_checkBox']")));
	
	Thread.sleep(5000);
	BaseTest.click(p.getPartner_marital_status_confirmbtn());
	
	Thread.sleep(5000);
	BaseTest.click(p.getEditt_Pp_save_btn());
	
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();  
	
	
	Thread.sleep(5000);
	BaseTest.click(p.getMatches_btn());
	
	Thread.sleep(5000);
	String value = driver.findElement(By.xpath("//*[@id='profileDesc']")).getText();
	System.out.println(value);
	
	
	String[] Age = value.split("yrs,");
	String age1 = Age[0].toString();
	String agee = age1.trim();
	System.out.println("Age :  "+agee);
	float Age1 = Float.parseFloat(agee);
	
	String Height = Age[1].toString();
	String[] height1 = Height.split("/");
	String heightt= height1[0].toString();
	String height123= heightt.trim();
	System.out.println("Height :  " + height123);
//	float Height11 = Float.parseFloat(height123);
	String heighttt = height123.replaceAll("[ftin]", "");
	String[] heightsplit = heighttt.split("  ");
	String Height11 = heightsplit[0]+"."+heightsplit[1];
	float height1122 = Float.parseFloat(Height11);
	System.out.println("Height " + height1122);
	
	
	
	String heightcms = height1[1].toString();
	String[] heightincms = heightcms.split(",");
	String heightincmntmtrs = heightincms[0].toString();
	
	String maried_status = heightincms[1].toString();
	System.out.println(maried_status+"**************");
	String city = heightincms[2].toString();
	System.out.println(city+"**************");
	String State = heightincms[3].toString();
	System.out.println(State+"**************");
	String countrys = heightincms[4].toString();
	System.out.println(countrys+"**************");
	String educations = heightincms[5].toString();
	System.out.println(educations+"**************");
	
	/*String Heightin = height1[1].toString();
	System.out.println(Heightin+"**************");
	String[] height1in = Heightin.split(",");
	String heightt1= height1in[0].toString();
	String heightincm= heightt1.trim();
	System.out.println("Height in CM :  " + heightincm);
	
	String marital = height1in[1].toString();
	String[] marital_sts = marital.split(",");
	String marital_stat = marital_sts[0].toString();
	//String marital_ststu = marital_sts[1].toString();
	String marital_status = marital_stat.trim();
	System.out.println("Marital Status :  " + marital_status);
//	System.out.println(marital_ststu);
	
	
	String[] aa= value.split("/");
	String b = aa[1].toString();
	System.out.println("***" + b);
	
	String[] c = b.split(",");
	String d = c[1].toString();
	String e= c[2].toString();
	String f=c[3].toString();
	String g=c[4].toString();
	String h=c[5].toString();
	
	System.out.println("1" + d);
	System.out.println("2" + e);
	System.out.println("3" + f);
	System.out.println("4" + g);
	System.out.println("5" + g);
	
	
	
	
	String reside = marital_sts[1].toString();
	System.out.println(reside);
	String[] reside_cc = reside.split(",");
	String reside_cit = reside_cc[0].toString();
	String reside_city= reside_cit.trim();
	System.out.println("Residing City :  " + reside_city);
			
	String resides = reside_cc[1].toString();
	String[] resides_st = resides.split(",");
	String reside_stat = resides_st[0].toString();
	String resides_state = reside_stat.trim();
	System.out.println("Residing State :  " + resides_state);
	
	
	String Count = resides_st[1].toString();
	String[] Countr = Count.split(",");
	String Countrr = Countr[0].toString();
	String Country = Countrr.trim();
	System.out.println("Country" + Country);
	
	
	String edu = Countr[1].toString();
	//String[] educ = edu.split(".");
	//String educa = educ[0].toString();
	//String education = educa.trim();
	System.out.println(edu);
	
	
/*	Thread.sleep(5000);
	driver.swipe(0, 600, 0, 0, 1000);
	BaseTest.click(p.getAccount_settings());
	
	Thread.sleep(5000);
	
	BaseTest.click(p.getLogout());*/
	
	
	String AfeFrom = BaseTest.readValueFromExcelSheet().get(1).get("AgeFrom");
    float Agefrom1 = Float.parseFloat(AfeFrom);
	String AfeTo = BaseTest.readValueFromExcelSheet().get(1).get("AgeTo");
	 float AgeTo = Float.parseFloat(AfeTo);
	String HeightFrom = BaseTest.readValueFromExcelSheet().get(1).get("HeightFrom");
	String heit = HeightFrom.replaceAll("[ftin]", "");
	String[] het = heit.split(" ");
	String heigt = het[0]+"."+het[1];
	float HeightFrom1 = Float.parseFloat(heigt);
	System.out.println(HeightFrom1 + " 8 8 8 ");
	
	// float HeightFrom1 = Float.parseFloat(HeightFrom);
	String HeightTo = BaseTest.readValueFromExcelSheet().get(1).get("HeightTo");
	String heit1 = HeightTo.replaceAll("[ftin]", "");
	String[] het1 = heit1.split(" ");
	String heigt1 = het1[0]+"."+het1[1];
	float HeightTo1 = Float.parseFloat(heigt1);
	System.out.println(HeightTo1 + " 8 # 8 # 8 ");
	
	
	
	
	//	float HeightTo1 = Float.parseFloat(HeightTo);
	String MariedStatus = BaseTest.readValueFromExcelSheet().get(1).get("MaritalStatus");
	//float MaritalStatus = Float.parseFloat(MariedStatus);
	String City = BaseTest.readValueFromExcelSheet().get(1).get("IndianCity");
	//float City1 = Float.parseFloat(City);
	String Statee = BaseTest.readValueFromExcelSheet().get(1).get("ResidingState");
	//float State1 = Float.parseFloat(Statee);
	String Country = BaseTest.readValueFromExcelSheet().get(1).get("Country");
	
	String Education = BaseTest.readValueFromExcelSheet().get(1).get("Education");
	
	
	if (Age1 == Agefrom1 || Age1 <= AgeTo) {
		System.out.println("The Age " +Age1+ "is between " + Agefrom1+ "and " + AgeTo);
		
	} else {
           System.out.println("The Age is not between " + Agefrom1 + "and " + AgeTo);
	}
	
	if (height1122 == HeightFrom1 ||  height1122 <= HeightTo1) {
		System.out.println("The Height " +height1122+ "is between " + HeightFrom1+ "and " + HeightTo1);
	} else {
		System.out.println("The Height  is not between " + HeightFrom1 + "and " + HeightTo1);
	}
	
	if (maried_status.contains(MariedStatus)) {
		System.out.println("The Marital Status Equals");
		
	} else {
		System.out.println("The Marital not Status Equals");
	}
	
	if (city.contains(City)) {
		System.out.println("The City matched");
	} else {
		System.out.println("The City not matched");
	}
	
	
	if (State.contains(Statee)) {
		System.out.println("The State matched");
	} else {
		System.out.println("The State not matched");
	}
	
	if (countrys.contains(Country)) {
		System.out.println("The Country matched");
	} else {
		System.out.println("The Country not matched");
	}
	
	if (educations.contains(Education)) {
		System.out.println("The Education matched");
	} else {
		System.out.println("The Education not matched");
	}
	
	
	Thread.sleep(5000);
	BaseTest.click(p.getMenu_btn());
	
	Thread.sleep(5000);
	driver.swipe(0, 600, 0, 0, 1000);
	BaseTest.click(p.getAccount_settings());
	
	Thread.sleep(5000);
	
	BaseTest.click(p.getLogout());
    }
    
  

    @AfterTest
    public void tearDown() {
       driver.quit();
    }
}