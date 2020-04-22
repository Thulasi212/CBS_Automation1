package EditPP_TestScripts;
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

public class GothraSearch_MultiplePPvalues {
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
	//Login-->Edit PP--> selecting multiple gothra values -->Search-->tapping on Search Now
	//-->view profile-->checking gotham for search profiles by tapping on Next profile button(vp gothra should be based on pp values)
    @Test(enabled=true)
    public void gothraSearchTest3() throws Throwable {
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
		Thread.sleep(3000);
		//=========================> EDIT PP==============
		g.getEditPP().click();
		Thread.sleep(5000);
		g.getPartnerReligious_Edit().click();
		Thread.sleep(4000);
		String gothram=g.getPartnerGothra_Edit().getText();
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		if(gothram.equalsIgnoreCase("All Except My Gothra(m)")) {
			System.out.println("Gothram in EditPP: "+gothram);
		}
		else if(gothram.equalsIgnoreCase("any"))System.out.println("Gothram in EditPP: "+gothram);
		else {
			System.out.println("Gothram in EditPP: "+gothram);
			gothram = gothram.replaceAll(",", "");
			System.out.println("Gothram in EditPP: "+gothram);
			String[] gothra_pp = gothram.split(" ");  
			System.out.println("Gothra values size  in PP: "+gothra_pp.length);
			BaseTest.click(login.getNavigate_back_btn());
			Thread.sleep(3000);
			BaseTest.click(login.getNavigate_back_btn());
			g.getSearch().click();
			Thread.sleep(3000);
			g.getSearchNow().click();
			Thread.sleep(3000);
			List<AndroidElement> lst=driver.findElementsByXPath("//*[@id='profileMatriId']");
			if(lst.size()>0) {
				lst.get(0).click();
				SoftAssert asrt=new SoftAssert();
				for( int i=1;i<=20;i++) {
					Thread.sleep(4000);
					String matriId=g.getMatriId_VP().getText();
					Thread.sleep(2000);
					driver.swipe(startx, starty, startx, endy, 3000);
					Thread.sleep(2000);
					g.getHoroscopeIcon_vp().click();
					Thread.sleep(2000);
					boolean vp_gothram_status=false;
					String gothra_VP=null;
					try {
						gothra_VP=g.getGotham_vp().getText();
						vp_gothram_status=true;
					}catch(Exception e) {System.out.println("profile "+i+" do not have Gothram");}
						
					if(vp_gothram_status) {
						boolean status=false;
						for(int k=0;k<=gothra_pp.length-1;k++) {
							if(gothra_pp[k].equalsIgnoreCase(gothra_VP)) {
								status=true;
								System.out.println("profile"+i+" : "+matriId+" gothram :"+gothra_VP+" is matching with PP gothram: "+gothra_pp[k]);
								break;
							}	
						}
						asrt.assertTrue(status, "gothra not matching for profile "+i+" : "+matriId);
						try {g.getNextProfile_btn().click();}
						catch(Exception e) {break;}	
					} 
				}
				asrt.assertAll();
				BaseTest.click(login.getNavigate_back_btn());
				Thread.sleep(3000);
				BaseTest.click(login.getNavigate_back_btn());
				
			}else {
				System.out.println("No profiles found in Search");
				
			}
			}
			
			
			
			
		}
		
		
    
}

