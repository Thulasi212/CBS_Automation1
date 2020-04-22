package POMBrahmin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;
import Base1.BaseBrahmin;
import io.appium.java_client.android.AndroidDriver;

public class Strictpp extends BaseBrahmin{
	
	public Strictpp(AndroidDriver driver) {
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
	
	 @FindBy(xpath="//*[@id='icon' and ./parent::*[@id='tab_menu']]")
	 private WebElement menu_button;
	 
	 @FindBy(xpath="//*[@text='Edit Partner Preference']")
	 private WebElement edit_partner_preference;
	 
	 @FindBy(xpath="//*[@text='Manage Strict Filters']")
	 private WebElement strict_filter;


	 @FindBy(xpath="//*[@text='Submit']")
	 private WebElement strict_filter_submit;
	 
	 @FindBy(xpath="//*[@text='OFF']")
	 private WebElement strict_filter_OFF;
	 
	 
	 @FindBy(xpath="//*[@text='ON']")
	 private WebElement strict_filter_ON;
	
	 
	 @FindBy(xpath="//*[@contentDescription='Navigate up']")
	 private WebElement strict_back_btn;
	
	 @FindBy(xpath="//*[@text='Matches']")
	 private WebElement matches;
	 
	 
	 @FindBy(xpath="//*[@id='icon' and ./parent::*[@id='tab_home']]")
	 private WebElement home_btn;
	 
	 
	 @FindBy(xpath="//*[@text='LATEST MATCHES']")
	 private WebElement latest_matches;

	 
	 @FindBy(xpath="//*[@id='profileDesc']")
	 private WebElement profile_description;
	 
	 
	 @FindBy(xpath="//*[@id='profileMatriId']")
	 private WebElement profile_matri_id;
	
	 
	 @FindBy(xpath="//*[@text='Account Settings']")
	 private WebElement Account_settings;
	
	 
	 
	 @FindBy(xpath="//*[@text='Logout']")
	 private WebElement logout;
	
	 
	 
	public WebElement getAccount_settings() {
		return Account_settings;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getStrict_back_btn() {
		return strict_back_btn;
	}

	public WebElement getMatches() {
		return matches;
	}

	public WebElement getHome_btn() {
		return home_btn;
	}

	public WebElement getLatest_matches() {
		return latest_matches;
	}

	public WebElement getProfile_description() {
		return profile_description;
	}

	public WebElement getProfile_matri_id() {
		return profile_matri_id;
	}

	public WebElement getStrict_filter_OFF() {
		return strict_filter_OFF;
	}

	public WebElement getStrict_filter_ON() {
		return strict_filter_ON;
	}

	public WebElement getStrict_filter_submit() {
		return strict_filter_submit;
	}

	public WebElement getEdit_partner_preference() {
		return edit_partner_preference;
	}

	public WebElement getStrict_filter() {
		return strict_filter;
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

	public WebElement getMenu_button() {
		return menu_button;
	}
	    
	 
	    
	
	
	
}
