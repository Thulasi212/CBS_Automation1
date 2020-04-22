package TestScriptsBrahmin;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.RemoveBlockIgno;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class RemoveIgnoreBlock2 {

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

	@Test
	public void remove_block_ignore() throws Exception {

		RemoveBlockIgno r = new RemoveBlockIgno(driver);

		try {
		  Thread.sleep(5000); BaseTest.click(r.getChooseLogin()); Thread.sleep(5000);
		  BaseTest.click(r.getMatriId()); BaseTest.typeData(r.getMatriId(),
		  BaseTest.readValueFromExcelSheet().get(1).get("UserName"));
		  Thread.sleep(5000); BaseTest.click(r.getPassword());
		  BaseTest.typeData(r.getPassword(),
		  BaseTest.readValueFromExcelSheet().get(1).get("PassWord"));
		 
		  Thread.sleep(5000); BaseTest.click(r.getIdLogin());
		} catch (Exception e) {
			System.out.println("Already Logged In");
		}
		Thread.sleep(10000);
		try {
			BaseTest.click(r.getQuick_Tour_Skip());
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
			BaseTest.click(r.getQuick_response_popup());
		} catch (Exception e) {
			System.out.println("The Quick Response page handled Successfully");
		}
		Thread.sleep(5000);
		try {
			BaseTest.click(r.getNotification_access_later());
		} catch (Exception e) {
			System.out.println("Notification handled");
		}

		Thread.sleep(5000);
		BaseTest.click(r.getMenu_button());

		Thread.sleep(5000);
		driver.swipe(0, 1000, 0, 0, 1000);

		Thread.sleep(5000);
		BaseTest.click(r.getAccount_settings());

		Thread.sleep(5000);
		BaseTest.click(r.getBlocked_profiles());

		Thread.sleep(10000);
		try {
			Thread.sleep(10000);
			if (driver.findElement(By.xpath("//*[@id='profileMatriId']")).isDisplayed()) {

					Thread.sleep(5000);
					BaseTest.click(r.getUnblock_viewprofile_btn());
					Thread.sleep(10000);
					BaseTest.click(r.getUnblock_viewprofile_continue_btn());
					Thread.sleep(5000);
					BaseTest.click(r.getUnblock_viewprofile_NAVIGATEBack_btn());
			
			} else {
				Thread.sleep(5000);
				BaseTest.click(r.getUnblock_viewprofile_NAVIGATEBack_btn());
				Thread.sleep(5000);
				System.out.println("There is No Blocked ID's");

			}
		} catch (Exception e) {
			Thread.sleep(5000);
			BaseTest.click(r.getUnblock_viewprofile_NAVIGATEBack_btn());
			System.out.println("There is No Blocked ID's");
		}
		
		Thread.sleep(5000);
		BaseTest.click(r.getUnblock_viewprofile_NAVIGATEBack_btn());
		Thread.sleep(5000);
		BaseTest.click(r.getIgnored_profiles());
		
		Thread.sleep(10000);
		try {
			Thread.sleep(10000);
			if (driver.findElement(By.xpath("//*[@id='profileMatriId']")).isDisplayed()) {

					Thread.sleep(5000);
					BaseTest.click(r.getUnblock_viewprofile_btn());
					Thread.sleep(10000);
					BaseTest.click(r.getUnblock_viewprofile_continue_btn());
					Thread.sleep(5000);
					BaseTest.click(r.getUnblock_viewprofile_NAVIGATEBack_btn());

			} else {
				
				Thread.sleep(5000);
				BaseTest.click(r.getUnblock_viewprofile_NAVIGATEBack_btn());
				System.out.println("There is No Ignore ID's");
				
  
			}
		} catch (Exception e) {
			Thread.sleep(5000);
			BaseTest.click(r.getUnblock_viewprofile_NAVIGATEBack_btn());
			System.out.println("There is No Ignore ID's");
		}
		
		Thread.sleep(5000);
		BaseTest.click(r.getUnblock_viewprofile_NAVIGATEBack_btn());
		Thread.sleep(5000);
		BaseTest.click(r.getLogout());

	}

	@AfterTest
	public void tearDown() {
		 driver.quit();
	}
}
