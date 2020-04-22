package com.cm.pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cm.Utility.BaseTest;

public class WhoShortlistedMePage extends BaseTest {
	public static Properties properties;
	public static WebElement whoShortlistMe(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("whoShortlistMe")));
		return element;
	}
	public static WebElement sendMailButton(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("sendMailButton")));
		return element;
	}
	
	public static WebElement mobButton(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("mobButton")));
		return element;
	}
	public static WebElement sendSmsPopup(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("sendSmsPopup")));
		return element;
	}
	public static WebElement reqHoro(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("reqHoro")));
		return element;
	}
	public static WebElement reqHoroconfMsg(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("reqHoroconfMsg")));
		return element;
	}
	
	public static WebElement vHoro(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("vHoro")));
		return element;
	}
	public static WebElement horoPOpupClose(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("horoPOpupClose")));
		return element;
	}
	public static WebElement horoReqPopup(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("horoReqPopup")));
		return element;
	}
	public  static List<WebElement> shortlistIconDisablList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("shortlistIconDisablList")));
		return lst;
	}
	public  static List<WebElement> markAsViewed(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("markAsViewed")));
		return lst;
	}
	public  static List<WebElement> shortlistedIdList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("shortlistedIdList")));
		return lst;
	}
	public  static List<WebElement> sendMailButtonList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("sendMailButtonList")));
		return lst;
	}
	public static WebElement sendmailbtnPopup(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("sendmailbtnPopup")));
		return element;
	}
	public static WebElement markAsviewedNo(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("markAsviewedNo")));
		return element;
	}
	public static WebElement viewFullProfile(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("viewFullProfile")));
		return element;
	}
	public static WebElement sendInterest(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("sendInterest")));
		return element;
	}
	public static WebElement sendIntPopupMsg(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("sendIntPopupMsg")));
		return element;
	}
	public static WebElement sendIntPopupClose(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("sendIntPopupClose")));
		return element;
	}
	public static WebElement sendRemainderPopupMsg(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("sendRemainderPopupMsg")));
		return element;
	}
	public static WebElement viewSimilarProfiles(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("viewSimilarProfiles")));
		return element;
	}
	public static WebElement sendRempopClose(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("sendRempopClose")));
		return element;
	}
	public static WebElement checkbox(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("checkbox")));
		return element;
	}
	public static WebElement checkboxShortlist(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("checkboxShortlist")));
		return element;
	}
	public static WebElement chechboxShortPopClose(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("chechboxShortPopClose")));
		return element;
	}
	public static WebElement checkboxShortPopMsg(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("checkboxShortPopMsg")));
		return element;
	}
	public  static List<WebElement> sendRemainder(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("sendRemainder")));
		return lst;
	}
	public  static List<WebElement> upgradeNowBtn(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("upgradeNowBtn")));
		return lst;
	}
	
	//*****************Who viewed my profile*****************
	public static WebElement whoViewMyProfile(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("whoViewMyProfile")));
		return element;
	}
	
	
	//***************who viewed my mobile number**********
	public static WebElement whoViewedMyMobNo(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("whoViewedMyMobNo")));
		return element;
	}
	public  static List<WebElement> oppMemIdList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("oppMemIdList")));
		return lst;
	}
	//**********Profiles I have Ignored*************
	public static WebElement profIhaveIgnore(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("profIhaveIgnore")));
		return element;
	}
	public  static List<WebElement> matchesOppIdList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("matchesOppIdList")));
		return lst;
	}
	public  static List<WebElement> viewProfileChoiceMenuList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("viewProfileChoiceMenuList")));
		return lst;
	}
	public  static List<WebElement> ignoreList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("ignoreList")));
		return lst;
	}
	public  static List<WebElement> ignoreYesBtnList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("ignoreYesBtnList")));
		return lst;
	}
	public  static List<WebElement> removeFromIgnoreList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("removeFromIgnoreList")));
		return lst;
	}
	public static WebElement removeIgnoreListPopMsg(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("removeIgnoreListPopMsg")));
		return element;
	}
	public static WebElement removeIgnoreListPopClose(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("removeIgnoreListPopClose")));
		return element;
	}
	public static void loadProperties()throws Throwable{
		properties=new Properties();
    	FileInputStream fis = new FileInputStream(new File(".\\ObjectRepository\\whoshortlistedme.properties"));
    	properties.load(fis);
	}

}
