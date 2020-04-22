package testscripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Dashboard_Pom {
	
	AndroidDriver driver;

	public Dashboard_Pom(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//*********horoscope****************//
	@FindBy(xpath = "//*[@text='ADD HOROSCOPE']")
	private WebElement Add_Horoscope_btn;
	
	@FindBy(xpath = "//*[@id='spinHour']")
	private WebElement Edit_hour_txt;
	
	@FindBy(xpath="//*[@id='spinMin']")
	private WebElement Edit_min_txt;
	
	@FindBy(xpath="//*[@id='spinMeridiem']")
	private WebElement Edit_Am_pm_txt;
	
	@FindBy(xpath="//*[@id='tvCountry']")
	private WebElement Edit_country_txt;
	
	@FindBy(xpath="//*[@id='tvState']")//*[@id='tvState']
	private WebElement Edit_state_txt;
	
	@FindBy(xpath="//*[@id='tvCity']")
	private WebElement Edit_city_txtt;

	@FindBy(xpath="//*[@id='tvChartStyle']")
	private WebElement Edit_chart_txt;

	@FindBy(xpath="//*[@id='btnGenerateHoroscope']")
	private WebElement Generate_horoscope;

	@FindBy(xpath="//*[@text='ADD DETAILS']")
	private WebElement Add_details_btn;
	
	//**********************add photo*******************//
	
	@FindBy(xpath="//*[@text='ADD PHOTO']")
	private WebElement Add_photo_btn;
	
	@FindBy(xpath="//*[@text='Choose from Gallery']")
	private WebElement choose_gallery_option;

	@FindBy(xpath="//*[@id='icon' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='Gallery']]]")
	private WebElement gallery_btn;
	
	@FindBy(xpath="//*[@text='Photos']")
	private WebElement photos_btn;
	
	
	
	
	//*****************getters*********************//
	
	
	public AndroidDriver getDriver() {
		return driver;
	}

	public WebElement getPhotos_btn() {
		return photos_btn;
	}

	public WebElement getAdd_Horoscope_btn() {
		return Add_Horoscope_btn;
	}

	public WebElement getEdit_hour_txt() {
		return Edit_hour_txt;
	}

	public WebElement getEdit_min_txt() {
		return Edit_min_txt;
	}

	public WebElement getEdit_Am_pm_txt() {
		return Edit_Am_pm_txt;
	}

	public WebElement getEdit_country_txt() {
		return Edit_country_txt;
	}

	public WebElement getEdit_state_txt() {
		return Edit_state_txt;
	}

	public WebElement getEdit_city_txtt() {
		return Edit_city_txtt;
	}

	public WebElement getEdit_chart_txt() {
		return Edit_chart_txt;
	}

	public WebElement getGenerate_horoscope() {
		return Generate_horoscope;
	}

	public WebElement getAdd_details_btn() {
		return Add_details_btn;
	}

	public WebElement getAdd_photo_btn() {
		return Add_photo_btn;
	}

	public WebElement getChoose_gallery_option() {
		return choose_gallery_option;
	}

	public WebElement getGallery_btn() {
		return gallery_btn;
	}

	@FindBy(xpath="//*[@id='mTxtAction2']")
	private WebElement db_viewedur_profile_viewal_btn;
	public WebElement getDb_viewedur_profile_viewal_btn() {
		return db_viewedur_profile_viewal_btn;
	}
	

	@FindBy(xpath="//*[@text='Upgrade Now']")
	private WebElement upgrade_now_btn;
	public WebElement getUpgrade_now_btn() {
		return upgrade_now_btn;
	}
	

	@FindBy(xpath="//*[@id='mTxtAction1']")
	private WebElement respond_nw_btn;

	public WebElement getRespond_nw_btn() {
		return respond_nw_btn;
	}

	/*@FindBy(xpath="//*[@id='tvChartStyle']")
	private WebElement Edit_Number_txt_submit;
*/












}









