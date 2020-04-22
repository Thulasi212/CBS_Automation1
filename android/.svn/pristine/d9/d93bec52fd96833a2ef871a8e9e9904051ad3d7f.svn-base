package TestScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.Delete_POM;
import POM.Login_Pom;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Raasi_EI_mtongue extends BaseTest {

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
	public void testUntitled() throws Throwable {

		Login_Pom l = new Login_Pom(driver);
		Delete_POM d = new Delete_POM(driver);
		for (int i = 0; i <= 0; i++) {
			try {
				BaseTest.click(l.getLogin_skip_btn());

				BaseTest.click(l.getLogin_btn());

				//String username = BaseTest.readValueFromExcelSheet().get(i).get("EZH710533");
				//String password = BaseTest.readValueFromExcelSheet().get(i).get("cbstest");
				// BaseTest.click(l.getEnter_Matrid());
				Thread.sleep(2000);

				BaseTest.typeData(l.getEnter_Matrid(), "rdy485145");

				Thread.sleep(2000);
				BaseTest.typeData(l.getEnter_passwrd(), "cbstest");

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
				BaseTest.click(driver.findElement(By.xpath("//*[@id='skip']")));
				System.out.println("Payment intermediate page Handled.....");

			} catch (Exception e) {
				System.out.println("no Payment intermediate page Handled .....");
			}

			try {

				Thread.sleep(4000);
				BaseTest.click(l.getQuickrespnse_clse_btn());
				System.out.println("quick Response page Handled ......");

			} catch (Exception e) {
				System.out.println("no quick response page displayed .....");
			}

			Thread.sleep(2000);
			BaseTest.click(d.getProfile_btn_click());
			Thread.sleep(2000);

			driver.scrollToExact("Edit Profile").click();
			driver.swipe(0, 800, 0, 0, 1000);
			Thread.sleep(5000);
			BaseTest.click(driver.findElement(By.xpath("//*[@id='basicdetails_edit']")));
			Thread.sleep(5000);
			String mtongue_ei = driver.findElement(By.xpath("//*[@id='edit_edt_mothertongue_value']")).getText();
			System.out.println(mtongue_ei);
			Thread.sleep(5000);
			BaseTest.click(l.getNavigate_back_btn());
			Thread.sleep(5000);
			driver.swipe(0, 800, 0, 0, 1000);
			Thread.sleep(5000);
			driver.swipe(0, 800, 0, 0, 1000);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='religiousdetails_edit']")).click();

			Thread.sleep(5000);
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='edit_txt_raasi_value']")).click();
			Thread.sleep(5000);
			
			if (mtongue_ei.equals("Tamil")) {
				for (int j = 1; j <= 13; j++) {
					String star = BaseTest.getExcelData("Sheet5", j, 12);
					System.out.println(star);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(star);
					Thread.sleep(5000);
					String star1 = driver.findElement(By.xpath("//*[@id='value_textView']")).getText();
					System.out.println(star1);
					Thread.sleep(5000);
					if (star.equalsIgnoreCase(star1)) {
						System.out.println("rasi verified......");

					} else {
						System.out.println("Not verified.....");
					}
				}
			}
			
			Thread.sleep(5000);
			if (mtongue_ei.equals("Bengali")) {
				for (int j = 1; j <= 13; j++) {
					String star = BaseTest.getExcelData("Sheet5", j, 1);
					System.out.println(star);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(star);
					Thread.sleep(5000);
					String star1 = driver.findElement(By.xpath("//*[@id='value_textView']")).getText();
					System.out.println(star1);
					Thread.sleep(5000);
					if (star.equalsIgnoreCase(star1)) {
						System.out.println("star verified......");

					} else {
						System.out.println("Not verified.....");
					}
				}
			}
			
			Thread.sleep(5000);
			if (mtongue_ei.equals("Marathi")) {
				for (int j = 1; j <= 13; j++) {
					String star = BaseTest.getExcelData("Sheet5", j, 6);
					System.out.println(star);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(star);
					Thread.sleep(5000);
					String star1 = driver.findElement(By.xpath("//*[@id='value_textView']")).getText();
					System.out.println(star1);
					Thread.sleep(5000);
					if (star.equalsIgnoreCase(star1)) {
						System.out.println("star verified......");

					} else {
						System.out.println("Not verified.....");
					}
				}
			}
			Thread.sleep(5000);
			if (mtongue_ei.equals("Gujarati")) {
				for (int j = 1; j <= 13; j++) {
					String star = BaseTest.getExcelData("Sheet5", j, 2);
					System.out.println(star);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(star);
					Thread.sleep(5000);
					String star1 = driver.findElement(By.xpath("//*[@id='value_textView']")).getText();
					System.out.println(star1);
					Thread.sleep(5000);
					if (star.equalsIgnoreCase(star1)) {
						System.out.println("star verified......");

					} else {
						System.out.println("Not verified.....");
					}
				}
			}
			Thread.sleep(5000);
			if (mtongue_ei.equals("Punjabi")) {
				for (int j = 1; j <= 13; j++) {
					String star = BaseTest.getExcelData("Sheet5", j, 10);
					System.out.println(star);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(star);
					Thread.sleep(5000);
					String star1 = driver.findElement(By.xpath("//*[@id='value_textView']")).getText();
					System.out.println(star1);
					Thread.sleep(5000);
					if (star.equalsIgnoreCase(star1)) {
						System.out.println("star verified......");

					} else {
						System.out.println("Not verified.....");
					}
				}
			}

			Thread.sleep(5000);
			if (mtongue_ei.equals("Hindi")) {
				for (int j = 1; j <= 13; j++) {
					String star = BaseTest.getExcelData("Sheet5", j, 3);
					System.out.println(star);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(star);
					Thread.sleep(5000);
					String star1 = driver.findElement(By.xpath("//*[@id='value_textView']")).getText();
					System.out.println(star1);
					Thread.sleep(5000);
					if (star.equalsIgnoreCase(star1)) {
						System.out.println("star verified......");

					} else {
						System.out.println("Not verified.....");
					}
				}
			}
			Thread.sleep(5000);
			if (mtongue_ei.equals("Sindhi")) {
				for (int j = 1; j <= 13; j++) {
					String star = BaseTest.getExcelData("Sheet5", j, 11);
					System.out.println(star);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(star);
					Thread.sleep(5000);
					String star1 = driver.findElement(By.xpath("//*[@id='value_textView']")).getText();
					System.out.println(star1);
					Thread.sleep(5000);
					if (star.equalsIgnoreCase(star1)) {
						System.out.println("star verified......");

					} else {
						System.out.println("Not verified.....");
					}
				}
			}
			Thread.sleep(5000);
			if (mtongue_ei.equals("Kannada")) {
				for (int j = 1; j <= 13; j++) {
					String star = BaseTest.getExcelData("Sheet5", j, 4);
					System.out.println(star);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(star);
					Thread.sleep(5000);
					String star1 = driver.findElement(By.xpath("//*[@id='value_textView']")).getText();
					System.out.println(star1);
					Thread.sleep(5000);
					if (star.equalsIgnoreCase(star1)) {
						System.out.println("star verified......");

					} else {
						System.out.println("Not verified.....");
					}
				}
			}
			Thread.sleep(5000);

			if (mtongue_ei.equals("Malayalam")) {
				for (int j = 1; j <= 13; j++) {
					String star = BaseTest.getExcelData("Sheet5", j, 5);
					System.out.println(star);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(star);
					Thread.sleep(5000);
					String star1 = driver.findElement(By.xpath("//*[@id='value_textView']")).getText();
					System.out.println(star1);
					Thread.sleep(5000);
					if (star.equalsIgnoreCase(star1)) {
						System.out.println("star verified......");

					} else {
						System.out.println("Not verified.....");
					}
				}
			}
			Thread.sleep(5000);
			if (mtongue_ei.equals("Telugu")) {
				for (int j = 1; j <= 13; j++) {
					String star = BaseTest.getExcelData("Sheet5", j, 13);
					System.out.println(star);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(star);
					Thread.sleep(5000);
					String star1 = driver.findElement(By.xpath("//*[@id='value_textView']")).getText();
					System.out.println(star1);
					Thread.sleep(5000);
					if (star.equalsIgnoreCase(star1)) {
						System.out.println("star verified......");

					} else {
						System.out.println("Not verified.....");
					}
				}
			}
			Thread.sleep(5000);
			if (mtongue_ei.equals("Marwadi")) {
				for (int j = 1; j <= 13; j++) {
					String star = BaseTest.getExcelData("Sheet5", j, 7);
					System.out.println(star);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(star);
					Thread.sleep(5000);
					String star1 = driver.findElement(By.xpath("//*[@id='value_textView']")).getText();
					System.out.println(star1);
	
					
					Thread.sleep(5000);
					if (star.equalsIgnoreCase(star1)) {
						System.out.println("star verified......");

					} else {
						System.out.println("Not verified.....");
					}
				}
			}

			Thread.sleep(5000);
			if (mtongue_ei.equals("Parsi")) {
				for (int j = 1; j <= 13; j++) {
					String star = BaseTest.getExcelData("Sheet5", j, 11);
					System.out.println(star);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(star);
					Thread.sleep(5000);
					String star1 = driver.findElement(By.xpath("//*[@id='value_textView']")).getText();
					System.out.println(star1);
					Thread.sleep(5000);
					if (star.equalsIgnoreCase(star1)) {
						System.out.println("star verified......");

					} else {
						System.out.println("Not verified.....");
					}
				}
			}
			Thread.sleep(5000);
			if (mtongue_ei.equals("Assamese")) {
				for (int j = 1; j <= 13; j++) {
					String star = BaseTest.getExcelData("Sheet5", j, 0);
					System.out.println(star);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(star);
					Thread.sleep(5000);
					String star1 = driver.findElement(By.xpath("//*[@id='value_textView']")).getText();
					System.out.println(star1);
					Thread.sleep(5000);
					if (star.equalsIgnoreCase(star1)) {
						System.out.println("star verified......");

					} else {
						System.out.println("Not verified.....");
					}
				}
			}
			Thread.sleep(5000);
			if (mtongue_ei.equals("Oriya")) {
				for (int j = 1; j <= 13; j++) {
					String star = BaseTest.getExcelData("Sheet5", j, 8);
					System.out.println(star);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(star);
					Thread.sleep(5000);
					String star1 = driver.findElement(By.xpath("//*[@id='value_textView']")).getText();
					System.out.println(star1);
					Thread.sleep(5000);
					if (star.equalsIgnoreCase(star1)) {
						System.out.println("star verified......");

					} else {
						System.out.println("Not verified.....");
					}
				}
			}

			Thread.sleep(5000);
			if (mtongue_ei.equals("Urdu")) {
				for (int j = 1; j <= 13; j++) {
					String star = BaseTest.getExcelData("Sheet5", j, 15);
					System.out.println(star);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='reg_search_editText']")).sendKeys(star);
					Thread.sleep(5000);
					String star1 = driver.findElement(By.xpath("//*[@id='value_textView']")).getText();
					System.out.println(star1);
					Thread.sleep(5000);
					if (star.equalsIgnoreCase(star1)) {
						System.out.println("star verified......");

					} else {
						System.out.println("Not verified.....");
					}
			}
			}
			
			
		

		}

	}
}

			
			
			
			
			
			
			

