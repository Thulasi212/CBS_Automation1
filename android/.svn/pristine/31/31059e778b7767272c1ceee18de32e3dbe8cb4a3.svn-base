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

import Base.BaseTest;
import POM.Login;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;

public class DashBoard_LatestMatches extends BaseTest {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected AndroidDriver<AndroidElement> driver = null;
    String A;
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
    public void latestMatchesTest() throws Exception {
    	
    	Login l = new Login(driver);
    	
  /*  	Thread.sleep(5000);
    	BaseTest.click(l.getChooseLogin());
    	Thread.sleep(5000);
    	BaseTest.click(l.getMatriId());
    	BaseTest.typeData(l.getMatriId(), BaseTest.readValueFromExcelSheet().get(1).get("UserName"));
    	Thread.sleep(5000);
    	BaseTest.click(l.getPassword());
    	BaseTest.typeData(l.getPassword(), BaseTest.readValueFromExcelSheet().get(1).get("PassWord"));
    	
    	Thread.sleep(5000);
    	BaseTest.click(l.getIdLogin());  */
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
    public void latestmatches_verification() throws InterruptedException {
		
    	Thread.sleep(5000);
    if(driver.findElements(By.xpath("//*[@id='txtDashTitle']")).size()!=0)
    {
    	
    	List<AndroidElement> matri_id = driver.findElements(By.xpath("//*[@id='profileMatriId']"));
    	for (int i = 1; i < matri_id.size(); i++) {
    		String A = matri_id.get(1).getText();
    		System.out.println("The ID are -" + A);
    		
    		
			
		}
    	
    }
        
    Thread.sleep(5000);
    	driver.findElement(By.xpath("//*[@id='txtDashViewAll']")).click();
    	Thread.sleep(5000);
    	/*List<AndroidElement> matri_id1 = driver.findElements(By.xpath("//*[@id='profileMatriId']"));
    	//int size = matri_id1.size();
    	for (int j = 0; j < matri_id1.size() ; j++) {
    		String B = matri_id1.get(j).getText();
    		driver.swipe(0, 300, 0, 0, 1000);
    		System.out.println("The ID are -" + B);
    	
    	}
    	*/
    	
    	
    	Thread.sleep(5000);
    	String Matri_id1 = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[1]")).getText();
    	System.out.println(Matri_id1);
    	
    	
    	Thread.sleep(5000);
    	String Matri_id2 = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[2]")).getText();
    	System.out.println(Matri_id2);
    	
    	
    	Thread.sleep(5000);
    	
    	String Matri_id3 = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[3]")).getText();
    	System.out.println(Matri_id3);
    	
    	
    	Thread.sleep(5000);
    	driver.swipe(0, 1200, 0, 0, 1000);
    	
    	Thread.sleep(5000);
    	String Matri_id4 = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[3]")).getText();
    	System.out.println(Matri_id4);
    	
    	
    	Thread.sleep(5000);
    	driver.swipe(0, 1000, 0, 0, 1000);
    	
    	Thread.sleep(5000);
       	String Matri_id5 = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[2]")).getText();
    	System.out.println(Matri_id5);

    	
    if (A.contains(Matri_id5)) {
    		System.out.println("ID 1 Matches");
		} else {
              System.out.println("ID not Matched");
		}
    
    if (A.contains(Matri_id4)) {
		System.out.println("ID 2 Matches");
	} else {
          System.out.println("ID not Matched");
	}
    
    if (A.contains(Matri_id3)) {
		System.out.println("ID 3 Matches");
	} else {
          System.out.println("ID not Matched");
	}
    
    if (A.contains(Matri_id2)) {
		System.out.println("ID 4 Matches");
	} else {
          System.out.println("ID not Matched");
	}
    
    if (A.contains(Matri_id1)) {
		System.out.println("ID 5 Matches");
	} else {
          System.out.println("ID not Matched");
	}
 
	}
}

