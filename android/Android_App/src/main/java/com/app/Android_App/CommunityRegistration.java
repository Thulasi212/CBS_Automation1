package com.app.Android_App;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import java.net.URL;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class CommunityRegistration extends BaseTest{
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




    @Test
    public void testUntitled() throws InterruptedException, IOException {
    	test=reports.startTest("Android Registeration Test");
//    	reports=new ExtentReports("D:\\Android HTML Report\\registeration.html",true);
//    	reports.loadConfig(new File("C:\\Users\\amuthan\\eclipse-workspace\\com.mobile\\extent-config.xml"));
//    	test=reports.startTest("Registeration Test ");
    	test.log(LogStatus.PASS, "Registeration Test Case Started");
    	try {
			AndroidElement free_register = driver.findElement(By.xpath("//*[@id='registration']"));
			if (free_register.isDisplayed()) {
				free_register.click();
				
			}
		} catch (Exception e) {
			e.getMessage();
		}
    	
    	driver.findElement(By.xpath("//*[@id='reg_community_button']")).click();
    	
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("(//*[@id='value_textView'])[4]")).click();
    	
    	
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("(//*[@class='android.widget.Button'])[2]")).click();
    	
    	Thread.sleep(3000);
    	try {
			AndroidElement mail_skip = driver.findElement(By.xpath("//*[@id='cancel']"));
			if (mail_skip.isDisplayed()) {
				mail_skip.click();
				
			}
		} catch (Exception e) {e.getMessage();
		}
    	
    	driver.findElement(By.xpath("//*[@id='male_button']")).click();
    	
    	
    	
    	driver.findElement(By.xpath("//*[@id='reg_name_editText']")).sendKeys("Karunakaran");
    	driver.hideKeyboard();
    	
    	driver.swipe(0, 800, 0, 0, 1000);
    	
    	
    	
    	AndroidElement Scroll = driver.findElement(By.xpath("//*[@id='reg_dob_editText']"));
    	
    	Scroll.click();
    	//driver.findElement(By.xpath("(//*[@id='icon'])[7")).click();
    	
    	driver.findElement(By.xpath("//*[@id='btn_confirm']")).click();
    		
  
    	//Scroll.scrollkeys(driver,new String[] {"Mar","03","1988"});
    	//JavaScriptExecutor js = (JavaScriptExecutor)driver;
    	//js.executeScript("arguments[0].scrollIntoView(true)")
//    	driver.findElement(By.xpath("//*[@id='picker_day']")).sendKeys("15");
//   	
//   	driver.findElement(By.xpath("//*[@id='picker_month']")).sendKeys("May");
//    	
//    	driver.findElement(By.xpath("//*[@id='picker_year']")).sendKeys("1988");
    	String mail = "supertestregmail"+ Math.floor(Math.random() * 143231) + "@gmail.com";
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@id='reg_email_editText']")).sendKeys(mail);
    	
    	test.log(LogStatus.PASS, "The Entered mail ID was : "  + mail);
    
    	
    	System.out.println("The Entered mail ID was" + mail);
    	
    	
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@id='reg_password_editText']")).sendKeys("cbstest");
    	 driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@id='reg_mobile_editText']")).sendKeys("9889757585");
    	
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@id='reg_mothertongue_editText']")).click();
    	 driver.hideKeyboard();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("(//*[@id='value_textView'])[1]")).click();
    	
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("(//*[@id='value_textView'])[2]")).click();
    	
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("(//*[@id='value_textView'])[2]")).click();
    	
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@id='reg_next_button']")).click();
    	
    	test.log(LogStatus.PASS, "Registeration Page 1 Completed Successfully");
    	
    	System.out.println("Page 1 Registertion completed");
    	
    	//Page 2 Registeration
    	
    	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);  
    	
    	test.log(LogStatus.PASS, "Registeration Page 2 Started");
    driver.findElement(By.xpath("(//*[@class='android.widget.Button'])[1]")).click();

    driver.findElement(By.xpath("(//*[@id='value_textView'])[1]")).click();
    driver.findElement(By.xpath("(//*[@id='value_textView'])[2]")).click();
    driver.findElement(By.xpath("(//*[@id='value_textView'])[3]")).click();
    driver.findElement(By.xpath("(//*[@id='value_textView'])[1]")).click();
    driver.findElement(By.xpath("(//*[@id='value_textView'])[7]")).click();
    driver.findElement(By.xpath("(//*[@id='value_textView'])[4]")).click();
    driver.findElement(By.xpath("(//*[@id='value_textView'])[2]")).click();
    driver.findElement(By.xpath("(//*[@id='value_textView'])[2]")).click();
    driver.findElement(By.xpath("//*[@id='reg_currency_textView']")).click();
    driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys("India");
    driver.findElement(By.xpath("(//*[@id='value_textView'])[1]")).click();
    driver.findElement(By.xpath("(//*[@id='value_textView'])[5]")).click();
    
    driver.findElement(By.xpath("(//*[@class='android.widget.Button'])[1]")).click();
    driver.findElement(By.xpath("(//*[@class='android.widget.Button'])[3]")).click();
    driver.swipe(0, 800, 0, 0, 1000);
    driver.findElement(By.xpath("(//*[@class='android.widget.Button'])[6]")).click();
    driver.findElement(By.xpath("(//*[@class='android.widget.Button'])[9]")).click();
    driver.swipe(0, 800, 0, 0, 1000);
    driver.findElement(By.xpath(" //*[@id='reg_pagethirdcontinue_button']")).click();
    
    test.log(LogStatus.PASS,"Registeration Page 2 completed Successfully");
    
    System.out.println("Registration 2nd page completed");
    //3rd page registration
    
    test.log(LogStatus.PASS,"Registeration Page 3 Started");
    driver.findElement(By.xpath("//*[@id='reg_doshamno_button']")).click();
    driver.findElement(By.xpath("(//*[@id='value_textView'])[3]")).click();
    driver.findElement(By.xpath("(//*[@id='value_textView'])[4]")).click();
    driver.hideKeyboard();
   // driver.findElement(By.xpath("(//*[@id='value_textView'])[2]")).click();
    driver.swipe(0, 800, 0, 0, 1000);
    driver.findElement(By.xpath("//*[@id='reg_pagefourthcontinue_button']")).click();
    
    test.log(LogStatus.PASS,"Registeration Page 3 completed Successfully");
    
    System.out.println("Registeration Page 3 Completed");
    
    AndroidElement matri_id = driver.findElement(By.xpath("//*[@id='matriID_textView']"));
    String b=matri_id.getText();
    String a=b.substring(33, 43);
    
    Thread.sleep(10000);
	
	String path= "D:\\Android HTML Report\\Android ScreenShot\\"+ Math.floor(Math.random() * 14) + "Regis.png";
	TakesScreenshot tk = (TakesScreenshot)driver;
	File source= tk.getScreenshotAs(OutputType.FILE);
	File destini = new File(path);
	FileUtils.copyFile(source, destini);
    
    System.out.println("Newly Register Matri ID is"+a);
    
    test.log(LogStatus.PASS,"Registeration completed Successfully");
    
    test.log(LogStatus.PASS,"The Registered Matri ID " + a);


    
    
    
    
    
    
    
    
    
    reports.endTest(test);
    
    
  //*[@id='reg_pagethirdcontinue_button']
    
    
    }
    
    
    

    @AfterTest
    public void tearDown() {
    	driver.resetApp();
        driver.quit();
        test.log(LogStatus.PASS, "Application Closed Succesfull");
        reports.flush();
     	reports.close();
       
    }
   }

	
	
	
	


