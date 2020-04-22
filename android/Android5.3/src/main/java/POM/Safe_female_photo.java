package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class Safe_female_photo {
	public Safe_female_photo(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id='selfImageView']")
	private WebElement photo_img;
	
	@FindBy(xpath="//*[@id='matriid_from_login_layout']")
	private WebElement Enter_Matrid;

	public WebElement getPhoto_img() {
		return photo_img;
	}

	public WebElement getEnter_Matrid() { 
		return Enter_Matrid;
	}
}