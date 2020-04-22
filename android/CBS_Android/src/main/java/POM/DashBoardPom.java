package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class DashBoardPom extends BaseTest{
	
	
	public DashBoardPom(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Profile awaiting Response
	
	@FindBy(xpath="//*[@id='profileMatriId']")
	private WebElement matriID;
	
	
	@FindBy(xpath="//*[@id='tv_int_declineLayout' and ./*[@width>0]]")
	private WebElement decline;
	
	
	@FindBy(xpath="//*[@id='tv_shortlistLayout' and @width>0]")
	private WebElement shortlist;
	
	
	@FindBy(xpath="//*[@id='tv_int_acceptLayout' and @width>0]")
	private WebElement accept;
	
	
	@FindBy(xpath="//*[@text='Profile(s) awaiting Response']")
	private WebElement profile_awaiting;


	
	@FindBy(xpath="//*[@id='popup_close_btn']")
	private WebElement accept_popup_close;
	
	
	@FindBy(xpath="//*[@id='tv_shortlistLayout' and @width>0]")
	private WebElement shortlisted_profile;
	
	
	@FindBy(xpath="//*[@text='Confirm']")
	private WebElement decline_confirm_btn;
	
	//////////////////////////////////////////////////
	
	
	@FindBy(xpath="//*[@text='Photo Requests Received']")
	private WebElement photo_request;
	
	
	@FindBy(xpath="//*[@text='Add Photo' and @width>0]")
	private WebElement Add_Photo;
	
	
	@FindBy(xpath="//*[@text='Add Photo']")
	private WebElement Add_Photo_folder;
	
	
	
	@FindBy(xpath="//*[@text='Take a Picture']")
	private WebElement take_picture;
	
	
	@FindBy(xpath="//*[@text='Choose from Gallery']")
	private WebElement choose_galeery;
	
	
	
	@FindBy(xpath="//*[@id='v9_shutter_button_internal']")
	private WebElement camera_click;
	
	
	@FindBy(xpath="//*[@id='inten_done_apply']")
	private WebElement photo_confirm;

	
	@FindBy(xpath="//*[@id='icon' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='Gallery']]]")
	private WebElement gallery_photo_choose;
	
	
	
	@FindBy(xpath="//*[@text='Photos']")
	private WebElement photo_;
	
	
	@FindBy(xpath="//*[@id='micro_thumb' and ./parent::*[@contentDescription='Photo taken on 11 February, 2019 19:35:22']]")
	private WebElement photo_from_gallery;
	
	
	@FindBy(xpath="//*[@text='Upgrade Now']")
	private WebElement accepted_matches_upgrade;
	
	
	public WebElement getAccepted_matches_upgrade() {
		return accepted_matches_upgrade;
	}


	public WebElement getPhoto_from_gallery() {
		return photo_from_gallery;
	}


	public WebElement getPhoto_request() {
		return photo_request;
	}


	public WebElement getAdd_Photo() {
		return Add_Photo;
	}


	public WebElement getAdd_Photo_folder() {
		return Add_Photo_folder;
	}


	public WebElement getTake_picture() {
		return take_picture;
	}


	public WebElement getChoose_galeery() {
		return choose_galeery;
	}


	public WebElement getCamera_click() {
		return camera_click;
	}


	public WebElement getPhoto_confirm() {
		return photo_confirm;
	}


	public WebElement getGallery_photo_choose() {
		return gallery_photo_choose;
	}


	public WebElement getPhoto_() {
		return photo_;
	}


	public WebElement getDecline_confirm_btn() {
		return decline_confirm_btn;
	}


	public WebElement getShortlisted_profile() {
		return shortlisted_profile;
	}


	public WebElement getMatriID() {
		return matriID;
	}


	public WebElement getAccept_popup_close() {
		return accept_popup_close;
	}


	public WebElement getDecline() {
		return decline;
	}


	public WebElement getShortlist() {
		return shortlist;
	}


	public WebElement getAccept() {
		return accept;
	}


	public WebElement getProfile_awaiting() {
		return profile_awaiting;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	

}









