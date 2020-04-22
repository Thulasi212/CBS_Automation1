package Base;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverWaitLib extends BaseTest{
	public static Properties properties;
	public static void waitPageToLoad(WebDriver driver)
	  {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	 public static void waitElementToPresent(WebElement element,WebDriver driver)
	 {
	    WebDriverWait wait=new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOf(element));
		
	  }
}

