package POMBrahmin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base1.BaseBrahmin;
import io.appium.java_client.android.AndroidDriver;

public class Payment extends BaseBrahmin{

	public Payment(AndroidDriver driver) {
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
	
	@FindBy(xpath="//*[@text='MENU']")
	private WebElement Menu;
	
	
	@FindBy(xpath="//*[@id='ivFilter']")
	private WebElement daily_match_click;
	
	
	@FindBy(xpath="//*[@contentDescription='Navigate up']")
	private WebElement daily_match_back;
	
	@FindBy(xpath="//*[@id='icon' and ./parent::*[@id='tab_menu']]")
	private WebElement menu_btn;
	
	
	@FindBy(xpath="//*[@id='txtupgradenow']")
	private WebElement upgrade_now;
	
	
	@FindBy(xpath="	//*[@id='payGold3mnth' and @width>0]")
	private WebElement upgrade_now_gold_3mnth;

	
	@FindBy(xpath="//*[@id='payGold3mnth' and @width>0]")
	private WebElement upgrade_now_Diamond_3mnth;
	
	
	@FindBy(xpath="//*[@id='payGold3mnth' and @width>0]")
	private WebElement upgrade_now_Platinum_3mnth;
	
	
	@FindBy(xpath="//*[@text='TILL-U-MARRY']")
	private WebElement Till_you_Mary;
	
	
	@FindBy(xpath="	//*[@id='tvGoldAmtdiscount' and @width>0]")
	private WebElement Till_you_Mary_amount;

	
	@FindBy(xpath="//*[@class='android.widget.LinearLayout' and @height>0 and ./*[@id='plan_name']]")
	private WebElement Till_you_Mary_membership_details;
	
	
	@FindBy(xpath="//*[@class='android.widget.LinearLayout' and @height>0 and ./*[@text] and ./*[@id='tvAddonTotalRate']]")
	private WebElement Till_you_Mary_amount_finao_Pay_amount;
	
	
	@FindBy(xpath="(//*[@id='list_view']/*/*[@id='payment_creditcard_mode' and @height>0])[1]")
	private WebElement credit_Payment_mode;
	
	
	@FindBy(xpath="//*[@id='plan_details']")
	private WebElement AMount_due;
	
	
	@FindBy(xpath="//*[@id='card_no']")
	private WebElement Card_number;
	
	
	@FindBy(xpath="(//*[@class='android.widget.ListView']/*[@id='text1'])[2]")
	private WebElement Expiry_month_Value;
	
	@FindBy(xpath="//*[@id='month_spinner']")
	private WebElement Expiry_Month;
	
	@FindBy(xpath="(//*[@class='android.widget.ListView']/*[@id='text1'])[6]")
	private WebElement Expiry_year_value;
	
	
	@FindBy(xpath="//*[@id='cvv']")
	private WebElement CVV;
	
	
	@FindBy(xpath="//*[@id='pay']")
	private WebElement Card_Pay_Now;
	
	
	@FindBy(xpath="//*[@contentDescription='Navigate up']")
	private WebElement Payment_Back;
	
	
	@FindBy(xpath="//*[@id='button1']")
	private WebElement Payment_back_confirm;
	
	
	@FindBy(xpath="//*[@text='PERSONALIZED']")
	private WebElement Personalized_Pack;
	
	
	@FindBy(xpath="//*[@id='rbPack2']")
	private WebElement Personalized_mnth_Pack;
	
	
	@FindBy(xpath="//*[@id='tvPayNow']")
	private WebElement Assisted_upgrade_btn;


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


	public WebElement getMenu() {
		return Menu;
	}


	public WebElement getDaily_match_click() {
		return daily_match_click;
	}


	public WebElement getDaily_match_back() {
		return daily_match_back;
	}


	public WebElement getMenu_btn() {
		return menu_btn;
	}


	public WebElement getUpgrade_now() {
		return upgrade_now;
	}


	public WebElement getUpgrade_now_gold_3mnth() {
		return upgrade_now_gold_3mnth;
	}


	public WebElement getUpgrade_now_Diamond_3mnth() {
		return upgrade_now_Diamond_3mnth;
	}


	public WebElement getUpgrade_now_Platinum_3mnth() {
		return upgrade_now_Platinum_3mnth;
	}


	public WebElement getTill_you_Mary() {
		return Till_you_Mary;
	}


	public WebElement getTill_you_Mary_amount() {
		return Till_you_Mary_amount;
	}


	public WebElement getTill_you_Mary_membership_details() {
		return Till_you_Mary_membership_details;
	}


	public WebElement getTill_you_Mary_amount_finao_Pay_amount() {
		return Till_you_Mary_amount_finao_Pay_amount;
	}


	public WebElement getCredit_Payment_mode() {
		return credit_Payment_mode;
	}


	public WebElement getAMount_due() {
		return AMount_due;
	}


	public WebElement getCard_number() {
		return Card_number;
	}


	public WebElement getExpiry_month_Value() {
		return Expiry_month_Value;
	}


	public WebElement getExpiry_Month() {
		return Expiry_Month;
	}


	public WebElement getExpiry_year_value() {
		return Expiry_year_value;
	}


	public WebElement getCVV() {
		return CVV;
	}


	public WebElement getCard_Pay_Now() {
		return Card_Pay_Now;
	}


	public WebElement getPayment_Back() {
		return Payment_Back;
	}


	public WebElement getPayment_back_confirm() {
		return Payment_back_confirm;
	}


	public WebElement getPersonalized_Pack() {
		return Personalized_Pack;
	}


	public WebElement getPersonalized_mnth_Pack() {
		return Personalized_mnth_Pack;
	}


	public WebElement getAssisted_upgrade_btn() {
		return Assisted_upgrade_btn;
	}
	
	
	
	
	
}
