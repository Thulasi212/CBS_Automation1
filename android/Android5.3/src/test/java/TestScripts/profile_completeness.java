package TestScripts;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.jboss.netty.util.internal.SystemPropertyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindAll;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.Login_Pom;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

public class profile_completeness extends BaseTest {
	Integer parseInt;
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
		try {
			Thread.sleep(2000);
			BaseTest.click(l.getHome_Login_btn());
			Thread.sleep(2000);
			BaseTest.click(l.getEnter_Matrid());
			Thread.sleep(2000);
			BaseTest.typeData(l.getEnter_Matrid(), "RDY485145");
			Thread.sleep(2000);
			BaseTest.typeData(l.getEnter_passwrd(), "cbstest5");
			Thread.sleep(2000);
			BaseTest.click(l.getEnter_Login());

		} catch (Exception e) {
			System.out.println("Already Login.................");
		}

		try {

			Thread.sleep(4000);
			BaseTest.click(l.getInter_close());
			System.out.println("intermediate page Handled......");

		} catch (Exception e) {
			System.out.println("no intermediate page displayed.....");
		}

		try {

			Thread.sleep(4000);
			BaseTest.click(l.getQuickrespnse_clse_btn());
			System.out.println("quick Response page Handled......");

		} catch (Exception e) {
			System.out.println("no quick response page displayed.....");
		}

		Thread.sleep(2000);
		driver.swipe(0, 800, 0, 0, 1000);

		Dimension size = driver.manage().window().getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		System.out.println(width);
		int y = (int) (height * 0.35);
		int startx = (int) (width * 0.75);
		int endx = (int) (width * 0.25);
		Thread.sleep(5000);

		try {
			if (driver.findElement(By.xpath("//*[contains(text(),'better responses')]")).isDisplayed()) {
				System.out.println(driver.findElement(By.xpath("//*[contains(text(),'better responses')]")).getText());
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[contains(text(),'Add Photo')]")).click();
				Thread.sleep(5000);
				if (driver.findElement(By.xpath("//*[@text='ADD PHOTO']")).isDisplayed()) {

					BaseTest.click(driver.findElement(By.xpath("//*[@text='ADD PHOTO']")));
					Thread.sleep(5000);
					BaseTest.click(driver.findElement(By.xpath("//*[@text='ADD PHOTO']")));
					Thread.sleep(5000);
				}
				BaseTest.click(driver.findElement(By.xpath("//*[@text='Choose from Gallery']")));
				Thread.sleep(5000);
				BaseTest.click(driver.findElement(By.xpath("//*[@text='Photos']")));
				Thread.sleep(5000);
				BaseTest.click(driver.findElement(By.xpath("//*[@text='Photos']")));
				Thread.sleep(5000);

				Thread.sleep(15000);

				List<AndroidElement> links = driver.findElements(By.xpath("//*[@class='android.view.ViewGroup']"));

				List<WebElement> visited = new ArrayList<WebElement>();
				WebElement random = links.get(new Random().nextInt(links.size()));
				String randomId = random.getText();
				System.out.println("No.of Photo's.. " + links.size());
				if (!visited.contains(random)) {
					Thread.sleep(5000);
					random.click();
					// visited.add(random);
					// driver.navigate().back();
				}

				BaseTest.click(driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")));

				System.out.println("Photo upload done successfully.....");

			}
		} catch (Exception e) {
			System.out.println("photo has been already uploaded...........");
		}
		try {
			Thread.sleep(5000);
			if (driver.findElement(By.xpath("//*[contains(text(),'fathers occupation')]")).isDisplayed()) {
				Thread.sleep(2000);
				BaseTest.typeData(driver.findElement(By.xpath("//*[@id='pcsEdit' and @width>0]")),"Government employee");
				Thread.sleep(5000);
				BaseTest.click(driver.findElement(By.xpath("//*[@text='Submit']")));
				System.out.println("Fathers occupation is  given successfully..........");
			}
		} catch (Exception e) {
			System.out.println("Fathers occupation is already given..........");
		}
		try {
			Thread.sleep(5000);
			if (driver.findElement(By.xpath("//*[contains(text(),'mothers occupation')]")).isDisplayed()) {
				Thread.sleep(2000);
				BaseTest.typeData(driver.findElement(By.xpath("//*[@id='pcsEdit' and @width>0]")),"Government employee");
				Thread.sleep(5000);
				BaseTest.click(driver.findElement(By.xpath("//*[@text='Submit']")));
			}
			System.out.println("mothers occupation is  given successfully..........");
		} catch (Exception e) {
			System.out.println("motherss occupation is already given..........");
		}

		
		try {
			if (driver.findElement(By.xpath("//*[@text='Add about your Partner']")).isDisplayed()) {
				Thread.sleep(5000);
				BaseTest.click(driver.findElement(By.xpath("//*[@text='Add about your Partner']")));
				Thread.sleep(5000);
				BaseTest.typeData(driver.findElement(By.xpath("//*[@id='partnerselfdesc']")), "Hi need a good and simple looking girl");
				Thread.sleep(5000);
				BaseTest.click(driver.findElement(By.xpath("//*[@text='Save']")));
				Thread.sleep(5000);
				BaseTest.click(driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")));

			}
		} catch (Exception e) {
			
		System.out.println("partner preferences have been added already..........");
		
	
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
