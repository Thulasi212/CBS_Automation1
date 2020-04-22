package com.cm.pages;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.cm.Utility.BaseTest;
import com.cm.Utility.ExcelData;
import com.cm.Utility.WebdriverWaitLib;
/**
 * 
 * @author Thulasi
 *
 */
public class LoginPage2 extends  BaseTest{
	public static Properties properties;
	//************Login Page**********
	public  static WebElement userNameEdit1(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("userNameEdit1")));
		return element;
	}
	public  static WebElement passwordEdit1(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("passwordEdit1")));
		return element;
	}
	public  static WebElement loginButton1(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("loginButton1")));
		return element;
	}
	public  static WebElement userNameEdit2(){
		WebElement element=driver.findElement(By.id(properties.getProperty("userNameEdit2")));
		return element;
	}
	public  static WebElement passwordEdit2(){
		WebElement element=driver.findElement(By.id(properties.getProperty("passwordEdit2")));
		return element;
	}
	public  static WebElement loginButton2(){
		WebElement element=driver.findElement(By.id(properties.getProperty("loginButton2")));
		return element;
	}
	public  static List<WebElement> errMsg(){
		List<WebElement> lst=driver.findElements(By.xpath(properties.getProperty("errMsg")));
		return lst;
	}
	public  static WebElement individualUserName(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("individualUserName")));
		return element;
	}
	public  static WebElement individualpassword(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("individualpassword")));
		return element;
	}
	public  static WebElement individualLoginBtn(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("individualLoginBtn")));
		return element;
	}
	//***************InterMediate Page****************
	public  static WebElement skipToMyMatrimony_Popup(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipToMyMatrimony_Popup")));
		return element;
	}
	public  static WebElement skipToDailyMatches_Popup(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipToDailyMatches_Popup")));
		return element;
	}
	public  static WebElement skipToDailymatches_AppStoreLink(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipToDailymatches_AppStoreLink")));
		return element;
	}
	public  static WebElement skipToDailyMatches_GooglePlayLink(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipToDailyMatches_GooglePlayLink")));
		return element;
	}
	public  static WebElement skipToDailyMatches_mobCode(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipToDailyMatches_mobCode")));
		return element;
	}
	public  static WebElement skipToDailyMatches_mobNo(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipToDailyMatches_mobNo")));
		return element;
	}
	public  static WebElement skipToDailyMatches_getLink(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipToDailyMatches_getLink")));
		return element;
	}
	public  static WebElement skipToDailyMatches_getLinkPOpMsg(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipToDailyMatches_getLinkPOpMsg")));
		return element;
	}
	public  static WebElement skipToDailyMatches_getLinkPopClose(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipToDailyMatches_getLinkPopClose")));
		return element;
	}
	public  static WebElement skipToDailyMatches_GooglePlayLinkHeaderText(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipToDailyMatches_GooglePlayLinkHeaderText")));
		return element;
	}
	public  static WebElement skipToDMatches_GoPremiumBtn(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipToDMatches_GoPremiumBtn")));
		return element;
	}
	public  static WebElement skipToMyMatrimony_proceed(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipToMyMatrimony_proceed")));
		return element;
	}
	public  static WebElement skipTodailyMatches_takeControl(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipTodailyMatches_takeControl")));
		return element;
	}
	public  static WebElement skipDailyMatches_viewAll(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipToMyMatrimony_viewAll")));
		return element;
	}
	public  static WebElement skipToMyMatrimony_listCount(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipToMyMatrimony_listCount")));
		return element;
	}
	public  static WebElement skipToMyMatrimony_senderId(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipToMyMatrimony_senderId")));
		return element;
	}
	public  static WebElement skipToMyMatrimony_declineBtn(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipToMyMatrimony_declineBtn")));
		return element;
	}
	public  static WebElement skipToMyMatrimony_declinepopMsg(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipToMyMatrimony_declinepopMsg")));
		return element;
	}
	public  static WebElement skipToMyMatrimony_declinepopClose(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("skipToMyMatrimony_declinepopClose")));
		return element;
	}
	public  static WebElement getItNow(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("getItNow")));
		return element;
	}
	public  static WebElement getItNow_AvailNow(){
		WebElement ele=driver.findElement(By.xpath(properties.getProperty("getItNow_AvailNow")));
		return ele;
	}
	public  static WebElement strategic_Popup(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("strategic_Popup")));
		return element;
	}
	public  static WebElement upgrade_Popup(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("upgrade_Popup")));
		return element;
	}
	public  static WebElement offer_UpgradeBtn(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("offer_UpgradeBtn")));
		return element;
	}
	public  static WebElement upgrade_Popup1(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("upgrade_Popup1")));
		return element;
	}
	public  static WebElement addPhoto(){
		WebElement element=driver.findElement(By.linkText(properties.getProperty("addPhoto")));
		return element;
	}
	public  static WebElement addPhotoIntBtn(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("addPhotoIntBtn")));
		return element;
	}
	public  static WebElement addPhotoAvatarBtn(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("addPhotoAvatarBtn")));
		return element;
	}
	public  static WebElement areYousure_Popup(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("areYousure_Popup")));
		return element;
	}
	public  static WebElement reason3_Popup(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("reason3_Popup")));
		return element;
	}
	public  static WebElement submit_Popup(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("submit_Popup")));
		return element;
	}
	public  static WebElement hours_TOB_Horo(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("hours_TOB_Horo")));
		return element;
	}
	public  static WebElement mins_TOB_Horo(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("mins_TOB_Horo")));
		return element;
	}
	public  static WebElement meridiem_TOB_Horo(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("meridiem_TOB_Horo")));
		return element;
	}
	public  static WebElement countryOfBirth(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("countryOfBirth")));
		return element;
	}
	public  static WebElement stateOfBirth(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("stateOfBirth")));
		return element;
	}
	public  static WebElement cityOfBirth(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("cityOfBirth")));
		return element;
	}
	public  static WebElement chartStyle(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("chartStyle")));
		return element;
	}
	public  static WebElement generateHoroBtn(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("generateHoroBtn")));
		return element;
	}
	public  static WebElement uploadBtn(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("uploadBtn")));
		return element;
	}
	public  static WebElement browse(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("browse")));
		return element;
	}
	//**************Logout Page******************
	public  static WebElement logoutMenu(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("logoutMenu")));
		return element;
	}
	public  static WebElement logoutButton(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("logoutButton")));
		return element;
	}
	public  static WebElement logoutCompletly(){
		WebElement element=driver.findElement(By.xpath(properties.getProperty("logoutCompletly")));
		return element;
	}
	public static void loadProperties()throws Throwable{
		properties=new Properties();
    	FileInputStream fis = new FileInputStream(new File(".\\ObjectRepository\\Generic.properties"));
    	properties.load(fis);
	}
	 public static void login() throws Throwable {
	        loadProperties();
			test.info("Browser Launching...............");
			ExcelData eData=new ExcelData();
	    //	int rowNum=eData.getExcelRandomRowNum("LoginTestData");
	    	String url=eData.getExcelData("LoginTestData",0,0);
	    	String userName=eData.getExcelData("LoginTestData",0,1);
	    	String password=eData.getExcelData("LoginTestData",0,2);
	    	driver.get(url);
	    	driver.manage().window().maximize();
            WebdriverWaitLib.waitPageToLoad();
	    	test.pass("Browser launched Successfully with Baseurl: "+url);
	    	test.info("Login to the Application................");
	    	userNameEdit1().sendKeys(userName);
		    passwordEdit1().sendKeys(password);
		    loginButton1().click();
	       /*individualUserName().sendKeys(userName);
		    individualpassword().sendKeys(password);
		    individualLoginBtn().click();*/
	    	test.pass("Login successfully Completed with username: "+userName+" & password: "+password);
		}
		public static void login(String url,String userName,String password) throws Throwable{
			loadProperties();
			test.info("Browser Launching...............");
	    	driver.get(url);
	    	driver.manage().window().maximize();
	    	WebdriverWaitLib.waitPageToLoad();
	    	test.pass("Browser launched Successfully with Baseurl: "+url);
	    	test.info("Login to the Application................");
	    	userNameEdit1().sendKeys(userName);
		    passwordEdit1().sendKeys(password);
		    loginButton1().click();
	       /*individualUserName().sendKeys(userName);
		    individualpassword().sendKeys(password);
		    individualLoginBtn().click();*/
	    	test.pass("Login successfully Completed with username: "+userName+" & password: *******");
		}
		
		public static void individualLogin(String url,String userName,String password) throws Throwable{
			loadProperties();
			test.info("Browser Launching...............");
	    	driver.get(url);
	    	driver.manage().window().maximize();
	    	WebdriverWaitLib.waitPageToLoad();
	    	test.pass("Browser launched Successfully with Baseurl: "+url);
	    	test.info("Login to the Application................");
	    	
	    	test.pass("Login successfully Completed with username: "+userName+" & password: *******");
		}
		public static void intermediate_Popups() throws Throwable{
			loadProperties();
			test.pass("Closing Intermediate Pages..............................");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			boolean status=true;
			try{
				skipToDailyMatches_Popup().click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				status=false;
				test.pass("SkipTodailyMatches Popup is closed successfully");
			}catch(Exception e){e.getMessage();}
			if(status){
				try{
					skipToMyMatrimony_Popup().click();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					test.pass("SkipMyMatches Popup is closed successfully");	
					try{
						strategic_Popup().click();
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						test.pass("Strategic Popup is closed");
					}catch(Exception e){e.getMessage();}
				}catch(Exception e){e.getMessage();}
			}
			try{
				addPhoto().click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				areYousure_Popup().click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				try{
					reason3_Popup().click();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					submit_Popup().click();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			        }catch(Exception e){e.getMessage();}
	    	}catch(Exception e){e.getMessage();}
			boolean status1=true;
			try{
				upgrade_Popup().click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				status1=false;
				test.pass("Upgrade Popup is closed successfully");
			}catch(Exception e){e.getMessage();}
			if(status1){
				try{
					Thread.sleep(5000);
					upgrade_Popup1().click();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					test.pass("Profile Highlighter Popup is closed successfully");	
				}catch(Exception e){e.getMessage();}
			}
		}
		public static void intermediate_Popups1() throws Throwable{
			loadProperties();
			test.pass("Closing Intermediate Pages..............................");
			try{
				WebdriverWaitLib.waitElementToPresent(skipToDailyMatches_Popup());
				skipToDailyMatches_Popup().click();
				test.pass("SkipTodailyMatches Popup is closed successfully");
			}catch(Exception e){e.getMessage();}
			try{
				skipToMyMatrimony_Popup().click();
				test.pass("SkipMyMatches Popup is closed successfully");	
				try{
					WebdriverWaitLib.waitElementToPresent(strategic_Popup());
					strategic_Popup().click();
					test.pass("Strategic Popup is closed");
				}catch(Exception e){e.getMessage();}
			}catch(Exception e){e.getMessage();}
			try{
				Thread.sleep(5000);
				addPhoto().click();
				WebdriverWaitLib.waitElementToPresent(areYousure_Popup());
				areYousure_Popup().click();
				try{
					WebdriverWaitLib.waitElementToPresent(reason3_Popup());
					reason3_Popup().click();
					WebdriverWaitLib.waitElementToPresent(submit_Popup());
					submit_Popup().click();
			        }catch(Exception e){e.getMessage();}
	    	}catch(Exception e){e.getMessage();}
			try{
				WebdriverWaitLib.waitElementToPresent(upgrade_Popup());
				upgrade_Popup().click();
				test.pass("Upgrade Popup is closed successfully");
			}catch(Exception e){e.getMessage();}
			try{
				Thread.sleep(5000);
				upgrade_Popup1().click();
				test.pass("Profile Highlighter Popup is closed successfully");	
			}catch(Exception e){e.getMessage();}
			try{
				Thread.sleep(5000);
				strategic_Popup().click();
				test.pass("Strategic Popup is closed");
			}catch(Exception e){e.getMessage();}
		}
			
	public static void logout() throws Throwable{
		loadProperties();
		test.pass("Logging out from the Application..........");
		Actions act=new Actions(driver);
		try{
		act.moveToElement(logoutMenu()).perform();
		test.pass("moved to Logout menu");
		Thread.sleep(5000);
        logoutButton().click();
        test.pass("clicked on Logout Button");
        try{
        	Thread.sleep(2000);
        	logoutCompletly().click();
        	test.pass("clicked on Logout Completly.");
        }catch(Exception e){e.getMessage();}
		test.pass("Applicatipon Logout Successfully");
		}catch(Exception e){e.getMessage();}
	}
}







