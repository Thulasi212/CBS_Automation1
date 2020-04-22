package CBS;

import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Utility.Login;
import Utility.Logout;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class LoginTest {
  private String reportDirectory = "reports";
  private String reportFormat = "xml";
  private String testName = "Untitled";
  protected IOSDriver<IOSElement> driver = null;

  DesiredCapabilities dc = new DesiredCapabilities();
  
  @BeforeTest
  public void setUp() throws MalformedURLException {
      dc.setCapability("reportDirectory", reportDirectory);
      dc.setCapability("reportFormat", reportFormat);
      dc.setCapability("testName", testName);
      dc.setCapability(MobileCapabilityType.UDID, "989240f183880fddcaff8ce3a01d58842aaa2317");
      dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.communityMatrimony.CommunityMatrimony");
      driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
      driver.setLogLevel(Level.INFO);
  }
   //verifying the Star dropdown values based on Mother Tongue in Edit profile
	@Test(enabled = true)
	public void starlistEditProfile() throws Throwable {
		Login login = new Login(driver);
		EditProfilePage ep= new EditProfilePage(driver);
		login.loginTest();
		Thread.sleep(3000);
		try {
			ep.getQuickResponseClose().click();
			Thread.sleep(1000);
		}catch (Exception e) {
			e.getMessage();
			
		}
		Logout.logoutTest();	
		
	}

}
