package com.cm.testscripts;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.cm.Utility.BaseTest;
import com.cm.pages.HomePage;
import com.cm.pages.LoginPage2;
import com.cm.pages.ProfViewedNotContactPage;
import com.cm.pages.WhoShortlistedMePage;

public class WhoViewedMyProfileTest extends BaseTest{
	public static Properties properties;
	public WhoViewedMyProfileTest() throws Throwable{
		HomePage.loadProperties();
		WhoShortlistedMePage.loadProperties();
	}
	@Test
	public  void whoViewedMyProfileTest() throws Throwable{
		test=extent.createTest("Who viewed my profile Test");
		LoginPage2.login();
		LoginPage2.intermediate_Popups();
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.moveToElement(HomePage.myHomeLink()).perform();
		act.moveToElement(WhoShortlistedMePage.whoViewMyProfile()).click().perform();
		test.pass("clicked on who viewed my profile");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		int idListSize=WhoShortlistedMePage.shortlistedIdList().size();
		if(idListSize>0){
			try{
				WhoShortlistedMePage.sendMailButton().click();
				test.pass("clicked on Send mail button");
				try{
					Set<String> set1=driver.getWindowHandles();
				    Iterator<String> it1=set1.iterator();
				    String pID1= it1.next();
				    String cId1=it1.next();
				    test.info("Passing the Driver control to Payment page");
				    driver.switchTo().window(cId1);
				    test.pass("driver Control is Successfully Passed to payment page");
				    driver.close();
				    test.pass("payment page window closed");
					test.info("passing the Driver control to Parent window");
					driver.switchTo().window(pID1);
					test.pass("Driver control passed to parent window successfully");
				}catch(Exception e){e.getMessage();}	
			}catch(Exception e){e.getMessage();}
			Thread.sleep(2000);
			try{
			WhoShortlistedMePage.mobButton().click();
			test.pass("clicked on mobile button");
			}catch(Exception e){e.getMessage();}
			Thread.sleep(5000);
			try{
			WhoShortlistedMePage.sendSmsPopup().click();
			test.pass("Send sms popup is closed");
			}catch(Exception e){e.getMessage();}
			try{
				Set<String> set1=driver.getWindowHandles();
			    Iterator<String> it1=set1.iterator();
			    String pID1= it1.next();
			    String cId1=it1.next();
			    test.info("Passing the Driver control to Payment page");
			    driver.switchTo().window(cId1);
			    test.pass("driver Control is Successfully Passed to payment page");
			    driver.close();
			    test.pass("payment page window closed");
				test.info("passing the Driver control to Parent window");
				driver.switchTo().window(pID1);
				test.pass("Driver control passed to parent window successfully");
			}catch(Exception e){e.getMessage();}
			try{
				Thread.sleep(5000);
				WhoShortlistedMePage.reqHoro().click();
				test.pass("clicked on request horoscope");
				Thread.sleep(2000);
				test.pass("Feching reuest horoscope confirmation message....");
				test.pass(WhoShortlistedMePage.reqHoroconfMsg().getText());
				WhoShortlistedMePage.horoReqPopup().click();
				test.pass("Request horoscope popup is closed");
			}catch(Exception e){e.getMessage();}
			try{
				Thread.sleep(2000);
				WhoShortlistedMePage.vHoro().click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				test.pass("clicked on view horoscope");
			}catch(Exception e){e.getMessage();}
			try{
				WhoShortlistedMePage.horoPOpupClose().click();
				test.pass("view horoscope is closed");
				}catch(Exception e){e.getMessage();}
			try{
				Set<String> set1=driver.getWindowHandles();
			    Iterator<String> it1=set1.iterator();
			    String pID1= it1.next();
			    String cId1=it1.next();
			    test.info("Passing the Driver control to Payment page");
			    driver.switchTo().window(cId1);
			    test.pass("driver Control is Successfully Passed to payment page");
			    driver.close();
			    test.pass("payment page window closed");
				test.info("passing the Driver control to Parent window");
				driver.switchTo().window(pID1);
				test.pass("Driver control passed to parent window successfully");
			}catch(Exception e){e.getMessage();}
			try{
				Thread.sleep(2000);
				ProfViewedNotContactPage.shortlistIconList().get(0).click();
				test.pass("clicked on Shortlist Icon");
				Thread.sleep(3000);
			}catch(Exception e){e.getMessage();}
			try{
				Thread.sleep(2000);
				boolean status1=WhoShortlistedMePage.shortlistIconDisablList().get(0).isSelected();
				if(status1){
					test.pass("shortlisted icon is enabled");
				}else{
					test.pass("shortlisted icon is disabled");
				}
			}catch(Exception e){e.getMessage();}
			try{
		        Thread.sleep(2000);
		        WhoShortlistedMePage.markAsViewed().get(0).click();
				Thread.sleep(3000);
				test.pass("clicked on mark as viewed");
				WhoShortlistedMePage.markAsviewedNo().click();
				Thread.sleep(2000);
				test.pass("clicked on No");
				WhoShortlistedMePage.viewFullProfile();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				test.pass("clicked on view profile");
			
			}catch(Exception e){e.getMessage();}
			try{
				Set<String> set1=driver.getWindowHandles();
			    Iterator<String> it1=set1.iterator();
			    String pID1= it1.next();
			    String cId1=it1.next();
			    test.info("Passing the Driver control to Payment page");
			    driver.switchTo().window(cId1);
			    test.pass("driver Control is Successfully Passed to payment page");
			    driver.close();
			    test.pass("payment page window closed");
				test.info("passing the Driver control to Parent window");
				driver.switchTo().window(pID1);
				test.pass("Driver control passed to parent window successfully");
			}catch(Exception e){e.getMessage();}
			try{
				Thread.sleep(2000);
				WhoShortlistedMePage.viewSimilarProfiles().click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Set<String> set1=driver.getWindowHandles();
			    Iterator<String> it1=set1.iterator();
			    String pID1= it1.next();
			    String cId1=it1.next();
			    test.info("Passing the Driver control to Payment page");
			    driver.switchTo().window(cId1);
			    test.pass("driver Control is Successfully Passed to payment page");
			    driver.close();
			    test.pass("payment page window closed");
				test.info("passing the Driver control to Parent window");
				driver.switchTo().window(pID1);
				test.pass("Driver control passed to parent window successfully");
			}catch(Exception e){e.getMessage();}
			try{
				WhoShortlistedMePage.sendInterest().click();
				test.pass("clicked on send interest");
				Thread.sleep(5000);
				test.pass(WhoShortlistedMePage.sendIntPopupMsg().getText());
				WhoShortlistedMePage.sendIntPopupClose().click();
			}catch(Exception e){e.getMessage();}
			try{
				WhoShortlistedMePage.sendMailButtonList().get(0).click();
				test.pass("clicked on send mail button");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				WhoShortlistedMePage.sendmailbtnPopup().click();
				test.pass("mail popup is successfully closed");
			}catch(Exception e){e.getMessage();}
			try{
				WhoShortlistedMePage.upgradeNowBtn().get(0).click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				test.pass("clicked on Upgrade now");
				Set<String> set1=driver.getWindowHandles();
			    Iterator<String> it1=set1.iterator();
			    String pID1= it1.next();
			    String cId1=it1.next();
			    test.info("Passing the Driver control to Payment page");
			    driver.switchTo().window(cId1);
			    test.pass("driver Control is Successfully Passed to payment page");
			    driver.close();
			    test.pass("payment page window closed");
				test.info("passing the Driver control to Parent window");
				driver.switchTo().window(pID1);
				test.pass("Driver control passed to parent window successfully");	
			}catch(Exception e){e.getMessage();}
			try{
				Thread.sleep(2000);
				WhoShortlistedMePage.sendRemainder().get(0).click();
				test.pass("clicked on send Remainder");
				Thread.sleep(3000);
				test.info("fetching remainder confirmation message");
				test.pass(WhoShortlistedMePage.sendRemainderPopupMsg().getText());
				WhoShortlistedMePage.sendRempopClose().click();
				test.pass("Send Remainder popup closed");
			}catch(Exception e){e.getMessage();}
			try{
			WhoShortlistedMePage.checkbox().click();
			test.pass("clicked on checkbox");
			WhoShortlistedMePage.checkboxShortlist().click();
			test.pass("clicked on Shortlist button");
			Thread.sleep(5000);
			test.pass(WhoShortlistedMePage.checkboxShortPopMsg().getText());
			}catch(Exception e){e.getMessage();}
			test.pass("who viewed my profile is verified successully");		
		}
		else{
			test.pass("sorry,  no  profiles for this id");
		}	
		driver.close();
	}

}
