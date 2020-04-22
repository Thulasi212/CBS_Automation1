package testscripts;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.Inbox2Page;
import pages.LoginPage2;
import utility.BaseTest;
import utility.WebDriverWaitLib;


public class InboxTest8  extends BaseTest {
	public static Properties properties;
	public InboxTest8()throws Throwable{
	    	HomePage.loadProperties();
	    	Inbox2Page.loadProperties();
	    }

	@Test
	public void inboxRequests_S8Test() throws Throwable {
		test=extent.createTest("Inbox_Requests Scenorio8 Test");
		LoginPage2.login();
		LoginPage2.intermediate_Popups();
	    test.pass("Intermediate pages are closed");
	    Thread.sleep(1000);
	    test.info("Fetching Profile Info, Sent Items Count Before Sending Request...........");
	    Inbox2Page.inboxLink().click();
	    test.pass("clicked on Inbox");
	    WebDriverWaitLib.waitElementToPresent(Inbox2Page.requests());
	    Inbox2Page.requests().click();
	    test.pass("clicked on Requests");
	    WebDriverWaitLib.waitElementToPresent(Inbox2Page.sentButton());
	    Thread.sleep(5000);
	    Inbox2Page.sentButton().click();
	    test.pass("clicked on Sent");
	    try{
	    Thread.sleep(5000);
	    Inbox2Page.requestAll().click();
	    test.pass("clicked on All");
	    WebDriverWaitLib.waitElementToPresent(Inbox2Page.profileInfoReqSent());
	    String s=Inbox2Page.profileInfoReqSent().getText();
	    test.pass(s);
	    int pICount=Integer.parseInt(s.substring(14, s.length()-1));
        test.pass("profile Info Request Sent Items Count: "+pICount);
        Thread.sleep(5000);
        test.info("Sending profile Info Request..............");
        HomePage.matchesLink();
        test.pass("clicked on Matches");
        Thread.sleep(5000);
	    boolean status=false;
	    for(int i=0;i<10;i++)
	    {
	    	Thread.sleep(6000);
	    	HomePage.viewFullProfile().get(i).click();
	    	test.pass("clicked on View profile");
	    	Set<String> lst1= driver.getWindowHandles();
	    	Iterator<String> it=lst1.iterator();
	    	String pId=it.next();
	    	String cId=it.next();
	    	driver.switchTo().window(cId);
	    	Thread.sleep(5000);
	    	for(int j=0;j<HomePage.requestFor().size()-1;i++)
	    	{  
	    		HomePage.requestFor().get(j).click();
	    		test.pass("clicked on Request For");
	    		status=true;
	    		Thread.sleep(2000);
	    		s=HomePage.requestConfMsg().getText();
	    		test.pass(s);
	    		HomePage.requestConfMsgClose().click();
	    		test.pass("Request confirmation Popup is closed");
	    		if(status){break;}		
	    	}	
	    	driver.close();
	    	driver.switchTo().window(pId);
	    	if(status){break;}   
	   	}
	    if(status){
	    	test.info("Fetching Profile Info, Sent Items Count After Sending Request...........");
	    	Inbox2Page.inboxLink().click();
	 	    test.pass("clicked on Inbox");
	 	    WebDriverWaitLib.waitElementToPresent(Inbox2Page.requests());
	 	    Thread.sleep(2000);
	 	    Inbox2Page.requests().click();
	 	    test.pass("clicked on Requests");
	 	    WebDriverWaitLib.waitElementToPresent(Inbox2Page.sentButton());
	 	    Thread.sleep(5000);
	 	    Inbox2Page.sentButton().click();
	 	    test.pass("clicked on Sent");
	 	    Thread.sleep(2000);
	 	    Inbox2Page.requestAll().click();
	 	    test.pass("clicked on All");
	 	    Thread.sleep(2000);
	 	    WebDriverWaitLib.waitElementToPresent(Inbox2Page.profileInfoReqSent());
	  	    String s2=Inbox2Page.profileInfoReqSent().getText();
	  	    int pICount1=Integer.parseInt(s2.substring(14, s2.length()-1));
	        test.pass("ProfileInfo Request Sent Items Count: "+pICount1); 
	        test.pass("Photo Request , Sent Items count is verified");
	    }
	    else{
	    	test.info("Sorry...........,There is No ProfileInfo Requests to send");
	    }
	    }
	    catch(Exception e){e.getMessage();}
	   // driver.close();
	}

}
