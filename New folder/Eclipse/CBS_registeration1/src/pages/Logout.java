package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Logout {
	@FindBy(xpath="//span[@class='menu-arrow-off']")
	private WebElement logoutMenu;
	public WebElement logoutMenu(){
		return logoutMenu;
				
	}
	@FindBy(xpath="//a[@class='settings-logout']")
	private WebElement logoutButton;
	public WebElement logoutButton(){
		return logoutButton;
	}
	@FindBy(partialLinkText="Logout Completely")
	private WebElement logoutCompletly; 
	public WebElement logoutCompletly(){
		return logoutCompletly;
	}
	
	public  void logout(WebDriver driver) throws Exception{
		Actions act=new Actions(driver);
		act.moveToElement(logoutMenu()).perform();
        act.moveToElement(logoutButton()).click().perform();
        logoutCompletly().click();;
		
		
	}
	

}

