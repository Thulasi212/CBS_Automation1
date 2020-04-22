package com.cm.pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.cm.Utility.BaseTest;

public class ProfViewedNotContactPage extends BaseTest{
	public static Properties properties;
	public  static WebElement yetToBeViewed(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("yetToBeViewed")));
		return element;
	}
	public  static WebElement viewFullProfOppId(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("viewFullProfOppId")));
		return element;
	}
	public  static WebElement proViewedNotContacted(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("proViewedNotContacted")));
		return element;
	}
	public  static List<WebElement> oppsiteIdList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("oppsiteIdList")));
		return lst;
	}
	public  static WebElement nextButton(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("nextButton")));
		return element;
	}
	public  static WebElement vPhone(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("vPhone")));
		return element;
	}
	public  static WebElement vPhonePopupClose(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("vPhonePopupClose")));
		return element;
	}
	public  static WebElement vHoro(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("vHoro")));
		return element;
	}
	public  static WebElement horoPOpupClose(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("horoPOpupClose")));
		return element;
	}
	public  static List<WebElement> shortlistIconList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("shortlistIconList")));
		return lst;
	}
	public  static List<WebElement> sendMailButtonlist(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("sendMailButtonlist")));
		return lst;
	}
	public  static WebElement sendmailpopupClose(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("sendmailpopupClose")));
		return element;
	}
	public  static List<WebElement> sendIntBtnList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("sendIntBtnList")));
		return lst;
	}
	public  static WebElement sendIntPopupClose(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("sendIntPopupClose")));
		return element;
	}
	public  static WebElement viewSimlrproLink(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("viewSimlrproLink")));
		return element;
	}
	public  static List<WebElement> shortlistedIdList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("shortlistedIdList")));
		return lst;
	}
	public  static WebElement profShortByMe(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("profShortByMe")));
		return element;
	}
	public  static WebElement mobNoViewedByMe(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("mobNoViewedByMe")));
		return element;
	}
	public  static WebElement mobileButton(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("mobileButton")));
		return element;
	}
	public  static WebElement viewMobNo(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("viewMobNo")));
		return element;
	}
	public  static WebElement mobNo(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("mobNo")));
		return element;
	}
	public  static WebElement mobNoPopupClose(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("mobNoPopupClose")));
		return element;
	}
	public  static WebElement mobNoViewDate(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("mobNoViewDate")));
		return element;
	}
	public  static WebElement sendMail(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("sendMail")));
		return element;
	}
	public  static WebElement messgTextbox(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("messgTextbox")));
		return element;
	}
	public  static WebElement mailPopupClose(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("mailPopupClose")));
		return element;
	}
	public  static WebElement viewFullprofile(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("viewFullprofile")));
		return element;
	}
	
	
	public static void loadProperties()throws Throwable{
		properties=new Properties();
    	FileInputStream fis = new FileInputStream(new File(".\\ObjectRepository\\ProfilesViewed.properties"));
    	properties.load(fis);
	}

}
