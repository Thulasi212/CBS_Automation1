package POM;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EditPI_Page {
	public EditPI_Page(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//*[@contentDescription='Profile']")
	private AndroidElement  profileIcon;
	public AndroidElement getProfileIcon(){
		return profileIcon;
	}
	
	@FindBy(xpath="//*[@text='Edit Profile']")
	private AndroidElement  editProfile;
	public AndroidElement getEditProfile(){
		return editProfile;
	}
	
	@FindBy(xpath="//*[@id='basicdetails_edit']")
	private AndroidElement  basicDetailsEdit;
	public AndroidElement getBasicDetailsEdit(){
		return basicDetailsEdit;
	}
	
	@FindBy(xpath="//*[@id='edit_edt_name_value']")
	private AndroidElement  name;
	public AndroidElement getName(){
		return name;
	}
	
	@FindBy(xpath="//*[@text='Save']")
	private AndroidElement  save;
	public AndroidElement getSave(){
		return save;
	}
	
	@FindBy(xpath="//*[@id='message']")
	private AndroidElement  errorMessage;
	public AndroidElement getErrorMessage(){
		return errorMessage;
	}
	
	@FindBy(xpath="//*[@id='edit_edt_marital_status_value']")
	private AndroidElement  mS;
	public AndroidElement getMaritalStatus(){
		return mS;
	}
	
	@FindBy(xpath="//*[@text='Widower']")
	private AndroidElement  mSValue;
	public AndroidElement getMaritalStatusValue2(){
		return mSValue;
	}
	@FindBy(xpath="//*[@id='edit_txt_no_of_children_value']")
	private AndroidElement  nochildren;
	public AndroidElement getNoChildren(){
		return nochildren;
	}
	
	@FindBy(xpath="(//*[@id='reg_listView']/*/*[@id='value_textView'])[2]")
	private AndroidElement  nochildrenvalue;
	public AndroidElement getNochildrenValue1(){
		return nochildrenvalue;
	}
	
	@FindBy(xpath="//*[@text='OK']")
	private AndroidElement  popup_Ok;
	public AndroidElement getPopup_Ok(){
		return popup_Ok;
	}
	
	@FindBy(xpath="//*[@id='edit_txt_languages_selected_value']")
	private AndroidElement  lan;
	public AndroidElement getlanguagesKnown(){
		return lan;
	}
	@FindBy(xpath="//*[@id='search_editText']")
	private AndroidElement  languagesknownsearch;
	public AndroidElement getLanguagesknownsearch(){
		return languagesknownsearch;
	}
	
	@FindBy(xpath="//*[@text='No Result Found']")
	private AndroidElement  languagesknownErr;
	public AndroidElement getLanguagesknownErr(){
		return languagesknownErr;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
