package TestScripts;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.bcel.generic.IF_ACMPEQ;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class wcsm {
	
	
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
            mobileEmulation.put("deviceName", "Pixel 2");

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", 
mobileEmulation);
            chromeOptions.addArguments("--disable-notifications");
            driver = new ChromeDriver(chromeOptions);
        }





    @Test
    public void loginTest() throws Throwable {
    	int ppfr,wcsmf,ppfrm,wcsmfrm;
    	
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
    	
    	driver.findElement(By.xpath("//*[@id=\"mainsidemenu\"]/div/ion-content/div[2]/ion-grid/ion-row/ion-col/ion-list[7]/ion-item/div[1]/div/ion-label")).click();
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("/html/body/ion-app/ion-modal/div/settingpopup/ion-content/div[2]/ion-grid/ion-row/ion-col/ion-list/ion-item[5]/div[1]/div/ion-label")).click();
    	
	
	ppfr=20;wcsmf=30;ppfrm=18;wcsmfrm=20
			;
/*	if (ppfr<wcsmf) {
		if (ppfrm==wcsmfrm) {
			System.out.println("pass");
			
		}else {
		System.out.println("codition satisfied value not updated");
		}
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
    }
}
