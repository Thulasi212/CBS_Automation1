package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
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

public class GothraTest_Listing {
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
	//Login-->Edit PI-->fetching PI gothram-->Edit PP-->setting gothram value as "All Except my gothram"-->Search-->tapping on Search Now
	//-->getting profile list count-->view profile-->checking gotham in all listing profiles by tapping on Next profile button(PI gothra should not match with opp.member VP gothram)
    @Test(enabled=false)
    public void gothram_ListingTest1() throws Throwable {
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
		//=========================>EDIT PROFILE==================
		Thread.sleep(3000);
		g.getEditProfile().click();
		Thread.sleep(5000);
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		Thread.sleep(2000);
		driver.swipe(startx, starty, startx, endy, 3000);
		Thread.sleep(2000);
		driver.swipe(startx, starty, startx, endy, 3000);
		Thread.sleep(2000);
		driver.swipe(startx, starty, startx, endy, 3000);
		Thread.sleep(2000);
		g.getReligiousEdit_PI().click();
		Thread.sleep(2000);
		String pI_gothram=g.getGothram_PI().getText();
		System.out.println("PI Gothram: "+pI_gothram);
		BaseTest.click(login.getNavigate_back_btn());
		Thread.sleep(3000);
		BaseTest.click(login.getNavigate_back_btn());
		Thread.sleep(2000);
		//=========================> EDIT PP==============
		g.getEditPP().click();
		Thread.sleep(4000);
		g.getPartnerReligious_Edit().click();
		Thread.sleep(2000);
		String gothram=g.getPartnerGothra_Edit().getText();
		System.out.println("Gothram in EditPP: "+gothram);
		if(gothram.equalsIgnoreCase("All Except My Gothra(m)")) {
			BaseTest.click(login.getNavigate_back_btn());
			Thread.sleep(3000);
			BaseTest.click(login.getNavigate_back_btn());
		}else if(gothram.equalsIgnoreCase("any")){
			g.getPartnerGothra_Edit().click();
			System.out.println("Selecting the Gothram as All Except My Gothra(m)");
			g.getPGothra_AllExceptMy().click();
			Thread.sleep(2000);
			g.getPartnerGothra_Submit().click();
			Thread.sleep(4000);
			gothram=g.getPartnerGothra_Edit().getText();
			System.out.println("Gothram in EditPP after modifying: "+gothram);
			g.getPartnerGothra_Save().click();
			Thread.sleep(4000);
			BaseTest.click(login.getNavigate_back_btn());
		}
		else {
			g.getPartnerGothra_Edit().click();
			System.out.println("Selecting the Gothram as All Except My Gothra(m)");
			g.getPGothra_AllExceptMy().click();
			Thread.sleep(4000);
			g.getPartnerGothra_Submit().click();
			Thread.sleep(4000);
			gothram=g.getPartnerGothra_Edit().getText();
			System.out.println("Gothram in EditPP after modifying: "+gothram);
			g.getPartnerGothra_Save().click();
			BaseTest.click(login.getNavigate_back_btn());
		}
		//==================> Listings ========================
		        g.getHomeIcon().click();
		        Thread.sleep(3000);
		        String[] s= {"JUST JOINED","MATCHES","PREMIUM","MUTUAL","VIEWED NOT CONTACTED","SHORTLISTED","VIEWED MY PROFILE","SHORTLISTED ME","NEARBY MATCHES","PREFERRED PROFESSION","PREFERRED EDUCATION","PREFERRED STAR","PREFERRED LOCATION"};   
		        for(String listname:s) {
		        	Thread.sleep(3000);
		        	System.out.println("Verifying Gothra in "+listname);
		        	driver.findElementByXPath("//*[@text='"+listname+"']").click();
					Thread.sleep(3000);
					List<AndroidElement> lst=driver.findElementsByXPath("//*[@id='profileMatriId']");
					if(lst.size()>0) {
						String count=g.getProfileListCount().getText();
						String[] arr = count.split(" ");    
						String a=arr[0];
						int listcount = Integer.parseInt(a);			
						System.out.println("List count in "+listname+" : "+listcount);
						lst.get(0).click();
						Thread.sleep(2000);
						//for( int i=1;i<listcount-2;i++) { 
						for( int i=1;i<=3;i++) { 
							Thread.sleep(2000);
							driver.swipe(startx, starty, startx, endy, 3000);
							Thread.sleep(2000);
							g.getHoroscopeIcon_vp().click();
							Thread.sleep(2000);
							try {
								String gothra_VP=g.getGotham_vp().getText();
								System.out.println("Gothram for Profile "+i+": "+gothra_VP);
								SoftAssert asrt=new SoftAssert();
								asrt.assertNotEquals(gothra_VP, pI_gothram, "VP "+i+" gothram is same as PI"); 
								System.out.println("Gothra for Profile "+i+" : "+g.getMatriId_VP().getText()+" is verified successfully ");
							}catch(Exception e) {
	                            System.out.println("Member do not have Gothra");
							}
							if(i<listcount-2) g.getNextProfile_btn().click();
							else {break;}	
							
						}
						BaseTest.click(login.getNavigate_back_btn());
						
					}else {
						System.out.println("No profiles found in "+listname);
						
					}
					
		        }
		        }
    @Test(enabled = true)
    public void gothram_ListingTest2() throws Throwable {
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
		//=========================>EDIT PROFILE==================
		Thread.sleep(3000);
		g.getEditProfile().click();
		Thread.sleep(5000);
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		driver.swipe(startx, starty, startx, endy, 3000);
		Thread.sleep(2000);
		driver.swipe(startx, starty, startx, endy, 3000);
		Thread.sleep(2000);
		driver.swipe(startx, starty, startx, endy, 3000);
		Thread.sleep(2000);
		g.getReligiousEdit_PI().click();
		Thread.sleep(2000);
		String pI_gothram=g.getGothram_PI().getText();
		System.out.println("PI Gothram: "+pI_gothram);
		g.getGothram_PI().click();
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@text='Agasthi']").click();
		Thread.sleep(3000);
		pI_gothram=g.getGothram_PI().getText();
		System.out.println("PI Gothram: "+pI_gothram);
		Thread.sleep(3000);
		g.getPartnerGothra_Save().click();
		Thread.sleep(3000);
		BaseTest.click(login.getNavigate_back_btn());
		Thread.sleep(2000);
		//=========================> EDIT PP==============
		g.getEditPP().click();
		Thread.sleep(4000);
		g.getPartnerReligious_Edit().click();
		Thread.sleep(2000);
		String gothram=g.getPartnerGothra_Edit().getText();
		System.out.println("Gothram in EditPP: "+gothram);
		if(gothram.equalsIgnoreCase("All Except My Gothra(m)")) {
			BaseTest.click(login.getNavigate_back_btn());
			Thread.sleep(3000);
			BaseTest.click(login.getNavigate_back_btn());
		}else if(gothram.equalsIgnoreCase("any")){
			g.getPartnerGothra_Edit().click();
			System.out.println("Selecting the Gothram as All Except My Gothra(m)");
			g.getPGothra_AllExceptMy().click();
			Thread.sleep(2000);
			g.getPartnerGothra_Submit().click();
			Thread.sleep(4000);
			gothram=g.getPartnerGothra_Edit().getText();
			System.out.println("Gothram in EditPP after modifying: "+gothram);
			g.getPartnerGothra_Save().click();
			Thread.sleep(4000);
			BaseTest.click(login.getNavigate_back_btn());
		}
		else {
			g.getPartnerGothra_Edit().click();
			System.out.println("Selecting the Gothram as All Except My Gothra(m)");
			g.getPGothra_AllExceptMy().click();
			Thread.sleep(4000);
			g.getPartnerGothra_Submit().click();
			Thread.sleep(4000);
			gothram=g.getPartnerGothra_Edit().getText();
			System.out.println("Gothram in EditPP after modifying: "+gothram);
			g.getPartnerGothra_Save().click();
			BaseTest.click(login.getNavigate_back_btn());
		}
		//==================> Listings ========================
        g.getHomeIcon().click();
        Thread.sleep(3000);
        String[] s= {"JUST JOINED","MATCHES","PREMIUM","MUTUAL","VIEWED NOT CONTACTED","SHORTLISTED","VIEWED MY PROFILE","SHORTLISTED ME","NEARBY MATCHES","PREFERRED PROFESSION","PREFERRED EDUCATION","PREFERRED STAR","PREFERRED LOCATION"};   
        for(String listname:s) {
        	Thread.sleep(3000);
        	System.out.println("Verifying Gothra in "+listname);
        	driver.findElementByXPath("//*[@text='"+listname+"']").click();
			Thread.sleep(3000);
			List<AndroidElement> lst=driver.findElementsByXPath("//*[@id='profileMatriId']");
			if(lst.size()>0) {
				String count=g.getProfileListCount().getText();
				String[] arr = count.split(" ");    
				String a=arr[0];
				int listcount = Integer.parseInt(a);			
				System.out.println("List count in "+listname+" : "+listcount);
				lst.get(0).click();
				Thread.sleep(2000);
				//for( int i=1;i<listcount-2;i++) { 
				for( int i=1;i<=3;i++) { 
					Thread.sleep(2000);
					driver.swipe(startx, starty, startx, endy, 3000);
					Thread.sleep(2000);
					g.getHoroscopeIcon_vp().click();
					Thread.sleep(2000);
					try {
						String gothra_VP=g.getGotham_vp().getText();
						System.out.println("Gothram for Profile "+i+": "+gothra_VP);
						SoftAssert asrt=new SoftAssert();
						asrt.assertNotEquals(gothra_VP, pI_gothram, "VP gothram is same as PI");   	
						System.out.println("Gothra for Profile "+i+" : "+g.getMatriId_VP().getText()+" is verified successfully ");
					}catch(Exception e) {
                        System.out.println("Member do not have Gothra");
					}
					if(i<listcount-2) g.getNextProfile_btn().click();
					else {break;}	
					
				}
				BaseTest.click(login.getNavigate_back_btn());
				
			}else {
				System.out.println("No profiles found in "+listname);
				
			}
			
        }
    }
    

}

