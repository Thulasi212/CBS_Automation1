package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class EdipPartnerPP extends BaseTest {
	
	public EdipPartnerPP(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@text='LOGIN']")
	private WebElement choose_login;

	public WebElement getChoose_login() {
		return choose_login;
	}
	
	@FindBy(xpath="//*[@id='matriid_from_login_layout']")
	private WebElement matriId;

	public WebElement getMatriId() {
		return matriId;
	}
	
	@FindBy(xpath="//*[@id='pass__from_login_layout']")
	private WebElement pasword;

	public WebElement getPasword() {
		return pasword;
	}
	
	@FindBy(xpath="//*[@text='Login']")
	private WebElement enter_login;

	public WebElement getEnter_login() {
		return enter_login;
	}
	
	
	@FindBy(xpath="//*[@text='Skip']")
	private WebElement skip_tour;

	public WebElement getSkip_tour() {
		return skip_tour;
	}
	
	@FindBy(xpath="//*[@id='popup_close_btn']")
	private WebElement quick_reponse;

	public WebElement getQuick_reponse() {
		return quick_reponse;
	}
	
	@FindBy(xpath="//*[@text='Later']")
	private WebElement notification_access;

	public WebElement getNotification_access() {
		return notification_access;
	}
	
	@FindBy(xpath="//*[@id='icon' and ./parent::*[@id='tab_menu']]")
	private WebElement menu_btn;

	public WebElement getMenu_btn() {
		return menu_btn;
	}
	
	@FindBy(xpath="//*[@text='Edit Partner Preference']")
	private WebElement edit_pp_button;

	public WebElement getEdit_pp_button() {
		return edit_pp_button;
	}
	
	@FindBy(xpath="//*[@id='aboutmypartner_edit']")
	private WebElement about_my_partner_btn;

	public WebElement getAbout_my_partner_btn() {
		return about_my_partner_btn;
	}
	
	@FindBy(xpath="//*[@id='partnerselfdesc']")
	private WebElement about_my_partner_description;

	public WebElement getAbout_my_partner_description() {
		return about_my_partner_description;
	}
	
	@FindBy(xpath="//*[@text='Save']")
	private WebElement editt_Pp_save_btn;

	public WebElement getEditt_Pp_save_btn() {
		return editt_Pp_save_btn;
	}
	
	@FindBy(xpath="//*[@text='Partner Preferences']")
	private WebElement partner_prefer_tab;

	public WebElement getPartner_prefer_tab() {
		return partner_prefer_tab;
	}
	
	
	@FindBy(xpath="//*[@id='partnerbasicdetail_edit']")
	private WebElement edit_pp_basicdetails_btn;

	public WebElement getEdit_pp_basicdetails_btn() {
		return edit_pp_basicdetails_btn;
	}
	
	@FindBy(xpath="//*[@id='edit_partner_txt_looking_status_value']")
	private WebElement partner_marital_status;

	public WebElement getPartner_marital_status() {
		return partner_marital_status;
	}
	
	@FindBy(xpath="//*[@text=concat('Doesn', \"'\", 't matter')]")
	private WebElement partner_marital_status_doesnt_matter;

	public WebElement getPartner_marital_status_doesnt_matter() {
		return partner_marital_status_doesnt_matter;
	}
	
	@FindBy(xpath="//*[@text='Unmarried' and @id='refine_adapter_checkBox']")
	private WebElement partner_marital_status_unmarried;

	public WebElement getPartner_marital_status_unmarried() {
		return partner_marital_status_unmarried;
	}
	
	
	@FindBy(xpath="//*[@text='Widow / Widower']")
	private WebElement partner_marital_status_widow;

	public WebElement getPartner_marital_status_widow() {
		return partner_marital_status_widow;
	}
	
	@FindBy(xpath="//*[@text='Divorced']")
	private WebElement partner_marital_status_Divorced;

	public WebElement getPartner_marital_status_Divorced() {
		return partner_marital_status_Divorced;
	}
	
	@FindBy(xpath="//*[@text='Separated']")
	private WebElement partner_marital_status_seperated;

	public WebElement getPartner_marital_status_seperated() {
		return partner_marital_status_seperated;
	}
	
	
	@FindBy(xpath="//*[@id='search_ok_imageView']")
	private WebElement partner_marital_status_confirmbtn;

	public WebElement getPartner_marital_status_confirmbtn() {
		return partner_marital_status_confirmbtn;
	}
	
	@FindBy(xpath="//*[@id='edit_partner_txt_age_from_value']")
	private WebElement partner_age_from_btn;

	public WebElement getPartner_age_from_btn() {
		return partner_age_from_btn;
	}
	
	@FindBy(xpath="//*[@id='edit_partner_txt_age_to_value']")
	private WebElement partner_age_To_btn;

	public WebElement getPartner_age_To_btn() {
		return partner_age_To_btn;
	}
	
	@FindBy(xpath="//*[@id='edit_partner_txt_height_from_value']")
	private WebElement partner_Height_from_btn;

	public WebElement getPartner_Height_from_btn() {
		return partner_Height_from_btn;
	}
	
	@FindBy(xpath="//*[@id='edit_partner_txt_height_to_value']")
	private WebElement partner_Height_To_btn;

	public WebElement getPartner_Height_To_btn() {
		return partner_Height_To_btn;
	}
	
	@FindBy(xpath="//*[@id='edit_partner_txt_mother_tongue_value']")
	private WebElement partner_mother_tongue_btn;

	public WebElement getPartner_mother_tongue_btn() {
		return partner_mother_tongue_btn;
	}
	
	
	@FindBy(xpath="//*[@id='edit_partner_txt_physical_status_value']")
	private WebElement partner_physical_status_btn;

	public WebElement getPartner_physical_status_btn() {
		return partner_physical_status_btn;
	}
	
	
	@FindBy(xpath="//*[@id='reg_search_editText']")
	private WebElement partner_search_btn;

	//*[@id='edit_txt_partner_income_to_value']


	public WebElement getPartner_search_btn() {
		return partner_search_btn;
	}
	
	@FindBy(xpath="//*[@id='value_textView']")
	private WebElement partner_search_value_click;

	public WebElement getPartner_search_value_click() {
		return partner_search_value_click;
	}
	
	
	@FindBy(xpath="//*[@id='partnerreligious_edit']")
	private WebElement partner_releigious_prefe_btn;

	public WebElement getPartner_releigious_prefe_btn() {
		return partner_releigious_prefe_btn;
	}
	
	
	@FindBy(xpath="//*[@id='edit_txt_partner_subcaste_value']")
	private WebElement partner_subcaste_btn;
	
	public WebElement getPartner_subcaste_btn() {
		return partner_subcaste_btn;
	}
	
	@FindBy(xpath="//*[@id='edit_txt_partner_star_value']")
	private WebElement partner_star_btn;

	public WebElement getPartner_star_btn() {
		return partner_star_btn;
	}
	
	@FindBy(xpath="//*[@id='edit_txt_partner_dhosam_value']")
	private WebElement partner_Dosham_btn;

	public WebElement getPartner_Dosham_btn() {
		return partner_Dosham_btn;
	}
	 
	@FindBy(xpath="//*[@id='search_editText']")
	private WebElement partner_search2_btn;

	public WebElement getPartner_search2_btn() {
		return partner_search2_btn;
	}
	
	@FindBy(xpath="//*[@id='partnerprofessional_edit']")
	private WebElement partner_professional_btn;

	public WebElement getPartner_professional_btn() {
		return partner_professional_btn;
	}
	
	@FindBy(xpath="//*[@id='edit_txt_partner_education_str_value']")
	private WebElement partner_education_btn;

	public WebElement getPartner_education_btn() {
		return partner_education_btn;
	}
	
	@FindBy(xpath="//*[@id='edit_txt_partner_occupation_str_value']")
	private WebElement partner_occupation_btn;

	public WebElement getPartner_occupation_btn() {
		return partner_occupation_btn;
	}
	
	@FindBy(xpath="//*[@id='edit_txt_partner_income_from_value']")
	private WebElement partner_annual_INcome_btn;

	public WebElement getPartner_annual_INcome_btn() {
		return partner_annual_INcome_btn;
	}
	
	@FindBy(xpath="//*[@id='partnerlocation_edit']")
	private WebElement partner_location_btn;

	public WebElement getPartner_location_btn() {
		return partner_location_btn;
	}
 
	@FindBy(xpath="//*[@id='edit_txt_partner_country_value']")
	private WebElement partner_country_btn;

	public WebElement getPartner_country_btn() {
		return partner_country_btn;
	}
	
	@FindBy(xpath="//*[@id='edit_txt_partner_citizenship_value']")
	private WebElement partner_citizenship_btn;

	public WebElement getPartner_citizenship_btn() {
		return partner_citizenship_btn;
	}
	
	@FindBy(xpath="//*[@id='partnerhabits_edit']")
	private WebElement partner_habits_btn;

	public WebElement getPartner_habits_btn() {
		return partner_habits_btn;
	}
	
	@FindBy(xpath="//*[@id='edit_edt_partner_eating_habits_value']")
	private WebElement partner_Eating_habits_btn;

	public WebElement getPartner_Eating_habits_btn() {
		return partner_Eating_habits_btn;
	}
	
	@FindBy(xpath="//*[@id='edit_edt_partner_drinking_habits_value']")
	private WebElement partner_drinking_habits_btn;

	public WebElement getPartner_drinking_habits_btn() {
		return partner_drinking_habits_btn;
	}
	
	@FindBy(xpath="//*[@id='edit_edt_partner_smoking_habits_value']")
	private WebElement partner_smoking_habits_btn;

	public WebElement getPartner_smoking_habits_btn() {
		return partner_smoking_habits_btn;
	}
	
	
	public WebElement getPartner_Annual_Income_Value_btn() {
		return partner_Annual_Income_Value_btn;
	}

	@FindBy(xpath="//*[@id='edit_txt_partner_income_to_value']")
	private WebElement partner_Annual_Income_Value_btn;

	
    @FindBy(xpath="//*[@id='edit_txt_partner_resident_indian_state_value']")
    private WebElement partner_residing_state;

	public WebElement getPartner_residing_state() {
		return partner_residing_state;
	}
	 
	 @FindBy(xpath="//*[@text='Account Settings']")
	    private WebElement Account_settings;

	public WebElement getAccount_settings() {
		return Account_settings;
	}
	
	@FindBy(xpath="//*[@text='Logout']")
    private WebElement logout;

	public WebElement getLogout() {
		return logout;
	}
	
	@FindBy(xpath="//*[@contentDescription='Navigate up']")
    private WebElement editpp_back_btn;

	public WebElement getEditpp_back_btn() {
		return editpp_back_btn;
	}
	
	
	public WebElement getMatches_btn() {
		return matches_btn;
	}

	@FindBy(xpath="//*[@text='Matches']")
    private WebElement matches_btn;

	
}
