package com.cm.pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cm.Utility.BaseTest;

public class SpecificRegisterpage extends BaseTest {
	public static Properties properties;
	
	public static WebElement profCreatedBy(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("profCreatedBy")));
		return ele;
	}
	public static WebElement name(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("name")));
		return ele;
	}
	public static WebElement male(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("male")));
		return ele;
	}
	public static WebElement female(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("female")));
		return ele;
	}
	public static WebElement birthDay(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("birthDay")));
		return ele;
	}
	public static WebElement birthMonth(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("birthMonth")));
		return ele;
	}
	public static WebElement birthYear(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("birthYear")));
		return ele;
	}
	public static WebElement unmarried(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("unmarried")));
		return ele;
	}
	public static WebElement widowOrWidower(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("widowOrWidower")));
		return ele;
	}
	public static WebElement divorced(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("divorced")));
		return ele;
	}
	public static WebElement seperated(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("seperated")));
		return ele;
	}
	public static WebElement casteOrDivision(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("casteOrDivision")));
		return ele;
	}
	public static WebElement subCaste(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("subCaste")));
		return ele;
	}
	public static WebElement motherTongue(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("motherTongue")));
		return ele;
	}
	public static WebElement countryLivingIn(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("countryLivingIn")));
		return ele;
	}
	public static WebElement mobNoCountryCode(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("mobNoCountryCode")));
		return ele;
	}
	public static WebElement mobNo(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("mobNo")));
		return ele;
	}
	public static WebElement loginPassword(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("loginPassword")));
		return ele;
	}
	public static WebElement rigisterNow(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("rigisterNow")));
		return ele;
	}
	public static WebElement email(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("email")));
		return ele;
	}
	public static WebElement height(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("height")));
		return ele;
	}
	public static WebElement physicalStatus_normal(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("physicalStatus_normal")));
		return ele;
	}
	public static WebElement physicalStatus_pChallenged(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("physicalStatus_pChallenged")));
		return ele;
	}
	public static WebElement residingState(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("residingState")));
		return ele;
	}
	public static WebElement residingCity(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("residingCity")));
		return ele;
	}
	public static WebElement citizenship(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("citizenship")));
		return ele;
	}
	public static WebElement sameCasteOrDivision(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("sameCasteOrDivision")));
		return ele;
	}
	public static WebElement otherCasteorDivision(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("otherCasteorDivision")));
		return ele;
	}
	public static WebElement star(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("star")));
		return ele;
	}
	public static WebElement raasi(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("raasi")));
		return ele;
	}
	public static WebElement gothra(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("gothra")));
		return ele;
	}
	public static WebElement dosham_Yes(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("dosham_Yes")));
		return ele;
	}
	public static WebElement dosham_No(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("dosham_No")));
		return ele;
	}
	public static WebElement dosham_doNotKnow(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("dosham_doNotKnow")));
		return ele;
	}
	public static WebElement timeOfBirth_hours(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("timeOfBirth_hours")));
		return ele;
	}
	public static WebElement timeOfBirth_mins(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("timeOfBirth_mins")));
		return ele;
	}
	public static WebElement timeOfBirth_meridiem(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("timeOfBirth_meridiem")));
		return ele;
	}
	public static WebElement countryOfBirth(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("countryOfBirth")));
		return ele;
	}
	public static WebElement stateOfBirth(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("stateOfBirth")));
		return ele;
	}
	public static WebElement cityOfBirth(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("cityOfBirth")));
		return ele;
	}
	public static WebElement chartStyle(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("chartStyle")));
		return ele;
	}
	
	//*******************Education & Profession***********************
	public static WebElement heighestEducation(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("heighestEducation")));
		return ele;
	}
	public static WebElement employedIn_govt(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("employedIn_govt")));
		return ele;
	}
	public static WebElement employedIn_defence(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("employedIn_defence")));
		return ele;
	}
	public static WebElement employedIn_private(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("employedIn_private")));
		return ele;
	}
	public static WebElement employedIn_business(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("employedIn_business")));
		return ele;
	}
	public static WebElement employesIn_selfEmployed(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("employesIn_selfEmployed")));
		return ele;
	}
	public static WebElement employedIn_notWorking(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("employedIn_notWorking")));
		return ele;
	}
	public static WebElement occupaton(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("occupaton")));
		return ele;
	}
	public static WebElement income_monthly(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("income_monthly")));
		return ele;
	}
	public static WebElement income_annual(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("income_annual")));
		return ele;
	}
	public static WebElement software(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("software")));
		return ele;
	}
	public static WebElement anualCurrency(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("anualCurrency")));
		return ele;
	}
	public static WebElement incomeTextbox(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("incomeTextbox")));
		return ele;
	}
	
	//**************Famly Information**********
	
	public static WebElement famlyValue_orthodox(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("famlyValue_orthodox")));
		return ele;
	}
	public static WebElement famlyValue_traditional(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("famlyValue_traditional")));
		return ele;
	}
	public static WebElement famlyValue_moderate(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("famlyValue_moderate")));
		return ele;
	}
	public static WebElement famlyValue_liberal(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("famlyValue_liberal")));
		return ele;
	}
	public static WebElement famlyType_joint(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("famlyType_joint")));
		return ele;
	}
	public static WebElement famlyType_nuclear(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("famlyType_nuclear")));
		return ele;
	}
	public static WebElement famlyStatus_middle(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("famlyStatus_middle")));
		return ele;
	}
	public static WebElement famlyStatus_upperMiddle(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("famlyStatus_upperMiddle")));
		return ele;
	}
	public static WebElement famlyStatus_rich(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("famlyStatus_rich")));
		return ele;
	}
	//**************About Me****************
	
	public static WebElement aboutMe(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("aboutMe")));
		return ele;
	}
	public static WebElement completeRegister(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("completeRegister")));
		return ele;
	}
	public static WebElement newlyRegisterId(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("newlyRegisterId")));
		return ele;
	}
	//*********Mobile verification***********
	public static WebElement pinText(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("pinText")));
		return ele;
	}
	public static WebElement pinNoTextbox(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("pinNoTextbox")));
		return ele;
	}
	public static WebElement verifyBtn(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("verifyBtn")));
		return ele;
	}
	public static WebElement alertMsg(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("alertMsg")));
		return ele;
	}
	public static WebElement alrtPop(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("alrtPop")));
		return ele;
	}
	public static WebElement skipPage(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("skipPage")));
		return ele;
	}
	public static WebElement addPhoto(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("addPhoto")));
		return ele;
	}
	public static WebElement reason1(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("reason1")));
		return ele;
	}
	public static WebElement skipPhotoclick(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("skipPhotoclick")));
		return ele;
	}
	public static WebElement skipToHome(){
		WebElement ele=driver.findElement(By.linkText(properties.getProperty("skipToHome")));
		return ele;
	}
	public static WebElement iWollDoThisLater(){
		WebElement ele=driver.findElement(By.linkText(properties.getProperty("iWollDoThisLater")));
		return ele;
	}
	public static WebElement personalDetailSkip(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("personalDetailSkip")));
		return ele;
	}
	public static WebElement skip(){
		WebElement ele=driver.findElement(By.linkText(properties.getProperty("skip")));
		return ele;
	}
	//Delete profile*****************
	public static WebElement logoutMenu(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("logoutMenu")));
		return ele;
	}
	public static WebElement acctSettings(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("acctSettings")));
		return ele;
	}
	public static WebElement deleteProfile(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("deleteProfile")));
		return ele;
	}
	public static WebElement marriedReason1(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("marriedReason1")));
		return ele;
	}
	public static WebElement submitBtn(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("submitBtn")));
		return ele;
	}
	public static WebElement pwTextbox(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("pwTextbox")));
		return ele;
	}
	public static WebElement deletepofileconfMsg(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("deletepofileconfMsg")));
		return ele;
	}
	public static List<WebElement> deleteProfileconf(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("deleteProfileconf")));
		return lst;
	}
	public static WebElement deleteProfileConfYes(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("deleteProfileConfYes")));
		return ele;
	}
	public static WebElement noOfChildren(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("noOfChildren")));
		return ele;
	}
	//*********christian properties*************
	public static WebElement denomination(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("denomination")));
		return ele;
	}
	public static WebElement religiousValues(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("religiousValues")));
		return ele;
	}
	public static WebElement ethnicity(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("ethnicity")));
		return ele;
	}
	
	//muslim properties
	public static WebElement sect(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("sect")));
		return ele;
	}
	public static WebElement readQuran_regularly(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("readQuran_regularly")));
		return ele;
	}
	public static WebElement readQuran_occ(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("readQuran_occ")));
		return ele;
	}
	public static WebElement readQuran_only(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("readQuran_only")));
		return ele;
	}
	public static WebElement readQuran_never(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("readQuran_never")));
		return ele;
	}
	public static WebElement doYouWear_hijab(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("doYouWear_hijab")));
		return ele;
	}
	public static WebElement doYouWear_niqab(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("doYouWear_niqab")));
		return ele;
	}
	public static WebElement doYouWear_none(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("doYouWear_none")));
		return ele;
	}
	
	//kerela Christian************************
	public static WebElement diocese(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("diocese")));
		return ele;
	}
	public static WebElement keralaDenomination(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("keralaDenomination")));
		return ele;
	}
	public static WebElement parishname(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("parishname")));
		return ele;
	}
	public static WebElement fathersName(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("fathersName")));
		return ele;
	}
	public static WebElement fatherNativePlace(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("fatherNativePlace")));
		return ele;
	}
	public static WebElement mothersName(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("mothersName")));
		return ele;
	}
	public static WebElement mothersNativePlace(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("mothersNativePlace")));
		return ele;
	}
	public static WebElement fathersHouseName(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("fathersHouseName")));
		return ele;
	}
	public static WebElement mothersHouseName(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("mothersHouseName")));
		return ele;
	}
	public static void loadProperties()throws Throwable{
		properties=new Properties();
    	FileInputStream fis = new FileInputStream(new File(".\\ObjectRepository\\SpecificRegister.properties"));
    	properties.load(fis);
	}

}
