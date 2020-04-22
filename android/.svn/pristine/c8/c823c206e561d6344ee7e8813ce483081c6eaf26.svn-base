package com.app.Android_App;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTestAgarwal;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;

public class Who_Viewed_my_Contact {
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


	@BeforeMethod
	public void testUntitled() throws InterruptedException {
		 Edit_Profile_Pom p1 = new Edit_Profile_Pom(driver);
		Matches_Pom p = new Matches_Pom(driver);
		BaseTest b = new BaseTest();
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//*[@text='LOGIN']")).click();
		} catch (Exception e) {
			System.out.println("no login button");
		}
		try {
			b.click(p1.getEnter_matri_Id1());
			b.typeData(p1.getEnter_matri_Id1(), BaseTest.readValueFromExcelSheet().get(1).get("Username"));
			Thread.sleep(5000);
			b.typeData(p1.getEnter_password1(), BaseTest.readValueFromExcelSheet().get(1).get("Password"));
			Thread.sleep(5000);
			b.click(p1.getEnter_Login1());
		} catch (Exception e) {
			System.out.println("Already login");
		}
		Thread.sleep(10000);

		try {
			WebElement allow = driver.findElement(By.xpath("//*[@text='ALLOW']"));
			if (allow.isDisplayed()) {
				allow.click();
			}
		} catch (Exception e) {
			System.out.println("No photo page");

		}
		try {
			WebElement skip = driver.findElement(By.xpath("//*[@id='skip']"));
			if (skip.isDisplayed()) {
				skip.click();

			}
		} catch (Exception e) {
			e.getMessage();
		}
		try {
			WebElement popup = driver.findElement(By.xpath("//*[@id='popup_close_btn']"));
			if (popup.isDisplayed()) {
				popup.click();
			}
		} catch (Exception e) {
			e.getMessage();
		}

		// driver.findElement(By.xpath("//*[@id='skip']")).click();
		Thread.sleep(5000);
		try {
			AndroidElement photo_skip = driver.findElement(By.xpath("//*[@id='doitlater']"));
			if (photo_skip.isDisplayed()) {
				photo_skip.click();
			}
		} catch (Exception e) {
			e.getMessage();
		}

		System.out.println("login and landed in dashboard");

	}

	@Test
	public void testUntitled1() throws InterruptedException {
		Matches_Pom p = new Matches_Pom(driver);
		BaseTest b = new BaseTest();

		Thread.sleep(5000);

		b.click(driver.findElement(By.xpath("(//*[@id='icon'])[5]")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@text='Who Viewed My Contact']")));

		List<AndroidElement> ID = driver.findElements(By.xpath("//*[@id='profileMatriId']"));
		for (int i = 0; i < ID.size(); i++) {
			//driver.scrollTo("RDY");
			String ids = ID.get(i).getText();
			System.out.println("viewed my contact ID are " + ids);

		}
		Thread.sleep(5000);
		try {
			if (p.getV_shortlisted_btn().isDisplayed()) {
				b.click(p.getV_shortlisted_btn());
				Thread.sleep(5000);
				//driver.findElement(By.xpath("//*[@id='btn_send_interest']")).click();
				Thread.sleep(5000);
				b.click(p.getBack_btn());
				Thread.sleep(5000);
				b.click(p.getNot_now_btn());
				/*try {
					b.click(p.getPopup_close());
					//driver.findElement(By.xpath("//*[@id='popup_close_btn']"))
				} catch (Exception e) {
					System.out.println("no pop up displayed");
				}*/
			}
		} catch (Exception e) {
			System.out.println("membership package");
			
			// b.click(p.getBack_btn());
		}

		// b.click(p.getView_sent_Intrest_btn());
		Thread.sleep(5000);
		String View_1 = driver.findElement(By.xpath("//*[@id='profileMatriId']")).getText();
		System.out.println(View_1);
		Thread.sleep(5000);
		// driver.findElement(By.xpath("//*[@contentDescription='Navigate
		// up']")).click();
		b.click(p.getBack_btn());
		Thread.sleep(5000);
		b.click(p.getMail_box());
		Thread.sleep(5000);
		try {

			b.click(p.getFilter());
		} catch (Exception e) {
			System.out.println("Handled");
		}
		Thread.sleep(5000);
		b.click(p.getSent_Icon());
		Thread.sleep(5000);
		String View_2 = driver.findElement(By.xpath("//*[@id='profileMatriId']")).getText();
		System.out.println(View_2);
		if (View_1.equals(View_2)) {
			System.out.println("sent intrest verified successfully");
		}

		// Thread.sleep(5000);

		b.click(p.getBack_btn());
		Thread.sleep(5000);
		
		Dimension size = driver.manage().window().getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		System.out.println(width);
		int y = (int) (height * 0.15);
		int startx = (int) (width * 0.75);
		int endx = (int) (width * 0.35);
		Thread.sleep(5000);
		driver.swipe(startx, y, endx, y, 4000);
		driver.swipe(startx, y, endx, y, 4000);
		driver.swipe(startx, y, endx, y, 4000);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='SHORTLISTED']")).click();
		Thread.sleep(5000);

		// Thread.sleep(5000);
		List<AndroidElement> IDS = driver.findElements(By.xpath("//*[@id='profileMatriId']"));
		for (int i = 0; i < IDS.size(); i++) {
			//driver.scrollTo("RDY");
			String ids = ID.get(i).getText();

			if (View_1.contains(ids)) {
				System.out.println("shortlisted id verified");
			} else {
				System.out.println("no id verified");
			}

			b.click(p.getMenu_btn());
			driver.swipe(0, 800, 0, 0, 1000);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='accountsLayout']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='logoutLayout']")).click();

		}
	}


	@AfterTest
	public void tearDown() {
		driver.resetApp();
		driver.quit();
		//reports.endTest(test);
		// reports.flush();
	}









}
