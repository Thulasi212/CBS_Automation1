package TestScripts;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;

public class test_notification {
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
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.promessage.message");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ui.MainActivity");
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);



	}

	@Test
	public void testUntitled() throws InterruptedException {
		
		Thread.sleep(6000);

		
		// driver.findElement(By.xpath("//*[@text='GOT IT']")).click();

		 Dimension size = driver.manage().window().getSize();
		  System.out.println(size);
		   
		  //Find swipe start and end point from screen's with and height.
		  //Find starty point which is at bottom side of screen.
		  int starty = (int) (size.height * 0.90);
		  //Find endy point which is at top side of screen.
		  int endy = (int) (size.height * 0.15);
		  //Find horizontal point where you wants to swipe. It is in middle of screen width.
		  int startx = size.width / 2;
		  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

		  //Swipe from Bottom to Top.
		  //driver.swipe(startx, starty, startx, endy, 3000);
		  Thread.sleep(2000);
		  //Swipe from Top to Bottom.
		  driver.swipe(startx, endy, startx, starty, 3000);
		  Thread.sleep(2000);
		  
		  //driver.findElement(By.xpath("(//*[@id='status_bar_latest_event_content'])[1]")).click();
		  Thread.sleep(2000);
		 

		
		/*try {
			driver.runAppInBackground(10);
		} catch (Exception e) {
			System.out.println("no app run in background.....");
		}
	
		*/
	//	driver.openNotifications();
		
		 /* Thread.sleep(2000);
		    List<AndroidElement> allnotifications=driver.findElements(By.id("notification_main_column"));
		    Thread.sleep(2000);
		    for (AndroidElement webElement : allnotifications) {
		    	Thread.sleep(2000);
		        System.out.println(webElement.getText());
		        Thread.sleep(2000);
		        if(webElement.getText().contains("Yadav Matrimony")) {
		        	Thread.sleep(2000);
		        	webElement.click();
		        	Thread.sleep(2000);
		            System.out.println("Notification found");
		           
		    }
		    else {
				System.out.println("Not Found");
			}
		    }*/
		  
           driver.findElement(By.xpath("(//*[@id='notification_stack_scroller']/*/*/*[@id='status_bar_latest_event_content' and ./*[./*[@id='header_text']]])[1]")).click();
		  
		  
		  
}}
