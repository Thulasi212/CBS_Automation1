package CBS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class IntermediatePage {
	IOSDriver<IOSElement> driver;

	public IntermediatePage(IOSDriver<IOSElement> driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='Skip']")
	private WebElement addPhoto_skip;

	public WebElement getAddPhoto_skip() {
		return addPhoto_skip;
	}

	@FindBy(xpath = "//*[@id='Yes']")
	private WebElement addPhoto_yes;

	public WebElement getAddPhoto_yes() {
		return addPhoto_yes;
	}

	public IOSDriver<IOSElement> getDriver() {
		return driver;
	}

}
//*[@id='Yes']