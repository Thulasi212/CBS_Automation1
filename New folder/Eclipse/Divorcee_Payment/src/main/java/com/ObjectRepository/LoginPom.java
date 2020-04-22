package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseTest;

public class LoginPom extends BaseTest{
	
	public LoginPom(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
		
		@FindBy(xpath="/html/body/div[1]/div[2]/div/form/div[1]/input")
		private WebElement matriID;
		public WebElement getMatriID() {
			return matriID;
		}
		
	    @FindBy(id="passwordClear1")
	    private WebElement passclr;
		public WebElement getPassclr() {
			return passclr;
		}
		
		@FindBy(id="password1")
		private WebElement password;
		public WebElement getPassword() {
			return password;
		}
		
		@FindBy(xpath="//*[@id=\"topnav-login-menu\"]/div[2]/div[3]/a")
	    private WebElement inboxbtn;
		public WebElement getInboxbtn() {
			return inboxbtn;
		}	
		
		
		@FindBy(xpath="/html/body/div[1]/div[2]/div/form/div[2]/input[3]")
		private WebElement login_btn;
		public WebElement getLogin_btn() {
			return login_btn;
		}
		
		
	

}
