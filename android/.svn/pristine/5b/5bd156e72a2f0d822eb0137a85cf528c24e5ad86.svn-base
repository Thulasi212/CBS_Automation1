package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.jsoup.Connection.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.QuickRes;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class QucikResponseNegative extends BaseTest {
	

	private String reportDirectory = "reports";
	private String reportFormat = "xml";
	private String testName = "Untitled";
	protected AndroidDriver<AndroidElement> driver = null;
	  Dimension size;
	    int starty;
	    int endy;
	    int startx;


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
	public void quickResponseNegative() throws Exception {

		QuickRes l = new QuickRes(driver);
	/*	Dimension size = driver.manage().window().getSize();
        int height = size.getHeight();
        int width = size.getWidth();
        System.out.println(width);
        int y = (int) (height * 0.15);
        int startx = (int) (width * 0.75);
        int endx = (int) (width * 0.35);
*/

/*		Thread.sleep(5000);
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
				driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
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
		try {
			WebElement no = driver.findElement(By.xpath("//*[@text='NO' and @width>0]"));
			Thread.sleep(5000);
			if (no.isDisplayed()) {
				Thread.sleep(5000);
				BaseTest.click(l.getQuick_Interest_No_btn());
				Thread.sleep(5000);
				BaseTest.click(l.getQuick_Decline_confirmbtn());
				Thread.sleep(5000);
				BaseTest.click(l.getQuick_Interest_No_Connfirm_btn());
				System.out.println("The Interest was declined");
				
				
			} else {
				
				System.out.println("No Interest Button Displayed");
				
			}
		} catch (Exception e) {
			
			System.out.println("No Interest Button Displayed");
		}
		
		try {
			WebElement decline = driver.findElement(By.xpath("//*[@text='DECLINE']"));
			Thread.sleep(5000);
			if (decline.isDisplayed()) {
				Thread.sleep(5000);
				BaseTest.click(l.getQuick_Decline_btn());
				Thread.sleep(5000);
				BaseTest.click(l.getQuick_Decline_confirmbtn());
				Thread.sleep(5000);
				BaseTest.click(l.getQuick_Decline_confirmbtn());
				System.err.println("The Profile was Declined");
			} else {
				
				System.out.println("No Decline Button Displayed");
				
			}
		} catch (Exception e) {
			System.out.println("No Decline Button Displayed");
		}
		
		try {
			WebElement delete = driver.findElement(By.xpath("//*[@text='DELETE']"));
			Thread.sleep(5000);
			if (delete.isDisplayed()) {
				Thread.sleep(5000);
				BaseTest.click(l.getQuickresponse_deleted_profile());
				System.out.println("The Profile was already Deleted");
			} else {
				System.out.println("No Deleted Profile Displayed");

			}
		} catch (Exception e) {
			System.out.println("No Deleted Profile Displayed");
		}
		

}
	
	
	 @AfterTest
	    public void tearDown() {
	      //  driver.quit();
	    }

	
	
}
