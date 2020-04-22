package POMBrahmin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;
import Base1.BaseBrahmin;
import io.appium.java_client.android.AndroidDriver;

public class QuickRes extends BaseBrahmin{
	
	public QuickRes(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	
		
	}
	
	
	@FindBy(xpath="//*[@text='LOGIN']")
	private WebElement chooseLogin;
	
	@FindBy(xpath="//*[@id='matriid_from_login_layout']")
	private WebElement matriId;
	
	@FindBy(xpath="//*[@id='pass__from_login_layout']")
	private WebElement password;
	
	@FindBy(xpath="//*[@text='Login']")
	private WebElement idLogin;
	
	@FindBy(xpath="//*[@text='Skip']")
	private WebElement quick_Tour_Skip;
	
	@FindBy(xpath="//*[@id='popup_close_btn']")
	private WebElement quick_response_popup;
	
	@FindBy(xpath="//*[@text='Later']")
	private WebElement notification_access_later;
	
	@FindBy(xpath="//*[@text='VIEW & REPLY']")
	private WebElement quick_view_reply;
	
	
	@FindBy(xpath="//*[@id='mailcontent']")
	private WebElement quick_mail_content;
	
	
	@FindBy(xpath="//*[@text='SEND']")
	private WebElement quick_mailcontent_send;
	
	
	@FindBy(xpath="//*[@text='YES']")
	private WebElement quick_interest_yes_btn;
	
	
	@FindBy(xpath="//*[@text='DECLINE']")
	private WebElement quick_Decline_btn;
	
	
	@FindBy(xpath="//*[@text='CONFIRM']")
	private WebElement quick_Decline_confirm_btn;
	
	
	@FindBy(xpath="//*[@text='NO' and @width>0]")
	private WebElement quick_Interest_No_btn;
	
	
	@FindBy(xpath="//*[@id='popup_close_btn']")
	private WebElement quick_Interest_No_Connfirm_btn;
	
	@FindBy(xpath="//*[@text='DELETE']")
	private WebElement quickresponse_deleted_profile;
	
	
	@FindBy(xpath="//*[@id='profileimage']")
	private WebElement quickresponse_view_profile;
	
	
	@FindBy(xpath="//*[@id='profileimage']")
	private WebElement quickresponse_send_mail;
	
	
	@FindBy(xpath="//*[@id='vp_comm_btn_right']")
	private WebElement quickresponse_viewProfile_decline;
	
	
	@FindBy(xpath="//*[@id='vp_comm_btn']")
	private WebElement quickresponse_viewProfile_viewrep_accept;
	
	

	@FindBy(xpath="//*[@contentDescription='Navigate up']")
	private WebElement navigate_back;
	
	
	
	public WebElement getNavigate_back() {
		return navigate_back;
	}

	public WebElement getQuick_Decline_confirm_btn() {
		return quick_Decline_confirm_btn;
	}

	public WebElement getQuickresponse_view_profile() {
		return quickresponse_view_profile;
	}

	public WebElement getQuickresponse_send_mail() {
		return quickresponse_send_mail;
	}

	public WebElement getQuickresponse_viewProfile_decline() {
		return quickresponse_viewProfile_decline;
	}

	public WebElement getQuickresponse_viewProfile_viewrep_accept() {
		return quickresponse_viewProfile_viewrep_accept;
	}

	public WebElement getQuick_Decline_btn() {
		return quick_Decline_btn;
	}

	public WebElement getQuick_Decline_confirmbtn() {
		return quick_Decline_confirm_btn;
	}

	public WebElement getQuick_Interest_No_btn() {
		return quick_Interest_No_btn;
	}

	public WebElement getQuick_Interest_No_Connfirm_btn() {
		return quick_Interest_No_Connfirm_btn;
	}

	public WebElement getQuickresponse_deleted_profile() {
		return quickresponse_deleted_profile;
	}

	public WebElement getQuick_interest_yes_btn() {
		return quick_interest_yes_btn;
	}

	public WebElement getQuick_mailcontent_send() {
		return quick_mailcontent_send;
	}

	public WebElement getQuick_mail_content() {
		return quick_mail_content;
	}

	public WebElement getQuick_view_reply() {
		return quick_view_reply;
	}

	public WebElement getChooseLogin() {
		return chooseLogin;
	}

	public WebElement getMatriId() {
		return matriId;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getIdLogin() {
		return idLogin;
	}

	public WebElement getQuick_Tour_Skip() {
		return quick_Tour_Skip;
	}

	public WebElement getQuick_response_popup() {
		return quick_response_popup;
	}

	public WebElement getNotification_access_later() {
		return notification_access_later;
	}
	
	
	

}
