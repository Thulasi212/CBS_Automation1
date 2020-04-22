package testscripts;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTestAgarwal;

import java.net.URL;
import java.awt.AWTException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Save_Search extends BaseTestAgarwal{
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
	public void testUntitled() throws InterruptedException, AWTException {
		 Edit_Profile_Pom p1 = new Edit_Profile_Pom(driver);
		Matches_Pom p = new Matches_Pom(driver);
		BaseTestAgarwal b = new BaseTestAgarwal();
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//*[@text='LOGIN']")).click();
		} catch (Exception e) {
			System.out.println("no login button");
		}
		try {
			b.click(p1.getEnter_matri_Id1());
			b.typeData(p1.getEnter_matri_Id1(), BaseTestAgarwal.readValueFromExcelSheet().get(1).get("Username"));
			Thread.sleep(5000);
			b.typeData(p1.getEnter_password1(), BaseTestAgarwal.readValueFromExcelSheet().get(1).get("Password"));
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

		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@id='icon'])[4]")).click();
		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 2000);
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("(//*[@id='txt_title'])[1]")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("(//*[@id='spinner_text'])[1]")));
		Thread.sleep(5000);
		AndroidElement Agefrom = driver.findElement(By.xpath("(//*[@id='spinner_text'])[7]"));
		Agefrom.click();
		String Agefrom1=Agefrom.getText();
		System.out.println("*" + Agefrom1);
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("(//*[@id='spinner_text'])[2]")));
		Thread.sleep(5000);
		AndroidElement AgeTo = driver.findElement(By.xpath("(//*[@id='spinner_text'])[5]"));
		AgeTo.click();
		String Ageto1=AgeTo.getText();
	
		System.out.println("*" + Ageto1);
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@id='search_ok_imageView']")));
		Thread.sleep(5000);
		String Age = driver.findElement(By.xpath("(//*[@id='txt_title'])[1]")).getText();
		System.out.println("*" +Age);
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("(//*[@id='txt_title'])[2]")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("(//*[@id='spinner_text'])[1]")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("(//*[@id='spinner_text'])[3]")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("(//*[@id='spinner_text'])[2]")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("(//*[@id='spinner_text'])[10]")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@id='search_ok_imageView']")));
		Thread.sleep(5000);
		String Height = driver.findElement(By.xpath("(//*[@id='txt_title'])[2]")).getText();
		System.out.println("*" + Height);
		
		
		
		
		
		List<AndroidElement> values =driver.findElements(By.xpath("//*[@id='txt_title']"));
		for (int i = 1; i < values.size(); i++) {
			String S =values.get(i).getText();
			System.out.println("*" + S);
			
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='imgSaveSearch']")).click();
		Thread.sleep(5000);
		b.typeData(driver.findElement(By.xpath("//*[@id='search_name_editText']")), "autosaved Seach"+Math.floor(Math.random()*1234));
		Thread.sleep(5000);
		b.click((driver.findElement(By.xpath("//*[@text='SAVE']"))));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@text='MY SAVED SEARCH']")));
		Thread.sleep(5000);
		b.click(driver.findElement(By.xpath("//*[@id='saved_my_search_TextView']")));
		Thread.sleep(5000);
	    //b.click(driver.findElement(By.xpath("//*[@id='profileMatriId']")));
		//Thread.sleep(5000);
		String text = driver.findElement(By.xpath("//*[@id='profileDesc']")).getText();
		System.out.println("*" + text);
		//driver.swipe(0, 2000, 0, 0, 3000);
		/*String[] a =text.split(",");
		String b1 =a[0].toString();
		String b12=b1.substring(0, 3);
		System.out.println(b12);
		String[] ab=a[1].split("/");
		String b2 = ab[0].toString();
		System.out.println(b2);
		String[] abc=ab[1].split(",");
		String b3 = abc[0].toString();
		System.out.println(b3);
		//String[] abcd=abc[1].split("Unmarried");
		//String b4 = abcd[0].toString();
		//System.out.println(b4);
		List<AndroidElement> findElements = driver.findElements(By.xpath("//*[@id='profileMatriId']"));
	ArrayList<AndroidElement> al= new ArrayList<AndroidElement>();
	 //String asd = findElements.retainAll(values);
	*/
	
		
		/*driver.swipe(0, 2000, 0, 0, 3000);
		driver.swipe(0, 2000, 0, 0, 3000);
		driver.swipe(0, 2000, 0, 0, 3000);
		driver.swipe(0, 2000, 0, 0, 3000);
		//driver.swipe(0, 2000, 0, 0, 3000);
*/		//Thread.sleep(5000);
		//b.click(p.getBack_btn());
			
			//Thread.sleep(5000);
			
			//Thread.sleep(5000);
			//b.click(p.getBack_btn());
			
	}		
		@AfterTest
		public void tearDown() {
			driver.resetApp();
			driver.quit();
			reports.endTest(test);
			reports.flush();
			// driver.resetApp();
			// driver.quit();

			// test.log(LogStatus.PASS, "Application Closed Succesfull");
			// reports.endTest(test);

		}
	
		
	
	
	
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	