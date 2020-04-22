package CBS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class ContentPage {
	IOSDriver<IOSElement> driver;

	public ContentPage(IOSDriver<IOSElement> driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@text='Edit Profile']")
	private WebElement editProfile;

	public WebElement getEditProfile() {
		return editProfile;
	}
	

}
