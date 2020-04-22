package POM;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class IntermediatePages {
	public IntermediatePages(AndroidDriver<?> driver) {
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath="//*[@id='inter_close']")
	private WebElement skip_AddPhoto;
	
	public WebElement getSkip_introductionScreen() {
		return skip_AddPhoto;
	}
	
	@FindBy(xpath="//*[@id='skip']")
	private WebElement skip_PaymentPage;
	
	public WebElement getSkip_PaymentPage() {
		return skip_PaymentPage;
	}
	
	@FindBy(xpath="//*[@id='popup_close_btn']")
	private WebElement skip_QuickResponse;
	
	public WebElement getSkip_QuickResponse() {
		return skip_QuickResponse;
	}
	
	
	public static void skipIntermediatePages(AndroidDriver<?> driver) {
		IntermediatePages pages=new IntermediatePages( driver);
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			pages.getSkip_introductionScreen().click();
			System.out.println("Add photo page Handled");
		}catch(Exception e){
			e.getStackTrace();
			System.out.println("no Payment intermediate page displayed.....");
		}
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			pages.getSkip_PaymentPage().click();
			System.out.println("Payment Page Handled.....");

		} catch (Exception e) {
			System.out.println("no Payment intermediate page displayed .....");
		}
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			pages.getSkip_QuickResponse();
			System.out.println("quick Response page Handled ......");
		} catch (Exception e) {
			System.out.println("no quick response page displayed .....");
		}
		
	}


}
