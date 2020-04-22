package com.cm.testscripts;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cm.Utility.BaseTest;
import com.cm.Utility.ExcelData;
import com.cm.Utility.WebdriverWaitLib;
import com.cm.pages.HomePage;
import com.cm.pages.Inbox2Page;
import com.cm.pages.LoginPage2;
import com.cm.pages.MatchesPage;

public class InboxTest extends BaseTest{
	public InboxTest() throws Throwable{
		LoginPage2.loadProperties();
		Inbox2Page.loadProperties();
		HomePage.loadProperties();		
	}
	/*Scenorio 1: Login>>Fetch Sent Items count>>send Interest>>1.check whether Sent items count is increased or not 
	                                                          >>2.check Receiver Id in Sent items(under pending)*/
	@Test(enabled=false)
	public void inboxInterests_S1Test() throws Throwable{
		test=extent.createTest("Inbox_Interests Scenorio1 Test");
		test.info("Browser Launching...............");
		//Fetching the data from excel
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("LoginTestData",14,0);
    	String userName=eData.getExcelData("LoginTestData",14,1);
    	String password=eData.getExcelData("LoginTestData",14,2);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	LoginPage2.passwordEdit1().sendKeys(password);
    	LoginPage2.loginButton1().click();
		LoginPage2.intermediate_Popups();
	    test.info("Fetching Sent Items count..............");
	    Thread.sleep(1000);
	    HomePage.myHomeLink().click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    Thread.sleep(2000);
	    int count1=Integer.parseInt(Inbox2Page.sentCount().getText());
		test.pass("SentItems count before sending Interest..."+count1);
		try{
			Thread.sleep(2000);
			LoginPage2.strategic_Popup().click();
			test.pass("Strategic popup closed");
		}catch(Exception e){e.getMessage();}
		Thread.sleep(1000);
		test.info("Sending Interest.....................");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Actions act =new Actions(driver);
		 act.moveToElement(HomePage.matchesLink()).perform();
		 HomePage.yetToBeViewed().click();
		//HomePage.matchesLink().click();
		test.pass("clicked on Matches link");
	    WebdriverWaitLib.waitPageToLoad();
        Thread.sleep(9000);
        boolean a=false;
        if(HomePage.yes().size()>0){
        	for(int i=0;i<=5;i++){
        		try{
        			 HomePage.yes().get(0).click();
        	         test.pass("clicked on Yes Button");
        		}catch(Exception e){e.getMessage();}
            a=true;
            if(a) {
            	break;
            }else{
            	
            }
        	}
         Thread.sleep(5000);
         String confMsg=HomePage.confirmMsg_InPopup().getText();
 		 test.pass(""+confMsg);
 		 HomePage.sentInterest_Popup().click();
 		 test.pass("Confirmation popup is closed");
         Thread.sleep(2000);
         test.info("Fetching Sent Items count..............");
         HomePage.myHomeLink().click();
         WebdriverWaitLib.waitElementToPresent(Inbox2Page.sentCount());
         Thread.sleep(7000);
 	    int count2=Integer.parseInt(Inbox2Page.sentCount().getText());
 	    test.pass("Sent Items count After sending Interest..."+count2);
 	    test.pass("Sent Items count is verified successfully");
 	    test.info("verifying Reciver Id in  Sent Items....................");
 	    Inbox2Page.inboxLink().click();    
 	    WebdriverWaitLib.waitElementToPresent(Inbox2Page.sentPendingAll());
 	    Inbox2Page.sentPendingAll().click();
 	    WebdriverWaitLib.waitElementToPresent(Inbox2Page.sentButton());
 	    Inbox2Page.sentButton().click();
 	    test.info("verifying Receiver Id in All under Pending...");
 	    WebdriverWaitLib.waitElementToPresent(Inbox2Page.sentPendingAll());
 	    Inbox2Page.sentPendingAll().click();
 	    Thread.sleep(5000);
 	    List<WebElement> lst=Inbox2Page.pendingAllSentIds();
 	    for(int i=0;i<=lst.size()-1;)
 	    {
 	    	String s=lst.get(i).getText();
 	    		String actId=s.substring(1, s.length()-1);
 	    		test.info("Actual Id: "+actId);
 	    		break;
 	    }
 	    test.pass("Receiver Id in All under Pending is Verified");
 	    test.info("verifying Receiver Id in Interests under Pending Interests...");
 	    Inbox2Page.sentPendingInterests().click();
 	    WebdriverWaitLib.waitPageToLoad();
 	    List<WebElement> list= Inbox2Page.pendingAllSentIds();
 	    for(int i=0;i<=list.size()-1;)
 	    {
 	    	String s=list.get(i).getText();
 	    		String actId=s.substring(1, s.length()-1);
 	    		test.info("Actual Id: "+actId);
 	    		break;
 	    }
 	    test.pass("Receiver Id in Interests under Pending is Verified");
 	    
 	    test.pass("Receiver Id is verified in Sent Items");
        
        }else{
        	test.pass("sorry...........,There is No matches to send interest");
        }
        driver.close();
        }
	
	
	// Scenorio 2: Login>>Inbox>>Interests>>Decline the Interest>>Check Declined id Under Declined>>Accept the Interest
	@Test(enabled=false)
	public void inboxInterests_S2Test() throws Throwable{
		test=extent.createTest("Inbox_Interests Scenorio2 Test");
		test.info("Browser Launching...............");
		//Fetching the data from excel
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("LoginTestData",15,0);
    	String userName=eData.getExcelData("LoginTestData",15,1);
    	String password=eData.getExcelData("LoginTestData",15,2);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	LoginPage2.passwordEdit1().sendKeys(password);
    	LoginPage2.loginButton1().click();
		LoginPage2.intermediate_Popups();
	    Thread.sleep(3000);
	    Inbox2Page.inboxLink().click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    Inbox2Page.sentPendingInterests().click();
	    test.pass("clicked on Interests under Pending");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    test.info("Declining the Interest.........");
	    boolean status=false;
	    try{
	    	 try{
	 	    	Inbox2Page.msgReadAndReply().click();
	 	    	Thread.sleep(2000);
	 	    }catch(Exception e){e.getMessage();}
	 	    List<WebElement> lt= Inbox2Page.msg();
	 	    if(lt.size()>0){
	 	    for(int i=0;i<1;i++){
	 	    	lt.get(i).click();
	 	    	status=true;
	 	    	Thread.sleep(5000);
	 	    }
	 	    }
	    }catch(Exception e){e.getMessage();}
	     if(status){
	    	Inbox2Page.msgDeclineReason().click();
	 	    Inbox2Page.msgDeclineReasonConfBtn().click();
	 	    Thread.sleep(8000);
	 	    test.info("verifying Declined id in All,Interests under Declined");
	 	    Inbox2Page.receivedDeclinedAll().click();
	 	    Thread.sleep(5000);
	 	    String s2=Inbox2Page.declinedId().getText();
	 	    WebdriverWaitLib.waitElementToPresent(Inbox2Page.declinedId());
	 	    String actId=s2.substring(1, s2.length()-1);
	 	    test.pass("ActualId in All: "+actId);
	 	    test.pass("Declined Id is verified successfully in All under Declined");
	 	    Inbox2Page.declinedInterests().click();
	 	    Thread.sleep(5000);
	 	    WebdriverWaitLib.waitElementToPresent(Inbox2Page.declinedId());
	 	    String s3=Inbox2Page.declinedId().getText();
	 	    String actId1=s3.substring(1, s3.length()-1);
	 	    test.pass("ActualId in All: "+actId1);
	 	    test.pass("Declined Id is verified successfully in Interests under Declined");
	 	    test.info("Accepting the Interest...........");
	 	    Inbox2Page.declinedInterestAccept().click();
	 	    Thread.sleep(2000);
	 	    WebdriverWaitLib.waitElementToPresent(Inbox2Page.decline_confMsg());
	 	    String s4=Inbox2Page.decline_confMsg().getText();
	 	    test.pass(s4);
	 	    WebdriverWaitLib.waitElementToPresent( Inbox2Page.decline_PopupClose());
	 	    Inbox2Page.decline_PopupClose().click();
	 	    test.pass("accepted confMsg Popup is closed");
	     }
	    else{
	    	test.info("Sorry....................,There is no Interests to Decline.");
	    }
	    driver.close();
	}
	//Scenorio 3: Login>>Inbox>>Messages>>Decline the Message>>Check Declined id Under Declined>>Reply for the Message>>check Replied Id under Replied 
	@Test(enabled=false)
	public void inboxMessages_S3Test() throws Throwable{
		test=extent.createTest("Inbox_Messages Scenorio3 Test");
		test.info("Browser Launching...............");
		//Fetching the data from excel
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("LoginTestData",16,0);
    	String userName=eData.getExcelData("LoginTestData",16,1);
    	String password=eData.getExcelData("LoginTestData",16,2);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	LoginPage2.passwordEdit1().sendKeys(password);
    	LoginPage2.loginButton1().click();
		LoginPage2.intermediate_Popups();	 
		Thread.sleep(3000);
	    Inbox2Page.inboxLink().click();
	    test.pass("clicked on Inbox");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    Inbox2Page.pendingMessages().click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    test.pass("clicked on Messages under Pending");
	    test.info("Declining the Message...............");
	    Thread.sleep(5000);
	    boolean status=false;
	    try{try{
	    	Inbox2Page.msgReadAndReply().click();
	            }catch(Exception e){e.getMessage();}
	    	Thread.sleep(3000);
	    	Inbox2Page.msgDeclineBtn().click();
	    status=true;
	    }catch(Exception e){e.getMessage();}
	    if(status){
	    Thread.sleep(2000);
	    Inbox2Page.msgDeclineReason().click();
	    Thread.sleep(1000);
	    Inbox2Page.msgDeclineReasonConfBtn().click();
	    test.pass("Message Declined successfully");
	    Thread.sleep(2000);
	    test.info("verifying Declined id in All under Declined..........");
	    Thread.sleep(5000);
	    Inbox2Page.receivedDeclinedAll().click();
	    Thread.sleep(5000);
	    String s2=Inbox2Page.declinedId().getText();
	    WebdriverWaitLib.waitElementToPresent(Inbox2Page.declinedId());
	    String actId=s2.substring(1, s2.length()-1);
	    test.pass("ActualId in All: "+actId);
	    test.pass("Declined Id is verified successfully in All under Declined");
	    test.info("verifying Declined id in Messages under Declined..........");
	    Inbox2Page.declinedMessages().click();
	    WebdriverWaitLib.waitElementToPresent(Inbox2Page.declinedId());
	    String s3=Inbox2Page.declinedId().getText();
	    String actId1=s3.substring(1, s3.length()-1);
	    test.pass("ActualId in Messages: "+actId1);
	    test.pass("Declined Id is verified successfully in Messages under Declined");
	    test.info("Replying for the Message................");
	    Inbox2Page.declinedMessages().click();
	    Thread.sleep(2000);
	    Inbox2Page.declinedMessagesReply().click(); 
	    Thread.sleep(2000);
	    String msg="hi how r u";
	    Inbox2Page.declinedMessagesReplyTextbox().sendKeys(msg);
	    Inbox2Page.declinedMessagesReplySend().click();
	    test.pass("Your Message has been sent successfully");
	    WebdriverWaitLib.waitPageToLoad();
	    Inbox2Page.decline_PopupClose().click();
	    Thread.sleep(2000);
	    test.info("verifying Replied Id in Messages under Replied.........");
	    Inbox2Page.repliedMessages().click();
	    String s4=Inbox2Page.repliedId().getText();
	    String actId2=s2.substring(1, s4.length()-1);
	    test.pass("Actual  id: "+actId2);
	    test.pass("Replied id is verified successfully");  
	    }else{
	    	test.pass("sorry..........,currently There is No messages to decline");
	    }
	    driver.close();
       }
	//Scenorio 4: Login>>Matches>>view Profile>>Send the Request>>Check Receiver Id in Inbox under Requests
	@Test(enabled=false)
	public void inboxRequests_S4Test() throws Throwable{
		test=extent.createTest("Inbox_Requests Scenorio4 Test");
		test.info("Browser Launching...............");
		//Fetching the data from excel
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("LoginTestData",17,0);
    	String userName=eData.getExcelData("LoginTestData",17,1);
    	String password=eData.getExcelData("LoginTestData",17,2);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	LoginPage2.passwordEdit1().sendKeys(password);
    	LoginPage2.loginButton1().click();
		LoginPage2.intermediate_Popups();
    	Thread.sleep(4000);
    	HomePage.matchesLink().click();
	    test.pass("clicked on matches");
	    Thread.sleep(5000);
	    boolean status=false;
	    String s="";
	    test.info("Sending the Request...........");
	    if(HomePage.viewFullProfile().size()>0){
	    for(int i=0;i<10;i++)
	    {
	    	WebdriverWaitLib.waitElementToPresent( HomePage.viewFullProfile().get(i));
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
	    		Thread.sleep(2000);
	    		s=HomePage.requestConfMsg().getText();
	    		test.pass(s);
	    		HomePage.requestConfMsgClose().click();
	    		test.pass("Request confirmation Popup is closed");
	    		if(s.contains("Your request has been sent to")){break;}		
	    	}	
	    	driver.close();
	    	driver.switchTo().window(pId);
	    	if(s.contains("Your request has been sent to")){
	    		status=true;
	    		break;
	    		}   
	   	}
	     if(status){
	    	test.info("verifying Receiver Id in Sent Items Under Requests...................");
	        Thread.sleep(2000);
	    	Inbox2Page.inboxLink().click();
	    	test.pass("clicked on Inbox Link");
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	Inbox2Page.requests().click();
	    	test.pass("clicked on Requests");
	    	Thread.sleep(8000);
	    	Inbox2Page.sentButton().click();
	    	test.pass("clicked on Sent");
	    	Thread.sleep(5000);
	    	String s3=Inbox2Page.receiverIdRequests().getText();
	    	String actId=s3.substring(1, s3.length()-1);
	    	test.info("Actual Id: "+actId);
	    	test.pass("Receiver Id is verified successfully");
	     }
	     else{
	    	 test.pass("sorry........,There is No Request to send.........");
	     }
	    }else{
	    	test.pass("sorry........,There is No Profiles in Matches for this Id.........");
	    }
	    driver.close();
    }
	
	//Scenorio 5: Login>>Inbox>>Chat History>>check Chat History>>verifying the chat history
	@Test(enabled=false)
	public void inboxRequests_S5Test() throws Throwable{
		test=extent.createTest("Inbox_chat Scenorio5 Test");
		test.info("Browser Launching...............");
		//Fetching the data from excel
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("LoginTestData",18,0);
    	String userName=eData.getExcelData("LoginTestData",18,1);
    	String password=eData.getExcelData("LoginTestData",18,2);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	LoginPage2.passwordEdit1().sendKeys(password);
    	LoginPage2.loginButton1().click();
		LoginPage2.intermediate_Popups();
	    Thread.sleep(4000);
	    Inbox2Page.inboxLink().click();
	    test.pass("Clicked on Inbox");
	    WebdriverWaitLib.waitElementToPresent(Inbox2Page.chatHistory());
	    Inbox2Page.chatHistory().click();
	    test.pass("clicked on ChatHistory");
	    Thread.sleep(5000);
	    if(Inbox2Page.chatHistory_ClickHere().size()>0){
	    	 for(int i=0;i<1;){
	    		WebdriverWaitLib.waitElementToPresent(Inbox2Page.chatHistory_ClickHere().get(i));
	    		Inbox2Page.chatHistory_ClickHere().get(i).click();
	 	    	break;
	 	    }
	 	    test.pass("clicked on Click Here");
	 	    Thread.sleep(5000);
	 	    for(int i=0;i<=Inbox2Page.chatTitle().size()-1;i++){
	 	    	if(Inbox2Page.chatTitle().get(i).isDisplayed()){
	 	    		test.pass(Inbox2Page.chatTitle().get(i).getText());
	 	    	}
	 	    	
	 	    }
	 	   for(int i=0;i<=Inbox2Page.chatMsgs().size()-1;i++){
	 	    	if(Inbox2Page.chatMsgs().get(i).isDisplayed()){
	 	         test.pass(Inbox2Page.chatMsgs().get(i).getText());
	 	         break;
	 	    	}
	 	    }
	 	    test.info("Verifying Chat Message.................");
	 	    boolean status=false;
	 	    for(int i=0;i<=Inbox2Page.chatMsgs().size()-1;i++){
	 	    	if(Inbox2Page.chatMsgs().get(i).isDisplayed()){
	 	         status=Inbox2Page.chatMsgs().get(i).getText().contains("Hi, I am interested in your profile. Would you like to chat with me?");
	 	         break;
	 	    	}
	 	    }
	 	    test.pass(status+"");
	 	    for(int i=0;i<=Inbox2Page.chatHistory_ConfMsgPopup().size()-1;i++){
	 	    	if(Inbox2Page.chatHistory_ConfMsgPopup().get(i).isDisplayed()){
	 	    		Inbox2Page.chatHistory_ConfMsgPopup().get(i).click();
	 	        test.pass("chat History Popup is closed");
	 	    	}
	 	    }
	 	    test.pass("Chat History is verified Successfully.");

	    }else{test.info("Sorry......., There is No Chat History.");}
	    driver.close();
	   	}
	//Scenorio 6: Login>>Inbox>>Requests>>Sent>>Fetch photo Request Count>>Listing Page>>Send  a Photo Request>>check whether Photo Request count is Increased or not 
	@Test(enabled=false)
	public void inboxRequests_S6Test() throws Throwable {
		test=extent.createTest("Inbox_Requests Scenorio6 Test");
		test.info("Browser Launching...............");
		//Fetching the data from excel
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("LoginTestData",19,0);
    	String userName=eData.getExcelData("LoginTestData",19,1);
    	String password=eData.getExcelData("LoginTestData",19,2);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	LoginPage2.passwordEdit1().sendKeys(password);
    	LoginPage2.loginButton1().click();
		LoginPage2.intermediate_Popups();
	    Thread.sleep(2000);
	    Inbox2Page.inboxLink().click();
	    test.pass("clicked on Inbox");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    Thread.sleep(1000);
	    Inbox2Page.requests().click();
	    test.pass("clicked on Requests");
	    Thread.sleep(3000);
	    Inbox2Page.sentButton().click();
	    test.pass("clicked on Sent");
	    Thread.sleep(2000);
	    Inbox2Page.requestAll().click();
	    test.pass("clicked on All");
	    test.info("Fetching Photo Request, Sent Items Count Before Sending Request...........");
	    String s=Inbox2Page.photoReqSent().getText();
	    int photoCount=Integer.parseInt(s.substring(7, s.length()-1));
        test.pass("photo Request Sent Items Count: "+photoCount);
        Thread.sleep(5000);
        test.info("Sending the Photo Request..............");
        HomePage.matchesLink().click();
        test.pass("clicked on Matches");
        String s1="";
        boolean status=false;
        for(int i=0;i<=HomePage.reqPhoto().size()-1;i++){
        	status=HomePage.reqPhoto().get(i).isDisplayed();
        	test.pass("photo request status: "+status);
        	if(status){
        		HomePage.reqPhoto().get(i).click();
        	test.pass("clicked on Photo Request");
        	WebdriverWaitLib.waitElementToPresent(HomePage.reqphotoConfMsg());
        	 s1=HomePage.reqphotoConfMsg().getText();
        	test.pass(s1);
        	Thread.sleep(5000);
        	HomePage.reqphotoPopupClose().click();
        	test.pass("Popup closed");
        	break;
        	}
        }
        if(status){
        	WebdriverWaitLib.waitPageToLoad();
        	Thread.sleep(6000);
        	Inbox2Page.inboxLink().click();
        	WebdriverWaitLib.waitElementToPresent(Inbox2Page.requests());
        	Inbox2Page.requests().click();
     	    WebdriverWaitLib.waitElementToPresent(Inbox2Page.sentButton());
     	    Inbox2Page.sentButton().click();
     	    Thread.sleep(2000);
     	    Inbox2Page.requestAll().click();
     	    test.info("Fetching Photo Request, Sent Items Count After Sending Request...........");
     	    String s2=Inbox2Page.photoReqSent().getText();
     	    int photoCount1=Integer.parseInt(s2.substring(7, s2.length()-1));
            test.pass("photo Request Sent Items Count: "+photoCount1);
            test.info("Verifying Photo Request Count............");
            if(s1.contains("already")){
            	Assert.assertEquals(photoCount1, photoCount);
            	test.info("Photo Request count Verification is successfully completed");
            }else{
            	Assert.assertEquals(photoCount1-1, photoCount);
            	test.info("Photo Request count Verification is successfully completed");
            }
            
        	
        }else{
        	test.info("Sorry............There is No Photo Requests to send........");
        }
        driver.close();   
   }	
	//Scenorio 7: Login>>Inbox>>Sent>>Fetch Horoscope Req.Count>>Listing page>>send a horoscope Req>>check whether horoscope Req.count is increased or not
	@Test(enabled=false)
	public void inboxRequests_S7Test() throws Throwable {
		test=extent.createTest("InboxRequests Scenorio7 Test");
		test.info("Browser Launching...............");
		//Fetching the data from excel
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("LoginTestData",19,0);
    	String userName=eData.getExcelData("LoginTestData",19,1);
    	String password=eData.getExcelData("LoginTestData",19,2);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	LoginPage2.passwordEdit1().sendKeys(password);
    	LoginPage2.loginButton1().click();
		LoginPage2.intermediate_Popups();
		Thread.sleep(2000);
	    test.info("Fetching Horoscope, Sent Items Count Before Sending Request...........");
	    try{
	    	 Inbox2Page.inboxLink().click();
	 	    test.pass("clicked on Inbox");
	 	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 	    Thread.sleep(1000);
	 	    Inbox2Page.requests().click();
	 	    test.pass("clicked on Requests");
	 	    Thread.sleep(3000);
	 	    Inbox2Page.sentButton().click();
	 	    test.pass("clicked on Sent");
	 	    Thread.sleep(2000);
	 	    Inbox2Page.requestAll().click();
	 	    test.pass("clicked on All");
	    	WebdriverWaitLib.waitElementToPresent(Inbox2Page.horoscopeReqSent());
	    	String s=Inbox2Page.horoscopeReqSent().getText();
	    	test.pass(s);
	    	int horoscopeCount=Integer.parseInt(s.substring(11, s.length()-1));
	    	test.pass("Horoscope Request Sent Items Count: "+horoscopeCount);
	    	Thread.sleep(2000);
	    	test.info("Sending Horoscope Request..............");
	    	HomePage.matchesLink();
	    	test.pass("clicked on Matches");
	    	Thread.sleep(5000);
	    	test.info("Sending Horoscope Request...........");
	    	boolean status=false;
	    	for(int i=0;i<3;i++)
	    	{
	    		WebdriverWaitLib.waitElementToPresent( HomePage.viewFullProfile().get(i));
	    		HomePage.viewFullProfile().get(i).click();
	    		test.pass("clicked on View profile"+i);
	    		Set<String> lst1= driver.getWindowHandles();
	    		Iterator<String> it=lst1.iterator();
	    		String pId=it.next();
	    		String cId=it.next();
	    		driver.switchTo().window(cId);
	    		Thread.sleep(5000);
	    		try{
	    			WebdriverWaitLib.waitPageToLoad();
	    			HomePage.reqHoroscope().click();
	    			status=true;
	    			WebdriverWaitLib.waitElementToPresent(HomePage.reqHoroscopeConfMsg());
	    			String s1=HomePage.reqHoroscopeConfMsg().getText();
	    			test.pass(s1);
	    			HomePage.reqHoroscopePopupClose().click();
	    			test.pass("Popup is closed");
	    			}catch(Exception e){e.getMessage();}
	    		driver.close();
	    		driver.switchTo().window(pId);
	    		WebdriverWaitLib.waitPageToLoad();
	    		if(status){break;}	
	    	}
	    	if(status){
	    	test.info("Fetching Horoscope, Sent Items Count After Sending Request...........");
	    	 Inbox2Page.inboxLink().click();
	 	    test.pass("clicked on Inbox");
	 	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 	    Thread.sleep(1000);
	 	    Inbox2Page.requests().click();
	 	    test.pass("clicked on Requests");
	 	    Thread.sleep(3000);
	 	    Inbox2Page.sentButton().click();
	 	    test.pass("clicked on Sent");
	 	    Thread.sleep(2000);
	 	    Inbox2Page.requestAll().click();
	 	    test.pass("clicked on All");
	 	    WebdriverWaitLib.waitElementToPresent(Inbox2Page.horoscopeReqSent());
	  	    String s2=Inbox2Page.horoscopeReqSent().getText();
	  	    int hCount=Integer.parseInt(s2.substring(11, s2.length()-1));
	        test.pass("Horoscope Request Sent Items Count: "+hCount);  
	        test.pass("Horoscope Request , Sent Items count is verified");
	    	}
	    	else{
		    	test.info("Sorry..........There is No HoroScope to Send");
		    }
	    }catch(Exception e){e.getMessage();}
	    driver.close();
	    }
	//Scenorio 8: Login>>Inbox>>Sent>>Fetch Prof.Info Req.Count>>Listing page>>send a Prof.Info Req>>check whether Prof.Info Req.count is increased or not
	@Test(enabled=false)
	public void inboxRequests_S8Test() throws Throwable {
		test=extent.createTest("Inbox_Requests Scenorio8 Test");
		LoginPage2.login();
		LoginPage2.intermediate_Popups();
	    test.pass("Intermediate pages are closed");
	    Thread.sleep(1000);
	    test.info("Fetching Profile Info, Sent Items Count Before Sending Request...........");
	    Inbox2Page.inboxLink().click();
	    test.pass("clicked on Inbox");
	    WebdriverWaitLib.waitElementToPresent(Inbox2Page.requests());
	    Inbox2Page.requests().click();
	    test.pass("clicked on Requests");
	    WebdriverWaitLib.waitElementToPresent(Inbox2Page.sentButton());
	    Thread.sleep(5000);
	    Inbox2Page.sentButton().click();
	    test.pass("clicked on Sent");
	    try{
	    Thread.sleep(5000);
	    Inbox2Page.requestAll().click();
	    test.pass("clicked on All");
	    WebdriverWaitLib.waitElementToPresent(Inbox2Page.profileInfoReqSent());
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
	 	    WebdriverWaitLib.waitElementToPresent(Inbox2Page.requests());
	 	    Thread.sleep(2000);
	 	    Inbox2Page.requests().click();
	 	    test.pass("clicked on Requests");
	 	    WebdriverWaitLib.waitElementToPresent(Inbox2Page.sentButton());
	 	    Thread.sleep(5000);
	 	    Inbox2Page.sentButton().click();
	 	    test.pass("clicked on Sent");
	 	    Thread.sleep(2000);
	 	    Inbox2Page.requestAll().click();
	 	    test.pass("clicked on All");
	 	    Thread.sleep(2000);
	 	    WebdriverWaitLib.waitElementToPresent(Inbox2Page.profileInfoReqSent());
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
	    driver.close();
	}
	//Scenorio 9:1.Profile A logged in : Profile A sending mail to Profile B>> For profile A login, Mailbox(Pending) sent contains profile B id and for profile B login, Mailbox(Pending) received contains profile A id. 
	           //2.Profile B logged in : Profile B replied to the message >>For profile B login,Mailbox(Replied) received contains profile A id and for profile A login, Mailbox(Replied) sent contains profile B id.
  @Test(enabled=true)
	public void inboxInterests_S9Test() throws Throwable{
		test=extent.createTest("Inbox Scenorio 9");
		test.info("Browser Launching...............");
		//Fetching the data from excel
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("LoginTestData",6,0);
    	String userName=eData.getExcelData("LoginTestData",6,1);
    	String password=eData.getExcelData("LoginTestData",6,2);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	LoginPage2.passwordEdit1().sendKeys(password);
    	LoginPage2.loginButton1().click();
    	test.pass("Profile A Login successfully Completed with username: "+userName+" & password: *******");
		LoginPage2.intermediate_Popups();
		Thread.sleep(1000);
		try{
		Actions act=new Actions(driver);
		act.moveToElement(HomePage.searchLink()).perform();
		test.pass("clicked on Search Link in Home page");
		Thread.sleep(1000);
		String userName2=eData.getExcelData("LoginTestData",7,1);
		test.pass("Searching for Profile B: "+userName2);
		HomePage.searchIdEditbox().sendKeys(userName2);
		test.pass("Profile B Id: "+userName2+" is Entered");
		Thread.sleep(1000);
		act.moveToElement(HomePage.searchBtn()).click().build().perform();
		test.pass("clicked on Search Icon Button");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test.pass("Navigating to the child window (View Profile) .....");
		test.info("Passing the driver control to Child window...........");
		Set<String> set1=driver.getWindowHandles();
	    Iterator<String> it1=set1.iterator();
	    String pID1= it1.next();
	    String cId1=it1.next();
	    driver.switchTo().window(cId1);
	    test.pass("driver Control is Successfully Passed to child Window");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Inbox2Page.sendMailBtn().get(0).click();
		Thread.sleep(3000);
		test.pass("clicked on Send Mail Button");
		Inbox2Page.sendMailConfSendBtn().click();
		Thread.sleep(2000);
		test.pass("clicked on Confirmation send mail Button");
		Thread.sleep(1000);
		driver.close();
		test.pass("Child window closed");
		test.info("passing the Driver control to Parent window.....");
		driver.switchTo().window(pID1);
		test.pass("Driver control passed to parent window successfully");
		Thread.sleep(1000);
		Inbox2Page.inboxLink().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test.pass("clicked on Inbox link in Home page");
		Thread.sleep(2000);
		Inbox2Page.pendingMessages().click();
		test.pass("clicked on messages");
		Thread.sleep(5000);
		Inbox2Page.sentButton().click();
		test.pass("clicked on sent Items");
		Thread.sleep(5000);
		test.pass("Validating Profile B Id in Sent Items...............");
		String expId=eData.getExcelData("LoginTestData",7,1);
		test.info("Expected Id: "+expId);
		test.info("Feching Actual Id from Sent Items....");
		String s=Inbox2Page.ReceiverIdInSentitems().getText();
		String actId=s.substring(1, s.length()-1);
		test.pass("Actual Id: "+actId);
		Assert.assertEquals(actId, expId);
		test.pass("Profile B Id is verified in Sent Items successfully");
		Thread.sleep(2000);
		LoginPage2.logout();
		test.pass("login to the Application with Profile B Id....");
		test.pass("Fetching test data from Excel........");
    	String userName1=eData.getExcelData("LoginTestData",7,1);
    	String password1=eData.getExcelData("LoginTestData",7,2);
    	LoginPage2.userNameEdit2().sendKeys(userName1);
    	LoginPage2.passwordEdit2().sendKeys(password1);
    	LoginPage2.loginButton2().click();
    	test.pass("clicked on login button");
    	test.pass("Profile B Login successfully Completed with username: "+userName1+" & password: "+password1);
    	LoginPage2.intermediate_Popups();
    	Thread.sleep(2000);
    	test.pass("Validating Profile A Id  in Received Items..............");
    	Inbox2Page.inboxLink().click();
    	test.pass("clicked on Inbox link in Home page");
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	Thread.sleep(2000);
		test.info("Feching Actual Id from Received Items....");
		String s1=Inbox2Page.ReceiverIdInSentitems().getText();
		String actId1=s1.substring(1, s1.length()-1);
		test.pass("Actual Id: "+actId1);
		test.pass("Profile A Id is verified in Sent Items successfully");
		Inbox2Page.msgReadAndReply().click();
		test.pass("clicked on Read and Reply button");
		Thread.sleep(2000);
		Inbox2Page.msgReplyBtn().click();
		Thread.sleep(1000);
		String msg="Hi......";
		test.pass("Replying for the messgae: "+msg);
		Inbox2Page.msgReplyTextbox().sendKeys(msg);
		Inbox2Page.msgReplySendBtn().click();
		test.pass("clicked on send Button");
		Thread.sleep(2000);
		test.pass(Inbox2Page.msgReplyConfirMsg().getText());
		Inbox2Page.msgReplyPopClose().click();
		Thread.sleep(2000);
		test.pass("confirmation Popup is closed");
		test.pass("validating Profile A id in Replied Messages....");
		Inbox2Page.repliedMessages().click();
		test.pass("clicked on Messages under Replied");
		test.info("Feching Actual Id from Received Items....");
		String ss=Inbox2Page.ReceiverIdInSentitems().getText();
		String actId2=ss.substring(1, s1.length()-1);
		test.pass("Actual Id: "+actId2);
		test.pass("Sender Id is verified in Sent Items successfully");
		LoginPage2.logout();
		Thread.sleep(2000);
		test.pass("login to the Application with profile A Id....");
		test.pass("Fetching test data from Excel........");
		LoginPage2.userNameEdit2().sendKeys(userName);
    	LoginPage2.passwordEdit2().sendKeys(password);
    	LoginPage2.loginButton2().click();
    	test.pass("Login successfully Completed with username: "+userName+" & password: "+password);
    	LoginPage2.intermediate_Popups();
    	Inbox2Page.inboxLink().click();
		test.pass("clicked on Inbox link in Home page");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		test.pass("validating Profile B id in Recieved Items.....");
		String expId2=eData.getExcelData("LoginTestData",7,1);
    	test.info("Expected Id: "+expId2);
		test.info("Feching Actual Id from Received Items....");
		String sr=Inbox2Page.ReceiverIdInSentitems().getText();
		String actId3=sr.substring(1, s1.length()-1);
		test.pass("Actual Id: "+actId3);
		Assert.assertEquals(actId3, expId2);
		test.pass("Profile B Id is verified in Sent Items successfully");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}catch(Exception e){e.getMessage();}
		driver.close();
	}
}
