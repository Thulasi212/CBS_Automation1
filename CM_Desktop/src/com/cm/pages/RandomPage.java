package com.cm.pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cm.Utility.BaseTest;

public class RandomPage extends BaseTest {
	public static Properties properties;
	public static WebElement dailyMatchesLink(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("dailyMatchesLink")));
		return ele;
	}
	public static void dailyMatchesTest(){
		dailyMatchesLink().click();
		
	}
	public static void loadProperties() throws Throwable{
		properties=new Properties();
		FileInputStream fis=new FileInputStream(new File(".\\ObjectRepository\\Random.properties"));
		properties.load(fis);
	}


}
