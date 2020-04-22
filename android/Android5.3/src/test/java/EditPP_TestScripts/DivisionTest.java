package EditPP_TestScripts;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Base.BaseTest;
import POM.Delete_POM;
import POM.EPP_Pom;
import POM.Login_Pom;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class DivisionTest {
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
     //Login-->Edit PI-->Edit PP-->fetching Division,sect value in Epp-->Search-->tapping on Search Now
  	//-->getting profile list count-->view profile-->checking PP  value  with Vp value by tapping on Next profile button
    @Test(enabled = true)
    public void subCaste_SearchTest() throws Throwable {
		Login_Pom login = new Login_Pom(driver);
		Delete_POM d = new Delete_POM(driver);
		EPP_Pom g=new EPP_Pom(driver);
		Thread.sleep(2000);
		//=================>LOGIN==============================
		try {
			login.getIntermediate_skip().click();
			Thread.sleep(2000);
			login.getIntermediate_Login().click();
			Thread.sleep(2000);
			login.getEnter_Matrid().sendKeys( "IYR242926");
			login.getEnter_passwrd().sendKeys( "cbstest");
			login.getEnter_Login().click();

		} catch (Exception e) {
			System.out.println("Already Login.................");
	   }
		//=================>INTERMEDIATE PAGES================
		try {

			Thread.sleep(4000);
			BaseTest.click(login.getInter_close());
			System.out.println("intermediate page Handled......");

		} catch (Exception e) {
			System.out.println("no intermediate page displayed.....");
		}

		try {

			Thread.sleep(4000);
			BaseTest.click(driver.findElement(By.xpath("//*[@id='skip']")));
			System.out.println("Payment intermediate page Handled.....");

		} catch (Exception e) {
			System.out.println("no Payment intermediate page Handled .....");
		}

		try {

			Thread.sleep(4000);
			BaseTest.click(login.getQuickrespnse_clse_btn());
			System.out.println("quick Response page Handled ......");

		} catch (Exception e) {
			System.out.println("no quick response page displayed .....");
		}
		//========================> MENU SECTION=================
		Thread.sleep(2000);
		BaseTest.click(d.getProfile_btn_click());
		Thread.sleep(2000);
		Dimension size = driver.manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		SoftAssert asrt=new SoftAssert();
		//=========================> EDIT PP==============
		g.getEditPP().click();
		Thread.sleep(4000);
		g.getPartnerReligious_Edit().click();
		Thread.sleep(2000);
		String divi_pp=g.getDivision_pp().getText();
		System.out.println("Division: "+divi_pp);
		String[] pp_division=divi_pp.split(",");
		
		String sect_pp=g.getSect_pp().getText();
		System.out.println("Sect: "+divi_pp);
		String[] pp_sect=sect_pp.split(",");
		//=============Navigating Back From EPP========
				Thread.sleep(3000);
				g.getEppBack().click();
				Thread.sleep(3000);
				g.getEppBack().click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				//======================SEARCH=================
				g.getSearch().click();
				Thread.sleep(3000);
				g.getSearchNow().click();
				Thread.sleep(9000);
				List<AndroidElement> lst=driver.findElementsByXPath("//*[@id='profileMatriId']");
				if(lst.size()>0) {
					//========================View Profile=====================
					lst.get(0).click();
					for( int i=1;i<=2;i++) {
						Thread.sleep(4000);
						String oppMatriId=g.getMatriId_VP().getText();
						Thread.sleep(2000);
						driver.swipe(startx, starty, startx, endy, 3000);
						Thread.sleep(4000);
						g.getHoroscopeIcon_vp().click();
						Thread.sleep(4000);
						//==============Fetching   Sect & division ===============
						
						String vp_division=g.getDivision_pp().getText();
					    System.out.println("Divsion in VP: "+pp_division);
					    
					    String vp_sect=g.getSect_pp().getText();
					    System.out.println("Sect in VP: "+vp_sect);
					    
		                System.out.println("Verifying vp Division with pp............");
					    if(!divi_pp.equalsIgnoreCase("Any")){
					    	 boolean statusDivi=false;
					    	 for(int j=0;j<=pp_division.length-1;j++){
					    		 if(vp_division.equalsIgnoreCase(pp_division[j])){
					    			    statusDivi=true;
								    	System.out.println("View profile  Division : "+vp_division+" is matching with pp "+pp_division[j]);
								    }
					    		 
					    	 }
							    
							    asrt.assertTrue(statusDivi, "View profile: " +oppMatriId+" Division is not as per PP values");
					    }
					    
					    System.out.println("Verifying vp Sect with pp............");
					    if(!sect_pp.equalsIgnoreCase("Any")){
					    	 boolean statusSect=false;
					    	 for(int j=0;j<=pp_sect.length-1;j++){
					    		 if(vp_sect.equalsIgnoreCase(pp_sect[j])){
					    			 statusSect=true;
								    	System.out.println("View profile Sect: "+vp_sect+"  is matching with pp "+pp_sect[j]);
								    }
					    		 
					    	 }
							    
							    asrt.assertTrue(statusSect, "View profile: " +oppMatriId+" Sect is not as per PP values");
					    }	
					    
					    //==============Navigating to Next Profile===============
					    try {
							g.getNextProfile_btn().click();
						} catch (Exception e) {
							break;
						}	          
					}
					System.out.println("View profile validated Sucessfully with PPvalues");
					asrt.assertAll();	
					g.getNavigate_back_btn().click();
					Thread.sleep(3000);	
					g.getNavigate_back_btn().click();	
				}else {
					System.out.println("No profiles found in Search");	
				}
		    }
    //Login-->Edit PI-->Edit PP-->fetching division,sect value in Epp-->Listing-->navigating to listing 
  	//-->getting profile list count-->view profile-->checking PP  value  with Vp value by tapping on Next profile button
    @Test(enabled = false)
    public void subCaste_ListingTest() throws Throwable {
		Login_Pom login = new Login_Pom(driver);
		Delete_POM d = new Delete_POM(driver);
		EPP_Pom g=new EPP_Pom(driver);
		Thread.sleep(2000);
		//=================>LOGIN==============================
		try {
			login.getIntermediate_skip().click();
			Thread.sleep(2000);
			login.getIntermediate_Login().click();
			Thread.sleep(2000);
			login.getEnter_Matrid().sendKeys( "IYR242926");
			login.getEnter_passwrd().sendKeys( "cbstest");
			login.getEnter_Login().click();

		} catch (Exception e) {
			System.out.println("Already Login.................");
	   }
		//=================>INTERMEDIATE PAGES================
		try {

			Thread.sleep(4000);
			BaseTest.click(login.getInter_close());
			System.out.println("intermediate page Handled......");

		} catch (Exception e) {
			System.out.println("no intermediate page displayed.....");
		}

		try {

			Thread.sleep(4000);
			BaseTest.click(driver.findElement(By.xpath("//*[@id='skip']")));
			System.out.println("Payment intermediate page Handled.....");

		} catch (Exception e) {
			System.out.println("no Payment intermediate page Handled .....");
		}

		try {

			Thread.sleep(4000);
			BaseTest.click(login.getQuickrespnse_clse_btn());
			System.out.println("quick Response page Handled ......");

		} catch (Exception e) {
			System.out.println("no quick response page displayed .....");
		}
		//========================> MENU SECTION=================
				Thread.sleep(2000);
				BaseTest.click(d.getProfile_btn_click());
				Thread.sleep(2000);
				Dimension size = driver.manage().window().getSize();
				int starty = (int) (size.height * 0.80);
				int endy = (int) (size.height * 0.20);
				int startx = size.width / 2;
				SoftAssert asrt=new SoftAssert();
				//=========================> EDIT PP==============
				g.getEditPP().click();
				Thread.sleep(4000);
				g.getPartnerReligious_Edit().click();
				Thread.sleep(2000);
				String divi_pp=g.getDivision_pp().getText();
				System.out.println("Division: "+divi_pp);
				String[] pp_division=divi_pp.split(",");
				
				String sect_pp=g.getSect_pp().getText();
				System.out.println("Sect: "+divi_pp);
				String[] pp_sect=sect_pp.split(",");
				//=============Navigating Back From EPP========
						Thread.sleep(3000);
						g.getEppBack().click();
						Thread.sleep(3000);
						g.getEppBack().click();
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					Thread.sleep(4000);
			     g.getHomeIcon().click();
		        Thread.sleep(3000);
		        String[] s= {"JUST JOINED","MATCHES","PREMIUM","MUTUAL","VIEWED NOT CONTACTED","SHORTLISTED","VIEWED MY PROFILE","SHORTLISTED ME","NEARBY MATCHES","PREFERRED PROFESSION","PREFERRED EDUCATION","PREFERRED STAR","PREFERRED LOCATION"};   
		        for(String listname:s) {
		        	Thread.sleep(3000);
		        	System.out.println("Verifying Subcaste in "+listname);
		        	driver.findElementByXPath("//*[@text='"+listname+"']").click();
					Thread.sleep(3000);
					List<AndroidElement> lst=driver.findElementsByXPath("//*[@id='profileMatriId']");
					String count=g.getProfileListCount().getText();
					String[] arr = count.split(" ");    
					String a=arr[0];
					int listcount = Integer.parseInt(a);	
					if(lst.size()>0) {
						System.out.println("List count in "+listname+" : "+listcount);
						lst.get(0).click();
						Thread.sleep(2000);
						//for( int i=1;i<listcount-2;i++) { 
						for( int i=1;i<=2;i++) {
							Thread.sleep(4000);
							String oppMatriId=g.getMatriId_VP().getText();
							Thread.sleep(2000);
							driver.swipe(startx, starty, startx, endy, 3000);
							Thread.sleep(4000);
							g.getHoroscopeIcon_vp().click();
							Thread.sleep(4000);
							//==============Fetching   Sect & division ===============
							
							String vp_division=g.getDivision_pp().getText();
						    System.out.println("Divsion in VP: "+pp_division);
						    
						    String vp_sect=g.getSect_pp().getText();
						    System.out.println("Sect in VP: "+vp_sect);
						    
			                System.out.println("Verifying vp Division with pp............");
						    if(!divi_pp.equalsIgnoreCase("Any")){
						    	 boolean statusDivi=false;
						    	 for(int j=0;j<=pp_division.length-1;j++){
						    		 if(vp_division.equalsIgnoreCase(pp_division[j])){
						    			    statusDivi=true;
									    	System.out.println("View profile  Division : "+vp_division+" is matching with pp "+pp_division[j]);
									    }
						    		 
						    	 }
								    
								    asrt.assertTrue(statusDivi, "View profile: " +oppMatriId+" Division is not as per PP values");
						    }
						    
						    System.out.println("Verifying vp Sect with pp............");
						    if(!sect_pp.equalsIgnoreCase("Any")){
						    	 boolean statusSect=false;
						    	 for(int j=0;j<=pp_sect.length-1;j++){
						    		 if(vp_sect.equalsIgnoreCase(pp_sect[j])){
						    			 statusSect=true;
									    	System.out.println("View profile Sect: "+vp_sect+"  is matching with pp "+pp_sect[j]);
									    }
						    		 
						    	 }
								    
								    asrt.assertTrue(statusSect, "View profile: " +oppMatriId+" Sect is not as per PP values");
						    }	
						    
						    //==============Navigating to Next Profile===============
						    try {
								g.getNextProfile_btn().click();
							} catch (Exception e) {
								break;
							}	
						}
					}else {
						System.out.println("No profiles found in "+listname);
						
					}
		        }
		        asrt.assertAll();
			
			
			
		
		}
    
		

}




