package Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class Login {
	static IOSDriver<IOSElement> driver;

	public Login(IOSDriver<IOSElement> driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@text='LOGIN']")
	private WebElement login1;

	public WebElement getLogin1() {
		return login1;
	}

	@FindBy(xpath = "//*[@placeholder='Matrimony ID/ E-mail ID']")
	private WebElement matriId;

	public WebElement getMatriId() {
		return matriId;
	}

	@FindBy(xpath = "//*[@placeholder='Password']")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(xpath = "//*[@text='Login' and @class='UIAButton']")
	private WebElement login2;

	public WebElement getLogin2() {
		return login2;
	}

	@FindBy(xpath = "//*[@id='Menu']")
	private WebElement menu;

	public WebElement getMenu() {
		return menu;
	}
public void loginTest() {
		// ****Login to the App
		getLogin1().click();
		getMatriId().sendKeys("AGR100173");
		getPassword().sendKeys("cbstest");
		getLogin2().click();
	}
	
	public static void loginTest(String matriId, String pwd) {
		Login login=new Login(driver);
		login.getLogin1().click();
		login.getMatriId().sendKeys(matriId);
		login.getPassword().sendKeys(pwd);
		login.getLogin2().click();
	}

	public IOSDriver<IOSElement> getDriver() {
		return driver;
	}
}

