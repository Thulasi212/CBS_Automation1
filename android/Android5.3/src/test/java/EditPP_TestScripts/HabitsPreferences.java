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

public class HabitsPreferences {
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

     //Login-->Edit PI-->Edit PP-->fetching Habit Preferences  in Epp-->Search-->tapping on Search Now
  	//-->getting profile list count-->view profile-->checking PP  value  with Vp value by tapping on Next profile button
    @Test(enabled=false)
    public void habitsPreferences_SearchTest() throws Throwable {
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
		driver.swipe(startx, starty, startx, endy, 3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Fetching Habit Preferences...........");
		String pp_eat=pp.getEatingHabits().getText();
	    System.out.println("Eating Habits in PP: "+pp_eat);
	    String[] pp_eatHabits=pp_eat.split(",");
	    
	    String pp_drink=pp.getDrikingHabits().getText();
	    System.out.println("Drinking Habits in PP: "+pp_drink);
	    String[] pp_drinkHabits=pp_drink.split(",");
	    
	    String pp_smoke=pp.getSmokingHabits().getText();
	    System.out.println("Smoking Habits in PP: "+pp_smoke);
	    String[] pp_smokeHabits=pp_smoke.split(",");
		
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
				pp.getHoroscopeIcon_vp().click();
				driver.swipe(startx, starty, startx, endy, 2000);
				Thread.sleep(4000);
				//==============Fetching   Habits ===============
				
				String vp_eatHabits=pp.getEatingHabits().getText();
			    System.out.println("Eating Habits in VP: "+vp_eatHabits);
			    
			    String vp_drinkHabits=pp.getDrikingHabits().getText();
			    System.out.println("Drinking Habits in VP: "+vp_drinkHabits);
			    
			    
			    String vp_smokeHabits=pp.getSmokingHabits().getText();
			    System.out.println("Smoking Habits in VP: "+vp_smokeHabits);
				
                System.out.println("Verifying vp Eating Habits with pp............");
			    if(!pp_eat.equalsIgnoreCase("Doesn't matter")){
			    	 boolean statusEat=false;
			    	 for(int j=0;j<=pp_eatHabits.length-1;j++){
			    		 if(vp_eatHabits.equalsIgnoreCase(pp_eatHabits[j])){
			    			    statusEat=true;
						    	System.out.println("View profile Eating habits: "+vp_eatHabits+"  is matching with pp "+pp_eatHabits[j]);
						    }
			    		 
			    	 }
					    
					    asrt.assertTrue(statusEat, "View profile: " +oppMatriId+" Eating Habits are not as per PP values");
			    }
			    
			    System.out.println("Verifying vp Drinking Habits with pp............");
			    if(!pp_drink.equalsIgnoreCase("Doesn't matter")){
			    	 boolean statusDrink=false;
			    	 for(int j=0;j<=pp_drinkHabits.length-1;j++){
			    		 if(vp_drinkHabits.equalsIgnoreCase(pp_drinkHabits[j])){
			    			    statusDrink=true;
						    	System.out.println("View profile Drinking habits: "+vp_drinkHabits+"  is matching with pp "+pp_drinkHabits[j]);
						    }
			    		 
			    	 }
					    
					    asrt.assertTrue(statusDrink, "View profile: " +oppMatriId+" Drinking Habits are not as per PP values");
			    }	
			    
			    System.out.println("Verifying vp Smoking Habits with pp............");
			    if(!pp_smoke.equalsIgnoreCase("Doesn't matter")){
			    	 boolean statusSmoke=false;
			    	 for(int j=0;j<=pp_smokeHabits.length-1;j++){
			    		 if(vp_smokeHabits.equalsIgnoreCase(pp_smokeHabits[j])){
			    			    statusSmoke=true;
						    	System.out.println("View profile Smoke habits: "+vp_smokeHabits+"  is matching with pp "+pp_smokeHabits[j]);
						    }
			    		 
			    	 }
					    
					    asrt.assertTrue(statusSmoke, "View profile: " +oppMatriId+" Smoking Habits are not as per PP values");
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
    public void habitsPreferences_ListingsTest() throws Throwable {
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
				driver.swipe(startx, starty, startx, endy, 3000);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				System.out.println("Fetching Habit Preferences...........");
				String pp_eat=pp.getEatingHabits().getText();
			    System.out.println("Eating Habits in PP: "+pp_eat);
			    String[] pp_eatHabits=pp_eat.split(",");
			    
			    String pp_drink=pp.getDrikingHabits().getText();
			    System.out.println("Drinking Habits in PP: "+pp_drink);
			    String[] pp_drinkHabits=pp_drink.split(",");
			    
			    String pp_smoke=pp.getSmokingHabits().getText();
			    System.out.println("Smoking Habits in PP: "+pp_smoke);
			    String[] pp_smokeHabits=pp_smoke.split(",");
				
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
					for( int i=1;i<=2;i++) {
						Thread.sleep(4000);
						String oppMatriId=pp.getMatriId_VP().getText();
						Thread.sleep(2000);
						driver.swipe(startx, starty, startx, endy, 3000);
						Thread.sleep(4000);
						pp.getHoroscopeIcon_vp().click();
						driver.swipe(startx, starty, startx, endy, 2000);
						Thread.sleep(4000);
						//==============Fetching   Habits ===============
						
						String vp_eatHabits=pp.getEatingHabits().getText();
					    System.out.println("Eating Habits in VP: "+vp_eatHabits);
					    
					    String vp_drinkHabits=pp.getDrikingHabits().getText();
					    System.out.println("Drinking Habits in VP: "+vp_drinkHabits);
					    
					    
					    String vp_smokeHabits=pp.getSmokingHabits().getText();
					    System.out.println("Smoking Habits in VP: "+vp_smokeHabits);
						
		                System.out.println("Verifying vp Eating Habits with pp............");
					    if(!pp_eat.equalsIgnoreCase("Doesn't matter")){
					    	 boolean statusEat=false;
					    	 for(int j=0;j<=pp_eatHabits.length-1;j++){
					    		 if(vp_eatHabits.equalsIgnoreCase(pp_eatHabits[j])){
					    			    statusEat=true;
								    	System.out.println("View profile Eating habits: "+vp_eatHabits+"  is matching with pp "+pp_eatHabits[j]);
								    }
					    		 
					    	 }
							    
							    asrt.assertTrue(statusEat, "View profile: " +oppMatriId+" Eating Habits are not as per PP values");
					    }
					    
					    System.out.println("Verifying vp Drinking Habits with pp............");
					    if(!pp_drink.equalsIgnoreCase("Doesn't matter")){
					    	 boolean statusDrink=false;
					    	 for(int j=0;j<=pp_drinkHabits.length-1;j++){
					    		 if(vp_drinkHabits.equalsIgnoreCase(pp_drinkHabits[j])){
					    			    statusDrink=true;
								    	System.out.println("View profile Drinking habits: "+vp_drinkHabits+"  is matching with pp "+pp_drinkHabits[j]);
								    }
					    		 
					    	 }
							    
							    asrt.assertTrue(statusDrink, "View profile: " +oppMatriId+" Drinking Habits are not as per PP values");
					    }	
					    
					    System.out.println("Verifying vp Smoking Habits with pp............");
					    if(!pp_smoke.equalsIgnoreCase("Doesn't matter")){
					    	 boolean statusSmoke=false;
					    	 for(int j=0;j<=pp_smokeHabits.length-1;j++){
					    		 if(vp_smokeHabits.equalsIgnoreCase(pp_smokeHabits[j])){
					    			    statusSmoke=true;
								    	System.out.println("View profile Smoke habits: "+vp_smokeHabits+"  is matching with pp "+pp_smokeHabits[j]);
								    }
					    		 
					    	 }
							    
							    asrt.assertTrue(statusSmoke, "View profile: " +oppMatriId+" Smoking Habits are not as per PP values");
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
