package CBS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class AddPhotoPage {
	IOSDriver<IOSElement> driver;

	public AddPhotoPage(IOSDriver<IOSElement> driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='Add Photo']")
	private WebElement avatarButton_Int;
	public WebElement getAvatarButton_Int() {
		return avatarButton_Int;
	}
	@FindBy(xpath = "//*[@id='Add Photo']")
	private WebElement addPhto;
	public WebElement getAddPhto() {
		return addPhto;
	}
	
	@FindBy(xpath = "//*[@id='Choose Photo']")
	private WebElement choosePhoto;
	public WebElement getChoosePhoto() {
		return choosePhoto;
	}
	
	
	
	@FindBy(xpath = "//*[@id='Selfies']")
	private WebElement photoSource;
	public WebElement getPhotoSource() {
		return photoSource;
	}
	
	@FindBy(xpath = "//*[@id='Choose']")
	private WebElement choose;
	public WebElement getChoose() {
		return choose;
	}
	
	@FindBy(xpath = "//*[@id='Save']")
	private WebElement save;
	public WebElement getSave() {
		return save;
	}
	
	@FindBy(xpath = "//*[@id='Cancel']")
	private WebElement cancel1;
	public WebElement getcancel1() {
		return cancel1;
	}

	@FindBy(xpath = "//*[@id='Skip']")
	private WebElement skip;
	public WebElement getSkip() {
		return skip;
	}
	
	
	
	
	
	
}
