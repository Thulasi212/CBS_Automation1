package com.cm.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.cm.Utility.BaseTest;
import com.cm.Utility.ExcelData;
import com.cm.pages.HomePage;
import com.cm.pages.LoginPage2;

public class ListingPageTest extends BaseTest {
	ExcelData data;
	public ListingPageTest() throws Throwable{
		LoginPage2.loadProperties();
		HomePage.loadProperties();
		data=new ExcelData();
	}
	@Test
	public void yetToBEViewedTest() throws Throwable{
		test=extent.createTest("Yet Viewed Test");
		String url=data.getExcelData("EditPPData", 1, 0);
		String userName=data.getExcelData("EditPPData", 1, 1);
		String password=data.getExcelData("EditPPData", 1, 2);
		test.pass(url);
		LoginPage2.login(url, userName, password);
		LoginPage2.intermediate_Popups();
		test.pass("Intermediate pages are closed");
		test.pass("Verifying Send Mail Option.........");
		Actions act=new Actions(driver);
		act.moveToElement(HomePage.matchesLink()).perform();
		act.moveToElement(HomePage.yetToBeViewed()).click().perform();
		test.pass("Clicked on Yet to be Viewed");
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		HomePage.sendMailToAllCheckbox().click();
		test.pass("clicked on Send Mail/Interest to All checkbox");
		HomePage.sendMailToAllBtn().click();
		test.pass("Sending a Mail/Interest.........");
		Thread.sleep(3000);
		test.info("Fetching confirmation Message........");
		boolean status=true;
		try{
			HomePage.sendBtnInPop().click();
			status=false;
			Thread.sleep(3000);
			test.pass(HomePage.mailconfMsg().getText());
			HomePage.mailconfPopClose().click();
			test.pass("Send Mail Option Verified successfully");
		}catch(Exception e){e.getMessage();}
		if(status){
			test.pass(HomePage.interestConfMsg().getText());
			HomePage.interestConfPopClose().click();
			test.pass("Send Interest Option Verified successfully");
		}
		
		
	}
    
}
