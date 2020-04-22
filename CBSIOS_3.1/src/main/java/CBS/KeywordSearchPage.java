package CBS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class KeywordSearchPage {
	IOSDriver<IOSElement> driver;

	public KeywordSearchPage(IOSDriver<IOSElement> driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='Search']")
	private WebElement search;

	public WebElement getSearch() {
		return search;
	}

	@FindBy(xpath = "//*[@id='Keyword Search']")
	private WebElement keywordSearch;

	public WebElement getKeywordSearch() {
		return keywordSearch;
	}

	@FindBy(xpath = "//*[contains(text(),'Martial Status')]")
	private WebElement defaultValues;

	public WebElement getDefaultValues() {
		return defaultValues;
	}

	@FindBy(xpath = "//*[@id='Edit']")
	private WebElement keyEdit;

	public WebElement getKeyEdit() {
		return keyEdit;
	}

	@FindBy(xpath = "(//*[@text='arrow' and (./preceding-sibling::* | ./following-sibling::*)[@text='Age : ']])[1]")
	private WebElement ageArrow;

	public WebElement getAgeArrow() {
		return ageArrow;
	}

	@FindBy(xpath = "((//*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView']]]]/*/*[@class='UIAPicker'])[1]/*[@class='UIAPickerWheel'])[2]")
	private WebElement ageFrom;

	public WebElement getAgeFrom() {
		return ageFrom;
	}

	@FindBy(xpath = "((//*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView']]]]/*/*[@class='UIAPicker'])[2]/*[@class='UIAPickerWheel'])[2]")
	private WebElement ageTo;

	public WebElement getAgeTo() {
		return ageTo;
	}

	@FindBy(xpath = "//*[@id=' Back']")
	private WebElement back_AgePage;

	public WebElement getBack_AgePage() {
		return back_AgePage;
	}

	@FindBy(xpath = "(//*[@text='arrow' and (./preceding-sibling::* | ./following-sibling::*)[@text='Height : ']])[1]")
	private WebElement htArrow;

	public WebElement getHeightArrow() {
		return htArrow;
	}

	@FindBy(xpath = "((//*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView']]]]/*/*[@class='UIAPicker'])[1]/*[@class='UIAPickerWheel'])[2]")
	private WebElement htFrom;

	public WebElement getHeightFrom() {
		return htFrom;
	}

	@FindBy(xpath = "((//*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView' and ./parent::*[@class='UIAView']]]]/*/*[@class='UIAPicker'])[2]/*[@class='UIAPickerWheel'])[2]")
	private WebElement htTo;

	public WebElement getHeightTo() {
		return htTo;
	}

	@FindBy(xpath = "//*[@id=' Back']")
	private WebElement back_htPage;

	public WebElement getBack_HeightPage() {
		return back_htPage;
	}

	@FindBy(xpath = "(//*[@class='UIATable']/*/*[@accessibilityLabel='arrow' and (./preceding-sibling::* | ./following-sibling::*)[@id='Marital Status : ']])[1]")
	private WebElement mTArrow;

	public WebElement getMStatusArrow() {
		return mTArrow;
	}

	@FindBy(xpath = "(//*[@id='Marital Status : ']//following-sibling::*)[3]")
	private WebElement mT;

	public WebElement getMaritalStatus() {
		return mT;
	}

	@FindBy(xpath = "(//*[@id='Dosham : ']/following-sibling::*)[1]")
	private WebElement dosham;

	public WebElement getDosham() {
		return dosham;
	}

	@FindBy(xpath = "//*[text()='Already Viewed, Shortlisted, Already Contacted, Ignored']/following-sibling::*")
	private WebElement doNotShowprofiles;

	public WebElement getDoNotShowprofiles() {
		return doNotShowprofiles;
	}

	@FindBy(xpath = "//*[@placeholder='eg : Kanada, Doctor, Delhi']")
	private WebElement seachBox;

	public WebElement getSeachBox() {
		return seachBox;
	}

	@FindBy(xpath = "((//*[@class='UIATable']/*[@class='UIAView'])[2]/*[@class='UIAButton'])[1]")
	private WebElement seachIcon;

	public WebElement getKeywordSeachIcon() {
		return seachIcon;
	}

	@FindBy(xpath = "(//*[@XCElementType='XCUIElementTypeStaticText'])[8]")
	private WebElement vpLink;

	public WebElement getVpLink() {
		return vpLink;
	}

	@FindBy(xpath = "//*[@id='arrow Rr']")
	private WebElement vpRightArrow;

	public WebElement getVpRtArrow() {
		return vpRightArrow;
	}

	@FindBy(xpath = "//*[@id='Cancel']")
	private WebElement cancel;

	public WebElement getCancel() {
		return cancel;
	}

	@FindBy(xpath = "//*[@text='Done']")
	private WebElement mStatus_Done;

	public WebElement getMStatus_Done() {
		return mStatus_Done;
	}

	@FindBy(xpath = "//*[@text='Any']")
	private WebElement mStatus_Any;

	public WebElement getMStatus_Any() {
		return mStatus_Any;
	}

	@FindBy(xpath = "//*[@id='Unmarried']")
	private WebElement mStatus_Unmarried;

	public WebElement getMStatus_Unmarried() {
		return mStatus_Unmarried;
	}

	@FindBy(xpath = "//*[@id='Widow / Widower']")
	private WebElement mStatus_Wid;

	public WebElement getMStatus_Wid() {
		return mStatus_Wid;
	}

	@FindBy(xpath = "//*[@id='Divorced']")
	private WebElement mStatus_Div;

	public WebElement getMStatus_Div() {
		return mStatus_Div;
	}

	@FindBy(xpath = "//*[@id='Separated']")
	private WebElement mStatus_Sep;

	public WebElement getMStatus_Sep() {
		return mStatus_Sep;
	}

	@FindBy(xpath = "//*[@id='Please select Marital Status']")
	private WebElement mS_Notselect_confMsg;

	public WebElement getMS_Notselect_confMsg() {
		return mS_Notselect_confMsg;
	}

	@FindBy(xpath = "//*[@id='Ok']")
	private WebElement mS_Notselect_confOk;

	public WebElement getmS_Notselect_confOk() {
		return mS_Notselect_confOk;
	}

	@FindBy(xpath = "(//*[@class='UIATable']/*/*[@accessibilityLabel='arrow' and (./preceding-sibling::* | ./following-sibling::*)[@id='Dosham : ']])[1]")
	private WebElement doshamArrow;

	public WebElement getDoshamArrow() {
		return doshamArrow;
	}

	@FindBy(xpath = "//*[@id='Yes']")
	private WebElement dosham_Yes;

	public WebElement getDosham_Yes() {
		return dosham_Yes;
	}

	@FindBy(xpath = "//*[@id='No']")
	private WebElement dosham_No;

	public WebElement getDosham_No() {
		return dosham_No;
	}

	@FindBy(xpath = "(//*[@class='UIAStaticText'])[3]")
	private WebElement dosham_DoesMatt;

	public WebElement getDosham_DoesMatt() {
		return dosham_DoesMatt;
	}

	@FindBy(xpath = "//*[@text='tick']")
	private WebElement dosham_Tick;

	public WebElement getDosham_Tick() {
		return dosham_Tick;
	}

	@FindBy(xpath = "//*[@id='Done']")
	private WebElement dosham_Done;

	public WebElement getDosham_Done() {
		return dosham_Done;
	}

	@FindBy(xpath = "(//*[@id='arrow'])[5]")
	private WebElement doNotShowProf;

	public WebElement getDoNotShowProf() {
		return doNotShowProf;
	}

	@FindBy(xpath = "//*[@id='Already Viewed']")
	private WebElement viewed;

	public WebElement getDoNotShowProf_viewed() {
		return viewed;
	}

	@FindBy(xpath = "//*[@id='Already Contacted']")
	private WebElement contacted;

	public WebElement getDoNotShowProf_contacted() {
		return contacted;
	}

	@FindBy(xpath = "//*[@id='Shortlisted']")
	private WebElement shortlisted;
	public WebElement getDoNotShowProf_shortlisted() {
		return shortlisted;
	}

	@FindBy(xpath = "//*[@id='Ignored']")
	private WebElement ignored;

	public WebElement getDoNotShowProf_ignored() {
		return ignored;
	}

	public IOSDriver<IOSElement> getDriver() {
		return driver;
	}
}
