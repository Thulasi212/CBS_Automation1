


package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.BaseTest;
import utility.WebDriverWaitLib;


public class IntermediatePages1 extends BaseTest {
	@FindBy(xpath="//a[contains(text(),'Skip to My Matrimony')]")
	private WebElement skipToMyMatrimony_Popup;
	@FindBy(xpath="//a[contains(text(),'Skip to Daily Matches')]")
	private WebElement skipToDailyMatches_Popup;

	@FindBy(xpath="//*[@id='strategicComm']/div/div[2]/a/img")
	private WebElement strategic_Popup;
	public WebElement strategic_Popup(){
		return strategic_Popup;
	}
	@FindBy(xpath="//div[@id='special_offer_lightpic1']/div[1]/div/a/img")
	private WebElement upgrade_Popup;
	
	@FindBy(linkText="I'll do this later >>")
	private WebElement addPhoto;
	@FindBy(xpath="//*[@id='conform']/div/div/div/a[1]")
	private WebElement areYousure_Popup;
	
	@FindBy(xpath="//*[@id='reason3']")
	private WebElement reason3_Popup;
	@FindBy(xpath="//*[@id='skipphotoclick']")
	private WebElement submit_Popup;
	
	
	
	
	public void intermediate_Popups(WebDriver driver) throws InterruptedException{
		test.pass("Closing Intermediate Pages..............................");
		boolean status=true;
		if(status){
		try{
			WebDriverWaitLib.waitElementToPresent(skipToDailyMatches_Popup);
			skipToDailyMatches_Popup.click();
			status=false;
			test.pass("SkipTodailyMatches Popup is closed successfully");
			try{
				WebDriverWaitLib.waitElementToPresent(upgrade_Popup);
				upgrade_Popup.click();
				test.pass("Upgrade Popup is closed successfully");
			}catch(Exception e){e.getMessage();}
		}catch(Exception e){e.getMessage();}

		try{
			skipToMyMatrimony_Popup.click();
			status=false;
			test.pass("SkipMyMatches Popup is closed successfully");
			try{
				WebDriverWaitLib.waitElementToPresent(strategic_Popup);
				strategic_Popup.click();
				test.pass("Strategic Popup is closed");
			}catch(Exception e){e.getMessage();}
			try{
				WebDriverWaitLib.waitElementToPresent(upgrade_Popup);
				upgrade_Popup.click();
				test.pass("Upgrade Popup is closed successfully");
			}catch(Exception e){e.getMessage();}
		}catch(Exception e){e.getMessage();}
		}
		
		if(status)
			try{
				addPhoto.click();
				status=false;
				WebDriverWaitLib.waitElementToPresent(areYousure_Popup);
				areYousure_Popup.click();
				WebDriverWaitLib.waitElementToPresent(reason3_Popup);
				reason3_Popup.click();
				Thread.sleep(2000);
				submit_Popup.click();
				try{
					WebDriverWaitLib.waitElementToPresent(upgrade_Popup);
					upgrade_Popup.click();
					test.pass("Upgrade Popup is closed successfully");
				}catch(Exception e){e.getMessage();}
		    	}catch(Exception e){e.getMessage();}
			

      }
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	