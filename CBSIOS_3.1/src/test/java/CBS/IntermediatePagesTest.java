package CBS;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class IntermediatePagesTest {
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

	@Test
	public void intermediatepagesTest() {
		// ****Login to the App
		IntermediatePage i = new IntermediatePage(driver);
		i.getAddPhoto_skip().click();
	}

	@AfterMethod
	private void tearDown() {
		// TODO Auto-generated method stub

	}

}
