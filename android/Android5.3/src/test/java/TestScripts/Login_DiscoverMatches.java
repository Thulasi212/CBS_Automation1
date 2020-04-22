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

public class Login_DiscoverMatches extends BaseTest {
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
		
		//////////// Location MAtches/////////////////////////
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		Thread.sleep(2000);
		String locationcountdash = driver.findElement(By.xpath("((//*[@id='dashRecycler']/*[@class='android.view.ViewGroup'])[1]/*[@class='android.widget.TextView' and @width>0 and @height>0])[2]")).getText();
		Thread.sleep(2000);
		System.out.println(locationcountdash);
		
		String loc1 = locationcountdash.substring(0, 3);
		int locint1 = Integer.parseInt(loc1);
		System.out.println(locint1);
		
		
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@text='Location']")).click();
	
	
		
		Thread.sleep(1000);
		String locationcount = driver.findElement(By.xpath("//*[@resource-id='android:id/message']")).getText();
		Thread.sleep(2000);
		System.out.println(locationcount);
		String loc = locationcount.substring(0, 3);
		int locint = Integer.parseInt(loc);
		System.out.println(locint);
		Thread.sleep(2000);
		if (locint1==locint) {
			System.out.println("location prefernces matches count verified with Preffered location matches");
		}
			else {
				System.out.println("not verfied");
			}
		Thread.sleep(2000);	
		Dimension size = driver.manage().window().getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		System.out.println(width);
		int y = (int) (height * 0.15);
		int startx = (int) (width * 0.75);
		int endx = (int) (width * 0.35);
		Thread.sleep(5000); //
		//driver.swipe(startx, y, endx, y, 4000);
		for (int i = 1; i <=12; i++) {
			driver.swipe(endx, y, startx, y, 4000);
		}
		
		/*driver.swipe(endx, y, startx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);
		driver.swipe(endx, y, startx, y, 4000);*/
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@text='DASHBOARD']")).click();
		
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		
      ////////////Education MAtches/////////////////////////
		
		
		String Educationcountdash = driver.findElement(By.xpath("((//*[@id='dashRecycler']/*[@class='android.view.ViewGroup'])[2]/*[@class='android.widget.TextView' and @width>0 and @height>0])[2]")).getText();
		Thread.sleep(2000);
		System.out.println(Educationcountdash);
		
		String edu1 = Educationcountdash.substring(0, 4);
		int eduint1 = Integer.parseInt(edu1);
		System.out.println(eduint1);
		
		
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@text='Education']")).click();
	
	    Thread.sleep(2000);
		String Educationcount = driver.findElement(By.xpath("//*[@resource-id='android:id/message']")).getText();
		Thread.sleep(2000);
		System.out.println(Educationcount);
		String edu = Educationcount.substring(0, 4);
		int eduint = Integer.parseInt(edu);
		System.out.println(eduint);
		Thread.sleep(2000);
		if (eduint1==eduint) {
			System.out.println("Education  prefernces matches count verified with Preffered Education matches");
		}
			else {
				System.out.println("not verfied");
			}
		Thread.sleep(2000);
		for (int i = 1; i <=12; i++) {
			driver.swipe(endx, y, startx, y, 4000);
		}
		
		
		
	Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@text='DASHBOARD']")).click();
		
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		
      ////////////Profession MAtches/////////////////////////
		
		
		String profesioncountdash = driver.findElement(By.xpath("((//*[@id='dashRecycler']/*[@class='android.view.ViewGroup'])[3]/*[@class='android.widget.TextView' and @width>0 and @height>0])[2]")).getText();
		Thread.sleep(2000);
		System.out.println(profesioncountdash);
		
		String pro1 = profesioncountdash.substring(0, 4);
		int proint1 = Integer.parseInt(pro1);
		System.out.println(proint1);
		
		
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@text='Profession']")).click();
	
	    Thread.sleep(2000);
		String professioncount = driver.findElement(By.xpath("//*[@resource-id='android:id/message']")).getText();
		Thread.sleep(2000);
		System.out.println(professioncount);
		String pro = professioncount.substring(0, 4);
		int proint = Integer.parseInt(pro);
		System.out.println(proint);
		Thread.sleep(2000);
		if (proint1==proint) {
			System.out.println("Profession  prefernces matches count verified with Preffered Profession matches");
		}
			else {
				System.out.println("not verfied");
			}
		Thread.sleep(2000);
		for (int i = 1; i <=12; i++) {
			driver.swipe(endx, y, startx, y, 4000);
		}
			
		
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@text='DASHBOARD']")).click();
		
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		driver.swipe(0, 800, 0, 0, 1000);
		
      //////////// Star MAtches/////////////////////////
		
		
		String starcountdash = driver.findElement(By.xpath("((//*[@id='dashRecycler']/*[@class='android.view.ViewGroup'])[4]/*[@class='android.widget.TextView' and @width>0 and @height>0])[2]")).getText();
		Thread.sleep(2000);
		System.out.println(starcountdash);
		
		String star1 = starcountdash.substring(0, 3);
		int starint1 = Integer.parseInt(star1);
		System.out.println(starint1);
		
		
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@text='Star']")).click();
	
	    Thread.sleep(2000);
		String Starcount = driver.findElement(By.xpath("//*[@resource-id='android:id/message']")).getText();
		Thread.sleep(2000);
		System.out.println(Starcount);
		String star = Starcount.substring(0, 3);
		int starint = Integer.parseInt(star);
		System.out.println(starint);
		Thread.sleep(2000);
		if (starint1==starint) {
			System.out.println("Star  prefernces matches count verified with Preffered Star matches");
		}
			else {
				System.out.println("not verfied");
			}
		Thread.sleep(2000);
		for (int i = 1; i <=12; i++) {
			driver.swipe(endx, y, startx, y, 4000);
		}
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
		}
		
		
		
}
