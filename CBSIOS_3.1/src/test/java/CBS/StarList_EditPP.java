package CBS;
//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BasicFunctions.Base;
import Utility.Login;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class StarList_EditPP {
  private String reportDirectory = "reports";
  private String reportFormat = "xml";
  private String testName = "Untitled";
  protected IOSDriver<IOSElement> driver = null;

  DesiredCapabilities dc = new DesiredCapabilities();
  
  @BeforeTest
  public void setUp() throws MalformedURLException {
      dc.setCapability("reportDirectory", reportDirectory);
      dc.setCapability("reportFormat", reportFormat);
      dc.setCapability("testName", testName);
      dc.setCapability(MobileCapabilityType.UDID, "989240f183880fddcaff8ce3a01d58842aaa2317");
      dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.communityMatrimony.CommunityMatrimony");
      driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
      driver.setLogLevel(Level.INFO);
  }
   //verifying the Star dropdown values based on Mother Tongue in Edit profile
	@SuppressWarnings("rawtypes")
	@Test(enabled = true)
	public void starlistEditProfile() throws Throwable {
		Login login = new Login(driver);
		IntermediatePage page = new IntermediatePage(driver);
		EditProfilePage ep= new EditProfilePage(driver);
		try {
			login.getLogin1().click();
			login.getMatriId().sendKeys("AGR100173");
			login.getPassword().sendKeys("cbstest");
			login.getLogin2().click();
		} catch (Exception e) {

		}
		Thread.sleep(2000);
		try {
			page.getAddPhoto_skip().click();
			Thread.sleep(2000);
			page.getAddPhoto_yes().click();
			
		} catch (Exception e) {
			e.getMessage();
			
		}
		try {
			ep.getQuickResponseClose().click();
			Thread.sleep(1000);
		}catch (Exception e) {
			e.getMessage();
			
		}
		ep.leftMenu().click();
		Thread.sleep(2000);
		ep.getEditProfile().click();
		Thread.sleep(3000);
		driver.executeScript("experitest:client.swipe(\"DOWN\",1104, 600)");
		String motherTongue=ep.getMotherTongueValue().getText();
		System.out.println("Mother Tongue: "+motherTongue);
		Thread.sleep(2000);
		//int offset = driver.manage().window().getSize().getHeight() / 2; // start from mid screen
		//System.out.println(offset);
		//double time = driver.manage().window().getSize().getHeight() * 0.3; // just an example
		//System.out.println(time);
		driver.executeScript("experitest:client.swipe(\"UP\",1104, 600)");
		Thread.sleep(4000);
		ep.getEditPP().click();
		ep.getEditReligiousInfo().click();
		System.out.println("clicked on Religious Information Edit button");
		Thread.sleep(2000);
		ep.getStarEdit().click();
		System.out.println("Clicked on Star Edit button");
		Thread.sleep(5000);
		SoftAssert asrt = new SoftAssert();
        if (motherTongue.equals("Tamil")) {
            for (int j = 1; j <= 27; j++) {
                String star = Base.getExcelData("Star", j, 0);
                System.out.println("Expected star value: "+star);
                Thread.sleep(2000);
                ep.getStarSearch().click();
                ((IOSDriver)driver).getKeyboard().pressKey(star);
                Thread.sleep(2000);
                String star1 = ep.getStarSearchValue().getText();
                System.out.println("Actual star value: "+star1);
                Thread.sleep(1000);
                System.out.println("verifying Actual star value with Expected star value...");
                asrt.assertEquals(star1, star, "Star not equal");
                System.out.println("verified successfully");
                ep.getStarSearchValue().click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='Done']")).click();
                Thread.sleep(1000);
                ep.getStarEdit().click();
            }
            asrt.assertAll();
        }
        Thread.sleep(2000);
        if (motherTongue.equals("Bengali")) {
            for (int j = 1; j <= 27; j++) {
                String star = Base.getExcelData("Star", j, 1);
                System.out.println("Expected star value: "+star);
                Thread.sleep(2000);
                ep.getStarSearch().click();
                ((IOSDriver)driver).getKeyboard().pressKey(star);
                Thread.sleep(2000);
                String star1 = ep.getStarSearchValue().getText();
                System.out.println("Actual star value: "+star1);
                Thread.sleep(1000);
                System.out.println("verifying Actual star value with Expected star value...");
                asrt.assertEquals(star1, star, "Star not equal");
                System.out.println("verified successfully");
                ep.getStarSearchValue().click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='Done']")).click();
                Thread.sleep(1000);
                String star2=driver.findElement(By.xpath("//*[@id='Star']/following-sibling::*")).getText();
                System.out.println("verifying Reflected star value with selected star value...");
                asrt.assertEquals(star2, star1, "Reflected Star not equal");
                System.out.println("verified successfully");
                ep.getStarEdit().click();
                
            }
            asrt.assertAll();
        }
        Thread.sleep(2000);
        if (motherTongue.equals("Marathi")) {
            for (int j = 1; j <= 27; j++) {
                String star = Base.getExcelData("Star", j, 2);
                System.out.println("Expected star value: "+star);
                Thread.sleep(2000);
                ep.getStarSearch().click();
                ((IOSDriver)driver).getKeyboard().pressKey(star);
                Thread.sleep(2000);
                String star1 = ep.getStarSearchValue().getText();
                System.out.println("Actual star value: "+star1);
                Thread.sleep(1000);
                System.out.println("verifying Actual star value with Expected star value...");
                asrt.assertEquals(star1, star, "Star not equal");
                System.out.println("verified successfully");
                ep.getStarSearchValue().click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='Done']")).click();
                Thread.sleep(1000);
                ep.getStarEdit().click();
                
          
            }
            asrt.assertAll();
        }
        Thread.sleep(2000);
        if (motherTongue.equals("Gujarati")) {
            for (int j = 1; j <= 27; j++) {
                String star = Base.getExcelData("Star", j, 3);
                System.out.println("Expected star value: "+star);
                Thread.sleep(2000);
                ep.getStarSearch().click();
                ((IOSDriver)driver).getKeyboard().pressKey(star);
                Thread.sleep(2000);
                String star1 = ep.getStarSearchValue().getText();
                System.out.println("Actual star value: "+star1);
                Thread.sleep(1000);
                System.out.println("verifying Actual star value with Expected star value...");
                
                asrt.assertEquals(star1, star, "Star not equal");
                System.out.println("verified successfully");
                ep.getStarSearchValue().click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='Done']")).click();
                Thread.sleep(1000);
                ep.getStarEdit().click();
                
          
            }
            asrt.assertAll();
        }
        Thread.sleep(2000);
        if (motherTongue.equals("Punjabi")) {
            for (int j = 1; j <= 27; j++) {
                String star = Base.getExcelData("Star", j, 4);
                System.out.println("Expected star value: "+star);
                Thread.sleep(2000);
                ep.getStarSearch().click();
                ((IOSDriver)driver).getKeyboard().pressKey(star);
                Thread.sleep(2000);
                String star1 = ep.getStarSearchValue().getText();
                System.out.println("Actual star value: "+star1);
                Thread.sleep(1000);
                System.out.println("verifying Actual star value with Expected star value...");
                
                asrt.assertEquals(star1, star, "Star not equal");
                System.out.println("verified successfully");
                ep.getStarSearchValue().click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='Done']")).click();
                Thread.sleep(1000);
                ep.getStarEdit().click();
                
          
            }
            asrt.assertAll();
        }
        Thread.sleep(2000);
        if (motherTongue.equals("Hindi")) {
            for (int j = 1; j <= 27; j++) {
                String star = Base.getExcelData("Star", j, 5);
                System.out.println("Expected star value: "+star);
                Thread.sleep(2000);
                ep.getStarSearch().click();
                ((IOSDriver)driver).getKeyboard().pressKey(star);
                Thread.sleep(2000);
                String star1 = ep.getStarSearchValue().getText();
                System.out.println("Actual star value: "+star1);
                Thread.sleep(1000);
                System.out.println("verifying Actual star value with Expected star value...");
                asrt.assertEquals(star1, star, "Star not equal");
                System.out.println("verified successfully");
                ep.getStarSearchValue().click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='Done']")).click();
                Thread.sleep(1000);
                ep.getStarEdit().click();
            }
            asrt.assertAll();
        }
        Thread.sleep(2000);
        if (motherTongue.equals("Sindhi")) {
            for (int j = 1; j <= 27; j++) {
                String star = Base.getExcelData("Star", j, 6);
                System.out.println("Expected star value: "+star);
                Thread.sleep(2000);
                ep.getStarSearch().click();
                ((IOSDriver)driver).getKeyboard().pressKey(star);
                Thread.sleep(2000);
                String star1 = ep.getStarSearchValue().getText();
                System.out.println("Actual star value: "+star1);
                Thread.sleep(1000);
                System.out.println("verifying Actual star value with Expected star value...");
                
                asrt.assertEquals(star1, star, "Star not equal");
                System.out.println("verified successfully");
                ep.getStarSearchValue().click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='Done']")).click();
                Thread.sleep(1000);
                ep.getStarEdit().click();
                
          
            }
            asrt.assertAll();
        }
        Thread.sleep(2000);
        if (motherTongue.equals("Kannada")) {
            for (int j = 1; j <= 27; j++) {
                String star = Base.getExcelData("Star", j, 7);
                System.out.println("Expected star value: "+star);
                Thread.sleep(2000);
                ep.getStarSearch().click();
                ((IOSDriver)driver).getKeyboard().pressKey(star);
                Thread.sleep(2000);
                String star1 = ep.getStarSearchValue().getText();
                System.out.println("Actual star value: "+star1);
                Thread.sleep(1000);
                System.out.println("verifying Actual star value with Expected star value...");
                
                asrt.assertEquals(star1, star, "Star not equal");
                System.out.println("verified successfully");
                ep.getStarSearchValue().click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='Done']")).click();
                Thread.sleep(1000);
                ep.getStarEdit().click();
                
          
            }
            asrt.assertAll();
        }
        Thread.sleep(2000);
        if (motherTongue.equals("Malayalam")) {
            for (int j = 1; j <= 27; j++) {
                String star = Base.getExcelData("Star", j, 8);
                System.out.println("Expected star value: "+star);
                Thread.sleep(2000);
                ep.getStarSearch().click();
                ((IOSDriver)driver).getKeyboard().pressKey(star);
                Thread.sleep(2000);
                String star1 = ep.getStarSearchValue().getText();
                System.out.println("Actual star value: "+star1);
                Thread.sleep(1000);
                System.out.println("verifying Actual star value with Expected star value...");
                
                asrt.assertEquals(star1, star, "Star not equal");
                System.out.println("verified successfully");
                ep.getStarSearchValue().click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='Done']")).click();
                Thread.sleep(1000);
                ep.getStarEdit().click();
                
          
            }
            asrt.assertAll();
        }
        Thread.sleep(2000);
        if (motherTongue.equals("Telugu")) {
            for (int j = 1; j <= 27; j++) {
                String star = Base.getExcelData("Star", j, 9);
                System.out.println("Expected star value: "+star);
                Thread.sleep(2000);
                ep.getStarSearch().click();
                ((IOSDriver)driver).getKeyboard().pressKey(star);
                Thread.sleep(2000);
                String star1 = ep.getStarSearchValue().getText();
                System.out.println("Actual star value: "+star1);
                Thread.sleep(1000);
                System.out.println("verifying Actual star value with Expected star value...");
                
                asrt.assertEquals(star1, star, "Star not equal");
                System.out.println("verified successfully");
                ep.getStarSearchValue().click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='Done']")).click();
                Thread.sleep(1000);
                ep.getStarEdit().click();
                
          
            }
            asrt.assertAll();
        }
        Thread.sleep(2000);
        if (motherTongue.equals("Marwadi")) {
            for (int j = 1; j <= 27; j++) {
                String star = Base.getExcelData("Star", j, 10);
                System.out.println("Expected star value: "+star);
                Thread.sleep(2000);
                ep.getStarSearch().click();
                ((IOSDriver)driver).getKeyboard().pressKey(star);
                Thread.sleep(2000);
                String star1 = ep.getStarSearchValue().getText();
                System.out.println("Actual star value: "+star1);
                Thread.sleep(1000);
                System.out.println("verifying Actual star value with Expected star value...");
                
                asrt.assertEquals(star1, star, "Star not equal");
                System.out.println("verified successfully");
                ep.getStarSearchValue().click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='Done']")).click();
                Thread.sleep(1000);
                ep.getStarEdit().click();
                
          
            }
            asrt.assertAll();
        }
        Thread.sleep(2000);
        if (motherTongue.equals("Assamese")) {
            for (int j = 1; j <= 27; j++) {
                String star = Base.getExcelData("Star", j, 12);
                System.out.println("Expected star value: "+star);
                Thread.sleep(2000);
                ep.getStarSearch().click();
                ((IOSDriver)driver).getKeyboard().pressKey(star);
                Thread.sleep(2000);
                String star1 = ep.getStarSearchValue().getText();
                System.out.println("Actual star value: "+star1);
                Thread.sleep(1000);
                System.out.println("verifying Actual star value with Expected star value...");
                
                asrt.assertEquals(star1, star, "Star not equal");
                System.out.println("verified successfully");
                ep.getStarSearchValue().click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='Done']")).click();
                Thread.sleep(1000);
                ep.getStarEdit().click();
                
          
            }
            asrt.assertAll();
        }
        Thread.sleep(2000);
        if (motherTongue.equals("Oriya")) {
            for (int j = 1; j <= 27; j++) {
                String star = Base.getExcelData("Star", j, 13);
                System.out.println("Expected star value: "+star);
                Thread.sleep(2000);
                ep.getStarSearch().click();
                ((IOSDriver)driver).getKeyboard().pressKey(star);
                Thread.sleep(2000);
                String star1 = ep.getStarSearchValue().getText();
                System.out.println("Actual star value: "+star1);
                Thread.sleep(1000);
                System.out.println("verifying Actual star value with Expected star value...");
                
                asrt.assertEquals(star1, star, "Star not equal");
                System.out.println("verified successfully");
                ep.getStarSearchValue().click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='Done']")).click();
                Thread.sleep(1000);
                ep.getStarEdit().click();
                
          
            }
            asrt.assertAll();
        }
        Thread.sleep(2000);
        if (motherTongue.equals("Urdu")) {
            for (int j = 1; j <= 27; j++) {
                String star = Base.getExcelData("Star", j, 14);
                System.out.println("Expected star value: "+star);
                Thread.sleep(2000);
                ep.getStarSearch().click();
                ((IOSDriver)driver).getKeyboard().pressKey(star);
                Thread.sleep(2000);
                String star1 = ep.getStarSearchValue().getText();
                System.out.println("Actual star value: "+star1);
                Thread.sleep(1000);
                System.out.println("verifying Actual star value with Expected star value...");
                
                asrt.assertEquals(star1, star, "Star not equal");
                System.out.println("verified successfully");
                ep.getStarSearchValue().click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='Done']")).click();
                Thread.sleep(1000);
                ep.getStarEdit().click();
                
          
            }
            asrt.assertAll();
        }
        
	   }
	
	
	}

