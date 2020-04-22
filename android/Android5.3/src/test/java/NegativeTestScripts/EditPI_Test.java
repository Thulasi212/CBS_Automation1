package NegativeTestScripts;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseTest;
import POM.Delete_POM;
import POM.EPP_Pom;
import POM.EditPI_Page;
import POM.IntermediatePages;
import POM.LoginPage;
import POM.Login_Pom;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class EditPI_Test {
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
	//Login-->Edit Pi-->Edit Basic details-->save name fieldas blank and verify error message
	   @Test(enabled=false)
       public void gothramListingTest1() throws Throwable {
		Login_Pom login = new Login_Pom(driver);
	    EditPI_Page pi=new EditPI_Page(driver);
	    EPP_Pom pp=new EPP_Pom(driver);
		Thread.sleep(2000);
		//=================>LOGIN==============================	
				String matriId=BaseTest.getExcelData("LoginDetails",1,1);
				String pwd=BaseTest.getExcelData("LoginDetails", 1, 2);	
				LoginPage.loginToApp(driver,matriId,pwd);
				IntermediatePages.skipIntermediatePages(driver);
				Thread.sleep(2000);
				pi.getProfileIcon().click();
				Thread.sleep(2000);
				//=========================>EDIT PI============
				SoftAssert asrt=new SoftAssert();
				org.openqa.selenium.Dimension size = driver.manage().window().getSize();
				int starty = (int) (size.height * 0.80);
				int endy = (int) (size.height * 0.20);
				int startx = size.width / 2;
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Thread.sleep(5000);
				//driver.swipe(startx, starty, startx, endy, 3000);
				pi.getEditProfile().click();
				Thread.sleep(4000);
				driver.swipe(startx, starty, startx, endy, 3000);
				pi.getBasicDetailsEdit().click();
				Thread.sleep(4000);
				pi.getName().clear();
				Thread.sleep(1000);
				pi.getSave().click();
				Thread.sleep(4000);
				String expMsgName="Please enter name";
				String actMsgName=pi.getErrorMessage().getText();
				asrt.assertEquals(expMsgName, actMsgName, "Error message is not equal for name field");
				pi.getPopup_Ok().click();
				pi.getMaritalStatus().click();
				Thread.sleep(3000);
				pi.getMaritalStatusValue2().click();
				Thread.sleep(1000);
				pi.getSave().click();
				Thread.sleep(3000);
				String extMsgNoChildren="Please select No.of Children";
				String actMsgNoChildren=pi.getErrorMessage().getText();
				asrt.assertEquals(extMsgNoChildren, actMsgNoChildren, "Error message is not equal for No.of Children field");
				pi.getPopup_Ok().click();
				pi.getNoChildren().click();
				Thread.sleep(3000);
				pi.getNochildrenValue1().click();
				Thread.sleep(1000);
				pi.getSave().click();
				Thread.sleep(4000);
				String extMsgChildrenStatus="Please select children living status";
				String actMsgChildrenStatus=pi.getErrorMessage().getText();
				asrt.assertEquals(extMsgChildrenStatus, actMsgChildrenStatus, "Error message is not equal for Children living status field");
				pi.getPopup_Ok().click();
				pi.getlanguagesKnown().click();
				Thread.sleep(2000);
				pi.getLanguagesknownsearch().sendKeys("teluugu");
				String expMsglanguageKnown="No Result Found";
				String actMsglanguageKnown=pi.getLanguagesknownErr().getText();
				asrt.assertEquals(expMsglanguageKnown, actMsglanguageKnown, "Error message is not equal for languages Known field");
				
						
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		
		
		
		
		
		
		
		
    }
}


