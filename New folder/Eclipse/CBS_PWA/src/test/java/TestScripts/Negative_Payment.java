package TestScripts;

import java.awt.Robot;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

public class Negative_Payment {
	
	public static WebDriver driver;
    String driverExecutablePath = 
"C:\\Users\\CBS\\eclipse-workspace\\CBS_PWA\\driver\\chromedriver.exe";

      ExtentReports report;
      ExtentTest logger;
        @BeforeMethod
        public void setUp1() throws MalformedURLException {
            System.setProperty("webdriver.chrome.driver", 
driverExecutablePath);
            Map<String, String> mobileEmulation = new HashMap<String, String>();
            mobileEmulation.put("deviceName", "Pixel 2 XL");

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", 
mobileEmulation);
            chromeOptions.addArguments("--disable-notifications");
            driver = new ChromeDriver(chromeOptions);
        }





    @Test
    public void loginTest() throws Throwable {
    	
    	Robot r  = new Robot();
    	JavaScriptExecutor js = (JavaScriptExecutor)driver;
    	
    	driver.get("https://m.communitymatrimony.com");
    	driver.manage().window().maximize();
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("//*[@id=\"login-btn\"]/a")).click();
    	Thread.sleep(2000);
    	
    	driver.findElement(By.id("idEmail")).sendKeys("EZH710533");
    	Thread.sleep(2000);
    	
    	driver.findElement(By.id("password1")).sendKeys("cbstest");
    	Thread.sleep(2000);
    	
    	driver.findElement(By.id("login-button")).click();
    	Thread.sleep(10000);
    	
    	driver.findElement(By.cssSelector("body > ion-app > ng-component > page-dashboard > ion-header > header > ion-navbar > div.toolbar-content.toolbar-content-md > ion-grid > ion-row > ion-col:nth-child(5)")).click();
    	Thread.sleep(2000);
    	try {
    	driver.findElement(By.cssSelector("#mainsidemenu > div > ion-content > div.scroll-content > ion-grid > ion-row > ion-col > ion-list:nth-child(6) > ion-item > div.item-inner > div > ion-label > span > span:nth-child(2)")).click();
    	Thread.sleep(5000);
    	} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	r.keyPress(java.awt.event.KeyEvent.VK_F12);
    	r.keyRelease(java.awt.event.KeyEvent.VK_F12);
    	
    	
    	
    	Thread.sleep(2000);
    	driver.findElement(By.cssSelector("body > div > div.gmg_chat_head > div")).click();
    	Thread.sleep(3000);
    	
    	r.keyPress(java.awt.event.KeyEvent.VK_F12);
    	r.keyRelease(java.awt.event.KeyEvent.VK_F12);
    	
    	try {
        	driver.findElement(By.cssSelector("#mainsidemenu > div > ion-content > div.scroll-content > ion-grid > ion-row > ion-col > ion-list:nth-child(6) > ion-item > div.item-inner > div > ion-label > span > span:nth-child(2)")).click();
        	Thread.sleep(5000);
        	} catch (Exception e) {
    			// TODO: handle exception
    		}
    	
    	driver.findElement(By.id("newuipaynowurl")).click();
    	Thread.sleep(3000);
    	
    	driver.findElement(By.id("credit-debit-link1")).click();
    	Thread.sleep(3000);
    	
    	driver.findElement(By.id("vpc_CardNum")).sendKeys("4111111111111111");
    	Thread.sleep(1000);
    	
    	try {
        	driver.findElement(By.cssSelector("#mainsidemenu > div > ion-content > div.scroll-content > ion-grid > ion-row > ion-col > ion-list:nth-child(6) > ion-item > div.item-inner > div > ion-label > span > span:nth-child(2)")).click();
        	Thread.sleep(5000);
        	} catch (Exception e) {
    			// TODO: handle exception
    		}
    	
    	driver.findElement(By.id("cardExpiryMonthDisplay")).sendKeys("10");
    	Thread.sleep(1000);
    	
    	driver.findElement(By.id("cardExpiryYear")).sendKeys("2020");
    	Thread.sleep(1000);
    	
    	try {
        	driver.findElement(By.cssSelector("#mainsidemenu > div > ion-content > div.scroll-content > ion-grid > ion-row > ion-col > ion-list:nth-child(6) > ion-item > div.item-inner > div > ion-label > span > span:nth-child(2)")).click();
        	Thread.sleep(5000);
        	} catch (Exception e) {
    			// TODO: handle exception
    		}
    	
    	driver.findElement(By.id("vpc_CardSecurityCode")).sendKeys("012");
    	Thread.sleep(1000); 
    	
    	driver.findElement(By.id("debit-card-submit")).click();
    	Thread.sleep(1000);

}
}
