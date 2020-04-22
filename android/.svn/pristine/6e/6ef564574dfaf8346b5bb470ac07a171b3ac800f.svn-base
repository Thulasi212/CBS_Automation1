package TestScripts;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.Login;
import POM.QuickRes;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class QuickResponse extends BaseTest{
	

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
		dc.setCapability(MobileCapabilityType.UDID, "16e455170205");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.community.matrimony");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.domaininstance.ui.activities.Splash");
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
		driver.setLogLevel(Level.INFO);
		
	}

	@Test
	public void quickResponse() throws Exception {

		QuickRes l = new QuickRes(driver);
		Dimension size = driver.manage().window().getSize();
        int height = size.getHeight();
        int width = size.getWidth();
        System.out.println(width);
        int y = (int) (height * 0.15);
        int startx = (int) (width * 0.75);
        int endx = (int) (width * 0.35);


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
		
	//	driver.swipe(startx, y, endx, y, 4000);

		try {
			Thread.sleep(5000);
			BaseTest.click(l.getQuick_interest_yes_btn());
			Thread.sleep(5000);
			BaseTest.click(l.getQuick_response_popup());
		} catch (Exception e) {
			e.getMessage();
		}
				
		try {
			if (l.getQuick_view_reply().isDisplayed()) {
				Thread.sleep(5000);
				BaseTest.click(l.getQuick_view_reply());
				Thread.sleep(5000);
				BaseTest.click(l.getQuick_mail_content());
				Thread.sleep(5000);
				BaseTest.typeData(l.getQuick_mail_content(), BaseTest.readValueFromExcelSheet().get(1).get("Quick Response Mail"));
				Thread.sleep(5000);
				BaseTest.click(l.getQuick_mailcontent_send());
				Thread.sleep(5000);
				BaseTest.click(l.getQuick_response_popup());
			}
			
		} catch (Exception e) {
		System.out.println("There Is No Mail to View and Reply");
		}
	
		Thread.sleep(5000);
		if (driver.findElement(By.xpath("//*[@text='DELETE']")).isDisplayed()) {
			Thread.sleep(5000);
			BaseTest.click(l.getQuickresponse_deleted_profile());
			
		} else {
			System.out.println("No Deleted Profile Displayed");

		}

}
	@AfterTest
	public void tearDown() {
		 driver.quit();
	}
}


