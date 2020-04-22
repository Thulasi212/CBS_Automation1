package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionDrivers {
	
	public static boolean click(WebElement locator){
		try{
			locator.click();
			return true;
		}
		catch(Exception e){
			e.getMessage();
			return false;
		}		
	}
	
	public static boolean type(WebElement locator, String value){
		try{
			locator.clear();
			locator.sendKeys(value);
			return true;
		}
		catch(Exception e){
			e.getMessage();
			return false;
		}
	}
	public static boolean selectElementByVisibleText(WebElement locator, String value){
		try{
			Select select = new Select(locator);
			select.selectByVisibleText(value);
			return true;
		}
		catch(Exception e){
			e.getMessage();
			return false;
		}	
		
	}
	public static boolean selectElementByIndex(WebElement locator, int value){
		try{
			Select select = new Select(locator);
			select.selectByIndex(value);
			return true;
		}
		catch(Exception e){
			e.getMessage();
			return false;
		}	
		
	}
		}
