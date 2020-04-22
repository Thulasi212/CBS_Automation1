package CBS;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.Login;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AddPhoto_IntermediatePageTest {
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

	@Test(enabled = false)
	public void addPhotoTest1() throws Exception {
		//Scenorio1: Intermediate Page-->Add Photo CTA-->choose photo
		Login login = new Login(driver);
		EditProfilePage ep= new EditProfilePage(driver);
		AddPhotoPage add=new AddPhotoPage(driver);
		try {
			login.getLogin1().click();
			login.getMatriId().sendKeys("AGR100173");
			login.getPassword().sendKeys("cbstest");
			login.getLogin2().click();
		} catch (Exception e) {
            e.getMessage();
		}
		Thread.sleep(2000);
		add.getAddPhto().click();
		System.out.println("Clicked on Add Photo");
		Thread.sleep(2000);
		add.getcancel1().click();
		System.out.println("Clicked on Cancel button ");
		Thread.sleep(2000);
		add.getAddPhto().click();
		System.out.println("Clicked on Add Photo");
		Thread.sleep(2000);
		add.getChoosePhoto().click();
		System.out.println("Clicked on Choose Photo");
		Thread.sleep(2000);
		add.getPhotoSource().click();
		System.out.println(" photo gallery(selfies) selected");
		Thread.sleep(2000);
		List<IOSElement> lst=driver.findElementsByXPath("//*[@XCElementType='XCUIElementTypeCell']");
		for(int i=0;i<lst.size();) {
			lst.get(i).click();
			System.out.println("photo selected");
			break;
		}
		add.getChoose().click();
		System.out.println("clicked on choose");
		Thread.sleep(2000);
		add.getSave().click();
		System.out.println(" clicked on Save button");
		Thread.sleep(8000);
		try {
			Thread.sleep(5000);
			ep.getQuickResponseClose().click();
			Thread.sleep(1000);
		}catch (Exception e) {
			e.getMessage();
		}
		System.out.println(" clicked on Save button");
		Thread.sleep(5000);
	//	DeletePhoto.deletePhotoTest();
		
		
	}
	
	@Test(enabled = false)
	public void addPhotoTest2() throws Exception {
		//Scenorio1: Intermediate Page-->Add Photo CTA-->Take photo
		Login login = new Login(driver);
		EditProfilePage ep= new EditProfilePage(driver);
		AddPhotoPage add=new AddPhotoPage(driver);
		try {
			login.getLogin1().click();
			login.getMatriId().sendKeys("AGR100173");
			login.getPassword().sendKeys("cbstest");
			login.getLogin2().click();
		} catch (Exception e) {
            e.getMessage();
		}
		Thread.sleep(2000);
		add.getAddPhto().click();
		System.out.println("Clicked on Add Photo");
		Thread.sleep(2000);
		add.getcancel1().click();
		System.out.println("Clicked on Cancel button ");
		Thread.sleep(2000);
		add.getAddPhto().click();
		System.out.println("Clicked on Add Photo");
		Thread.sleep(2000);
		add.getChoosePhoto().click();
		System.out.println("Clicked on Choose Photo");
		Thread.sleep(2000);
		add.getPhotoSource().click();
		System.out.println(" photo gallery(selfies) selected");
		Thread.sleep(2000);
		List<IOSElement> lst=driver.findElementsByXPath("//*[@XCElementType='XCUIElementTypeCell']");
		for(int i=0;i<lst.size();) {
			lst.get(i).click();
			System.out.println("photo selected");
			break;
		}
		add.getChoose().click();
		System.out.println("clicked on choose");
		Thread.sleep(2000);
		add.getSave().click();
		System.out.println(" clicked on Save button");
		Thread.sleep(8000);
		try {
			Thread.sleep(5000);
			ep.getQuickResponseClose().click();
			Thread.sleep(1000);
		}catch (Exception e) {
			e.getMessage();
		}
		System.out.println(" clicked on Save button");
		Thread.sleep(5000);
	//	DeletePhoto.deletePhotoTest();
		
		
	}
}
