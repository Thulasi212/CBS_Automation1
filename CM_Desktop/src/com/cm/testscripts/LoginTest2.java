package com.cm.testscripts;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cm.Utility.BaseTest;
import com.cm.Utility.ExcelData;
import com.cm.Utility.WebdriverWaitLib;
import com.cm.pages.LoginPage2;

public class LoginTest2 extends BaseTest {
	public LoginTest2() throws Throwable{
		LoginPage2.loadProperties();
	}
	@Test
	public void loginTest1() throws Throwable{
		test=extent.createTest("Login Positive Scenorio2");
		test.info("Browser Launching...............");
		ExcelData eData=new ExcelData();
    	int rowNum=eData.getExcelRandomRowNum("LoginTestData");
    	String baseUrl=eData.getExcelData("LoginTestData",rowNum,0);
    	String userName=eData.getExcelData("LoginTestData",rowNum,1);
    	String password=eData.getExcelData("LoginTestData",rowNum,2);
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
		LoginPage2.logout();
		test.pass("closing the Browser.....");
		driver.close();
		test.pass("Browser closed successfully");
	}
	@Test
	public void loginTest2() throws Throwable{
		test=extent.createTest("Login Negative Scenorio1");
		test.info("Browser Launching...............");
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData(".//Resources//LoginTestData.xlsx","LoginTest2",0,0);
    	String userName=eData.getExcelData(".//Resources//LoginTestData.xlsx","LoginTest2",0,1);
    	String password=eData.getExcelData(".//Resources//LoginTestData.xlsx","LoginTest2",0,2);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        WebdriverWaitLib.waitPageToLoad();
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	test.info("Entering Valid User name.............");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	test.pass("User Name: "+userName+" is Entered");
    	test.info("Entering Invalid password.............");
    	LoginPage2.passwordEdit1().sendKeys(password);
    	test.pass("password: ***** is Entered");
    	LoginPage2.loginButton1().click();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	test.pass("Clicked on LoginButton");
		test.pass("validating Error Message");
		String expMsg=eData.getExcelData(".//Resources//LoginTestData.xlsx","LoginTest2",0,3);
		String actMsg=LoginPage2.errMsg().get(1).getText();
		test.pass("Error message: "+actMsg);
		boolean status=false;
		if(actMsg.contains(expMsg))status=true;
		Assert.assertTrue(status);
		test.pass("Error Message is verified successfully");
		test.pass("closing the Browser.....");
		driver.close();
		test.pass("Browser closed successfully");
	}
	@Test
	public void loginTest3() throws Throwable{
		test=extent.createTest("Login Negative Scenorio2");
		test.info("Browser Launching...............");
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData(".//Resources//LoginTestData.xlsx","LoginTest2",1,0);
    	String userName=eData.getExcelData(".//Resources//LoginTestData.xlsx","LoginTest2",1,1);
    	String password=eData.getExcelData(".//Resources//LoginTestData.xlsx","LoginTest2",1,2);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        WebdriverWaitLib.waitPageToLoad();
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	test.info("Entering InValid User name.............");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	test.pass("User Name: "+userName+" is Entered");
    	test.info("Entering valid password.............");
    	LoginPage2.passwordEdit1().sendKeys(password);
    	test.pass("password: ****** is Entered");
    	LoginPage2.loginButton1().click();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	test.pass("Clicked on LoginButton");
		test.pass("validating Error Message");
		String expMsg=eData.getExcelData(".//Resources//LoginTestData.xlsx","LoginTest2",1,3);
		String actMsg=LoginPage2.errMsg().get(1).getText();
		test.pass("Error message: "+actMsg);
		boolean status=false;
		if(actMsg.contains(expMsg))status=true;
		Assert.assertTrue(status);
		test.pass("Error Message is verified successfully");
		test.pass("closing the Browser.....");
		driver.close();
		test.pass("Browser closed successfully");
	} 
	@Test
	public void loginTest4() throws Throwable{
		test=extent.createTest("Login Negative Scenorio3");
		test.info("Browser Launching...............");
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData(".//Resources//LoginTestData.xlsx","LoginTest2",2,0);
    	String userName=eData.getExcelData(".//Resources//LoginTestData.xlsx","LoginTest2",2,1);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        WebdriverWaitLib.waitPageToLoad();
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	test.info("Entering InValid User name.............");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	test.pass("User Name: "+userName+" is Entered");
    	test.info("leaving password as Blank........");
    	LoginPage2.loginButton1().click();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	test.pass("Clicked on LoginButton");
		test.pass("validating Error Message");
		String expMsg=eData.getExcelData(".//Resources//LoginTestData.xlsx","LoginTest2",1,3);
		String actMsg=LoginPage2.errMsg().get(1).getText();
		test.pass("Error message: "+actMsg);
		boolean status=false;
		if(actMsg.contains(expMsg))status=true;
		Assert.assertTrue(status);
		test.pass("Error Message is verified successfully");
		test.pass("closing the Browser.....");
		driver.close();
		test.pass("Browser closed successfully");
	} 
	@Test
	public void loginTest5() throws Throwable{
		test=extent.createTest("Login Negative Scenorio4");
		test.info("Browser Launching...............");
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData(".//Resources//LoginTestData.xlsx","LoginTest2",3,0);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        WebdriverWaitLib.waitPageToLoad();
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	test.info("Leaving username as Blank.............");
    	test.info("leaving password as Blank........");
    	LoginPage2.loginButton1().click();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	test.pass("Clicked on LoginButton");
		test.pass("validating Error Message");
		String expMsg=eData.getExcelData(".//Resources//LoginTestData.xlsx","LoginTest2",3,3);
		String actMsg=LoginPage2.errMsg().get(1).getText();
		test.pass("Error message: "+actMsg);
		boolean status=false;
		if(actMsg.contains(expMsg))status=true;
		Assert.assertTrue(status);
		test.pass("Error Message is verified successfully");
		test.pass("closing the Browser.....");
		driver.close();
		test.pass("Browser closed successfully");
	}
	@Test
	public void loginTest6() throws Throwable{
		test=extent.createTest("Login Negative Scenorio5");
		test.info("Browser Launching...............");
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData(".//Resources//LoginTestData.xlsx","LoginTest2",4,0);
    	String userName=eData.getExcelData(".//Resources//LoginTestData.xlsx","LoginTest2",4,1);
    	String password=eData.getExcelData(".//Resources//LoginTestData.xlsx","LoginTest2",4,2);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        WebdriverWaitLib.waitPageToLoad();
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application with Email Id................");
    	test.info("Entering Valid User name.............");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	test.pass("User Name: "+userName+" is Entered");
    	test.info("Entering Invalid password.............");
    	LoginPage2.passwordEdit1().sendKeys(password);
    	test.pass("password: ****** is Entered");
    	LoginPage2.loginButton1().click();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	test.pass("Clicked on LoginButton");
		test.pass("validating Error Message");
		String expMsg=eData.getExcelData(".//Resources//LoginTestData.xlsx","LoginTest2",4,3);
		String actMsg=LoginPage2.errMsg().get(1).getText();
		test.pass("Error message: "+actMsg);
		boolean status=false;
		if(actMsg.contains(expMsg))status=true;
		Assert.assertTrue(status);
		test.pass("Error Message is verified successfully");
		test.pass("closing the Browser.....");
		driver.close();
		test.pass("Browser closed successfully");
	} 
	

}
