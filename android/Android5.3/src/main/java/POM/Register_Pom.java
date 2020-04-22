package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;

public class Register_Pom {
	public Register_Pom(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//*[@text='Skip']")
	private WebElement skip_btn;
	@FindBy(xpath="//*[@id='tv_signUp']")
	private WebElement signup_btn;
	@FindBy(xpath="//*[@id='reg_community_button']")
	private WebElement community_select_btn;
	@FindBy(xpath="//*[@id='reg_search_editText']")
	private WebElement search_btn;
	@FindBy(xpath="//*[@id='value_textView']")
	private WebElement value_select_btn;
	@FindBy(xpath="//*[@text='Self']")
	private WebElement profile_self_btn;
	@FindBy(xpath="//*[@text='Parents']")
	private WebElement profile_parents_btn;
	@FindBy(xpath="//*[@text='Sibling']")
	private WebElement profile_sibling_btn;
	@FindBy(xpath="//*[@text='Friend']")
	private WebElement profile_friend_btn;
	
	@FindBy(xpath="///*[@text='Relative']")
	private WebElement profile_Relative_btn;
	@FindBy(xpath="//*[@text='Male']")
	private WebElement Gender_male_btn;
	
	@FindBy(xpath="//*[@text='Female']")
	private WebElement Gender_female_btn;
	
	
	@FindBy(xpath="//*[@id='reg_name_editText']")
	private WebElement Enter_name_btn;
	
	
	@FindBy(xpath="//*[@id='cancel']")
	private WebElement cancel_btn;
	
	
	@FindBy(xpath="//*[@id='btn_confirm']")
	private WebElement date_set_btn;
	
	
	@FindBy(xpath="//*[@id='reg_email_editText']")
	private WebElement email_btn;
	
	
	
	@FindBy(xpath="//*[@id='reg_countrycode_editText']")
	private WebElement country_code_btn;
	
	@FindBy(xpath="//*[@id='reg_mobile_editText']")
	private WebElement mobile_num_btn;
	
	@FindBy(xpath="//*[@id='reg_next_button']")
	private WebElement continue_btn;
	
	@FindBy(xpath="//*[@id='reg_mothertongue_editText']")
	private WebElement mothertongue_btn;
	
	@FindBy(xpath="//*[@id='reg_password_editText']")
	private WebElement password_btn;
	
	
	
	public WebElement getPassword_btn() {
		return password_btn;
	}

	public WebElement getEmail_btn() {
		return email_btn;
	}

	public WebElement getCountry_code_btn() {
		return country_code_btn;
	}

	public WebElement getMobile_num_btn() {
		return mobile_num_btn;
	}

	public WebElement getContinue_btn() {
		return continue_btn;
	}

	public WebElement getMothertongue_btn() {
		return mothertongue_btn;
	}

	public WebElement getGender_female_btn() {
		return Gender_female_btn;
	}

	public WebElement getEnter_name_btn() {
		return Enter_name_btn;
	}

	public WebElement getCancel_btn() {
		return cancel_btn;
	}

	public WebElement getDate_set_btn() {
		return date_set_btn;
	}

	public WebElement getSkip_btn() {
		return skip_btn;
	}

	public WebElement getSignup_btn() {
		return signup_btn;
	}

	public WebElement getCommunity_select_btn() {
		return community_select_btn;
	}

	public WebElement getSearch_btn() {
		return search_btn;
	}

	public WebElement getValue_select_btn() {
		return value_select_btn;
	}

	public WebElement getProfile_self_btn() {
		return profile_self_btn;
	}

	public WebElement getProfile_parents_btn() {
		return profile_parents_btn;
	}

	public WebElement getProfile_sibling_btn() {
		return profile_sibling_btn;
	}

	public WebElement getProfile_friend_btn() {
		return profile_friend_btn;
	}

	public WebElement getProfile_Relative_btn() {
		return profile_Relative_btn;
	}

	public WebElement getGender_male_btn() {
		return Gender_male_btn;
	}

	//////////////////2nd PAge Registration////////////////////////////
	
	@FindBy(xpath="//*[@text='Unmarried']")
	private WebElement unmarried_btn;
	
	@FindBy(xpath="//*[@text='Widow/Widower']")
	private WebElement widower_btn;
	
	@FindBy(xpath="//*[@text='Divorced']")
	private WebElement Divorced_btn;
	
	@FindBy(xpath="//*[@text='Separated']")
	private WebElement Separated_btn;

////////////////////3 rd page////////////////////////////
	
	
	
	
	@FindBy(xpath="//*[@id='reg_currency_textView']")
	private WebElement currency_btn;
	
	@FindBy(xpath="//*[@id='etAnnualIncome']")
	private WebElement salary_btn;
	
	@FindBy(xpath="//*[@text='Normal']")
	private WebElement Normal_btn;
	
	
	@FindBy(xpath="//*[@text='Physically Challenged']")
	private WebElement phys_btn;
	
	@FindBy(xpath="//*[@text='Middle Class']")
	private WebElement middleclass_btn;
	
	
	@FindBy(xpath="//*[@text='Upper Middle Class']")
	private WebElement uppermiddle_btn;
	
	@FindBy(xpath="//*[@text='Rich / Affluent']")
	private WebElement rich_btn;
	
	
	@FindBy(xpath="//*[@text='Joint family']")
	private WebElement joint_btn;
	
	
	@FindBy(xpath="//*[@text='Nuclear family']")
	private WebElement nuclear_btn;
	
	
	@FindBy(xpath="//*[@text='Orthodox']")
	private WebElement orthodox_btn;
	
	@FindBy(xpath="//*[@text='Traditional']")
	private WebElement traditional_btn;
	
	@FindBy(xpath="//*[@text='Moderate']")
	private WebElement moderate_bnt;
	
	@FindBy(xpath="//*[@text='Liberal']")
	private WebElement liberal_btn;
	
	@FindBy(xpath="//*[@id='reg_gothram_editText']")
	private WebElement gothram_btn;
	
	@FindBy(xpath="//*[@text='Yes']")
	private WebElement dosham_yes_btn;
	
	@FindBy(xpath="//*[@text='No']")
	private WebElement dosham_no_btn;
	
	@FindBy(xpath="//*[@text=concat('Don', \"'\", 't know')]")
	private WebElement dosham_dontknow_btn;
	
	@FindBy(xpath="//*[@id='reg_pagefourthcontinue_button']")
	private WebElement fourthrdpage_continue_btn;
	@FindBy(xpath="//*[@id='reg_pagethirdcontinue_button']")
	private WebElement thirdrdpage_continue_btn;
	/*@FindBy(xpath="//*[@id='reg_pagethirdcontinue_button']")
	private WebElement thirdrdpage_continue_btn;
	@FindBy(xpath="//*[@id='reg_pagethirdcontinue_button']")
	private WebElement thirdrdpage_continue_btn;*/
	
	
	
	
	
	public WebElement getThirdrdpage_continue_btn() {
		return thirdrdpage_continue_btn;
	}

	public WebElement getFourthrdpage_continue_btn() {
		return fourthrdpage_continue_btn;
	}

	public WebElement getDosham_yes_btn() {
		return dosham_yes_btn;
	}

	public WebElement getDosham_no_btn() {
		return dosham_no_btn;
	}

	public WebElement getDosham_dontknow_btn() {
		return dosham_dontknow_btn;
	}

	public WebElement getCurrency_btn() {
		return currency_btn;
	}

	public WebElement getSalary_btn() {
		return salary_btn;
	}

	public WebElement getNormal_btn() {
		return Normal_btn;
	}

	public WebElement getPhys_btn() {
		return phys_btn;
	}

	public WebElement getMiddleclass_btn() {
		return middleclass_btn;
	}

	public WebElement getUppermiddle_btn() {
		return uppermiddle_btn;
	}

	public WebElement getRich_btn() {
		return rich_btn;
	}

	public WebElement getJoint_btn() {
		return joint_btn;
	}

	public WebElement getNuclear_btn() {
		return nuclear_btn;
	}

	public WebElement getOrthodox_btn() {
		return orthodox_btn;
	}

	public WebElement getTraditional_btn() {
		return traditional_btn;
	}

	public WebElement getModerate_bnt() {
		return moderate_bnt;
	}

	public WebElement getLiberal_btn() {
		return liberal_btn;
	}

	public WebElement getGothram_btn() {
		return gothram_btn;
	}

	public WebElement getUnmarried_btn() {
		return unmarried_btn;
	}

	public WebElement getWidower_btn() {
		return widower_btn;
	}

	public WebElement getDivorced_btn() {
		return Divorced_btn;
	}

	public WebElement getSeparated_btn() {
		return Separated_btn;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
}
