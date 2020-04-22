package EditPP_TestScripts;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseTest;
import POM.Delete_POM;
import POM.EPP_Pom;
import POM.IntermediatePages;
import POM.LoginPage;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class LocationPreference {
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
        dc.setCapability(MobileCapabilityType.UDID, "63b35456");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.community.matrimony");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.domaininstance.ui.activities.Splash");
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

     //Login-->Edit PI-->Edit PP-->fetching sub caste value in Epp-->Search-->tapping on Search Now
  	//-->getting profile list count-->view profile-->checking PP  value  with Vp value by tapping on Next profile button
    @Test(enabled=true)
    public void locationPreferences_SearchTest() throws Throwable {
		EPP_Pom pp=new EPP_Pom(driver);
		Delete_POM d = new Delete_POM(driver);
		//=================>LOGIN==============================	
		String matriId=BaseTest.getExcelData("LoginDetails",1,1);
		String pwd=BaseTest.getExcelData("LoginDetails", 1, 2);	
		LoginPage.loginToApp(driver,matriId,pwd);
		IntermediatePages.skipIntermediatePages(driver);
		Thread.sleep(2000);
		BaseTest.click(d.getProfile_btn_click());
		Thread.sleep(2000);
		//=========================>EDIT PP============
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.swipe(startx, starty, startx, endy, 3000);
		pp.getEditPP().click();
		Thread.sleep(4000);
		driver.swipe(startx, starty, startx, endy, 2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Fetching PP Location preferenes...........");
		
		String pp_ctry=pp.getPP_Country().getText();
		System.out.println("pp Country: "+pp_ctry);
		String[] pp_Country=pp_ctry.split(",");
		
		String pp_st= null;
		String[] pp_State= null;
		
		try{
		    pp_st=pp.getPP_State().getText();
			System.out.println("PP State: "+pp_st);
		     pp_State=pp_st.split(",");	
		}
		catch(Exception e){
			System.out.println("PP State: null");
			
		}
		
		String pp_cty = null;
		String[] pp_City = null;
		try{
			pp_cty=pp.getPP_City().getText();
			System.out.println("PP City: "+pp_cty);
			pp_City=pp_cty.split(",");	
		}
		catch(Exception e){
			pp_cty=null;
			System.out.println("PP City: null");
			
		}
		
		String pp_rStatus=pp.getPP_ResidentStatus().getText();
		System.out.println("PP Resident status: "+pp_rStatus);
		String[] pp_ResidentStatus=pp_rStatus.split(",");
		
		String pp_cship=pp.getPP_Citizenship().getText();
		System.out.println("PP Citizenship: "+pp_cship);
		String[] pp_Citizenship=pp_cship.split(",");	
		
		//=============Navigating Back From EPP========
		Thread.sleep(3000);
		pp.getEppBack().click();
		Thread.sleep(3000);
		pp.getEppBack().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//======================SEARCH=================
		pp.getSearch().click();
		Thread.sleep(3000);
		pp.getSearchNow().click();
		Thread.sleep(9000);
		List<AndroidElement> lst=driver.findElementsByXPath("//*[@id='profileMatriId']");
		if(lst.size()>0) {
			//========================View Profile=====================
			lst.get(0).click();
			SoftAssert asrt=new SoftAssert();
			for( int i=1;i<=2;i++) {
				Thread.sleep(4000);
				String oppMatriId=pp.getMatriId_VP().getText();
				Thread.sleep(2000);
				driver.swipe(startx, starty, startx, endy, 3000);
				Thread.sleep(4000);
				pp.getBasicDetailsIcon().click();
				driver.swipe(startx, starty, startx, endy, 3000);
				Thread.sleep(5000);
				//==============Fetching View profile location details=============
				String vp_Country=pp.getVP_Country().getText();
				System.out.println("Vp Country: "+vp_Country);
				
				String vp_State;
				try{
					vp_State=pp.getVP_State().getText();
					System.out.println("VP State: "+vp_State);
				}
				catch(Exception e){
					vp_State=null;
					System.out.println("VP State: null");
					
				}
				String Vp_City;
				try{
					Vp_City=pp.getVP_City().getText();
					System.out.println("VP City: "+Vp_City);
				}
				catch(Exception e){
					Vp_City=null;
					System.out.println("VP City: null");
					
				}
				
				String vp_ResidentStatus=pp.getVP_ResidentStatus().getText();
				System.out.println("VP Resident status: "+vp_ResidentStatus);
				
				String vp_Citizenship=pp.getVP_Citizenship().getText();
				System.out.println("VP Citizenship: "+vp_Citizenship);
				
			   System.out.println("Verifying Country with pp............");
			    if(!pp_ctry.equalsIgnoreCase("Any")){
			    	 boolean statusCountry=false;
			    	 for(int j=0;j<=pp_Country.length-1;j++){
			    		 if(vp_Country.equalsIgnoreCase(pp_Country[j])){
			    			 statusCountry=true;
						     System.out.println("View profile Country: "+vp_Country+"  is matching with pp "+pp_Country[j]);
						    }
			    		 
			    	 }
					    
					    asrt.assertTrue(statusCountry, "View profile: " +oppMatriId+" Country is not as per PP values");
			    }
			   System.out.println("Verifying vp State with pp............");
			    			   
			   if(!pp_st.equalsIgnoreCase("Any")||pp_st!=null){
			    	 boolean statusState=false;
			    	 for(int j=0;j<=pp_State.length-1;j++){
			    		 if(vp_State.equalsIgnoreCase(pp_State[j])){
			    			 statusState=true;
						     System.out.println("View profile State: "+vp_State+"  is matching with pp "+pp_State[j]);
						    }
			    		 
			    	 }
					    
					    asrt.assertTrue(statusState, "View profile: " +oppMatriId+" State is not as per PP values");
			    }
			   System.out.println("Verifying vp City with pp............");			    
			   if(!pp_cty.equalsIgnoreCase("Any")||pp_cty!=null){
			    	 boolean statusCity=false;
			    	 for(int j=0;j<=pp_City.length-1;j++){
			    		 if(Vp_City.equalsIgnoreCase(pp_City[j])){
			    			 statusCity=true;
						     System.out.println("View profile City: "+Vp_City+"  is matching with pp "+pp_City[j]);
						    }
			    		 
			    	 }
					    
					    asrt.assertTrue(statusCity, "View profile: " +oppMatriId+" city is not as per PP values");
			    }
			   
			   System.out.println("Verifying vp Citisenship with pp............");			    
			   if(!pp_cship.equalsIgnoreCase("Any")){
			    	 boolean statusCitizenship=false;
			    	 for(int j=0;j<=pp_Citizenship.length-1;j++){
			    		 if(vp_Citizenship.equalsIgnoreCase(pp_Citizenship[j])){
			    			 statusCitizenship=true;
						     System.out.println("View profile Citizenship: "+vp_Citizenship+"  is matching with pp "+pp_Citizenship[j]);
						    }
			    		 
			    	 }
					    
					    asrt.assertTrue(statusCitizenship, "View profile: " +oppMatriId+" citizenship is not as per PP values");
			    }
			   
			   System.out.println("Verifying vp Resident status with pp............");			    
			   if(!pp_rStatus.equalsIgnoreCase("Any")){
			    	 boolean statusResident=false;
			    	 for(int j=0;j<=pp_ResidentStatus.length-1;j++){
			    		 if(vp_ResidentStatus.equalsIgnoreCase(pp_ResidentStatus[j])){
			    			 statusResident=true;
						     System.out.println("View profile Resident status: "+vp_ResidentStatus+"  is matching with pp "+pp_ResidentStatus[j]);
						    }
			    		 
			    	 }
					    
					    asrt.assertTrue(statusResident, "View profile: " +oppMatriId+" Resident status is not as per PP values");
			    }
			   
			    //==============Navigating to Next Profile===============
			    try {
					pp.getNextProfile_btn().click();
				} catch (Exception e) {
					break;
				}	          
			}
			System.out.println("View profile validated Sucessfully with PPvalues");
			asrt.assertAll();
			pp.getNavigate_back_btn().click();
			Thread.sleep(3000);	
			pp.getNavigate_back_btn().click();	
		}else {
			System.out.println("No profiles found in Search");	
		}
		
		

    }
    
    
    
    @Test(enabled=false)
    public void locationPreferences_ListingsTest() throws Throwable {
		EPP_Pom pp=new EPP_Pom(driver);
		Delete_POM d = new Delete_POM(driver);
		//=================>LOGIN==============================	
		String matriId=BaseTest.getExcelData("LoginDetails",1,1);
		String pwd=BaseTest.getExcelData("LoginDetails", 1, 2);	
		LoginPage.loginToApp(driver,matriId,pwd);
		IntermediatePages.skipIntermediatePages(driver);
		Thread.sleep(2000);
		BaseTest.click(d.getProfile_btn_click());
		Thread.sleep(2000);
		//=========================>EDIT PP============
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.swipe(startx, starty, startx, endy, 3000);
		pp.getEditPP().click();
		Thread.sleep(4000);
		driver.swipe(startx, starty, startx, endy, 2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Fetching PP Location preferenes...........");
		
		String pp_ctry=pp.getPP_Country().getText();
		System.out.println("pp Country: "+pp_ctry);
		String[] pp_Country=pp_ctry.split(",");
		
		String pp_st= null;
		String[] pp_State= null;
		
		try{
		    pp_st=pp.getPP_State().getText();
			System.out.println("PP State: "+pp_st);
		     pp_State=pp_st.split(",");	
		}
		catch(Exception e){
			System.out.println("PP State: null");
			
		}
		
		String pp_cty = null;
		String[] pp_City = null;
		try{
			pp_cty=pp.getPP_City().getText();
			System.out.println("PP City: "+pp_cty);
			pp_City=pp_cty.split(",");	
		}
		catch(Exception e){
			pp_cty=null;
			System.out.println("PP City: null");
			
		}
		
		String pp_rStatus=pp.getPP_ResidentStatus().getText();
		System.out.println("PP Resident status: "+pp_rStatus);
		String[] pp_ResidentStatus=pp_rStatus.split(",");
		
		String pp_cship=pp.getPP_Citizenship().getText();
		System.out.println("PP Citizenship: "+pp_cship);
		String[] pp_Citizenship=pp_cship.split(",");	
		
		//=============Navigating Back From EPP========
		Thread.sleep(3000);
		pp.getEppBack().click();
		Thread.sleep(3000);
		pp.getEppBack().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//=================Listings==================
		pp.getHomeIcon().click();
		System.out.println("Clicked on Home icon..........");
        Thread.sleep(3000);
        SoftAssert asrt=new SoftAssert();
        String[] listArray= {"JUST JOINED","MATCHES","PREMIUM","MUTUAL","VIEWED NOT CONTACTED","SHORTLISTED","VIEWED MY PROFILE","SHORTLISTED ME","NEARBY MATCHES","PREFERRED PROFESSION","PREFERRED EDUCATION","PREFERRED STAR","PREFERRED LOCATION"};   
        for(String listname:listArray) {
        	Thread.sleep(9000);
        	driver.findElementByXPath("//*[@text='"+listname+"']").click();
			Thread.sleep(3000);
			if(listname.equalsIgnoreCase("JUST JOINED")||listname.equalsIgnoreCase("MATCHES")||listname.equalsIgnoreCase("PREMIUM")||listname.equalsIgnoreCase("MUTUAL")) {
				List<AndroidElement> lst=driver.findElementsByXPath("//*[@id='profileMatriId']");
				System.out.println("Verifying location preferences  details in "+listname);
				if(lst.size()>0) {
					String count=pp.getProfileListCount().getText();
					String[] arr = count.split(" ");    
					String a1=arr[0];
					int listcount = Integer.parseInt(a1);			
					System.out.println("List count in "+listname+" : "+listcount);
					lst.get(0).click();
					Thread.sleep(2000);
					//for( int i=1;i<listcount;i++) { 
					for( int i=1;i<=2;i++) {
						Thread.sleep(4000);
						String oppMatriId=pp.getMatriId_VP().getText();
						Thread.sleep(2000);
						driver.swipe(startx, starty, startx, endy, 3000);
						Thread.sleep(4000);
						pp.getBasicDetailsIcon().click();
						driver.swipe(startx, starty, startx, endy, 3000);
						Thread.sleep(5000);
						//==============Fetching View profile location details=============
						String vp_Country=pp.getVP_Country().getText();
						System.out.println("Vp Country: "+vp_Country);
						
						String vp_State;
						try{
							vp_State=pp.getVP_State().getText();
							System.out.println("VP State: "+vp_State);
						}
						catch(Exception e){
							vp_State=null;
							System.out.println("VP State: null");
							
						}
						String Vp_City;
						try{
							Vp_City=pp.getVP_City().getText();
							System.out.println("VP City: "+Vp_City);
						}
						catch(Exception e){
							Vp_City=null;
							System.out.println("VP City: null");
							
						}
						
						String vp_ResidentStatus=pp.getVP_ResidentStatus().getText();
						System.out.println("VP Resident status: "+vp_ResidentStatus);
						
						String vp_Citizenship=pp.getVP_Citizenship().getText();
						System.out.println("VP Citizenship: "+vp_Citizenship);
						
					   System.out.println("Verifying Country with pp............");
					    if(!pp_ctry.equalsIgnoreCase("Any")){
					    	 boolean statusCountry=false;
					    	 for(int j=0;j<=pp_Country.length-1;j++){
					    		 if(vp_Country.equalsIgnoreCase(pp_Country[j])){
					    			 statusCountry=true;
								     System.out.println("View profile Country: "+vp_Country+"  is matching with pp "+pp_Country[j]);
								    }
					    		 
					    	 }
							    
							    asrt.assertTrue(statusCountry, "View profile: " +oppMatriId+" Country is not as per PP values");
					    }
					   System.out.println("Verifying vp State with pp............");
					    			   
					   if(!pp_st.equalsIgnoreCase("Any")||pp_st!=null){
					    	 boolean statusState=false;
					    	 for(int j=0;j<=pp_State.length-1;j++){
					    		 if(vp_State.equalsIgnoreCase(pp_State[j])){
					    			 statusState=true;
								     System.out.println("View profile State: "+vp_State+"  is matching with pp "+pp_State[j]);
								    }
					    		 
					    	 }
							    
							    asrt.assertTrue(statusState, "View profile: " +oppMatriId+" State is not as per PP values");
					    }
					   System.out.println("Verifying vp City with pp............");			    
					   if(!pp_cty.equalsIgnoreCase("Any")||pp_cty!=null){
					    	 boolean statusCity=false;
					    	 for(int j=0;j<=pp_City.length-1;j++){
					    		 if(Vp_City.equalsIgnoreCase(pp_City[j])){
					    			 statusCity=true;
								     System.out.println("View profile City: "+Vp_City+"  is matching with pp "+pp_City[j]);
								    }
					    		 
					    	 }
							    
							    asrt.assertTrue(statusCity, "View profile: " +oppMatriId+" city is not as per PP values");
					    }
					   
					   System.out.println("Verifying vp Citisenship with pp............");			    
					   if(!pp_cship.equalsIgnoreCase("Any")){
					    	 boolean statusCitizenship=false;
					    	 for(int j=0;j<=pp_Citizenship.length-1;j++){
					    		 if(vp_Citizenship.equalsIgnoreCase(pp_Citizenship[j])){
					    			 statusCitizenship=true;
								     System.out.println("View profile Citizenship: "+vp_Citizenship+"  is matching with pp "+pp_Citizenship[j]);
								    }
					    		 
					    	 }
							    
							    asrt.assertTrue(statusCitizenship, "View profile: " +oppMatriId+" citizenship is not as per PP values");
					    }
					   
					   System.out.println("Verifying vp Resident status with pp............");			    
					   if(!pp_rStatus.equalsIgnoreCase("Any")){
					    	 boolean statusResident=false;
					    	 for(int j=0;j<=pp_ResidentStatus.length-1;j++){
					    		 if(vp_ResidentStatus.equalsIgnoreCase(pp_ResidentStatus[j])){
					    			 statusResident=true;
								     System.out.println("View profile Resident status: "+vp_ResidentStatus+"  is matching with pp "+pp_ResidentStatus[j]);
								    }
					    		 
					    	 }
							    
							    asrt.assertTrue(statusResident, "View profile: " +oppMatriId+" Resident status is not as per PP values");
					    }
					   
					    //==============Navigating to Next Profile===============
					    try {
							pp.getNextProfile_btn().click();
						} catch (Exception e) {
							break;
						}	          
					}
					System.out.println("View profile validated Sucessfully with PPvalues");
					asrt.assertAll();
					pp.getNavigate_back_btn().click();
					Thread.sleep(3000);	
					pp.getNavigate_back_btn().click();	
								}else {
					System.out.println("No profiles found in "+listname);
					
				}
			}
				
			
			
        }
        asrt.assertAll();
        
        }

    

}
