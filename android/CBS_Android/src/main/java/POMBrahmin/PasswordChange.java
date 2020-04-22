package POMBrahmin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;
import Base1.BaseBrahmin;
import io.appium.java_client.android.AndroidDriver;

public class PasswordChange extends BaseBrahmin{
	
	public PasswordChange(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@text='LOGIN']")
	private WebElement home_Login_btn;
	
	
	@FindBy(xpath="//*[@id='matriid_from_login_layout']")
	private WebElement matri_Id;
	
	
	@FindBy(xpath="//*[@id='pass__from_login_layout']")
	private WebElement password;
	
	
	@FindBy(xpath="//*[@text='Login']")
	private WebElement Login_btn;
	
	
	@FindBy(xpath="//*[@text='Skip']")
	private WebElement quick_tour_skip;
	
	
	@FindBy(xpath="//*[@contentDescription='Navigate up']")
	private WebElement quick_tour_back_btn;
	
	
	@FindBy(xpath="//*[@id='ivFilter']")
	private WebElement daily_match_click;
	
	
	@FindBy(xpath="//*[@contentDescription='Navigate up']")
	private WebElement daily_match_back;
	
	
	@FindBy(xpath="//*[@text='Later']")
	private WebElement notification_later;
	
	
	@FindBy(xpath="//*[@text='Skip']")
	private WebElement qucik_response;
	
	
	@FindBy(xpath="//*[@id='icon' and ./parent::*[@id='tab_menu']]")
	private WebElement menu_btn;
	
	
	@FindBy(xpath="//*[@text='Account Settings']")
	private WebElement Account_setting;
	
	
	@FindBy(xpath="//*[@text='Change Password']")
	private WebElement change_password_btn;

	
	@FindBy(xpath="//*[@id='old_pwd_txt']")
	private WebElement old_password;
	
	
	@FindBy(xpath="//*[@id='new_pwd_txt']")
	private WebElement New_password;
	
	
	@FindBy(xpath="//*[@id='confirm_pwd_txt']")
	private WebElement confirm_password;
	
	
	@FindBy(xpath="//*[@text='Save']")
	private WebElement save_password;
	
	
	@FindBy(xpath="//*[@text='Logout']")
	private WebElement logout;


	public WebElement getHome_Login_btn() {
		return home_Login_btn;
	}


	public WebElement getMatri_Id() {
		return matri_Id;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getLogin_btn() {
		return Login_btn;
	}


	public WebElement getQuick_tour_skip() {
		return quick_tour_skip;
	}


	public WebElement getQuick_tour_back_btn() {
		return quick_tour_back_btn;
	}


	public WebElement getDaily_match_click() {
		return daily_match_click;
	}


	public WebElement getDaily_match_back() {
		return daily_match_back;
	}


	public WebElement getNotification_later() {
		return notification_later;
	}


	public WebElement getQucik_response() {
		return qucik_response;
	}


	public WebElement getMenu_btn() {
		return menu_btn;
	}


	public WebElement getAccount_setting() {
		return Account_setting;
	}


	public WebElement getChange_password_btn() {
		return change_password_btn;
	}


	public WebElement getOld_password() {
		return old_password;
	}


	public WebElement getNew_password() {
		return New_password;
	}


	public WebElement getConfirm_password() {
		return confirm_password;
	}


	public WebElement getSave_password() {
		return save_password;
	}


	public WebElement getLogout() {
		return logout;
	}
	
	
	
	
}
