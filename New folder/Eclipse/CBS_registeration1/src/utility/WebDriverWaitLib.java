package utility;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitLib extends BaseTest{
	public static Properties properties;
	public static void waitPageToLoad()
	  {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	 public static void waitElementToPresent(WebElement element)
	 {
	    WebDriverWait wait=new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOf(element));
		
	  }
}
