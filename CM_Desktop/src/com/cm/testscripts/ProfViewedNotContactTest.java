package com.cm.testscripts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.cm.Utility.BaseTest;
import com.cm.Utility.WebdriverWaitLib;
import com.cm.pages.HomePage;
import com.cm.pages.LoginPage2;
import com.cm.pages.ProfViewedNotContactPage;

public class ProfViewedNotContactTest extends BaseTest {
	public ProfViewedNotContactTest() throws Throwable{
		ProfViewedNotContactPage.loadProperties();
		HomePage.loadProperties();
	}
	
	//***Scenorio1: Login>>click on Yet to Be Viewed>>View the profile>>check in Profile Viewed Not Contacted***
	
	/*@Test
	public void profileViewedNotContactedTest1() throws Throwable{
		test=extent.createTest("Profile Viewed & Not Contacted Scenorio1" );
		LoginPage2.login();
		LoginPage2.intermediate_Popups();
		Thread.sleep(2000);
		try{
		Actions act=new Actions(driver);
		act.moveToElement(HomePage.matchesLink()).perform();
		act.moveToElement(ProfViewedNotContactPage.yetToBeViewed()).click().perform();
		test.pass("Clicked on Yet to be Viewed");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		HomePage.viewFullprofile().get(0).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test.pass("clicked on View Profile");
		test.info("Passing the Driver control to child Window");
		Set<String> set=driver.getWindowHandles();
	    Iterator<String> it=set.iterator();
	    String pID= it.next();
	    String cId=it.next();
	    driver.switchTo().window(cId);
	    test.pass("driver Control is Successfully Passed to child Window");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test.info("Fetching Viewed Profile Id...........");
		String expId=ProfViewedNotContactPage.viewFullProfOppId().getText();
		test.pass("Viewed Profile Id: "+expId);
		driver.close();
		test.pass("Child window closed");
		test.info("passing the Driver control to Parent window");
		driver.switchTo().window(pID);
		test.pass("Driver control passed to parent window successfully");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		act.moveToElement(HomePage.myHomeLink()).perform();
		act.moveToElement(ProfViewedNotContactPage.proViewedNotContacted()).click().perform();
		Thread.sleep(5000);
		test.pass("Clicked on Profiles viewed & not contacted");
		boolean status=false;
		for(int i=0;i<ProfViewedNotContactPage.oppsiteIdList().size();i++){
			String s=ProfViewedNotContactPage.oppsiteIdList().get(i).getText();
			test.pass("verifying......... Expected Id: "+expId+" with Actuals :"+s);
			status=s.equalsIgnoreCase(expId);
			if(status){
				break;
			}
			if(i==9){
				break;
			}
		}
		if(status){
			test.pass("Viewed Profile id is present in Viewed and Not contacted");
		}else{
			test.pass("Viewed Profile id is not present in Viewed and Not contacted");
		}
		}catch(Exception e){e.getMessage();}
		driver.close();
		
	}*/
	@Test
	public void profileViewedNotContactedTest2() throws Throwable{
		test=extent.createTest("Profile Viewed & Not Contacted Scenorio2" );
		LoginPage2.login();
		LoginPage2.intermediate_Popups();
		Thread.sleep(2000);
		try{
			Actions act=new Actions(driver);
			act.moveToElement(HomePage.myHomeLink()).perform();
			act.moveToElement(ProfViewedNotContactPage.proViewedNotContacted()).click().perform();
			test.pass("Clicked on Profile Viewed not Contacted");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			if(ProfViewedNotContactPage.vHoro().isDisplayed()){
				try{
					ProfViewedNotContactPage.vPhone().click();
					test.pass("clicked on View Mobile Number/send SmS Button");
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					boolean status=true;
					try{
						ProfViewedNotContactPage.vPhonePopupClose().click();
						test.pass("View Mobile number Popup is Closed");
						status=false;
						Thread.sleep(2000);
						}catch(Exception e){e.getMessage();}
					if(status){
						test.info("Passing the Driver control to child Window");
						Set<String> set=driver.getWindowHandles();
						Iterator<String> it=set.iterator();
						String pId=it.next();
						String cId=it.next();
						driver.switchTo().window(cId);
						test.pass("driver Control is Successfully Passed to child Window");
						driver.close();
						test.pass("Child window closed");
						test.info("passing the Driver control to Parent window");
						driver.switchTo().window(pId);
						test.pass("Driver control passed to parent window successfully");
						}
		             	ProfViewedNotContactPage.vHoro().click();
		             	test.pass("clicked on View Horoscope");
		             	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		             	boolean status1=true;
		             	try{
		             		ProfViewedNotContactPage.horoPOpupClose().click();
		             		test.pass("Horoscope popup is closed");
		             		status1=false;
		             		Thread.sleep(2000);
		             	}catch(Exception e){e.getMessage();}
		             	if(status1){
		             		test.info("Passing the Driver control to child Window");
		             		Set<String> set=driver.getWindowHandles();
		             		Iterator<String> it=set.iterator();
		             		String pId=it.next();
		             		String cId=it.next();
		             		driver.switchTo().window(cId);
		             		test.pass("driver Control is Successfully Passed to child Window");
			    			driver.close();
			    			test.pass("Child window closed");
			    			test.info("passing the Driver control to Parent window");
			    			driver.switchTo().window(pId);
			    			test.pass("Driver control passed to parent window successfully");
		             	}
		             	try{
		             		Thread.sleep(2000);
		             		ProfViewedNotContactPage.shortlistIconList().get(0).click();
		             		test.pass("clicked on Shortlist Icon");
		             		Thread.sleep(3000);
		             	}catch(Exception e){e.getMessage();}
		             	ProfViewedNotContactPage.viewSimlrproLink().click();
		             	test.pass("clicked on View similar profiles");
		             	test.info("Passing the Driver control to child Window");
		             	Set<String> set1=driver.getWindowHandles();
		             	Iterator<String> it1=set1.iterator();
		             	String pID1= it1.next();
		             	String cId1=it1.next();
		             	driver.switchTo().window(cId1);
		             	test.pass("driver Control is Successfully Passed to child Window");
		             	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		             	driver.close();
		             	test.pass("Child window closed");
		             	test.info("passing the Driver control to Parent window");
		             	driver.switchTo().window(pID1);
		             	test.pass("Driver control passed to parent window successfully");
		             	try{
		             		ProfViewedNotContactPage.oppsiteIdList().get(0).click();
		             		test.pass("clicked on Opposite Id link in my home");
		             		test.info("Passing the Driver control to child Window");
		             		Set<String> set=driver.getWindowHandles();
		             		Iterator<String> it=set.iterator();
		             		String pID= it.next();
		             		String cId=it.next();
		             		driver.switchTo().window(cId);
		             		test.pass("driver Control is Successfully Passed to child Window");
		             		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		             		test.info("Fetching Viewed Profile Id...........");
		             		String expId=ProfViewedNotContactPage.viewFullProfOppId().getText();
		             		test.pass("Viewed Profile Id: "+expId);
		             		driver.close();
		             		test.pass("Child window closed");
		             		test.info("passing the Driver control to Parent window");
		             		driver.switchTo().window(pID);
		             		test.pass("Driver control passed to parent window successfully");
		             	}catch(Exception e){e.getMessage();}
				
		             	test.pass("All links present in Profiles viewed & not contacted are verified successfully");
		             	try{
		             		boolean status2=true;
		             		try{
		             			ProfViewedNotContactPage.sendMailButtonlist().get(0).click();
		             			test.pass("clicked on send mail");
		             			WebdriverWaitLib.waitElementToPresent(ProfViewedNotContactPage.sendmailpopupClose());
		             			ProfViewedNotContactPage.sendmailpopupClose().click();
		             			test.pass("Send mail popup is closed");
		             			status2=false;
		             			Thread.sleep(2000);
		             		}catch(Exception e){e.getMessage();}
		             		if(status2){
		             			Set<String> set=driver.getWindowHandles();
		             			Iterator<String> it=set.iterator();
		             			String pId=it.next();
		             			String cId=it.next();
		             			driver.switchTo().window(cId);
		             			test.pass("driver Control is Successfully Passed to child Window");
		             			driver.close();
		             			test.pass("Child window closed");
		             			test.info("passing the Driver control to Parent window");
		             			driver.switchTo().window(pId);
		             			test.pass("Driver control passed to parent window successfully");
		             		}
			
		             	}catch(Exception e){e.getMessage();}
				
				}catch(Exception e){e.getMessage();}
			}else{
				test.pass("sorry......,There is No viewed profiles");
			}
		}catch(Exception e){e.getMessage();}
		driver.quit();
	}
	
}
