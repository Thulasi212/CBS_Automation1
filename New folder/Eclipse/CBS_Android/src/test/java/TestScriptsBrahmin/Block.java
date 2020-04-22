package TestScriptsBrahmin;


import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import Base1.BaseBrahmin;
import POMBrahmin.Login;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class Block extends BaseBrahmin {
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
         dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.brahminmatrimony");
         dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.domaininstance.ui.activities.Splash");
         driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
         driver.setLogLevel(Level.INFO);


    }

    @Test
    public void blockTest() throws Exception {
    	
    	Login l = new Login(driver);
    	try {
    	Thread.sleep(5000);
    	BaseBrahmin.click(l.getChooseLogin());
    	Thread.sleep(5000);
    	BaseBrahmin.click(l.getMatriId());
    	BaseBrahmin.typeData(l.getMatriId(), BaseBrahmin.readValueFromExcelSheet().get(1).get("UserName"));
    	Thread.sleep(5000);
    	BaseBrahmin.click(l.getPassword());
    	BaseBrahmin.typeData(l.getPassword(), BaseBrahmin.readValueFromExcelSheet().get(1).get("PassWord"));
    	
    	Thread.sleep(5000);
    	BaseBrahmin.click(l.getIdLogin()); 
    	} catch (Exception e) {
    		System.out.println("Already Logged In");
    	}
    	Thread.sleep(10000);
    	try {
    		BaseBrahmin.click(l.getQuick_Tour_Skip());
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
    		BaseBrahmin.click(l.getQuick_response_popup());
		} catch (Exception e) {
			System.out.println("The Quick Response page handled Successfully");
		}
    	Thread.sleep(5000);
    	try {
    		BaseBrahmin.click(l.getNotification_access_later());
		} catch (Exception e) {
			System.out.println("Notification handled");
		}
    	
    	Thread.sleep(5000);
    	BaseBrahmin.click(l.getLatest_matches());
    	
    	Thread.sleep(5000);
    	String block_id = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[1]")).getText();
    	
     	System.out.println(block_id);
     	
     	try {
     		 Thread.sleep(5000);
             if (l.getIgnore_block_dropdown().isDisplayed()) {
            	 Thread.sleep(5000);
            	 BaseBrahmin.click(l.getIgnore_block_dropdown());
             	 Thread.sleep(5000);
             	BaseBrahmin.click(l.getBlock());
             	Thread.sleep(5000);
             	BaseBrahmin.click(l.getConfirm_ignore_block());
    			} else {
                 System.out.println("There is no profile to Block");
    			}
		} catch (Exception e) {
			 System.out.println("There is no profile to Block");
		}
     	
	    	
         
         Thread.sleep(5000);
         BaseBrahmin.click(l.getMenu_button());
         
         driver.swipe(0, 1100, 0, 0, 1000);
         
         Thread.sleep(5000);
         BaseBrahmin.click(l.getAccount_settings());
         
         Thread.sleep(5000);
         BaseBrahmin.click(l.getBlocked_profiles());
         
         Thread.sleep(5000);
         String block_id1 = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[1]")).getText();
         
         if (block_id.equals(block_id1)) {
        	 
        	 System.out.println("The Blocked ID Matches ");
			
		} else  if (driver.findElement(By.xpath("(//*[@id='profileMatriId'])[2]")).isDisplayed()) {
        	
        	String block_id2 = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[2]")).getText();
        	
        	boolean equals = block_id.equals(block_id2);
        	
        	System.out.println("The Blocked ID Matches " + equals);
			
		}  else {
			
            System.out.println("The ID not matches");
		}
         
         
         
         
         
    }
    
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}