package CBS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class EditPP {
	IOSDriver<IOSElement> driver;

	public EditPP(IOSDriver<IOSElement> driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@text='Edit Profile']")
	private WebElement editProfile;

	public WebElement getEditProfile() {
		return editProfile;
	}

	@FindBy(xpath = "//*[@text='Partner Preference']")
	private WebElement editPP;

	public WebElement getEditPP() {
		return editPP;
	}

	@FindBy(xpath = "//*[@class='UIAButton' and ./parent::*[@text='BASIC DETAILS']]")
	private WebElement basicDetailsEdit;

	public WebElement getBasicDetailsEdit() {
		return basicDetailsEdit;
	}

	@FindBy(xpath = "//*[@text='Age']/following-sibling::*")
	private WebElement age;

	public WebElement getAge() {
		return age;
	}

	@FindBy(xpath = "(//*[@text='Age From']/following-sibling::*)[3]")
	private WebElement ageFrom;

	public WebElement getAgeFrom() {
		return ageFrom;
	}

	@FindBy(xpath = "(//*[@text='Age To']/following-sibling::*)[3]")
	private WebElement ageTo;

	public WebElement getAgeTo() {
		return ageTo;
	}

	@FindBy(xpath = "(//*[@text='Height From']/following-sibling::*)[3]")
	private WebElement heightFrom;

	public WebElement getHeightFrom() {
		return heightFrom;
	}

	@FindBy(xpath = "(//*[@text='Height To']/following-sibling::*)[3]")
	private WebElement heightTo;

	public WebElement getHeightTo() {
		return heightTo;
	}

	@FindBy(xpath = "(//*[@text='Partner Marital Status']//following-sibling::*)[3]")
	private WebElement mStatus;

	public WebElement getMaritalStatus() {
		return mStatus;
	}

	@FindBy(xpath = "//*[@id=' Back']")
	private WebElement back_PP;

	public WebElement getBack_PP() {
		return back_PP;
	}

	@FindBy(xpath = "//*[@id='Dhosam']/following-sibling::*")
	private WebElement dosham;

	public WebElement getDosham() {
		return dosham;
	}

	//

}
