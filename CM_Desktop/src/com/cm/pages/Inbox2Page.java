package com.cm.pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.cm.Utility.BaseTest;

public class Inbox2Page extends BaseTest {
	public static Properties properties;
	
	//*******DailyMatches**********

	 public  static WebElement yesButton_DailyMatches(){
			WebElement element=driver.findElement(By.id(properties.getProperty("yesButton_DailyMatches")));
			return element;
		}
		public  static WebElement profileHeading(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("profileHeading")));
			return element;
		}
		//*********Maches********
		public  static WebElement inboxLink(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("inboxLink")));
			return element;
		}
		public  static WebElement sentLink(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("sentLink")));
			return element;
		}
		//************sent Items*****
		public  static WebElement sentPendingAll(){
			WebElement element=driver.findElement(By.id(properties.getProperty("sentPendingAll")));
			return element;
		}
		public  static WebElement pendingMessages(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("pendingMessages")));
			return element;
		}
		public  static WebElement messagesDecline(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("messagesDecline")));
			return element;
		}
		public  static WebElement declinedMessages(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("declinedMessages")));
			return element;
		}
		public  static WebElement declinedMessagesReply(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("declinedMessagesReply")));
			return element;
		}
		public  static WebElement declinedMessagesReplyTextbox(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("declinedMessagesReplyTextbox")));
			return element;
		}
		public  static WebElement declinedMessagesReplySend(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("declinedMessagesReplySend")));
			return element;
		}
		public  static WebElement repliedMessages(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("repliedMessages")));
			return element;
		}
		
		public  static WebElement repliedId(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("repliedId")));
			return element;
		}
		public  static WebElement sentPendingInterests(){
			WebElement element=driver.findElement(By.id(properties.getProperty("sentPendingInterests")));
			return element;
		}
		public  static WebElement sentCount(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("sentCount")));
			return element;
		}
		public  static WebElement sentButton(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("sentButton")));
			return element;
		}

		public  static WebElement decline_confMsg(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("decline_confMsg")));
			return element;
		}
		public  static WebElement decline_PopupClose(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("decline_PopupClose")));
			return element;
		}
		public  static WebElement receivedDeclinedAll(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("receivedDeclinedAll")));
			return element;
		}
		public  static WebElement declinedId(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("declinedId")));
			return element;
		}
		public  static WebElement declinedInterests(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("declinedInterests")));
			return element;
		}
		public  static WebElement declinedInterestAccept(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("declinedInterestAccept")));
			return element;
		}
		public  static WebElement requests(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("requests")));
			return element;
		}
		public  static WebElement receiverIdRequests(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("receiverIdRequests")));
			return element;
		}
		public  static WebElement requestsReceived(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("requestsReceived")));
			return element;
		}
		public  static WebElement requestGrant(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("requestGrant")));
			return element;
		}
		public  static List<WebElement> pendingAllSentIds(){
			List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("pendingAllSentIds")));
			return lst;
		}
		public  static List<WebElement> msg(){
			List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("msg")));
			return lst;
		}
		public  static WebElement requestRevoke(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("requestRevoke")));
			return element;
		}
		public  static List<WebElement> requestDecline(){
			List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("requestDecline")));
			return lst;
		}
		public  static WebElement grant_confMsg(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("grant_confMsg")));
			return element;
		}
		public  static WebElement grant_PopupClose(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("grant_PopupClose")));
			return element;
		}
		public  static WebElement chatHistory(){
			WebElement element=driver.findElement(By.id(properties.getProperty("chatHistory")));
			return element;
		}
		public  static List<WebElement> chatHistory_ClickHere(){
			List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("chatHistory_ClickHere")));
			return lst;
		}
		public  static List<WebElement> chatTitle(){
			List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("chatTitle")));
			return lst;
		}
		public  static List<WebElement> chatMsgs(){
			List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("chatMsgs")));
			return lst;
		}
		public  static List<WebElement> chatHistory_ConfMsgPopup(){
			List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("chatHistory_ConfMsgPopup")));
			return lst;
		}
		public  static WebElement requestAll(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("requestAll")));
			return element;
		}
		public  static WebElement photoReqSent(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("photoReqSent")));
			return element;
		}
		public  static WebElement horoscopeReqSent(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("horoscopeReqSent")));
			return element;
		}
		public  static WebElement profileInfoReqSent(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("profileInfoReqSent")));
			return element;
		}
		public  static WebElement sendMailConfSendBtn(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("sendMailConfSendBtn")));
			return element;
		}
		public  static WebElement sendMailConfPopMsg(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("sendMailConfPopMsg")));
			return element;
		}
		public  static WebElement sendMailPopClose(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("sendMailPopClose")));
			return element;
		}
		public  static List<WebElement> sendMailBtn(){
			List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("sendMailBtn")));
			return lst;
		}
		public  static WebElement msgReadAndReply(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("msgReadAndReply")));
			return element;
		}
		public  static WebElement ReceiverIdInSentitems(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("ReceiverIdInSentitems")));
			return element;
		}
		public  static WebElement msgDeclineBtn(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("msgDeclineBtn")));
			return element;
		}
		public  static WebElement msgReplyBtn(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("msgReplyBtn")));
			return element;
		}
		public  static WebElement msgReplyTextbox(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("msgReplyTextbox")));
			return element;
		}
		public  static WebElement msgDeclinePOpMsg(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("msgDeclinePOpMsg")));
			return element;
		}
		public  static WebElement msgDeclinePOpClose(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("msgDeclinePOpClose")));
			return element;
		}
		public  static WebElement msgReplySendBtn(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("msgReplySendBtn")));
			return element;
		}
		public  static WebElement msgReplyConfirMsg(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("msgReplyConfirMsg")));
			return element;
		}
		public  static WebElement msgReplyPopClose(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("msgReplyPopClose")));
			return element;
		}
		public  static WebElement msgDeclineReason(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("msgDeclineReason")));
			return element;
		}
		public  static WebElement msgDeclineReasonConfBtn(){
			WebElement element=driver.findElement(By.xpath(properties.getProperty("msgDeclineReasonConfBtn")));
			return element;
		}
		public static void loadProperties()throws Throwable{
			properties=new Properties();
	    	FileInputStream fis = new FileInputStream(new File(".\\ObjectRepository\\Inbox2.properties"));
	    	properties.load(fis);
		}
}
