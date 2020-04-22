package com.testscripts;



import java.awt.Robot;
import java.io.File;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseTest;



public class Bug_Report extends BaseTest{
	
	 String Status;
	 String path ="D:\\AutoMation\\BugZilla\\Data\\";
	public static WebDriver driver;
	public static String No_Bug;

    String driverExecutablePath = 
      ".//Driver//chromedriver.exe";
	
	@BeforeSuite
	public void setUp() {
	    System.setProperty("webdriver.chrome.driver",".//Driver//chromedriver.exe");
	    		         ChromeOptions lChromeOptions = new ChromeOptions();
	    		         HashMap<String, Object> lChromePrefs = new HashMap<String,Object>();
	    		lChromePrefs.put("profile.default_content_settings.popups", 0);
	    		         lChromePrefs.put("download.default_directory", path);
	    		         lChromePrefs.put("browser.set_download_behavior", "{ behavior:'allow' , downloadPath: '"+path+"'}");
	    		        //     lChromeOptions.addArguments("--headless");
	    		        //     lChromeOptions.addArguments("--disable-gpu");
	    		             lChromeOptions.setExperimentalOption("prefs", lChromePrefs);
	    		                driver = new ChromeDriver(lChromeOptions);
	    		                   

	}

	@Test(retryAnalyzer=com.testscripts.RetryFailedTestCases.class)
     public static void maiolcode() throws Throwable  {
		
		
	//	Actions acc= new Actions(driver);
	    Robot bot = new Robot();
	  //  WebDriverWait wait = new WebDriverWait(driver, 30);		
		
		/*
		 * String driverExecutablePath = ".//Driver//chromedriver.exe";
		 * System.setProperty("webdriver.chrome.driver", driverExecutablePath); driver =
		 * new ChromeDriver();
		 */

         driver.get("http://192.168.1.56/bugzilla/enter_bug.cgi");
         driver.manage().window().maximize();
          Thread.sleep(3000);

          // Login
      
 /* driver.findElement(By.id("Bugzilla_login")).sendKeys("amudhan.nagarajan@matrimony.com");
          Thread.sleep(3000);

  driver.findElement(By.id("Bugzilla_password")).sendKeys("login123");
          Thread.sleep(3000);

          driver.findElement(By.id("log_in")).click();
          Thread.sleep(3000); */

     try {

          Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"header\"]/ul/li[4]/a")).click();
         Thread.sleep(3000);
         
driver.findElement(By.xpath("//*[@id=\"tab_advanced\"]/a")).click();
         Thread.sleep(2000);
         
driver.findElement(By.xpath("//*[@id='v1_classification']")).click();
         Thread.sleep(2000);
       
driver.findElement(By.xpath("//*[@id='v46_product']")).click(); 
//*[@id="v1_classification"]
           bot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
           
driver.findElement(By.xpath("//*[@id='v54_product']")).click();

driver.findElement(By.xpath("//*[@id='v58_product']")).click();

driver.findElement(By.xpath("//*[@id='v48_product']")).click();

driver.findElement(By.xpath("//*[@id='v5_product']")).click();

 driver.findElement(By.xpath("//*[@id='v41_product']")).click();
  

driver.findElement(By.xpath("//*[@id='v57_product']")).click();

           bot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);

driver.findElement(By.xpath("//*[@id='v1_resolution']")).click();
           Thread.sleep(3000);

//js.executeScript("window.scroll(), 200");
driver.findElement(By.xpath("//*[@id=\"history_filter\"]/a")).click();
           Thread.sleep(2000);
           
driver.findElement(By.xpath("//*[@id=\"chfield\"]/option[1]")).click();
           Thread.sleep(2000);
           
driver.findElement(By.xpath("//*[@id=\"button_calendar_chfieldfrom\"]")).click();
           Thread.sleep(2000);
           
           driver.findElement(By.xpath("(//td[contains(@class, 'today selectable')])[1]")).click();
           Thread.sleep(2000);
           
driver.findElement(By.xpath("//*[@id=\"Search\"]")).click();
           currentUrl = driver.getCurrentUrl();
           System.out.println(currentUrl);


           /////

 

try {
         Thread.sleep(3000);
          No_Bug = driver.findElement(By.xpath("//span[contains(text(),'Zarro Boogs found.')]")).getText();
          System.out.println(No_Bug);
}  catch (Exception e) {
	
}     
  try {
Thread.sleep(3000);
if (driver.findElement(By.xpath("//a[contains(text(),'CSV')]")).isDisplayed()) {

	Thread.sleep(3000);
	WebElement Csv_download = driver.findElement(By.xpath("//a[contains(text(),'CSV')]"));
	Thread.sleep(3000);
	Csv_download.click();
	  // Store the current window handle
    String mainWindow = driver.getWindowHandle();

    // open a new tab
    Thread.sleep(3000);
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("window.open()");

   // switch to new tab
  // Switch to new window opened
    Thread.sleep(3000);
    for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
    }
   // navigate to chrome downloads
    driver.get("chrome://downloads");

    JavascriptExecutor js1 = (JavascriptExecutor)driver;
    // wait until the file is downloaded
    Long percentage = (long) 0;
    /*while ( percentage!= 100) {
        try {
            percentage = (Long) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('#progress').value");
            //System.out.println(percentage);
        }catch (Exception e) {
          // Nothing to do just wait
      }
        Thread.sleep(1000);
    }*/ Thread.sleep(10000);
    
    TakesScreenshot screenshot = (TakesScreenshot) driver;
    File src = screenshot.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(src, new File(".//ScreenShot//" +"SAmple1"+ ".png"));
    System.out.println("Successfully captured a screenshot");
    
    
   // get the latest downloaded file name
   fileName_1 = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");
   // get the latest downloaded file url
    String sourceURL = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').href");
    // file downloaded location
    String donwloadedAt = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div.is-active.focus-row-active #file-icon-wrapper img').src");
    System.out.println("Download deatils");
    System.out.println("File Name :-" + fileName_1);
   System.out.println("Donwloaded path :- " + donwloadedAt);
    System.out.println("Downloaded from url :- " + sourceURL);
   // print the details
    System.out.println(fileName_1);
    System.out.println(sourceURL);
   // close the downloads tab2
    driver.close();
   // switch back to main window
    driver.switchTo().window(mainWindow);
   // return fileName;
	
    
    Thread.sleep(3000);
  BaseTest.reportflush4();
	
	
	
} 
  }
  catch (Exception e) {
	
}
  
  ///////////////////////////
  /////////////////////////////
  
  
try {
	Thread.sleep(3000);
	if (driver.findElement(By.xpath("//span[contains(text(),'Zarro Boogs found.')]")).isDisplayed()) {
		
	
	System.out.println(" No Bug Posted for the Day ");
	Thread.sleep(3000);
	BaseTest.reportflush5();
	}
} catch (Exception e) {
	
}	
		
    
     }catch (Exception e) {
    	 Thread.sleep(3000);
		BaseTest.reportflush_load();
	}
     


	
}
	
}


