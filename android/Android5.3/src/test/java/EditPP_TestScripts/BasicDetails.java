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

public class BasicDetails {
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

     //Login-->Edit PI-->Edit PP-->fetching basic details  in Epp-->Search-->tapping on Search Now
  	//-->getting profile list count-->view profile-->checking PP  value  with Vp value by tapping on Next profile button
    @Test(enabled=false)
    public void basicDetails_SearchTest() throws Throwable {
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		pp.getBDetailsEdit().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Fetching PP Basic Details...........");
		String a=pp.getAgeFrom().getText();
		String b=pp.getAgeTo().getText();
		int ppAgeFrom=Integer.parseInt(a);
		int ppAgeTo=Integer.parseInt(b);
		System.out.println("Default PP Age : "+ppAgeFrom+"-"+ppAgeTo);
		Thread.sleep(4000);
		String htFrom=pp.getHeightFrom().getText();
		String htTo=pp.getHeightTo().getText();
		System.out.println("Default PP Height : "+htFrom+"-"+htTo);
		htFrom=htFrom.replace("ft",".");
		htFrom=htFrom.replaceAll("[^\\d.]", "");
		htFrom=htFrom.replace("."," ");
		String[] s=htFrom.split(" ");
		double ppHeightFrom;
		double ppHeightTo;
		try{
			ppHeightFrom=EPP_Pom.convertFeetandInchesToCentimeter(s[0], s[1]);
			
		}catch(Exception e){
			ppHeightFrom=EPP_Pom.convertFeetandInchesToCentimeter(s[0], "0");
			
		}
		htTo=htTo.replace("ft",".");
		htTo=htTo.replaceAll("[^\\d.]", "");
		htTo=htTo.replace("."," ");
		String[] s1=htTo.split(" ");
		try{
			 ppHeightTo=EPP_Pom.convertFeetandInchesToCentimeter(s1[0], s1[1]);
			
		}catch(Exception e){
			 ppHeightTo=EPP_Pom.convertFeetandInchesToCentimeter(s[0], "0");
		}
		System.out.println("Default PP Height in cms: "+ppHeightFrom+" - "+ppHeightTo);
		String ppMs=pp.getMaritalStatus().getText();
	    System.out.println("Marital status: "+ppMs);
	    String[] ppMstatus=ppMs.split(",");
	    String pp_mT=pp.getPP_mTongue().getText();
	    System.out.println("Mother Tongue in PP: "+pp_mT);
	    String[] pp_motherTongue=pp_mT.split(",");
	    String pp_pStstus=pp.getPP_pStatus().getText();
	    System.out.println("Physical status: "+pp_pStstus);
		
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
				//==============Fetching Age Value ===============
			    String ss=pp.getVp_Age().getText();
			    String s2=ss.substring(0,2);
			    int vpAge=Integer.parseInt(s2);
			    System.out.println("vp age: "+vpAge); 
			    driver.swipe(startx, starty, startx, endy, 3000);
			    Thread.sleep(2000);
			    //============= Fetching Height value=============
			    String vpHt=pp.getVpHeight().getText();
			    String[] array=vpHt.split("/");
			    System.out.println("Vp Height "+array[1]);
			    String viewprofileHt=array[1].replaceAll("[^\\d.]", "");
			    double vpHeight=Double.parseDouble(viewprofileHt);
			    System.out.println("Vp Height "+vpHeight);
			    //==============Fetching Marital status==========
			    String vpMStatus=pp.getVp_mStatus().getText();
			    System.out.println("view profile: "+vpMStatus);
			    String vp_motherTongue=pp.getVp_mTongue().getText();
			    System.out.println("view profile: "+vp_motherTongue);
			    String vp_pStatus=pp.getVP_pStatus().getText();
			    System.out.println("view profile: "+vp_pStatus);
			    System.out.println("Verifying vp Age with pp............");
			    boolean statusAge=false;
			    if(vpAge>=ppAgeFrom&&vpAge <=ppAgeTo) {
			    	statusAge=true;	
			    	System.out.println("View profile Age : "+vpAge+" is coming based on pp "+ppAgeFrom+" - "+ppAgeTo);
			    }
			    asrt.assertTrue(statusAge, "View profile: " +oppMatriId+" Age is not as per PP values");
			    
			    System.out.println("Verifying vp Height with pp............");
			    boolean statusHeight=false;
			    if(vpHeight>=ppHeightFrom&&vpHeight<=ppHeightTo) {
			    	statusHeight=true;
			    	System.out.println("View profile Height : "+vpHeight+" is coming based on pp "+ppHeightFrom+" - "+ppHeightTo);
			    }
			    asrt.assertTrue(statusHeight, "View profile: " +oppMatriId+" Height is not as per PP values");
			    
			    System.out.println("Verifying vp Marital status with pp............");
			    if(!ppMs.equalsIgnoreCase("Doesn't matter")){
			    	 boolean statusMarital=false;
			    	 for(int j=0;j<=ppMstatus.length-1;j++){
			    		 if(vpMStatus.equalsIgnoreCase(ppMstatus[j])){
						    	statusMarital=true;
						    	System.out.println("View profilemarital status: "+vpMStatus+"  is matching with pp "+ppMstatus[j]);
						    }
			    		 
			    	 }
					    
					    asrt.assertTrue(statusMarital, "View profile: " +oppMatriId+" Marital status is not as per PP values");
			    }
			    System.out.println("Verifying vp Mother Tongue with pp............");
			    			   
			    if(!pp_mT.equalsIgnoreCase("Any")){
			    	boolean statusMotherTongue=false;
			  		for(int j=0;j<=pp_motherTongue.length-1;j++){
			  			if(vp_motherTongue.equalsIgnoreCase(pp_motherTongue[j])){
			  				statusMotherTongue=true;
			  				System.out.println("View profile mother Tongue: "+vp_motherTongue+" is matching with pp Mother Tongue "+pp_motherTongue[j]);
			  				
			  			}
			  				
			  		}
			  		asrt.assertTrue(statusMotherTongue, "View profile: " +oppMatriId+" Mother Tongue is not as per PP values");

			    	
			    }
			    System.out.println("Verifying vp physical status with pp............");
			    if(!pp_pStstus.equalsIgnoreCase("Doesn't matter")){
			    	 boolean statusPhysical=false;
					    if(vp_pStatus.equalsIgnoreCase(pp_pStstus)){
					    	statusPhysical=true;
					    	System.out.println("View profile physical status: "+vp_pStatus+"  is matching with pp "+pp_pStstus);
					    }
					    asrt.assertTrue(statusPhysical, "View profile: " +oppMatriId+" Marital status is not as per PP values");
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
    @Test
    public void basicDetails_ListingsTest() throws Throwable {
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		pp.getBDetailsEdit().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Fetching PP Basic Details...........");
		String a=pp.getAgeFrom().getText();
		String b=pp.getAgeTo().getText();
		int ppAgeFrom=Integer.parseInt(a);
		int ppAgeTo=Integer.parseInt(b);
		System.out.println("Default PP Age : "+ppAgeFrom+"-"+ppAgeTo);
		Thread.sleep(4000);
		String htFrom=pp.getHeightFrom().getText();
		String htTo=pp.getHeightTo().getText();
		System.out.println("Default PP Height : "+htFrom+"-"+htTo);
		htFrom=htFrom.replace("ft",".");
		htFrom=htFrom.replaceAll("[^\\d.]", "");
		htFrom=htFrom.replace("."," ");
		String[] s=htFrom.split(" ");
		double ppHeightFrom;
		double ppHeightTo;
		try{
			ppHeightFrom=EPP_Pom.convertFeetandInchesToCentimeter(s[0], s[1]);
			
		}catch(Exception e){
			ppHeightFrom=EPP_Pom.convertFeetandInchesToCentimeter(s[0], "0");
			
		}
		htTo=htTo.replace("ft",".");
		htTo=htTo.replaceAll("[^\\d.]", "");
		htTo=htTo.replace("."," ");
		String[] s1=htTo.split(" ");
		try{
			 ppHeightTo=EPP_Pom.convertFeetandInchesToCentimeter(s1[0], s1[1]);
			
		}catch(Exception e){
			 ppHeightTo=EPP_Pom.convertFeetandInchesToCentimeter(s[0], "0");
		}
		System.out.println("Default PP Height in cms: "+ppHeightFrom+" - "+ppHeightTo);
		String ppMs=pp.getMaritalStatus().getText();
	    System.out.println("Marital status: "+ppMs);
	    String[] ppMstatus=ppMs.split(",");
	    String pp_mT=pp.getPP_mTongue().getText();
	    System.out.println("Mother Tongue in PP: "+pp_mT);
	    String[] pp_motherTongue=pp_mT.split(",");
	    String pp_pStstus=pp.getPP_pStatus().getText();
	    System.out.println("Physical status: "+pp_pStstus);
		
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
				System.out.println("Verifying Basic details in "+listname);
				if(lst.size()>0) {
					String count=pp.getProfileListCount().getText();
					String[] arr = count.split(" ");    
					String a1=arr[0];
					int listcount = Integer.parseInt(a1);			
					System.out.println("List count in "+listname+" : "+listcount);
					lst.get(0).click();
					Thread.sleep(2000);
					//for( int i=1;i<listcount;i++) { 
					for( int i=1;i<2;i++) { 
						Thread.sleep(4000);
						String oppMatriId=pp.getMatriId_VP().getText();
						driver.swipe(startx, starty, startx, endy, 3000);
						Thread.sleep(4000);//==============Fetching Age Value ===============
					    String ss=pp.getVp_Age().getText();
					    String s2=ss.substring(0,2);
					    int vpAge=Integer.parseInt(s2);
					    System.out.println("vp age: "+vpAge); 
					    driver.swipe(startx, starty, startx, endy, 3000);
					    Thread.sleep(2000);
					    //============= Fetching Height value=============
					    String vpHt=pp.getVpHeight().getText();
					    String[] array=vpHt.split("/");
					    System.out.println("Vp Height "+array[1]);
					    String viewprofileHt=array[1].replaceAll("[^\\d.]", "");
					    double vpHeight=Double.parseDouble(viewprofileHt);
					    System.out.println("Vp Height "+vpHeight);
					    //==============Fetching Marital status==========
					    String vpMStatus=pp.getVp_mStatus().getText();
					    System.out.println("view profile: "+vpMStatus);
					    String vp_motherTongue=pp.getVp_mTongue().getText();
					    System.out.println("view profile: "+vp_motherTongue);
					    String vp_pStatus=pp.getVP_pStatus().getText();
					    System.out.println("view profile: "+vp_pStatus);
					    System.out.println("Verifying vp Age with pp............");
					    boolean statusAge=false;
					    if(vpAge>=ppAgeFrom&&vpAge <=ppAgeTo) {
					    	statusAge=true;	
					    	System.out.println("View profile Age : "+vpAge+" is coming based on pp "+ppAgeFrom+" - "+ppAgeTo);
					    }
					    asrt.assertTrue(statusAge, "View profile: " +oppMatriId+" Age is not as per PP values");
					    
					    System.out.println("Verifying vp Height with pp............");
					    boolean statusHeight=false;
					    if(vpHeight>=ppHeightFrom&&vpHeight<=ppHeightTo) {
					    	statusHeight=true;
					    	System.out.println("View profile Height : "+vpHeight+" is coming based on pp "+ppHeightFrom+" - "+ppHeightTo);
					    }
					    asrt.assertTrue(statusHeight, "View profile: " +oppMatriId+" Height is not as per PP values");
					    
					    System.out.println("Verifying vp Marital status with pp............");
					    if(!ppMs.equalsIgnoreCase("Doesn't matter")){
					    	 boolean statusMarital=false;
					    	 for(int j=0;j<=ppMstatus.length-1;j++){
					    		 if(vpMStatus.equalsIgnoreCase(ppMstatus[j])){
								    	statusMarital=true;
								    	System.out.println("View profilemarital status: "+vpMStatus+"  is matching with pp "+ppMstatus[j]);
								    }
					    		 
					    	 }
							    
							    asrt.assertTrue(statusMarital, "View profile: " +oppMatriId+" Marital status is not as per PP values");
					    }
					    System.out.println("Verifying vp Mother Tongue with pp............");
					    			   
					    if(!pp_mT.equalsIgnoreCase("Any")){
					    	boolean statusMotherTongue=false;
					  		for(int j=0;j<=pp_motherTongue.length-1;j++){
					  			if(vp_motherTongue.equalsIgnoreCase(pp_motherTongue[j])){
					  				statusMotherTongue=true;
					  				System.out.println("View profile mother Tongue: "+vp_motherTongue+" is matching with pp Mother Tongue "+pp_motherTongue[j]);
					  				
					  			}
					  				
					  		}
					  		asrt.assertTrue(statusMotherTongue, "View profile: " +oppMatriId+" Mother Tongue is not as per PP values");

					    	
					    }
					    System.out.println("Verifying vp physical status with pp............");
					    if(!pp_pStstus.equalsIgnoreCase("Doesn't matter")){
					    	 boolean statusPhysical=false;
							    if(vp_pStatus.equalsIgnoreCase(pp_pStstus)){
							    	statusPhysical=true;
							    	System.out.println("View profile physical status: "+vp_pStatus+"  is matching with pp "+pp_pStstus);
							    }
							    asrt.assertTrue(statusPhysical, "View profile: " +oppMatriId+" Marital status is not as per PP values");
					    }
					   
					    
					    //==============Navigating to Next Profile===============
					    try {
							pp.getNextProfile_btn().click();
						} catch (Exception e) {
							break;
						}	          
					}
					System.out.println("View profile validated Sucessfully with PPvalues");
					pp.getNavigate_back_btn().click();
					Thread.sleep(3000);	
					

					
				}else {
					System.out.println("No profiles found in "+listname);
					
				}
			}
				
			
			
        }
        asrt.assertAll();
        
        }

    

}
