package CBS;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WCSM_POM {
public WCSM_POM(WebDriver driver) {
PageFactory.initElements(driver, this);
}

@FindBy(xpath="//*[@id='idEmail']")
private WebElement username;

@FindBy(xpath="//*[@id='password1']")
private WebElement password;

@FindBy(xpath="//*[@id='login-button']")
private WebElement login;

public WebElement getUsername() {
return username;
}

public WebElement getPassword() {
return password;
}

public WebElement getLogin() {
return login;
}

@FindBy(xpath="/html/body/ion-app/ng-component/page-dashboard/ion-header/header/ion-navbar/div[2]/ion-grid/ion-row/ion-col[5]")
private WebElement menu;

public WebElement getMenu() {
return menu;
}

@FindBy(xpath="//*[@id=\"mainsidemenu\"]/div/ion-content/div[2]/ion-grid/ion-row/ion-col/ion-list[4]")
private WebElement editpi;

public WebElement getEditpi() {
return editpi;
}

public WebElement getBasicdetails() {
return basicdetails;
}


@FindBy(xpath="//*[@id=\"linktobasic_details\"]/div[1]/div[2]")
private WebElement basicdetails;

@FindBy(xpath="//*[@id=\\\"wap-edit-profile\\\"]/div/div[2]/form/fieldset[1]/div[2]")
private WebElement profilecreatedby;

@FindBy(xpath="//*[@id='RegPanelSearchvalue']")
private WebElement searchbar;

public WebElement getProfilecreatedby() {
return profilecreatedby;
}

public WebElement getSearchbar() {
return searchbar;
}

@FindBy(xpath="//*[@id=\"wap-edit-profile\"]/div/div[2]/form/fieldset[4]/div[2]")
private WebElement height;

@FindBy(xpath="//*[@id=\"wap-edit-profile\"]/div/div[2]/form/fieldset[5]/div[2]")
private WebElement weight;

public WebElement getHeight() {
return height;
}

public WebElement getWeight() {
return weight;
}

@FindBy(xpath="//*[@id=\"wap-edit-profile\"]/div/div[2]/form/fieldset[6]/div[2]")
private WebElement maritalstatus;
@FindBy(xpath="//*[@id='No_of_child_value']")
private WebElement noofchild;
@FindBy(xpath="//*[@id='Child_Living_status_value']")
private WebElement childrenlivingwith;



public WebElement getNoofchild() {
return noofchild;
}

public WebElement getChildrenlivingwith() {
return childrenlivingwith;
}

@FindBy(xpath="//*[@id=\"wap-edit-profile\"]/div/div[2]/form/fieldset[9]/div[2]")
private WebElement mothertongue;

@FindBy(xpath="//*[@id=\"wap-edit-profile\"]/div/div[2]/form/fieldset[10]/div[2]")
private WebElement bodytype;

@FindBy(xpath="//*[@id=\"wap-edit-profile\"]/div/div[2]/form/fieldset[11]/div[2]")
private WebElement complexion;

@FindBy(xpath="//*[@id=\"wap-edit-profile\"]/div/div[2]/form/fieldset[12]/div[2]")
private WebElement physcialstatus;

@FindBy(xpath="//*[@id=\"wap-edit-profile\"]/div/div[2]/form/fieldset[13]/div[2]")
private WebElement languageknown;



public WebElement getMothertongue() {
return mothertongue;
}

public WebElement getBodytype() {
return bodytype;
}

public WebElement getMaritalstatus() {
return maritalstatus;
}

public WebElement getComplexion() {
return complexion;
}

public WebElement getPhyscialstatus() {
return physcialstatus;
}

public WebElement getLanguageknown() {
return languageknown;
}


public WebElement getReligiousinformation() {
return religiousinformation;
}

public WebElement getBasicdetailsave() {
return basicdetailsave;
}

@FindBy(xpath="//*[@id='edit-prof_footer']/div[2]")
private WebElement basicdetailsave;

@FindBy(xpath="//*[@id='wap-edit-profile']/div[3]/div[3]/div[1]/div[2]")
private WebElement religiousinformation;

@FindBy(xpath="//*[@id='Gothram']")
private WebElement gothram;


public WebElement getGothram() {
return gothram;
}

@FindBy(xpath="//*[@id='subcastesleect']/div")
private WebElement subcaste;

@FindBy(xpath="//*[@id='wap-edit-profile']/div/div[2]/form/fieldset[3]/div[2]")
private WebElement star;

public WebElement getSubcaste() {
return subcaste;
}

public WebElement getStar() {
return star;
}

public WebElement getRaasi() {
return raasi;
}



@FindBy(xpath="//*[@id='wap-edit-profile']/div/div[2]/form/fieldset[4]/div[2]")
private WebElement raasi;


@FindBy(xpath="//*[@id='Dosham']")
private WebElement suddhajadhagam;


public WebElement getSuddhajadhagam() {
return suddhajadhagam;
}

@FindBy(xpath="//*[@id='SpecifiedDosham']")
private WebElement specifieddhosham;


public WebElement getSpecifieddhosham() {
return specifieddhosham;
}

@FindBy(xpath="//*[@id='linktoeducation']/div[1]/div[2]")
private WebElement professionalinformation;

public WebElement getProfessionalinformation() {
return professionalinformation;
}

public WebElement getEducation() {
return education;
}

@FindBy(xpath="//*[@id='wap-edit-profile']/div/div[2]/form/fieldset[1]/div[2]")
private WebElement education;

@FindBy(xpath="//*[@id='additional_degree']")
private WebElement additionaldegree;



public WebElement getAdditionaldegree() {
return additionaldegree;
}

@FindBy(xpath="//*[@id='wap-edit-profile']/div/div[2]/form/fieldset[5]/div[2]")
private WebElement employedin;

@FindBy(xpath="//*[@id='Occupation_display']/div[2]")
private WebElement occupation;

public WebElement getEmployedin() {
return employedin;
}

public WebElement getOccupation() {
return occupation;
}

@FindBy(xpath="//*[@id='Annual_income_currency_display']/div[2]")
private WebElement currencytype;

@FindBy(xpath="//*[@id='IncomeSelectInputWrap']")
private WebElement annualincome;

public WebElement getCurrencytype() {
return currencytype;
}

public WebElement getAnnualincome() {
return annualincome;
}

@FindBy(xpath="//*[@id='wap-edit-profile']/div[3]/div[5]/div[1]/div[2]")
private WebElement location;

@FindBy(xpath="//*[@id='wap-edit-profile']/div/div[2]/form/fieldset[1]/div[2]")
private WebElement country;

@FindBy(xpath="//*[@id='Residing_state_display']/div[2]")
private WebElement state;

public WebElement getLocation() {
return location;
}

public WebElement getCountry() {
return country;
}

public WebElement getState() {
return state;
}

public WebElement getCity() {
return city;
}


@FindBy(xpath="//*[@id='Residing_city_display']/div[2]")
private WebElement city;



@FindBy(xpath="//*[@id='Resident_status']")
private WebElement residentstatus;

public WebElement getResidentstatus() {
return residentstatus;
}

@FindBy(xpath="//*[@id='Citizenship']")
private WebElement citizenship;

public WebElement getCitizenship() {
return citizenship;
}



@FindBy(xpath="//*[@id='linktofamily']/div[1]/div[2]")
private WebElement familydetails;

@FindBy(xpath="//*[@id='wap-edit-profile']/div/div[2]/form/fieldset[1]/div[2]")
private WebElement familyvalue;

@FindBy(xpath="//*[@id='wap-edit-profile']/div/div[2]/form/fieldset[2]/div[2]")
private WebElement familytype;

@FindBy(xpath="//*[@id='wap-edit-profile']/div/div[2]/form/fieldset[3]/div[2]")
private WebElement familystatus;

@FindBy(xpath="//*[@id='wap-edit-profile']/div/div[2]/form/fieldset[7]/div[2]")
private WebElement noofbrothers;

@FindBy(xpath="//*[@id='wap-edit-profile']/div/div[2]/form/fieldset[9]/div[2]")
private WebElement noofsisters;

public WebElement getFamilydetails() {
return familydetails;
}

public WebElement getFamilyvalue() {
return familyvalue;
}

public WebElement getFamilytype() {
return familytype;
}

public WebElement getFamilystatus() {
return familystatus;
}

public WebElement getNoofbrothers() {
return noofbrothers;
}

public WebElement getNoofsisters() {
return noofsisters;
}

@FindBy(xpath="//*[@id='linktohobbies']/div[1]/div[2]")
private WebElement lifestyle;


public WebElement getLifestyle() {
return lifestyle;
}

@FindBy(xpath="//*[@id='Eating_Habits']")
private WebElement eatinghabit;

@FindBy(xpath="//*[@id='Drinking_habits']")
private WebElement drinkinghabit;

@FindBy(xpath="//*[@id='Smoking_habits']")
private WebElement smokinghabit;

@FindBy(xpath="//*[@id='Hobbies']")
private WebElement hobbiesandinterest;

public WebElement getEatinghabit() {
return eatinghabit;
}

public WebElement getDrinkinghabit() {
return drinkinghabit;
}

public WebElement getSmokinghabit() {
return smokinghabit;
}

public WebElement getHobbiesandinterest() {
return hobbiesandinterest;
}

@FindBy(xpath="//*[@id='Music']")
private WebElement music;

@FindBy(xpath="//*[@id='Sports']")
private WebElement sports;

@FindBy(xpath="//*[@id='Food']")
private WebElement food;

public WebElement getMusic() {
return music;
}

public WebElement getSports() {
return sports;
}

public WebElement getFood() {
return food;
}


@FindBy(xpath="//*[@id='mainsidemenu']/div/ion-content/div[2]/ion-grid/ion-row/ion-col/ion-list[5]")
private WebElement editpp;

public WebElement getEditpp() {
return editpp;
}


@FindBy(xpath="//ion-label[contains(text(),'Settings')]")
private WebElement setting;

@FindBy(xpath="/html/body/ion-app/ion-modal/div/settingpopup/ion-content/div[2]/ion-grid/ion-row/ion-col/ion-list/ion-item[6]")
private WebElement whocanseeme;

public WebElement getSetting() {
return setting;
}

public WebElement getWhocanseeme() {
return whocanseeme;
}


@FindBy(xpath="//div[@class='linknb more_link']")
private WebElement morepreference;

public WebElement getMorepreference() {
return morepreference;
}








}



