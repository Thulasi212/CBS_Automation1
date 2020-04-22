package com.cm.pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.cm.Utility.BaseTest;


public class PaymentPage extends BaseTest {
	public static Properties properties;
	public  static WebElement gold_3months(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("gold_3months")));
		return element;
	}
	public  static WebElement gold_6months(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("gold_6months")));
		return element;
	}
	public  static WebElement diamond_3months(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("diamond_3months")));
		return element;
	}
	public  static WebElement diamond_6months(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("diamond_6months")));
		return element;
	}
	public  static WebElement platinum_3months(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("platinum_3months")));
		return element;
	}

	public  static WebElement platinum_6months(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("platinum_6months")));
		return element;
	}
	public  static WebElement till_u_marry(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("till_u_marry")));
		return element;
	}
	public  static WebElement profHighlighter(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("profHighlighter")));
		return element;
	}
	public static WebElement topPlacement(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("topPlacement")));
		return element;
	}
	public static WebElement astroMatch(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("astroMatch")));
		return element;
	}
	public static WebElement astromatchSpecial(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("astromatchSpecial")));
		return element;
	}
	public static WebElement creditCardNoEdit(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("creditCardNoEdit")));
		return element;
	}
	public static WebElement cardExpiryMonth(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("cardExpiryMonth")));
		return element;
	}
	public static WebElement cardExpiryYear(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("cardExpiryYear")));
		return element;
	}
	public static WebElement ccvEdit(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("ccvEdit")));
		return element;
	}
	public static WebElement splTotalAmount(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("splTotalAmount")));
		return element;
	}
	public static WebElement paySecure(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("paySecure")));
		return element;
	}
	public static WebElement paymentFailureMsg(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("paymentFailureMsg")));
		return element;
	}
	public static WebElement goBackLink(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("goBackLink")));
		return element;
	}
	public static WebElement summaryAmount(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("summaryAmount")));
		return element;
	}
	public static WebElement headerUpgradeBtn(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("headerUpgradeBtn")));
		return element;
	}
	public static WebElement chat_PayOnlineLink(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("chat_PayOnlineLink")));
		return element;
	}
	public static WebElement updradeLinkFromMenu(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("updradeLinkFromMenu")));
		return element;
	}
	public static WebElement cardHolderName(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("cardHolderName")));
		return element;
	}
	
	
	public static void loadProperties()throws Throwable{
		properties=new Properties();
    	FileInputStream fis = new FileInputStream(new File(".\\ObjectRepository\\Payment.properties"));
    	properties.load(fis);
	}

}







