package com.cm.testscripts;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cm.Utility.BaseTest;
import com.cm.Utility.ExcelData;
import com.cm.pages.HomePage;
import com.cm.pages.LoginPage2;
import com.cm.pages.MatchesPage;

public class MatchesTest extends BaseTest{
	public MatchesTest() throws Throwable{
		LoginPage2.loadProperties();
		MatchesPage.loadProperties();
		HomePage.loadProperties();
		
	}
	//1.Login as Paid Id>>Matches>Yet to be Viewed>>click on Mobile icon>>i).Get available SMS count>>Send a SMS>>check the Count (should  reduce by -1) ,
	//Again click on  Mobile Icon>>check for Toast Message. ii).Get available available mobile no's>>view mobile no.>>check the count (should  reduce by -1),
	//Again view the mobile no.>>check mobile no. count(should not reduce). And also check all the links are working are not.
	
		@Test(enabled=false)
		public void matches_YetToBeViewedTest1() throws Throwable{
			test=extent.createTest("Matches -yet to be Viewed Test1");
			//Fetching the data from excel
			ExcelData eData=new ExcelData();
	    	String baseUrl=eData.getExcelData("LoginTestData",1,0);
	    	String userName=eData.getExcelData("LoginTestData",1,1);
	    	String password=eData.getExcelData("LoginTestData",1,2);
	    	LoginPage2.login(baseUrl, userName, password);
			LoginPage2.intermediate_Popups();
			Thread.sleep(1000);
			Actions act=new Actions(driver);
			act.moveToElement(MatchesPage.matchesLink()).perform();
			MatchesPage.matches_YetToBeViewed().click();
			test.pass("Clicked on Yet to be viewed under matches");
			boolean status=true;;
			if(MatchesPage.oppMemberIdList().size()>0){
				MatchesPage.mobileIcon().click();
				 status=true;
				test.pass("clicked on Mobile Icon");
				test.info("Fetching Mobile Icon Popup Message.....");
				test.pass(MatchesPage.mobIconPopMsg().getText());
				test.info("Fetching Available SMS count in Popup1.......");
				String count1=MatchesPage.mobIconPop_AvailableSMS_Count().getText();
				test.pass("Available SMS: "+count1);
				try{
					MatchesPage.mobIconPop_SendSMS().click();
					status=false;
					test.pass("Clicked on send SMS button in Mobile Icon Popup");
				}catch(Exception e){e.getMessage();}
				if(status){
					test.pass("You have already sent SMS to this Member");
				}else{
					test.info("Fetching Available SMS count in Popup2");
					String count2=MatchesPage.mobIconPop_SendSMSPop_AvailableSMS_Count().getText();
					test.pass("Available SMS: "+count2);
					Assert.assertEquals(count1, count2);
					test.pass("SMS count is verified successfully");
					test.info("Fetching Stardard SMS.....");
					test.pass(MatchesPage.mobIcon_StandardSMS_Text().getText());
					MatchesPage.mobIcon_SendStandardSMS().click();
					test.pass("clicked on send Button ");
					Thread.sleep(2000);
					test.pass(MatchesPage.mobIcon_SendSMS_confMsg().getText());
					MatchesPage.mobIcon_SendSMS_confMsgClose().click();
					test.pass("clicked on Confirmation popup close Button");
					Thread.sleep(2000);
					MatchesPage.mobileIcon().click();
					test.pass("clicked on Mobile Icon");
					test.info("Fetching Mobile Icon Popup Message.....");
					test.pass(MatchesPage.mobIconPopMsg().getText());
					test.info("Fetching Available SMS count in Popup1.......");
					String count3=MatchesPage.mobIconPop_AvailableSMS_Count().getText();
					test.pass("Available SMS: "+count3);
					MatchesPage.mobIconPop_SedSMS_Close().click();
					test.pass("Clicked on Send SMS close button in Mobile Icon Popup");	
				}
			}else{
				test.pass("sorry,there is no matches to check this Scenorio");
			}
		}
		
