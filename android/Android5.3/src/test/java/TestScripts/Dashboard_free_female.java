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
import POM.Login_Pom;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class Dashboard_free_female extends BaseTest {
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
		
       //////////////////////////////////1st number//////////////////////////////////////
	/*	Thread.sleep(2000);
		String quick_title = driver.findElement(By.xpath("//*[@id='dashTitle']")).getText();
		System.out.println(quick_title);

		Thread.sleep(2000);
		String head_1 = driver.findElement(By.xpath("(//*[@id='quickTxt'])[1]")).getText();
		System.out.println(head_1);
		Thread.sleep(2000);
		String head_2 = driver.findElement(By.xpath("(//*[@id='quickdec'])[1]")).getText();
		System.out.println(head_2);
		Thread.sleep(2000);
		String count1 = driver.findElement(By.xpath("(//*[@id='quickCount'])[1]")).getText();
		System.out.println(count1);
		Thread.sleep(2000);
		String substring2 = count1.substring(0, 1);
		int parseInt2 = Integer.parseInt(substring2);
		Thread.sleep(2000);
		System.out.println(head_1 + head_2 + ":" + count1);*/
		//Thread.sleep(2000);

		//Thread.sleep(4000);
		//driver.findElement(By.xpath(
			//	"(//*[@id='dashRecycler']/*/*[@class='android.view.ViewGroup' and @height>0 and ./*[@id='quickImg']])[1]"))
				//.click();

		/*Thread.sleep(2000);
		String toast_msg = driver.findElement(By.xpath("//*[@resource-id='android:id/message']")).getText();
		System.out.println(toast_msg);
		try {
			String substring1 = toast_msg.substring(0, 1);
			System.out.println(substring1);
			parseInt = Integer.parseInt(substring1);
		} catch (Exception e) {
			System.out.println("handled..");
		}

		Thread.sleep(1000);

		if (parseInt > 1000) {
			System.out.println("Newly members count verified....");

		}

		else if (parseInt < 1000 || parseInt == parseInt2) {

			System.out.println("Newly members count verified and is below 1000...");

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@text='DASHBOARD']")).click();
		
*/


	/*	Thread.sleep(2000);
		String head_12 = driver.findElement(By.xpath("(//*[@id='quickTxt'])[2]")).getText();
		System.out.println(head_12);
		Thread.sleep(2000);
		String head_21 = driver.findElement(By.xpath("(//*[@id='quickdec'])[2]")).getText();
		System.out.println(head_21);
		Thread.sleep(2000);
		String count2 = driver.findElement(By.xpath("(//*[@id='quickCount'])[2]")).getText();
		System.out.println(count2);
		String substring21 = count2.substring(0, 2);
		int parseInt21 = Integer.parseInt(substring21);
		Thread.sleep(2000);
		System.out.println(head_12 + head_21 + ":" + count2);
		Thread.sleep(4000);*/
//		driver.findElement(By.xpath(
	//			"(//*[@id='dashRecycler']/*/*[@class='android.view.ViewGroup' and @height>0 and ./*[@id='quickImg']])[2]"))
		//		.click();

		/*Thread.sleep(2000);
		String toast_msg1 = driver.findElement(By.xpath("//*[@resource-id='android:id/message']")).getText();
		System.out.println(toast_msg1);
		String substring12 = toast_msg1.substring(0, 2);
		System.out.println(substring12);
		int parseInt3 = Integer.parseInt(substring12);
		Thread.sleep(1000);

		
			if (parseInt3 > 1000) {
				System.out.println(" members viewed ur profile count verified....");

			}
		 
			else if (parseInt3 < 1000 || parseInt3 == parseInt21) {

				System.out.println("members viewed ur profile count verified and is below 1000...");

			}*/
		

		Thread.sleep(3000);
		Dimension size = driver.manage().window().getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		System.out.println(width);
		int y = (int) (height * 0.45);
		int startx = (int) (width * 0.75);
		int endx = (int) (width * 0.15);
		Thread.sleep(5000); //
		/*driver.swipe(startx, y, endx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);

		driver.swipe(endx, y, startx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@text='DASHBOARD']")).click();
	
		Thread.sleep(2000);
		String head_123 = driver.findElement(By.xpath("(//*[@id='quickTxt'])[3]")).getText();
		System.out.println(head_123);
		Thread.sleep(2000);
		String head_213 = driver.findElement(By.xpath("(//*[@id='quickdec'])[3]")).getText();
		System.out.println(head_213);
		Thread.sleep(2000);
		String count3 = driver.findElement(By.xpath("(//*[@id='quickCount'])[3]")).getText();
		System.out.println(count3);
		String substring212 = count3.substring(0, 1);
		int parseInt4 = Integer.parseInt(substring212);

		Thread.sleep(2000);
		System.out.println(head_123 + head_213 + ":" + count3);*/

		Thread.sleep(2000);
		//driver.findElement(By.xpath(
			//	"(//*[@id='dashRecycler']/*/*[@class='android.view.ViewGroup' and ./*[@id='quickImg']])[3]"))
			//	.click();
		Thread.sleep(2000);
		/*try {
			driver.findElement(By.xpath("//*[@text='GOT IT']")).click();
		} catch (Exception e) {
			System.out.println("help button disabled");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();

		System.out.println("landed in dashboard section..........");
		
		Thread.sleep(2000);
		
	*/
		Thread.sleep(2000);
		driver.swipe(0, 400, 0, 0, 1000);
		
			Thread.sleep(3000);
			
			
			String viewprofile_count = driver.findElement(By.xpath("//*[contains(text(),' Members viewed your profile')]")).getText();
			
			if (driver.findElement(By.xpath("//*[contains(text(),' Members viewed your profile')]")).isDisplayed()) {
				System.out.println(viewprofile_count);
				String substring7 = viewprofile_count.substring(0, 2);
				int parseInt21 = Integer.parseInt(substring7);
				Thread.sleep(2000);
				for (int m = 1; m <= 6; m++) {
					driver.swipe(startx, y, endx, y, 4000);
				}

			//}
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@text='VIEW ALL']")).click();
			Thread.sleep(1000);
			String toast_msg5 = driver.findElement(By.xpath("//*[@resource-id='android:id/message']")).getText();
			System.out.println(toast_msg5);
			String substring5 = toast_msg5.substring(0, 2);
			System.out.println(substring5);
			int parseInt5 = Integer.parseInt(substring5);
			Thread.sleep(2000);
	
			if (parseInt5 > 1000) {
				System.out.println(" members viewed ur profile count verified....");

			}
		 
			else if (parseInt5 < 1000 || parseInt5 == parseInt21) {

				System.out.println("members viewed ur profile count verified and is below 1000...");

			}
			Thread.sleep(2000);
			Dimension size2 = driver.manage().window().getSize();
			int height2 = size.getHeight();
			int width2 = size.getWidth();
			System.out.println(width2);
			int y2 = (int) (height2 * 0.15);
			int startx2 = (int) (width2 * 0.75);
			int endx2 = (int) (width2 * 0.35);
			Thread.sleep(5000);
			for (int r = 1; r <= 8; r++) {
				driver.swipe(startx2, y2, endx2, y2, 4000);
			}

			
			}

	}}
	


	

		
		
		
		
		
		
		
		
		
		
		
	

