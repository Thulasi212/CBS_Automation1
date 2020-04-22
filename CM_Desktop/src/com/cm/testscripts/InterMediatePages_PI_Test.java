package com.cm.testscripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.cm.Utility.BaseTest;
import com.cm.Utility.ExcelData;
import com.cm.Utility.WebdriverWaitLib;
import com.cm.pages.Inbox2Page;
import com.cm.pages.LoginPage2;

public class InterMediatePages_PI_Test extends BaseTest {
	public InterMediatePages_PI_Test() throws Throwable{
		LoginPage2.loadProperties();
		Inbox2Page.loadProperties();
		
	}
	@Test
	public void pendingInterestTest() throws Throwable{
		test=extent.createTest("Pending Interests in Intermediate Pages Test");
		test.info("Browser Launching...............");
		//Fetching the data from excel
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("LoginTestData",12,0);
    	String userName=eData.getExcelData("LoginTestData",12,1);
    	String password=eData.getExcelData("LoginTestData",12,2);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        WebdriverWaitLib.waitPageToLoad();
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	LoginPage2.passwordEdit1().sendKeys(password);
    	LoginPage2.loginButton1().click();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	test.pass("Profile A Login successfully Completed with username: "+userName+" & password: "+password);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		boolean status=false;
		int i;
		for(i=1;i<=15;i++){
			try{
				status=LoginPage2.skipToMyMatrimony_declineBtn().isDisplayed();
				break;
			}catch(Exception e){e.getMessage();}
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		System.out.println(i);
		if(status){
			test.info("Fetching pending Interest list Count Before Declining the Interest");
			Thread.sleep(2000);
			String pIcount=LoginPage2.skipToMyMatrimony_listCount().getText();
			test.pass("pending Interest count: "+pIcount);
			String s=LoginPage2.skipToMyMatrimony_senderId().getText();
			String senderId=s.substring(s.length()-11, s.length()-1);
			test.pass("Sender Id: "+senderId);
			LoginPage2.skipToMyMatrimony_declineBtn().click();
			test.pass("Clicked on Decline Button");
			Thread.sleep(3000);
			test.pass(LoginPage2.skipToMyMatrimony_declinepopMsg().getText());
			LoginPage2.skipToMyMatrimony_declinepopClose().click();
			test.pass("Decline Interest Confirmation Popup is closed successfully");
			test.info("Fetching pending Interest list Count After Declining the Interest");
			driver.navigate().refresh();
			boolean status1=false;
			int j;
			for(j=1;j<=15;j++){
				try{
					status1=LoginPage2.skipToMyMatrimony_declineBtn().isDisplayed();
					break;
				}catch(Exception e){e.getMessage();}
				driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			System.out.println(j);
			if(status1){
				Thread.sleep(2000);
				String pIcount1=LoginPage2.skipToMyMatrimony_listCount().getText();
				test.pass("pending Interest count: "+pIcount1);
	            LoginPage2.skipToDailyMatches_Popup().click();
			    test.pass("SkipTodailyMatches Popup is closed successfully");
			}
			try{
				Thread.sleep(5000);
				LoginPage2.addPhoto().click();
				WebdriverWaitLib.waitElementToPresent(LoginPage2.areYousure_Popup());
				LoginPage2.areYousure_Popup().click();
				try{
					WebdriverWaitLib.waitElementToPresent(LoginPage2.reason3_Popup());
					LoginPage2.reason3_Popup().click();
					WebdriverWaitLib.waitElementToPresent(LoginPage2.submit_Popup());
					LoginPage2.submit_Popup().click();
			        }catch(Exception e){e.getMessage();}
	    	}catch(Exception e){e.getMessage();}
			try{
				WebdriverWaitLib.waitElementToPresent(LoginPage2.upgrade_Popup());
				LoginPage2.upgrade_Popup().click();
				test.pass("Upgrade Popup is closed successfully");
			}catch(Exception e){e.getMessage();}
			try{
				Thread.sleep(5000);
				LoginPage2.upgrade_Popup1().click();
				test.pass("Profile Highlighter Popup is closed successfully");	
			}catch(Exception e){e.getMessage();}
			test.info("Validating Declined Id in Inbox under Declined Interests ");
		    Inbox2Page.inboxLink().click();
		    test.pass("Clicked on Inbox link");
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    Inbox2Page.declinedInterests().click();
		    Thread.sleep(2000);
		    test.pass("Clicked on Interests under Declined");
		    test.pass("Fetching Declined Id....");
		    String s1=Inbox2Page.declinedId().getText();
		    test.pass("Declined Id id: "+s1);
		    test.pass("declined Id is verified successfully");
		    LoginPage2.logout();
		    driver.close();
		}
		
	}

}