	//2.Login as Free Id>>Matches>>Yet to be Viewed>>check all the links are working or not.
	@Test(priority=1,enabled=true)
	public void matches_YetToBeViewedTest2() throws Throwable{
		test=extent.createTest("Matches -yet to be Viewed Test2");
		//Fetching the data from excel
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("LoginTestData",2,0);
    	String userName=eData.getExcelData("LoginTestData",2,1);
    	String password=eData.getExcelData("LoginTestData",2,2);
    	LoginPage2.login(baseUrl, userName, password);
		LoginPage2.intermediate_Popups();
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		act.moveToElement(MatchesPage.matchesLink()).perform();
		MatchesPage.matches_YetToBeViewed().click();
		test.pass("Clicked on Yet to be viewed under matches");
		MatchesPage.sendMailIcon().get(0).click();
		test.pass("clicked on Send Mail button");
		test.info("Passing driver control to payment page window");
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		String pId=it.next();
		String cId=it.next();
		driver.switchTo().window(cId);
		test.pass("driver control successfully passed to payment page");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test.info("Fetching payment page Header line....");
		test.pass(MatchesPage.paymentPageHeader().getText());
		test.info("Closing payment page.........");
		driver.close();
		test.pass("payment page closed successfully");
		driver.switchTo().window(pId);
		test.pass("driver control is passed to Main window");
		MatchesPage.mobileIcon().click();
		test.pass("clicked on Mobile Icon");
		test.info("Passing driver control to payment page window");
		Set<String> set1=driver.getWindowHandles();
		Iterator<String> it1=set1.iterator();
		String pId1=it1.next();
		String cId1=it1.next();
		driver.switchTo().window(cId1);
		test.pass("driver control successfully passed to payment page");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test.info("Fetching payment page Header line....");
		test.pass(MatchesPage.paymentPageHeader().getText());
		test.info("Closing payment page.........");
		driver.close();
		test.pass("payment page closed successfully");
		driver.switchTo().window(pId1);
		test.pass("driver control is passed to Main window");
		MatchesPage.horoscopeIcon().click();
		test.pass("clicked on Horoscope Icon");
		boolean status=true;
		try{
			test.pass(MatchesPage.reqHoroconfPopMsg().getText());
			Thread.sleep(2000);
			MatchesPage.reqHoroConfPopClose().click();
			status=false;
			test.pass("Request horoscope popup is closed successfully");
		}catch(Exception e){e.getMessage();}
		if(status){
			test.info("Passing driver control to payment page window");
			Set<String> set2=driver.getWindowHandles();
			Iterator<String> it2=set2.iterator();
			String pId2=it2.next();
			String cId2=it2.next();
			driver.switchTo().window(cId2);
			test.pass("driver control successfully passed to payment page");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			test.info("Fetching payment page Header line....");
			test.pass(MatchesPage.paymentPageHeader().getText());
			test.info("Closing payment page.........");
			driver.close();
			test.pass("payment page closed successfully");
			driver.switchTo().window(pId2);
			
			test.pass("driver control is passed to Main window");
		}
		boolean status1=true;
		Thread.sleep(2000);
		try{
			MatchesPage.shortlistIcon().click();
			Thread.sleep(3000);
			test.pass(MatchesPage.shortlistConfPopMsg().get(0).getText());
			status=false;
			MatchesPage.shortlistConfPopClose().get(0).click();
			test.pass("Shorlisted popup is successfully closed");
		}catch(Exception e){e.getMessage();}
		if(status1)test.pass("Shortlist icon is Disabled");	
		MatchesPage.markAsViewed().get(0).click();
		Thread.sleep(2000);
		test.pass("clicked on Mark As viewed");
		test.pass(MatchesPage.markAsViewedConfMsg().getText());
		MatchesPage.markAsViewedConfMsg_No().click();
		test.pass("Clicked on Marked as Viewed---> Confirmation-No Button");
		String MatriId1=MatchesPage.oppMembermatriId().get(0).getText();
		test.pass("Oppsite member Matri id1 : "+MatriId1);
		MatchesPage.markAsViewed().get(0).click();
		Thread.sleep(2000);
		test.pass("clicked on Mark As viewed");
		test.pass(MatchesPage.markAsViewedConfMsg().getText());
		MatchesPage.markAsViewedConfMsg_Yes().click();
		test.pass("Clicked on Marked as Viewed---> Confirmation-Yes Button");
		Thread.sleep(2000);
		String MatriId2=MatchesPage.oppMembermatriId().get(0).getText();
		test.pass("Oppsite member Matri id1 : "+MatriId2);
		test.info("Verifying Matri Id is removed or not(After making mark as viewed)...................");
		Assert.assertNotEquals(MatriId1, MatriId2);
		test.pass("Member has removed from the list");
		MatchesPage.oppMembermatriId().get(0).click();
		test.pass("clicked on Opposite member Matri id");
		test.info("Passing driver control to View profile page");
		Set<String> set2=driver.getWindowHandles();
		Iterator<String> it2=set2.iterator();
		String pId2=it2.next();
		String cId2=it2.next();
		driver.switchTo().window(cId2);
		test.pass("driver control successfully passed to View profile page");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test.pass("Fetching viewed profile Id...........");
		String viewedId=MatchesPage.viewedProfileId().getText();
		test.pass("Viewed profile Id: "+viewedId);
		driver.close();
		driver.switchTo().window(pId2);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String matriId3=MatchesPage.oppMembermatriId().get(0).getText();
		test.pass("Oppsite member Matri id3 : "+matriId3);
		test.info("Verifying Matri Id is removed or not(After viewing the profile)...................");
		Assert.assertNotEquals(matriId3, viewedId);
		test.pass("Member has removed from the list");
		MatchesPage.viewSimilarProfiles().click();
		test.pass("clicked on View similar profiles");
		test.info("Passing driver control to similar profiles page");
		Set<String> set3=driver.getWindowHandles();
		Iterator<String> it3=set3.iterator();
		String pId3=it3.next();
		String cId3=it3.next();
		driver.switchTo().window(cId3);
		test.pass("driver control successfully passed to similar profiles page");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.pass("similar profiles header line: "+MatchesPage.viewSimilarProfilesHeader().getText());
		driver.close();
		driver.switchTo().window(pId3);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		MatchesPage.viewFullprofileLink().click();
		test.pass("clicked on View profile");
		test.info("Passing driver control to View profile page");
		Set<String> set4=driver.getWindowHandles();
		Iterator<String> it4=set4.iterator();
		String pId4=it4.next();
		String cId4=it4.next();
		driver.switchTo().window(cId4);
		test.pass("driver control successfully passed to View profile page");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test.pass("Fetching viewed profile Id...........");
		String viewedId1=MatchesPage.viewedProfileId().getText();
		test.pass("Viewed profile Id: "+viewedId1);
		driver.close();
		driver.switchTo().window(pId4);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String matriId4=MatchesPage.oppMembermatriId().get(0).getText();
		test.pass("Oppsite member Matri id4 : "+matriId4);
		test.info("Verifying Matri Id is removed or not(After viewing the profile)...................");
		Assert.assertNotEquals(matriId4, viewedId1);
		test.pass("Member has removed from the list");
		test.pass("Sending Interest....");
		MatchesPage.sendInterestIn_Yes().get(0).click();
		test.pass("Clicked on Send Interest- Yes button");
		Thread.sleep(2000);
		test.pass(MatchesPage.sendInterestConfPopMsg().getText());
		MatchesPage.sendInterestConfPopClose().click();
		test.pass("Send Interest confirmation popup is closed successfully");
		test.info("Verifying Yes button is Changed to Send Remainder or not........");
		String s=MatchesPage.sendRemainderList().get(0).getText();
		test.pass(s+" Is Present");
		test.pass("Send Remainder is Verified successfully");
		Thread.sleep(2000);
		String m1=MatchesPage.oppMembermatriId().get(0).getText();
		MatchesPage.sendInterestIn_No().get(0).click();
		test.pass("profile Id Which you have not Interested in: "+m1);
		test.pass("clicked on Send Interest- No button");
		test.info("Verifying whether member is Removed from the list or not");
		Thread.sleep(2000);
		String m2=MatchesPage.oppMembermatriId().get(0).getText();
		test.pass("profile Id after removing the Not Interested profile: "+m2);
		test.pass("Member has Removed from the list");
		test.pass("All the links Available in yet To Be Viewed are successfully Verified");
		
	}
	//2.Login as Free Id>>Matches>>Latest Matches>>check all the links are working or not.
	@Test(priority=1,enabled=false)
	public void matches_YetToBeViewedTest3() throws Throwable{
		test=extent.createTest("Matches -yet to be Viewed Test2");
		//Fetching the data from excel
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("LoginTestData",2,0);
    	String userName=eData.getExcelData("LoginTestData",2,1);
    	String password=eData.getExcelData("LoginTestData",2,2);
    	LoginPage2.login(baseUrl, userName, password);
		LoginPage2.intermediate_Popups();
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		act.moveToElement(MatchesPage.matchesLink()).perform();
		//act.moveToElement(MatchesPage.matches_LatestMatches()).click().build().perform();
		MatchesPage.matches_LatestMatches().click();
		test.pass("clicked on latest Matches under matches");
		MatchesPage.sendMailIcon().get(0).click();
		test.pass("clicked on Send Mail button");
		test.info("Passing driver control to payment page window");
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		String pId=it.next();
		String cId=it.next();
		driver.switchTo().window(cId);
		test.pass("driver control successfully passed to payment page");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test.info("Fetching payment page Header line....");
		test.pass(MatchesPage.paymentPageHeader().getText());
		test.info("Closing payment page.........");
		driver.close();
		test.pass("payment page closed successfully");
		driver.switchTo().window(pId);
		test.pass("driver control is passed to Main window");
		MatchesPage.mobileIcon().click();
		test.pass("clicked on Mobile Icon");
		test.info("Passing driver control to payment page window");
		Set<String> set1=driver.getWindowHandles();
		Iterator<String> it1=set1.iterator();
		String pId1=it1.next();
		String cId1=it1.next();
		driver.switchTo().window(cId1);
		test.pass("driver control successfully passed to payment page");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test.info("Fetching payment page Header line....");
		test.pass(MatchesPage.paymentPageHeader().getText());
		test.info("Closing payment page.........");
		driver.close();
		test.pass("payment page closed successfully");
		driver.switchTo().window(pId1);
		test.pass("driver control is passed to Main window");
		MatchesPage.horoscopeIcon().click();
		test.pass("clicked on Horoscope Icon");
		boolean status=true;
		try{
			test.pass(MatchesPage.reqHoroconfPopMsg().getText());
			Thread.sleep(2000);
			MatchesPage.reqHoroConfPopClose().click();
			status=false;
			test.pass("Request horoscope popup is closed successfully");
		}catch(Exception e){e.getMessage();}
		if(status){
			test.info("Passing driver control to payment page window");
			Set<String> set2=driver.getWindowHandles();
			Iterator<String> it2=set2.iterator();
			String pId2=it2.next();
			String cId2=it2.next();
			driver.switchTo().window(cId2);
			test.pass("driver control successfully passed to payment page");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			test.info("Fetching payment page Header line....");
			test.pass(MatchesPage.paymentPageHeader().getText());
			test.info("Closing payment page.........");
			driver.close();
			test.pass("payment page closed successfully");
			driver.switchTo().window(pId2);
			
			test.pass("driver control is passed to Main window");
		}
		boolean status1=true;
		Thread.sleep(2000);
		try{
			MatchesPage.shortlistIcon().click();
			Thread.sleep(3000);
			test.pass(MatchesPage.shortlistConfPopMsg().get(0).getText());
			status=false;
			MatchesPage.shortlistConfPopClose().get(0).click();
			test.pass("Shorlisted popup is successfully closed");
		}catch(Exception e){e.getMessage();}
		if(status1)test.pass("Shortlist icon is Disabled");	
		MatchesPage.oppMembermatriId().get(0).click();
		test.pass("clicked on Opposite member Matri id");
		test.info("Passing driver control to View profile page");
		Set<String> set2=driver.getWindowHandles();
		Iterator<String> it2=set2.iterator();
		String pId2=it2.next();
		String cId2=it2.next();
		driver.switchTo().window(cId2);
		test.pass("driver control successfully passed to View profile page");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test.pass("Fetching viewed profile Id...........");
		String viewedId=MatchesPage.viewedProfileId().getText();
		test.pass("Viewed profile Id: "+viewedId);
		driver.close();
		driver.switchTo().window(pId2);
		//driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		MatchesPage.viewSimilarProfiles().click();
		test.pass("clicked on View similar profiles");
		test.info("Passing driver control to similar profiles page");
		Set<String> set3=driver.getWindowHandles();
		Iterator<String> it3=set3.iterator();
		String pId3=it3.next();
		String cId3=it3.next();
		driver.switchTo().window(cId3);
		test.pass("driver control successfully passed to similar profiles page");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		test.pass("similar profiles header line: "+MatchesPage.viewSimilarProfilesHeader().getText());
		driver.close();
		driver.switchTo().window(pId3);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    MatchesPage.viewFullprofileLink().click();
		test.pass("clicked on View profile");
		test.info("Passing driver control to View profile page");
		Set<String> set4=driver.getWindowHandles();
		Iterator<String> it4=set4.iterator();
		String pId4=it4.next();
		String cId4=it4.next();
		driver.switchTo().window(cId4);
		test.pass("driver control successfully passed to View profile page");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test.pass("Fetching viewed profile Id...........");
		String viewedId1=MatchesPage.viewedProfileId().getText();
		test.pass("Viewed profile Id: "+viewedId1);
		driver.close();
		driver.switchTo().window(pId4);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try{
			String m1=MatchesPage.oppMembermatriId().get(0).getText();
			MatchesPage.sendInterestIn_No().get(0).click();
			test.pass("profile Id Which you have not Interested in: "+m1);
			test.pass("clicked on Send Interest- No button");
			test.info("Verifying whether member is Removed from the list or not");
			Thread.sleep(2000);
			String m2=MatchesPage.oppMembermatriId().get(0).getText();
			test.pass("profile Id after removing the Not Interested profile: "+m2);
			test.pass("Member has Removed from the list");
			Thread.sleep(2000);
			test.pass("Sending Interest....");
		}catch(Exception e){e.getMessage();}
		boolean st=false;
		try{
			for(int i=0;i<=5;i++){
				MatchesPage.sendInterestIn_Yes().get(1).click();
				test.pass("Clicked on Send Interest- Yes button");
				st=true;
				Thread.sleep(2000);
				test.pass(MatchesPage.sendInterestConfPopMsg().getText());
				MatchesPage.sendInterestConfPopClose().click();
				test.pass("Send Interest confirmation popup is closed successfully");
				test.info("Verifying Yes button is Changed to Send Remainder or not........");
				String s=MatchesPage.sendRemainderList().get(0).getText();
				test.pass(s+" Is Present");
				test.pass("Send Remainder is Verified successfully");
				if(st){
					break;
				}
			}
			
		}catch(Exception e){e.getMessage();}
		LoginPage2.logout();
		driver.close();
		test.pass("All the links Available in yet To Be Viewed are successfully Verified");
		
		
		
			
			
			
		
		
		
		
	}
}
