package com.cm.testscripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.cm.Utility.BaseTest;
import com.cm.Utility.ExcelData;
import com.cm.Utility.WebdriverWaitLib;
import com.cm.pages.Inbox2Page;
import com.cm.pages.LoginPage2;
import com.cm.pages.RandomPage;

public class RandomScenorioTest extends BaseTest{
	public RandomScenorioTest() throws Throwable{
		LoginPage2.loadProperties();
		Inbox2Page.loadProperties();	
	}
	@Test
	public void randomTest1() throws Throwable{
		test=extent.createTest("Random Scenorio1");
		test.info("Browser Launching...............");
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("RandomTestData",0,0);
    	System.out.println(baseUrl);
    	String userName=eData.getExcelData("RandomTestData",0,1);
    	String password=eData.getExcelData("RandomTestData",0,2);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        WebdriverWaitLib.waitPageToLoad();
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	LoginPage2.loginButton1().click();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	test.pass("clicked on Login Button1");
    	LoginPage2.userNameEdit2().sendKeys(userName);
    	LoginPage2.passwordEdit2().sendKeys(password);
    	LoginPage2.loginButton2().click();
    	test.pass("Login successfully Completed with username: "+userName+" & password: "+password);
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	LoginPage2.intermediate_Popups();
    	Thread.sleep(1000);
    	RandomPage.dailyMatchesTest();
    	
    	
    	
    	
		
	}

}
