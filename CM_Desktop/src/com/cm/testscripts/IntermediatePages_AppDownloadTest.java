package com.cm.testscripts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.cm.Utility.BaseTest;
import com.cm.Utility.ExcelData;
import com.cm.Utility.WebdriverWaitLib;
import com.cm.pages.LoginPage2;

public class IntermediatePages_AppDownloadTest extends BaseTest {
	public IntermediatePages_AppDownloadTest() throws Throwable{
		LoginPage2.loadProperties();
	}
	//*** Checking App Download link and Other links in intermediate Page******
	@Test
	public void intermediatePage_appDownloadTest() throws Throwable{
		test=extent.createTest("App Download Test In Intermediate Page");
		test.info("Browser Launching...............");
		//Fetching the data from excel
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("LoginTestData",8,0);
    	String userName=eData.getExcelData("LoginTestData",8,1);
    	String password=eData.getExcelData("LoginTestData",8,2);
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean status=false;
		int i;
		for(i=1;i<=15;i++){
			try{
				LoginPage2.skipToDailymatches_AppStoreLink().click();
				test.pass("Clicked on App store link");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				status=true;
				break;
			}catch(Exception e){e.getMessage();}
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}
		System.out.println(i);
		if(status){
			test.info("Passing the driver control to child window");
			Set<String> set=driver.getWindowHandles();
			Iterator<String> it=set.iterator();
			String pId=it.next();
			String cId=it.next();
			driver.switchTo().window(cId);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			test.pass("Driver control is successfully passed to Child Window");
			test.info("Closing child window");
			driver.close();
			test.pass("child window closed successfully");
			test.info("Passing driver control to parent window");
			driver.switchTo().window(pId);
			LoginPage2.skipToDailyMatches_GooglePlayLink().click();
			test.pass("Clicked on Google Play link");
			test.info("Passing the driver control to child window");
			Set<String> set1=driver.getWindowHandles();
			Iterator<String> it1=set1.iterator();
			String pId1=it1.next();
			String cId1=it1.next();
			driver.switchTo().window(cId1);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.pass("Driver control is successfully passed to Child Window");
			test.pass("Fetching the Content in Google play.......");
			String s=LoginPage2.skipToDailyMatches_GooglePlayLinkHeaderText().getText();
			test.pass(s);
			test.info("Closing child window");
			driver.close();
			test.pass("child window closed successfully");
			test.info("Passing driver control to parent window");
			driver.switchTo().window(pId1);
			Thread.sleep(2000);
			try{
				String mobCode=LoginPage2.skipToDailyMatches_mobCode().getText();
				test.pass(mobCode);
				test.pass(LoginPage2.skipToDailyMatches_mobNo().getText());
				LoginPage2.skipToDailyMatches_getLink().click();
				test.pass("1st time :Clicked on Get link ");
				Thread.sleep(3000);
				test.pass(LoginPage2.skipToDailyMatches_getLinkPOpMsg().getText());
				LoginPage2.skipToDailyMatches_getLinkPopClose().click();
				test.pass("Get link Message Popup closed successfully");
				Thread.sleep(1000);
				LoginPage2.skipToDailyMatches_getLink().click();
				test.pass("2nd time :Clicked on Get link ");
				Thread.sleep(3000);
				test.pass(LoginPage2.skipToDailyMatches_getLinkPOpMsg().getText());
				LoginPage2.skipToDailyMatches_getLinkPopClose().click();
				test.pass("Get link Message Popup closed successfully");
				Thread.sleep(1000);
				LoginPage2.skipToDailyMatches_getLink().click();
				test.pass("3rd time :Clicked on Get link ");
				Thread.sleep(3000);
				test.pass(LoginPage2.skipToDailyMatches_getLinkPOpMsg().getText());
				LoginPage2.skipToDailyMatches_getLinkPopClose().click();
				test.pass("Get link Message Popup closed successfully");
			}catch(Exception e){e.getMessage();}
				
		}
	}

}
