package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.apache.tools.ant.types.Assertions.BaseAssertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.Login;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Request extends BaseTest {

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
	        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.ezhavamatrimony");
	        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.domaininstance.ui.activities.Splash");
	        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
	        driver.setLogLevel(Level.INFO);

 
	}

	@Test
	public void requestScenario1() throws Exception {

		Login l = new Login(driver);
try {
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
} catch (Exception e) {
	System.out.println("Already Logged In");
}
		Thread.sleep(10000);
		try {
			BaseTest.click(l.getQuick_Tour_Skip());
		} catch (Exception e) {
			System.out.println("The Tour Page Handled Successfully");
		}

		try {
			driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
			;
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
			System.out.println("NO Notification to handle");
		}

		Thread.sleep(5000);

		BaseTest.click(driver.findElement(By.xpath("//*[@text='MATCHES']")));

		Thread.sleep(5000);
		String send_Request_id = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[1]")).getText();

		BaseTest.click(driver.findElement(
				By.xpath("(//*[@class='android.widget.RelativeLayout' and ./*[@id='lldateSupport']])[1]")));

		Thread.sleep(5000);
		List<AndroidElement> req1 = driver.findElements(By.xpath("//*[@text='Request']"));

		System.out.println(req1.size());

		int req2 = (req1.size() / 2) - 1;

		System.out.println(req2);

		for (int i = 0; i < req2; i++) {

			Thread.sleep(5000);
try {
	driver.findElement(By.xpath("//*[@id='send_yes_interest_btn' and @width>0]")).click();
} catch ( Exception e) {
	System.out.println("Interest Accepted");
}
			 Thread.sleep(10000);

			driver.scrollToExact("Request").click();

			// Thread.sleep(5000);

		}

		try {
			Thread.sleep(5000);
			driver.scrollToExact("RELIGIOUS INFORMATION");
			Thread.sleep(5000);
			if (driver.findElement(By.xpath("//*[@text='REQUEST HOROSCOPE']")).isDisplayed()) {
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@text='REQUEST HOROSCOPE']")).click();
			} else {
				System.out.println("Request Was Already Sent");

			}
		} catch (Exception e) {
			System.out.println("Religious Information Was not Displayed");
		}

		Thread.sleep(5000);
		if (l.getSkip_membership_package().isDisplayed()) {
			Thread.sleep(5000);
			BaseTest.click(l.getSkip_membership_package());
		} else {
			driver.findElement(By.xpath("//*[@contentDescription='Navigate up' and @width>0]")).click();
		}

		Thread.sleep(5000);
		BaseTest.click(l.getMenu_mailbox());

		Thread.sleep(5000);
		try {
			if (l.getFilter().isDisplayed()) {
				Thread.sleep(5000);
				BaseTest.click(l.getFilter());

			}
		} catch (Exception e) {
			System.out.println("The There is No Pop Up to Handle");
		}

		Thread.sleep(5000);
		BaseTest.click(l.getMailbox_sent_btn());
		Thread.sleep(5000);
		BaseTest.click(driver.findElement(By.xpath("//*[@id='mailbox_filter']")));
		Thread.sleep(5000);
		BaseTest.click(driver.findElement(By.xpath("//*[@text='REQUEST SENT']")));
		Thread.sleep(5000);
		BaseTest.click(driver.findElement(By.xpath("//*[@id='btnApplyFilter']")));
		Thread.sleep(5000);

		Thread.sleep(5000);
		if (driver.findElement(By.xpath("(//*[@id='profileMatriId'])[1]")).isDisplayed()) {

			String send_Request_id1 = driver.findElement(By.xpath("(//*[@id='profileMatriId'])[1]")).getText();
			Thread.sleep(5000);
			BaseTest.click(driver.findElement(By.xpath("(//*[@id='profileLayout'])[1]")));
			Thread.sleep(5000);
			BaseTest.click(driver.findElement(By.xpath("//*[@text='+ More Conversations' and @width>0]")));
			Thread.sleep(5000);
			List<AndroidElement> Req_deatils = driver.findElements(By.xpath("//*[@id='txt_req_comm_title']"));
			Thread.sleep(5000);
			for (int j = 0; j < Req_deatils.size(); j++) {
				Thread.sleep(5000);
				String deatils = Req_deatils.get(j).getText();

				System.out.println(deatils);

			}

		} else {
			System.out.println("There is No Matri ID to check the Request Sent");
		}

		Thread.sleep(5000);
		if (l.getSkip_membership_package().isDisplayed()) {
			Thread.sleep(5000);
			BaseTest.click(l.getSkip_membership_package());
		} else {
			driver.findElement(By.xpath("//*[@contentDescription='Navigate up' and @width>0]")).click();
		}

		Thread.sleep(5000);
		if (l.getSkip_membership_package().isDisplayed()) {
			Thread.sleep(5000);
			BaseTest.click(l.getSkip_membership_package());
		} else {
			driver.findElement(By.xpath("//*[@contentDescription='Navigate up' and @width>0]")).click();
		}

		Thread.sleep(5000);
		if (l.getSkip_membership_package().isDisplayed()) {
			Thread.sleep(5000);
			BaseTest.click(l.getSkip_membership_package());
		} else {
			driver.findElement(By.xpath("//*[@contentDescription='Navigate up' and @width>0]")).click();
		}

		Thread.sleep(5000);
		BaseTest.click(l.getMenu_button());
		Thread.sleep(5000);
		driver.swipe(0, 1000, 0, 0, 1000);
		BaseTest.click(l.getAccount_settings());
		Thread.sleep(5000);
		BaseTest.click(l.getLogout_btn());

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
