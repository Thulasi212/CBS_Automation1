package TestScripts;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindAll;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import POM.Login_Pom;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.logging.Level;

public class Login extends BaseTest {
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
			BaseTest.typeData(l.getEnter_Matrid(), "KMC333738");
			Thread.sleep(2000);
			BaseTest.typeData(l.getEnter_passwrd(), "cbstest");
			Thread.sleep(2000);
			BaseTest.click(l.getEnter_Login());

		} catch (Exception e) {
			System.out.println("Already Login.................");
		}

		try {

			Thread.sleep(4000);
			BaseTest.click(l.getQuickrespnse_clse_btn());
			System.out.println("quick Response page Handled......");

		} catch (Exception e) {
			System.out.println("no quick response page displayed.....");
		}

		Thread.sleep(2000);

		System.out.println(driver.findElement(By.xpath("//*[@id='hotlineTitle']")).getText());
		String memebership = driver.findElement(By.xpath("//*[@id='hotlineTitle']")).getText();
		Boolean status = true;
		if (memebership.equals("Gold Member")) {
			System.out.println("membership is Gold member");

		} else if (memebership.equals("Platinum Member")) {
			System.out.println("membership is Platinum member");
		}

		else if (memebership.equals("Diamond Member")) {
			System.out.println("membership is Diamond member");
		}

		//
		// Assert.assertEquals(driver.findElement(By.xpath("//*[@id='hotlineTitle']")).
		// getText(), // "Gold Member", // "memebership not verified");

		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//*[@id='hotlineNumber']")).getText());

		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='hotlineNumber']")).getText(),
				"Your Helpline : 1800-3000-2222", "number not verified");

		Thread.sleep(2000);
		String days_Left = driver.findElement(By.xpath("//*[@id='dayleft']")).getText();
		System.out.println(days_Left);

		Thread.sleep(2000);
		String unused_contact_count = driver.findElement(By.xpath("//*[@id='unusedCount']")).getText();
		System.out.println("Unused Contacts : " + unused_contact_count);

		Thread.sleep(2000);
		String Matches_Count = driver.findElement(By.xpath("//*[@id='matchesCount']")).getText();
		System.out.println("Matches yet to View : " + Matches_Count);

		//////////////////////////// 1 st number /////////////////////////////

		Thread.sleep(2000);
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
		System.out.println(head_1 + head_2 + ":" + count1);
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"(//*[@id='dashRecycler']/*/*[@class='android.view.ViewGroup' and @height>0 and ./*[@id='quickImg']])[1]"))
				.click();
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//*[@text='GOT IT']")).click();
		} catch (Exception e) {
			System.out.println("help button disabled");
		}
		Thread.sleep(2000);
		String m1 = driver.findElement(By.xpath("//*[@id='tvClearInbox']")).getText();
		System.out.println(m1);
		String substring = m1.substring(0, 3);
		System.out.println(substring);
		if (count1.equals(substring)) {
			System.out.println("EI pending counting verified");

			Thread.sleep(3000);

			driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();

			System.out.println("landed in dashboard section..........");
		}

		//////////////////////////// 2 nt number /////////////////////////////

		Thread.sleep(2000);
		String head_12 = driver.findElement(By.xpath("(//*[@id='quickTxt'])[2]")).getText();
		System.out.println(head_12);
		Thread.sleep(2000);
		String head_21 = driver.findElement(By.xpath("(//*[@id='quickdec'])[2]")).getText();
		System.out.println(head_21);
		Thread.sleep(2000);
		String count2 = driver.findElement(By.xpath("(//*[@id='quickCount'])[2]")).getText();
		System.out.println(count2);
		String substring2 = count2.substring(0, 2);
		int parseInt2 = Integer.parseInt(substring2);
		Thread.sleep(2000);
		System.out.println(head_12 + head_21 + ":" + count2);

		Thread.sleep(4000);
		driver.findElement(By.xpath(
				"(//*[@id='dashRecycler']/*/*[@class='android.view.ViewGroup' and @height>0 and ./*[@id='quickImg']])[2]"))
				.click();

		Thread.sleep(2000);
		String toast_msg = driver.findElement(By.xpath("//*[@resource-id='android:id/message']")).getText();
		System.out.println(toast_msg);
		String substring1 = toast_msg.substring(0, 4);
		System.out.println(substring1);
		int parseInt = Integer.parseInt(substring1);
		Thread.sleep(1000);
		try {
			if (parseInt > 1000) {
				System.out.println("Newly members count verified....");

			}
		} catch (Exception e) {
			if (parseInt < 1000 || parseInt == parseInt2) {

				System.out.println("Newly members count verified and is below 1000...");

			}
		}

		/*
		 * Thread.sleep(3000); if (count2.equals(substring1)) {
		 * System.out.println("Newly members count verified...."); }
		 */
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@text='DASHBOARD']")).click();

		//////////////////////////// 3rd number /////////////////////////////

		Thread.sleep(2000);
		String head_123 = driver.findElement(By.xpath("(//*[@id='quickTxt'])[3]")).getText();
		System.out.println(head_123);
		Thread.sleep(2000);
		String head_213 = driver.findElement(By.xpath("(//*[@id='quickdec'])[3]")).getText();
		System.out.println(head_213);
		Thread.sleep(2000);
		String count3 = driver.findElement(By.xpath("(//*[@id='quickCount'])[3]")).getText();
		System.out.println(count3);
		String substring21 = count3.substring(0, 2);
		int parseInt4 = Integer.parseInt(substring21);

		Thread.sleep(2000);
		System.out.println(head_123 + head_213 + ":" + count3);

		Thread.sleep(2000);
		driver.swipe(0, 400, 0, 0, 1000);
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"(//*[@id='dashRecycler']/*/*[@class='android.view.ViewGroup' and ./*[@id='quickImg']])[3]"))
				.click();

		Thread.sleep(2000);
		String toast_msg1 = driver.findElement(By.xpath("//*[@id='message']")).getText();
		System.out.println(toast_msg1);
		String substring12 = toast_msg1.substring(0, 4);
		System.out.println(substring12);
		int parseInt3 = Integer.parseInt(substring12);
		Thread.sleep(1000);

		try {
			if (parseInt3 > 1000) {
				System.out.println(" members viewed ur profile count verified....");

			}
		} catch (Exception e) {
			if (parseInt3 < 1000 || parseInt3 == parseInt4) {

				System.out.println("members viewed ur profile count verified and is below 1000...");

			}
		}
		Thread.sleep(3000);
		Dimension size = driver.manage().window().getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		System.out.println(width);
		int y = (int) (height * 0.15);
		int startx = (int) (width * 0.75);
		int endx = (int) (width * 0.35);
		Thread.sleep(5000); //
		driver.swipe(startx, y, endx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);

		driver.swipe(endx, y, startx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@text='DASHBOARD']")).click();
