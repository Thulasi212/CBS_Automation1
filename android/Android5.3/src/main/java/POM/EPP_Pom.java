package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EPP_Pom {
	public EPP_Pom(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@id='ln_editProfile_partner']")
	private WebElement epp;
	
	public WebElement getEditPP() {
		return epp;
	}
	
	
	@FindBy(xpath="//*[@id='partnerreligious_edit']")
	private WebElement partnerReligious_Edit;
	
	public WebElement getPartnerReligious_Edit() {
		return partnerReligious_Edit;
	}
	
	@FindBy(xpath="//*[@id='edit_txt_partner_gothram_value']")
	private WebElement partnerGothra_Edit;
	
	public WebElement getPartnerGothra_Edit() {
		return partnerGothra_Edit;
	}
	
	@FindBy(xpath="//*[@text='All Except My Gothra(m)' and @top='true']")
	private WebElement partnerGothra_AllExcept;
	public WebElement getPGothra_AllExceptMy() {
		return partnerGothra_AllExcept;
	}
	
	@FindBy(xpath="//*[@text='Submit']")
	private WebElement partnerGothra_Submit;
	public WebElement getPartnerGothra_Submit() {
		return partnerGothra_Submit;
	}
	
	@FindBy(xpath="//*[@text='Save']")
	private WebElement partnerGothra_Save;
	public WebElement getPartnerGothra_Save() {
		return partnerGothra_Save;
	}
	
	@FindBy(xpath="//*[@text='Save']")
	private WebElement ppGothram;
	public WebElement getPP_Gothram() {
		return ppGothram;
	}
	
	@FindBy(xpath="//*[@id='ln_editProfile']")
	private WebElement editProfile;
	public WebElement getEditProfile() {
		return editProfile;
	}
	
	@FindBy(xpath="//*[@id='religiousdetails_edit']")
	private WebElement religiousEdit_PI;
	public WebElement getReligiousEdit_PI() {
		return religiousEdit_PI;
	}
	
	@FindBy(xpath="//*[@id='edit_txt_gothram_value']")
	private WebElement gothram_PI;
	public WebElement getGothram_PI() {
		return gothram_PI;
	}
	
	@FindBy(xpath="//*[text()='Search']")
	private WebElement search;
	public WebElement getSearch() {
		return search;
	}
	
	@FindBy(xpath="//*[@id='search_now_imageView']")
	private WebElement searchNow;
	public WebElement getSearchNow() {
		return searchNow;
	}
	
	@FindBy(xpath="(//*[@text='Gothra']/following-sibling::*)[2]")
	private WebElement gotham_vp;
	public WebElement getGotham_vp() {
		return gotham_vp;
	}
	@FindBy(xpath="//*[@id='nextprofile']")
	private WebElement nextProfile_btn;
	public WebElement getNextProfile_btn() {
		return nextProfile_btn;
	}
	@FindBy(xpath="//*[@id='imgHoro']")
	private WebElement horoscopeIcon_vp;
	public WebElement getHoroscopeIcon_vp() {
		return horoscopeIcon_vp;
	}
	@FindBy(xpath="//*[@id='reg_search_editText']")
	private WebElement gothramSearch_PI;
	public WebElement getGothramSearch_PI() {
		return gothramSearch_PI;
	}
	
	@FindBy(xpath="//*[@text='JUST JOINED']")
	private WebElement justJoined;
	public WebElement getJustJoined() {
		return justJoined;
	}
	@FindBy(xpath="//*[@text='Home']")
	private WebElement homeIcon;
	public WebElement getHomeIcon() {
		return homeIcon;
	}
	@FindBy(xpath="//*[@id='count']")
	private WebElement profileListCount;
	public WebElement getProfileListCount() {
		return profileListCount;
	}
	@FindBy(xpath="//*[@id='profilematriid']")
	private WebElement matriId_VP;
	public WebElement getMatriId_VP() {
		return matriId_VP;
	}
	@FindBy(xpath="//*[@text='All Except My Gothra(m)']")
	private WebElement gothra_Value1;
	public WebElement getGothra_Value1() {
		return gothra_Value1;
	}
	
	@FindBy(xpath="//*[@id='edit_txt_partner_star_value']")
	private WebElement starEdit;
	public WebElement getStarEdit() {
		return starEdit;
	}
	
	@FindBy(xpath="(//*[@text='Star']/following-sibling::*)[2]")
	private WebElement star_vp;
	public WebElement getStar_vp() {
		return star_vp;
	}
	
	@FindBy(xpath="//*[@id='edit_txt_partner_subcaste_value']")
	private WebElement subcaste_pp;
	public WebElement getSubcaste_pp() {
		return subcaste_pp;
	}
	
	
	@FindBy(xpath="(//*[@text='Subcaste']/following-sibling::*)[2]")
	private WebElement subcaste_vp;
	public WebElement getSubcaste_vp() {
		return subcaste_vp;
	}
	@FindBy(xpath="//*[@id='edit_txt_partner_dhosam_value']")
	private WebElement dosham_pp;
	public WebElement getDosham_pp() {
		return dosham_pp;
	}
	
	@FindBy(xpath="(//*[contains(@text,'Dosham')]/following-sibling::*)[2]")
	private WebElement dosham_vp;
	public WebElement getDosham_vp() {
		return dosham_vp;
	}
	
	@FindBy(xpath="//*[@text='Yes']")
	private WebElement dosham_pp_Yes;
	public WebElement getDosham_pp_Yes() {
		return dosham_pp_Yes;
	}
	@FindBy(xpath="//*[@text='No']")
	private WebElement dosham_pp_No;
	public WebElement getDosham_pp_No() {
		return dosham_pp_No;
	}
	
	@FindBy(xpath="//*[@id='partnerbasicdetail_edit']")
	private WebElement basicDetailsEdit;
	public WebElement getBDetailsEdit() {
		return basicDetailsEdit;
	}
	
	@FindBy(xpath="//*[@id='edit_partner_txt_age_from_value']")
	private WebElement ageFrom;
	public WebElement getAgeFrom() {
		return ageFrom;	
	}
	@FindBy(xpath="//*[@id='edit_partner_txt_age_to_value']")
	private WebElement ageTo;
	public WebElement getAgeTo() {
		return ageTo;	
	}
	
	@FindBy(xpath="//*[@id='edit_partner_txt_height_from_value']")
	private WebElement htFrom;
	public WebElement getHeightFrom() {
		return htFrom;	
	}
	
	@FindBy(xpath="//*[@id='edit_partner_txt_height_to_value']")
	private WebElement htTo;
	public WebElement getHeightTo() {
		return htTo;	
	}
	
	@FindBy(xpath="(//*[text()='Height']/following-sibling::*)[2]")
	private WebElement vpHeight;
	public WebElement getVpHeight() {
		return vpHeight;	
	}
	
	
	@FindBy(xpath="//*[@id='edit_partner_txt_looking_status_value']")
	private WebElement mt;
	public WebElement getMaritalStatus() {
		return mt;	
	}
	

	@FindBy(xpath="(//*[@text='Marital Status']/following-sibling::*)[2]")
	private WebElement vp_mStatus;
	public WebElement getVp_mStatus() {
		return vp_mStatus;	
	}
	
	@FindBy(xpath="//*[@id='edit_partner_txt_mother_tongue_value']")
	private WebElement pp_mTongue;
	public WebElement getPP_mTongue() {
		return pp_mTongue;	
	}
	
	@FindBy(xpath="//*[@id='edit_partner_txt_physical_status_value']")
	private WebElement pp_pStatus;
	public WebElement getPP_pStatus() {
		return pp_pStatus;	
	}
	
	@FindBy(xpath="(//*[@text='Mother Tongue']/following-sibling::*)[2]")
	private WebElement vp_mTongue;
	public WebElement getVp_mTongue() {
		return vp_mTongue;	
	}
	
	@FindBy(xpath="(//*[@text='Physical Status']/following-sibling::*)[2]")
	private WebElement vp_pStatus;
	public WebElement getVP_pStatus() {
		return vp_pStatus;	
	}
	
	@FindBy(xpath="(//*[@text='Division']/following-sibling::*)[2]")
	private WebElement pp_division;
	public WebElement getDivision_pp() {
		return pp_division;	
	}
	
	@FindBy(xpath="(//*[@text='Denomination']/following-sibling::*)[2]")
	private WebElement pp_denomination;
	public WebElement getDenomination_pp() {
		return pp_denomination;	
	}
	
	@FindBy(xpath="(//*[@text='Sect']/following-sibling::*)[2]")
	private WebElement pp_sect;
	public WebElement getSect_pp() {
		return pp_sect;	
	}
	
	
	
	

	
	
	
	
	
	public static double convertFeetandInchesToCentimeter(String feet, String inches) {
  	    double heightInFeet = 0;
  	    double heightInInches = 0;
  	    try {
  	        if (feet != null && feet.trim().length() != 0) {
  	            heightInFeet = Double.parseDouble(feet);
  	        }
  	        if (inches != null && inches.trim().length() != 0) {
  	            heightInInches = Double.parseDouble(inches);
  	        }
  	    } catch (NumberFormatException nfe) {

  	    }
  	    return (heightInFeet * 30.48) + (heightInInches * 2.54);
  	}
	
	
	
	
	
	
	
	
	@FindBy(xpath="//*[@id='reg_search_editText']")
	private WebElement searchAgeF;
	public WebElement getSearchAgeF() {
		return searchAgeF;	
	}
	
	@FindBy(xpath="//*[@id='value_textView']")
	private WebElement selectAgeF;
	public WebElement getSelectAgeF() {
		return selectAgeF;	
	}
	
	@FindBy(xpath="//*[@contentDescription='Navigate up']")
	private WebElement eppBack;
	public WebElement getEppBack() {
		return eppBack;	
	}
	@FindBy(xpath="(//*[@text='Age']/following-sibling::*)[2]")
	private WebElement vp_Age;
	public WebElement getVp_Age() {
		return vp_Age;	
	}
	
	@FindBy(xpath="//*[@contentDescription='Navigate up']")
	private WebElement navigate_back_btn;
	public WebElement getNavigate_back_btn() {
		return navigate_back_btn;
	}
	@FindBy(xpath="//*[@id='imgBasic']")
	private WebElement basicDetailsIcon;
	public WebElement getBasicDetailsIcon() {
		return basicDetailsIcon;
	}
	
	@FindBy(xpath="//*[@id='location_edit']")
	private WebElement locationEdit;
	public WebElement getLocationEdit() {
		return locationEdit;
	}
	
	
	@FindBy(xpath="(//*[@text='Country']/following-sibling::*)[2]")
	private WebElement country_pp;
	public WebElement getPP_Country() {
		return country_pp;
	}
	
	@FindBy(xpath="(//*[@text='Country']/following-sibling::*)[2]")
	private WebElement country_vp;
	public WebElement getVP_Country() {
		return country_vp;
	}
	
	@FindBy(xpath="(//*[@text='State']/following-sibling::*)[2]")
	private WebElement state_pp;
	public WebElement getPP_State() {
		return state_pp;
	}
	
	@FindBy(xpath="(//*[@text='State']/following-sibling::*)[2]")
	private WebElement state_vp;
	public WebElement getVP_State() {
		return state_vp;
	}
	
	@FindBy(xpath="(//*[contains(@text,'City')]/following-sibling::*)[2]")
	private WebElement city_pp;
	public WebElement getPP_City() {
		return city_pp;
	}
	
	@FindBy(xpath="(//*[contains(@text,'City')]/following-sibling::*)[2]")
	private WebElement city_vp;
	public WebElement getVP_City() {
		return city_vp;
	}
	
	@FindBy(xpath="(//*[@text='Citizenship']/following-sibling::*)[2]")
	private WebElement citizenship_pp;
	public WebElement getPP_Citizenship() {
		return citizenship_pp;
	}
	
	@FindBy(xpath="(//*[@text='Citizenship']/following-sibling::*)[2]")
	private WebElement citizenship_vp;
	public WebElement getVP_Citizenship() {
		return citizenship_vp;
	}
	
	@FindBy(xpath="(//*[@text='Resident Status']/following-sibling::*)[2]")
	private WebElement residentStatus_pp;
	public WebElement getPP_ResidentStatus() {
		return residentStatus_pp;
	}
	
	@FindBy(xpath="(//*[@text='Resident Status']/following-sibling::*)[2]")
	private WebElement residentStatus_vp;
	public WebElement getVP_ResidentStatus() {
		return residentStatus_vp;
	}
	
	@FindBy(xpath="(//*[@text='Eating Habits']/following-sibling::*)[2]")
	private WebElement eatingHabits;
	public WebElement getEatingHabits() {
		return eatingHabits;
	}
	
	@FindBy(xpath="(//*[@text='Drinking Habits']/following-sibling::*)[2]")
	private WebElement drikingHabits;
	public WebElement getDrikingHabits() {
		return drikingHabits;
	}
	
	@FindBy(xpath="(//*[@text='Smoking Habits']/following-sibling::*)[2]")
	private WebElement smokingHabits;
	public WebElement getSmokingHabits() {
		return smokingHabits;
	}
	
	
	
	
	
	
	
}
	
