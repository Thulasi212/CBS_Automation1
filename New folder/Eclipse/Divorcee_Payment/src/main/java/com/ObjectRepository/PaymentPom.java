package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseTest;

public class PaymentPom extends BaseTest {
	
	public PaymentPom(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath="//*[@id=\"a12\"]")
	private WebElement DmatriID;
	public WebElement getMatriID() {
		return DmatriID;
	}
	
	
	@FindBy(id="passwordClear1")
	private WebElement DpassWordclr1;
	public WebElement getDpassWordclr1() {
		return DpassWordclr1;
	}

	@FindBy(xpath="//*[@id=\"password1\"]")
	private WebElement Dpassword;
	public WebElement getDpassword() {
		return Dpassword;
	}

	@FindBy(xpath="//*[@id=\"login_form_web\"]/div[2]/input[3]")
	private WebElement Dlogin;
	public WebElement getDlogin() {
		return Dlogin;
	}

	@FindBy(xpath="/html/body/header/div/div/div/a")
	private WebElement DskipInter;
	
	public WebElement getDskipInter() {
		return DskipInter;
	}

	@FindBy(xpath="//*[@id=\"special_offer_lightpic1\"]/div[1]/div/a/img")
	private WebElement DaddsPop;
	public WebElement getDaddsPop() {
		return DaddsPop;
	}

	@FindBy(xpath="//*[@id=\"topnav-login-menu\"]/div[2]/div[6]/a")
	private WebElement Dupgrde;
	public WebElement getDupgrde() {
		return Dupgrde;
	}

	@FindBy(xpath="//*[@id=\"upgpop\"]/div[2]/div/div[1]/ul/li[1]/a")
	private WebElement DupgdePay;
	public WebElement getDupgdePay() {
		return DupgdePay;
	}

	@FindBy(xpath="//*[@id=\"upgpop\"]/div[2]/div/div[1]/ul/li[2]/a")
	private WebElement DupgrdeAssis;
	public WebElement getDupgrdeAssis() {
		return DupgrdeAssis;
	}

	@FindBy(xpath="//*[@id=\"upgpop\"]/div[2]/div/div[1]/ul/li[3]/a")
	private WebElement DupgrdeAddomn;
	public WebElement getDupgrdeAddomn() {
		return DupgrdeAddomn;
	}

	@FindBy(xpath="//*[@id=\"vpc_CardNum_C\"]")
	private WebElement DcardNumber;
	public WebElement getDcardNumber() {
		return DcardNumber;
	}

	@FindBy(xpath="//*[@id=\"cardExpiryMonth\"]")
	private WebElement DexpreMnth;
	public WebElement getDexpreMnth() {
		return DexpreMnth;
	}

	@FindBy(xpath="//*[@id=\"cardExpiryYear\"]")
	private WebElement DexpreYr;
	public WebElement getDexpreYr() {
		return DexpreYr;
	}

	@FindBy(xpath="//*[@id=\"vpc_CardSecurityCode\"]")
	private WebElement DCvv;
	public WebElement getDCvv() {
		return DCvv;
	}

	@FindBy(id="crditCardRiSubButL")
	private WebElement DpayCRDcard;
	public WebElement getDpayCRDcard() {
		return DpayCRDcard;
	}
	
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div/form/div[1]/input")
	private WebElement community_matri_id;
	public WebElement getDmatriID() {
		return DmatriID;
	}


	public WebElement getCommunity_matri_id() {
		return community_matri_id;
	}
	
	
	@FindBy(xpath="//input[@value=\"LOGIN\"]")
	private WebElement community_login;
	public WebElement getCommunity_login() {
		return community_login;
	}
	

}
