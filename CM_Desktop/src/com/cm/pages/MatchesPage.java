package com.cm.pages;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cm.Utility.BaseTest;

public class MatchesPage extends BaseTest{
	public static Properties properties;
	public static WebElement matchesLink(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("matchesLink")));
		return ele;
	}
	public static WebElement matches_YetToBeViewed(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("matches_YetToBeViewed")));
		return ele;
	}
	public static List<WebElement> sendMailIcon(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("sendMailIcon")));
		return lst;
	}
	public static WebElement paymentPageHeader(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("paymentPageHeader")));
		return ele;
	}
	public static WebElement mobileIcon(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("mobileIcon")));
		return ele;
	}
	public static WebElement horoscopeIcon(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("horoscopeIcon")));
		return ele;
	}
	public static WebElement reqHoroconfPopMsg(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("reqHoroconfPopMsg")));
		return ele;
	}
	public static WebElement reqHoroConfPopClose(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("reqHoroConfPopClose")));
		return ele;
	}
	public static WebElement shortlistIcon(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("shortlistIcon")));
		return ele;
	}
	public static List<WebElement> shortlistConfPopMsg(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("shortlistConfPopMsg")));
		return lst;
	}
	public static List<WebElement> shortlistConfPopClose(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("shortlistConfPopClose")));
		return lst;
	}
	public static List<WebElement> markAsViewed(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("markAsViewed")));
		return lst;
	}
	public static WebElement markAsViewedConfMsg(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("markAsViewedConfMsg")));
		return ele;
	}
	public static WebElement markAsViewedConfMsg_No(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("markAsViewedConfMsg_No")));
		return ele;
	}
	public static WebElement markAsViewedConfMsg_Yes(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("markAsViewedConfMsg_Yes")));
		return ele;
	}
	public static List<WebElement> oppMembermatriId(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("oppMembermatriId")));
		return lst;
	}
	public static WebElement viewedProfileId(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("viewedProfileId")));
		return ele;
	}
	public static WebElement viewSimilarProfiles(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("viewSimilarProfiles")));
		return ele;
	}
	public static WebElement viewSimilarProfilesHeader(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("viewSimilarProfilesHeader")));
		return ele;
	}
	public static WebElement viewFullprofileLink(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("viewFullprofileLink")));
		return ele;
	}
	public static List<WebElement> sendInterestIn_Yes(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("sendInterestIn_Yes")));
		return lst;
	}
	public static WebElement sendInterestConfPopMsg(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("sendInterestConfPopMsg")));
		return ele;
	}
	public static WebElement sendInterestConfPopClose(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("sendInterestConfPopClose")));
		return ele;
	}
	public static List<WebElement> sendInterestIn_No(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("sendInterestIn_No")));
		return lst;
	}
	public static List<WebElement> oppMemberIdList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("oppMemberIdList")));
		return lst;
	}
	public static WebElement mobIconPopMsg(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("mobIconPopMsg")));
		return ele;
	}
	public static WebElement mobIconPop_SendSMS(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("mobIconPop_SendSMS")));
		return ele;
	}
	public static WebElement mobIconPop_AvailableSMS_Count(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("mobIconPop_AvailableSMS_Count")));
		return ele;
	}
	public static WebElement mobIconPop_SedSMS_Close(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("mobIconPop_SedSMS_Close")));
		return ele;
	}
	public static WebElement mobIcon_SendStandardSMS(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("mobIcon_SendStandardSMS")));
		return ele;
	}
	public static WebElement mobIconPop_SendSMSPop_AvailableSMS_Count(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("mobIconPop_SendSMSPop_AvailableSMS_Count")));
		return ele;
	}
	public static WebElement mobIcon_StandardSMS_Text(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("mobIcon_StandardSMS_Text")));
		return ele;
	}
	public static WebElement mobIcon_SendSMS_confMsg(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("mobIcon_SendSMS_confMsg")));
		return ele;
	}
	public static WebElement mobIcon_SendSMS_confMsgClose(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("mobIcon_SendSMS_confMsgClose")));
		return ele;
	}
	public static List<WebElement> sendRemainderList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("sendRemainderList")));
		return lst;
	}
	public static WebElement matches_LatestMatches(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("matches_LatestMatches")));
		return ele;
	}
	public static void loadProperties() throws Throwable{
		properties=new Properties();
		FileInputStream fis=new FileInputStream(new File(".\\ObjectRepository\\Matches.properties"));
		properties.load(fis);
	}
}
