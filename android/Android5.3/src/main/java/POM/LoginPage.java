package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
	public LoginPage(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@text='Skip']")
	private WebElement skip_introductionScren;
	
	public WebElement getSkip_introductionScreen() {
		return skip_introductionScren;
	}
	
	@FindBy(xpath="//*[@id='txt_logIn']")
	private WebElement loginButton1;
	public WebElement getLoginButton1() {
		return loginButton1;
	}
	
	@FindBy(xpath="//*[@id='txt_matriid']")
	private WebElement matriId;
	public WebElement getMatriId() {
		return matriId;
	}
    
	@FindBy(xpath="//*[@id='txt_pwd']")
	private WebElement pwd;
	public WebElement getPwd() {
		return pwd;
	}
	
	@FindBy(xpath="//*[@id='login_btn_from_login_layout']")
	private WebElement loginButton2;
	public WebElement getLoginButton2() {
		return loginButton2;
	}
	


	public static void loginToApp(AndroidDriver driver,String matriId,String pwd) {
		LoginPage login=new LoginPage( driver);
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			login.getSkip_introductionScreen().click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			login.getLoginButton1().click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			login.getMatriId().sendKeys(matriId);
			login.getPwd().sendKeys(pwd);
			login.getLoginButton2().click();	
		}catch(Exception e){
			System.out.println("Already login");	
		}
		
		
		
		
		
	}

}
