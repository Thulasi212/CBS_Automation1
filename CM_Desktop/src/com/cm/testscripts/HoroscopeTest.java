package com.cm.testscripts;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.cm.Utility.BaseTest;
import com.cm.Utility.ExcelData;
import com.cm.Utility.WebdriverWaitLib;
import com.cm.pages.EppPage;
import com.cm.pages.HomePage;
import com.cm.pages.LoginPage2;
import com.cm.pages.PaymentPage;

public class HoroscopeTest  extends BaseTest{
	public ExcelData eData;
	public HoroscopeTest() throws Throwable{
		LoginPage2.loadProperties();
		PaymentPage.loadProperties();
		EppPage.loadProperties();
		HomePage.loadProperties();
		eData=new ExcelData();
	}
	@Test
	public void generateHoroscopeTest() throws Throwable{
		test=extent.createTest("Generate Horoscope Test");
		test.info("Browser Launching...............");
		//Fetching the data from excel
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("CommonData",2,0);
    	String userName=eData.getExcelData("CommonData",2,1);
    	String password=eData.getExcelData("CommonData",2,2);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        WebdriverWaitLib.waitPageToLoad();
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	LoginPage2.passwordEdit1().sendKeys(password);
    	LoginPage2.loginButton1().click();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	test.pass("Profile A Login successfully Completed with username: "+userName+" & password: "+password);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean status=false;
		int i;
		for(i=0;i<=15;i++){
			try{ 
				Thread.sleep(1000);
				status=LoginPage2.generateHoroBtn().isDisplayed();
				break;
			}catch(Exception e){e.getMessage();}
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		System.out.println("No of cycles: "+i);
			if(status){
				test.pass("Generating the Horoscope..........");
				test.pass("Entering the Values......");
				WebdriverWaitLib.waitElementToPresent(LoginPage2.hours_TOB_Horo());
				new Select(LoginPage2.hours_TOB_Horo()).selectByIndex(2);
				new Select(LoginPage2.mins_TOB_Horo()).selectByIndex(2);
				new Select(LoginPage2.meridiem_TOB_Horo()).selectByIndex(1);
				String countryOfBirth=eData.getExcelData("CommonData", 2, 3);
				new Select((LoginPage2.countryOfBirth())).selectByVisibleText(countryOfBirth);
				String sob=eData.getExcelData("CommonData", 2, 4);
				new Select(LoginPage2.stateOfBirth()).selectByVisibleText(sob);
				String cob=eData.getExcelData("CommonData", 2, 5);
				new Select(LoginPage2.cityOfBirth()).selectByVisibleText(cob);
				String cs=eData.getExcelData("CommonData", 2, 6);
				new Select(LoginPage2.chartStyle()).selectByVisibleText(cs);
				test.pass("Values Entered successfully");
				LoginPage2.generateHoroBtn().click();
				test.pass("clicked on Generate Horoscope Button");
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				Set<String> set=driver.getWindowHandles();      
				Iterator<String> it=set.iterator();
				String parentWinId=it.next();
				String childWinId=it.next();
				driver.switchTo().window(childWinId);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				test.pass("Horoscope generated successfully");
				driver.switchTo().window(parentWinId);
				try{
					WebdriverWaitLib.waitElementToPresent(LoginPage2.upgrade_Popup());
					LoginPage2.upgrade_Popup().click();
					test.pass("Upgrade Popup is closed successfully");
				}catch(Exception e){e.getMessage();}
				try{
					Thread.sleep(5000);
					LoginPage2.upgrade_Popup1().click();
					test.pass("Profile Highlighter Popup is closed successfully");	
				}catch(Exception e){e.getMessage();}
				test.pass("Deleting the Horoscope....");
				Actions act=new Actions(driver);
				act.moveToElement(EppPage.logMenu()).perform();
				EppPage.editProfile().click();
				test.pass("Clicked on Edit profile");
				EppPage.horoscope_AddLeftBtn().click();
				test.pass("clicked on Horoscope Add button");
				EppPage.horoDeleteBtn().click();
				test.pass("clicked on Horoscope Delete button");
				Alert alt=driver.switchTo().alert();
				alt.accept();
				test.pass("Accepted Delete confirmation ");
				test.pass("Horoscope is successfully Deleted");
			}
			else{
				test.pass("Popup is not Available to check Generate Horoscope scenorio");
			}
		
		driver.quit();
		}
	/*@Test
	public void uploadHoroscopeTest() throws Throwable{
		test=extent.createTest("Upload horoscope Test");
		test.info("Browser Launching...............");
		//Fetching the data from excel
		ExcelData eData=new ExcelData();
    	String baseUrl=eData.getExcelData("CommonData",2,0);
    	String userName=eData.getExcelData("CommonData",2,1);
    	String password=eData.getExcelData("CommonData",2,2);
    	driver.get(baseUrl);
    	driver.manage().window().maximize();
        WebdriverWaitLib.waitPageToLoad();
    	test.pass("Browser launched Successfully with Baseurl: "+baseUrl);
    	test.info("Login to the Application................");
    	LoginPage2.userNameEdit1().sendKeys(userName);
    	LoginPage2.passwordEdit1().sendKeys(password);
    	LoginPage2.loginButton1().click();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	test.pass("Profile A Login successfully Completed with username: "+userName+" & password: "+password);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean status=false;
		int i;
		for(i=0;i<=15;i++){
			try{ 
				Thread.sleep(1000);
				status=LoginPage2.generateHoroBtn().isDisplayed();
				break;
			}catch(Exception e){e.getMessage();}
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		System.out.println("No of cycles: "+i);
			if(status){
				LoginPage2.browse().click();
				Thread.sleep(2000);
				test.pass("Triggering Autoit code for Horoscope Uploading.........");
			    Runtime.getRuntime().exec(".//Resources//Autoit//FileUploadHoro.exe");
				Thread.sleep(3000);
				LoginPage2.uploadBtn().click();
				Thread.sleep(2000);
				test.pass("horoscope uploaded successfully");
			}else{
				test.pass("Popup is not Available to check upload Horoscope scenorio ");
			}
		driver.close();
		}*/

}
