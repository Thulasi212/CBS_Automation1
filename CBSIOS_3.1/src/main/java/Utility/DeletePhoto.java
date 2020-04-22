package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeletePhoto {
	
	@FindBy(xpath = "//*[@text='Menu']")
	public static WebElement leftMenu;
	
	@FindBy(xpath = "//*[@id='Edit Profile']")
	public static WebElement editProfile;
	
	@FindBy(xpath = "//*[@class='UIAImage' and ./parent::*[@class='UIAScrollView']]")
	public static WebElement profilePhoto;
	
	@FindBy(xpath = "(//*[@class='UIACollectionView']/*/*/*[@class='UIAImage'])[1]")
	public static WebElement photo;
	
	@FindBy(xpath = "//*[@id='DELETE']")
	public static WebElement delete ;
	
	@FindBy(xpath = "//*[@id=' Back']")
	public static WebElement back ;
	
	public static void deletePhotoTest() throws Exception {
		System.out.println("Deleting the Profile...");
		leftMenu.click();
		System.out.println("clicked on Left menu");
		Thread.sleep(3000);
		editProfile.click();
		Thread.sleep(2000);
		profilePhoto.click();
		Thread.sleep(4000);
		photo.click();
		Thread.sleep(2000);	
		delete.click();
		Thread.sleep(5000);
		back.click();
		Thread.sleep(5000);
		back.click();
		
	}

}
