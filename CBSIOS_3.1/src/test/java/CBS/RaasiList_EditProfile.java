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
import BasicFunctions.Base;
import Utility.Login;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;

public class RaasiList_EditProfile {
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
	@Test(enabled = true)
	public void keywordSearchTest1() throws Throwable {
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
		int offset = driver.manage().window().getSize().getHeight() / 2; // start from mid screen
		System.out.println(offset);
		double time = driver.manage().window().getSize().getHeight() * 0.3; // just an example
		System.out.println(time);
		Thread.sleep(2000);
		driver.executeScript("experitest:client.swipe(\"DOWN\",1100, 600)");
		String motherTongue=ep.getMotherTongueValue().getText();
		System.out.println("Mother Tongue: "+motherTongue);
		Thread.sleep(1000);
		driver.executeScript("experitest:client.swipe(\"DOWN\",1200, 600)");
		Thread.sleep(4000);
		ep.getEditReligiousInfo().click();
		System.out.println("clicked on Religious Information Edit button");
		Thread.sleep(2000);
		ep.getRaasiEdit().click();
		System.out.println("Clicked on Raasi Edit button");
		Thread.sleep(5000);
		if (motherTongue.equals("Assamese")) {
          for (int j = 1; j <= 12; j++) {
              String raasi = Base.getExcelData("Raasi", j, 0);
              System.out.println("Expected Raasi value: "+raasi);
              String s1=raasi.replaceAll("\\s", "");
              System.out.println(s1);
              Thread.sleep(2000);
              List<IOSElement> lst = driver.findElements(By.xpath("//*[@class='UIAStaticText']"));
              boolean status=false;
              for(int i=0;i<=lst.size()-1;i++) {
            	  String raasi1=lst.get(i).getText();
            	  System.out.println(raasi1);
            	  String s2=raasi1.replaceAll("\\s", "");
            	  System.out.println(s2);
            	  if(s1.equals(s2)) {
            		  System.out.println("Actual Raasi value: "+raasi1);
            		  status=true;
            	  }
              }
              if(status==false) {
            	  System.out.println("Raasi " +j+"  value is not matching");
              }
              
          }
    
      }
      Thread.sleep(2000);
      if (motherTongue.equals("Bengali")) {
          for (int j = 1; j <= 12; j++) {
              String raasi = Base.getExcelData("Raasi", j, 1);
              System.out.println("Expected Raasi value: "+raasi);
              String s1=raasi.replaceAll("\\s", "");
              System.out.println(s1);
              Thread.sleep(2000);
              List<IOSElement> lst = driver.findElements(By.xpath("//*[@class='UIAStaticText']"));
              boolean status=false;
              for(int i=0;i<=lst.size()-1;i++) {
            	  String raasi1=lst.get(i).getText();
            	  System.out.println(raasi1);
            	  String s2=raasi1.replaceAll("\\s", "");
            	  System.out.println(s2);
            	  if(s1.equals(s2)) {
            		  System.out.println("Actual Raasi value: "+raasi1);
            		  status=true;
            	  }
              }
              if(status==false) {
            	  System.out.println("Raasi " +j+"  value is not matching");
              }
          }
          
      }
      if (motherTongue.equals("Gujarati")) {
          for (int j = 1; j <= 12; j++) {
              String raasi = Base.getExcelData("Raasi", j, 2);
              System.out.println("Expected Raasi value: "+raasi);
              String s1=raasi.replaceAll("\\s", "");
              System.out.println(s1);
              Thread.sleep(2000);
              List<IOSElement> lst = driver.findElements(By.xpath("//*[@class='UIAStaticText']"));
              boolean status=false;
              for(int i=0;i<=lst.size()-1;i++) {
            	  String raasi1=lst.get(i).getText();
            	  System.out.println(raasi1);
            	  String s2=raasi1.replaceAll("\\s", "");
            	  System.out.println(s2);
            	  if(s1.equals(s2)) {
            		  System.out.println("Actual Raasi value: "+raasi1);
            		  status=true;
            	  }
              }
              if(status==false) {
            	  System.out.println("Raasi " +j+"  value is not matching");
              }
          }
          
      }
      if (motherTongue.equals("Hindi")) {
    	  for (int j = 1; j <= 12; j++) {
              String raasi = Base.getExcelData("Raasi", j, 3);
              System.out.println("Expected Raasi value: "+raasi);
              String s1=raasi.replaceAll("\\s", "");
              System.out.println(s1);
              Thread.sleep(2000);
              List<IOSElement> lst = driver.findElements(By.xpath("//*[@class='UIAStaticText']"));
              boolean status=false;
              for(int i=0;i<=lst.size()-1;i++) {
            	  String raasi1=lst.get(i).getText();
            	  System.out.println(raasi1);
            	  String s2=raasi1.replaceAll("\\s", "");
            	  System.out.println(s2);
            	  if(s1.equals(s2)) {
            		  System.out.println("Actual Raasi value: "+raasi1);
            		  status=true;
            	  }
              }
              if(status==false) {
            	  System.out.println("Raasi " +j+"  value is not matching");
              }
              
          }
      }
      if (motherTongue.equals("Kannada")) {
          for (int j = 1; j <= 12; j++) {
              String raasi = Base.getExcelData("Raasi", j, 4);
              System.out.println("Expected Raasi value: "+raasi);
              String s1=raasi.replaceAll("\\s", "");
              System.out.println(s1);
              Thread.sleep(2000);
              List<IOSElement> lst = driver.findElements(By.xpath("//*[@class='UIAStaticText']"));
              boolean status=false;
              for(int i=0;i<=lst.size()-1;i++) {
            	  String raasi1=lst.get(i).getText();
            	  System.out.println(raasi1);
            	  String s2=raasi1.replaceAll("\\s", "");
            	  System.out.println(s2);
            	  if(s1.equals(s2)) {
            		  System.out.println("Actual Raasi value: "+raasi1);
            		  status=true;
            	  }
              }
              if(status==false) {
            	  System.out.println("Raasi " +j+"  value is not matching");
              }
          }
         
      }
	if (motherTongue.equals("Malayalam")) {
		for (int j = 1; j <= 12; j++) {
            String raasi = Base.getExcelData("Raasi", j, 5);
            System.out.println("Expected Raasi value: "+raasi);
            String s1=raasi.replaceAll("\\s", "");
            System.out.println(s1);
            Thread.sleep(2000);
            List<IOSElement> lst = driver.findElements(By.xpath("//*[@class='UIAStaticText']"));
            boolean status=false;
            for(int i=0;i<=lst.size()-1;i++) {
          	  String raasi1=lst.get(i).getText();
          	  System.out.println(raasi1);
          	  String s2=raasi1.replaceAll("\\s", "");
          	  System.out.println(s2);
          	  if(s1.equals(s2)) {
          		  System.out.println("Actual Raasi value: "+raasi1);
          		  status=true;
          	  }
            }
            if(status==false) {
          	  System.out.println("Raasi " +j+"  value is not matching");
            }
            
        }
    }
	if (motherTongue.equals("Marathi")) {
        for (int j = 1; j <= 12; j++) {
            String raasi = Base.getExcelData("Raasi", j, 6);
            System.out.println("Expected Raasi value: "+raasi);
            String s1=raasi.replaceAll("\\s", "");
            System.out.println(s1);
            Thread.sleep(2000);
            List<IOSElement> lst = driver.findElements(By.xpath("//*[@class='UIAStaticText']"));
            boolean status=false;
            for(int i=0;i<=lst.size()-1;i++) {
          	  String raasi1=lst.get(i).getText();
          	  System.out.println(raasi1);
          	  String s2=raasi1.replaceAll("\\s", "");
          	  System.out.println(s2);
          	  if(s1.equals(s2)) {
          		  System.out.println("Actual Raasi value: "+raasi1);
          		  status=true;
          	  }
            }
            if(status==false) {
          	  System.out.println("Raasi " +j+"  value is not matching");
            }
        }
       
    }
	if (motherTongue.equals("Marwadi")) {
        for (int j = 1; j <= 12; j++) {
            String raasi = Base.getExcelData("Raasi", j, 7);
            System.out.println("Expected Raasi value: "+raasi);
            String s1=raasi.replaceAll("\\s", "");
            System.out.println(s1);
            Thread.sleep(2000);
            List<IOSElement> lst = driver.findElements(By.xpath("//*[@class='UIAStaticText']"));
            boolean status=false;
            for(int i=0;i<=lst.size()-1;i++) {
          	  String raasi1=lst.get(i).getText();
          	  System.out.println(raasi1);
          	  String s2=raasi1.replaceAll("\\s", "");
          	  System.out.println(s2);
          	  if(s1.equals(s2)) {
          		  System.out.println("Actual Raasi value: "+raasi1);
          		  status=true;
          	  }
            }
            if(status==false) {
          	  System.out.println("Raasi " +j+"  value is not matching");
            }
        }
       
    }
	if (motherTongue.equals("Oriya")) {
        for (int j = 1; j <= 12; j++) {
            String raasi = Base.getExcelData("Raasi", j, 8);
            System.out.println("Expected Raasi value: "+raasi);
            String s1=raasi.replaceAll("\\s", "");
            System.out.println(s1);
            Thread.sleep(2000);
            List<IOSElement> lst = driver.findElements(By.xpath("//*[@class='UIAStaticText']"));
            boolean status=false;
            for(int i=0;i<=lst.size()-1;i++) {
          	  String raasi1=lst.get(i).getText();
          	  System.out.println(raasi1);
          	  String s2=raasi1.replaceAll("\\s", "");
          	  System.out.println(s2);
          	  if(s1.equals(s2)) {
          		  System.out.println("Actual Raasi value: "+raasi1);
          		  status=true;
          	  }
            }
            if(status==false) {
          	  System.out.println("Raasi " +j+"  value is not matching");
            }
        }
       
    }
	if (motherTongue.equals("Punjabi")) {
        for (int j = 1; j <= 12; j++) {
            String raasi = Base.getExcelData("Raasi", j, 10);
            System.out.println("Expected Raasi value: "+raasi);
            String s1=raasi.replaceAll("\\s", "");
            System.out.println(s1);
            Thread.sleep(2000);
            List<IOSElement> lst = driver.findElements(By.xpath("//*[@class='UIAStaticText']"));
            boolean status=false;
            for(int i=0;i<=lst.size()-1;i++) {
          	  String raasi1=lst.get(i).getText();
          	  System.out.println(raasi1);
          	  String s2=raasi1.replaceAll("\\s", "");
          	  System.out.println(s2);
          	  if(s1.equals(s2)) {
          		  System.out.println("Actual Raasi value: "+raasi1);
          		  status=true;
          	  }
            }
            if(status==false) {
          	  System.out.println("Raasi " +j+"  value is not matching");
            }
        }
        
    }
	if (motherTongue.equals("Sindhi")) {
        for (int j = 1; j <= 12; j++) {
            String raasi = Base.getExcelData("Raasi", j, 11);
            System.out.println("Expected Raasi value: "+raasi);
            String s1=raasi.replaceAll("\\s", "");
            System.out.println(s1);
            Thread.sleep(2000);
            List<IOSElement> lst = driver.findElements(By.xpath("//*[@class='UIAStaticText']"));
            boolean status=false;
            for(int i=0;i<=lst.size()-1;i++) {
          	  String raasi1=lst.get(i).getText();
          	  System.out.println(raasi1);
          	  String s2=raasi1.replaceAll("\\s", "");
          	  System.out.println(s2);
          	  if(s1.equals(s2)) {
          		  System.out.println("Actual Raasi value: "+raasi1);
          		  status=true;
          	  }
            }
            if(status==false) {
          	  System.out.println("Raasi " +j+"  value is not matching");
            }
        }
        
    }
	if (motherTongue.equals("Tamil")) {
        for (int j = 1; j <= 12; j++) {
            String raasi = Base.getExcelData("Raasi", j, 12);
            System.out.println("Expected Raasi value: "+raasi);
            String s1=raasi.replaceAll("\\s", "");
            System.out.println(s1);
            Thread.sleep(2000);
            List<IOSElement> lst = driver.findElements(By.xpath("//*[@class='UIAStaticText']"));
            boolean status=false;
            for(int i=0;i<=lst.size()-1;i++) {
          	  String raasi1=lst.get(i).getText();
          	  System.out.println(raasi1);
          	  String s2=raasi1.replaceAll("\\s", "");
          	  System.out.println(s2);
          	  if(s1.equals(s2)) {
          		  System.out.println("Actual Raasi value: "+raasi1);
          		  status=true;
          	  }
            }
            if(status==false) {
          	  System.out.println("Raasi " +j+"  value is not matching");
            }
        }
        
    }
	if (motherTongue.equals("Telugu")) {
        for (int j = 1; j <= 12; j++) {
            String raasi = Base.getExcelData("Raasi", j, 13);
            System.out.println("Expected Raasi value: "+raasi);
            String s1=raasi.replaceAll("\\s", "");
            System.out.println(s1);
            Thread.sleep(2000);
            List<IOSElement> lst = driver.findElements(By.xpath("//*[@class='UIAStaticText']"));
            boolean status=false;
            for(int i=0;i<=lst.size()-1;i++) {
          	  String raasi1=lst.get(i).getText();
          	  System.out.println(raasi1);
          	  String s2=raasi1.replaceAll("\\s", "");
          	  System.out.println(s2);
          	  if(s1.equals(s2)) {
          		  System.out.println("Actual Raasi value: "+raasi1);
          		  status=true;
          	  }
            }
            if(status==false) {
          	  System.out.println("Raasi " +j+"  value is not matching");
            }
        }
       
    }
	if (motherTongue.equals("Urdu")) {
        for (int j = 1; j <= 12; j++) {
            String raasi = Base.getExcelData("Raasi", j, 14);
            System.out.println("Expected Raasi value: "+raasi);
            String s1=raasi.replaceAll("\\s", "");
            System.out.println(s1);
            Thread.sleep(2000);
            List<IOSElement> lst = driver.findElements(By.xpath("//*[@class='UIAStaticText']"));
            boolean status=false;
            for(int i=0;i<=lst.size()-1;i++) {
          	  String raasi1=lst.get(i).getText();
          	  System.out.println(raasi1);
          	  String s2=raasi1.replaceAll("\\s", "");
          	  System.out.println(s2);
          	  if(s1.equals(s2)) {
          		  System.out.println("Actual Raasi value: "+raasi1);
          		  status=true;
          	  }
            }
            if(status==false) {
          	  System.out.println("Raasi " +j+"  value is not matching");
            }
        }
       
    }
	}
}