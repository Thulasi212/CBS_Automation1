package com.cm.testscripts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.cm.Utility.BaseTest;
import com.cm.pages.HomePage;
import com.cm.pages.LoginPage2;
import com.cm.pages.WhoShortlistedMePage;

public class ProfilesIHaveIgnoredTest extends BaseTest{
	public ProfilesIHaveIgnoredTest() throws Throwable{
		LoginPage2.loadProperties();
		HomePage.loadProperties();
		WhoShortlistedMePage.loadProperties();	
	}
	@Test
	public void profilesIgnoredTest() throws Throwable{
		test=extent.createTest("Profiles I Have Ignored Test scenorio1");
		LoginPage2.login();
		LoginPage2.intermediate_Popups();
		Thread.sleep(2000);
		HomePage.matchesLink().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test.pass("clicked on Matches link");
		int oppIdlistSize=WhoShortlistedMePage.matchesOppIdList().size();
		if(oppIdlistSize>0){
			HomePage.viewFullProfile().get(0).click();
			test.pass("clicked on View Full Profile");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Set<String> set1=driver.getWindowHandles();
		    Iterator<String> it1=set1.iterator();
		    String pID1= it1.next();
		    String cId1=it1.next();
		    driver.switchTo().window(cId1);
		    test.pass("driver Control is Successfully Passed to child Window");
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    test.pass(WhoShortlistedMePage.viewProfileChoiceMenuList().size()+"");
		    WhoShortlistedMePage.viewProfileChoiceMenuList().get(0).click();
			test.pass("clicked on Choice menu to ignore profile");
			WhoShortlistedMePage.ignoreList().get(0).click();
			test.pass("clicked on Ignore button");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.close();
		    test.pass("Child window closed");
			test.info("passing the Driver control to Parent window");
			driver.switchTo().window(pID1);
			test.pass("Driver control passed to parent window successfully");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		}else{
			test.pass("sorry...., there is no matches to Ignore, please Edit Partner Preferences");
		}
		try{
		Actions act=new Actions(driver);
		act.moveToElement(HomePage.myHomeLink()).perform();
		act.moveToElement(WhoShortlistedMePage.profIhaveIgnore()).click().build().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test.pass("clicked on Profiles i Have Ignored");
		}catch(Exception e){e.getMessage();}
		int oppIdlistSize1=WhoShortlistedMePage.matchesOppIdList().size();
		if(oppIdlistSize1>0){
				Thread.sleep(2000);
				WhoShortlistedMePage.viewSimilarProfiles().click();
			    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			    test.pass("clicked View similar profiles");
			    Set<String> set2=driver.getWindowHandles();
			    Iterator<String> it2=set2.iterator();
			    String pID2= it2.next();
			    String cId2=it2.next();
			    driver.switchTo().window(cId2);
			    test.pass("driver Control is Successfully Passed to child Window");
			    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			    driver.close();
			    test.pass("Child window closed");
				test.info("passing the Driver control to Parent window");
				driver.switchTo().window(pID2);
				test.pass("Driver control passed to parent window successfully");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				try{
				WhoShortlistedMePage.markAsViewed().get(0).click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				}catch(Exception e){e.getMessage();}
				WhoShortlistedMePage.removeFromIgnoreList().get(0).click();
				Thread.sleep(2000);
				test.pass(WhoShortlistedMePage.removeIgnoreListPopMsg().getText());
				WhoShortlistedMePage.removeIgnoreListPopClose().click();
				test.pass("Remove from Ignore list Confirmation popup is closed");
	}else{
		test.pass("sorry...., there is no profiles in 'Who i have Ignored'" );
	}
    LoginPage2.logout();
	driver.close();
	}

}
