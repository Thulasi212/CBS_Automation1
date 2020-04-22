package com.app.Android_App;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import java.net.URL;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class AppPayment extends BaseTest{
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
    public void payment() throws InterruptedException, AWTException, IOException {
    	test=reports.startTest("Android Payment Test");
    	
    	test.log(LogStatus.PASS, "Payment Test Case Started");
    	
    	
    	//try {
			WebElement login = driver.findElement(By.xpath("//*[@text='LOGIN']"));
		//	if (login.isDisplayed()) {
				login.click();
				
//			}
//		} catch (Exception e) {
//			e.getMessage();
//		}
    	
    	test.log(LogStatus.PASS, "Login  Started");
    	//driver.findElement(By.xpath("//*[@id='reg_login_button']")).click();
    	driver.findElement(By.xpath("//*[@id='matriid_from_login_layout']")).sendKeys("AGR100222");
    	driver.findElement(By.xpath("//*[@id='pass__from_login_layout']")).sendKeys("cbstest");
    	driver.findElement(By.xpath("//*[@id='login_btn_from_login_layout']")).click();
    	
    	test.log(LogStatus.PASS, "Logged in Succcessfully");
    	Thread.sleep(6000);
    	//driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
    	try {
    		WebElement skip = driver.findElement(By.xpath("//*[@id='skip']"));
    		if (skip.isDisplayed()) {
    			skip.click();
				
			}
		} catch (Exception e) {
			
			e.getMessage();
		}
    	Thread.sleep(3000);
    	try {
    		WebElement close=driver.findElement(By.xpath("//*[@id='popup_close_btn']"));
    		if(close.isDisplayed()) {
    			close.click();
    		}
		} catch (Exception e) {
		e.getMessage();
		}
    	//driver.findElement(By.xpath("//*[@id='skip']")).click();
    	Thread.sleep(3000);
    	try {
			AndroidElement photo_skip = driver.findElement(By.xpath("//*[@id='doitlater']"));
			if (photo_skip.isDisplayed()) {
				photo_skip.click();
			}
		} catch (Exception e) {
			e.getMessage();
		}
    	
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("(//*[@id='icon'])[5]")).click();
  
    	//To Scroll
    	driver.swipe(0, 800, 0, 0, 1000);
    	test.log(LogStatus.PASS, "Entering into Membership Module");
    	
    	driver.findElement(By.xpath("//*[@id='layUpgradeNow']")).click();
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("(//*[@id='payGold3mnth'])[1]")).click();
    	
    	test.log(LogStatus.PASS, "Selected 3 month membership plan");
    	
    	Thread.sleep(2000);
    	
    	test.log(LogStatus.PASS, "Payment Method");
    	
    	driver.findElement(By.xpath("(//*[@id='payment_creditcard'])[1]")).click();
    	
    	//Enter Card Number
    	test.log(LogStatus.PASS, "Entering Card Details");
    	
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//*[@id='card_no']")).sendKeys("4111111111111111");
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("(//*[@id='text1'])[1]")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("(//*[@id='text1'])[4]")).click();
    	
    	//Enter Expiry Month
    	//WebElement expiry_month = driver.findElement(By.xpath("(//*[@id='text1'])[1]"));
    	
    	//driver.findElement(By.xpath("(//*[@id='text1'])[3]"));
//    	Select s = new Select(expiry_month);
//    	s.selectByIndex(3);
    	
    	//Enter Expiry Year
    	//Thread.sleep(3000);
//    	driver.findElement(By.xpath("(//*[@id='text1'])[2]"));
    	Thread.sleep(3000);
     	driver.findElement(By.xpath("(//*[@id='text1'])[5]")).click();;  
     	
//    	Select s1 = new Select(expiry_year);
//    	s1.selectByIndex(4);
     	
    	//Enter Cvv
     	Thread.sleep(2000);
    	driver.findElement(By.xpath("//*[@id='cvv']")).sendKeys("012");
    	try {
			driver.findElement(By.xpath("//*[@id='popclose']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
    	Thread.sleep(2000);
    	try {
			driver.findElement(By.xpath("//*[@id='popclose']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//*[@id='pay']")).click();
    	try {
			driver.findElement(By.xpath("//*[@id='popclose']")).click();
		} catch (Exception e) {
			e.getMessage();
		}
    	
    	test.log(LogStatus.PASS, "Payment is in Progress*****");
    	
    	
    	Thread.sleep(10000);
    	
    	String path= "D:\\Android HTML Report\\Android ScreenShot\\"+ Math.floor(Math.random() * 14) + "payment.png";
    	TakesScreenshot tk = (TakesScreenshot)driver;
    	File source= tk.getScreenshotAs(OutputType.FILE);
    	File destini = new File(path);
		FileUtils.copyFile(source, destini);
		
		test.log(LogStatus.PASS, "Captured Screenshot");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='button1']")).click();
        
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton']")).click();  
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='btnPayNotnow']")).click();
    	
		Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@id='accountsLayout']")).click();
    	
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@id='logoutLayout']")).click();
    	
    	test.log(LogStatus.PASS, "Logged out successfully");
    	
    	test.log(LogStatus.PASS, "Payment test case completed successfully");
    	reports.endTest(test);
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


