
package CBS;

import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import BasicFunctions.Base;
import Utility.Login;

import java.net.URL;
import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class KeywordSearchTest extends Base {
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

	// Case1: verify the label of Keyword Search
	@Test(enabled = true)
	public void keywordSearchTest1() throws InterruptedException {
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
		key.getSearch().click();
		String s1 = key.getKeywordSearch().getText();
		System.out.println(s1);
		assertEquals(s1, "Keyword Search");
		
	}

	@Test(enabled = true)
	public void keywordSearchTest2() throws InterruptedException {
		// Case2 : verifying Displayed default values of keyword search with PP values
		
		Login login = new Login(driver);
		IntermediatePage page = new IntermediatePage(driver);
		EditProfilePage ep= new EditProfilePage(driver);
		EditPP pp=new EditPP(driver);
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
		key.getSearch().click();
		System.out.println("fetching the values in Keyword search...");
		key.getKeyEdit().click();
		Thread.sleep(2000);
		key.getAgeArrow().click();
		Thread.sleep(2000);
		String a1 = key.getAgeFrom().getText();
		System.out.println("From Age: " + a1);
		String a2 = key.getAgeTo().getText();
		System.out.println("To Age: " + a2);
		key.getBack_AgePage().click();
		Thread.sleep(2000);
		key.getHeightArrow().click();
		Thread.sleep(2000);
		String ht1 = key.getHeightFrom().getText();
		String h1 = ht1.replaceAll("\\s", "");
		System.out.println("From height: " + h1);
		String ht2 = key.getHeightTo().getText();
		String h2 = ht2.replaceAll("\\s", "");
		System.out.println("To Height: " + h2);
		key.getBack_HeightPage().click();
		Thread.sleep(2000);
		String m1 = key.getMaritalStatus().getText();
		System.out.println("Marital Status: " + m1);
		String d1 = key.getDosham().getText();
		System.out.println("Dosham: " + d1);
		System.out.println("fetching the values of in EPP...");
		login.getMenu().click();
		pp.getEditProfile().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		pp.getEditPP().click();
		Thread.sleep(2000);
		pp.getBasicDetailsEdit().click();
		Thread.sleep(3000);
		String a3 = pp.getAgeFrom().getText();
		System.out.println(" From Age: " + a3);
		String a4 = pp.getAgeTo().getText();
		System.out.println(" To Age: " + a4);
		String ht3 = pp.getHeightFrom().getText();
		String h3 = ht3.replaceAll("\\s", "");
		System.out.println("From Height: " + h3);
		String ht4 = pp.getHeightTo().getText();
		String h4 = ht4.replaceAll("\\s", "");
		System.out.println("Height To: " + h4);
		String m2 = pp.getMaritalStatus().getText();
		System.out.println("Marital Status: " + m2);
		pp.getBack_PP().click();
		Thread.sleep(2000);
		String d2 = pp.getDosham().getText();
		System.out.println("Dosham: " + d2);
		System.out.println("Validating the values in keyword search with EPP....");
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(a1.equals(a3), "From Age is not equal");
		soft.assertTrue(a2.equals(a4), "To Age is not equal");
		System.out.println("Age value validated successfully");
		soft.assertTrue(h1.equals(h3), "From Height is not equal");
		soft.assertTrue(h2.equals(h4), "To height is not equal");
		System.out.println("Height is validated successfully");
		soft.assertTrue(m1.equals(m2), "Marital status is not equal");
		System.out.println("Marital status is validated successfully");
		// soft.assertTrue(d1.equals(d2), "Dosham is not equal");
		System.out.println("the values in keyword search validated successfully with EPP ");
		soft.assertAll();
	}

	@Test(enabled = false)
	public void keywordSearchTest3() throws Throwable {
		// case3: Check & verify whether Profiles are displayed based on Keyword.
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
		Thread.sleep(2000);
		key.getSearch().click();
		Thread.sleep(2000);
		//String keyword = getExcelData(sheetLocat, "KeywordSearch", 1, 0);
		//key.getSeachBox().sendKeys(keyword);
		Thread.sleep(2000);
		key.getKeywordSeachIcon().click();
		Thread.sleep(3000);
		boolean status1 = false;
		try {
			key.getVpLink().click();
			status1 = true;
		} catch (Exception e) {
			System.out.println("No profiles Found");
		}
		if (status1) {
			Thread.sleep(3000);
			int offset = driver.manage().window().getSize().getHeight() / 2; // start from mid screen
			System.out.println(offset);
			double time = driver.manage().window().getSize().getHeight() * 0.3; // just an example
			System.out.println(time);
			Thread.sleep(2000);
			int profileCount = 0;
			for (int i = 1; i <= 10; i++) {
				profileCount = profileCount + i;
				driver.executeScript("experitest:client.swipe(\"DOWN\",1104, 600)");
				//String mT = driver.findElement(By.xpath("//*[@id='" + keyword + "']")).getText();
				//System.out.println("Mother Tongue for profile " + i + ": " + mT);
			//	soft.assertEquals(mT, keyword);
				driver.executeScript("experitest:client.swipe(\"UP\",1104, 600)");
				Thread.sleep(1000);
				boolean status = key.getVpRtArrow().isDisplayed();
				System.out.println(status);
				if (status) {
					key.getVpRtArrow().click();
				} else {
					break;
				}
				Thread.sleep(2000);
			}
		}

	}

	@Test(enabled = false)
	public void keywordSearchTest4() throws Throwable {
		// case4: click on Edit button and check whether cancel button is enabled
		Login login = new Login(driver);
		IntermediatePage page = new IntermediatePage(driver);
		KeywordSearchPage key = new KeywordSearchPage(driver);
		try {
			login.getLogin1().click();
			//String id = getExcelData("C:\\Users\\thulasi\\workspace\\CBSIOS_3.1\\Resources\\IOS_LoginTestdata.xlsx",
					//"Keyword", 1, 0);
		//	login.getMatriId().sendKeys(id);
		//	String pwd = getExcelData("C:\\Users\\thulasi\\workspace\\CBSIOS_3.1\\Resources\\IOS_LoginTestdata.xlsx",
				//	"Keyword", 1, 1);
			//login.getPassword().sendKeys(pwd);
			login.getLogin2().click();
			System.out.println("App login successful");
		} catch (Exception e) {
			System.out.println("App already login");

		}
		Thread.sleep(3000);
		try {
			page.getAddPhoto_skip().click();
			Thread.sleep(2000);
			page.getAddPhoto_yes().click();
			System.out.println("Add photo page closed");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Add photo page not dispalyed");
		}
		Thread.sleep(2000);
		key.getSearch().click();
		Thread.sleep(2000);
		key.getKeyEdit().click();
		Thread.sleep(2000);
		boolean status = key.getCancel().isDisplayed();
		System.out.println(status);
		SoftAssert asrt = new SoftAssert();
		asrt.assertTrue(status, "Cancel button is not Available");
		System.out.println("verified successfully");
	}
	/*
	 * Case 5:"Check the following fields --> Age, height , Marital status, Dosham,
	 * are all prefilled according to the members PP (system set or user set)." AND
	 * Case 6: Click on Age and check whether it is tappable or not.
	 */

	@Test(enabled = false)
	public void keywordSearchTest5() throws Throwable {
		Login login = new Login(driver);
		IntermediatePage page = new IntermediatePage(driver);
		KeywordSearchPage key = new KeywordSearchPage(driver);
		EditPP pp = new EditPP(driver);
		try {
			login.getLogin1().click();
		//	String id = getExcelData("C:\\Users\\thulasi\\workspace\\CBSIOS_3.1\\Resources\\IOS_LoginTestdata.xlsx",
					//"Keyword", 1, 0);
			//login.getMatriId().sendKeys(id);
			//String pwd = getExcelData("C:\\Users\\thulasi\\workspace\\CBSIOS_3.1\\Resources\\IOS_LoginTestdata.xlsx",
				//	"Keyword", 1, 1);
			//login.getPassword().sendKeys(pwd);
			login.getLogin2().click();
			System.out.println("App login successful");
		} catch (Exception e) {
			System.out.println("App already login");

		}
		Thread.sleep(3000);
		try {
			page.getAddPhoto_skip().click();
			Thread.sleep(2000);
			page.getAddPhoto_yes().click();
			System.out.println("Add photo page closed");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Add photo page not dispalyed");
		}
		Thread.sleep(2000);
		key.getSearch().click();
		Thread.sleep(2000);
		key.getKeyEdit().click();
		Thread.sleep(2000);
		System.out.println("Fetching the Age value from keyword search....");
		key.getAgeArrow().click();
		Thread.sleep(2000);
		String a1 = key.getAgeFrom().getText();
		System.out.println("From Age: " + a1);
		String a2 = key.getAgeTo().getText();
		System.out.println("To Age: " + a2);
		key.getBack_AgePage().click();
		Thread.sleep(2000);
		key.getHeightArrow().click();
		Thread.sleep(2000);
		String ht1 = key.getHeightFrom().getText();
		String h1 = ht1.replaceAll("\\s", "");
		System.out.println("From height: " + h1);
		String ht2 = key.getHeightTo().getText();
		String h2 = ht2.replaceAll("\\s", "");
		System.out.println("To Height: " + h2);
		key.getBack_HeightPage().click();
		Thread.sleep(2000);
		String m1 = key.getMaritalStatus().getText();
		System.out.println("Marital Status: " + m1);
		String d1 = key.getDosham().getText();
		System.out.println("Dosham: " + d1);
		System.out.println("fetching the values of in EPP...");
		login.getMenu().click();
		pp.getEditProfile().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		pp.getEditPP().click();
		Thread.sleep(2000);
		pp.getBasicDetailsEdit().click();
		Thread.sleep(3000);
		String a3 = pp.getAgeFrom().getText();
		System.out.println(" From Age: " + a3);
		String a4 = pp.getAgeTo().getText();
		System.out.println(" To Age: " + a4);
		String ht3 = pp.getHeightFrom().getText();
		String h3 = ht3.replaceAll("\\s", "");
		System.out.println("From Height: " + h3);
		String ht4 = pp.getHeightTo().getText();
		String h4 = ht4.replaceAll("\\s", "");
		System.out.println("Height To: " + h4);
		String m2 = pp.getMaritalStatus().getText();
		System.out.println("Marital Status: " + m2);
		pp.getBack_PP().click();
		Thread.sleep(2000);
		String d2 = pp.getDosham().getText();
		System.out.println("Dosham: " + d2);
		System.out.println("Validating the values in keyword search with EPP....");
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(a1.equals(a3), "From Age is not equal");
		soft.assertTrue(a2.equals(a4), "To Age is not equal");
		System.out.println("Age value validated successfully");
		soft.assertTrue(h1.equals(h3), "From Height is not equal");
		soft.assertTrue(h2.equals(h4), "To height is not equal");
		System.out.println("Height is validated successfully");
		soft.assertTrue(m1.equals(m2), "Marital status is not equal");
		System.out.println("Marital status is validated successfully");
		// soft.assertTrue(d1.equals(d2), "Dosham is not equal");
		System.out.println("the values in keyword search validated successfully with EPP ");
		soft.assertAll();
	}

	@Test(enabled = false)
	public void keywordSearchTest6() throws Throwable {
		Login login = new Login(driver);
		IntermediatePage page = new IntermediatePage(driver);
		KeywordSearchPage key = new KeywordSearchPage(driver);
		try {
			login.getLogin1().click();
			//String id = getExcelData("C:\\Users\\thulasi\\workspace\\CBSIOS_3.1\\Resources\\IOS_LoginTestdata.xlsx",
					//"Keyword", 1, 0);
			//login.getMatriId().sendKeys(id);
			//String pwd = getExcelData("C:\\Users\\thulasi\\workspace\\CBSIOS_3.1\\Resources\\IOS_LoginTestdata.xlsx",
					//"Keyword", 1, 1);
			//login.getPassword().sendKeys(pwd);
			login.getLogin2().click();
			System.out.println("App login successful");
		} catch (Exception e) {
			System.out.println("App already login");

		}
		Thread.sleep(3000);
		try {
			page.getAddPhoto_skip().click();
			Thread.sleep(2000);
			page.getAddPhoto_yes().click();
			System.out.println("Add photo page closed");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("Add photo page not dispalyed");
		}
		Thread.sleep(2000);
		key.getSearch().click();
		Thread.sleep(2000);
		key.getKeyEdit().click();

	}

}
