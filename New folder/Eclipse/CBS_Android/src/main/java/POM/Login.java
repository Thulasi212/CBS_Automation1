package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class Login extends BaseTest {
	
	
	
	public Login(AndroidDriver driver) {
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
	
	@FindBy(xpath="//*[@text='LATEST MATCHES']")
	private WebElement latest_matches;
	
	@FindBy(xpath="//*[@text='Send Interest' and @height>0]")
	private WebElement send_interest;
	
	@FindBy(xpath="//*[@text='Send Mail']")
	private WebElement send_mail;
	
	@FindBy(xpath="//*[@contentDescription='Navigate up']")
	private WebElement skip_membership_package;
	
	@FindBy(xpath="//*[@text='NOT NOW']")
	private WebElement membership_call_skip;
	
	
    @FindBy(xpath="(//*[@id='ivContentPopup'])[1]")
    private WebElement ignore_block_dropdown;
    
    
    @FindBy(xpath="//*[@text='Ignore']")
    private WebElement ignore;
    
    
    @FindBy(xpath="//*[@text='Block']")
    private WebElement block;
    
    
    @FindBy(xpath="//*[@text='YES']")
    private WebElement confirm_ignore_block;
    
    
    @FindBy(xpath="//*[@text='Mark As Viewed']")
    private WebElement mark_as_viewed;
    
    
    @FindBy(xpath="//*[@id='icon' and ./parent::*[@id='tab_mailbox']]")
    private WebElement mail_box;
 
    
    @FindBy(xpath="//*[@id='profileMatriId']")
    private WebElement get_matriID;
    
    
    @FindBy(xpath="//*[@id='ivFilter']")
    private WebElement filter;
    
    
    @FindBy(xpath="//*[@text='Sent']")
    private WebElement mailbox_sent;
    
    @FindBy(xpath="//*[@id='icon' and ./parent::*[@id='tab_menu']]")
    private WebElement menu_button;
    
    
    @FindBy(xpath="//*[@text='Account Settings']")
    private WebElement account_settings;
    
    @FindBy(xpath="//*[@text='Blocked Profiles']")
    private WebElement blocked_profiles;
    
    @FindBy(xpath="//*[@text='Ignored Profiles']")
    private WebElement ignored_profiles;
    
    
    @FindBy(xpath="(//*[@id='tv_view_replyLayout'])[1]")
    private WebElement view_reply_mailbox;
    
    @FindBy(xpath="//*[@id='mailcontent']")
    private WebElement view_reply_mailconten;
    
    @FindBy(xpath="//*[@text='Send']")
    private WebElement mail_send_btn;
    
    @FindBy(xpath="//*[@id='popup_close_btn']")
    private WebElement toast_msg_close_btn;
    
    @FindBy(xpath=" //*[@text='Matches']")
    private WebElement menu_matches;
    
    
    @FindBy(xpath="//*[@id='icon' and ./parent::*[@id='tab_mailbox']]")
    private WebElement menu_mailbox;
 
    @FindBy(xpath="//*[@id='sbSent']")
    private WebElement mailbox_sent_btn;
 
    @FindBy(xpath="//*[@text='Logout']")
    private WebElement logout_btn;
  
 
    
    
	public WebElement getLogout_btn() {
		return logout_btn;
	}

	public WebElement getMailbox_sent_btn() {
		return mailbox_sent_btn;
	}

	public WebElement getMenu_mailbox() {
		return menu_mailbox;
	}

	public WebElement getMenu_matches() {
		return menu_matches;
	}

	public WebElement getView_reply_mailbox() {
		return view_reply_mailbox;
	}

	public WebElement getView_reply_mailconten() {
		return view_reply_mailconten;
	}

	public WebElement getMail_send_btn() {
		return mail_send_btn;
	}

	public WebElement getToast_msg_close_btn() {
		return toast_msg_close_btn;
	}

	public WebElement getMenu_button() {
		return menu_button;
	}

	public WebElement getAccount_settings() {
		return account_settings;
	}

	public WebElement getBlocked_profiles() {
		return blocked_profiles;
	}

	public WebElement getIgnored_profiles() {
		return ignored_profiles;
	}

	public WebElement getMail_box() {
		return mail_box;
	}

	public WebElement getGet_matriID() {
		return get_matriID;
	}

	public WebElement getFilter() {
		return filter;
	}

	public WebElement getMailbox_sent() {
		return mailbox_sent;
	}

	public WebElement getIgnore_block_dropdown() {
		return ignore_block_dropdown;
	}

	public WebElement getIgnore() {
		return ignore;
	}

	public WebElement getBlock() {
		return block;
	}

	public WebElement getConfirm_ignore_block() {
		return confirm_ignore_block;
	}

	public WebElement getMark_as_viewed() {
		return mark_as_viewed;
	}

	public WebElement getMembership_call_skip() {
		return membership_call_skip;
	}

	public WebElement getSkip_membership_package() {
		return skip_membership_package;
	}

	public WebElement getSend_mail() {
		return send_mail;
	}


	public WebElement getSend_interest() {
		return send_interest;
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

	public WebElement getLatest_matches() {
		return latest_matches;
	}
	
	//@FindBy(xpath="//*[@text='LOGIN']")
//	private WebElement chooseLogin;
	

}
