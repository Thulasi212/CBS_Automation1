package CBS;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class EditProfilePage {
	IOSDriver<IOSElement> driver;

	public EditProfilePage(IOSDriver<IOSElement> driver) {
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//*[@text='Menu']")
	private WebElement leftMenu;

	public WebElement leftMenu() {
		return leftMenu;
	}
	
	@FindBy(xpath = "//*[@text='Edit Profile']")
	private WebElement editProfile;
	public WebElement getEditProfile() {
		return editProfile;
	}
	
	@FindBy(xpath = "//*[@id='Partner Preference']")
	private WebElement editPP;
	public WebElement getEditPP() {
		return editPP;
	}
	
	
	@FindBy(xpath = "//*[@class='UIAButton' and ./parent::*[@accessibilityLabel='RELIGIOUS INFORMATION']]")
	private WebElement editReligiousInfo;
	public WebElement getEditReligiousInfo() {
		return editReligiousInfo;
	}
	
	@FindBy(xpath="//*[@class='UIAView' and @height>0 and ./*[@id='Star']]")
	private WebElement starEdit;
	public WebElement getStarEdit() {
		return starEdit;
	}
	@FindBy(xpath="//*[@id='Mother Tongue']/following-sibling::*")
	private WebElement mTongueValue;
	public WebElement getMotherTongueValue() {
		return mTongueValue;
	}
	@FindBy(xpath="(//*[@id='Search for Star'])[2]")
	private WebElement starSearch;
	public WebElement getStarSearch() {
		return starSearch;
	}

	@FindBy(xpath="//*[@XCElementType='XCUIElementTypeStaticText']")
	private WebElement starSearchValue;
	public WebElement getStarSearchValue() {
		return starSearchValue;
	}
	@FindBy(xpath="//*[@id='close 1']")
	private WebElement qResponseClose;
	public WebElement getQuickResponseClose() {
		return qResponseClose;
	}
	
	@FindBy(xpath="//*[@class='UIAView' and @height>0 and ./*[@id='Raasi']]")
	private WebElement raasiEdit;
	public WebElement getRaasiEdit() {
		return raasiEdit;
	}
	
	
	
	
}
