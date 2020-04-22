package com.app.Android_App;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import java.net.URL;
import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class Communication extends BaseTest{
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
        dc.setCapability(MobileCapabilityType.UDID, "330063acdba724f5");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.community.matrimony");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.domaininstance.ui.activities.Splash");
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void loginTest() throws InterruptedException, AWTException, IOException {
    	test=reports.startTest("Android Login Test");
    	
    	test.log(LogStatus.PASS, "Login Test Case Started");
    	Thread.sleep(4000);
    	//try {
			WebElement login = driver.findElement(By.xpath("//*[@text='LOGIN']"));
		//	if (login.isDisplayed()) {
				login.click();
				
//			}
//		} catch (Exception e) {
//			e.getMessage();
//		}
    	//driver.findElement(By.xpath("//*[@id='reg_login_button']")).click();
    	test.log(LogStatus.PASS, "Entering Matri-ID & Password");
    	driver.findElement(By.xpath("//*[@id='matriid_from_login_layout']")).sendKeys("VIS506868");
    	driver.findElement(By.xpath("//*[@id='pass__from_login_layout']")).sendKeys("cbstest");
    	driver.findElement(By.xpath("//*[@text='Login']")).click();
    	
    	test.log(LogStatus.PASS, "Login Button Clicked");
    	
    	Thread.sleep(10000);
    	try {
    		WebElement skip = driver.findElement(By.xpath("//*[@text='Skip']"));
    		if (skip.isDisplayed()) {
    			skip.click();
				
			}
		} catch (Exception e) {
			e.getMessage();
		}
    	
    	//driver.findElement(By.xpath("//*[@id='skip']")).click();
    	Thread.sleep(5000);
    	try {
			AndroidElement photo_skip = driver.findElement(By.xpath("//*[@text=concat('I', \"'\", 'll do this later >')]"));
			if (photo_skip.isDisplayed()) {
				photo_skip.click();
			}
		} catch (Exception e) {
			e.getMessage();
			
		}

    	Thread.sleep(2000);
    	//driver.findElement(By.xpath("//*[@class='android.support.v7.app.a$b' and @width>0 and ./*[@text='LATEST MATCHES']]")).click();
    	//Thread.sleep(2000);
    	//driver.findElement(By.xpath("//*[@text='SEND INTEREST']")).click();
    	//Thread.sleep(2000);
    	//driver.findElement(By.xpath("//*[@text='Shortlist' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='View Number']]]]")).click();
    	//Thread.sleep(2000);
    	//driver.findElement(By.xpath("//*[@text='SEND INTEREST']")).click();
    	//driver.findElement(By.xpath("//*[@text='LATEST MATCHES']")).click();
    	//Thread.sleep(2000);
    	driver.findElement(By.xpath("(//*[@id='icon'])[5]")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//*[@text='Edit Partner Preference']")).click();
    	Thread.sleep(2000);
    	driver.swipe(0, 800, 0, 0, 1000);
    	
    	WebElement age=driver.findElement(By.xpath("//*[@text='Age' and @height>0 and @top='true']"));
    	Thread.sleep(2000);
    	WebElement agedetails=driver.findElement(By.xpath("//*[@text='28 - 35 Yrs']"));
    	System.out.println(age.getText() + ":" + agedetails.getText());
    	Thread.sleep(2000);
    	WebElement height=driver.findElement(By.xpath("//*[@text='Height' and @height>0]"));
    	Thread.sleep(2000);
    	WebElement heightdetails=driver.findElement(By.xpath("//*[@text='5 ft 4 in - 6 ft 4 in']"));
    	System.out.println(height.getText() + ":" + heightdetails.getText());
    	Thread.sleep(2000);
    	WebElement marital=driver.findElement(By.xpath("//*[@text='Marital Status' and @height>0]"));
    	Thread.sleep(2000);
    	WebElement maritalstatus=driver.findElement(By.xpath("//*[@text='Unmarried' and @height>0]"));
    	System.out.println(marital.getText() + ":" + maritalstatus.getText());
    	Thread.sleep(2000);
    	WebElement mothertongue =driver.findElement(By.xpath("//*[@text='Mother Tongue' and @height>0]"));
    	//String m1=mothertongue.getText();
    	
    	WebElement mothertongued =driver.findElement(By.xpath("//*[@text='Telugu' and @height>0]"));
    	System.out.println(mothertongue.getText() + ":" + mothertongued.getText());
    	WebElement physicalstatus =driver.findElement(By.xpath("//*[@text='Physical Status' and @height>0]"));
    	//String m1=mothertongue.getText();
    	
    	WebElement physicalstatusd =driver.findElement(By.xpath("//*[@text='Normal' and @height>0]"));
    	System.out.println(age.getText() + ":" + agedetails.getText());
    	System.out.println(height.getText() + ":" + heightdetails.getText());
    	System.out.println(physicalstatus.getText() + ":" + physicalstatusd.getText());
    	System.out.println(marital.getText() + ":" + maritalstatus.getText());
    	System.out.println(mothertongue.getText() + ":" + mothertongued.getText());
    	WebElement dosam =driver.findElement(By.xpath("//*[@text='Kuja Dosham']"));
   
    	WebElement dosamd =driver.findElement(By.xpath("//*[@text=concat('Doesn', \"'\", 't matter') and @height>0]l"));
    	System.out.println(dosam.getText() + ":" + dosamd.getText());
    	
    	
    	
    	
    }
    	@AfterTest
        public void tearDown() {
    	driver.resetApp();
        driver.quit();
        test.log(LogStatus.PASS, "Application Closed Succesfull");
       // reports.endTest(test);
        reports.flush();
     	reports.close();
    }
    	
    }
