package CBS;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.Login;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class KeywordSearchTest2 {
	private String reportDirectory = "reports";
	private String reportFormat = "xml";
	private String testName = "Untitled";
	protected IOSDriver<IOSElement> driver = null;

	DesiredCapabilities dc = new DesiredCapabilities();

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		dc.setCapability("reportDirectory", reportDirectory);
		dc.setCapability("reportFormat", reportFormat);
		dc.setCapability("testName", testName);
		dc.setCapability(MobileCapabilityType.UDID, "989240f183880fddcaff8ce3a01d58842aaa2317");
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.communityMatrimony.CommunityMatrimony");
		driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
		driver.setLogLevel(Level.INFO);
	}

	@Test(enabled = true)
	public void keywordSearchTest10() throws InterruptedException {
		Login login = new Login(driver);
		IntermediatePage page = new IntermediatePage(driver);
		EditProfilePage ep= new EditProfilePage(driver);
		KeywordSearchPage key = new KeywordSearchPage(driver);
		try {
			login.getLogin1().click();
			login.getMatriId().sendKeys("AGR100173");
			login.getPassword().sendKeys("cbstest");
			login.getLogin2().click();
		} catch (Exception e) {

		}
		Thread.sleep(2000);
		try {
			page.getAddPhoto_skip().click();
			Thread.sleep(2000);
			page.getAddPhoto_yes().click();
			
		} catch (Exception e) {
			e.getMessage();
			
		}
		try {
			ep.getQuickResponseClose().click();
			Thread.sleep(1000);
		}catch (Exception e) {
			e.getMessage();
			
		}
		// Case13:Click on Marital status and check whether it is tappable or not.
		key.getSearch().click();
		Thread.sleep(2000);
		key.getKeyEdit().click();
		Thread.sleep(2000);
		key.getMStatusArrow().click();
		System.out.println("marital status is clickable");
		/*
		 * Case 14:verify the following fields Any,Unmarried,widow/widower,Divorced,
		 * Separated. each field should be selectable and selected option should reflect
		 * in corresponding field
		 */
		List<IOSElement> mStatuscheckboxlst = driver.findElementsByXPath("//*[@id='tick']");
		if (mStatuscheckboxlst.size() == 5) {
			mStatuscheckboxlst.get(0).click();
		} else {
			for (int j = 0; j < mStatuscheckboxlst.size(); j++) {
				mStatuscheckboxlst.get(0).click();
			}
		}
		String unMar1 = key.getMStatus_Unmarried().getText();
		System.out.println(unMar1);
		key.getMStatus_Unmarried().click();
		Thread.sleep(2000);
		key.getMStatus_Done().click();
		String unMar2 = key.getMStatus_Unmarried().getText();
		System.out.println(unMar2);
		Assert.assertEquals(unMar1, unMar2);
		System.out.println("Marital status value is Reflecting on correspomding field sucessfully ");
		// case 15:"* select-->Any and check whether all fields are selected with tick
		// .if unselect the any option all fields should unselect with tick*/
		key.getMStatusArrow().click();
		Thread.sleep(2000);
		key.getMStatus_Any().click();
		Thread.sleep(2000);
		boolean status = false;
		List<IOSElement> mStatuscheckboxlst1 = driver.findElementsByXPath("//*[@id='tick']");
		if (mStatuscheckboxlst1.size() == 5) {
			status = true;
		}
		Assert.assertTrue(status);
		// Case 16: Select Any --> if any one option unselect then it should unselect
		// along with any option.
		key.getMStatus_Unmarried().click();
		boolean status1 = false;
		List<IOSElement> mStatuscheckboxlst2 = driver.findElementsByXPath("//*[@id='tick']");
		if (mStatuscheckboxlst2.size() == 3) {
			status1 = true;
		}
		Assert.assertTrue(status1);
		// Case 17:don't select any values and try to save ,verify the toast message
		// 'please select any value'
		key.getMStatus_Any().click();
		key.getMStatus_Any().click();
		key.getMStatus_Done().click();
		Thread.sleep(1000);
		String s = key.getMS_Notselect_confMsg().getText();
		Assert.assertEquals(s, "Please select Marital Status");
		System.out.println("Toast message verified successfully");
		// Case 18: if we select all options except Any then Any should select
		// automatically and it should display in Marital status field instead of
		// showing all options.
		key.getmS_Notselect_confOk().click();
		key.getMStatus_Unmarried().click();
		key.getMStatus_Wid().click();
		key.getMStatus_Div().click();
		key.getMStatus_Sep().click();
		boolean status3 = false;
		List<IOSElement> mStatuscheckboxlst3 = driver.findElementsByXPath("//*[@id='tick']");
		if (mStatuscheckboxlst3.size() == 5) {
			status3 = true;
		}
		Assert.assertTrue(status3);
		System.out.println("Any option is verified successfully");
		

	}

	@Test(enabled = false)
	public void keywordSearchTest11() throws InterruptedException {
		Login login = new Login(driver);
		IntermediatePage page = new IntermediatePage(driver);
		KeywordSearchPage key = new KeywordSearchPage(driver);
		try {
			login.getLogin1().click();
			login.getMatriId().sendKeys("IYR242926");
			login.getPassword().sendKeys("cbstest");
			login.getLogin2().click();
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(2000);
		try {
			page.getAddPhoto_skip().click();
			Thread.sleep(2000);
			page.getAddPhoto_yes().click();

		} catch (Exception e) {
			e.getMessage();
		}
		key.getSearch().click();
		Thread.sleep(2000);
		key.getKeyEdit().click();
		Thread.sleep(1000);
		// Case 19: Click on Dosham and check whether it is tappable or not.
		key.getDoshamArrow().click();
		Thread.sleep(3000);
		System.out.println("clicked on Dosham");
		// Case 20:select each option in Dosham(YES/NO/Doesn't Matter)-->click on
		// done-->check whether it is displayed on Dosham field.
		try {
			key.getDosham_Tick().click();
			String s = key.getDosham_Tick().getText();
			System.out.println("Already Selected value: " + s + " Is unselected");
		} catch (Exception e) {
			e.getMessage();
		}
		key.getDosham_Yes().click();
		System.out.println("Fetching the selected value....");
		String yes = key.getDosham_Yes().getText();
		System.out.println("selected value :" + yes);
		key.getDosham_Done().click();
		System.out.println("verifying whether the selected value is reflecting in corresponding field...");
		String s = key.getDosham().getText();
		System.out.println("Reflected Value: " + s);
		Thread.sleep(2000);
		// Assert.assertEquals(yes, s);
		System.out.println("Dosham verified successfully");
		/*
		 * Case 21: Click on Don't Show Profiles -->check whether it is tappable --> and
		 * verify the following fields already contacted,
		 * viewed,ignored,blocked,shortlisted.each field should be selectable and
		 * selected option should appear in Don't show profiles field.
		 */
		key.getDoNotShowProf().click();
		System.out.println("Don't Show profiles Clickable");
		List<IOSElement> lst = driver.findElementsById("tick");
		System.out.println("selected elememts size: " + lst.size());
		for (int i = 0; i <= lst.size() - 1; i++) {
			lst.get(0).click();
			Thread.sleep(1000);
			System.out.println(i);
		}
		System.out.println("Already selected options are unselected");
		Thread.sleep(2000);
		for (int i = 0; i < 2; i++) {
			System.out.println("Verifying whether every element is selectable....");
			key.getDoNotShowProf_viewed().click();
			Thread.sleep(1000);
			key.getDoNotShowProf_contacted().click();
			Thread.sleep(1000);
			key.getDoNotShowProf_shortlisted().click();
			Thread.sleep(1000);
			key.getDoNotShowProf_ignored().click();
			System.out.println("verified");
		}
		key.getDoNotShowProf_viewed().click();
		String v = key.getDoNotShowProf_viewed().getText();
		System.out.println("selected element: " + v);
		key.getDosham_Done().click();

	}

}
