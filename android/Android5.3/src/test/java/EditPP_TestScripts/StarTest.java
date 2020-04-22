package EditPP_TestScripts;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
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

public class StarTest {
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
     //Login-->Edit PI-->Edit PP-->fetching star value in Epp-->Search-->tapping on Search Now
  	//-->getting profile list count-->view profile-->checking PP star value  with Vp value by tapping on Next profile button
    @Test(enabled = false)
    public void star_SearchTest() throws Throwable {
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
		//=========================> EDIT PP==============
		g.getEditPP().click();
		Thread.sleep(4000);
		g.getPartnerReligious_Edit().click();
		Thread.sleep(5000);
		String starPP=g.getStarEdit().getText();
		if(starPP.equalsIgnoreCase("any")) {
			System.out.println("Star value in EditPP: "+starPP + " ,please select multiple star values manually in EPP and run the script" );
		}
		else {
			starPP = starPP.replaceAll(",", "");
			System.out.println("star in EditPP: "+starPP);
			String[] starValuesPP = starPP.split(" ");  
			System.out.println("star values size  in PP: "+starValuesPP.length);
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
				for( int i=1;i<=10;i++) {
					Thread.sleep(4000);
					String matriId=g.getMatriId_VP().getText();
					Thread.sleep(2000);
					driver.swipe(startx, starty, startx, endy, 3000);
					Thread.sleep(2000);
					g.getHoroscopeIcon_vp().click();
					Thread.sleep(2000);
					boolean status=false;
					String star_VP=null;
					try {
						star_VP=g.getStar_vp().getText();
						status=true;
					}catch(Exception e) {System.out.println("profile "+i+" do not have star");}
						
					if(status) {
						boolean status1=false;
						for(int k=0;k<=starValuesPP.length-1;k++) {
							if(starValuesPP[k].equalsIgnoreCase(star_VP)) {
								status1=true;
								System.out.println("profile"+i+" "+matriId+" vp star "+star_VP+" is matching with PP star "+starValuesPP[k]);
								break;
							}	
						}
						asrt.assertTrue(status1, "star not matching for profile "+i+" : "+matriId);
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
    //Login-->Edit PI-->Edit PP-->fetching star value in Epp-->Search-->navigating to listing 
  	//-->getting profile list count-->view profile-->checking PP star value  with Vp value by tapping on Next profile button
    @Test(enabled = true)
    public void star_ListingTest() throws Throwable {
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
		String starPP=g.getStarEdit().getText();
		if(starPP.equalsIgnoreCase("any")) {
			System.out.println("Star value in EditPP: "+starPP + " ,please select multiple star values manually in EPP and run the script" );
		}
		else {
			starPP = starPP.replaceAll(",", "");
			System.out.println("star in EditPP: "+starPP);
			String[] starValuesPP = starPP.split(" ");  
			System.out.println("star values size  in PP: "+starValuesPP.length);
			BaseTest.click(login.getNavigate_back_btn());
			Thread.sleep(3000);
			BaseTest.click(login.getNavigate_back_btn());
			Thread.sleep(4000);
			 g.getHomeIcon().click();
		        Thread.sleep(3000);
		        String[] s= {"JUST JOINED","MATCHES","PREMIUM","MUTUAL","VIEWED NOT CONTACTED","SHORTLISTED","VIEWED MY PROFILE","SHORTLISTED ME","NEARBY MATCHES","PREFERRED PROFESSION","PREFERRED EDUCATION","PREFERRED STAR","PREFERRED LOCATION"};   
		        for(String listname:s) {
		        	Thread.sleep(5000);
		        	System.out.println("Verifying Gothra in "+listname);
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
						for( int i=1;i<=10;i++) { 
							Thread.sleep(4000);
							String matriId=g.getMatriId_VP().getText();
							Thread.sleep(2000);
							driver.swipe(startx, starty, startx, endy, 3000);
							Thread.sleep(2000);
							g.getHoroscopeIcon_vp().click();
							Thread.sleep(2000);
							boolean status=false;
							String star_VP=null;
							try {
								star_VP=g.getStar_vp().getText();
								status=true;
							}catch(Exception e) {System.out.println("profile "+i+" do not have star");}
								
							if(status) {
								boolean status1=false;
								for(int k=0;k<=starValuesPP.length-1;k++) {
									if(starValuesPP[k].equalsIgnoreCase(star_VP)) {
										status1=true;
										System.out.println("profile"+i+" "+matriId+" vp star "+star_VP+" is matching with PP star "+starValuesPP[k]);
										break;
									}	
								}
								asrt.assertTrue(status1, "star not matching for profile "+i+" : "+matriId);
								try {g.getNextProfile_btn().click();}
								catch(Exception e) {break;}	
							} 	
							
						}
						BaseTest.click(login.getNavigate_back_btn());
						
						
					}else {
						System.out.println("No profiles found in "+listname);
						
					}
		        }
		        asrt.assertAll();
						
		
		}
    }
		

}



