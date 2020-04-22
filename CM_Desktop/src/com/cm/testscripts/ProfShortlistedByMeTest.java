package com.cm.testscripts;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.cm.Utility.BaseTest;
import com.cm.pages.HomePage;
import com.cm.pages.LoginPage2;
import com.cm.pages.ProfViewedNotContactPage;

public class ProfShortlistedByMeTest extends BaseTest{
	public static Properties properties;
	public ProfShortlistedByMeTest() throws Throwable{
		HomePage.loadProperties();
		ProfViewedNotContactPage.loadProperties();
	}
	@Test
	public static void ShortlistedByMeTest() throws Throwable{
		test=extent.createTest(" Profiles shortlisted by me Test");
		LoginPage2.login();
		LoginPage2.intermediate_Popups();
		HomePage.matchesLink().click();
		test.pass("clicked on matches link");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test.pass("shortlisted ids size: "+ProfViewedNotContactPage.shortlistedIdList().size());
		ProfViewedNotContactPage.shortlistIconList().get(0).click();
		test.pass("clicked on Shortlisted icon");
		Thread.sleep(2000);
		String id="";
		for(int i=ProfViewedNotContactPage.shortlistedIdList().size()-1;i>=0;){
			id=ProfViewedNotContactPage.shortlistedIdList().get(i).getText();	
			test.pass(id+"has been shortlisted");
			break;
		}
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.moveToElement(HomePage.myHomeLink()).perform();
		act.moveToElement(ProfViewedNotContactPage.profShortByMe()).click().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test.pass("clicked on Profiles shortlisted by me");
		boolean status=false;
		test.pass("validating shortlisted id with profiles present in shortlisted me ");
		for(int i=0;i<=ProfViewedNotContactPage.oppsiteIdList().size()-1;i++){
			String actId=ProfViewedNotContactPage.oppsiteIdList().get(i).getText();
			if(id.contains(actId)){
				status=true;
			}
		}
		test.pass("All profiles are validated successfully");
		if(status){
			test.pass("Shortlisted id is present in ProfilesShortlisted By Me");
		}
		else{
			test.pass("Shortlisted id is not present in ProfilesShortlisted By Me");
		}	
		driver.close();
		
	}
	
	

}
