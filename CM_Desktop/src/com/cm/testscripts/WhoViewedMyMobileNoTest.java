package com.cm.testscripts;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.cm.Utility.BaseTest;
import com.cm.pages.HomePage;
import com.cm.pages.LoginPage2;
import com.cm.pages.ProfViewedNotContactPage;
import com.cm.pages.WhoShortlistedMePage;

public class WhoViewedMyMobileNoTest extends BaseTest{
	public WhoViewedMyMobileNoTest() throws Throwable{
		HomePage.loadProperties();
		WhoShortlistedMePage.loadProperties();
		ProfViewedNotContactPage.loadProperties();
		LoginPage2.loadProperties();
	}
	@Test
	public  void viewedMyMobNoTest() throws Throwable{
		test=extent.createTest("Who viewed my Mobile NumberTest ");
		LoginPage2.login();
		LoginPage2.intermediate_Popups();
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.moveToElement(HomePage.myHomeLink()).perform();
		act.moveToElement(WhoShortlistedMePage.whoViewedMyMobNo()).click().perform();
		test.pass("clicked on Who viewed my mobile number");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(WhoShortlistedMePage.oppMemIdList().size()>0){
			ProfViewedNotContactPage.mobileButton().click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			test.pass("clicked on Mobile Button");
			try{
			ProfViewedNotContactPage.viewMobNo().click();
			Thread.sleep(3000);
			test.pass("clicked on View Mobile Number");
			test.pass("Fetching the mobile Number viewed by me.......");
			String no=ProfViewedNotContactPage.mobNo().getText();
			test.pass("Mobile number is "+no);
			test.pass("Fetching mobile number verified date..........");
			String s=ProfViewedNotContactPage.mobNoViewDate().getText();
			test.pass("Mobile Number verified date :"+s);
			test.pass("closing Mobile number viewed popup..........");
			ProfViewedNotContactPage.mobNoPopupClose().click();
			test.pass("popup closed successfully");
			}catch(Exception e){e.getMessage();}
			Thread.sleep(2000);
			try{
				ProfViewedNotContactPage.mobNoPopupClose().click();
			}catch(Exception e){e.getMessage();}
			try{
				Set<String> set1=driver.getWindowHandles();
			    Iterator<String> it1=set1.iterator();
			    String pID1= it1.next();
			    String cId1=it1.next();
			    driver.switchTo().window(cId1);
			    test.pass("driver Control is Successfully Passed to child Window");
			    driver.close();
			    test.pass("Child window closed");
				test.info("passing the Driver control to Parent window");
				driver.switchTo().window(pID1);
				test.pass("Driver control passed to parent window successfully");
			}catch(Exception e){e.getMessage();}
			Thread.sleep(2000);
			ProfViewedNotContactPage.sendMail().click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			test.pass("clicked send mail");
			try{
			ProfViewedNotContactPage.messgTextbox().sendKeys("Hi how r u");
			test.pass("typing the message: Hi How are you");
			test.pass("closing popup..........");
			ProfViewedNotContactPage.sendmailpopupClose().click();
			Thread.sleep(2000);
			test.pass("popup closed successfully");
			}catch(Exception e){e.getMessage();}
			Thread.sleep(2000);
			try{
				Set<String> set1=driver.getWindowHandles();
			    Iterator<String> it1=set1.iterator();
			    String pID1= it1.next();
			    String cId1=it1.next();
			    driver.switchTo().window(cId1);
			    test.pass("driver Control is Successfully Passed to child Window");
			    driver.close();
			    test.pass("Child window closed");
				test.info("passing the Driver control to Parent window");
				driver.switchTo().window(pID1);
				test.pass("Driver control passed to parent window successfully");
			}catch(Exception e){e.getMessage();}
			ProfViewedNotContactPage.viewFullprofile().click();
			test.pass("clicked on view full profile");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			test.info("Passing the Driver control to child Window");
			Set<String> set1=driver.getWindowHandles();
		    Iterator<String> it1=set1.iterator();
		    String pID1= it1.next();
		    String cId1=it1.next();
		    driver.switchTo().window(cId1);
		    test.pass("driver Control is Successfully Passed to child Window");
		    driver.close();
		    test.pass("Child window closed");
			test.info("passing the Driver control to Parent window");
			driver.switchTo().window(pID1);
			test.pass("Driver control passed to parent window successfully");
		}else{
			test.pass("sorry...No One has viewed your Mobile Number");
		}
		Thread.sleep(2000);
		LoginPage2.logout();
		driver.quit();
		
	}

}