//////////////
		Thread.sleep(2000);
		driver.swipe(0, 800, 0, 0, 1000);
		//////////////////////////// 4th number /////////////////////////////

		Thread.sleep(2000);
		String head_1234 = driver.findElement(By.xpath("(//*[@id='quickTxt'])[4]")).getText();
		System.out.println(head_1234);
		Thread.sleep(2000);
		String head_2134 = driver.findElement(By.xpath("(//*[@id='quickdec'])[4]")).getText();
		System.out.println(head_2134);
		Thread.sleep(2000);
		String count4 = driver.findElement(By.xpath("(//*[@id='quickCount'])[4]")).getText();
		System.out.println(count4);
		Thread.sleep(2000);
		System.out.println(head_1234 + head_2134 + ":" + count4);
		Thread.sleep(2000);

		// driver.swipe(0, 400, 0, 0, 1000);

		Thread.sleep(3000);
		driver.swipe(0, 400, 0, 0, 1000);
		driver.findElement(By.xpath(
				"(//*[@id='dashRecycler']/*/*[@class='android.view.ViewGroup' and ./*[@id='quickImg']])[4]"))
				.click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
		Thread.sleep(3000);

		System.out.println("landed in dashboard section..........");

		driver.swipe(0, 800, 0, 0, 1000);

		Thread.sleep(3000);

		/*
		 * int offset = driver.manage().window().getSize().getHeight() / 2; // start
		 * from mid screen System.out.println(offset); double time =
		 * driver.manage().window().getSize().getHeight() * 0.3; // just an example
		 * System.out.println(time);
		 * driver.executeScript("experitest:client.swipe(\"LEFT\",740, 500)");
		 */

		Thread.sleep(2000);

		try {
			if (driver.findElement(By.xpath(
					"//*[@id='dashTitle' and (./preceding-sibling::* | ./following-sibling::*)[@height>0 and ./*[@id='mCommunicationLay']]]"))
					.isDisplayed()) {
				System.out.println(driver.findElement(By.xpath(
						"//*[@id='dashTitle' and (./preceding-sibling::* | ./following-sibling::*)[@height>0 and ./*[@id='mCommunicationLay']]]"))
						.getText());
				
	

			}
			Thread.sleep(3000);
			if (driver.findElement(By.xpath("//*[@id='txtMoreComm']")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id='txtMoreComm']")).click();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		Thread.sleep(5000);
		AndroidElement next_profile = driver.findElement(By.xpath("//*[@id='nextprofile' and @width>0]"));
		if (next_profile.isDisplayed()) {
			for (int i = 0; i < 5; i++) {
				next_profile.click();
			}
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@contentDescription='Navigate up' and @width>0]")).click();

		}
		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 1000);

		Thread.sleep(5000);
		try {
			if (driver.findElement(By.xpath(
					"//*[@id='dashTitle' and @height>0 and (./preceding-sibling::* | ./following-sibling::*)[./*[@id='card_view']]]"))
					.isDisplayed()) {
				System.out.println(driver.findElement(By.xpath(
						"//*[@id='dashTitle' and @height>0 and (./preceding-sibling::* | ./following-sibling::*)[./*[@id='card_view']]]"))
						.getText());

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//*[@class='android.widget.RelativeLayout' and @width>0 and @height>0 and ./*[@width>0] and (./preceding-sibling::* | ./following-sibling::*)[@height>0] and ./*[@id='lldateSupport']]"))
				.click();

		AndroidElement next_profile1 = driver.findElement(By.xpath("//*[@id='nextprofile' and @width>0]"));
		if (next_profile.isDisplayed()) {
			for (int j = 0; j < 5; j++) {
				next_profile1.click();
			}
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@contentDescription='Navigate up' and @width>0]")).click();

		}

		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 1000);

		Thread.sleep(5000);
		try {
			if (driver.findElement(By.xpath(
					"//*[@id='dashTitle' and @height>0 and (./preceding-sibling::* | ./following-sibling::*)[./*[@id='mCommunicationLay']]]"))
					.isDisplayed()) {
				System.out.println(driver.findElement(By.xpath(
						"//*[@id='dashTitle' and @height>0 and (./preceding-sibling::* | ./following-sibling::*)[./*[@id='mCommunicationLay']]]"))
						.getText());

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='first' and @height>0 and ./*[./*[./*[@width>0]]]]")).click();
		AndroidElement next_profile12 = driver.findElement(By.xpath("//*[@id='nextprofile' and @width>0]"));
		if (next_profile12.isDisplayed()) {
			for (int k = 0; k < 5; k++) {
				next_profile12.click();
			}
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@contentDescription='Navigate up' and @width>0]")).click();

		}

		Thread.sleep(5000);
		driver.swipe(0, 800, 0, 0, 1000);

		Thread.sleep(5000);
		try {
			if (driver.findElement(By.xpath(
					"//*[@id='dashTitle' and (./preceding-sibling::* | ./following-sibling::*)[./*[@id='mCommunicationLay' and ./*[./*[./*[./*[./*[@id='layCommAction']]]]]]]]"))
					.isDisplayed()) {
				System.out.println(driver.findElement(By.xpath(
						"//*[@id='dashTitle' and (./preceding-sibling::* | ./following-sibling::*)[./*[@id='mCommunicationLay' and ./*[./*[./*[./*[./*[@id='layCommAction']]]]]]]]"))
						.getText());

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//*[@id='first' and ./*[./*[./*[@width>0]]] and (./preceding-sibling::* | ./following-sibling::*)[@id='layCommAction']]"))
				.click();
		AndroidElement next_profile123 = driver.findElement(By.xpath("//*[@id='nextprofile' and @width>0]"));
		if (next_profile123.isDisplayed()) {
			for (int m = 0; m < 5; m++) {
				next_profile123.click();
			}
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@contentDescription='Navigate up' and @width>0]")).click();

		}


		Thread.sleep(5000);

		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}



/*
 * Thread.sleep(3000); Dimension size = driver.manage().window().getSize();
 * System.out.println(size); int width = size.getWidth();
 * System.out.println(width); int startx = (int) (size.width * 0.8); int endx =
 * (int) (size.width * 0.20); int starty = size.height / 2; new
 * TouchAction(driver).longPress(38, 996).moveTo(720, 1119).release().perform();
 */

//driver.swipe(startx, starty, endx, starty, 2000);
//driver.executeScript("experitest:client.swipe(\"RIGHT\",300, 500)");
// System.out.println("swiped right succesfully...");
