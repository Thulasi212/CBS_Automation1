package com.cm.pages;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cm.Utility.BaseTest;

public class MarkAsViewedPage extends BaseTest {
	public static Properties properties;
	public static List<WebElement> markedAsViewed(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("markedAsViewed")));
		return lst;
	}
	public static List<WebElement> markAsViewedYes(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("markAsViewedYes")));
		return lst;
	}
	public static List<WebElement> idList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("idList")));
		return lst;
	}
	public static WebElement paginationNext(){
	WebElement element=driver.findElement(By.xpath(properties.getProperty("paginationNext")));	
	return element;
	}
	//profiles Blocked................
	public static List<WebElement> blockBtnInMatchesList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("blockBtnInMatchesList")));
		return lst;
	}
	public static List<WebElement> blockYesButtonList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("blockYesButtonList")));
		return lst;
	}
	public static WebElement oppId(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("oppId")));
		return element;
	}
	public static WebElement membersYouHaveBlocked(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("membersYouHaveBlocked")));
		return element;
	}
	public  static WebElement yetToBeViewed(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("yetToBeViewed")));
		return element;
	}
	public static List<WebElement> removeFromBlockList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("removeFromBlockList")));
		return lst;
	}
	public  static WebElement remvFrmBlockConfMsg(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("remvFrmBlockConfMsg")));
		return element;
	}
	public  static WebElement remvFrmBlockConfMsgClose(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("remvFrmBlockConfMsgClose")));
		return element;
	}
	//Search Elements...............
	
	public  static WebElement ageFrom(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("ageFrom")));
		return element;
	}
	public  static WebElement ageTo(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("ageTo")));
		return element;
	}
	public  static WebElement heightFrom(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("heightFrom")));
		return element;
	}
	public  static WebElement heightTo(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("heightTo")));
		return element;
	}
	public  static WebElement unmarried(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("unmarried")));
		return element;
	}
	public  static WebElement casteOrDivision(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("casteOrDivision")));
		return element;
	}
	public  static WebElement profAlreadyContCheckbox(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("profAlreadyContCheckbox")));
		return element;
	}
	public  static WebElement profAlreadyViewedCheckbox(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("profAlreadyViewedCheckbox")));
		return element;
	}
	public  static WebElement shortlistedProfilesCheckbox(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("shortlistedProfilesCheckbox")));
		return element;
	}
	public  static WebElement profIHaveBlockedCheckbox(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("profIHaveBlockedCheckbox")));
		return element;
	}
	public  static WebElement profIHaveIgnoredCheckbox(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("profIHaveIgnoredCheckbox")));
		return element;
	}
	public  static WebElement searchBtn(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("searchBtn")));
		return element;
	}
	public  static List<WebElement> sendMailList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("sendMailList")));
		return lst;
	}
	public  static List<WebElement> yesBtn(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("yesBtn")));
		return lst;
	}
	public  static WebElement searchOptionSubmit(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("searchOptionSubmit")));
		return element;
	}
	public  static List<WebElement> shortlistIconList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("shortlistIconList")));
		return lst;
	}
	public  static List<WebElement> interestedInHerOrHim(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("interestedInHerOrHim")));
		return lst;
	}
	public  static List<WebElement> removeFromIgnoreList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("removeFromIgnoreList")));
		return lst;
	}
	public  static List<WebElement> awaitingRespnse(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("awaitingRespnse")));
		return lst;
	}
	public  static List<WebElement> yetToReceiveReply(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("yetToReceiveReply")));
		return lst;
	}
	public  static List<WebElement> remaindInterest(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("remaindInterest")));
		return lst;
	}
	public  static List<WebElement> messageDeclined(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("messageDeclined")));
		return lst;
	}
	public  static List<WebElement> interestDeclined(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("interestDeclined")));
		return lst;
	}
	public  static List<WebElement> viewedOn(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("viewedOn")));
		return lst;
	}
	public  static List<WebElement> shortlistedIconList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("shortlistedIconList")));
		return lst;
	}
	public static void loadProperties()throws Throwable{
		properties=new Properties();
    	FileInputStream fis = new FileInputStream(new File(".\\ObjectRepository\\markAsViewed.properties"));
    	properties.load(fis);
	}


}
