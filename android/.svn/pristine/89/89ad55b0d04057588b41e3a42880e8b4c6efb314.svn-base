package TestScriptsBrahmin;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

public class SMS {
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
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.apps.messaging");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ui.ConversationListActivity");
        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testUntitled() throws InterruptedException, ParseException {
    	
    	Thread.sleep(3000);
    	SimpleDateFormat sdf = new SimpleDateFormat("dd-mm");
    	
    	//"Tue Sep 10 15:59:59 IST 2019"
    	String dd = driver.getDeviceTime();
    	String[] dd1 = dd.split(" ");
    	String dd2 = dd1[2]+" "+dd1[1];
    	System.out.println(dd2);
    	
    	//Date D = sdf.parse(dd2);
    	
    	//System.out.println(D);
    	
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@text='BPCMATRM']")).click();
    	
    	Thread.sleep(3000);
    	List<AndroidElement> tot = driver.findElements(By.xpath("//*[contains(text(),'cmatri.in/?')]"));
    	int total = tot.size();
    	System.err.println(tot.size());
    	
    	Thread.sleep(3000);
    	List<AndroidElement> dat = driver.findElements(By.xpath("//*[@id='message_status']"));
    	int date = dat.size();
    	String Date = dat.get(date-1).getText();
    	String[] Dates = Date.split(",");
    	String Date_val = Dates[0].toString().trim();
    	System.out.println(Date_val);
    	
    	//Date D1 = sdf.parse(Date);
    	
    //	System.err.println(D1);
    	
    	
    	if (dd2.equals(Date_val)) {
			

    	Thread.sleep(3000);
    	String mess = tot.get(total-1).getText();
    	System.out.println(mess);
    	
    	Thread.sleep(3000);
    	String[] u = mess.split("visit");
    	String ur = u[1].toString().trim();
    	System.out.println(ur);
    	
    	Thread.sleep(3000);
    	driver.get(ur);
    	}  	 else {
			System.out.println("Message from Older Dates");
		}
    }

    @AfterTest
    public void tearDown() {
    //    driver.quit();
    }
}