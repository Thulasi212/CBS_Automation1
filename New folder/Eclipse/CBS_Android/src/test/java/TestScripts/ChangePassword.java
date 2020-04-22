package TestScripts;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.eclipse.jetty.util.security.Password;
import org.jsoup.Connection.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.PasswordChange;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class ChangePassword extends BaseTest {
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

    @Test(priority=1)
    public void passwordChangeTest() throws InterruptedException {
    	
    	
    	PasswordChange c = new PasswordChange(driver);
    	
    	try {
			BaseTest.click(c.getHome_Login_btn());
		} catch (Exception e) {
			System.out.println("Already in Login Page");
		}
    	
    	
    	Thread.sleep(5000);
    	BaseTest.click(c.getMatri_Id());
    	
    	Thread.sleep(5000);
    	BaseTest.typeData(c.getMatri_Id(), BaseTest.readValueFromExcelSheet().get(1).get("Username"));
    	
    	Thread.sleep(5000);
    	BaseTest.click(c.getPassword());
    	
    	Thread.sleep(5000);
    	BaseTest.typeData(c.getPassword(), BaseTest.readValueFromExcelSheet().get(1).get("Password"));
    		
    	
    	Thread.sleep(5000);
    	BaseTest.click(c.getLogin_btn());
    	
    	Thread.sleep(10000);
    	try {
			BaseTest.click(c.getQuick_tour_skip());
		} catch (Exception e) {
			System.out.println("The tour page was not Displayed");
		}
    	
    	Thread.sleep(5000);
    	try {
			BaseTest.click(c.getQuick_tour_back_btn());
		} catch (Exception e) {
            System.out.println("The tour page was not displayed");          
        }
    	
    	Thread.sleep(5000);
    	try {
			BaseTest.click(c.getDaily_match_click());
			Thread.sleep(5000);
			BaseTest.click(c.getDaily_match_back());
		} catch (Exception e) {
			System.out.println("Daily match page was  not displayed");
		}
    	
    	try {
    		Thread.sleep(5000);
        	BaseTest.click(c.getNotification_later());
		} catch (Exception e) {
			System.out.println("No notification button");
		}
    	
    	
    	Thread.sleep(5000);
    	BaseTest.click(c.getMenu_btn());
    	
    	Thread.sleep(5000);
    	driver.swipe(0, 1000, 0, 0, 1000);
    	
    	Thread.sleep(5000);
    	BaseTest.click(c.getAccount_setting());
    	
    	
    	Thread.sleep(5000);
    	BaseTest.click(c.getChange_password_btn());
    	
    	
    	Thread.sleep(5000);
    	BaseTest.click(c.getOld_password());
    	
    	Thread.sleep(5000);
    	BaseTest.typeData(c.getOld_password(), BaseTest.readValueFromExcelSheet().get(1).get("Password"));
    	
    
    	
    	Thread.sleep(5000);
    	BaseTest.click(c.getNew_password());
    	
    	Thread.sleep(5000);
    	BaseTest.typeData(c.getNew_password(), BaseTest.readValueFromExcelSheet().get(1).get("New Password"));
    	
    	Thread.sleep(5000);
    	BaseTest.click(c.getConfirm_password());
    	
    	Thread.sleep(5000);
    	BaseTest.typeData(c.getConfirm_password(), BaseTest.readValueFromExcelSheet().get(1).get("New Password"));
    	
    	Thread.sleep(5000);
    	BaseTest.click(c.getSave_password());
    	
    	Thread.sleep(5000);
    	BaseTest.click(c.getLogout());
    	
    }
    
    
    	@Test(priority=2)
    	 public void passwordChangeTest1() throws InterruptedException {
    	
    		PasswordChange c = new PasswordChange(driver);
    		
    		try {
    			BaseTest.click(c.getHome_Login_btn());
    		} catch (Exception e) {
    			System.out.println("Already in Login Page");
    		}
        	
        	
        	Thread.sleep(5000);
        	BaseTest.click(c.getMatri_Id());
        	
        	Thread.sleep(5000);
        	BaseTest.typeData(c.getMatri_Id(), BaseTest.readValueFromExcelSheet().get(1).get("Username"));
        	
        	Thread.sleep(5000);
        	BaseTest.click(c.getPassword());
        	
        	Thread.sleep(5000);
        	BaseTest.typeData(c.getPassword(), BaseTest.readValueFromExcelSheet().get(1).get("New Password"));
        	
        	Thread.sleep(5000);
        	BaseTest.click(c.getLogin_btn());
        	
        	Thread.sleep(10000);
        	try {
    			BaseTest.click(c.getQuick_tour_skip());
    		} catch (Exception e) {
    			System.out.println("The tour page was not Displayed");
    		}
        	
        	Thread.sleep(5000);
        	try {
    			BaseTest.click(c.getQuick_tour_back_btn());
    		} catch (Exception e) {
                System.out.println("The tour page was not displayed");          
            }
        	
        	Thread.sleep(5000);
        	try {
    			BaseTest.click(c.getDaily_match_click());
    			Thread.sleep(5000);
    			BaseTest.click(c.getDaily_match_back());
    		} catch (Exception e) {
    			System.out.println("Daily match page was  not displayed");
    		}
        	
        	try {
        		Thread.sleep(5000);
            	BaseTest.click(c.getNotification_later());
			} catch (Exception e) {
				System.out.println("No notification button");
			}
        	
        	
        	
        	Thread.sleep(5000);
        	BaseTest.click(c.getMenu_btn());
        	
        	Thread.sleep(5000);
        	driver.swipe(0, 1000, 0, 0, 1000);
        	
        	Thread.sleep(5000);
        	BaseTest.click(c.getAccount_setting());
    	
        	
        	Thread.sleep(5000);
        	BaseTest.click(c.getLogout());
    	
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}