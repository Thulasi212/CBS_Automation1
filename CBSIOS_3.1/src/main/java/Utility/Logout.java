package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class Logout {
	IOSDriver<IOSElement> driver;

	public Logout(IOSDriver<IOSElement> driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@text='Menu']")
	public static WebElement leftMenu;
	
	@FindBy(xpath = "//*[@id='Settings']")
	public static WebElement settings;
	
	@FindBy(xpath = "//*[@id='Account']")
	public static WebElement account;
	
	@FindBy(xpath = "//*[@id='Logout']")
	public static WebElement logout;
	
	@FindBy(xpath = "//*[@id='Yes']")
	public static WebElement confirYes;
	
	public static void logoutTest() throws Exception {
		leftMenu.click();
		System.out.println("Clicked on Menu");
		Thread.sleep(3000);
		settings.click();
		System.out.println("Clicked on settings");
		account.click();
		System.out.println("Clicked on Account");
		logout.click();
		Thread.sleep(3000);
		System.out.println("Clicked on logout");
		confirYes.click();
		System.out.println("logout  successfully");
		
	}
	
	
	
	
	
	

}
