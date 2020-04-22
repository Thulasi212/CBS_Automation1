package EditPP_TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Base.BaseTest;
import POM.Delete_POM;
import POM.EPP_Pom;
import POM.Login_Pom;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class DoshamTest {
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
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.community.matrimony");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.domaininstance.ui.activities.Splash");
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
		driver.setLogLevel(Level.INFO);
	}

	// Login-->Edit PI-->Edit PP-->select dosham value as No in
	// Epp-->Search-->tapping on Search Now
	// -->getting profile list count-->view profile-->checking PP value with Vp
	// value by tapping on Next profile button
	@Test(enabled = false)
	public void dosham_SearchTest1() throws Throwable {
		Login_Pom login = new Login_Pom(driver);
		Delete_POM d = new Delete_POM(driver);
		EPP_Pom g = new EPP_Pom(driver);
		Thread.sleep(2000);
		// =================>LOGIN==============================
		try {
			login.getIntermediate_skip().click();
			Thread.sleep(2000);
			login.getIntermediate_Login().click();
			Thread.sleep(2000);
			login.getEnter_Matrid().sendKeys("IYR242926");
			login.getEnter_passwrd().sendKeys("cbstest");
			login.getEnter_Login().click();

		} catch (Exception e) {
			System.out.println("Already Login.................");
		}
		// =================>INTERMEDIATE PAGES================
		try {

			Thread.sleep(4000);
			BaseTest.click(login.getInter_close());
			System.out.println("intermediate page Handled......");

		} catch (Exception e) {
			System.out.println("no intermediate page displayed.....");
		}

		try {

			Thread.sleep(4000);
			BaseTest.click(driver.findElement(By.xpath("//*[@id='skip']")));
			System.out.println("Payment intermediate page Handled.....");

		} catch (Exception e) {
			System.out.println("no Payment intermediate page Handled .....");
		}

		try {

			Thread.sleep(4000);
			BaseTest.click(login.getQuickrespnse_clse_btn());
			System.out.println("quick Response page Handled ......");

		} catch (Exception e) {
			System.out.println("no quick response page displayed .....");
		}
		// =========================> EDIT PP==============
		SoftAssert asrt = new SoftAssert();
		Thread.sleep(2000);
		BaseTest.click(d.getProfile_btn_click());
		Thread.sleep(2000);
		Dimension size = driver.manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		g.getEditPP().click();
		Thread.sleep(5000);
		g.getPartnerReligious_Edit().click();
		Thread.sleep(2000);
		String doshamPP = g.getDosham_pp().getText();
		System.out.println("Dosham  in EditPP: " + doshamPP);
		if (doshamPP.equalsIgnoreCase("Don't Know") || doshamPP.equalsIgnoreCase("Yes")) {
			g.getDosham_pp().click();
			Thread.sleep(3000);
			g.getDosham_pp_No().click();
			Thread.sleep(4000);
			doshamPP = g.getDosham_pp().getText();
			g.getPartnerGothra_Save().click();
			Thread.sleep(4000);
		}
		if (doshamPP.equalsIgnoreCase("No")) {
			try {
				BaseTest.click(login.getNavigate_back_btn());
				Thread.sleep(3000);
				BaseTest.click(login.getNavigate_back_btn());
			} catch (Exception e) {
				e.getMessage();
			}
			Thread.sleep(4000);
			g.getSearch().click();
			Thread.sleep(5000);
			g.getSearchNow().click();
			Thread.sleep(4000);
			List<AndroidElement> lst = driver.findElementsByXPath("//*[@id='profileMatriId']");
			if (lst.size() > 0) {
				lst.get(0).click();
				Thread.sleep(8000);
				for (int i = 1; i <= 10; i++) {
					Thread.sleep(4000);
					String matriId = g.getMatriId_VP().getText();
					Thread.sleep(2000);
					driver.swipe(startx, starty, startx, endy, 3000);
					Thread.sleep(2000);
					g.getHoroscopeIcon_vp().click();
					Thread.sleep(2000);
					String dosham_VP = g.getDosham_vp().getText();
					boolean status1 = false;
					if (doshamPP.equalsIgnoreCase(dosham_VP)) {
						status1 = true;
						System.out.println("profile" + i + " " + matriId + " vp dosham " + dosham_VP
								+ " is matching with PP dosham " + doshamPP);
					}
					asrt.assertTrue(status1, "dosham not matching for profile " + i + " : " + matriId);
					try {
						g.getNextProfile_btn().click();
					} catch (Exception e) {
						break;
					}
				}
				BaseTest.click(login.getNavigate_back_btn());
				Thread.sleep(5000);
				BaseTest.click(login.getNavigate_back_btn());
				Thread.sleep(5000);
			} else {
				System.out.println("No profiles found in Search");
				BaseTest.click(login.getNavigate_back_btn());
				Thread.sleep(3000);

			}

		}
		asrt.assertAll();

	}

	// Login-->Edit PI-->Edit PP-->select dosham value as Yes in
	// Epp-->Search-->tapping on Search Now
	// -->getting profile list count-->view profile-->checking PP value with Vp
	// value by tapping on Next profile button
	@Test(enabled = false)
	public void dosham_SearchTest2() throws Throwable {
		Login_Pom login = new Login_Pom(driver);
		Delete_POM d = new Delete_POM(driver);
		EPP_Pom g = new EPP_Pom(driver);
		Thread.sleep(2000);
		// =================>LOGIN==============================
		try {
			login.getIntermediate_skip().click();
			Thread.sleep(2000);
			login.getIntermediate_Login().click();
			Thread.sleep(2000);
			login.getEnter_Matrid().sendKeys("IYR242926");
			login.getEnter_passwrd().sendKeys("cbstest");
			login.getEnter_Login().click();

		} catch (Exception e) {
			System.out.println("Already Login.................");
		}
		// =================>INTERMEDIATE PAGES================
		try {

			Thread.sleep(4000);
			BaseTest.click(login.getInter_close());
			System.out.println("intermediate page Handled......");

		} catch (Exception e) {
			System.out.println("no intermediate page displayed.....");
		}

		try {

			Thread.sleep(4000);
			BaseTest.click(driver.findElement(By.xpath("//*[@id='skip']")));
			System.out.println("Payment intermediate page Handled.....");

		} catch (Exception e) {
			System.out.println("no Payment intermediate page Handled .....");
		}

		try {

			Thread.sleep(4000);
			BaseTest.click(login.getQuickrespnse_clse_btn());
			System.out.println("quick Response page Handled ......");

		} catch (Exception e) {
			System.out.println("no quick response page displayed .....");
		}
		// =========================> EDIT PP==============
		SoftAssert asrt = new SoftAssert();
		Thread.sleep(2000);
		BaseTest.click(d.getProfile_btn_click());
		Thread.sleep(2000);
		Dimension size = driver.manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		g.getEditPP().click();
		Thread.sleep(5000);
		g.getPartnerReligious_Edit().click();
		Thread.sleep(2000);
		String doshamPP = g.getDosham_pp().getText();
		System.out.println("Dosham  in EditPP: " + doshamPP);
		if (doshamPP.equalsIgnoreCase("Don't Know") || doshamPP.equalsIgnoreCase("No")) {
			g.getDosham_pp().click();
			Thread.sleep(3000);
			g.getDosham_pp_Yes().click();
			Thread.sleep(4000);
			doshamPP = g.getDosham_pp().getText();
			g.getPartnerGothra_Save().click();
			Thread.sleep(4000);
		}
		if (doshamPP.equalsIgnoreCase("Yes")) {
			try {
				BaseTest.click(login.getNavigate_back_btn());
				Thread.sleep(3000);
				BaseTest.click(login.getNavigate_back_btn());
			} catch (Exception e) {
				e.getMessage();
			}
			Thread.sleep(4000);
			g.getSearch().click();
			Thread.sleep(5000);
			g.getSearchNow().click();
			Thread.sleep(4000);
			List<AndroidElement> lst = driver.findElementsByXPath("//*[@id='profileMatriId']");
			if (lst.size() > 0) {
				lst.get(0).click();
				Thread.sleep(8000);
				for (int i = 1; i <= 2; i++) {
					Thread.sleep(4000);
					String matriId = g.getMatriId_VP().getText();
					Thread.sleep(2000);
					driver.swipe(startx, starty, startx, endy, 3000);
					Thread.sleep(2000);
					g.getHoroscopeIcon_vp().click();
					Thread.sleep(2000);
					String dosham_VP = g.getDosham_vp().getText();
					boolean status1 = false;
					if (!dosham_VP.equalsIgnoreCase("No")) {
						status1 = true;
						System.out.println("profile" + i + " " + matriId + " vp dosham : " + dosham_VP
								+ ", PP dosham : " + doshamPP);
					}
					asrt.assertTrue(status1, "profile" + i + " : " + matriId + " is not based on PP value ");
					try {
						g.getNextProfile_btn().click();
					} catch (Exception e) {
						break;
					}
				}
				BaseTest.click(login.getNavigate_back_btn());
				Thread.sleep(5000);
				BaseTest.click(login.getNavigate_back_btn());
				Thread.sleep(5000);
			} else {
				System.out.println("No profiles found in Search");
				BaseTest.click(login.getNavigate_back_btn());
				Thread.sleep(3000);

			}
			asrt.assertAll();

		}

	}

	// Login-->Edit PI-->Edit PP-->select dosham value as No in
	// Epp-->Search-->navigating to listing
	// -->getting profile list count-->view profile-->checking PP value with Vp
	// value by tapping on Next profile button
	@Test(enabled = false)
	public void dosham_ListingTest1() throws Throwable {
		Login_Pom login = new Login_Pom(driver);
		Delete_POM d = new Delete_POM(driver);
		EPP_Pom g = new EPP_Pom(driver);
		Thread.sleep(2000);
		// =================>LOGIN==============================
		try {
			login.getIntermediate_skip().click();
			Thread.sleep(2000);
			login.getIntermediate_Login().click();
			Thread.sleep(2000);
			login.getEnter_Matrid().sendKeys("IYR242926");
			login.getEnter_passwrd().sendKeys("cbstest");
			login.getEnter_Login().click();

		} catch (Exception e) {
			System.out.println("Already Login.................");
		}
		// =================>INTERMEDIATE PAGES================
		try {

			Thread.sleep(4000);
			BaseTest.click(login.getInter_close());
			System.out.println("intermediate page Handled......");

		} catch (Exception e) {
			System.out.println("no intermediate page displayed.....");
		}

		try {

			Thread.sleep(4000);
			BaseTest.click(driver.findElement(By.xpath("//*[@id='skip']")));
			System.out.println("Payment intermediate page Handled.....");

		} catch (Exception e) {
			System.out.println("no Payment intermediate page Handled .....");
		}

		try {

			Thread.sleep(4000);
			BaseTest.click(login.getQuickrespnse_clse_btn());
			System.out.println("quick Response page Handled ......");

		} catch (Exception e) {
			System.out.println("no quick response page displayed .....");
		}
		// =========================> EDIT PP==============
		SoftAssert asrt = new SoftAssert();
		Thread.sleep(2000);
		BaseTest.click(d.getProfile_btn_click());
		Thread.sleep(2000);
		Dimension size = driver.manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		g.getEditPP().click();
		Thread.sleep(5000);
		g.getPartnerReligious_Edit().click();
		Thread.sleep(2000);
		String doshamPP = g.getDosham_pp().getText();
		System.out.println("Dosham  in EditPP: " + doshamPP);
		if (doshamPP.equalsIgnoreCase("Don't Know") || doshamPP.equalsIgnoreCase("Yes")) {
			g.getDosham_pp().click();
			Thread.sleep(3000);
			g.getDosham_pp_No().click();
			Thread.sleep(4000);
			doshamPP = g.getDosham_pp().getText();
			g.getPartnerGothra_Save().click();
			Thread.sleep(4000);
		}
		if (doshamPP.equalsIgnoreCase("No")) {
			try {
				BaseTest.click(login.getNavigate_back_btn());
				Thread.sleep(3000);
				BaseTest.click(login.getNavigate_back_btn());
			} catch (Exception e) {
				e.getMessage();
			}
			Thread.sleep(4000);
			g.getHomeIcon().click();
			Thread.sleep(3000);
			String[] s = { "JUST JOINED", "MATCHES", "PREMIUM", "MUTUAL", "VIEWED NOT CONTACTED", "SHORTLISTED",
					"VIEWED MY PROFILE", "SHORTLISTED ME", "PREFERRED PROFESSION", "PREFERRED EDUCATION",
					"PREFERRED STAR", "PREFERRED LOCATION" };
			for (String listname : s) {
				Thread.sleep(5000);
				driver.findElementByXPath("//*[@text='" + listname + "']").click();
				Thread.sleep(3000);
				if(listname.equalsIgnoreCase("JUST JOINED")||listname.equalsIgnoreCase("MATCHES")||listname.equalsIgnoreCase("PREMIUM")||listname.equalsIgnoreCase("MUTUAL")) {
					List<AndroidElement> lst = driver.findElementsByXPath("//*[@id='profileMatriId']");
					System.out.println("Verifying Dosham in " + listname);
					if (lst.size() > 0) {
						lst.get(0).click();
						Thread.sleep(8000);
						for (int i = 1; i <= 2; i++) {
							Thread.sleep(4000);
							String matriId = g.getMatriId_VP().getText();
							Thread.sleep(2000);
							driver.swipe(startx, starty, startx, endy, 3000);
							Thread.sleep(2000);
							g.getHoroscopeIcon_vp().click();
							Thread.sleep(2000);
							String dosham_VP = null;
							try {
								dosham_VP = g.getDosham_vp().getText();
							} catch (Exception e) {
								System.out.println("there is no dosham for this profile: " + matriId);
							}
							boolean status1 = false;
							if (doshamPP.equalsIgnoreCase(dosham_VP)) {
								status1 = true;
								System.out.println("profile" + i + " " + matriId + " vp dosham " + dosham_VP
										+ " is matching with PP dosham " + doshamPP);
							}
							asrt.assertTrue(status1, "dosham not matching for profile " + i + " : " + matriId);
							try {
								g.getNextProfile_btn().click();
							} catch (Exception e) {
								break;
							}
						}
						BaseTest.click(login.getNavigate_back_btn());
						Thread.sleep(5000);

					} else {
						System.out.println("No profiles found in " + listname);

					}
					
					
				}

			}
			asrt.assertAll();

		}
	}

	@Test(enabled = true)
	public void dosham_ListingTest2() throws Throwable {
		Login_Pom login = new Login_Pom(driver);
		Delete_POM d = new Delete_POM(driver);
		EPP_Pom g = new EPP_Pom(driver);
		Thread.sleep(2000);
		// =================>LOGIN==============================
		try {
			login.getIntermediate_skip().click();
			Thread.sleep(2000);
			login.getIntermediate_Login().click();
			Thread.sleep(2000);
			login.getEnter_Matrid().sendKeys("IYR242926");
			login.getEnter_passwrd().sendKeys("cbstest");
			login.getEnter_Login().click();

		} catch (Exception e) {
			System.out.println("Already Login.................");
		}
		// =================>INTERMEDIATE PAGES================
		try {

			Thread.sleep(4000);
			BaseTest.click(login.getInter_close());
			System.out.println("intermediate page Handled......");

		} catch (Exception e) {
			System.out.println("no intermediate page displayed.....");
		}

		try {

			Thread.sleep(4000);
			BaseTest.click(driver.findElement(By.xpath("//*[@id='skip']")));
			System.out.println("Payment intermediate page Handled.....");

		} catch (Exception e) {
			System.out.println("no Payment intermediate page Handled .....");
		}

		try {

			Thread.sleep(4000);
			BaseTest.click(login.getQuickrespnse_clse_btn());
			System.out.println("quick Response page Handled ......");

		} catch (Exception e) {
			System.out.println("no quick response page displayed .....");
		}
		// =========================> EDIT PP==============
		SoftAssert asrt = new SoftAssert();
		Thread.sleep(2000);
		BaseTest.click(d.getProfile_btn_click());
		Thread.sleep(2000);
		Dimension size = driver.manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		g.getEditPP().click();
		Thread.sleep(5000);
		g.getPartnerReligious_Edit().click();
		Thread.sleep(2000);
		String doshamPP = g.getDosham_pp().getText();
		System.out.println("Dosham  in EditPP: " + doshamPP);
		if (doshamPP.equalsIgnoreCase("Don't Know") || doshamPP.equalsIgnoreCase("No")) {
			g.getDosham_pp().click();
			Thread.sleep(3000);
			g.getDosham_pp_Yes().click();
			Thread.sleep(4000);
			doshamPP = g.getDosham_pp().getText();
			g.getPartnerGothra_Save().click();
			Thread.sleep(4000);
		}
		if (doshamPP.equalsIgnoreCase("Yes")) {
			try {
				BaseTest.click(login.getNavigate_back_btn());
				Thread.sleep(3000);
				BaseTest.click(login.getNavigate_back_btn());
			} catch (Exception e) {
				e.getMessage();
			}
			Thread.sleep(4000);
			g.getHomeIcon().click();
			Thread.sleep(3000);
			String[] s= {"JUST JOINED","MATCHES","PREMIUM","MUTUAL","VIEWED NOT CONTACTED","SHORTLISTED",
					"VIEWED MY PROFILE","SHORTLISTED ME","NEARBY MATCHES","PREFERRED PROFESSION","PREFERRED EDUCATION","PREFERRED STAR","PREFERRED LOCATION"};   	      
			for (String listname : s) {
				Thread.sleep(5000);
				driver.findElementByXPath("//*[@text='" + listname + "']").click();
				Thread.sleep(3000);
				if(listname.equalsIgnoreCase("JUST JOINED")||listname.equalsIgnoreCase("MATCHES")||listname.equalsIgnoreCase("PREMIUM")||listname.equalsIgnoreCase("MUTUAL")) {
					List<AndroidElement> lst = driver.findElementsByXPath("//*[@id='profileMatriId']");
					System.out.println("Verifying Dosham in " + listname);
					if (lst.size() > 0) {
						lst.get(0).click();
						Thread.sleep(8000);
						for (int i = 1; i <= 2; i++) {
							Thread.sleep(6000);
							String matriId = g.getMatriId_VP().getText();
							Thread.sleep(2000);
							driver.swipe(startx, starty, startx, endy, 3000);
							Thread.sleep(2000);
							g.getHoroscopeIcon_vp().click();
							Thread.sleep(2000);
							String dosham_VP = null;
							try {
								dosham_VP = g.getDosham_vp().getText();
							} catch (Exception e) {
								System.out.println("there is no dosham for this profile: " + matriId);
								boolean status1 = false;
								if (!dosham_VP.equalsIgnoreCase("No")) {
									status1 = true;
									System.out.println("profile" + i + " " + matriId + " vp dosham : " + dosham_VP
											+ ", PP dosham : " + doshamPP);
								}
								asrt.assertTrue(status1, "profile" + i + " : " + matriId + " is not based on PP value ");
								try {
									g.getNextProfile_btn().click();
								} catch (Exception a) {
									break;
								}
							}
						}
							BaseTest.click(login.getNavigate_back_btn());
							Thread.sleep(5000);
						
					} else {
						System.out.println("No profiles found in " + listname);

					}
					
					
				}
				
				

			}
			asrt.assertAll();
		}
	}

}
