package pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.BaseTest;

public class HomePage extends BaseTest{
	public static Properties properties;
	//****************Home Page**************
	public  static WebElement myHomeLink(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("myHomeLink")));
		return element;
	}
	public  static WebElement matchesLink(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("matchesLink")));
		return element;
	}
	
	//************My Home********************
	public  static WebElement requestSentCount(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("requestSentCount")));
		return element;
	}
	public  static WebElement request(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("request")));
		return element;
	}
	//*********Matches*************************
	public  static List<WebElement> viewFullprofile(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("viewFullprofile")));
		return lst;
	}
	public  static List<WebElement> nextButton(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("nextButton")));
		return lst;
	}
	public  static List<WebElement> nextLable(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("nextLable")));
		return lst;
	}
	public  static List<WebElement> prevLable(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("prevLable")));
		return lst;
	}
	public  static List<WebElement> prevButton(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("prevButton")));
		return lst;
	}
	public  static WebElement nextLink(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("nextLink")));
		return element;
	}
	public  static WebElement ageHeight(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("ageHeight")));
		return element;
	}
	public  static List<WebElement> yes(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("yes")));
		return lst;
	}
	public  static WebElement CasteOrDivision(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("CasteOrDivision")));
		return element;
	}
	
	public  static WebElement paginationLink2(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("paginationLink2")));
		return element;
	}
	public  static WebElement sentInterest_Popup(){
		WebElement element=driver.findElement(By.id(properties.getProperty("sentInterest_Popup")));
		return element;
	}
	public  static WebElement confirmMsg_InPopup(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("confirmMsg_InPopup")));
		return element;
	}
	public  static List<WebElement> requestFor(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("requestFor")));
		return lst;
	}
	public  static List<WebElement> viewFullProfile(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("viewFullProfile")));
		return lst;
	}
	public  static List<WebElement> reqPhoto(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("reqPhoto")));
		return lst;
	}
	public  static WebElement reqphotoConfMsg(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("reqphotoConfMsg")));
		return element;
	}
	public  static WebElement reqphotoPopupClose(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("reqphotoPopupClose")));
		return element;
	}
	public  static WebElement reqHoroscope(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("reqHoroscope")));
		return element;
	}
	public  static WebElement reqHoroscopeConfMsg(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("reqHoroscopeConfMsg")));
		return element;
	}
	public  static WebElement reqHoroscopePopupClose(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("reqHoroscopePopupClose")));
		return element;
	}
	public  static WebElement requestConfMsg(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("requestConfMsg")));
		return element;
	}
	public  static WebElement requestConfMsgClose(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("requestConfMsgClose")));
		return element;
	}
	//************View profile****************
	
	public  static List<WebElement> CasteOrDivisionList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("CasteOrDivision")));
		return lst;
	}
	public  static List<WebElement> ageHeightList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("ageHeight")));
		return lst;
	}
	public  static List<WebElement> subCasteList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("subCasteList")));
		return lst;
	}
	public  static List<WebElement> educationList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("educationList")));
		return lst;
	}
	public  static List<WebElement> occupationList(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("occupationList")));
		return lst;
	}
	
	
	
	
	//********************Add Photo*********************
	public  static WebElement profileIcon(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("profileIcon")));
		return element;
	}

	public  static WebElement profileIconPhoto(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("profileIconPhoto")));
		return element;
	}
	public  static List<WebElement> AddPhotoList(){
		List<WebElement> list=driver.findElements(By.xpath(properties.getProperty("AddPhotoList")));
		return list;
	}
	
	public  static WebElement addPhotoNow(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("addPhotoNow")));
		return element;
	}
	
	public  static WebElement addPhotoNowSuccessMsg(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("addPhotoNowSuccessMsg")));
		return element;
	}
	
	public  static WebElement image(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("image")));
		return element;
	}
	public  static WebElement editPhoto(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("editPhoto")));
		return element;
	}
	
	public  static WebElement deletePhoto(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("deletePhoto")));
		return element;
	}
	public  static WebElement deletePhotoConf_Yes(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("deletePhotoConf_Yes")));
		return element;
	}
	public  static WebElement deletePhotoConf_Msg(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("deletePhotoConf_Msg")));
		return element;
	}
	public  static WebElement deletePhotoConf_Close(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("deletePhotoConf_Close")));
		return element;
	}
	public static void loadProperties()throws Throwable{
		properties=new Properties();
    	FileInputStream fis = new FileInputStream(new File(".\\ObjectRepository\\Home.properties"));
    	properties.load(fis);
	}
}
	

