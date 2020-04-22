package TestScripts;



import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.EdipPartnerPP;
import POM.Login;

import java.net.URL;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class MobileNumberCount extends BaseTest{
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected AndroidDriver<AndroidElement> driver = null;
     String Number_Viewed_count="";
     String Number_Viewed_count1="";
     String Number_Viewed_count2="";
     String View ="";
     String View1 ="";
     String View2 ="";
     String left ="";
     String left1 ="";
     String left2 ="";
     
    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeTest
    public void setUp() throws MalformedURLException {
    	dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "32002b32ee5b451f");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.ezhavamatrimony");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.domaininstance.ui.activities.Splash");
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @BeforeMethod
    public void login() throws InterruptedException {
    	EdipPartnerPP p1 = new EdipPartnerPP(driver);
       Login p = new Login(driver);
        BaseTest b = new BaseTest();
        Thread.sleep(15000);
        // b.click(p.getMain_Login());
try{driver.findElement(By.xpath("//*[@text='LOGIN']")).click();
        Thread.sleep(15000);
        b.click(p.getMatriId());
        b.typeData(p.getMatriId(), "EZH710533");
        Thread.sleep(15000);
        b.typeData(p.getPassword(), "cbstest");
        Thread.sleep(15000);
        b.click(p.getIdLogin());
        } catch (Exception e) {
            System.out.println("Already Logged In");
        }
        Thread.sleep(10000);
        try {
            WebElement allow = driver.findElement(By.xpath("//*[@text='ALLOW']"));
            if (allow.isDisplayed()) {
                allow.click();
            }
        } catch (Exception e) {
            System.out.println("No photo page");

        }
        try {
            WebElement skip = driver.findElement(By.xpath("//*[@id='skip']"));
            if (skip.isDisplayed()) {
                skip.click();

            }
        } catch (Exception e) {
            e.getMessage();
        }
        try {
            WebElement popup = driver.findElement(By.xpath("//*[@id='popup_close_btn']"));
            if (popup.isDisplayed()) {
                popup.click();
            }
        } catch (Exception e) {
            e.getMessage();
        }

        // driver.findElement(By.xpath("//*[@id='skip']")).click();
        Thread.sleep(15000);
        try {
            AndroidElement photo_skip = driver.findElement(By.xpath("//*[@id='doitlater']"));
            if (photo_skip.isDisplayed()) {
                photo_skip.click();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        Thread.sleep(5000);
    	try {
			BaseTest.click(p1.getQuick_reponse());
		} catch (Exception e) {
			System.out.println("The Quick Response page handled Successfully");
		}
    	Thread.sleep(5000);
    	try {
			BaseTest.click(p1.getNotification_access());
		} catch (Exception e) {
			System.out.println("Notification handled");
		}  
    }




    @Test
     public void mobileNumber() throws InterruptedException, AWTException {
String s="";
Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@text='LATEST MATCHES']")).click();


        Thread.sleep(5000);
        String Matri_Id  = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[1]")).getText();
        System.out.println(Matri_Id);
        String Id = Matri_Id.substring(3, 9);
        System.out.println(Id);

        Thread.sleep(5000);
driver.findElement(By.xpath("(//*[@id='profileDesc'])[1]")).click();

        Thread.sleep(5000);

        if(driver.findElement(By.xpath("//*[@id='vp_phone' and @width>0]")).isDisplayed()) {

            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id='vp_phone' and @width>0]")).click();

            Thread.sleep(5000);
            String Number_Viewed_count = driver.findElement(By.xpath("//*[@id='mobileviewed']")).getText();
            System.out.println(Number_Viewed_count);
            String A = Number_Viewed_count.substring(16, 18);
            Integer View = Integer.parseInt(A);
            System.out.println(View);

            String Count_left = driver.findElement(By.xpath("//*[@id='countleft']")).getText();
            System.out.println(Count_left);
            String B = Count_left.substring(13, 15);
            Integer left = Integer.parseInt(B);
            System.out.println(left);

            Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id='view_btn']")).click();
            System.out.println("View Mobile Number");
    try {
        if (driver.findElement(By.xpath("//*[@id='tvPrimaryMobNo']")).isDisplayed()) {
            String Mobile_number = driver.findElement(By.xpath("//*[@id='tvPrimaryMobNo']")).getText();
            System.out.println(Mobile_number);

        } else {
driver.findElement(By.xpath("//*[@id='btnRequest']")).click();
        }
    } catch (Exception e) {
        System.out.println("Not able to view the Mobile Number");
    }
            /*Thread.sleep(5000);
            String Mobile_number = driver.findElement(By.xpath("//*[@id='tvPrimaryMobNo']")).getText();
            System.out.println(Mobile_number);*/

            Thread.sleep(5000);
        // driver.findElement(By.xpath("//*[@id='back']")).click();
            driver.navigate().back();


            //////////////////////////////

            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id='vp_phone' and @width>0]")).click();

            Thread.sleep(5000);
            String Number_Viewed_count1 = driver.findElement(By.xpath("//*[@id='mobileviewed']")).getText();
            System.out.println(Number_Viewed_count1);
            String A1 = Number_Viewed_count1.substring(16, 18);
            Integer View1 = Integer.parseInt(A1);
            System.out.println(View);

            String Count_left1 = driver.findElement(By.xpath("//*[@id='countleft']")).getText();
            System.out.println(Count_left1);
            String B1 = Count_left1.substring(13, 15);
            Integer left1 = Integer.parseInt(B1);
            System.out.println(left1);

            Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id='view_btn']")).click();
            System.out.println("View Mobile Number");


            try {
                if (driver.findElement(By.xpath("//*[@id='tvPrimaryMobNo']")).isDisplayed()) {
                    String Mobile_number1 = driver.findElement(By.xpath("//*[@id='tvPrimaryMobNo']")).getText();
                    System.out.println(Mobile_number1);

                } else {
driver.findElement(By.xpath("//*[@id='btnRequest']")).click();
                }
            } catch (Exception e) {
                System.out.println("Not able to view the Mobile Number");
            }
            /*Thread.sleep(5000);
            String Mobile_number1 = driver.findElement(By.xpath("//*[@id='tvPrimaryMobNo']")).getText();
            System.out.println(Mobile_number1);*/

            Thread.sleep(5000);
            driver.navigate().back();





            if (View+1==View1) {
                System.out.println("Verified");

            } else {
            System.out.println("No Matched");
            }

            if (left-1==left1) {
                System.out.println("Verified");

            } else {
            System.out.println("No Matched");
            }

            
          /////////////////////////////////////////////////////////////////////////////
            
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@contentDescription='Navigate up' and @width>0]")).click();
            
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id='icon' and ./parent::*[@id='tab_menu']]")).click();
            
           // driver.swipe(0, starty, endx, endy, duration);
            
            Thread.sleep(5000);      
            driver.findElement(By.xpath("//*[@text='Contact Viewed']")).click();


            Thread.sleep(5000);
            String Matri_Id1  = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[1]")).getText();
            System.out.println(Matri_Id1);
            String Id1 = Matri_Id1.substring(3, 9);
            System.out.println(Id1);

            Thread.sleep(5000);
    driver.findElement(By.xpath("(//*[@id='profileDesc'])[1]")).click();

            
        	/*Robot r = new Robot();
    		Thread.sleep(5000);
    		r.keyPress(KeyEvent.VK_ENTER);
    		r.keyRelease(KeyEvent.VK_ENTER);*/
            
            Thread.sleep(5000);

            if(driver.findElement(By.xpath("//*[@id='vp_phone' and @width>0]")).isDisplayed()) {

                Thread.sleep(5000);
                driver.findElement(By.xpath("//*[@id='vp_phone' and @width>0]")).click();

                Thread.sleep(5000);
                String Number_Viewed_count2 = driver.findElement(By.xpath("//*[@id='mobileviewed']")).getText();
                System.out.println(Number_Viewed_count2);
                String A2 = Number_Viewed_count2.substring(16, 18);
                Integer View2 = Integer.parseInt(A2);
                System.out.println(View2);

                String Count_left2 = driver.findElement(By.xpath("//*[@id='countleft']")).getText();
                System.out.println(Count_left2);
                String B2 = Count_left2.substring(13, 15);
                Integer left2 = Integer.parseInt(B2);
                System.out.println(left2);

                Thread.sleep(5000);
    driver.findElement(By.xpath("//*[@id='view_btn']")).click();
                System.out.println("View Mobile Number");
        try {
            if (driver.findElement(By.xpath("//*[@id='tvPrimaryMobNo']")).isDisplayed()) {
                String Mobile_number2 = driver.findElement(By.xpath("//*[@id='tvPrimaryMobNo']")).getText();
                System.out.println(Mobile_number2);

            } else {
    driver.findElement(By.xpath("//*[@id='btnRequest']")).click();
            }
        } catch (Exception e) {
            System.out.println("Not able to view the Mobile Number");
        }
            
        if (View2==View1) {
            System.out.println("Verified");

        } else {
        System.out.println("No Matched");
        }

        if (left2==left1) {
            System.out.println("Verified");

        } else {
        System.out.println("No Matched");
        }
        
        
        
        if (Matri_Id==Matri_Id1) {
        	System.out.println("Id Matches");
			
		} else {
			System.out.println("ID Not Matched ");
		}


        } else {
            System.out.println("Call Now button is not displayed");

        }

//////////////////////////////////////////////////////////////////////////////////////////////////////
        
     

        }
        
        Thread.sleep(5000);
        driver.navigate().back();
        
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@contentDescription='Navigate up' and @width>0]")).click();
        
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@contentDescription='Navigate up' and @width>0]")).click();
        
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='icon' and ./parent::*[@id='tab_menu']]")).click();
        
        driver.swipe(0, 1000, 0, 0, 1000);
        
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@text='Account Settings']")).click();
        
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@text='Logout']")).click();
    }

    @AfterTest
    public void tearDown() {
       driver.quit();
    }
}


