package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class InboxPagesExt {
	


			//*******DailyMatches**********
		@FindBy(id="buttonActionPerform")
		private WebElement yesButton;
		public void yesButton_DailyMatches(){
			yesButton.click();
		}
		@FindBy(xpath="//div[@class='daily-PP-icon padr15']")
		private WebElement profileHeading;
		public WebElement profileHeading(){
			return profileHeading;
		}
		//*********Maches********
		@FindBy(xpath="//a[text()='Inbox ']")
		private WebElement inboxLink;
		public WebElement inboxLink(){
			return inboxLink;
		}
		
		@FindBy(xpath="//div[@id='msgpop']/div[2]/div[1]/div[1]/ul[1]/li[2]/a")
		private WebElement sentLink;
		public WebElement sentLink(){
			return sentLink;
		}
		//************sent Items*****
		@FindBy(id="RMPENDING")
		private WebElement sentPendingAll;
		public WebElement sentPendingAll(){
			return sentPendingAll;
		}
		@FindBy(xpath="//*[@id='RMPENDINGMSG1']")
		private WebElement pendingMessages;
		public WebElement  pendingMessages(){
			return pendingMessages;
		}
		@FindBy(xpath="//*[@id='decdiv0']")
		private WebElement messagesDecline;
		public WebElement messagesDecline(){
				return messagesDecline;
		}
		@FindBy(xpath="//*[@id='RMDECLINEDMSG1']")
		private WebElement declinedMessages;
		public WebElement declinedMessages(){
			return declinedMessages;
		}
		@FindBy(xpath="//*[@id='reply0']/div")
		private WebElement declinedMessagesReply;
		public WebElement declinedMessagesReply(){
			return declinedMessagesReply;
		}
		@FindBy(xpath="//*[@id='txtval0']")
		private WebElement declinedMessagesReplyTextbox;
		public WebElement declinedMessagesReplyTextbox(){
			return declinedMessagesReplyTextbox;
		}
		@FindBy(xpath=".//*[@id='send0']")
		private WebElement declinedMessagesReplySend;
		public WebElement declinedMessagesReplySend(){
			return declinedMessagesReplySend;
		}
		@FindBy(xpath="//*[@id='SMREPLIEDMSG2']")
		private WebElement repliedMessages;
		public WebElement repliedMessages(){
			return repliedMessages;
		}
		@FindBy(xpath="//*[@id='num0']/div[2]/div[2]/div[2]/div/div[1]/span")
		private WebElement repliedId;
		public WebElement repliedId(){
			return repliedId;
		}
		
		
		
		@FindBy(id="RMPENDINGINT1")
		private WebElement sentPendingInterests;
		public WebElement sentPendingInterests(){
			return sentPendingInterests;
			
			
		}
		@FindBy(xpath="//*[@id='ui-id-2']/span/span")	
		private WebElement sentCount;
		public WebElement sentCount(){
			return sentCount;
			
		}
		@FindBy(xpath="//*[@id='senttab']")
		private WebElement sentButton;
		public WebElement sentButton(){
			return sentButton;
		}
		@FindBy(xpath=".//*[@id='decdiv0']")
		private WebElement declineButton;
		public WebElement declineButton(){
			return declineButton;
		}
		@FindBy(xpath="//*[@id='delete_msg_val']")
		private WebElement decline_confMsg;
		public WebElement decline_confMsg(){
			return decline_confMsg; 
		}
		@FindBy(xpath=".//*[@id='delete_confirm']/div/div/div/div[1]/div[2]/a")
		private WebElement decline_PopupClose;
		public WebElement decline_PopupClose(){ 
			return decline_PopupClose;
		}
		@FindBy(xpath="//a[@id='RMDECLINEDALL1']")
		private WebElement receivedDeclinedAll;
		public WebElement receivedDeclinedAll(){
			return receivedDeclinedAll;
		}
		@FindBy(xpath=".//*[@id='num0']/div[2]/div[2]/div[2]/div/div[1]/span[1]")
		private WebElement declinedId;
		public WebElement declinedId(){
			return declinedId;
		}
		@FindBy(xpath="//*[@id='RMDECLINEDINT1']")
		private WebElement declinedInterests;
		public WebElement declinedInterests(){
			return declinedInterests;
		}
		
		
		@FindBy(xpath="//*[@id='accept0']/div")
		private WebElement declinedInterestAccept;
		public WebElement declinedInterestAccept(){
			return declinedInterestAccept;
		}
		
		@FindBy(xpath="//*[@id='RRALL']/div/span")
		private WebElement requests;
		public WebElement requests(){
			return requests;
		}
		@FindBy(xpath="//*[@id='divhide0']/div[2]/div[2]/div[1]/div[1]/span")
		private WebElement receiverIdRequests;
		public WebElement receiverIdRequests(){
			return receiverIdRequests;
		}
		
		@FindBy(xpath="//*[@id='rectab']")
		private WebElement requestsReceived;
		public WebElement requestsReceived(){
			return requestsReceived;
		}
		@FindBys(@FindBy(xpath="//a[contains(text(),'Grant')]"))
		private List<WebElement> requestGrant;
		public List<WebElement> requestGrant(){
			return requestGrant;
		}
		@FindBys(@FindBy(xpath="//*[@id='msgResults']/div[@class='srcbdr bgclr5 mrgb10']//div[2]/div[2]/div[2]/div/div[1]/span"))
		private List<WebElement> pendingAllSentIds;
		public List<WebElement> pendingAllSentIds(){
			return pendingAllSentIds;
		}
		@FindBys(@FindBy(xpath="//div[text()='I like your profile and I want to get in touch with you. Please accept if interested.']/../following-sibling::div/a[2]"))
		private List<WebElement> msg;
		public List<WebElement> msg(){
		return msg;
		}
		@FindBys(@FindBy(xpath="//a[contains(text(),'Revoke')]"))
		private List<WebElement> requestRevoke;
		public List<WebElement> requestRevoke(){
			return requestRevoke;
		}
		//a[contains(text(),'Decline')]
		@FindBys(@FindBy(xpath="//a[contains(text(),'Decline')]"))
		private List<WebElement> requestDecline;
		public List<WebElement> requestDecline(){
			return requestDecline;
		}
		
		@FindBy(xpath="//*[@id='delete_msg_val']")
		private WebElement grant_confMsg;
		public WebElement grant_confMsg(){
			return grant_confMsg; 
		}
		@FindBy(xpath=".//*[@id='delete_confirm']/div/div/div/div[1]/div[2]/a")
		private WebElement grant_PopupClose;
		public WebElement grant_PopupClose(){ 
			return grant_PopupClose;
		}
		@FindBy(id="CHAT_LEFT")
		private WebElement chatHistory;
		public WebElement chatHistory(){ 
			return chatHistory;
		}
		@FindBy(xpath="//a[contains(text(),'Click Here')]")
		private List<WebElement> chatHistory_ClickHere;
		public List<WebElement> chatHistory_ClickHere(){ 
			return chatHistory_ClickHere;
		}
		@FindBy(xpath="//*[@id='chat_title']")
		private List<WebElement> chatTitle;
		public List<WebElement> chatTitle(){ 
			return chatTitle;
		}
		@FindBy(xpath="//*[@id='chat_msg_val']")
		private List<WebElement> chatMsgs;
		public List<WebElement> chatMsgs(){ 
			return chatMsgs;
		}
		
		@FindBy(xpath="//*[@id='chat_confirm']/div/div/div/div/div[1]/div[3]/input")
		private List<WebElement> chatHistory_ConfMsgPopup;
		public List<WebElement> chatHistory_ConfMsgPopup(){ 
			return chatHistory_ConfMsgPopup;
		}
		@FindBy(xpath="//*[@id='ReqRecShow']/div/div[1]/a")
		private WebElement requestAll;
		public WebElement requestAll(){
			return requestAll;
		}
		
		@FindBy(xpath="//*[@id='SRPHOTO1']")
		private WebElement photoReqSent;
		public WebElement photoReqSent(){
			return photoReqSent;
		}
		
		@FindBy(xpath="//*[@id='SRHOROSCOPE1']")
		private WebElement horoscopeReqSent;
		public WebElement horoscopeReqSent(){
			return horoscopeReqSent;	
		}
		@FindBy(xpath="//*[@id='SRPROFILE1']")
		private WebElement profileInfoReqSent;
		public WebElement profileInfoReqSent(){
			return profileInfoReqSent;
		}
		@FindBy(xpath="//*[@id='SRGPHOTO1']")
		private WebElement photoGrantReqSent;
		public WebElement photoGrantReqSent(){
			return photoGrantReqSent;
		}
		
		@FindBy(xpath="//*[@id='SRGPHONE1']")
		private WebElement phoneGrantReqSent;
		public WebElement phoneGrantReqSent(){
			return phoneGrantReqSent;
		}
		
		
		@FindBy(xpath="//*[@id='SRGHOROSCOPE1']")
		private WebElement horoScopeGrantReqSent;
		public WebElement horoScopeGrantReqSent(){
			return horoScopeGrantReqSent;
		}
	}



