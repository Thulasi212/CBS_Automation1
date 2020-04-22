package ExtraActivites;
import org.openqa.selenium.WebDriver;
/**
 * @author Thulasi
 */
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
public class Browser 
{   public static String browser="firefox";
	public static WebDriver driver;
	public static WebDriver getBrowser()
	{   if(browser.equals("firefox")) {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("dom.webnotifications.enabled", false);
		    driver= new FirefoxDriver(profile);
		   // driver=new FirefoxDriver();
		} else if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","./Resources/chromedriver.exe");
		    driver= new ChromeDriver();
		}else{
			System.setProperty("webdriver.ie.driver","./Resources/IEDriverServer.exe");
		}
		return driver;
	}
	
	
	

}
