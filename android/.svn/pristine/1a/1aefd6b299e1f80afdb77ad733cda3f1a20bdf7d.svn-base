package testscripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTestAgarwal;
import io.appium.java_client.android.AndroidDriver;

public class Inbox_pom extends BaseTestAgarwal{

	AndroidDriver driver;
	
	public Inbox_pom(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@text='LOGIN']")
	private WebElement main_Login;

	@FindBy(xpath = "//*[@id='matriid_from_login_layout']")
	private WebElement Enter_matri_Id;
	
	@FindBy(xpath = "//*[@id='pass__from_login_layout']")
	private WebElement Enter_password;
	
	@FindBy(xpath = "//*[@id='login_btn_from_login_layout']")
	private WebElement Enter_Login;
	
	@FindBy(xpath = "//*[@text='ALLOW']")
	private WebElement Allow_btn ;
	
	@FindBy(xpath = "//*[@id='skip']")
	private WebElement skip_btn ;
	
	@FindBy(xpath = "//*[@id='popup_close_btn']")
	private WebElement popup_close ;
	
	@FindBy(xpath = "//*[@id='doitlater']")
	private WebElement photo_skip ;
	
	@FindBy(xpath = "//*[@text='YES']")
	private WebElement Accept_intrest_yes ;
	
	@FindBy(xpath = "//*[@text='NO']")
	private WebElement Accept_intrest_no ;
	
	@FindBy(xpath = "//*[@text='VIEW & REPLY']")
	private WebElement View_Reply ;
	
	@FindBy(xpath = "//*[@text='Grant']")
	private WebElement grant ;
	
	@FindBy(xpath = "//*[@text='Decline']")
	private WebElement Decline ;
	
	@FindBy(xpath = "//*[@text='ADD']")
	private WebElement Add_details ;
	@FindBy(xpath = "//*[@text='SEND MAIL']")
	private WebElement received_accept_sendmail ;
	
	@FindBy(xpath = "//*[@text='Revoke']")
	private WebElement Revoke ;
	
	@FindBy(xpath = "//*[@text='SEND']")
	private WebElement message_send ;
	
	@FindBy(xpath = "//*[@id='mailcontent']")
	private WebElement mail_content ;

	public WebElement getAccept_intrest_yes() {
		return Accept_intrest_yes;
	}

	public WebElement getMessage_send() {
		return message_send;
	}

	public WebElement getMail_content() {
		return mail_content;
	}

	public WebElement getAccept_intrest_no() {
		return Accept_intrest_no;
	}

	public WebElement getView_Reply() {
		return View_Reply;
	}

	public WebElement getGrant() {
		return grant;
	}

	public WebElement getDecline() {
		return Decline;
	}

	public WebElement getAdd_details() {
		return Add_details;
	}

	public WebElement getReceived_accept_sendmail() {
		return received_accept_sendmail;
	}

	public WebElement getRevoke() {
		return Revoke;
	}

	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getMain_Login() {
		return main_Login;
	}

	public WebElement getEnter_matri_Id() {
		return Enter_matri_Id;
	}

	public WebElement getEnter_password() {
		return Enter_password;
	}

	public WebElement getEnter_Login() {
		return Enter_Login;
	}

	public WebElement getAllow_btn() {
		return Allow_btn;
	}

	public WebElement getSkip_btn() {
		return skip_btn;
	}

	public WebElement getPopup_close() {
		return popup_close;
	}

	public WebElement getPhoto_skip() {
		return photo_skip;
	}
}