package com.cm.testscripts;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.cm.Utility.BaseTest;
import com.cm.pages.HomePage;
import com.cm.pages.LoginPage2;
import com.cm.pages.MarkAsViewedPage;
import com.cm.pages.WhoShortlistedMePage;

public class ProfilesBlockedTest extends BaseTest{
	public ProfilesBlockedTest() throws Throwable{
		LoginPage2.loadProperties();
		HomePage.loadProperties();
		WhoShortlistedMePage.loadProperties();	
		MarkAsViewedPage.loadProperties();
	}
	@Test
	public void profilesIgnoredTest() throws Throwable{
		test=extent.createTest("Profiles I Have Ignored Test scenorio1");
		LoginPage2.login();
		LoginPage2.intermediate_Popups();
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.moveToElement(HomePage.matchesLink()).perform();
		act.moveToElement(MarkAsViewedPage.yetToBeViewed()).click().perform();
		test.pass("Clicked on Yet to be Viewed");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		    WhoShortlistedMePage.viewProfileChoiceMenuList().get(0).click();
		    Thread.sleep(2000);
		    test.pass("clicked on choice menu to block the profile");
		    MarkAsViewedPage.blockBtnInMatchesList().get(0).click();
		    test.pass("clicked on block Option");
		    Thread.sleep(3000);
		    MarkAsViewedPage.blockYesButtonList().get(0).click();
		    test.pass("clicked on confirmation Yes button.");
		    Thread.sleep(2000);
		    String expId=MarkAsViewedPage.oppId().getText();
		    test.pass("you have blocked this member-"+expId);
		    test.pass("verifying Blocked Id in Blocked Members List");
		    driver.close();
		    driver.switchTo().window(pID1);
		    act.moveToElement(HomePage.myHomeLink()).perform();
			act.moveToElement(WhoShortlistedMePage.profIhaveIgnore()).click().build().perform();
			test.pass("clicked on profiles i have ignored");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(5000);
			MarkAsViewedPage.membersYouHaveBlocked().click();
			test.pass("clicked on Members you have blocked ");
			test.pass("passing the driver control to child window");
			Set<String> set2=driver.getWindowHandles();
		    Iterator<String> it2=set2.iterator();
		    it2.next();
		    String cId2=it2.next();
		    driver.switchTo().window(cId2);
		    test.pass("driver Control is Successfully Passed to child Window");
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			String actId="";
			boolean status=false;
			for(int i=0;i<=10;i++){
				String s=MarkAsViewedPage.idList().get(i).getText();
				if(s.equalsIgnoreCase(expId)){
					actId=s;
					status=true;
					break;
				}
			}
			if(status){
				test.pass("Actual Id: "+actId);
				test.pass("Profile is present in blocked members");
			}
			else{
				test.pass("Profile is not present in blocked members");
			}
			test.pass("Blocked Id is verified successfully");
			test.info("verifying All the links present in Blocked profile................");
			test.info("verifying view similar profiles link......");
			WhoShortlistedMePage.viewSimilarProfiles().click();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    test.pass("clicked on View similar profiles");
		    Set<String> set=driver.getWindowHandles();
		    Iterator<String> it=set.iterator();
		    it.next();
		    String cId=it.next();
		    String cid2=it.next();
		    driver.switchTo().window(cid2);
		    test.pass("driver Control is Successfully Passed to child Window");
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    driver.close();
		    test.pass("Child window closed");
		    test.pass("view similar profiles is successfully verified");
			test.info("passing the Driver control to Previous window");
			driver.switchTo().window(cId);
			test.pass("Driver control passed to Previous window successfully");
			test.info("verifying Opposite id link........");
			MarkAsViewedPage.idList().get(0).click();
			Thread.sleep(2000);
			test.pass("clicked on Oppsite Id");
			Set<String> set4=driver.getWindowHandles();
		    Iterator<String> it4=set4.iterator();
		    it4.next();
		    String cId4=it4.next();
		    String cid4=it4.next();
		    driver.switchTo().window(cid4);
		    test.pass("driver Control is Successfully Passed to child Window");
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    driver.close();
		    test.pass("Child window closed");
		    test.pass("opposite id link is verified successfully");
			test.info("passing the Driver control to Parent window");
			driver.switchTo().window(cId4);
			test.pass("Driver control passed to parent window successfully");
			test.info("verifying Remove from block list..........");
			Thread.sleep(2000);
			MarkAsViewedPage.removeFromBlockList().get(0).click();
			Thread.sleep(1000);
			test.pass("clicked on Remove from block list");
			test.pass("fetching confirmation message..........");
			test.pass(MarkAsViewedPage.remvFrmBlockConfMsg().getText());
			MarkAsViewedPage.remvFrmBlockConfMsgClose().click();
			test.pass("Popup is closed successfully");
			test.pass("Remove from block list is successfully verified"); 
			LoginPage2.logout();
			test.pass("closing the driver.......");
		}else{
			test.pass("sorry...., there is no matches to Block, please Edit Partner Preferences");
		}
		driver.close();
		test.pass("driver closed successfully");

	}
}
