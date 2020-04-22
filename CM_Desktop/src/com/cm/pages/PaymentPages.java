package com.cm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPages {
	
@FindBy(id="category_1")
private WebElement gold_3_Months;
public void gold_3_Months(){
	gold_3_Months.click();
	
}
@FindBy(id="category_172")
private WebElement gold_6_Months;
public void ggold_6_Months(){
	gold_6_Months.click();
}
@FindBy(id="category_2")
private WebElement diamond_3_Months;
public void diamond_3_Months() {
	diamond_3_Months.click();
}
@FindBy(id="category_2173")
private WebElement diamond_6_Months;
public void diamond_6_Months(){
	diamond_6_Months.click();
}
@FindBy(id="category_14")
private WebElement platinum_3_Months;
public void platinum_3_Months(){
	platinum_3_Months.click();
}
@FindBy(id="category_14156")
private WebElement platinum_6_Months;
public void platinum_6_Months(){
	platinum_6_Months.click();
}

@FindBy(id="category_8")
private WebElement Till_U_Marry;
public void Till_U_Marry(){
	Till_U_Marry.click();
}



                                       //ADD_ON PACKS*****//


@FindBy(id="specialOffer120")
private WebElement profileHighlighter_1400rs;
public void profileHighlighter_1400rs(){
	profileHighlighter_1400rs.click();
}
@FindBy(id="specialOffer125")
private WebElement topPlacement_1200rs;
public void topPlacement_1200rs(){
	topPlacement_1200rs.click();
	
}
@FindBy(id="specialOffer110")
private WebElement astroMatch_650rs;
public void astroMatch_650rs(){
	astroMatch_650rs.click();	
}
@FindBy(id="specialOffer111")
private WebElement astroMatch_6Months_900rs;
public void astroMatch_6Months_900rs(){
	astroMatch_6Months_900rs.click();
	
}
@FindBy(id="specialOffer112")
private WebElement astroMatch_Tum__1200rs;
public void astroMatch_Tum__1200rs(){
	astroMatch_Tum__1200rs.click();
	
}
@FindBy(id="splCheckoutAddon']/div/div[1]/div/input[1]")
private WebElement specialAddon;
public void specialAddon(){
	specialAddon.click();
}
                                               //****upgrade
@FindBy(xpath=".//*[@id='topnav-login-menu']/div[2]/div[6]/a")
private WebElement upgrade;
public void upgrade(){
	upgrade.click();
}
                                      //upgrdae links 
@FindBy(partialLinkText="Know More")
private WebElement chatwindow_Link;
public void chatwindow_Link(){
	chatwindow_Link.click();
}
@FindBy(partialLinkText="Pay Online")
private WebElement chatwindow_Link_tuesday;
public void chatwindow_Link_tuesday(){
	chatwindow_Link_tuesday.click();
}

@FindBy(xpath=".//*[@id='topnav-login-menu']/div[3]/div[2]/div[1]/span")
private WebElement upgradeDropDown;
public void upgradeDropDown(){
	upgradeDropDown.click();
}
@FindBy(partialLinkText="Upgrade Account")
private WebElement upgradeDropDown_upgrade_Link;
public void upgradeDropDown_upgrade_Link(){
	upgradeDropDown_upgrade_Link.click();
}
@FindBy(xpath=".//*[@id='lp-container']/div[4]/a/div/div")
private WebElement daily_7_banner;
public void daily_7_banner(){
	daily_7_banner.click();
}

                            
                                                //card details //
@FindBy(id="cardHolderName")
private WebElement nameoncard;
public void nameoncard(){
nameoncard.sendKeys("gold3months");


}
@FindBy(id="vpc_CardNum_C")
private WebElement cardNumber;
public void cardNumber(){
	cardNumber.sendKeys("4111111111111111");
	
}
@FindBy(id="vpc_CardSecurityCode")
private WebElement cvv;
public void cvv(){
	cvv.sendKeys("156");
}
@FindBy(id="crditCardRiSubButL")
private WebElement submitButton;
public void submitButton(){
	submitButton.click();
}
                                                           //paymentfailure//
@FindBy(linkText="www.communitymatrimony.com")
private WebElement goBacktofailurePage;
public void goBacktofailurePage(){
	goBacktofailurePage.click();

}
}
	


