package TestScriptsBrahmin;


import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.Login;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class SendInterest extends BaseTest {
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

    @Test
    public void sendInterest() throws Exception {
    	
    	Login l = new Login(driver);
    	try {
    	Thread.sleep(5000);
    	BaseTest.click(l.getChooseLogin());
    	Thread.sleep(5000);
    	BaseTest.click(l.getMatriId());
    	BaseTest.typeData(l.getMatriId(), BaseTest.readValueFromExcelSheet().get(1).get("UserName"));
    	Thread.sleep(5000);
    	BaseTest.click(l.getPassword());
    	BaseTest.typeData(l.getPassword(), BaseTest.readValueFromExcelSheet().get(1).get("PassWord"));
    	
    	Thread.sleep(5000);
    	BaseTest.click(l.getIdLogin());  
    	} catch (Exception e) {
		System.out.println("Already Logged In");
		}
    	Thread.sleep(10000);
    	try {
			BaseTest.click(l.getQuick_Tour_Skip());
		} catch (Exception e) {
			System.out.println("The Tour Page Handled Successfully");
		}
    	
    	try {
			driver.findElement(By.xpath("")).click();
		} catch (Exception e) {
			// TODO: handle exception
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
			BaseTest.click(l.getQuick_response_popup());
		} catch (Exception e) {
			System.out.println("The Quick Response page handled Successfully");
		}
    	Thread.sleep(5000);
    	try {
			BaseTest.click(l.getNotification_access_later());
		} catch (Exception e) {
			System.out.println("Notification handled");
		}
    	
    	Thread.sleep(5000);
    //	BaseTest.click(l.getLatest_matches());
    	driver.findElement(By.xpath("//*[@text='MATCHES']")).click();
    	Thread.sleep(5000);
    	String send_interest_id = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[1]")).getText();
    	Thread.sleep(5000);
    //	WebElement send_Interests = driver.findElement(By.xpath("//*[@text='Send Interest' and @height>0]"));
    	if (l.getSend_interest().isDisplayed()) {
    		Thread.sleep(5000);
    		BaseTest.click(l.getSend_interest());
    	System.out.println(send_interest_id);
    	Thread.sleep(5000);
    		
    		Thread.sleep(5000);
    		try {
				if(driver.findElement(By.xpath("//*[@text='View Number' and @height>0]")).isDisplayed());
				{
					Thread.sleep(5000);
				String Number = driver.findElement(By.xpath("//*[@text='to view her number' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@height>0]]]")).getText();
				System.out.println("Upgrade Now" + Number);
				}
				Thread.sleep(5000);
				if (driver.findElement(By.xpath("//*[@id='tvUpgradeNow']")).isEnabled()) {
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='tvUpgradeNow']")).click();
					Thread.sleep(5000);
					
					BaseTest.click(l.getSkip_membership_package());
					try {
						Thread.sleep(5000);
						BaseTest.click(l.getMembership_call_skip());
					} catch (Exception e2) {
						System.out.println("No Call Now Button");
				}
				}
				
			} catch (Exception e) {
				Thread.sleep(5000);
				if(driver.findElement(By.xpath("//*[@id='send_interestLayout' and @height>0]")).isDisplayed());
				{
					Thread.sleep(5000);
				String Mail = driver.findElement(By.xpath("//*[@id='layUpgradeOption' and @height>0 and ./*[@text='to send her mail directly']]")).getText();
				System.out.println("Upgrade Now" + Mail);
				}
				Thread.sleep(5000);
				if (driver.findElement(By.xpath("//*[@id='tvUpgradeNow']")).isEnabled()) {
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='tvUpgradeNow']")).click();
					Thread.sleep(5000);
					
					BaseTest.click(l.getSkip_membership_package());
				try {
					Thread.sleep(5000);
					BaseTest.click(l.getMembership_call_skip());
				} catch (Exception e2) {
					System.out.println("No Call Now Button");
				}
			}
			}
    		
		} else {
            System.out.println("There is no latest matches to send interest");
		}  
    	
    	
    	Thread.sleep(5000);
    	BaseTest.click(l.getMail_box());
    	
    	Thread.sleep(5000);
    	try {
    		BaseTest.click(l.getFilter());
		} catch (Exception e) {
			System.out.println("****");
		}
    	
    	
    	Thread.sleep(5000);
    	BaseTest.click(l.getMailbox_sent_btn());
    	
    	Thread.sleep(5000);
    	String send_interest_id1 = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[1]")).getText();
    	
        Thread.sleep(5000);
        
        if (send_interest_id.equals(send_interest_id1)) {
        	System.out.println("The send Interest ID matches");
			
		} else  if (driver.findElement(By.xpath("(//*[@id='profileMatriId'])[2]")).isDisplayed()) {
        	
        	String send_interest_id2 = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[2]")).getText();
        	
        	boolean equals = send_interest_id.equals(send_interest_id2);
        	
        	System.out.println("The Send Interesrt ID matches" + equals);
			
		}  else {
			
            System.out.println("The ID not matches");
		}
    	
    }
        
    
     /*   if (driver.findElement(By.xpath("(//*[@id='profileMatriId'])[2]")).isDisplayed()) {
        	
        	String send_interest_id2 = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[2]")).getText();
        	
        	boolean equals = send_interest_id.equals(send_interest_id2);
			
		} else {

		}
    }
    
    */
    
    

	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }
	}
    		