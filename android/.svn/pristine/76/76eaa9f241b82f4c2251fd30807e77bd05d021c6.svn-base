package TestScripts;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.Delete_POM;
import POM.Login_Pom;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class Agressive_pp_newuser {
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

	@Test
	public void testUntitled() throws InterruptedException {
		Login_Pom l = new Login_Pom(driver);
		Delete_POM d = new Delete_POM(driver);
		for (int i = 0; i <= 0; i++) {
			try {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@text='Skip']")).click();
				Thread.sleep(2000);
				// driver.findElement(By.xpath("//*[@text='Skip']")).click();
				// Thread.sleep(2000);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@text='Login']")).click();
				Thread.sleep(2000);

				Thread.sleep(2000);
				String username = BaseTest.readValueFromExcelSheet().get(i).get("KMC333738");
				String password = BaseTest.readValueFromExcelSheet().get(i).get("cbstest");
				// BaseTest.click(l.getEnter_Matrid());
				Thread.sleep(2000);

				BaseTest.typeData(l.getEnter_Matrid(), username);

				Thread.sleep(2000);
				BaseTest.typeData(l.getEnter_passwrd(), password);

				Thread.sleep(2000);
				BaseTest.click(l.getEnter_Login());

			} catch (Exception e) {
				System.out.println("Already Login................."); 
			}

			try {

				Thread.sleep(8000);
				BaseTest.click(l.getInter_close());
				System.out.println("intermediate page Handled......");

			} catch (Exception e) {
				System.out.println("no intermediate page displayed.....");
			}

			try {

				Thread.sleep(8000);
				BaseTest.click(driver.findElement(By.xpath("//*[@id='skip']")));
				System.out.println("PAyment intermediate page HAndled");

			} catch (Exception e) {
				System.out.println("no PAyment intermediate page HAndled.....");
			}

			try {

				Thread.sleep(8000);
				BaseTest.click(l.getQuickrespnse_clse_btn());
				System.out.println("quick Response page Handled......");

			} catch (Exception e) {
				System.out.println("no quick response page displayed.....");
			}

			////////// JUST JOINED SECTION/////////////////
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@text='JUST JOINED']")).click();
			Thread.sleep(8000);
			String just_joined = "new members matching your profile information";
			String profile_count = driver.findElement(By.xpath("//*[@id='count']")).getText();
			System.out.println(profile_count);
			System.out.println(just_joined);
	
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@id='pp_edit']")).click();

			Thread.sleep(8000);
			BaseTest.click(l.getNavigate_back_btn());
			System.out.println("landed back in just joined section..........");

			////////// JUST JOINED SECTION/////////////////
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@text='MATCHES']")).click();
			Thread.sleep(8000);
			String Matches = "members matching your profile information";

			System.out.println(Matches);

			String Matches_count_ = driver.findElement(By.xpath("//*[@id='count']")).getText();
			System.out.println(Matches_count_);
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@id='pp_edit']")).click();
			Thread.sleep(8000);
			BaseTest.click(l.getNavigate_back_btn());
			System.out.println("landed back in just joined section..........");

			////////// JUST JOINED SECTION/////////////////
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@text='PREMIUM']")).click();
			String premium = "premium members match your preferences";

			System.out.println(premium);
			Thread.sleep(8000);
			String premium_count = driver.findElement(By.xpath("//*[@id='count']")).getText();
			System.out.println(premium_count);
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@id='pp_edit']")).click();
			Thread.sleep(8000);
			BaseTest.click(l.getNavigate_back_btn());
			System.out.println("landed back in just joined section..........");
			////////// JUST JOINED SECTION/////////////////

			/*Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@text='MUTUAL']")).click();
			String mutual = "Members with whom you match mutually";

			System.out.println(mutual);

			Thread.sleep(8000);

			String mutual_count = driver.findElement(By.xpath("//*[@id='count']")).getText();
			System.out.println(mutual_count);
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@id='pp_edit']")).click();
			Thread.sleep(8000);
			BaseTest.click(l.getNavigate_back_btn());
			Thread.sleep(8000);
			System.out.println("landed back in just joined section..........");*/
			Thread.sleep(2000);

			////////////

			Thread.sleep(5000);
			Dimension size = driver.manage().window().getSize();
			int height = size.getHeight();
			int width = size.getWidth();
			System.out.println(width);
			int y = (int) (height * 0.15);
			int startx = (int) (width * 0.75);
			int endx = (int) (width * 0.35);

			driver.swipe(startx, y, endx, y, 4000);
			driver.swipe(startx, y, endx, y, 4000);
			driver.swipe(startx, y, endx, y, 4000);
			driver.swipe(startx, y, endx, y, 4000);

			////////// NearBy SECTION/////////////////

			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@text='NEARBY MATCHES']")).click();
			Thread.sleep(8000);

			String nearby_matches = driver.findElement(By.xpath("//*[@id='count']")).getText();
			System.out.println(nearby_matches);
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@id='pp_edit']")).click();
			Thread.sleep(8000);
			BaseTest.click(l.getNavigate_back_btn());
			Thread.sleep(8000);
			System.out.println("landed back in  nearby_matches section..........");
			Thread.sleep(2000);

			////////// Prfeered Profession SECTION/////////////////

			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@text='PREFERRED PROFESSION']")).click();
			Thread.sleep(8000);
			String preffered = "members matching your selected preference";
			System.out.println(preffered);
			System.out.println(Matches);
			String profession = driver.findElement(By.xpath("//*[@id='count']")).getText();
			System.out.println(profession);
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@id='pp_edit']")).click();
			Thread.sleep(8000);
			BaseTest.click(l.getNavigate_back_btn());
			Thread.sleep(8000);
			System.out.println("landed back in PREFERRED PROFESSION section..........");
			Thread.sleep(2000);

			////////// Prefferd Education  /////////////////

			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@text='PREFERRED EDUCATION']")).click();
			Thread.sleep(8000);
			System.out.println(preffered);
			String EDUCATION = driver.findElement(By.xpath("//*[@id='count']")).getText();
			System.out.println(EDUCATION);
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@id='pp_edit']")).click();
			Thread.sleep(8000);
			BaseTest.click(l.getNavigate_back_btn());
			Thread.sleep(8000);
			System.out.println("landed back in PREFERRED EDUCATION section..........");
			Thread.sleep(2000);

			////////// Prefferd Star SECTION/////////////////

			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@text='PREFERRED STAR']")).click();
			Thread.sleep(8000);
			System.out.println(preffered);
			String STAR = driver.findElement(By.xpath("//*[@id='count']")).getText();
			System.out.println(STAR);
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@id='pp_edit']")).click();
			Thread.sleep(8000);
			BaseTest.click(l.getNavigate_back_btn());
			Thread.sleep(8000);
			System.out.println("landed back in  PREFFERED STAR section..........");
			Thread.sleep(2000);

			//////////  Prefferd Location  SECTION/////////////////

			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@text='PREFERRED LOCATION']")).click();
			Thread.sleep(8000);
			System.out.println(preffered);
			String LOCATION = driver.findElement(By.xpath("//*[@id='count']")).getText();
			System.out.println(LOCATION);
			Thread.sleep(8000);
			driver.findElement(By.xpath("//*[@id='pp_edit']")).click();
			Thread.sleep(8000);
			BaseTest.click(l.getNavigate_back_btn());
			Thread.sleep(8000);
			System.out.println("landed back in  PREFFERED LOCATION section..........");
			Thread.sleep(2000);

			BaseTest.click(d.getProfile_btn_click());
			Thread.sleep(2000);

			driver.scrollToExact("Account Settings").click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='logoutLayout']")).click();
			Thread.sleep(10000);
			driver.resetApp();
	
	
	
	
	
	
	
	
	
		}}
	
	
	
	
	
	
	
}
