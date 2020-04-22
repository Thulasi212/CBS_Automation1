package com.cm.testscripts;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.cm.Utility.BaseTest;
import com.cm.Utility.ExcelData;
import com.cm.Utility.WebdriverWaitLib;
import com.cm.pages.HomePage;
import com.cm.pages.LoginPage2;
import com.cm.pages.ProfViewedNotContactPage;

public class MobileNoViewedByMe extends BaseTest {
	public static Properties properties;
	public MobileNoViewedByMe() throws Throwable{
		HomePage.loadProperties();
		LoginPage2.loadProperties();
		ProfViewedNotContactPage.loadProperties();
	}
	@Test
	public void mobileNoViewTest() throws Throwable{
		test=extent.createTest("Mobile Numbers Viewed By Me");
		//LoginPage2.login();
		test.info("Browser Launching...............");
		//Fetching the data from excel
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("LoginTestData",11,0);
    	String userName=eData.getExcelData("LoginTestData",11,1);
    	String password=eData.getExcelData("LoginTestData",11,2);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        WebdriverWaitLib.waitPageToLoad();
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	LoginPage2.passwordEdit1().sendKeys(password);
    	LoginPage2.loginButton1().click();
    	test.pass("Login successfully Completed with username: "+userName+" & password: "+password);
		LoginPage2.intermediate_Popups();
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.moveToElement(HomePage.myHomeLink()).perform();
		act.moveToElement(ProfViewedNotContactPage.mobNoViewedByMe()).click().perform();
		test.pass("clicked on My Home link");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ProfViewedNotContactPage.mobileButton().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test.pass("clicked on Mobile Button");
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
		Thread.sleep(2000);
		ProfViewedNotContactPage.sendMail().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test.pass("clicked send mail");
		test.pass("typing the message Hi how r u");
		ProfViewedNotContactPage.messgTextbox().sendKeys("Hi how r u");
		test.pass("closing popup..........");
		ProfViewedNotContactPage.sendmailpopupClose().click();
		Thread.sleep(2000);
		test.pass("popup closed successfully");
		ProfViewedNotContactPage.viewFullprofile().click();
		test.pass("clicked on view full profile");
		/*test.info("Passing the Driver control to child Window");
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
		test.pass("Driver control passed to parent window successfully");*/
		driver.quit();
		test.pass("Mobile number viewed by me is successfully completed");
	}

	

}
