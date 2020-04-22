package TestScripts;

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

import Base.BaseTest;
import POM.Login;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class SendMail extends BaseTest {
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
    public void SendMailTest() throws Exception {
    	
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
    	BaseTest.click(l.getMail_box());
    	try {
    	Thread.sleep(5000);
    	BaseTest.click(l.getFilter());
    	} catch (Exception e) {
			System.out.println("No ivFilter");
		}
    	/*Thread.sleep(5000);
    	if (l.getSend_interest().isDisplayed()) {
    		String send_interest_id = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[1]")).getText();
    	System.out.println(send_interest_id);
    		BaseTest.click(l.getSend_interest());
		} else {
            System.out.println("There is no latest matches to send interest");
		}  */
    		
		
    	Thread.sleep(5000);
    	if (l.getView_reply_mailbox().isDisplayed()) {
    		String send_mail_id = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[1]")).getText();
    		System.out.println(send_mail_id);
    		Thread.sleep(5000);
    		BaseTest.click(l.getView_reply_mailbox());
    		Thread.sleep(5000);
    		BaseTest.typeData(l.getView_reply_mailconten(), BaseTest.readValueFromExcelSheet().get(1).get("MailContent"));
    		Thread.sleep(5000);
    		BaseTest.click(l.getMail_send_btn());
    		Thread.sleep(5000);
    		BaseTest.click(l.getToast_msg_close_btn());
			
		} else {
			 System.out.println("There is no latest matches to send mail");
		}
    	
    }
    
    @AfterTest
    public void tearDown() {
        //driver.quit();
    }
}