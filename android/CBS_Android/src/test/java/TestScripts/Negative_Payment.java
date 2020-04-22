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
import POM.Payment;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class Negative_Payment {
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
    
    @BeforeMethod
    public void login() throws Exception {
		
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
  				driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();;
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
    	
    	

	}

    @Test
    public void till_you_Marry() throws InterruptedException {
    	
    	Payment p = new Payment(driver);
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getMenu());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getUpgrade_now());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getTill_you_Mary());
    	
    	Thread.sleep(5000);
    	String Amount = p.getTill_you_Mary_amount().getText();
    	System.out.println("Till You Marry Pack cost Rs : " + Amount);
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getUpgrade_now_Diamond_3mnth());
    	
    	Thread.sleep(5000);
    	String Membership_Details = p.getTill_you_Mary_membership_details().getText();
    	System.out.println(Membership_Details);
    	
    	
    	Thread.sleep(5000);
    	String Final_Pay_Amount = p.getTill_you_Mary_amount_finao_Pay_amount().getText();
    	System.out.println(Final_Pay_Amount);
    	
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getCredit_Payment_mode());
    	
    	
    	try {
    	Thread.sleep(10000);
    	BaseTest.click(driver.findElement(By.xpath("//*[@id='popclose']")));
    	} catch (Exception e) 
    	{
    		System.out.println("No Pop Up Appeared");
    	}
    	
    	
    	Thread.sleep(5000);
    	BaseTest.typeData(p.getCard_number(), BaseTest.readValueFromExcelSheet().get(1).get("CardNumber"));
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getExpiry_Month());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getExpiry_month_Value());
    	
    	Thread.sleep(5000);
        BaseTest.click(p.getExpiry_year_value());
        
        Thread.sleep(5000);
        BaseTest.typeData(p.getCVV(), BaseTest.readValueFromExcelSheet().get(1).get("CVV"));
        
        Thread.sleep(5000);
        BaseTest.click(p.getCard_Pay_Now());
        
        Thread.sleep(30000);
        BaseTest.click(p.getPayment_Back());
        
        Thread.sleep(5000);
        BaseTest.click(p.getPayment_back_confirm());
        
        try {
        	Thread.sleep(15000);
        	BaseTest.click(driver.findElement(By.xpath("//*[@id='popclose']")));
        	} catch (Exception e) 
        	{
        		System.out.println("No Pop Up Appeared");
        	}
        
        Thread.sleep(5000);
        BaseTest.click(p.getPayment_Back());
    	
    }
    
    @Test
    public void Personalized() throws InterruptedException {
    	
    	Payment p = new Payment(driver);
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getMenu());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getUpgrade_now());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getPersonalized_Pack());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getAssisted_upgrade_btn());
    	
    	Thread.sleep(5000);
    	String Assisted_Amount = driver.findElement(By.xpath("//*[@id='plan_rate']")).getText();
    	System.out.println("Assisted serivce Cost  "+Assisted_Amount);
    	
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getCredit_Payment_mode());
    	
    	try {
        	Thread.sleep(15000);
        	BaseTest.click(driver.findElement(By.xpath("//*[@id='popclose']")));
        	} catch (Exception e) 
        	{
        		System.out.println("No Pop Up Appeared");
        	}
    	
    	
    	Thread.sleep(5000);
    	BaseTest.typeData(p.getCard_number(), BaseTest.readValueFromExcelSheet().get(1).get("CardNumber"));
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getExpiry_Month());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getExpiry_month_Value());
    	
    	Thread.sleep(5000);
        BaseTest.click(p.getExpiry_year_value());
        
        Thread.sleep(5000);
        BaseTest.typeData(p.getCVV(), BaseTest.readValueFromExcelSheet().get(1).get("CVV"));
        
        Thread.sleep(5000);
        BaseTest.click(p.getCard_Pay_Now());
        
        Thread.sleep(30000);
        BaseTest.click(p.getPayment_Back());
        
        try {
        	Thread.sleep(10000);
        	BaseTest.click(driver.findElement(By.xpath("//*[@id='popclose']")));
        	}catch (Exception e) 
        	{
        		System.out.println("No Pop Up Appeared");
        	}
        
        Thread.sleep(5000);
        BaseTest.click(p.getPayment_back_confirm());
        
        Thread.sleep(5000);
        BaseTest.click(p.getPayment_Back());
        
        
         	
    	
    	
    }
    
    @Test
    public void assisted_6mnth_pPack() throws InterruptedException {
    	
	Payment p = new Payment(driver);
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getMenu());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getUpgrade_now());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getPersonalized_Pack());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getPersonalized_mnth_Pack());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getAssisted_upgrade_btn());
    	
    	Thread.sleep(5000);
    	String Assisted_Amount = driver.findElement(By.xpath("//*[@id='plan_rate']")).getText();
    	System.out.println("Assisted serivce Cost  "+Assisted_Amount);
    	
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getCredit_Payment_mode());
    	
    	try {
        	Thread.sleep(15000);
        	BaseTest.click(driver.findElement(By.xpath("//*[@id='popclose']")));
        	} catch (Exception e) 
        	{
        		System.out.println("No Pop Up Appeared");
        	}
    	
    	Thread.sleep(5000);
    	BaseTest.typeData(p.getCard_number(), BaseTest.readValueFromExcelSheet().get(1).get("CardNumber"));
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getExpiry_Month());
    	
    	Thread.sleep(5000);
    	BaseTest.click(p.getExpiry_month_Value());
    	
    	Thread.sleep(5000);
        BaseTest.click(p.getExpiry_year_value());
        
        Thread.sleep(5000);
        BaseTest.typeData(p.getCVV(), BaseTest.readValueFromExcelSheet().get(1).get("CVV"));
        
        Thread.sleep(5000);
        BaseTest.click(p.getCard_Pay_Now());
        
        Thread.sleep(30000);
        BaseTest.click(p.getPayment_Back());
        
        try {
        	Thread.sleep(10000);
        	BaseTest.click(driver.findElement(By.xpath("//*[@id='popclose']")));
        	} catch (Exception e) 
        	{
        		System.out.println("No Pop Up Appeared");
        	}
        
        Thread.sleep(5000);
        BaseTest.click(p.getPayment_back_confirm());
        
        Thread.sleep(5000);
        BaseTest.click(p.getPayment_Back());
        
		

	}
    	

    @AfterTest
    public void tearDown() {
      //  driver.quit();
    }
}